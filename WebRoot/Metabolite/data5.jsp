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

  <%
  Map attribute=ActionContext.getContext().getSession(); 
  ArrayList<String> data=(ArrayList<String>)attribute.get("data");
  int columnCount=(Integer)attribute.get("columnCount"); 

  %>



<body>

<!--LOGO+导航开始-->
<%@ include file="../ListHeader.jsp" %>

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
		           <a href="/maizego/file/Supplementary Data 5.xlsx" title="XLSX File"><img src="/maizego/images/down1.jpg" /></a>　　
				</div>
		 </div>
          <div style="clear:both"></div>
          <div style="overflow:auto;height:400px">
              <table cellpadding="0" cellspacing="0" width="100%" align="center" class="tab1" >
				   <tr bgcolor="#CFEEF8">	
				        <td align="center">NO</td>		
				        <td align="center">Experiment ID</td>		
				        <td align="center">Metabolite ID</td>	
				        <td align="center">Putative metabolite name</td>	
				        <td align="center">Lead SNP</td>
				        <td align="center">Chromosome</td>
				        <td align="center">Position (bp)</td>
				        <td align="center">Additional Candidate Gene List</td>
				       	          
				  </tr> 
				       <%				    				        
							for(int i=0;i<data.size()/columnCount;i++)
				            { 				          	         
		               %>
		                      <tr>

					           <%
					           //System.out.println(String.valueOf(seed.get(12*i)));
							for(int j=0;j<columnCount;j++)
				            { 	
				            %>
							    <td  align="center"><%=data.get(columnCount*i+j)%></td> 
							   
							  <% }}%>
						   </tr> 

			</table>
			
	<div >		
	<P>Supplementary Data 5: List of possible additional candidate genes within 100 kb flanking region of the lead SNPs in the loci significantly associated with metabolites that were identified or putatively annotated.</P>
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



