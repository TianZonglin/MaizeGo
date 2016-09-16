
<%@ page contentType="text/html;charset=gbk" language="java" pageEncoding="UTF-8"%>
<%@ page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page import="java.util.*"%>

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
          <div id="Jobs_caption">
            <ul>
              <li class="b" >Mapping</li>
            </ul>
          </div>	
	             <div id="Jobs_content">     
	                  <form name="form" id="phenotypic"  method="post" action="bb_qtl_el.action">
	                  <span  class="Phenotypicstrongblack">&nbsp;Chromosome：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
	                  <select name="chr"class="select">
	                      <option value="0">all</option>
						  <option value="1">chr1</option>
						  <option value="2">chr2</option>
						  <option value="3">chr3</option>
						  <option value="4">chr4</option>
						  <option value="5">chr5</option>
						  <option value="6">chr6</option>
						  <option value="7">chr7</option>
						  <option value="8">chr8</option>
						  <option value="9">chr9</option>
						  <option value="10">chr10</option>				  						  
                      </select>&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;  
	                <input type="image" src="../images/button_08.jpg" height="35"width="130"/>
	                  </form>

                 </div>
 
  </div>
 

<!--主体部结束--> 
<!--版权信息开始--> 
<%@ include file="../ListFooter.jsp" %>                                           
<!--版权结束-->
</body>
</html>
