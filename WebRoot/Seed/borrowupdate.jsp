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
  

  <%
  Map attribute=ActionContext.getContext().getSession(); 
  ArrayList borrow=(ArrayList)attribute.get("borrow"); 
  %>





</head>

<body>

<!--LOGO+导航开始-->
<%@ include file="../ListHeader.jsp" %>
<%  if(user==null){
  response.sendRedirect("/maizego/index.jsp");
  return;
  } %>
<!--导航结束-->  
<!--主体部分开始-->      
<div class="main">	
  <div class="span_24 padding_lr">
         <h3 class="tit" style="border-bottom:2px solid #08b702; padding-bottom:5px; color:#08b702;"><span>UPDATE</span></h3>
         <div class="content">
      <!-- href="#" onClick="myf()"          <a href="#" onClick="myf()">bbbbbbb</a>
      <button type="submit" value="submit"  class="file_button" onclick="javascript:exportcsvfile();"></button>
     
       <button type="submit" value="submit"  class="file_button" onclick="javascript:checkkuaidi100();"></button> 
      javascript:exportcsvfile();
        <div class="bnt_1"><a href="#" class="orange12">马上注册免费会员 &gt;&gt;</a></div>    -->
      

 <form action="borrow_update1.action">
 
 	    <table cellpadding="0" cellspacing="10" width="650" align="center" class="tab">				   	
				   	<tr>
						    <td width="30%" class="t">ID</td>
						    <td><input type="text" name="ID" value="<%=borrow.get(0)%>" readonly/></td>	
				    </tr>
	    </table>
	    <table cellpadding="0" cellspacing="10" width="650" align="center" class="tab">				   	
				   	<tr>
						    <td width="30%" class="t">BorrowTime</td>
						    <td><input type="text" name="BorrowTime" value="<%=borrow.get(1)%>"/></td>	
				    </tr>
	    </table>
	    
		<table cellpadding="0" cellspacing="10" width="650" align="center" class="tab">	    
				    <tr>
						    <td width="30%" class="t">Borrower</td>
						    <td><input type="text" name="Borrower" value="<%=borrow.get(2)%>"/></td>	
				    </tr>
	    </table>			    
		<table cellpadding="0" cellspacing="10" width="650" align="center" class="tab">	    
				    <tr>
						    <td width="30%" class="t">Number</td>
						    <td><input type="text" name="Number" value="<%=borrow.get(3)%>"/></td>	
				    </tr>
	    </table>			    
		<table cellpadding="0" cellspacing="10" width="650" align="center" class="tab">	    				    
				    <tr>						    
						    <td width="30%" class="t">BackTime</td>
						    <td><input type="text" name="BackTime" value="<%=borrow.get(4)%>"/></td>	
				    </tr>
	    </table>			    
		<table cellpadding="0" cellspacing="10" width="650" align="center" class="tab">	    				    
				    <tr>						    
						    <td width="30%" class="t">BackNumber</td>
						    <td><input type="text" name="BackNumber" value="<%=borrow.get(5)%>"/></td>	
				    </tr>
	    </table>	
		<table cellpadding="0" cellspacing="10" width="650" align="center" class="tab">	    				    
				    <tr>						    
						    <td width="30%" class="t">BeforeNum</td>
						    <td><input type="text" name="BeforeNum" value="<%=borrow.get(6)%>"/></td>	
				    </tr>
	    </table>
		<table cellpadding="0" cellspacing="10" width="650" align="center" class="tab">	    				    
				    <tr>						    
						    <td width="30%" class="t">AfterNum</td>
						    <td><input type="text" name="AfterNum" value="<%=borrow.get(7)%>"/></td>	
				    </tr>
	    </table>	    	    		    
		<table cellpadding="0" cellspacing="10" width="650" align="center" class="tab">	    				    
				    <tr>						    
						    <td width="30%" class="t">Type</td>
						    <td><input type="text" name="Type" value="<%=borrow.get(8)%>"/></td>	
				    </tr>
	    </table>			    
			    
			    
		<table cellpadding="0" cellspacing="10" width="650" align="center" class="tab">	    				    
				    <tr>						    	
						    <td width="30%" class="t">Notes</td>	
						    <td><textarea name="Notes" style="height:60px;width:200px" ><%=borrow.get(9)%></textarea></td>	
				    </tr>
	    </table>			    
		 <div style="width:650px; text-align:right; margin-top:30px;"><input type="image" src="/maizego/images/button_03.jpg" /></div>	
			
			</form>

    </div>
    
  
  </div>   

<!--右分栏结束--> 
    </div>
</div>
<!--主体部结束--> 
<!--版权信息开始--> 
<%@ include file="../ListFooter.jsp" %>                                           
<!--版权结束-->
</body>


</html>



