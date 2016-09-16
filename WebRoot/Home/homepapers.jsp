<%@ page contentType="text/html;charset=gbk"  import="java.util.*"  language="java" pageEncoding="UTF-8"%>
<%@ page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page import="org.hibernate.HibernateException"%>
<%@ page import="org.hibernate.Session"%>
<%@ page import="java.io.*" %> 



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
   {  
     if(confirm("确定要删除吗？")){
           return true;
     }
     else { return false;}




   }	
	
	
</script>

</head>





<body>

<!--LOGO+导航开始-->
<%@ include file="../ListHeader.jsp" %>

<!--导航结束-->  
<!--主体部分开始-->   
<div class="main">
   <div class="content">



          <div style="clear:both"></div>
<table><tr> </tr></table><table><tr> </tr></table>
                <span class="Phenotypicstrongblack" style="color: #08b702;vertical-align:bottom">Publications that are referenced  by MODEM</span>
                <table cellpadding="0" cellspacing="0" width="100%" align="center" class="tab1" style="ord-break:break-all;word-wrap:break-word; ">
				   <tr bgcolor="#CFEEF8">	
				   <td  align="center" width="5%">Number</td><td  align="center" width="35%">Authors</td><td  align="center" width="45%">Title</td><td  align="center" width="15%">Publish</td> </tr>
				   <tr>
				   <td  align="center" style="font-size:10px">01</td>
				   <td  align="center" style="font-size:10px">Wen WW, Li D, Li X, Gao YQ, Li WQ, Li HH, Liu J, Liu HJ, Chen W, Luo J & Yan JB.</td> 
				   <td  align="center" style="font-size:10px">Metabolome-based genome-wide association study of maize kernel leads to novel biochemical insights.</td> 
				   <td  align="center" style="font-size:10px">Nat Commun.,5: 3438.</td> 
				   </tr>
				   
				   
				   <tr>
				   <td  align="center" style="font-size:10px">02</td> 
				   <td  align="center" style="font-size:10px">Yang N, Lu YL, Yang XH, Huang J, Zhou Y, Ali F, Wen WW, Liu J, Li JS & Yan JB.</td> 
				   <td  align="center" style="font-size:10px">Genome Wide Association Studies Using a New Nonparametric Model Reveal the Genetic Architecture of 17 Agronomic Traits in an Enlarged Maize Association Panel.</td> 
				   <td  align="center" style="font-size:10px">Plos Genetics, 10(9): e1004573 2014</td>  
				   </tr>
				   
				  
				   <tr>
				   <td  align="center" style="font-size:10px">03</td> 
				   <td  align="center" style="font-size:10px">Fu JJ, Cheng YB, Linghu JJ, Yang XH, Kang L, Zhang ZX, Zhang J, He C, Du XM, Peng ZY, Wang B, Zhai LH, Dai CM,Xu JB, Wang WD,Li XR, Zheng J,Chen L, Luo LH, Liu JJ,Qian XJ, Yan JB, Wang J, Wang GY.</td> 
				   <td  align="center" style="font-size:10px">RNA sequencing reveals the complex regulatory network in the maize kernel.</td> 
				   <td  align="center" style="font-size:10px">Nat Commun.,4:2832</td>  
				   </tr>

				   <tr>
				   <td  align="center" style="font-size:10px">04</td> 
				   <td  align="center" style="font-size:10px">Li H, Peng ZY, Yang XH, Wang WD, Fu JJ, Wang JH, Han YJ, Chai YC, Guo TT, Yang N, Liu J, Warburton ML, Cheng YB, Hao XM, Zhang P, Zhao JY, Liu YJ, Wang GY, Li JS & Yan JB.</td> 
				   <td  align="center" style="font-size:10px">Genome-wide association study dissects the genetic architecture of oil biosynthesis in maize kernels.</td> 
				   <td  align="center" style="font-size:10px">Nature Genetics , 2012 DEC 17.</td>  
				   </tr>
		
				  <tr>
				   <td  align="center" style="font-size:10px">05</td>
				   <td  align="center" style="font-size:10px">Yan JB,Warburton M,Crouch J.</td> 
				   <td  align="center" style="font-size:10px">Association mapping for enhancing maize genetic improvement</td> 
				   <td  align="center" style="font-size:10px">Crop Science,2011,51:433-449</td> 
				   </tr>
				   
				   		   <tr>
				   <td  align="center" style="font-size:10px">06</td>
				   <td  align="center" style="font-size:10px">Wen WW, Araus JL, Shah T, Cairns J, Mahuku G, Bänziger M, Torres JL, Sánchez C, and Yan JB</td> 
				   <td  align="center" style="font-size:10px">Molecular Characterization of a Diverse Maize Inbred Line Collection and its Potential Utilization for Stress Tolerance Improvement</td> 
				   <td  align="center" style="font-size:10px">Crop Sciencedoi: 10.2135/cropsci2010.08.0465</td> 
				   </tr>
				   		   
				   		   <tr>
				   <td  align="center" style="font-size:10px">07</td>
				   <td  align="center" style="font-size:10px">Yang XH, Gao SB, Xu ST, Zhang ZX, Prasanna BM, Li L, Li JS, Yan JB</td> 
				   <td  align="center" style="font-size:10px">Characterization of a global germplasm collection and its potential utilization for analysis of complex quantitative traits in maize</td> 
				   <td  align="center" style="font-size:10px">Molecular Breeding,DOI 10.1007/s11032-010-9500-7</td> 
				   </tr>
				  
				  
			    </table>
	

    </div>
    
  
  </div>   

<!--主体部结束--> 
<!--版权信息开始--> 
<%@ include file="../ListFooter.jsp" %>                                          
<!--版权结束-->

  </body>


</html>



