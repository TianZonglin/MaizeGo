<%@ page contentType="text/html;charset=gbk"  import="java.util.*"  language="java" pageEncoding="UTF-8"%>
<%@ page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page import="org.hibernate.HibernateException"%>
<%@ page import="org.hibernate.Session"%>
<%@ page import="org.db.phenotypes_294_rils_441_crosses.*"%>
<%@ page import="java.io.*" %> 

<%@ page import="org.util.DbBean" %> 

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
	
   function check()
   {  
     if(confirm("确定要删除吗？")){
           return true;
     }
     else { return false;}




   }	
	
	
</script>
  

</head>

<body>

<!--LOGO+导航开始-->

<%@ include file="../ListHeader.jsp" %>
  <%
    if(user==null)
  {
      response.sendRedirect("/maizego/");
      return;
      }
  Map attribute=ActionContext.getContext().getSession(); 
  ArrayList borrow=(ArrayList)attribute.get("borrow"); 
  DbBean db=new DbBean();
    ArrayList borrow1=new ArrayList();
    int p=0;
  for(int i=0;i<borrow.size();i++){
  	if(!borrow.get(i).equals("")){
  		borrow1.add(borrow.get(i));
  	}
  }
  
  
  %>
  

 
<!--导航结束-->  
<!--主体部分开始-->   
<div class="main">
   <div class="content">
         <div>
		 　　　　<div class="inser">
		           <select name="cata" style="border:2px solid #09b801; padding:7px 15px; position:relative; top:2px; color:#666;">
				       <option>CATEGORY</option>
					   <option>CATEGORY</option>
					   <option>CATEGORY</option>
				   </select>
				   <input type="text" value="SEARCH" onblur="this.style.color='#999';if (this.value == '') this.value = 'SEARCH';" onfocus="this.style.color='#666';this.value = ''" style="height:30px; border-top:2px solid #09b801; border-bottom:2px solid #09b801; color:#666; width:260px; line-height:30px; border-left:2px solid #09b801; text-indent:15px;" /><input type="image" src="/maizego/images/ingo.jpg" style="margin-left:-2px;" />
		        </div>
		 　　　　<div style=" float:right">
		           <a href="/maizego/Seed/borrow_csv.jsp" title="CSV File"><img src="/maizego/images/down1.jpg" /></a>　
		           <a href="/maizego/Seed/borrow_txt.jsp" title=" TXT File"><img src="/maizego/images/down2.jpg" /></a>　
		           <%if(type.equals("admin")){ %>
		           <a href="/maizego/Seed/borrow_add.jsp" title="Add"><img src="/maizego/images/del.jpg" /></a>
                 <%} %>
				</div>
		 </div>

  
     <div style="clear:both"></div>
      	  <div style="overflow:auto;height:400px">

                          <table cellpadding="0" cellspacing="0" width="100%" align="center" class="tab1">
				   <tr bgcolor="#CFEEF8">										    
                            <td width="220" align="center">ID</td>
						    <td width="180" align="center">BorrowTime</td>
						    <td width="180" align="center">Borrower</td>
						    <td width="180" align="center">Number</td>
						    <td width="180" align="center">BackTime</td><!--
						    <td width="180" align="center">BackNumber</td>
						    --><td width="180" align="center">BeforeNum</td>
						    <td width="180" align="center">AfterNum</td>						    
						    <td width="180" align="center">Type</td><!-- 
						    <td width="180" align="center">Notes</td>
						    --><td width="180" align="center">Population</td>
					<%if(type.equals("admin")){%>	
						    <td width="180" align="center">edit</td>	
						    <td width="180" align="center">delete</td>	
			         <%} %>				  
					   </tr>
				       <%				    				        
							for(int i=0;i<borrow1.size()/9;i++)
				            { 				          	         
		               %>
		                      <tr>
					       
					 
					           <%
					           //System.out.println(String.valueOf(borrow.get(12*i)));
							for(int j=0;j<9;j++)
				            { 				            	
				            %>					           
							    <td  align="center"><%=borrow1.get(9*i+j)%></td> 
							    <%
							  
							  }%>
							   
							  <% if(type.equals("admin")){%>
							   <td align="center"><a href="borrow_update.action?id=<%=borrow1.get(9*i)%>"><img src="/maizego/images/add.png" width="25px"/></a></td>
							   <td align="center"><a href="borrow_delete.action?id=<%=borrow1.get(9*i) %>" onclick="return check()"><img src="/maizego/images/e.jpg" width="25px"/></a></td>
							 <%} %>  
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



