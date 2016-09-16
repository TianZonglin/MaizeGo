<%@ page contentType="text/html;charset=gbk"  import="java.util.*"  language="java" pageEncoding="UTF-8"%>
<%@ page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page import="org.hibernate.HibernateException"%>
<%@ page import="org.hibernate.Session"%>
<%@ page import="org.db.phenotypes_294_rils_441_crosses.*"%>
<%@ page import="java.io.*" %> 


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
  <title>MaizeGo DataMine Platform</title>

  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">
  <meta http-equiv="keywords" content="maize">
  <meta http-equiv="description" content="This is a database search engine of maize!">
 

  <link href="../css/bg.css" rel="stylesheet" type="text/css" />
  <link href="../css/link.css" rel="stylesheet" type="text/css" />
  <link href="../css/exhibition.css" rel="stylesheet" type="text/css" />
  <link rel="stylesheet" href="../css/cb24.css" />
  <link href="../css/company.css" rel="stylesheet" type="text/css" />
  <link href="../css/paul.css" rel="stylesheet" type="text/css" />
  
	<script type="text/javascript">
		function myf(fieldPath)
		{
		  var liu;
          window.open(fieldPath);
		  /* execCommand("SaveAs",false,"E:\aaa.txt") */
		  alert("5555555555555555))))");
		  /* window.open("e:/aaa.txt"); */
          return null;
		}
		
	</script>
	
  <script language="text/javascript">
    function downLoadField(fieldPath)
    {
        alert("dddddd");
        window.open(fieldPath);
        return null;
    }
    </script>

  <%
             Map attibutes = ActionContext.getContext().getSession();
             ArrayList<PhenotypesOf294Rils441Crosses> phenotypesofcrosses_list = (ArrayList<PhenotypesOf294Rils441Crosses>) attibutes.get("phenotypesofcrosses_list");
             double specificvalue=Double.parseDouble(attibutes.get("specificvalue").toString());
             String selectproperty=(String)attibutes.get("selectproperty");
             String phenotypeicmenu=(String)attibutes.get("phenotypeicmenu");
             String idmenu=(String)attibutes.get("idmenu");
             
  %>

</head>

<body>

<!--top开始-->
<div class="box">
  <div class="span_24 padding_lr">
    <div class="top ">
      <div class="flaot_l">Welcome to Maizego Datamine Platform！ </div>
      <div class="flaot_r"> Help | About | FAQ </div>
    </div>
  </div>
</div>
<!--LOGO+导航开始-->
<div class="box">
	<div class="span_24 padding_lr">
		<div class="LOGO"><span class="flaot_l"><img src="../pic/header_maizego.jpg" width="935" height="85" /></span>
	  </div>
	</div>
	<div class="span_24 padding_lr">
		  <div class="nav" >  <a href="/maizego"  class="White14">Home</a>　　<a href="/maizego" class="White14">Search</a>　　<a href="/maizego" class="White14">Download</a>　　<a href="/maizego" class="White14">Contact Us</a>　</div>
	</div>
	                           
</div>
<!--导航结束-->  
<!--主体部分开始-->      
<div class="box">	
  <div class="span_24 padding_lr">
      
      <div class="span_30">
      <div class="R">
        <div class="r1_bg">
          <h6>&nbsp;&nbsp;&nbsp;&nbsp; Export</h6>
          <div class="quick">
            <ul>
              <li> <a href="exportphenotypic_csv.jsp" class="blue12">CSV File</a></li>
            </ul>
            <ul>
              <li> <a href="exportphenotypic_txt.jsp" class="blue12">Text File</a></li>
            </ul>
          </div>
          <div>
          </div>
        </div>
      </div>
      
      <!-- href="#" onClick="myf()"          <a href="#" onClick="myf()">bbbbbbb</a>
      <button type="submit" value="submit"  class="file_button" onclick="javascript:exportcsvfile();"></button>
     
       <button type="submit" value="submit"  class="file_button" onclick="javascript:checkkuaidi100();"></button> 
      javascript:exportcsvfile();
        <div class="bnt_1"><a href="#" class="orange12">马上注册免费会员 &gt;&gt;</a></div>    -->
      

    <div class="list_middle_right_content">
        <table width="940" border="0" cellspacing="1" cellpadding="1" bgcolor="#A9D9EF" style="text-align:center">
				   <tr bgcolor="#CFEEF8">
				   <%
				        if(phenotypeicmenu.equals("Search all types"))
				        {
				   %>
						    <td width="220" align="center">ID</td>
						    <td width="180" align="center">grainyield</td>
						    <td width="180" align="center">earlength</td>
						    <td width="180" align="center">kernelweight</td>
						    <td width="180" align="center">rownumber</td>
					   </tr>
				       <%
							for(int i=0;i<phenotypesofcrosses_list.size();i++)
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
							    <td align="center"><%=phenotypesofcrosses_list.get(i).getId()%></td> 
								<td align="center"><%=phenotypesofcrosses_list.get(i).getGrainyield()%></td>
								<td align="center"><%=phenotypesofcrosses_list.get(i).getEarlength()%></td>
								<td align="center"><%=phenotypesofcrosses_list.get(i).getKernelweight()%></td>
								<td align="center"><%=phenotypesofcrosses_list.get(i).getRownumber()%></td>
						   </tr> 
					     <%
					       }//for 
					     }
					     else if(!phenotypeicmenu.equals("Search all types") && !idmenu.equals("Search all ID"))
					     {
					    %>
					             <td width="520" align="center">ID</td>
						         <td width="420" align="center"><%=selectproperty%></td>
					    </tr>
					    <tr bgcolor="#FFFFFF">
							     <td align="center"><%=idmenu%></td>
							     <td align="center"><%=specificvalue%></td>
				        </tr>
					    <%
					    }
					    else if(!phenotypeicmenu.equals("Search all types") && idmenu.equals("Search all ID"))
			            {
					    %>
					             <td width="520" align="center">ID</td>
						         <td width="420" align="center"><%=selectproperty%></td>
					   </tr>
					   <%
							for(int i=0;i<phenotypesofcrosses_list.size();i++)
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
					           <td align="center"><%=phenotypesofcrosses_list.get(i).getId()%></td> 
					           <%
					            if(phenotypeicmenu.equals("grainyield"))
							    {%>
							    	<td align="center"><%=phenotypesofcrosses_list.get(i).getGrainyield()%></td>
							  <%}
							    else if(phenotypeicmenu.equals("earlength"))
							    {%>
							    	<td align="center"><%=phenotypesofcrosses_list.get(i).getEarlength()%></td>
							  <%}
							    else if(phenotypeicmenu.equals("kernelweight"))
							    {%>
							    	<td align="center"><%=phenotypesofcrosses_list.get(i).getKernelweight()%></td>
							  <%}
							    else if(phenotypeicmenu.equals("rownumber"))
							    {%>
							    	<td align="center"><%=phenotypesofcrosses_list.get(i).getRownumber()%></td>
							  <%}%>
						   </tr> 
					     <%
					       }//for 
					  }//else
					  %>
			</table>

    </div>
    
  
  </div>   

<!--右分栏结束--> 
    </div>
</div>
<!--主体部结束--> 
<!--版权信息开始--> 
<div class="box">
  <div class="span_24 padding_lr">    
    <div class="foot">
      <div class="padding_tf"><img src="../pic/foot.gif" width="940" height="5" /></div>
  <!--  <p><a href="http://www.maizego.org/index.html" class="Grand6">About MaizeGo</a> | <a href="#" class="Grand6">联系我们</a></p>   -->    
        <p> Tel:+86-27-87280169　E-mail:<a href="#">heroalone2@gmail.com</a><br />
        Copyright reserved by Aruo &copy; 2013 &middot; Yan's lab <br />
      </p>
      <p></p>
    </div>
  </div>
</div>                                            
<!--版权结束-->
</body>


</html>



