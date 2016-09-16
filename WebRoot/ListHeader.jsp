<%@ page contentType="text/html;charset=gbk" language="java" pageEncoding="UTF-8"%>
<%@ page import="com.opensymphony.xwork2.ActionContext"%>
 <% String user=(String)request.getSession().getAttribute("user"); 
 String type=(String)request.getSession().getAttribute("userType"); 
 String url;
url=request.getRequestURI();
 %>
 <script>
  function checkLogin(){
  	var uname = $("#user").val();
  	var pwd = $("#password").val();
  	//alert(uname);
  	//检查输入内容格式
  	if(uname==""||pwd=="")
  	{
  		alert("用户名和密码不能为空");
  		return false;
  	}
    var flag = false;
    $.ajax({
		type : "post",
		async:false,
		url : "/maizego/checklogin.action?uname="+uname+"&pwd="+pwd,
		success : function(result) {
			if(result=="failure"){
				alert("用户名或密码错误");
			}else{
				flag = true;
			}
		},
		failure:function(){
		}
     });
  return flag;
  }
  </script>
 
<div class="headerwrap">
   <div class="header"><a href="#">HELP</a>　<a href="#">ABOUT</a>　<a href="#">FAQ</a></div>
</div>
<div class="top">
   <div class="logo"><a href="#"><img src="/maizego/images/logo.jpg" /></a></div>
   <div class="topbox">
      <div class="log">
      <%if(user==null) {%>
      <a id="various1" href="#inline1">LOGIN</a><%}else{ %>welcome,<a href="/maizego/Seed/Seed.jsp">${user}</a> &nbsp;<a  href="loginout.action?url=<%=url%>">logout</a><%}  %>|<br /> <a href="#">REGISTER</a> |</div>
	  <div class="search">
	  <form method="post" action="">
	       <table cellpadding="0" cellspacing="0" border="0" width="100%">
		       <tr><td><input type="text" value="SEARCH" name="keyword" class="input" onblur="this.style.color='#666';if (this.value == '') this.value = 'SEARCH';" onfocus="this.style.color='#666';this.value = ''" /></td><td><input type="image" src="/maizego/images/go.jpg" /></td></tr>
		   </table> 
	  </form>
	  </div>
   </div>
</div>

<div class="nav">
   <ul>
       <li style="padding:0 65px;"><a href="/maizego">HOME</a></li>
      
	   <li><a href="#">SEARCH</a>
	      <ul class="mlist" style="width:178px;">
	         <a href="/maizego/Germplasmlines/germplas.jsp">Germplasm</a>
	         <a href="/maizego/Genotypic/genotypic_new.jsp" >Genotype</a>
	         <!--<a href="/maizego/Genotypic/genotypicIndex.jsp" >XXXXXX</a>
	         --><a href="/maizego/Expression/expressionIndex.jsp">Transcriptome</a>
	         <a href="/maizego/Phenotypic/phenoagritraits_new.jsp" >Phenotype</a>
	         <a href="/maizego/Metabolite/metabolite.jsp">Metabolite</a>
	         <a href="/maizego/Hif/Chromosome/chromosome.jsp">HIF</a>
	         <a href="/maizego/MappingResult/gwas.jsp">Mapping Results</a>	 
	         
		  </ul>
	   </li>
	   
	   <li><a href="/maizego/JBrowse/index.html?data=maize%2Fjson&tracklist=1&nav=1&overview=1">BROWSER</a>
	    
	    <li><a href="/maizego/graph/draw.jsp">TOOLS</a></li>
	   <li style="border:none;"><a href="/maizego/Seed/Seed.jsp">SEED</a>
	      <ul class="mlist" style="width:178px;"> 
	          <a href="/maizego/Seed/seed_select.jsp" class="Grand3">Seed Information</a>
	   <% if(user!=null){%>	          
	          <a href="modification.action" class="Grand3">Seed Modification</a>
	          <a href="borrow.action" class="Grand3">Borrow Information</a>
	          <a href="/maizego/Seed/list.jsp" class="Grand3">Search Seed Location</a>
	          <a href="/maizego/Seed/source.jsp" class="Grand3">Search Seed Source</a>
	    <%} %>
	          <%if(type!=null&&type.equals("guest")){ %>
	          <a href="/maizego/Seed/seedBorrow.jsp" class="Grand3">Go to Borrow Seed</a>
	       
	          <%} %>
	          <%if(type!=null&&type.equals("admin")){ %>
	         <a href="/maizego/Seed/batchImport.jsp" class="Grand3">BatchImport</a>
	       
	          <%} %>
	             
	      </ul>
	    </li>
	    

<!-- 
	   <li><a href="dbtablesearch.action">DOWNLOAD</a></li>
	   <li style="border:none;"><a href="/maizego/Contact/contact.jsp">CONTACT US</a></li>    -->
   </ul>
</div> 
