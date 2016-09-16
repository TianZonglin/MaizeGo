<%@ page contentType="text/html;charset=gbk"  import="java.util.*"  language="java" pageEncoding="UTF-8"%>
<%@ page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page import="org.hibernate.HibernateException"%>
<%@ page import="org.hibernate.Session"%>
<%@ page import="org.db.phenoype_agri_traits.*"%>
<%@ page import="java.io.*" %> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
<title>MaizeGo DataMine Platform</title>

  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">
  <meta http-equiv="keywords" content="maize">
  <meta http-equiv="description" content="This is a database search engine of maize!">


   <!-- 新版本添加的 -->
<link href="../style.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="../js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="../js/jquery.fancybox-1.3.4.js"></script>
<script type="text/javascript" src="../js/jquery.mousewheel-3.0.4.js"></script>
<link rel="stylesheet" type="text/css" href="../css/jquery.fancybox-1.3.4.css" media="screen" />
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
<%@ include file="../ListHeader.jsp" %>
<!--导航结束-->  
<!--主体部分开始-->      
<div class="main">
<h3 class="tit" style="border-bottom:2px solid #08b702; padding-bottom:5px; color:#08b702;"><span>Advanced Search</span></h3>
<div id="Jobs_content"> 
<p style="font-size:20px">Search Successfully, Please Download!</p> 
<div >
 <h2 class="tit" style="color:#08b702">Phenotypic Data:</h2><a href="../FileDownload/csvDownload.jsp?name=Phenotypic" title="CSV File"><img src="../images/down1.jpg" /></a>　<a href="../FileDownload/txtDownload.jsp?name=Phenotypic" title=" TXT File"><img src="../images/down2.jpg" /></a>　
</div>
<div style=" float:left">
 <h2 class="tit" style="color:#08b702">Genotypic Data:</h2><a href="../FileDownload/csvDownload.jsp?name=Genotypic" title="CSV File"><img src="../images/down1.jpg" /></a>　<a href="../FileDownload/txtDownload.jsp?name=Genotypic" title=" TXT File"><img src="../images/down2.jpg" /></a>　
</div>
</div>
</div>
<!--主体部结束--> 
<!--版权信息开始--> 
<%@ include file="../ListFooter.jsp" %>                                         
<!--版权结束-->
  </body>
</html>
