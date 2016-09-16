<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ page import="org.util.DbBean"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
DbBean db=new DbBean();
String id=request.getParameter("id");
String sql="delete from seed_kd_ril where `No`="+id+";";
db.executeUpdate(sql);

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'delete.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript"> 
function delayedRedirect(){  window.location ="seed.action?id=sed Manage"; }  </script>
  </head>
  
  <body onload="delayedRedirect()">

  </body>
</html>
