
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
<!--导航结束-->  
<!--主体部分开始-->      
<div class="main">	

    
 		 

                   	 <div id="Jobs_caption">
			            <ul>
			              <li class="b">Simple Search</li>
			            </ul>
			         </div>
				    <div id="Jobs_content" style="font-size:16px; padding-left:10px;height:420px">
	                  <form name="form" id="phenotypic"  method="post" action="seed.action"  >
	                  
	                  <span class="Phenotypicstrongblack">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Population：</span>
	               	   <select name="population" class="select">
						  <option value="seed_amp x mo17 f1">AMP/X/MO17/F1</option>
						  <option value="seed_amp x zheng58 f1">AMP/X/ZHENG58/F1</option>
						  <option value="seed_amp">AMP</option>
						  <option value="seed_b73/by804">B73/BY804</option>
						  <option value="seed_kui3/b77">KUI3/B77</option>
						  <option value="seed_k22/ci7">K22/CI7</option>
						  <option value="seed_d340/k22">D340/K22</option>
						  <option value="seed_zheng58/sk">ZHENG58/SK</option>
						  <option value="seed_mo17/x26-4">MO17/X26-4</option>
						  <option value="seed_yu8701/bk">YU8701/BK</option>		
						  <option value="seed_zong3/yu87-1">ZONG3/YU8701</option>	
					  						  
                      </select>                      
 	                 
	                  <input style="margin-top: 5px" type="image"src="/maizego/images/button_08.jpg" height="36"width="130"/>
	                  </form>
	                  <div id="tip"></div>
                 </div>
	               
</div>
<!--主体部结束--> 
<!--版权信息开始--> 
<%@ include file="/ListFooter.jsp" %>                                           
<!--版权结束-->
</body>
</html>
