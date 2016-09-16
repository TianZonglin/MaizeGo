
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
  
  
  
  <link href="../css/search.css" rel="stylesheet" type="text/css" />
  <script language="javascript" type="text/javascript" src="../Script/search.js"></script> 
 <script language="javascript" type="text/javascript" src="http://g.wanfangdata.com.cn/share/Script/jquery-1.7.1.min.js"></script>
 
 
 
 
 
 
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
	
	
		function check(){
			var minpos=document.getElementById('minpos').value;//用户名
		    var maxpos=document.getElementById('maxpos').value;//用户名		    
		   if(minpos.length==0||isNaN(minpos)||minpos.length>10||minpos<0){
		   		   
            document.getElementById('tip').innerHTML='&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;minpos is not legal';
            document.form.minpos.focus();
            return false;            
                }else if(maxpos.length==0||isNaN(maxpos)||maxpos.length>10||parseInt(maxpos)<=parseInt(minpos)){
                document.getElementById('tip').innerHTML='&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;maxpos is illegal';
                document.form.maxpos.focus();
                return false;
                }else{
                
                     document.form.submit();
                 }

}
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
			DbBean db = new DbBean();
			ResultSet rrs = null;					
			
			try
			{
			    String sql=" select COLUMN_NAME from information_schema.`COLUMNS` WHERE TABLE_NAME='expression';";
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

<!--LOGO+导航开始-->
<%@ include file="../ListHeader.jsp" %>
      
<!--导航结束-->  
<!--主体部分开始-->      
<div class="main">	
 				<div id="Jobs">
                   	 <div id="Jobs_caption">
			            <ul>
			              <li class="b">Simple Search</li>
			            </ul>
			         </div>
			         <div >
				     <div id="Jobs_content" style="height:400px">
				    
	                  <form name="form" id="phenotypic"  method="post" action="expression.action" >
			             
		                   <table >
		                    <tr id="s1">
		                        <td ><input id="addqbtn" type="button" class="w-button1" onclick="javascript:addQueryCondition();"  /></td>
		                        <td ><input id="redqbtn" onclick="javascript:reduceQueryCondition();" class="w-button2" type="button" /></td>
		                        
		                        <td>
			                        <select name="sel"  class="select">
			                        <% while(rrs.next()){ %>		                        
					                      <option><%=rrs.getObject(1) %></option>
					                 <%} %>
			                        </select>
		                        </td>
		                    </tr>
		                     <tr id="s2">
		                        <td colspan="2">&nbsp;</td>
		                        <td> 
			                        <select name="sel"  class="select">
			                        <% rrs.beforeFirst();
			                        while(rrs.next()){ %>		                        
					                      <option><%=rrs.getObject(1) %></option>
					                 <%} %>
			                       </select>
			                     </td>
		                    </tr>
		                      <tr id="s3"style="display: none;">
		                        <td colspan="2">&nbsp;</td>
		                        <td>
		                          <select name="sel"  class="select">
		                          
			                        <%  rrs.beforeFirst();
			                        while(rrs.next()){ %>		                        
					                      <option><%=rrs.getObject(1) %></option>
					                 <%} %>
		                          
		                          </select>
		                          </td>		                        
		                    </tr>
		                    <tr id="s4" style="display: none;">
		                        <td colspan="2">&nbsp;</td>
		                        <td>
		                        <select name="sel"  class="select">
			                        <% rrs.beforeFirst();
			                         while(rrs.next()){ %>		                        
					                      <option><%=rrs.getObject(1) %></option>
					                 <%} %>		                        
		                        </select>
		                        </td>		                        
		                    </tr>
		                    <tr id="s5" style="display: none;">
		                        <td colspan="2">&nbsp;</td>
		                        <td>
		                        <select name="sel"  class="select">
			                        <%  rrs.beforeFirst();
			                        while(rrs.next()){ %>		                        
					                      <option><%=rrs.getObject(1) %></option>
					                 <%} %>		                        
		                        </select>
		                        </td>
		                       
		                    </tr>
		                    <tr id="s6" style="display: none;" >
		                        <td colspan="2">&nbsp;</td>
		                        <td>
		                        <select name="sel"  class="select">
			                        <%  rrs.beforeFirst();
			                        while(rrs.next()){ %>		                        
					                      <option><%=rrs.getObject(1) %></option>
					                 <%} %>		                        
		                        
		                        </select>
		                        </td>	                       
		                        <td>&nbsp;</td>
		                    </tr>
		                  </table>
		                  
		               
		                <div>
		                <input style="margin-top:5px;"type="image" src="../images/button_08.jpg" height="36"width="130" />	
		                </div> 
		                </form>              
	                  <div id="tip"></div>
                 </div>
	                 </div>
	             </div>
 
    </div>
<!--主体部结束--> 
<!--版权信息开始--> 
<%@ include file="../ListFooter.jsp" %>
</body>
</html>
