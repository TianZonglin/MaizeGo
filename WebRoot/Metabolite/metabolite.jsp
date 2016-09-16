
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
<link href="../style.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="../js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="../js/jquery.fancybox-1.3.4.js"></script>
<script type="text/javascript" src="../js/jquery.mousewheel-3.0.4.js"></script>
<link rel="stylesheet" type="text/css" href="../css/jquery.fancybox-1.3.4.css" media="screen" />
<script type="text/javascript" src="../js/autoComplete.js"></script>
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
  function check1()
{ 
	var trait=$("#trait1").val();//用户名
	var word=$("#word").val();//用户名
 
   if(trait=="Please select the compound" && word=="")
   {
     alert("Error: Please use the correct compound !");
     return false;
   }
   
  return true;
 }	
 </script>


<script type="text/javascript">
function checkdata(){
var tra=$("#trait1").val();
var wor=$("#word").val();
var all_op=document.getElementById("trait1").options;
if(tra!="Please select the compound"){
   document.getElementById("word").value=null; 
}
}
 </script>
 
 <script type="text/javascript">
function checkdata2(){
var tra=$("#trait1").val();
var wor=$("#word").val();
var all_op=document.getElementById("trait1").options;
if(wor!=null){
 all_op[0].selected=true;
  }
}
 </script>
<%
DbBean db=new DbBean();
String sql="select `Peak NO.`,`Putative metabolite name` from `supplementary data 2`;";
ResultSet rs=db.executeQuery(sql);
 %>	
 
 
  
 
</head>
  
<body>
<!--LOGO+导航开始-->
<%@ include file="../ListHeader.jsp" %>
<!--导航结束-->  
<!--主体部分开始-->      
<!--导航结束-->  
<!--主体部分开始-->      
<div class="main" >	

    
 				<div id="Jobs">
                   	 <div id="Jobs_caption">
			            <ul>
			              <li class="b">Metabolite</li>
			            </ul>
			         </div>
				     <div id="Jobs_content" style="font-size:16px; padding-left:10px;height:420px">
				     
				      <form action="metabolite.action" method="post" onsubmit="return check1()">
				      <br/>
				      <div style="font-size:12px">Based on LC-MS/MS analysis we quantified 983 metabolite features in 702 maize genotypes planted at multiple locations. We have identified genome-wide significant loci through metabolite-based genome-wide association studies (GWAS) and linkage mapping.</div>
				          <br/>
				          <span class="Phenotypicstrongblack">Compound：</span>
				          <select class="select" name="trait" id="trait1" style="width:150px" onchange="checkdata()"> 
				          <option >Please select the compound</option>
				          <%while(rs.next()) {%>
				          <option style="width:150px"><%=rs.getString(1) %><%if(rs.getString(2)!=null&&!rs.getString(2).equals("")) {%>:<%=rs.getString(2) %><%} %></option>
				          <%} %>
				          </select>
				           
				          <span class="Phenotypicstrongblack">Or input the compound：</span>
				          <input id="word" class="input1" type="text" name="inputtrait" onblur='javascript:$("#auto")' onchange="checkdata2()"/> 
				          
				          <span class="Grand9" style="font-size:12px">(e.g:n0020:L-Aspartic acid)</span>
				          
				          <input style="margin-top: 5px"type="image" src="/maizego/images/button_08.jpg" height="36"width="100" /> 
				         <table id="auto"></table>
				          </form>
				          <br/>
				          <br/>				     
				     
				     
				     
				     
				     
				     
				          <ul>
				            <li style="height:40px"><span >Metabolite | </span> <a href="/maizego/Metabolite/data2.action" class="Grand3">List of 983 metabolite features</a> 　<a href="/maizego/file/Supplementary Data 2.xlsx" title=" XLSX File"><img align="top" style="width: 25px; height: 20px;" src="/maizego/images/down2.jpg" /></a></li>
				            <li style="height:40px"><span >Metabolite | </span> <a href="/maizego/Metabolite/data3.action" class="Grand3">Significant loci identified by GWAS </a>　<a href="/maizego/file/Supplementary Data 3.xlsx" title=" XLSX File"><img align="top" style="width: 25px; height: 20px;" src="/maizego/images/down2.jpg" /></a></li>
				            <li style="height:40px"><span >Metabolite | </span> <a href="/maizego/Metabolite/data4.action" class="Grand3">QTL mapping summary</a> 　<a href="/maizego/file/Supplementary Data 4.xlsx" title=" XLSX File"><img align="top" style="width: 25px; height: 20px;" src="/maizego/images/down2.jpg" /></a></li>
							<li style="height:40px"><span >Metabolite | </span> <a href="/maizego/Metabolite/data5.action" class="Grand3">List of possible candidate genes</a> 　<a href="/maizego/file/Supplementary Data 5.xlsx" title=" XLSX File"><img align="top" style="width: 25px; height: 20px;" src="/maizego/images/down2.jpg" /></a></li>
				          </ul> 
				          <br/>

				           
                 </div>
	                 </div>
	             </div>
    



<!--主体部结束--> 
<!--版权信息开始--> 
<%@ include file="../ListFooter.jsp" %>                                           
<!--版权结束-->
</body>
</html>
