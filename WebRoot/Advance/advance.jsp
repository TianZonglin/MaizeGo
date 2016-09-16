
<%@ page contentType="text/html;charset=gbk" language="java" pageEncoding="UTF-8"%>
<%@ page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page import="org.hibernate.Session"%>
<%@ page import="java.util.*"%>
<%@ page import="org.db.phenoype_agri_traits.*"%>
<%@ page import="org.hibernate.HibernateException"%>
<%@ page import="org.util.DbBean"%>
<%@ page import="java.sql.ResultSet"%>

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
<!--导航结束-->  
<!--主体部分开始-->      
<div class="main">	

    
 				<div class="span_27 r_0"> 
 				<div id="Jobs">
                   	 <div id="Jobs_caption">
			            <ul>
			              <li class="b" style="width:130px">Advanced Search</li>
			            </ul>
			         </div>
				     <div id="Jobs_content" style="font-size:16px; padding-left:10px">
				          <ul>
				            <li><span >Advanced Search | </span>  <a href="/maizego/Advance/advance_user_define.jsp" class="Grand3" >Search By User-defined</a></li>
				            <li><span >Advanced Search | </span>  <a href="/maizego/Advance/advance_selection.jsp" class="Grand3">Search By Selection</a></li>
				            <li><span >Advanced Search | </span>  <a href="/maizego/Advance/advance_blup.jsp" class="Grand3">Search By Blup</a></li>

				          </ul>  
                 </div>
	                 </div>
	             </div>
    
    </div>

<!--主体部结束--> 
<!--版权信息开始--> 
<%@ include file="../ListFooter.jsp" %>                                           
<!--版权结束-->
</body>
</html>
