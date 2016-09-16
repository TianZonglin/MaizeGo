<%@ page contentType="text/html;charset=gbk" language="java" pageEncoding="UTF-8"%>
<%@ page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page import="org.hibernate.Session"%>
<%@ page import="java.util.*"%>
<%@ page import="org.db.germplasmlines.*"%>
<%@ page import="org.hibernate.HibernateException"%>
<%@ page import="org.hibernate.Session"%>
<%@ page import="org.util.DbBean"%>
<%@ page import="java.sql.ResultSet"%>

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
			//Map attibutes = ActionContext.getContext().getSession();					
			List<Germplasmlines> germtypesrlist = new ArrayList<Germplasmlines>();
			DbBean db = new DbBean();
			ResultSet rrs = null;					
			
			try
			{
			    String sql="SELECT `Lines` FROM germplasmlines;";
				//PhenoypeAgriTraitsDAO dao = new PhenoypeAgriTraitsDAO();
				//phenotypesrlist=dao.findAll();
			    rrs = db.executeQuery(sql);
			
			} 
			catch (HibernateException e) 
			{
				System.err.println("Entity retrieval failed.");
				e.printStackTrace();
			} 
	  %>
	
	
</head>
  
<body>

<!--LOGO+导航开始-->
<%@ include file="../ListHeader.jsp" %>
<!--导航结束-->  
<!--主体部分开始-->      
<!--导航结束-->  
<!--主体部分开始-->   
<div class="main">   

          <div id="Jobs_caption">
            <ul>
              <li class="b" >Simple Search</li>
            </ul>
          </div>
          <div id="Jobs_content">
            
	            <div>
	                  <form name="form" id="phenotypic"  method="post" action="germsearch.action">
	                    <span class="Phenotypicstrongblack" >&nbsp;Type：</span>
	                      <select  class="select" name="germtypeicmenu" id="germtypeicmenujumpMenu">
		                      <option>Search all types</option>
		                      <option>SS</option>
		                      <option>NSS</option>
		                      <option>TST</option>
		                      <option>Pedigree</option>
		                      <option>Origin</option>
		                      <option>Subpopulations</option>
	                    </select>
	                  <span class="Grand9">(Please select the type) </span>
	                 
	                  <div> 
	                  <span class="Phenotypicstrongblack">Lines：</span>
	                      <select  class="select"  name="idmenu" id="idjumpMenu">
		                      <option>Search all Lines</option>
		                      <% 
									while (rrs.next())
									{
							  %>
										<option><%=rrs.getString("Lines")%></option>
							  <%	}	
			
		                      %>
	
	                    </select>
	                  <span class="Grand9">(Please select the Lines)</span>  <!--  OR input the specific ID：</span> <input type="text" name="textfield" id="textfield" />   -->
	                  </div>
	
	                  <div style="padding:5px 5px;"><input type="image" src="../images/button_08.jpg" height="35"width="130"/></div>
	                  </form>
	             </div>
            </div>
            
              
      
          </div>

<!--主体部结束--> 
<!--版权信息开始--> 
<%@ include file="../ListFooter.jsp" %>

</body>
</html>
