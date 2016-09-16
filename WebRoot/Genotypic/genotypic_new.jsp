
<%@ page contentType="text/html;charset=gbk" language="java" pageEncoding="UTF-8"%>
<%@ page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page import="org.hibernate.Session"%>
<%@ page import="java.util.*"%>
<%@ page import="org.db.phenoype_agri_traits.*"%>
<%@ page import="org.hibernate.HibernateException"%>
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
</script>
  
	<script type="text/javascript">
	
	
		function check(){

	     var datainput =$("#genotypic").val().trim();
		 var selectt =$("#select11").val().trim(); 
		 if(datainput==""){	   		   
                alert("Please input your data !");
            return false;                     
          }
        
          
        return true;
}
	
	
	

	</script>
	

	
	
</head>
  
<body>
<!--LOGO+导航开始-->
<%@ include file="/ListHeader.jsp" %>
<!--导航结束-->  
<!--主体部分开始-->      
<!--导航结束-->  
<!--主体部分开始-->      
<div class="main">	

    

                   	 <div id="Jobs_caption">
			            <ul>
			              <li class="b">Genotype</li>
			            </ul>
			         </div>
			         
			         <div id="Jobs_content" style="font-size:16px; padding-left:10px;height:420px" onsubmit="return check();" >

	                  <form name="form" id="genotypic1"  method="post" action="genotypic_new.action"  >
	                  			    <p> </p>
  									<br/>
  									<div></div> 
  									
  					<!--  -->				
  									
	                  <span class="Phenotypicstrongblack">&nbsp;&nbsp;choose  the  way:</span>
	               	   <select name="select11" id="select11" class="select">
						  <option value="Gene_Symbols">Gene_Symbol</option>
						  <option value="Gene_Region">Gene_Region</option>
						    						  
                      </select> <br />  
                      
                       <span class="Phenotypicstrongblack">&nbsp;&nbsp;input  the  data:&nbsp;&nbsp;&nbsp;</span> 
       
	                  <input  id="genotypic" name="genotypic" class="inputlang" />  &nbsp;&nbsp;&nbsp;                      
	                  <input style="margin-top: 5px" type="image"src="/maizego/images/button_08.jpg" height="36"width="130"/>

	                  <br/><br/>
	                    <div style="font-size:14px"><span class="Grand9">&nbsp;&nbsp;&nbsp;&nbsp;(e.g. Gene_Symbol:&nbsp;[GRMZM2G374777]&nbsp;[GRMZM2G314660])</span></td> </div>
	                  	<div style="font-size:14px"><span class="Grand9">&nbsp;&nbsp;&nbsp;&nbsp;(e.g. Gene_Region:&nbsp;[chr1:100339360..10037221]&nbsp;[chr2:10000699..10383286]&nbsp;[chr3:100284394..100285501] )</span></td> </div>
	        
	                    
	                  </form>
	                  <div id="tip"></div>
 
	                 </div>
</div>
<!--主体部结束--> 
<!--版权信息开始--> 
<%@ include file="/ListFooter.jsp" %>                                           
<!--版权结束-->
</body>
</html>
