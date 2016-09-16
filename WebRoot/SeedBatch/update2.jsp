<%@ page contentType="text/html;charset=gbk"  import="java.util.*"  language="java" pageEncoding="UTF-8"%>
<%@ page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page import="java.io.*" %> 


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
	function check(){
	//alert("aaaaaaa");
	var string=document.getElementById("piliang").value;  
	if(string==""){
	   alert("Please input the borrow information !");
	   return false;
	}



	return true;
}	
</script>

  







</head>

<body>

<!--LOGO+导航开始-->
  <%@ include file="../ListHeader.jsp" %>
  <%
  Map attribute=ActionContext.getContext().getSession(); 
  ArrayList<String> field=(ArrayList)attribute.get("field");
  ArrayList seed=(ArrayList)attribute.get("seedlist");

  String table1 =(String)attribute.get("table");
    String table = table1.toUpperCase();
   System.out.println("------update2.jsp-----"+field);
  if(user==null){
  response.sendRedirect("/maizego/index.jsp");
  return;
  }
  %>
<!--导航结束-->  
<!--主体部分开始-->      
<div class="main">	
  <div class="span_24 padding_lr">
         <h3 class="tit" style="border-bottom:2px solid #08b702; padding-bottom:5px; color:#08b702;"><span>Population:<%=table.split("_")[1]%></span></h3>
         <div class="content">
    
  
	    <form action="update_result.action" onsubmit="return check();">
         
	    
	    
 		  <table cellpadding="0" cellspacing="50" width="600" align="center" class="tab">				    
				    <tr>	
				    		   
				    		</div>	
				    		 		    	
						    <td><div id="test"> 
                            <span style="color:green">DataInput：</span> 
                            </div>					  						   					   
						    <textarea id="piliang"  name="piliang"  method="post"  style="height:300px;width:320px"></textarea></td>
						    
						    <td><div id="test"> 
                            <span style="color:green">Example：</span> 
                            </div>						    
						    <textarea name="Note"  readonly="readonly" style="height:300px;width:320px"><%="11AMH0053 2"+"\n"
						    +"11YN1791 2"+"\n"
						    +"11AMH0072 1"+"\n"
						    +"11YN1277 2"+"\n"
						    +"11YN1797 1"+"\n"  
						    +"12RIL0192 1"+"\n"
						    +"11YN2084 2"+"\n"
						    +"11YN1968 2"+"\n"
						    +"11AMH0077 1"+"\n"
						    +"12AMP366 2"+"\n"
						    +"11YN1750 2"+"\n"
						    +"11YN1797 1"+"\n"
						    +"12RIL0003 1"+"\n"
						    %>
						  </textarea></td>
				    </tr>
	    </table>	
	    
	    
	       
	      
	
		 <div style="width:758px; text-align:right; margin-top:30px;"><input type="image" src="/maizego/images/button_10.jpg" /></div>	
			
			
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



