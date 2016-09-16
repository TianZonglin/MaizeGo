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
 <script type="text/javascript"> 	
	 function check111(){ 

		var BorrowTime=document.getElementById('BorrowTime').value; 
		var Borrower=document.getElementById("Borrower").value;
		var Number=document.getElementById("Number").value;
		var BackTime=document.getElementById("BackTime").value;
		//var BackNumber=document.getElementById("BackNumber").value;
		var BeforeNum=document.getElementById("BeforeNum").value;
		var AfterNum=document.getElementById("AfterNum").value;
		var Type=document.getElementById("Type").value;
		var Population=document.getElementById("Population").value;
		//var Notes=document.getElementById("Notes").value;

		if(BorrowTime==""||Borrower==""||Number==""||BackTime==""||BeforeNum==""||AfterNum==""||Type==""||Population==""){
			alert("Error: Please input the information completely !");
			return false;
		}
		return true;
      }
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
    <form action="borrow_add.action"  onsubmit="return check111();">
	    <table cellpadding="0" cellspacing="10" width="650" align="center" class="tab">				   	
				   	<tr>
						    <td width="30%" class="t">BorrowTime</td>
						    <td><input type="text" id="BorrowTime" name="BorrowTime"/></td>	
				    </tr>
	    </table>
	    
		<table cellpadding="0" cellspacing="10" width="650" align="center" class="tab">	    
				    <tr>
						    <td width="30%" class="t">Borrower</td>
						    <td><input type="text" id="Borrower" name="Borrower"/></td>	
				    </tr>
	    </table>			    
		<table cellpadding="0" cellspacing="10" width="650" align="center" class="tab">	    
				    <tr>
						    <td width="30%" class="t">Number</td>
						    <td><input type="text" id="Number" name="Number"/></td>	
				    </tr>
	    </table>			    
		<table cellpadding="0" cellspacing="10" width="650" align="center" class="tab">	    				    
				    <tr>						    
						    <td width="30%" class="t">BackTime</td>
						    <td><input type="text" id="BackTime" name="BackTime"/></td>	
				    </tr>
	    </table><!--			    
		<table cellpadding="0" cellspacing="10" width="650" align="center" class="tab">	    				    
				    <tr>						    
						    <td width="30%" class="t">BackNumber</td>
						    <td><input type="text" id="BackNumber" name="BackNumber"/></td>	
				    </tr>
	    </table>
		--><table cellpadding="0" cellspacing="10" width="650" align="center" class="tab">	    				    
				    <tr>						    
						    <td width="30%" class="t">BeforeNum</td>
						    <td><input type="text" id="BeforeNum" name="BeforeNum" /></td>	
				    </tr>
	    </table>
		<table cellpadding="0" cellspacing="10" width="650" align="center" class="tab">	    				    
				    <tr>						    
						    <td width="30%" class="t">AfterNum</td>
						    <td><input type="text" id="AfterNum" name="AfterNum"/></td>	
				    </tr>
	    </table>	    			    
		<table cellpadding="0" cellspacing="10" width="650" align="center" class="tab">	    				    
				    <tr>						    
						    <td width="30%" class="t">Type</td>
						    <td><input type="text" id="Type" name="Type"/></td>	
				    </tr>
	    </table>			    
			    
			    
		<table cellpadding="0" cellspacing="10" width="650" align="center" class="tab">	    				    
				    <tr>						    	
						    <td width="30%" class="t">Population</td>	
						     <td><input type="text" id="Population"  name="Population"/></td>	
				    </tr>
	    </table><!--				    
			    
			    
			    
		<table cellpadding="0" cellspacing="10" width="650" align="center" class="tab">	    				    
				    <tr>						    	
						    <td width="30%" class="t">Notes</td>	
						    <td><textarea id="Notes" style="height:60px;width:200px" ></textarea></td>	
				    </tr>
	    </table>	
	    
    
	    
	    		    
		 --><div style="width:650px; text-align:right; margin-top:30px;"><input type="image" src="../images/button_06.jpg" /></div>	
			
			</form>

    </div>
    </div>
<!--主体部结束--> 
<!--版权信息开始--> 
<%@ include file="../ListFooter.jsp" %>                                          
<!--版权结束-->
</body>


</html>










