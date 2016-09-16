<%@ page contentType="text/html;charset=gbk" language="java" pageEncoding="UTF-8"%>
<%@ page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page import="org.hibernate.Session"%>
<%@ page import="java.util.*"%>
<%@ page import="org.db.phenotypes_294_rils_441_crosses.*"%>
<%@ page import="org.hibernate.HibernateException"%>
<%@ page import="org.hibernate.Session"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
  <title>MaizeGo DataMine Platform</title>

  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">
  <meta http-equiv="keywords" content="maize">
  <meta http-equiv="description" content="This is a database search engine of maize!">
  
  <link rel="stylesheet" href="../css/cb24.css" type="text/css"/>
  <link href="../css/bg.css" rel="stylesheet" type="text/css" />
  <link href="../css/link.css" rel="stylesheet" type="text/css" />
  <link href="../css/exhibition.css" rel="stylesheet" type="text/css" />
  <link href="../css/company.css" rel="stylesheet" type="text/css" />
  <link href="../css/employment.css" rel="stylesheet" type="text/css" />
  
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
			List<PhenotypesOf294Rils441Crosses> phenotypesrlist = new ArrayList<PhenotypesOf294Rils441Crosses>();					
			try
			{
				PhenotypesOf294Rils441CrossesDAO dao = new PhenotypesOf294Rils441CrossesDAO();
				phenotypesrlist=dao.findAll();
			
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
<!--导航结束-->  
<!--主体部分开始-->      
<div class="box">	
  <div class="span_24 padding_lr">
      <!--左分栏开始-->
    <div class="span_8 l_0">
     
      <div class="span_8 l_0 r_0 margin_tf">
        <div class="L2_bg padding_lr"><span class="black14">Search</span></div>
        <div class="L2_p padding_tf">
          <ul>
            <li><span>Genetic |</span>  <a href="#" class="Grand3">Genetic Data Search</a></li>
            <li><span>Genotypic |</span>  <a href="/maizego/Genotypic/genotypic.jsp" class="Grand3">Genotypic Data Search</a></li>
            <li><span>Expression |</span>  <a href="#" class="Grand3">Expression Data Search</a></li>
            <li><span>Phenotypic |</span>  <a href="/maizego/Phenotypic/phenotypic.jsp" class="Grand30">Phenotypic Data Search</a></li>

          </ul>
        </div>
        <div class="jiaob"></div>
      </div>
      <div class="span_8 l_0 r_0 margin_tf">
        <div class="L2_bg padding_lr"><span class="black14">Download</span>　　　　　　　　　　<a href="#" class="Grand6">More&gt;&gt;</a></div>
        <div class="L2_p padding_tf">
          <ul>
            <li><a href="#" class="Grand3">Genetic Resources</a></li>
            <li><a href="#" class="Grand3">Genotypic Data</a></li>
            <li><a href="#" class="Grand3">Expression data </a></li>
            <li><a href="#" class="Grand3">Phenotypic Data</a></li>
          </ul>
        </div>
        <div class="jiaob"></div>
      </div>
    </div> 
    
      <!--右分栏开始-->
    <div class="span_27 r_0"> 
        
        
      <div class="span_27 l_0 r_0 margin_tf"><!--这儿做一个左右切换,-->
        <div id="Jobs">
          <div id="Jobs_caption">
            <ul>
              <li class="b" onmousemove="secBoard('Jobs_caption','lab',1);">Specific Search</li>
              <li class="a" onmousemove="secBoard('Jobs_caption','lab',2);">Scope Search</li>
            </ul>
          </div>
          <div id="Jobs_content">
            <div class="b" id="lab_1">
	            <div>
	                  <form name="form" id="phenotypic"  method="post" action="phenotypicsearch.action">
	                    <span class="Phenotypicstrongblack">Type：</span>
	                      <select  class="selectlen" name="phenotypeicmenu" id="phenotypeicmenujumpMenu">
		                      <option>Search all types</option>
		                      <option>grainyield</option>
		                      <option>earlength</option>
		                      <option>kernelweight</option>
		                      <option>rownumber</option>
	                    </select>
	                  <span class="Grand9">(Please select the type) </span>
	                  
	                  <div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
	                  <span class="Phenotypicstrongblack">ID：</span>
	                      <select class="selectlen"  name="idmenu" id="idjumpMenu">
		                      <option>Search all ID</option>
		                      <% 
									for(PhenotypesOf294Rils441Crosses phecrosses:phenotypesrlist)
									{
							  %>
										<option><%=phecrosses.getId()%></option>
							  <%	}	
			
		                      %>
	
	                    </select>
	                  <span class="Grand9">(Please select the ID)</span> <span class="strongred"> <!--  OR input the specific ID：</span> <input type="text" name="textfield" id="textfield" />   -->
	                  </div>
	
	                  <div><input class="searchphenotypic" type="submit" value="search" style="width:80px;"> </div>
	                  </form>
	             </div>
            </div>
            
            <div class="a" id="lab_2">
              
               <div>
	                  <form name="form" id="phenotypic_scopesearch"  method="post" action="phenotypic_scopesearch.action">
	                    <span class="Phenotypicstrongblack">&nbsp;&nbsp;&nbsp;Type：</span>
	                      <select class="selectlen" name="scopephenotypicmenu" id="phenotypeicmenujumpMenu">     
		                      <option>grainyield</option>
		                      <option>earlength</option>
		                      <option>kernelweight</option>
		                      <option>rownumber</option>
	                    </select>
	                    <span class="Grand9">(Please select the type) </span>
	                  
	                    <div>
	                     <span class="Phenotypicstrongblack">&nbsp;Scope：</span>   
	                        <input class="textlen" type="text" name="starttextfield" id="textfield" />
	                        <span class="Grand9">---</span>
			                <input type="text" name="endtextfield" id="textfield" />
			                <span class="Grand9">(Please input the value)</span>
	                    </div>
	
	                  <div><input class="searchphenotypic" type="submit" value="search" style="width:80px;"> </div>
	                  </form>
	             </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  
 

<!--右分栏结束--> 
    </div>
</div>
<!--主体部结束--> 
<!--版权信息开始--> 
<div class="box">
  <div class="span_25 padding_lr">    
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
