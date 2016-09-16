<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=gbk" language="java" pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>MaizeGo DataMine Platform</title>
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
</head>

<body>
<%@ include file="ListHeader.jsp"%>
<div class="main">
   <div class="banner">
      <div id="YNews">
	
	  <dl><dt><a href="#"><img src="/maizego/images/maize.jpg"/><div class="mask"></div></a></dt></dl>
	  <dl><dt><a href="#"><img src="/maizego/images/BDBC.jpg" /><div class="mask"></div></a></dt></dl>
	  <dl><dt><a href="#"><img src="/maizego/images/servespeople.jpg" /><div class="mask"></div></a></dt></dl>
	  
      <p id="YNIndex">
	   
	    <a href="#"></a>
	    <a href="#"></a>
		<a href="#"></a>
		
	  </p>
</div>
<script language="javascript" type="text/javascript" src="/maizego/js/yao.js"></script>
<script language="javascript" type="text/javascript"> 
<!--
YAO.YTabs({
		tabs: YAO.getEl('YNIndex').getElementsByTagName('a'),
		contents: YAO.getEl('YNews').getElementsByTagName('dl'),
		auto: true,
		fadeUp: true
});
//-->
</script>  
   </div>
   <div class="sidebar">
      <ul>
           <li><a href="/maizego/edit.jsp">Data Tree</a><a href="/maizego/edit.jsp" class="more"></a></li>
	       <li><a href="/maizego/Home/collaborators.jsp">Collaborators</a><a href="/maizego/Home/collaborators.jsp" class="more"></a></li>
		   <li><a href="/maizego/Home/homepapers.jsp">Publications</a><a href="/maizego/Home/homepapers.jsp" class="more"></a></li>
		   <li><a href="#">News</a><a href="#" class="more"></a></li>
		   <li><a href="#">Useful links</a><a href="#" class="more"></a></li> 
	  </ul>
   </div>
</div>

<div class="main">
   <h3 class="tit"><span>SEARCH</span><span class="more"><a href="#"><img src="/maizego/images/more.jpg" /></a></span></h3>
   <div class="maincontent">
       <div ><p>GERMPLASM<br /><a href="/maizego/Germplasmlines/germplas.jsp" >Germplasm  Data  Search</a></p></div>
      <div ><p>PHENOTYPIC<br /><a href="/maizego/Phenotypic/phenoagritraits_new.jsp" >Phenotypic  Data  Search</a></p></div>
      <div><p>MAPPING<br /><a href="/maizego/MappingResult/gwas.jsp" >Mapping  Data Search</a></p></div>
	  <div style="background:none;"><p>METABOLITE<br /><a href="/maizego/Metabolite/metabolite.jsp">Metabolite  Data Search</a></p></div>
	  
   </div>
</div>

<div class="main">
   <h3 class="tit"><span>DOWNLOAD</span><span class="more"><a href="#"><img src="/maizego/images/more.jpg" /></a></span></h3>
   <div class="maincontent">
      <div><p>GENETIC<br /><a href="/maizego/dbtablesearch.action">Genetic  Download&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></p></div>
	  <div><p>GENOTYPIC<br /><a href="/maizego/dbtablesearch.action">Genotypic  Download&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></p></div>
	  <div><p>EXPRESSION<br /><a href="/maizego/dbtablesearch.action">Expression  Download&nbsp;</a></p></div>
	  <div style="background:none;"><p>PHENOTYPIC<br /><a href="/maizego/dbtablesearch.action">Phenotypic  Download</a></p></div>
   </div>
   
</div>


<%@ include file="ListFooter.jsp" %>

</body>
</html>
