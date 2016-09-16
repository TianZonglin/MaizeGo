
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
<link href="/maizego/style.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="/maizego/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="/maizego/js/jquery.fancybox-1.3.4.js"></script>
<script type="text/javascript" src="/maizego/js/jquery.mousewheel-3.0.4.js"></script>
<link rel="stylesheet" type="text/css" href="/css/jquery.fancybox-1.3.4.css" media="screen" />
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
	function check(form){
	if(form=='1'){
			var minpos=document.getElementById('minpos1').value;//用户名
		    var maxpos=document.getElementById('maxpos1').value;//用户名		    
		   if(minpos.length==0||isNaN(minpos)||minpos.length>10||minpos<0){
		   		   
            document.getElementById('tip1').innerHTML='&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;minpos is not legal';
            document.form1.minpos1.focus();
            return false;            
                }else if(maxpos.length==0||isNaN(maxpos)||maxpos.length>10||parseInt(maxpos)<=parseInt(minpos)){
                document.getElementById('tip1').innerHTML='&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;maxpos is illegal';
                document.form1.maxpos1.focus();
                return false;
                }else{
                
                     document.form1.submit();
                 }
                 }
                 
       else if(form=='2'){
			var minpos=document.getElementById('minpos2').value;
		    var maxpos=document.getElementById('maxpos2').value;
		    var step=document.getElementById('step').value;	    
		   if(minpos.length==0||isNaN(minpos)||minpos.length>4||minpos<0){
		   		   
            document.getElementById('tip2').innerHTML='&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;minpos is not legal';
            document.form2.minpos2.focus();
            return false;            
                }else if(maxpos.length==0||isNaN(maxpos)||maxpos.length>4||parseInt(maxpos)<=parseInt(minpos)){
                document.getElementById('tip2').innerHTML='&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;maxpos is illegal';
                document.form2.maxpos2.focus();
                return false;
                }else if(step.length==0||isNaN(step)||step.length>4){
                document.getElementById('tip2').innerHTML='&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;step is illegal';
                document.form2.maxpos2.focus();
                return false;
                }else{
                
                     document.form2.submit();
                 }
                 }                 
                 
                 

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
<%@ include file="/ListHeader.jsp"%>
<!--导航结束-->  
<!--主体部分开始-->      
<!--导航结束-->  
<!--主体部分开始-->   
<div class="main">   
<div class="box">	
  <div class="span_24 padding_lr">
    
 
	           <div class="span_27 r_0"> 
	           <div id="Jobs">
                   	 <div id="Jobs_caption">
			            <ul>
			              <li class="b">Simple Search</li>

			            </ul>
			         </div>
				     <div id="Jobs_content">
				     
	                  <form name="form1" id="phenotypic"  method="post" action="tablesearch.action" onsubmit="return check('1');">
	                   <span class="Phenotypicstrongblack">&nbsp;Population：</span>
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
						  <option value="hif_yu8701/bk">Yu8701/BK</option>		
						  <option value="hif_zheng58/sk">Zheng58/SK</option>	
						  <option value="hif_zong3/yu8701">Zong3/Yu8701</option>	  						  
                      </select>    
                      <br/>
	                    <span class="Phenotypicstrongblack">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Position：</span>
	                    
	                  
	                  <input  id="minpos1" type="text" name="minpos1"  class="input1" />
	                  <span class="Grand9">---------</span>
	                   <input  id="maxpos1" type="text" name="maxpos1" class="input1"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    
	                   <input style="margin-top: 5px"type="image" src="/maizego/images/button_08.jpg" height="36"width="100" />
	                  <span id="tip1"></span>  
	                  </form>	
	                  
	                  
	                  <br/>
	                  <br/>
	                  <br/>
	                  
	                  <form name="form2" id="phenotypic"  method="post" action="chartDisplaysearch.action"onsubmit="return check('2');">
	                   <span class="Phenotypicstrongblack">&nbsp;Population：</span>
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
						  <option value="hif_yu8701/bk">Yu8701/BK</option>		
						  <option value="hif_zheng58/sk">Zheng58/SK</option>	
						  <option value="hif_zong3/yu8701">Zong3/Yu8701</option>  						  
                      </select>      
                      <br/>	                  
	                   <span class="Phenotypicstrongblack">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Position：</span>&nbsp;
	                  <input id="minpos2" type="text" name="minpos2"  class="input1" />
	                  <span class="Grand9">---------</span>	                
	                  <input id="maxpos2" type="text" name="maxpos2"  class="input1"/>
	                  <span  style="font-family:verdana">M</span>
	                  <span class="Phenotypicstrongblack">&nbsp;step：</span>	               
	                  <input id="step" type="text" name="step" class="input1"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;     
	                 <input type="image" align="top" src="/maizego/images/button_08.jpg" style="margin-top: 5px" height="36"width="100"/>   
	                  </form>
	                  <div id="tip2"></div>	                  
	                 </div>
	                 </div>
	             </div>
    
 
  
 

<!--右分栏结束--> 
    </div>
</div>
</div>
<!--主体部结束--> 
<!--版权信息开始--> 
<%@ include file="/ListFooter.jsp"%>                                           
<!--版权结束-->
</body>
</html>
