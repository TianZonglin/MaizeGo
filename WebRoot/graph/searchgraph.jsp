
<%@ page contentType="text/html;charset=gbk" language="java" pageEncoding="UTF-8"%>
<%@ page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page import="org.hibernate.Session"%>
<%@ page import="java.util.*"%>
<%@ page import="org.db.phenoype_agri_traits.*"%>
<%@ page import="org.hibernate.HibernateException"%>
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
DbBean db=new DbBean();
String sql="select DISTINCT(`first`) from `graph` union select DISTINCT(`second`) from `graph`;";
ResultSet rs=db.executeQuery(sql);
%>	
</head>
  
<body>
<!--LOGO+导航开始-->
<%@ include file="/ListHeader.jsp" %>
<!--导航结束-->  
<!--主体部分开始-->      
<!--导航结束-->  
<!--主体部分开始-->      
<div class="main">	

    
 		

                   	 <div id="Jobs_caption">
			            <ul>
			              <li class="b">Show Graph</li>
			            </ul>
			         </div>
				     <div id="Jobs_content" style="height:420px">
	                  <br/>
	                  
					  <form name="form" id="phenotypic"  method="post" action="relation.action"  > 
	                  <span class="Phenotypicstrongblack">Node :&nbsp;</span>
	               	   <select class="select" name="relationnode" style="width:141px;">
				          <%while(rs.next()) {%>
				          <option><%=rs.getString(1) %></option>
				          <%} %>
				      </select>
				        <br/><span class="Phenotypicstrongblack">Level :&nbsp;</span>   
					  <input id="floor"  type="text" name="floor" class="input1"/ style="width:139px;"/>                      
 	                   <br/><span class="Phenotypicstrongblack">Value:&nbsp;</span>   
					  <input id="value"  type="text" name="value" class="input1"/ style="width:141px;"/>                      
 	                  <input style="margin-top: 5px" type="image"src="/maizego/images/button_08.jpg" height="36"width="126"/><br/><!--
 	                  <input style="margin-top: 5px" type="image"src="/maizego/images/showgraph.jpg" height="36"width="100"onclick="showgraph();"/>
 	                 
	                   --></form><!--
	                   
	              <script type="text/javascript">
                           function showgraph(){
                           document.forms.form.action="showgraph.action";
                           document.forms.form.submit();
                         }
                   </script>
                   
	                  --><form name="form" id="phenotypic"  method="post" action="leastroad.action"  >
	                  <br/><span class="Phenotypicstrongblack">LeastRoad :&nbsp;</span>
	                  <select class="select" name="firstnode" style="width:140px;">
	               	      <%rs=db.executeQuery(sql);%>
				          <%while(rs.next()) {%>
				          <option><%=rs.getString(1) %></option>
				          <%} %> 
				      </select><br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				      <select class="select" name="secondnode" style="width:140px;">
                          <%rs=db.executeQuery(sql);%>
				          <%while(rs.next()) {%>
				          <option><%=rs.getString(1) %></option>
				          <%} %>
				      </select>
				      <input style="margin-top: 5px" type="image"src="/maizego/images/button_08.jpg" height="36"width="126"/>
	                  </form>
	                  
				<div id="tip"></div>
                 </div>
	                 </div>

<!--主体部结束--> 
<!--版权信息开始--> 
<%@ include file="/ListFooter.jsp" %>                                           
<!--版权结束-->
</body>
</html>
