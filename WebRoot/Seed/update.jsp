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
<script type="text/javascript"> 	

/*
  //可用与设置只有按下数字按键时有效
        function IsNum(e) {
        alert(e);
            var k = window.event ? e.keyCode : e.which;
            if (((k >= 48) && (k <= 57)) || k == 8 || k == 0) {
            } else {
                if (window.event) {
                    window.event.returnValue = false;
                }
                else {
                    e.preventDefault(); //for firefox 
                }
            }
        }	


*/

/*
	function check(){
	alert(document.getElementById("maize_11YN_NUM")!=null);
	return false;
	if(document.getElementById("maize_11YN_NUM")!=null){
		var num1=document.getElementById("maize_11YN_NUM").value;  
		var num2=document.getElementById("maize_11YN_borrow").value;
		if(num2!=null&&num2.length!=0&&(isNaN(num2)||parseInt(num1)<parseInt(num2)||parseInt(num2)<0)){
		   alert("11YN_borrow is illegal");
		   return false;
		}
		if(num2!=null&&num2.length!=0&&(num7.length==0||isNaN(num7)||parseInt(num1)<parseInt(num7)||parseInt(num7)<0)){
		   alert("11YN_remain is illegal");
		   return false;
		}
	}			
	var num3=document.getElementById("maize_11YXH_NUM").value;
	var num4=document.getElementById("maize_11YXH_borrow").value;
	var num5=document.getElementById("maize_12RIL_NUM").value;
	var num6=document.getElementById("maize_12RIL_borrow").value;
	var num7=document.getElementById("maize_11YN_remain").value;
	var num8=document.getElementById("maize_11YXH_remain").value;
	var num9=document.getElementById("maize_12RIL_remain").value;
	

	if(num4!=null&&num4.length!=0&&(isNaN(num4)||parseInt(num3)<parseInt(num4)||parseInt(num4)<0)){
	   alert("11YXH_borrow is illegal");
	   return false;
	}
	if(num4!=null&&num4.length!=0&&(num8.length==0||isNaN(num8)||parseInt(num3)<parseInt(num8)||parseInt(num8)<0)){
	   alert("11YXH_remain is illegal");
	   return false;
	}		
	if(num6!=null&&num6.length!=0&&(isNaN(num6)||parseInt(num5)<parseInt(num6)||parseInt(num6)<0)){
	   alert("12RIL_borrow is illegal");
	   return false;
	}
	if(num6!=null&&num6.length!=0&&(num9.length==0||isNaN(num9)||parseInt(num5)<parseInt(num9)||parseInt(num9)<0)){
	   alert("12RIL_remain is illegal");
	   return false;
	}			
	}
	*/

	
	function check(){

		var temp_borrow=document.getElementsByName("borrow");
		var temp_remain=document.getElementsByName("remain");
		for(var i=0;i<temp_borrow.length;i++){
			var temp_value1=temp_borrow[i].value;
			var temp_value2=temp_remain[i].value;
			if(isNaN(temp_value1)){
				alert("borrow number must be a number!");
				return false;
			}else if(isNaN(temp_value2)){
				alert("remain number must be a number!");
				return false;
			}	
		}
		return true;
	}	
	
	
	
	
	
	
</script>
  







</head>

<body>


<!--LOGO+导航开始-->
<%@ include file="../ListHeader.jsp" %>
  <%
  Map attribute=ActionContext.getContext().getSession(); 
  ArrayList<String> field=(ArrayList)attribute.get("field");
  ArrayList seed=(ArrayList)attribute.get("seedlist");
  ArrayList<Integer> num=(ArrayList)attribute.get("num");
   // System.out.println(num.toString());
  if(user==null){
  response.sendRedirect("/maizego/index.jsp");
  return;
  }
  %>
<!--导航结束-->  
<!--主体部分开始-->      
<div class="main">	
  <div class="span_24 padding_lr">
         <h3 class="tit" style="border-bottom:2px solid #08b702; padding-bottom:5px; color:#08b702;"><span>UPDATE</span></h3>
         <div class="content">
    
    <%if(type.equals("admin")){%>
       <form action="update1.action">
       
              <table cellpadding="0" cellspacing="10" width="650" align="center" class="tab">
				   <tr >										    
                            <td width="30%" class="t">No</td>
                            <td><input type="text" name="No"  value="<%=seed.get(0)%>"readonly="readonly"/></td>					  
				   </tr>
	          </table> 
       
       
       
       <% for(int i=1;i<field.size()-1;i++){%>
        <table cellpadding="0" cellspacing="10" width="650" align="center" class="tab">
				   <tr >										    
                            <td width="30%" class="t"><%=field.get(i) %></td>
                            <td><input type="text" name="maize"  value="<%=seed.get(i)%>"/></td>					  
				   </tr>
	    </table>
	    <%} %>
	     	    <table cellpadding="0" cellspacing="10" width="650" align="center" class="tab">				    
				    <tr>						    	
						    <td width="30%" class="t">Note</td>	
						    <td><textarea name="Note" style="height:60px;width:200px"><%=seed.get(field.size()-1)%></textarea></td>	
				    </tr>
	    </table>

	    <%}else{ %>
	    <form action="update1.action" >
        <table cellpadding="0" cellspacing="10" width="650" align="center" class="tab">
				   <tr >										    
                            <td width="30%" class="t">No</td>
                            <td><input type="text" name="No" value="<%=seed.get(0)%>"readonly="readonly"/></td>					  
				   </tr>
	    </table>
	    
	    
	    
       <% for(int i=1;i<field.size()-1;i++){%>
        <table cellpadding="0" cellspacing="10" width="650" align="center" class="tab">
				   <tr >										    
                            <td width="30%" class="t"><%=field.get(i) %></td>
                            <td><input type="text" name="maize"  value="<%=seed.get(i)%>" readonly="readonly"/></td>					  
				   </tr>
	    </table>
	    
	    
	    <%if(num.contains(i)&&Integer.valueOf((String)seed.get(i))>30){ %>
	        <input type="hidden"  name="selectField" value="<%=field.get(i) %>"/>
	        <input type="hidden" name="material" value="<%=seed.get(i-1) %>"/>
	        <input type="hidden" name="beforeNum" value="<%=seed.get(i)%>"/>
		    <table cellpadding="0" cellspacing="10" width="650" align="center" class="tab">	
		    <tr>
				<td width="30%" class="t">borrow number</td>
			    <td><input type="text"  name="borrow"   /></td>
				<td width="30%" class="t">remaining number</td>
			    <td><input type="text"  name="remain"  /></td>		    
		    </tr>
		    </table>		
	    <%} %>		    
	    
	    
	    

	    
	    <%}%>	    
	    
	    
	  <table cellpadding="0" cellspacing="10" width="650" align="center" class="tab">				    
				    <tr>						    	
						    <td width="30%" class="t">Note</td>	
						    <td><textarea name="Note" readonly="readonly" style="height:60px;width:200px"><%=seed.get(field.size()-1)%></textarea></td>	
				    </tr>
	    </table>	    
	      
	    <%} %>
		 <div style="width:650px; text-align:right; margin-top:30px;"><input type="image" src="/maizego/images/button_03.jpg" onclick="return check();"/></div>	
			
			
    </form>

    </div>
    
  
  </div>   

    </div>

<!--主体部结束--> 
<!--版权信息开始--> 
<%@ include file="../ListFooter.jsp" %>                                           
<!--版权结束-->
</body>


</html>



