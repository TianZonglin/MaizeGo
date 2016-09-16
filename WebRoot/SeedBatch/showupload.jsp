<%@ page contentType="text/html;charset=gbk"  import="java.util.*"  language="java" pageEncoding="UTF-8"%>
<%@ page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page import="org.hibernate.HibernateException"%>
<%@ page import="org.hibernate.Session"%>
<%@ page import="java.io.*" %> 



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


</head>

  <%
  Map attribute=ActionContext.getContext().getSession(); 
  ArrayList<String> field=(ArrayList)attribute.get("field");
  ArrayList seed=(ArrayList)attribute.get("seed"); 
  String tablename=(String)attribute.get("tablename"); 
  attribute.put("tablename", tablename);
 //System.out.println("aaaaaaaaaaaasdasfadsfadsfdsafdsa"+tablename);
  ArrayList<Integer> num=new ArrayList();
  %>



<body>

<!--LOGO+导航开始-->
<%@ include file="../ListHeader.jsp" %>

<!--导航结束-->  
<!--主体部分开始-->   
<div class="main">
   <div class="content">

          <div style="clear:both"></div>
          <div style="overflow:auto;height:400px">
          
          <span class="Phenotypicstrongblack">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Uploaded table：</span>
		          <input id="minpos"  type="text"  readonly="readonly" name="table" class="input1" value="<%=tablename%>" />       
              <table cellpadding="0" cellspacing="0" width="100%" align="center" class="tab1" style="ord-break:break-all;word-wrap:break-word; ">
				   <tr bgcolor="#CFEEF8">	
				          <% for(int i=0;i<field.size()-1;i++){			          
				          if(field.get(i).endsWith("NUMBER"))
				          {
				             num.add(i);
				             }
				          
				          %> 								    
                              <td  style="overflow: hidden;white-space: nowrap;text-overflow: ellipsis;" align="center"><%=field.get(i) %></td>
			               <%} 
			               
			               attribute.put("num",num);

			               %>					    			  
					   </tr>
				       <%				    				        
							for(int i=0;i<seed.size()/field.size();i++)
				            { 				          	         
		               %>
		                      <tr>
					        <td align="center"><a href="update.action?id=<%=seed.get(field.size()*i)%>"><%=seed.get(field.size()*i)%></a></td>
					 
					           <%
					           //System.out.println(String.valueOf(seed.get(12*i)));
							for(int j=1;j<field.size()-1;j++)
				            { 	
				               // System.out.println(seed.get(field.size()*i+j));
				                if(num.contains(j)&&Integer.parseInt((String)seed.get(field.size()*i+j))<30)
				                {				                  
				            %>
				                <td  align="center" style="color:red;font-size:20px"><%=seed.get(field.size()*i+j)%></td> 
				                <%} else{%>
				 
							    <td  align="center"><%=seed.get(field.size()*i+j)%></td> 
							   
							  <% }}%>
						   </tr> 
					     <%
					       }//for 
					  %>

			</table>
			</div>

    </div>
    
  
  </div>   

<!--主体部结束--> 
<!--版权信息开始--> 
<%@ include file="../ListFooter.jsp" %>                                          
<!--版权结束-->

  </body>


</html>



