<%@ page contentType="text/html;charset=gbk"  import="java.util.*"  language="java" pageEncoding="UTF-8"%>
<%@ page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page import="org.hibernate.HibernateException"%>
<%@ page import="org.hibernate.Session"%>
<%@ page import="org.db.chr1_merged_all_snp.*"%>
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
             ArrayList<Chr1MergedAllSnp> genotypic_chr1_list = (ArrayList<Chr1MergedAllSnp>) attibutes.get("genotypic_chr1_list");

             String simplegenotypicmenu=(String)attibutes.get("simplegenotypicmenu");
             String specificrs=(String)attibutes.get("specificrs");
             String specificvalue=(String)attibutes.get("specificvalue");
             String selectproperty=(String)attibutes.get("selectproperty");
             
             
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
				   <input type="text" value="SEARCH" onblur="this.style.color='#999';if (this.value == '') this.value = 'SEARCH';" onfocus="this.style.color='#666';this.value = ''" style="height:30px; border-top:2px solid #09b801; border-bottom:2px solid #09b801; color:#666; width:260px; line-height:30px; border-left:2px solid #09b801; text-indent:15px;" /><input type="image" src="/maizego/images/ingo.jpg" style="margin-left:-2px;" />
		      	</div>	        
		 　　　　<div style=" float:right;">

		           <a href="/maizego/Seed/seed_csv.jsp" title="CSV File"><img src="/maizego/images/down1.jpg" /></a>　<a href="/maizego/Seed/seed_txt.jsp" title=" TXT File"><img src="/maizego/images/down2.jpg" /></a>　<%if(type!=null&&type.equals("admin")){ %><a href="/maizego/Seed/information_add.jsp" title="Add"><img src="/maizego/images/del.jpg" /></a>　<%} %>
				</div>
			 
		 </div>
          <div style="clear:both"></div>

        
	
		 

      
      <!-- href="#" onClick="myf()"          <a href="#" onClick="myf()">bbbbbbb</a>
      <button type="submit" value="submit"  class="file_button" onclick="javascript:exportcsvfile();"></button>
     
       <button type="submit" value="submit"  class="file_button" onclick="javascript:checkkuaidi100();"></button> 
      javascript:exportcsvfile();
        <div class="bnt_1"><a href="#" class="orange12">马上注册免费会员 &gt;&gt;</a></div>    -->
      
        <table cellpadding="0" cellspacing="0" width="100%" align="center" class="tab1">
				   <tr bgcolor="#CFEEF8">
				   <%
				        if(simplegenotypicmenu.equals("Search all types"))
				        {
				   %>
						    <td width="220" align="center">rs</td>
						    <td width="180" align="center">alleles</td>
						    <td width="180" align="center">chrom</td>
						    <td width="180" align="center">pos</td>
						    <td width="180" align="center">strand</td>
					   </tr>
				       <%
							for(int i=0;i<genotypic_chr1_list.size();i++)
				            { 
		               %>
		                  <tr>
							    <td align="center"><%=genotypic_chr1_list.get(i).getRs()%></td> 
								<td align="center"><%=genotypic_chr1_list.get(i).getAlleles()%></td>
								<td align="center"><%=genotypic_chr1_list.get(i).getChrom()%></td>
								<td align="center"><%=genotypic_chr1_list.get(i).getPos()%></td>
								<td align="center"><%=genotypic_chr1_list.get(i).getStrand()%></td>
						   </tr> 
					     <%
					       }//for 
					     }
					     else if(!simplegenotypicmenu.equals("Search all types") && !specificrs.equals(""))
					     {
					    %>
					             <td width="520" align="center">ID</td>
						         <td width="420" align="center"><%=selectproperty%></td>
					    </tr>
					    <tr bgcolor="#FFFFFF">
							     <td align="center"><%=specificrs%></td>
							     <td align="center"><%=specificvalue%></td>
				        </tr>
					    <%
					    }
					    else if(!simplegenotypicmenu.equals("Search all types") && specificrs.equals(""))
			            {
					    %>
					             <td width="520" align="center">ID</td>
						         <td width="420" align="center"><%=selectproperty%></td>
					   </tr>
					   <%
							for(int i=0;i<genotypic_chr1_list.size();i++)
				            { 
		               %>
		                       <%
					            if(i%2==0)
					            {
					            %>
					        <tr bgcolor="#FFFFFF">
					            <%
					            }
					            else
					            { %>
					        <tr bgcolor="#CFEEF8">
					           <%}%>
					           <td align="center"><%=genotypic_chr1_list.get(i).getRs()%></td> 
					           <%
					            if(simplegenotypicmenu.equals("alleles"))
							    {%>
							    	<td align="center"><%=genotypic_chr1_list.get(i).getAlleles()%></td>
							  <%}
							    else if(simplegenotypicmenu.equals("chrom"))
							    {%>
							    	<td align="center"><%=genotypic_chr1_list.get(i).getChrom()%></td>
							  <%}
							    else if(simplegenotypicmenu.equals("pos"))
							    {%>
							    	<td align="center"><%=genotypic_chr1_list.get(i).getPos()%></td>
							  <%}
							    else if(simplegenotypicmenu.equals("strand"))
							    {%>
							    	<td align="center"><%=genotypic_chr1_list.get(i).getStrand()%></td>
							  <%}%>
						   </tr> 
					     <%
					       }//for 
					  }//else
					  %>
			</table>

    </div>
    </div>    
  
  </div>   

<!--右分栏结束--> 
    </div>
</div>
<!--主体部结束--> 
<!--版权信息开始--> 
<%@ include file="../ListFooter.jsp" %>                                           
<!--版权结束-->
</body>


</html>



