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
	    function check()
    {       
      var num1=document.getElementsByName('maize_11YN_NUM')[0].value;
      var num2=document.getElementsByName('maize_11YXH_NUM')[0].value;
      var num3=document.getElementsByName('maize_12RIL_NUM')[0].value;
      if(num1.length==0||isNaN(num1)){        
          alert("11YN_NUM is not a number!")
           return false;
         }
      if(num2.length==0||isNaN(num2)){
          alert("11YXH_NUM is not a number!")
           return false;      
         }
      if(num3.length==0||isNaN(num3)){
          alert("12RIL_NUM is not a number!")
           return false;      
         }       
      } 
      function check11(){ 
		var temp_borrow=document.getElementsByName("maize");

		for(var i=0;i<temp_borrow.length;i++){
			var temp_value1=temp_borrow[i].value;

			if(temp_value1==""){
				alert("Error:wrong input!");
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
  if(user==null){
  response.sendRedirect("/maizego/index.jsp");
  return;
  }
   Map attribute= ActionContext.getContext().getSession(); 
 
  ArrayList<String> field=(ArrayList)attribute.get("field");
  ArrayList<String> seed=(ArrayList)attribute.get("seedlist");
  ArrayList<Integer> num=(ArrayList)attribute.get("num");
%>
  
  
  
  

<!--导航结束-->  
<!--主体部分开始-->      
<div class="main">	
   <h3 class="tit" style="border-bottom:2px solid #08b702; padding-bottom:5px; color:#08b702;"><span>ADD</span></h3>
   <div class="content">
    <form action="add.action" onsubmit="return check11();">
    
    
         <% for(int i=1;i<field.size()-1;i++){%>
        <table cellpadding="0" cellspacing="10" width="650" align="center" class="tab">
				   <tr >										    
                            <td width="30%" class="t"><%=field.get(i) %></td>
                            <td><input type="text" name="maize" /></td>					  
				   </tr>
	    </table>
	    <%} %>
    
    	  <table cellpadding="0" cellspacing="10" width="650" align="center" class="tab">				    
				    <tr>						    	
						    <td width="30%" class="t">Note</td>	
						    <td><textarea name="Note"  style="height:60px;width:200px"></textarea></td>	
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



