<%@ page contentType="text/html;charset=gbk"  import="java.util.*"  language="java" pageEncoding="UTF-8"%>
<%@ page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page import="org.db.phenotypes_294_rils_441_crosses.*"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.text.DecimalFormat"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
		<%
		  Map attributes=ActionContext.getContext().getSession();
		  ArrayList materials=(ArrayList)attributes.get("materials");
		  double min=(Double)attributes.get("min");
		  double max=(Double)attributes.get("max");
		  String chr=(String)attributes.get("chr");	
		  String population=((String)attributes.get("population")).substring(4).toUpperCase();	  
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
		tip=Math.floor((x-left-20)/800*(<%=max%>-<%=min%>)+<%=min%>);
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
<div class="main">
<div style="width:980px" align="center" class="content">	

		   <div class="Phenotypicstrongblack" style="text-align:left;padding-top:10px;padding-bottom:10px">The hybrid information of chromosome <%=chr%><span class="Grand9"> (red blocks represent heterogeneous segments in specific individuals)</span> </div>
		  <div>
			<span style="font-size:15px;color:black;display:inline-block;width:100px">windows:</span>
			<canvas id="head" width="840" height="40"class="backgroundLiner"  style="vertical-align:middle">		  
		  </canvas>
		  </div>
		  
		  
		<script type="text/javascript">
			var c=document.getElementById("head");
			var cxt=c.getContext("2d");
			cxt.fillStyle="#00FF00";
			cxt.moveTo(0,20);
			cxt.lineTo(800,20);
			cxt.fillStyle = "#000";
			cxt.fillText(<%=(int)min%>,0,35);
			cxt.fillText(<%=(int)max%>,780,35);
			<%		
			double window=(max-min)/10;
			for(int t=1;t<10;t++)
			{
			  
			//cxt.font = "italic 0.1px 微软雅黑"; 
			 //cxt.textBaseline = "top";  
			 %>
			
			 cxt.fillRect(80*<%=t%>,20,1,10);
			 cxt.fillText(<%=(int)(min+window*t)%>,80*(<%=t%>)-20,35);	
			 cxt.stroke();
			<%}%>	
			</script>	
			  
		  <% 
		  String material;
		 
		  for(int i=0;i<materials.size();i++)
		  {
		  material=(String)materials.get(i);
		%>
	
		<div>
		<table>
		
		<td style="width:100px;height:40px">
		    <a href="materialinformation.action?material=<%=material%>" style="font-size:15px;color:black;display:inline-block;width:20px;"><img src="/maizego/images/down2.jpg" width="15" height="10" style="margin-bottom:6px;"/></a>		
			<a href="material.action?material=<%=material%>" style="display:inline-block;width:75px;" ><%=material%>:(<%=population %>)</a>			
			
		</td>
		<td style="width:840px;height:40px">	
			<canvas id="<%=material%>" width="840" height="40"class="backgroundLiner"  style="vertical-align:middle;" onmousemove="cnvs_getCoordinates(event,'<%=material%>')" onmouseout="cnvs_clearCoordinates()">
			<!--<canvas id="<%=material%>" width="850" height="25"  style="border:1px solid #c3c3c3;">-->
			Your browser does not support the canvas element.			
			</canvas>
	        <div id="xycoordinates" ></div>	
	    </td>    
	     </table>
		</div>
<script type="text/javascript">
			var c=document.getElementById("<%=material%>");
			var cxt=c.getContext("2d");
			cxt.fillStyle="#00FF00";
			cxt.moveTo(0,20);
			cxt.lineTo(800,20);

			cxt.fillStyle="#FF0000";
			<%
			
			ArrayList pos_begin=(ArrayList)attributes.get(material+"_begin");
			ArrayList pos_end=(ArrayList)attributes.get(material+"_end");
			for(int j=0;j<pos_begin.size();j++){
			double pos_bg=(double)(Integer.parseInt((String)pos_begin.get(j))-min)*800/(max-min);
			double pos_ed=(double)(Integer.parseInt((String)pos_end.get(j))-Integer.parseInt((String)pos_begin.get(j)))*800/(max-min)+1;
			     
				%>
				cxt.fillRect(<%=pos_bg%>,15,<%=pos_ed%>,10);
			<%}%>

			
		cxt.stroke();
		</script>
		
		<%} %>
</div>
</div>




<!--主体部结束--> 
<!--版权信息开始--> 
<%@ include file="/ListFooter.jsp" %>

</body>
</html>


