<%@ page contentType="text/html;charset=gbk"  import="java.util.*"  language="java" pageEncoding="UTF-8"%>
<%@ page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page import="org.hibernate.HibernateException"%>
<%@ page import="org.hibernate.Session"%>
<%@ page import="java.io.*" %> 
<%@ page import="java.util.*"%>
<%@ page import="org.db.phenoype_agri_traits.*"%>
<%@ page import="org.util.DbBean"%>
<%@ page import="java.sql.ResultSet"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html >
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
   function check()
   {  
     if(confirm("确定要删除吗？")){
           return true;
     }
     else { return false;}
}		
</script>



<!--<script type="javascript"> 	
function check(){
	//alert("aaaaaaa");
	var num1=document.getElementById("select1").value;  
	var num2=document.getElementById("select2").value;	
	if(num2>num1){
	   alert("choice is illegal");
	   return false;
	}
	if(num2=num1){
	   alert("choice is illegal");
	   return false;
	}	
}
</script>
  






--></head>

 <%
Map attribute=ActionContext.getContext().getSession(); 
  ArrayList<String> rs_select  = (ArrayList)attribute.get("rs1");
  ArrayList<String> rs_choose2 = (ArrayList)attribute.get("rs2");
   ArrayList<String> rs_choose1 = (ArrayList)attribute.get("choose1");
      //ArrayList<String> rs_choose1 = (ArrayList)attribute.get("choose1")
 // ArrayList<String>    choose1 = (ArrayList)attribute.get("choose1");
 
 
 %>	

<body>

<!--LOGO+导航开始-->
<%@ include file="../ListHeader.jsp" %>

<!--导航结束-->  
<!--主体部分开始-->   
<div class="main">
    <div class="content">
         <h3 class="tit" style="border-bottom:2px solid #08b702; padding-bottom:5px; color:#08b702;"><span>T-TEST-ANALYSIS</span></h3>
         
            <form name="form1" action="t-test1.action">
             
               		 <span class="Phenotypicstrongblack">POS起始点*  </span> 
				          <select id="select1" class="select" name="select1" style="width:150px">			     
				          <%for(int i=0;i<rs_select.size();i++){%>
				          <option style="width:150px" value="<%=rs_select.get(i) %>"><%=rs_select.get(i) %></option>
				          <%} %>
				          </select>
				      <span class="Phenotypicstrongblack">    POS终点*  </span>
				          <select id="select2" class="select" name="select2" style="width:150px">
				          <option style="width:150px" >1000404</option>
				          <option style="width:150px" >1000509</option>
				          <%for(int i=1;i<rs_select.size();i++){%>
				          <option style="width:150px" value="<%=rs_select.get(i) %>"><%=rs_select.get(i) %></option>
				          <%} %>
				          </select>
					 
           <div id="Jobs_content" style="font-size: 16px; padding-left: 10px; height: 240px">
                    
					<div>
						<span class="Phenotypicstrongblack"><br />&nbsp;Choose:</span><span class="Grand9">(选择多种材料/选择PAT表:)</span>
					</div>

					<div class="sel">		
					 <span class="Phenotypicstrongblack">MATERAILS*   </span>
						<select style="width:230px" id="choose1" name="choose1"  multiple="multiple" size="6" class="select"   style="margin-left:30px">
						  <%for(int i=11;i<rs_choose1.size();i++){%>
				          <option style="width:150px" value="<%=rs_choose1.get(i) %>"><%=rs_choose1.get(i) %></option>
				          <%} %>
						</select>
					<span class="Phenotypicstrongblack">  PAT*   </span>
						<select style="width:230px" id="choose2" name="choose2" multiple="multiple" size="6" class="select"  >
				           <%for(int i=1;i<rs_choose2.size();i++){%>
				          <option style="width:150px" value="<%=rs_choose2.get(i) %>"><%=rs_choose2.get(i) %></option>
				          <%} %>
						</select>
					 

					</div>
                  	 
                  		<input style="margin-top: 10px" type="image"src="/maizego/images/button_08.jpg" height="36"width="100"/> 
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



