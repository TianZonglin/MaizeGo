<%@ page contentType="text/html;charset=gbk"  import="java.util.*"  language="java" pageEncoding="UTF-8"%>
<%@ page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page import="org.db.phenotypes_294_rils_441_crosses.*"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.text.DecimalFormat"%>
<%@ page import="graph.Data"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
		
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
  
</head>
<%
  Map attribute=ActionContext.getContext().getSession(); 
  ArrayList<String> result=(ArrayList<String>)attribute.get("result");
  int columnCount=(Integer)attribute.get("columnCount"); 
%>

<body>

<!--导航结束-->  
<!--主体部分开始-->  

<!--LOGO+导航开始-->
<%@ include file="/ListHeader.jsp" %>

<!--导航结束-->  
<!--主体部分开始-->  
<div class="main">
<div style="width:980px" align="center" class="content">	

		<div>
		<table>
		

		<td style="width:840px;height:40px">	
			<canvas id="22222" width="840" height="640"class="backgroundLiner"  style="vertical-align:middle;" onmousemove="cnvs_getCoordinates(event,'777')"onmouseout="cnvs_clearCoordinates()">		
			</canvas>
	        <div id="xycoordinates" ></div>	
	    </td>    
	     </table>
		</div>

   <script type = "text/javascript" language="javascript">
   
   <%
   Map<String,Data> datamap=new HashMap<String,Data>();
   datamap.put(result.get(1),new Data(400,100,-1));
  %>
   
   	var canvas = document.getElementById("22222");
    var context = canvas.getContext("2d");   
  
  
    
    //画圆
    context.beginPath();
    context.strokeStyle = "#009100";
    context.arc(<%= datamap.get(result.get(1)).x  %>,<%= datamap.get(result.get(1)).y %>,20,0,2*Math.PI, true);
    context.stroke();
   // context.font="30px Georgia";
    context.font="30px Georgia";
   
    context.strokeText("<%=result.get(1)%>",<%=datamap.get(result.get(1)).x-8 %>,<%=datamap.get(result.get(1)).y
    +5%>);
 
    <%
    String first,second;
    for(int i=0;i<result.size()/columnCount;i++)
    {
        first=result.get(columnCount*i+1);
        second=result.get(columnCount*i+2);
        if(datamap.get(second)==null)
        {
        datamap.put(second,new Data(datamap.get(first).pos*100+datamap.get(first).x ,datamap.get(first).y+100,-1));
        }
        datamap.get(first).pos++;%>
        context.beginPath();
        context.strokeStyle = "#009100";
        context.arc(<%= datamap.get(second).x  %>,<%= datamap.get(second).y %>,20,0,2*Math.PI, true);
        context.stroke();
        context.beginPath();
        context.strokeStyle = "#009100";
        context.moveTo(<%=datamap.get(first).x%>,<%=datamap.get(first).y+20%>);
        context.lineTo(<%=datamap.get(second).x%>,<%=datamap.get(second).y-20%>);
        context.stroke();
       
        context.font="30px Georgia";
        context.strokeText("<%=result.get(columnCount*i+2)%>",<%=datamap.get(second).x-8%>,<%=datamap.get(second).y+5%>);
        context.font="10px Georgia";
        context.strokeText("<%=result.get(columnCount*i+3)%>",<%=(datamap.get(first).x+datamap.get(second).x)/2%>,<%=(datamap.get(first).y+datamap.get(second).y)/2%>);
        
        <%
    }%>
   

</script>
		


<!--主体部结束--> 
<!--版权信息开始--> 
<%@ include file="/ListFooter.jsp" %>

</body>
</html>


