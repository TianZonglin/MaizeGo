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
 

  ArrayList<String> field = (ArrayList)attribute.get("field1");
  ArrayList<String> info = (ArrayList)attribute.get("info1");
  ArrayList<String> wdata = (ArrayList)attribute.get("wdata1");
 

 %>	

<body>

<!--LOGO+导航开始-->
<%@ include file="../ListHeader.jsp" %>

<!--导航结束-->  
<!--主体部分开始-->   
<div class="main">
    <div class="content">
    
    		<div style=" float:right;">
		           <a href="/maizego/Expression/km_csv.jsp" title="CSV File"><img src="/maizego/images/down1.jpg" /></a>
		           <a href="/maizego/Expression/km_txt.jsp" title=" TXT File"><img src="/maizego/images/down2.jpg" /></a>
		</div><br />
        
        
    
		<div>
			   <h3 class="tit" style="color:#08b702;">
			   <span>Search by QQ_normed</span></h3> 
          </div>    <hr style=" border-top:2px solid #08b702;" />  

              <%if(info.size()!=0){ %><!--
               		 <div>
						<span class="Phenotypicstrongblack"><br />&nbsp;From-table-expression:</span>
					</div>
					
					-->
					
					<!-- 
						
				<div class="inser">
		           <select name="cata" style="border:2px solid #09b801; padding:7px 15px; position:relative; top:2px; color:#666;">
				       <option>CATEGORY</option>
					   <option>CATEGORY</option>
					   <option>CATEGORY</option>
				   </select>
				   <input type="text" value="SEARCH" onblur="this.style.color='#999';if (this.value == '') this.value = 'SEARCH';" onfocus="this.style.color='#666';this.value = ''" style="height:30px; border-top:2px solid #09b801; border-bottom:2px solid #09b801; color:#666; width:260px; line-height:30px; border-left:2px solid #09b801; text-indent:15px;" /><input type="image" src="/maizego/images/ingo.jpg" style="margin-left:-2px;" />
		      	</div>	
					

					 -->
	
					
				<div style="overflow:auto;height:420px">	
					<div class="sel">
					 <div style="overflow:auto">
					 
					 
					 
					 
					<table cellpadding="0" cellspacing="0" width="100%" align="center" class="tab1" >
				        <tr bgcolor="#CFEEF8">	
				        	<%				    				        
								for(int i=0;i<field.size();i++)
				            	{ 				           	       	         
		                %>
		                    	  <td  align="center"><%=field.get(i)%></td> 
					   		 <% }%>
					   	</tr>	 
					   		 
					   		 
					   		 
					   		<%	
			    				        
							for(int k=0;k<info.size()/field.size();k++)
				            {%>
				            <tr>
				            <%for(int i=0;i<field.size();i++)
				            	{ 		 	   	       	         
		                    %>  
		                         <td  align="center"><%=info.get(field.size()*k+i)%></td>  
							<%
							 }%>
							 </tr>
							 <%}%>
			</table>
		           
					</div>
			   </div>

			   
			   
			</div>
			

		             
					   <div>
						<span class="Phenotypicstrongblack"><br />&nbsp;Null result:</span><br />
					</div>
					&nbsp;
					<%for(int i=0;i<wdata.size();i++){ %>
				        <span ><%=","+wdata.get(i)%></span>
				     <%} %>       
				</div> 
				 <%}else{ %> 
				 
				<div style="height:420px">
				 <div>
						<span class="Phenotypicstrongblack"><br />&nbsp;No result or wrong input !</span><br />
						<span class="Phenotypicstrongblack"><br />&nbsp;Please return to check your input !</span><br />
					</div>
				 </div>  
				<%}%>             	     	    		 

      </div>
</div>	




<!--主体部结束--> 
<!--版权信息开始--> 
<%@ include file="../ListFooter.jsp" %>                                          
<!--版权结束-->

  </body>


</html>



