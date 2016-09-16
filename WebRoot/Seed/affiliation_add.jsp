<%@ page contentType="text/html;charset=gbk"  import="java.util.*"  language="java" pageEncoding="UTF-8"%>
<%@ page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page import="java.io.*" %> 

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
<%
  if(user==null){
  response.sendRedirect("/maizego/index.jsp");
  return;
  }
 %>
<!--导航结束-->  
<!--主体部分开始-->      
<div class="main">	
   <h3 class="tit" style="border-bottom:2px solid #08b702; padding-bottom:5px; color:#08b702;"><span>ADD</span></h3>
   <div class="content">
    <form action="affiliation_add.action">
   
		<table cellpadding="0" cellspacing="10" width="650" align="center" class="tab">	    
				    <tr>
						    <td width="30%" class="t">Name</td>
						    <td><input type="text" name="name"/></td>	
				    </tr>
	    </table>			    
		<table cellpadding="0" cellspacing="10" width="650" align="center" class="tab">	    
				    <tr>
						    <td width="30%" class="t">Affiliation</td>
						    <td><input type="text" name="affiliation"/></td>	
				    </tr>
	    </table>			    
		<table cellpadding="0" cellspacing="10" width="650" align="center" class="tab">	    				    
				    <tr>						    
						    <td width="30%" class="t">Phone</td>
						    <td><input type="text" name="phone"/></td>	
				    </tr>
	    </table>			    
		<table cellpadding="0" cellspacing="10" width="650" align="center" class="tab">	    				    
				    <tr>						    
						    <td width="30%" class="t">BorrowNum</td>
						    <td><input type="text" name="borrowNum"/></td>	
				    </tr>
	    </table>

		    
			    
			    
		<table cellpadding="0" cellspacing="10" width="650" align="center" class="tab">	    				    
				    <tr>						    	
						    <td width="30%" class="t">Note</td>	
						    <td><textarea name="note" style="height:60px;width:200px" ></textarea></td>	
				    </tr>
	    </table>			    
		 <div style="width:650px; text-align:right; margin-top:30px;"><input type="image" src="../images/button_06.jpg" /></div>	
			
			</form>

    </div>
    </div>
<!--主体部结束--> 
<!--版权信息开始--> 
<%@ include file="../ListFooter.jsp" %>                                          
<!--版权结束-->
</body>


</html>



