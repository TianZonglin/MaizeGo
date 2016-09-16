<%@ page contentType="text/html;charset=gbk" language="java" pageEncoding="UTF-8"%>
<%@ page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page import="org.hibernate.Session"%>
<%@ page import="java.util.*"%>
<%@ page import="org.db.phenoype_agri_traits.*"%>
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
  
  
  
  
  
  
  
  
  
  
  
  
	<script type="text/javascript">
	function secBoard(elementID,listName,n) 
	{
		 var elem = document.getElementById(elementID);
		 var elemlist = elem.getElementsByTagName("li");
		 for (var i=0; i<elemlist.length; i++) 
		 {
			  elemlist[i].className = "a";
			  var m = i+1;
			  document.getElementById(listName+"_"+m).className = "a";
		 }
		  elemlist[n-1].className = "b";
		  document.getElementById(listName+"_"+n).className = "b";
	}
	</script>
	
	  <%
			//Map attibutes = ActionContext.getContext().getSession();					
			List<PhenoypeAgriTraits> phenotypesrlist = new ArrayList<PhenoypeAgriTraits>();
			DbBean db = new DbBean();
			ResultSet rrs = null;					
			
			try
			{
			    String sql="SELECT Trait FROM phenoype_agri_traits;";
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
<!--top开始-->

<!--LOGO+导航开始-->
<%@ include file="../ListHeader.jsp" %>
<!--导航结束-->  
<!--主体部分开始-->      
<!--导航结束-->  
<!--主体部分开始-->      
<div class="main">	
  <div class="span_24 padding_lr">
    <div class="span_27 r_0"> 
        
        
      <div class="span_27 l_0 r_0 margin_tf"><!--这儿做一个左右切换,-->
        <div id="Jobs">
          <div id="Jobs_caption">
            <ul>
              <li class="b" onmousemove="secBoard('Jobs_caption','lab',1);">Simple Search</li>
              <li class="a" onmousemove="secBoard('Jobs_caption','lab',2);" style="width:130px">Advanced Search</li>
            </ul>
          </div>
          <div id="Jobs_content">
            <div class="b" id="lab_1">
	            <div>
	                  <form name="form" id="phenotypic"  method="post" action="phenoagritraitssearch.action">
	                    <span class="Phenotypicstrongblack">&nbsp;Type：</span>
	                      <select  class="select" name="phenotypeicmenu" id="phenotypeicmenujumpMenu">
		                      <option>Search all types</option>
		                      <option>Plantheight</option>
		                      <option>Earheight</option>
		                      <option>Earleafwidth</option>
		                      <option>Earleaflength</option>
	                    </select>
	                  <span class="Grand9">(Please select the type) </span>
	                  
	                  <div> 
	                  <span class="Phenotypicstrongblack">Traits：</span>
	                      <select class="select"  name="idmenu" id="idjumpMenu">
		                      <option>Search all Trait</option>
		                      <% 
									while (rrs.next())
									{
							  %>
										<option><%=rrs.getString("Trait")%></option>
							  <%	}	
			
		                      %>
	
	                    </select>
	                  <span class="Grand9">(Please select the Trait)</span> <span class="strongred"> <!--  OR input the specific ID：</span> <input type="text" name="textfield" id="textfield" />   -->
	                  </div>
	
	                  <div style="padding:5px 5px;"><input  type="image" src="../images/button_08.jpg" height="36"width="100"/> </div>
	                  </form>
	             </div>
            </div>
            
            <div class="a" id="lab_2">
              
               <div>
	                  <form name="form" id="phenotypic_scopesearch"  method="post" action="phenoagritraits_scopesearch.action">
	                    <span class="Phenotypicstrongblack">&nbsp;&nbsp;&nbsp;Type：</span>
	                      <select class="select" name="scopephenotypicmenu" id="phenotypeicmenujumpMenu">     
		                      <option>Plantheight</option>
		                      <option>Earheight</option>
		                      <option>Earleafwidth</option>
		                      <option>Earleaflength</option>
	                    </select>
	                    <span class="Grand9">(Please select the type) </span>
	                  
	                    <div>
	                     <span class="Phenotypicstrongblack">&nbsp;Scope：</span>   
	                        <input class="input1" type="text" name="starttextfield" />
	                        <span>---</span>
			                <input type="text" name="endtextfield" class="input1"/>
			                <span class="Grand9">(Please input the value)</span>
	                    </div>
	
	                  <div style="padding:5px 5px;"><input  type="image" src="../images/button_08.jpg" height="36"width="100"/> </div> 
	                  </form>
	             </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  
    </div>
</div>
<!--主体部结束--> 
<!--版权信息开始--> 
<%@ include file="../ListFooter.jsp" %>
</body>
</html>
