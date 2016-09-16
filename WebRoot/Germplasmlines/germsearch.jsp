<%@ page contentType="text/html;charset=gbk"  import="java.util.*"  language="java" pageEncoding="UTF-8"%>
<%@ page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page import="org.hibernate.HibernateException"%>
<%@ page import="org.hibernate.Session"%>
<%@ page import="org.db.germplasmlines.*"%>
<%@ page import="java.io.*" %> 


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
  <title>MaizeGo DataMine Platform</title>

  <meta http-equiv="pragma" content="no-cache"/>
  <meta http-equiv="cache-control" content="no-cache"/>
  <meta http-equiv="expires" content="0"/>
  <meta http-equiv="keywords" content="maize"/>
  <meta http-equiv="description" content="This is a database search engine of maize!"/>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

 

  
  
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
             Map attibutes = ActionContext.getContext().getSession();
             ArrayList<Germplasmlines> germtypesofcrosses_list = (ArrayList<Germplasmlines>) attibutes.get("germtypesofcrosses_list");
             String specificvalue=(String)attibutes.get("specificvalue");
             String selectproperty=(String)attibutes.get("selectproperty");
             String germtypeicmenu=(String)attibutes.get("germtypeicmenu");
             String idmenu=(String)attibutes.get("idmenu");
             
  %>

</head>

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
				   <input type="text" value="SEARCH" onblur="this.style.color='#999';if (this.value == '') this.value = 'SEARCH';" onfocus="this.style.color='#666';this.value = ''" style="height:30px; border-top:2px solid #09b801; border-bottom:2px solid #09b801; color:#666; width:260px; line-height:30px; border-left:2px solid #09b801; text-indent:15px;" /><input type="image" src="../images/ingo.jpg" style="margin-left:-2px;" />
		        </div>
		 　　　　<div style=" float:right">
		           <a href="exportgerm_csv.jsp" title="CSV File"><img src="../images/down1.jpg" /></a>　<a href="exportgerm_txt.jsp" title=" TXT File"><img src="../images/down2.jpg" /></a>　
				</div>
		 </div>
		 <div style="clear:both"></div>
        <form name="feed" method="post" action="">
       <table cellpadding="0" cellspacing="0" width="100%" align="center" class="tab1">
				   <tr bgcolor="#CFEEF8">
				   <%
				        if(germtypeicmenu.equals("Search all types"))
				        {
				   %>
						    <td width="120" align="center">Lines</td>
						    <td width="120" align="center">SS</td>
						    <td width="120" align="center">NSS</td>
						    <td width="120" align="center">TST</td>
						    <td width="120" align="center">Pedigree</td>
						    <td width="120" align="center">Origin</td>
						    <td width="120" align="center">Subpopulations</td>
					   </tr>
				       <%
							for(int i=0;i<germtypesofcrosses_list.size();i++)
				            { 
		               %>
		
	                        <tr>
							    <td align="center"><a href="../Phenotypic/phenoagritraitsadvance.jsp?trait=<%=germtypesofcrosses_list.get(i).getLines()%>"><%=germtypesofcrosses_list.get(i).getLines()%></a></td> 
								<td align="center"><%=germtypesofcrosses_list.get(i).getSs()%></td>
								<td align="center"><%=germtypesofcrosses_list.get(i).getNss()%></td>
								<td align="center"><%=germtypesofcrosses_list.get(i).getTst()%></td>
								<td align="center"><%=germtypesofcrosses_list.get(i).getPedigree()%></td>
								<td align="center"><%=germtypesofcrosses_list.get(i).getOrigin()%></td>
								<td align="center"><%=germtypesofcrosses_list.get(i).getSubpopulations()%></td>
						   </tr> 
					     <%
					       }//for 
					     }
					     else if(!germtypeicmenu.equals("Search all types") && !idmenu.equals("Search all Lines"))
					     {
					    %>
					    <tr bgcolor="#CFEEF8">
					             <td >Lines</td>
						         <td ><%=selectproperty%></td>
					    </tr>
					    <tr>
							     <td ><%=idmenu%></td>
							     <td ><%=specificvalue%></td>
				        </tr>
					    <%
					    }
					    else if(!germtypeicmenu.equals("Search all types") && idmenu.equals("Search all Lines"))
			            {
					    %>
					    <tr bgcolor="#CFEEF8">
					             <td >Lines</td>
						         <td ><%=selectproperty%></td>
					    </tr>
					   <%
							for(int i=0;i<germtypesofcrosses_list.size();i++)
				            { 
		               %>
		                     <tr>
					           <td ><%=germtypesofcrosses_list.get(i).getLines()%></td> 
					           <%
					            if(germtypeicmenu.equals("SS"))
							    {%>
							    	<td><%=germtypesofcrosses_list.get(i).getSs()%></td>
							  <%}
							    else if(germtypeicmenu.equals("NSS"))
							    {%>
							    	<td ><%=germtypesofcrosses_list.get(i).getNss()%></td>
							  <%}
							    else if(germtypeicmenu.equals("TST"))
							    {%>
							    	<td ><%=germtypesofcrosses_list.get(i).getTst()%></td>
							  <%}
							    else if(germtypeicmenu.equals("Pedigree"))
							    {%>
                                    <td ><%=germtypesofcrosses_list.get(i).getPedigree()%></td> 
					           <%}
					            else if(germtypeicmenu.equals("Origin"))
							    {
							    %>
							    	<td ><%=germtypesofcrosses_list.get(i).getOrigin()%></td>
							  <%}
							    else if(germtypeicmenu.equals("Subpopulations"))
							    {%>
							    	<td ><%=germtypesofcrosses_list.get(i).getSubpopulations()%></td>
							  <%}%>
						   </tr> 
					     <%
					       }//for 
					  }//else
					  %>

	   </table>
	   <table cellpadding="0" cellspacing="0" width="100%" style="margin-top:20px;"><td align="right"><span><a href="#"><img src="../images/first.jpg" /></a></span> <span><a href="#"><img src="../images/pre.jpg" /></a></span>　<span style="position:relative; bottom:5px; font-size:16px;">Page <select name="cata" style="border:2px solid #09b801; position:relative">
				       <option>1</option>
					   <option>2</option>
					   <option>3</option>
				   </select></span>　<span><a href="#"><img src="../images/next.jpg" /></a></span> <span><a href="#"><img src="../images/last.jpg" /></a></span></td></table>
	</form>
   </div>
</div>

<!--主体部结束--> 
<!--版权信息开始--> 
<%@ include file="../ListFooter.jsp" %>

</body>
</html>


