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
	function check(){
	
	var num2=document.getElementById("borrow_num").value;
	var num1=document.getElementById("number").value;
	var num3=document.getElementById("borrow_remain").value;
	if(num2.length==0||isNaN(num2)||parseInt(num2)<=0||parseInt(num1)<parseInt(num2)){
	   alert("borrow is illegal");
	   return false;
	}
	if(num3.length==0||isNaN(num3)||parseInt(num3)<=0||parseInt(num1)<parseInt(num3)){
	   alert("remaining is illegal");
	   return false;	
	}
}
</script>
  

  <%
  Map attribute=ActionContext.getContext().getSession(); 
  ArrayList borrow=(ArrayList)attribute.get("borrow");
  %>





</head>

<body>

<!--LOGO+导航开始-->
<%@ include file="../ListHeader.jsp" %>
<%if(type==null) response.sendRedirect("/maizego/"); %>
<!--导航结束-->  
<!--主体部分开始-->      
<div class="main">	
  <div class="span_24 padding_lr">
         <h3 class="tit" style="border-bottom:2px solid #08b702; padding-bottom:5px; color:#08b702;"><span>Borrow Seed</span></h3>
         <div class="content" style="height:420px" >  
    <%if(!borrow.isEmpty()) {%> 
       <form action="seedBorrow1.action" onsubmit="return check()">
          <input type="hidden" name="type" value="<%=borrow.get(0)%>"/>
	      <table cellpadding="0" cellspacing="10" width="650" align="center" class="tab">				    
				    <tr>
						    <td width="30%" class="t">name</td>
						    <td><input type="text" name="name" value="<%=borrow.get(1)%>" readonly="readonly"/></td>	
				    </tr>
	    </table>
	    <table cellpadding="0" cellspacing="10" width="650" align="center" class="tab">				    
				    <tr>						    
						    <td width="30%" class="t">number</td>
						    <td><input type="text" id="number"name="number" value="<%=borrow.get(2)%>" readonly="readonly"/></td>	
				    </tr>
	    </table>
	    <%if(Integer.parseInt((String)borrow.get(2))>30){ %>
	    <table cellpadding="0" cellspacing="10" width="650" align="center" class="tab">				    
				    <tr>						    
						    <td width="30%" class="t">borrow number</td>
						    <td><input type="text" id="borrow_num" name="borrow_num" "/></td>	
				    </tr>
	    </table>
	    <table cellpadding="0" cellspacing="10" width="650" align="center" class="tab">				    
				    <tr>						    
						    <td width="30%" class="t">remaining number</td>
						    <td><input type="text" id="borrow_remain" name="borrow_remain" "/></td>	
				    </tr>
	    </table>	    
	     <div style="width:650px; text-align:right; margin-top:30px;"><input type="image" src="/maizego/images/button_03.jpg" /></div>		    
	    <%}%>

		
			
			
    </form>
<%}else{ %>

	<div>
	<span class="Phenotypicstrongblack"><br />&nbsp;&nbsp;&nbsp;&nbsp;The query result is empty !</span>
	</div>
      

<%} %>
    </div>
    
  
  </div>   

    </div>

<!--主体部结束--> 
<!--版权信息开始--> 
<%@ include file="../ListFooter.jsp" %>                                           
<!--版权结束-->
</body>


</html>



