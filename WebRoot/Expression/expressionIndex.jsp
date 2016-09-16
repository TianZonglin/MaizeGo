
<%@ page contentType="text/html;charset=gbk" language="java" pageEncoding="UTF-8"%>

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
function blup(){
//alert("xxxxxxxxxxxxxxxxxxxxxxxx");
       document.forms.sForm1.action="by_qqnormed.action";
       document.forms.sForm1.submit();
       //alert("11111");
}
</script>


<style type="text/css">

.button1_search{
	background:url(/maizego/images/qqnormed.jpg);
	height: 36px;
	width: 149px;
	border-top-width: 0px;
	border-right-width: 0px;
	border-bottom-width: 0px;
	border-left-width: 0px;
	border-top-style: solid;
	border-right-style: solid;
	border-bottom-style: solid;
	border-left-style: solid;
	cursor:pointer;
}
</style>



</head>
  
<body>
<%@ include file="../ListHeader.jsp"%>
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
			              <li class="b">Transcriptome</li>

			            </ul>
			         </div>
				    <div id="Jobs_content" style="font-size:16px; padding-left:10px;height:580px">                                
				          <ul><!--
				            <li><span >Expression |</span>  <a href="#" class="Grand3">Expression Data</a></li>
				            <li><span >Expression |</span>  <a href="#" class="Grand3">Simple Search</a></li>
				          --></ul>   
				   
				      <br/>
				      <div style="font-size:12px">The expression values by RPKM normalization or further normal quantile transformation (Q-Q normed) could be either displayed and saved when a list &nbsp;&nbsp;of gene symbols provided.</div>
				       <br/>    
    
				      <span class="Phenotypicstrongblack">Input your search infomation:</span> <br/>
				      

				      <form id="sForm1" action="by_kmpl.action">
				      
				    <table cellpadding="0"  class="tab">				    
				    <tr>	
				    		   
				    		</div>	
				    		 		    	
						    <td><div id="test"> 
                            <span style="color:green">DataInput：</span> 
                            </div>					  						   					   
				            <textarea cellpadding="0" cellspacing="50" id="inputdata"  name="inputdata"  method="post"  style="height:300px;width:200px" ></textarea>
						    
						    <td><div id="test"> 
                            <span style="color:green">Example：</span> 
                            </div>						    
						    <textarea name="Note"  readonly="readonly" style="height:300px;width:140px"><%="GRMZM2G024563"+"\n"+
				      	    "GRMZM5G809265\n"+
					      	"GRMZM2G005155\n"+
					      	"GRMZM5G800734\n"+  
					      	"GRMZM2G467169\n"+ 
					      	"GRMZM2G158462\n"+  
					      	"GRMZM2G096184\n"+    
					      	"GRMZM2G159768\n"+ 
					      	"GRMZM2G140016\n"%>

						  </textarea></td>
				    </tr>
	    </table>	
				      
				      
				      
				      
				         	
					      	
					      	<!--
				          
				          <br/><span class="Phenotypicstrongblack">Please select the method:</span> --><br/>                
				          
				          <input   type="image"src="/maizego/images/rpkm.jpg" height="36"width="149"/>&nbsp;&nbsp;
                          <input  class="button1_search" type="button"  height="36"width="100" onclick="blup();"/>
				      			          
				      </form>
				                        
	                 </div>
	                 </div>
	             </div>
    
 
  
 

<!--右分栏结束--> 
    </div>
</div>
</div>
<!--主体部结束--> 
<!--版权信息开始--> 
<%@ include file="../ListFooter.jsp"%>                                           
<!--版权结束-->
</body>
</html>
