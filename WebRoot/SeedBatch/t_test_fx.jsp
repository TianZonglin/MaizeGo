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
  String select_1  = (String)attribute.get("select_1");
  String select_2  = (String)attribute.get("select_2");
  System.out.println("-------"+select_1+"---------"+select_2+"-------");
  ArrayList<String> t_table = (ArrayList)attribute.get("t_table");
  ArrayList<String> t_hang = (ArrayList)attribute.get("t_lie");
  ArrayList<String> t_lie  = (ArrayList)attribute.get("t_hang");
  ArrayList<String> lie_2  = (ArrayList)attribute.get("lie_2");
   ArrayList<String> T  = (ArrayList)attribute.get("T");
    ArrayList<String> pat_field  = (ArrayList)attribute.get("pat_field");
  int count = (Integer)attribute.get("count");
  System.out.println("qqqqqqqqqqqqqqqqqqq-------"+t_hang.size()+"------------"+t_lie.size()+"-------------------------------------------"+count+"-----------");

    //System.out.println("6666666666666"+rs_select.get(1) +"66666666666666");
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
               
             
               		 <span class="Phenotypicstrongblack">POS起始点*  </span>
				          <select class="select" name="select1" style="width:150px">
				       
				          <option style="width:150px"><%=select_1%></option>
				       
				          </select>
				      <span class="Phenotypicstrongblack">    POS终点*  </span>
				          <select class="select" name="select2" style="width:150px">
				           
				          <option style="width:150px"><%=select_2%></option>
				     
				          </select><!--
					 
           <div id="Jobs_content" style="font-size: 16px; padding-left: 5px; height: 300px; width:931px">
                    
					--><div>
						<span class="Phenotypicstrongblack"><br />&nbsp;结果1:</span><span class="Grand9">(对照表:)</span>
					</div>
					
					<div class="sel">
					 <div style="overflow:auto;height:400px">
					<table cellpadding="0" cellspacing="0" width="100%" align="center" class="tab1" >
				        <tr>	
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
						<span class="Phenotypicstrongblack"><br />&nbsp;结果2:</span><span class="Grand9">(T值分析:)</span>
					</div> 

				<div style="overflow:auto;height:400px">

				<table cellpadding="0" cellspacing="0" width="100%" align="center" class="tab1" >
				        <tr>	
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
		 
			</div>
		             
      </div>
</div>	




<!--主体部结束--> 
<!--版权信息开始--> 
<%@ include file="../ListFooter.jsp" %>                                          
<!--版权结束-->

  </body>


</html>



