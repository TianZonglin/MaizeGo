<%@ page contentType="text/html;charset=gbk"  import="java.util.*"  language="java" pageEncoding="UTF-8"%>
<%@ page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page import="org.hibernate.HibernateException"%>
<%@ page import="org.hibernate.Session"%>
<%@ page import="org.db.metabolic_traits_zy.MetabolicTraitsZy"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
  <title>MaizeGo DataMine Platform</title>

  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">
  <meta http-equiv="keywords" content="maize">
  <meta http-equiv="description" content="This is a database search engine of maize!">
 

  <link href="css/bg.css" rel="stylesheet" type="text/css" />
  <link href="css/link.css" rel="stylesheet" type="text/css" />
  <link href="css/exhibition.css" rel="stylesheet" type="text/css" />
  <link rel="stylesheet" href="css/cb24.css" />
  <link href="css/company.css" rel="stylesheet" type="text/css" />
    
  <%
             Map attibutes = ActionContext.getContext().getSession();
             ArrayList<MetabolicTraitsZy> metabolictraintszy_list = (ArrayList<MetabolicTraitsZy>) attibutes.get("metabolictraintszy_list");
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
		<div class="LOGO"><span class="flaot_l"><img src="pic/header_maizego.jpg" width="935" height="85" /></span>
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
      <!--左分栏开始-->

    <div class="list_middle_right_content">
        <table width="920" border="0" cellspacing="1" cellpadding="1" bgcolor="#A9D9EF" style="text-align:center">
				   <tr bgcolor="#CFEEF8">
					    <td width="170" align="center">Experiment_1</td>
					    <td width="150" align="center">n0001</td>
					    <td width="150" align="center">n0002</td>
					    <td width="150" align="center">n0004</td>
					    <td width="150" align="center">n0005</td>
					    <td width="150" align="center">n0006</td>
				   </tr>
			       <%
						for(int i=0;i<metabolictraintszy_list.size();i++)
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
					    <td align="center"><%=metabolictraintszy_list.get(i).getExperiment1()%></td> 
						<td align="center"><%=metabolictraintszy_list.get(i).getN0001()%></td>
						<td align="center"><%=metabolictraintszy_list.get(i).getN0002()%></td>
						<td align="center"><%=metabolictraintszy_list.get(i).getN0004()%></td>
						<td align="center"><%=metabolictraintszy_list.get(i).getN0005()%></td>
						<td align="center"><%=metabolictraintszy_list.get(i).getN0006()%></td>
				   </tr> 
					   <%
					       }
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
      <div class="padding_tf"><img src="pic/foot.gif" width="940" height="5" /></div>
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
