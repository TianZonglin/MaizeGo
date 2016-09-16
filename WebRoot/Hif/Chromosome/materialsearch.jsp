<%@ page contentType="text/html;charset=gbk"  import="java.util.*"  language="java" pageEncoding="UTF-8"%>
<%@ page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page import="org.db.phenotypes_294_rils_441_crosses.*"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.util.Map"%>
<%@ page import="com.sun.rowset.CachedRowSetImpl" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
		<% 
		  Map attributes=ActionContext.getContext().getSession(); 
		  //int min[]=(int[])attributes.get("min");
		  int all_max=(Integer)attributes.get("all_max"); 
		  ArrayList max=(ArrayList)attributes.get("max"); 
		  String material=(String)attributes.get("material"); 
		  ArrayList chr=(ArrayList)attributes.get("chr"); 
		  ArrayList rate=(ArrayList)attributes.get("rate");   //各染色体杂合率
		  ArrayList seed=(ArrayList)attributes.get("seed");
		  String rate_all=(String)attributes.get("rate_all");  //总杂合率
		  CachedRowSetImpl seed_column=(CachedRowSetImpl) attributes.get("seed_column");
		  
		  %>

<head>
  <title>MaizeGo DataMine Platform</title>

  <meta http-equiv="pragma" content="no-cache"/>
  <meta http-equiv="cache-control" content="no-cache"/>
  <meta http-equiv="expires" content="0"/>
  <meta http-equiv="keywords" content="maize"/>
  <meta http-equiv="description" content="This is a database search engine of maize!"/>
 
  
    <!-- 新版本添加的 -->
<link href="/maizego/style.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="/maizego/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="/maizego/js/jquery.fancybox-1.3.4.js"></script>
<script type="text/javascript" src="/maizego/js/jquery.mousewheel-3.0.4.js"></script>
<link rel="stylesheet" type="text/css" href="/maizego/css/jquery.fancybox-1.3.4.css" media="screen" />
<script type="text/javascript"> 
	$(document).ready(function() {
 
		$("#various1").fancybox({
			'titlePosition':'inside',
			'transitionIn':'none',
			'transitionOut':'none'
		});

 
	});
</script>
  
  
  
  
  
    <style type="text/css">
  .backgroundLiner {
    background-image: url("/maizego/img/bg.png");
    background-repeat: repeat;
}
  </style>

<script type="text/javascript">

	function getX(obj){
		var parObj=obj;  
		var left=obj.offsetLeft;  
	 	while(parObj=parObj.offsetParent){  
	  		left+=parObj.offsetLeft;  
		}  
 		return left;  
	}  
  /*
	function getY(obj){  
		var parObj=obj;  
		var top=obj.offsetTop;  
		while(parObj = parObj.offsetParent){  
	 		top+=parObj.offsetTop;  
	 	}  
	 return top;  
	}  
*/
function cnvs_getCoordinates(e,demo)
{
		var left,oDiv;  
		oDiv=document.getElementById(demo);  
		//top=getY(oDiv);  
		left=getX(oDiv);
		x=e.clientX+20;
		y=e.clientY;
		tip=Math.floor((x-left-20)/800*(<%=all_max%>));
		document.getElementById("xycoordinates").style.position="fixed";
		document.getElementById("xycoordinates").style.top=y+"px";
		document.getElementById("xycoordinates").style.left=x+"px";
		document.getElementById("xycoordinates").innerHTML=tip;
}
function cnvs_clearCoordinates()
{
document.getElementById("xycoordinates").innerHTML="";
}
</script>



</head>

<body>
<!--LOGO+导航开始-->
<%@ include file="/ListHeader.jsp" %>
<!--导航结束-->  
<!--主体部分开始--> 

<div style="width:980px" align="center">     
     <% if(rate_all!=null){%>
		   <div class="Phenotypicstrongblack" style="text-align:left;padding-top:10px;padding-bottom:10px">The chromosome infomation of <%=material%>(<%=rate_all%>%)</div>
	<%} %>	   
		   	<span class="Phenotypicstrongblack" style="font-size: 15px; color: black; display: inline-block; width: 85px;">windows:</span> 
			<canvas id="head" width="850" height="40"class="backgroundLiner"  style="vertical-align:middle">		  
		  </canvas>
		  
		  
		<script type="text/javascript">
			var c=document.getElementById("head");
			var cxt=c.getContext("2d");
			cxt.fillStyle="#00FF00";
			cxt.moveTo(0,20);
			cxt.lineTo(800,20);
			cxt.fillStyle = "#000";
			cxt.fillText(0,0,35);
			cxt.fillText(<%=all_max%>,780,35);
			<%		
			double window1=(all_max)/10;
			for(int t=1;t<10;t++)
			{
			  
			//cxt.font = "italic 0.1px 微软雅黑"; 
			 //cxt.textBaseline = "top";  
			 %>
			
			 cxt.fillRect(80*<%=t%>,20,1,10);
			 cxt.fillText(<%=(int)(window1*t)%>,80*(<%=t%>)-20,35);	
			 cxt.stroke();
			<%}%>	
			</script>
		<%  
		  for(int i=0;i<chr.size();i++) 
		  { 
		  double max_length=Double.parseDouble(String.valueOf(max.get(i)))*800/all_max;
		%>	
		<div>
		   
			<span class="Phenotypicstrongblack" style="font-size: 15px; color: black; display: inline-block; width: 85px;"><%=chr.get(i)%>:<!--(<%=rate.get(i)%>)  --></span> 
			<canvas id="<%=chr.get(i)%>" width="850" height="40" style="vertical-align:middle"class="backgroundLiner" onmousemove="cnvs_getCoordinates(event,'<%=chr.get(i)%>')"onmouseout="cnvs_clearCoordinates()">
			Your browser does not support the canvas element.
			</canvas>
			
			<div id="xycoordinates" ></div>	
		</div>

		<script type="text/javascript">
			var c=document.getElementById("<%=chr.get(i)%>");
			var cxt=c.getContext("2d");
			cxt.fillStyle="#FF0000";
			cxt.moveTo(0,20);
			cxt.lineTo(<%=max_length%>,20);
			
			<%
			ArrayList chr_begin=(ArrayList)attributes.get(chr.get(i)+"_begin");
			ArrayList chr_end=(ArrayList)attributes.get(chr.get(i)+"_end");
			for(int j=0;j<chr_begin.size();j++){
			
			double pos_bg=(double)(Integer.parseInt(String.valueOf(chr_begin.get(j))))*max_length/Double.parseDouble(String.valueOf(max.get(i)));
			double pos_ed=(double)(Integer.parseInt(String.valueOf(chr_end.get(j)))-Integer.parseInt(String.valueOf(chr_begin.get(j))))*max_length/Double.parseDouble(String.valueOf(max.get(i)))+1;
				%>
				cxt.fillRect(<%=pos_bg%>,15,<%=pos_ed%>,10);

			<%}	%>

		cxt.stroke();
		</script>
		<%} %>
		
		
		
		
	 	
<br/>
<br/>
<br/>	



<%if(seed!=null) {%>	
 <div class="Phenotypicstrongblack" style="text-align:left;padding-top:10px;padding-bottom:10px">The seed infomation of <%=material%></div>		
  <div style="overflow:auto">
	        <table  cellpadding="0" cellspacing="0" width="100%" align="center" class="tab1">
				   <tr bgcolor="#CFEEF8">			
				        <%while(seed_column.next()) { if(seed_column.getRow()==seed_column.size())break;;%>							    
                        <td  align="center"><%=seed_column.getString(1) %></td>
                         <%} %>

				   </tr>
				       <%				    				        
							for(int i=0;i<seed.size()/seed_column.size();i++)
				            { 				          	         
		               %>
					        <tr >
					           <%
							for(int j=0;j<seed_column.size()-1;j++)
				            { 				        
					           %>
							    <td align="center"><%=seed.get(seed_column.size()*i+j)%></td> 
							    <%} %>
						   </tr> 
					     <%
					       }//for 
					  %>
			</table>	
			
	</div>	
<%} %>
<div align="right" class="Phenotypicstrongblack" >Notes:<%=seed.get(seed_column.size()-1) %></div>	               	
</div>






<!--主体部结束--> 
<!--版权信息开始--> 
<%@ include file="/ListFooter.jsp" %>                                        
<!--版权结束-->
</body>


</html>



