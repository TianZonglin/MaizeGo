<%@ page contentType="text/html;charset=gbk"  import="java.util.*"  language="java" pageEncoding="UTF-8"%>
<%@ page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page import="org.hibernate.HibernateException"%>
<%@ page import="org.hibernate.Session"%>
<%@ page import="org.db.chr1_merged_all_snp.*"%>
<%@ page import="java.io.*" %> 
<%@ page import="java.lang.reflect.Field" %>
<%@ page import="java.lang.StringBuilder" %>

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
</script>
  

  <%
             Map attribute = ActionContext.getContext().getSession();
             List<Chr1MergedAllSnp> genotypic_chr1_list = (List<Chr1MergedAllSnp>) attribute.get("list");
             
            int currentpage=(Integer)attribute.get("currentpage");
            long total=(Long)attribute.get("total");
          
             
  %>

</head>
  
 
  
  
<body>

<!--LOGO+导航开始-->
<%@ include file="../ListHeader.jsp" %>
<!--导航结束-->  
<!--主体部分开始-->      
<div class="main">	
        <div>
		 　　　　<div class="inser">
		           <select name="cata" style="border:2px solid #09b801; padding:7px 15px; position:relative; top:2px; color:#666;">
				       <option>CATEGORY</option>
					   <option>CATEGORY</option>
					   <option>CATEGORY</option>
				   </select>
				   <input type="text" value="SEARCH" onblur="this.style.color='#999';if (this.value == '') this.value = 'SEARCH';" onfocus="this.style.color='#666';this.value = ''" style="height:30px; border-top:2px solid #09b801; border-bottom:2px solid #09b801; color:#666; width:260px; line-height:30px; border-left:2px solid #09b801; text-indent:15px;" /><input type="image" src="../images/ingo.jpg" style="margin-left:-2px;" />
		        </div>
		 　　　　<div style=" float:right">
		           <a href="exportgenotypic_csv.jsp" title="CSV File"><img src="../images/down1.jpg" /></a>　<a href="exportgenotypic_txt.jsp" title=" TXT File"><img src="../images/down2.jpg" /></a>　
				</div>
		 </div>
		 <div style="clear:both"></div>
      <div style="overflow:auto;height:500px">
        <table cellpadding="0" cellspacing="0" width="100%" align="center" class="tab1">
				   <tr bgcolor="#CFEEF8">
				   <%
				   Field[] field = genotypic_chr1_list.get(0).getClass().getDeclaredFields(); 
				   for(int i=0;i<field.length;i++){
				   if(field[i].getName().startsWith("maize")){
				   %>
						    <td width="220" align="center"><%=field[i].getName().substring(5).toUpperCase() %></td>
						    <%} else{%>
                         <td width="220" align="center"><%=field[i].getName().toUpperCase()%></td>
                         <%}} %>
					   </tr>
				       <%
							for(int i=0;i<genotypic_chr1_list.size();i++)
				            { 
				           // System.out.println(genotypic_chr1_list.get(i).getClass().getDeclaredFields());
				   

							
		               %>
					         <tr>
					         <% for(int j=0;j<field.length;j++)  {
					         
					         String name= field[j].getName();
				            StringBuilder sb = new StringBuilder(name);
							sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
							name = sb.toString();
					         
					         
					         
					         %>
							    <td align="center"><%=(String)genotypic_chr1_list.get(i).getClass().getMethod("get"+name).invoke(genotypic_chr1_list.get(i))%></td> 
                             <%} %>
						   </tr> 
					     <%
					     
					       }//for 
					    %>
			</table>
     </div>
     <form action="genotypic.action">
	   <table cellpadding="0" cellspacing="0" width="100%" style="margin-top:20px;">
	    <td align="right">
	       <span><a href="genotypic.action?page=0"><img src="../images/first.jpg" /></a></span>
	      <%if(currentpage!=0){ %> 
	       <span><a href="genotypic.action?page=<%=currentpage-1 %>"><img src="../images/pre.jpg" /></a></span>　
	       <%}else{ %>
	        <span><img src="../images/pre.jpg" /></span>　
	        <%} %>
	       <span style="position:relative; bottom:5px; font-size:16px;">Page 
	       <input type="text" name="page" style="border:2px solid #09b801; position:relative;width:40px"/>
	       <span><%=currentpage+1 %>/<%=total+1 %></span>
	    <!--    <select name="cata" style="border:2px solid #09b801; position:relative">
				       <option>1</option>
					   <option>2</option>
					   <option>3</option>
				   </select>--> 
				   </span>　
				  <span > <input type="image" src="../img/go.jpg" style="height:22px;margin-bottom:12px;margin-right:10px"/></span>
				   <%if(currentpage<total) {%>
		<span><a href="genotypic.action?page=<%=currentpage+1 %>"><img src="../images/next.jpg" /></a></span>
	<%}else{%>
	<span><img src="../images/next.jpg" /></span>
	<%} %>
	 <span><a href="genotypic.action?page=<%=total%>"><img src="../images/last.jpg" /></a></span></td>
	 </table>
	</form>     
     
     
     
    </div>
    
<!--主体部结束--> 
<!--版权信息开始--> 
<%@ include file="../ListFooter.jsp" %>
</body>


</html>



