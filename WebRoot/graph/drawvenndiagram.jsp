
<%@ page contentType="text/html;charset=gbk" language="java" pageEncoding="UTF-8"%>
<%@ page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page import="org.hibernate.Session"%>
<%@ page import="java.util.*"%>
<%@ page import="org.db.phenoype_agri_traits.*"%>
<%@ page import="org.hibernate.HibernateException"%>
<%@ page import="org.hibernate.Session"%>
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
<%@ include file="../ListHeader.jsp"%>

<!--导航结束-->  
<!--主体部分开始-->      
<!--导航结束-->  
<!--主体部分开始--> 
	<%   
	request.setCharacterEncoding("UTF-8");

 response.setCharacterEncoding("UTF-8"); %>  
<div class="main">   	

                   	 <div id="Jobs_caption">
			            <ul>
			              <li class="b">Venn Diagram</li>

			            </ul>
			         </div>
				     <div id="Jobs_content" style="height:330px">
	                  <form name="form1" id="phenotypic"  method="post" action="draw.action" >&nbsp; 
	                  <table>
	                <tr>
		                  <td>
		                    <span class="Phenotypicstrongblack" >List1:</span> 
		                   </td> 
		                   <td>
			                  <textarea id="list1" name="list1" style="height:50px;width:150px"></textarea>
		                  </td>
	                </tr>
	                <tr>
		                  <td>
		                    <span class="Phenotypicstrongblack" >List2:</span> 
		                   </td> 
		                   <td>
			                  <textarea id="list2" name="list2" style="height:50px;width:150px"></textarea>
		                  </td>
	                </tr>
	                <tr>
		                  <td>
		                    <span class="Phenotypicstrongblack" >List3:</span> 
		                   </td> 
		                   <td>
			                  <textarea id="list3" name="list3" style="height:50px;width:150px"></textarea>
		                  </td>
	                </tr>
	                <tr>
		                  <td>
		                    <span class="Phenotypicstrongblack" >List4:</span> 
		                   </td> 
		                   <td>
			                  <textarea id="list4" name="list4" style="height:50px;width:150px"></textarea>
		                  </td>
	                </tr>	                
	                  <tr>
	                  <td style="padding-left:10px">
	                   <input style="margin-top: 5px"type="image" src="../images/button_08.jpg" height="36"width="100" />
	                   </td>
	                   </tr>
	                   
	                   </table>
	                  <span id="tip1"></span>  
	                  </form>	                
	                 </div>
	                 </div>
    
<!--主体部结束--> 
<!--版权信息开始--> 
<%@ include file="../ListFooter.jsp"%>                                            
<!--版权结束-->
</body>
</html>
