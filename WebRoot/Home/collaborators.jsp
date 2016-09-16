
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
<div class="main"  style="height:450px">	
  <p> </p>
  <br/>
  <div></div> 

<span class="Phenotypicstrongblack" style="color: #08b702;vertical-align:bottom">&nbsp;We collaborate with Drs. Yang Xiaohong(杨小红) and Li Jiansheng(李建生) closely for germplasm collection, characterization, utilization and large scale genetic populations developing for genetic architecture dissertation of multiple quantitative traits; with Dr. Wang Guoying(王国英) for high density markers developing and eQTL mapping by deep RNA sequencing of the diverse maize collection; with Drs. Wang Hongwu(王红武), Gao Shibin(高世斌), Tang Jihua(汤继华),Chen Wenjun(陈文俊), Yang Wenpeng(杨文鹏) and Huang Yiqin(黄益勤) for large scale phenotyping; with Drs. Yuan Lixing(袁力行) and Chen Fanjun(陈范骏) for nitrogen genetic analysis; with Zhang Chunyi(张春义) for folic acid genetic analysis; with Drs. Wang Xiaoming (王晓鸣), Fan Xingming(番兴明) and George Mahuku for disease phentoyping and analysis; with Drs.Edward Buckler and Marilyn Warburton for micro nutrition biofortification in maize.</span>

	               
</div>
<!--主体部结束--> 
<!--版权信息开始--> 
<%@ include file="/ListFooter.jsp" %>                                           
<!--版权结束-->
</body>
</html>
