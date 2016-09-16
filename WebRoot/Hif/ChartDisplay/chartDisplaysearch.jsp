<%@ page contentType="text/html;charset=gbk" language="java" pageEncoding="UTF-8"%>
<%@ page import = "java.io.PrintWriter" %> 
<%@ page import="org.hibernate.Session"%>
<%@ page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page import="org.db.phenotypes_294_rils_441_crosses.*"%>
<%@ page import="java.io.*" %> 
<%@ page import="org.hibernate.HibernateException"%>
<%@ page import="java.util.Map"%>

<% 
Map attibutes = ActionContext.getContext().getSession();
String fileName=(String)attibutes.get("fileName");
String graphURL = request.getContextPath() + "/servlet/DisplayChart?filename=" +fileName; 
System.out.println(graphURL);
%> 

<html>
<head>
  <title>MaizeGo DataMine Platform</title>

  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">
  <meta http-equiv="keywords" content="maize">
  <meta http-equiv="description" content="This is a database search engine of maize!">
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />




  


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



</head> 
<body> 
<!--LOGO+导航开始-->
<%@ include file="/ListHeader.jsp" %>
  
<!--导航结束--> 
 
<!--主体部分开始--> 
<div class="main"> 
		 <img src="<%=graphURL%>" width=940 height=450 border=0 >                        
</div>  
<!--主体部结束--> 

<!--版权信息开始--> 
<%@ include file="/ListFooter.jsp" %>

</body>
</html>
