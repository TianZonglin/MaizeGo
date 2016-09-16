<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
   <!-- 新版本添加的 -->
<link href="/login/style.css" type="text/css" rel="stylesheet" />

<script type="text/javascript" src="/maizego/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="/maizego/js/jquery.fancybox-1.3.4.js"></script>
<script type="text/javascript" src="/maizego/js/jquery.mousewheel-3.0.4.js"></script>

<link rel="stylesheet" type="text/css" href="/login/css/jquery.fancybox-1.3.4.css" media="screen" />

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
	
	
		function check(){
		   var account=$("#account").val().trim(); 
		   var password=$("#password").val().trim();  
		   if(account.length==0 ){
		   		   
               alert("password or account is not legal !");
               return false;            
           }
		   if(password.length==0 ){
              
               alert("account or password is illegal !");               
               return false;
            }
          if(!aa() ){
              
              alert("account or password is illegal !");               
               return false;
            }
           if(account=="admin") && password=="admin") ){

              return true;
           }
           alert("Wrong input !"); 
           return false;

            
		}
</script>		
<script type="text/javascript">
 founction aa(string1)
{
 	var hh=false;
	for(int i =0;i<string1.length;i++)
	{
		if(parseInt(string1.toLowerCase().charCodeAt(i))>=97 && parseInt(string1.toLowerCase().charCodeAt(i))<=122) { hh = true; }
		else { hh = false; break;}
	}
	return hh;
}
	
	
	

	</script>
	

	
	
</head>
  
<body>
<!--LOGO+导航开始-->

<!--导航结束-->  
<!--主体部分开始-->      
<!--导航结束-->  
<!--主体部分开始-->      
<div class="main">	

    

                 		<p> </p><br/> <div></div> 
			            <p> </p><br/> <div></div> 
			            <p> </p><br/> <div></div> 
			            <p> </p><br/> <div></div> 
			            <p> </p><br/> <div></div> 
			            <li  style="font-size: 35px;">登陆页面检测</li><br/>
			            <p> </p><br/> <div></div> 
			            <span class="Phenotypicstrongblack">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请输入信息</span><br/>
			            <p> </p><br/> <div></div> 
			           
			       

                 
 	                   <span class="Phenotypicstrongblack">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;账号：</span>
	                   <input id="account"  type="text" name="account" class="input1"/><br/>
	                   <span class="Phenotypicstrongblack">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;密码：</span>
	                   <input  id="password" type="text" name="password"class="input1"/>                         
	                   
	                    <a href="/login/End.jsp"  >
	                    <input style="margin-top: 5px" type="image"src="/login/login.jpg" height="30"width="110" onclick="return check();"/>
	                    </a>
	                     
	
	                  <div id="tip"></div>
 
	               
</div>
</body>
</html>
