<%@ page contentType="text/html;charset=gbk" language="java" pageEncoding="UTF-8"%>
<%@ page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page import="org.hibernate.Session"%>
<%@ page import="java.util.*"%>
<%@ page import="org.db.phenotypes_294_rils_441_crosses.*"%>
<%@ page import="org.db.chr1_merged_all_snp.*"%>

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
			DbBean db = new DbBean();
			ResultSet rrs = null;	
			//List<Chr1MergedAllSnp> chr1_merged = new ArrayList<Chr1MergedAllSnp>();					
			try
			{
			    String sql="SELECT rs FROM chr1_merged_all_snp;"; 
			    //rrs = db.executeQuery(sql);
				//Chr1MergedAllSnpDAO dao = new Chr1MergedAllSnpDAO();
				//chr1_merged=dao.findAll();
				//while (rrs.next()) 
			    //{
						//System.out.println("-------: "+rrs.getString("rs"));
							  
						//rrs.getString("rs")
				//}	
			
			} 
			catch (Exception e) 
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
<div class="main">	
          <div id="Jobs_caption">
            <ul>
              <li class="b" onmousemove="secBoard('Jobs_caption','lab',1);">Simple Search</li>
              <li class="a" onmousemove="secBoard('Jobs_caption','lab',2);"style="width:130px">Advanced Search</li>
            </ul>
          </div>
          <div id="Jobs_content">
            <div class="b" id="lab_1">
	            <div>

	                  <form name="form" id="genotypic"  method="post" action="genotypicsimplesearch.action">
	                   <span class="Phenotypicstrongblack">Chromosome：</span>
	                      <select  name="chromosomemenu" id="chromosomejumpMenu" class="select">
		                      <option>chromosome_1</option>
		                      <option>chromosome_2</option>
		                      <option>chromosome_3</option>
		                      <option>chromosome_4</option>
		                      <option>chromosome_5</option>
		                      <option>chromosome_6</option>
		                      <option>chromosome_7</option>
		                      <option>chromosome_8</option>
		                      <option>chromosome_9</option>
		                      <option>chromosome_10</option>           
	                    </select>
	                    <br/>
	                  <div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span class="Phenotypicstrongblack">Type：</span>
	                      <select name="simplegenotypicmenu" id="phenotypeicmenujumpMenu" class="select">
		                      <option>Search all types</option>
		                      <option>alleles</option>
		                      <option>chrom</option>
		                      <option>pos</option>
		                      <option>strand</option>
	                     </select>
	                     <span class="Grand9">(Please select the type) </span>
	                  </div> 
	                  <div>&nbsp;&nbsp;&nbsp; 
	                  
	                   <input type="checkbox" value="SelectAll" onclick="select_all()" checked/>&nbsp;
	                   <span class="Phenotypicstrongblack">All RS to be searched </span>  <span class="Grand9">Or input the specific RS:</span> <input type="text" name="specificrs"  class="input1"/> 
	                  
	                  <!-- 
	                  readonly="true"
	                      <select   name="rsmenu" id="rsjumpMenu">
		                      <option>Search all RS</option>
	                    </select>
	                    <td width="30" height="30" class="checkbox" align="center" valign="middle"><input type="checkbox" value="SelectAll" onclick="select_all()" /></td>
	                    
	                  <span class="Grand9">(Please select the ID)</span> <span class="strongred"> 
	                   
	                  <td width="30" height="30" class="checkbox" align="center" valign="middle">
	                  OR input the specific ID：</span> <input type="text" name="textfield" id="textfield" />   
	                  -->
	 
	                  
	                  </div>
	
	                  <div style="padding:5px 5px;"><input type="image" src="../images/button_08.jpg"height="36"width="130"/> </div>
	                  </form>
	             </div>
            </div>
            
            <div class="a" id="lab_2">
              
               <div>
	                  <form name="form" id="genotypic_scopesearch"  method="post" action="genotypic_scopesearch.action">
	                   <span class="Phenotypicstrongblack">Chromosome：</span>
	                      <select name="scopechromosomemenu" id="scope_chromosomejumpMenu" class="select">
		                      <option>chromosome_1</option>
		                      <option>chromosome_2</option>
		                      <option>chromosome_3</option>
		                      <option>chromosome_4</option>
		                      <option>chromosome_5</option>
		                      <option>chromosome_6</option>
		                      <option>chromosome_7</option>
		                      <option>chromosome_8</option>
		                      <option>chromosome_9</option>
		                      <option>chromosome_10</option>           
	                    </select>
	                    <div>
	                      <span class="Phenotypicstrongblack">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Type：</span>
	                        <select  class="select"    name="scopegenotypicmenu" id="scopegenotypiccmenujumpMenu">     
		                      <option>rs</option>
		                      <option>pos</option>
	                        </select>
	                    <span class="Grand9">(Please select the type) </span>
	                    </div>
	                    <div>
	                     <span class="Phenotypicstrongblack">&nbsp;Scope：</span>   
	                        <input type="text" name="starttextfield" id="textfield" class="input1" />
	                        <span class="Grand9">---</span>
			                <input type="text" name="endtextfield"  class="input1"/>
			                <span class="Grand9">(Please input the value)</span>
	                    </div>
	
	                   <div style="padding:5px 5px;"><input type="image" src="../images/button_08.jpg" height="36"width="130"/> </div>
	                  </form>
	             </div>
            </div>
          </div>
        </div>
<!--主体部结束--> 
<!--版权信息开始--> 
<%@ include file="../ListFooter.jsp" %>
</body>
</html>
