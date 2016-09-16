
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
			var minpos=$("#minpos").val().trim(); 
		    var maxpos=$("#maxpos").val().trim();  
		   if(minpos.length==0||isNaN(minpos)||minpos.length>10||minpos<0){
		   		   
            alert("Maxpos or Minpos is not legal !");
          
            return false;            
                }else if(maxpos.length==0||isNaN(maxpos)||maxpos.length>10||parseInt(maxpos)<=parseInt(minpos)){
                alert("Minpos or Maxpos is illegal !");
                
                return false;
                }else{
                
                     return true;
                 }

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
			              <li class="b">HIF</li>
			            </ul>
			         </div>
			         
			         <div id="Jobs_content" style="font-size:16px; padding-left:10px;height:420px">

	                  <form name="form" id="phenotypic"  method="post" action="chromosome.action"  onsubmit="return check();">
	                  
	                  <span class="Phenotypicstrongblack">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Population：</span>
	               	   <select name="population" class="select">
						  <option value="hif_b73/by804">B73/BY804</option>
						  <option value="hif_by815/kui3">BY815/KUI3</option>
						  <option value="hif_d340/k22">D340/K22</option>
						  <option value="hif_de3/by815">DE3/BY815</option>
						  <option value="hif_k22/by815">K22/BY815</option>
						  <option value="hif_k22/ci7">K22/CI7</option>
						  <option value="hif_kui3/b77">KUI3/B77</option>
						  <option value="hif_kui3/sc55">KUI3/SC55</option>
						  <option value="hif_mo17/x26-4">MO17/X26-4</option>
						  <option value="hif_yu87-1/bk">Yu87-1/BK</option>		
						  <option value="hif_zheng58/sk">Zheng58/SK</option>	
						  <option value="hif_zong3/yu87-1">Zong3/Yu87-1</option>	  						  
                      </select>    
 	                   <br/>  	                  
	                  
	                  
	                  
	                  <span class="Phenotypicstrongblack">&nbsp;Chromosome：</span>
	                  <select name="chr" class="select">
						  <option value="1">Chr1</option>
						  <option value="2">Chr2</option>
						  <option value="3">Chr3</option>
						  <option value="4">Chr4</option>
						  <option value="5">Chr5</option>
						  <option value="6">Chr6</option>
						  <option value="7">Chr7</option>
						  <option value="8">Chr8</option>
						  <option value="9">Chr9</option>
						  <option value="10">Chr10</option>				  						  
                      </select>
 	                   <br/>  
                 
 	                   <span class="Phenotypicstrongblack">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Position：</span>
	                  <input id="minpos"  type="text" name="minpos" class="input1"/>
	                  <span class="Grand9">---------</span>
	                  <input  id="maxpos" type="text" name="maxpos"class="input1"/>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;                       
	                  <input style="margin-top: 5px" type="image"src="/maizego/images/button_08.jpg" height="36"width="130"/>
	                   <div style="font-size:12px"><span class="Grand9">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(e.g: 239225--3710656&nbsp;&nbsp;/&nbsp;&nbsp;462235--4956441)</span></td> </div>
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
