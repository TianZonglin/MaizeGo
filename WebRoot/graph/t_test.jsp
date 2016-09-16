
<%@ page contentType="text/html;charset=gbk"  import="java.util.*"  language="java" pageEncoding="UTF-8"%>
<%@ page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page import="org.hibernate.HibernateException"%>
<%@ page import="org.hibernate.Session"%>
<%@ page import="java.io.*" %> 
<%@ page import="java.util.*"%>
<%@ page import="org.db.phenoype_agri_traits.*"%>
<%@ page import="org.util.DbBean"%>
<%@ page import="java.sql.ResultSet"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html >
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
   function check()
   {  alert("Error:the value of pos is illegal");
     if(confirm("确定要删除吗？")){
           return true;
     }
     else { return false;}
}	


function checkk(){
 
    var num1=$("#select1").val();  
    var num2=$("#select2").val();  
    var chos1=$("#choose1").val();  
    var chos2=$("#choose2").val();     
    
    if(isNaN(num1)||isNaN(num2)){
	   alert("Error: the type of pos is illegal !");
	   return false;
	}
	
	if(num2==""||num1==""||(num2<=num1)){
	   alert("Error: the value of pos is illegal !");
	   return false;
	}

	
	if(chos1==""||chos2==""){
	   alert("Please select the materials and traits !");
	   return false;
	}/*
	alert(num2);
	*/
	return true;
}	


 </script>










</head>

 <%
   Map attribute=ActionContext.getContext().getSession(); 
  //ArrayList<String> rs_select  = (ArrayList)attribute.get("rs1");
  ArrayList<String> rs_choose2 = (ArrayList)attribute.get("rs2");
   ArrayList<String> rs_choose1 = (ArrayList)attribute.get("choose1");
      //ArrayList<String> rs_choose1 = (ArrayList)attribute.get("choose1")
 // ArrayList<String>    choose1 = (ArrayList)attribute.get("choose1");
 
 
 %>	

<body>

<!--LOGO+导航开始-->
<%@ include file="../ListHeader.jsp" %>

<!--导航结束-->  
<!--主体部分开始-->   
<div class="main">
    <div class="content">
         <h3 class="tit" style="border-bottom:2px solid #08b702; padding-bottom:5px; color:#08b702;"><span>T-Test-analysis</span></h3>
         <div id="Jobs_content" style="height:535px">
             <form name="form1" method="post" action="t-test1.action" onsubmit="return checkk();">
                     
                      <br/>  
	                  <span class="Phenotypicstrongblack" >Chromosome:</span>
	                  <select id="chr" name="chr" class="input1">
						  <option value="1">chr1</option>
						  <option value="2">chr2</option>
						  <option value="3">chr3</option>
						  <option value="4">chr4</option>
						  <option value="5">chr5</option>
						  <option value="6">chr6</option>
						  <option value="7">chr7</option>
						  <option value="8">chr8</option>
						  <option value="9">chr9</option>
						  <option value="10">chr10</option>				  						  
                      </select>
 	                   <br/>  
 	                   <br/>  
               		 
               		 
               		 <span class="Phenotypicstrongblack">Start Position: </span> 
               		 <input name="select1" id="select1" style="width:150px" class="input1"/>
               		
				          
				      <span class="Phenotypicstrongblack"> End Position:  </span>
				      <input name="select2" id="select2" style="width:150px" class="input1"/>



	               <div style="font-size:12px"><span class="Grand9">&nbsp;&nbsp;&nbsp;&nbsp;(e.g: StartPosition 1000282, EndPosition 1000409)</span></td> </div>
					<div>
						<span class="Phenotypicstrongblack"><br />&nbsp;&nbsp;&nbsp;&nbsp;Please select the materials and traits:</span>
					</div>

					<div class="sel">	
					
			<table>			
					<tr>
					<td>
					 <span class="Phenotypicstrongblack" style="color: #08b702;vertical-align:bottom">&nbsp;&nbsp;</span>
					</td>	
			<td>						    
			<table   class="tab">				    
				    <tr>	
				    		   
				    		</div>	
				    		 		    	
						    <td>
						    <div id="test"> <span style="color:green">Materials：</span> </div>					  						   					   
				            <textarea cellpadding="0" cellspacing="50" id="choose1"  name="choose1"  method="post"  style="height:220px;width:120px" ></textarea>
						    <td>
						    <div id="test"> <span style="color:green">Example：</span> </div>						                                
						    <textarea name="Note"  readonly="readonly" style="height:220px;width:120px"><%=
						    rs_choose1.get(11)+"\n"+
						    rs_choose1.get(12)+"\n"+
						    rs_choose1.get(13)+"\n"+
						    rs_choose1.get(14)+"\n"+
						    rs_choose1.get(15)+"\n"+
						    rs_choose1.get(16)+"\n"+
						    rs_choose1.get(17)+"\n"+
						    rs_choose1.get(18)+"\n"+
						    rs_choose1.get(19)+"\n"+
						    rs_choose1.get(20)+"\n"+
						    rs_choose1.get(21)+"\n"+
						    rs_choose1.get(22)+"\n"%>
						    </textarea>
						   
						 
						    </td>
				    </tr>
	       </table>			
			<td>			
					
			<td>		
			 <span class="Phenotypicstrongblack" style="color: #08b702;vertical-align:bottom">&nbsp;&nbsp;</span>
			</td>	  
					    
			<td>			    
			<table   class="tab">				    
				    <tr>	
				    		   
				    		 <td>
						    <div id="test"> <span style="color:green">Traits：</span> </div>					  						   					   
				            <textarea cellpadding="0" cellspacing="50" id="choose2"  name="choose2"  method="post"  style="height:220px;width:140px" ></textarea>
						    </td>
						    <td>
						    <div id="test"> <span style="color:green">Example：</span> </div>						                                
						    <textarea name="Note"  readonly="readonly" style="height:220px;width:140px"><%=
						    rs_choose2.get(1)+"\n"+
						    rs_choose2.get(2)+"\n"+
						    rs_choose2.get(3)+"\n"+
						    rs_choose2.get(4)+"\n"+
						    rs_choose2.get(5)+"\n"+
						    rs_choose2.get(6)+"\n"+
						    rs_choose2.get(7)+"\n"+
						    rs_choose2.get(8)+"\n"+
						    rs_choose2.get(9)+"\n"+
						    rs_choose2.get(10)+"\n"+
						    rs_choose2.get(11)+"\n"+
						    rs_choose2.get(12)+"\n"%>
						    </textarea>
						    </td>
				    </tr>
	       </table>	
			</td>			
     </table>
					
					</div>
                  	 
                  		&nbsp;&nbsp;&nbsp;<input style="margin-top: 10px" type="image"src="/maizego/images/button_08.jpg" height="36"width="126" /> 
				</form>
				</div>
		          
		       
                 
      
      
     
    </div>
</div>	




<!--主体部结束--> 
<!--版权信息开始--> 
<%@ include file="../ListFooter.jsp" %>                                          
<!--版权结束-->

  </body>


</html>





 











