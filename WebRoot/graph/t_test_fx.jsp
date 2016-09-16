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
 

  ArrayList<String> t_table = (ArrayList)attribute.get("t_table");
  ArrayList<String> t_hang = (ArrayList)attribute.get("t_lie");
  ArrayList<String> t_lie  = (ArrayList)attribute.get("t_hang");
  ArrayList<String> lie_2  = (ArrayList)attribute.get("lie_2");
  ArrayList<String> T  = (ArrayList)attribute.get("T");
  ArrayList<String> pat_field  = (ArrayList)attribute.get("pat_field");
  int count = (Integer)attribute.get("count");
  int flag = (Integer)attribute.get("flag");
   ArrayList<String> data_attribute = (ArrayList)attribute.get("data_attribute");

 %>	

<body>

<!--LOGO+导航开始-->
<%@ include file="../ListHeader.jsp" %>

<!--导航结束-->  
<!--主体部分开始-->   
<div class="main">
    <div class="content">
         <h3 class="tit" style="border-bottom:2px solid #08b702; padding-bottom:5px; color:#08b702;"><span>T-Test-Analysis</span></h3>

		 
			<%if(flag==0){ %>	
			<div id="content" style="height:420px">
				<div><span class="Phenotypicstrongblack"><br />&nbsp;Can't build the infomation table ,</span></div>
				<div><span class="Phenotypicstrongblack"><br />&nbsp;Please return to check your input !</span></div></div>
		    <%}else{ %>
		 
					<div>
						<span class="Phenotypicstrongblack"><br />&nbsp;Materials-Positions:</span>
					</div>
					
					<div class="sel">
					 <div style="overflow:auto">
					<table cellpadding="0" cellspacing="0" width="100%" align="center" class="tab1" >
				        <tr bgcolor="#CFEEF8">	
				    	  <td  align="center">             </td> 
				      
				        	<%				    				        
								for(int i=0;i<t_hang.size();i++)
				            	{ 				           	       	         
		                %>
		                    	  <td  align="center"><%=t_hang.get(i)%></td> 
					   		 <% }%>
					   	</tr>	 
					   		 
					   		 
					   		 
					   		<%	
					   	    int j=0;			    				        
							for(int k=0;k<t_lie.size();k++)
				            { 	   	       	         
		                    %>  
		                    <tr> <td  align="center"><%=t_lie.get(k)%></td> 
					   	         <%				    				        
							     for(int i=0;i<t_hang.size();i++)
				                 { 	   	       	         
		                         %> 
		                         <td  align="center"><%=t_table.get(j)%></td>  
							     <%j++;
							     }
							 }%>
						 </tr> 
						  
					
				     
							 
						   
		           </table>
					</div>
					


					<div>
						<span class="Phenotypicstrongblack"><br />&nbsp;Materials-Traits:</span>
					</div> 

				<div style="overflow:auto;">

				<table cellpadding="0" cellspacing="0" width="100%" align="center" class="tab1" >
				        <tr bgcolor="#CFEEF8">	
				    	  <td  align="center">             </td> 
				      
				        	<%				    				        
								for(int i=0;i<pat_field.size();i++)
				            	{ 				           	       	         
		                %>
		                    	  <td  align="center"><%=pat_field.get(i)%></td> 
					   		 <% }%>
					   	</tr>	 
					   		 
					   		 
					   		 
					   		<%	
					   	    				        
							for(int k=0;k<t_hang.size();k++)
				            { 	   	       	         
		                    %>  
		                    <tr> <td  align="center"><%=t_hang.get(k)%></td> 
					   	         <%				    				        
							     for(int i=0;i<pat_field.size();i++)
				                 { 	   	       	         
		                         %> 
		                         <td  align="center"><%=data_attribute.get(k*pat_field.size()+i)%></td>  
							     <%
							     }
							 }%>
						 </tr> 
						  
					
				     
							 
						   
		           </table>
		           
		           </div>























					
					<div>
						<span class="Phenotypicstrongblack"><br />&nbsp;T-test:</span>
					</div> 

				<div style="overflow:auto;">

				<table cellpadding="0" cellspacing="0" width="100%" align="center" class="tab1" >
				        <tr bgcolor="#CFEEF8">	
				    	  <td  align="center">             </td> 
				      
				        	<%				    				        
								for(int i=0;i<pat_field.size();i++)
				            	{ 				           	       	         
		                %>
		                    	  <td  align="center"><%=pat_field.get(i)%></td> 
					   		 <% }%>
					   	</tr>	 
					   		 
					   		 
					   		 
					   		<%	
					   	    int jj=0;			    				        
							for(int k=0;k<lie_2.size();k++)
				            { 	   	       	         
		                    %>  
		                    <tr> <td  align="center"><%=lie_2.get(k)%></td> 
					   	         <%				    				        
							     for(int i=0;i<pat_field.size();i++)
				                 { 	   	       	         
		                         %> 
		                         <td  align="center"><%=T.get(jj)%></td>  
							     <%jj++;
							     }
							 }%>
						 </tr> 
						  
					
				     
							 
						   
		           </table>
		           
		           </div>
		           
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



