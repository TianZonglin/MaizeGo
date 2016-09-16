<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=gbk" language="java" pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>MaizeGo DataMine Platform</title>
<link href="style.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/jquery.fancybox-1.3.4.js"></script>
<script type="text/javascript" src="js/jquery.mousewheel-3.0.4.js"></script>
<link rel="stylesheet" type="text/css" href="css/jquery.fancybox-1.3.4.css" media="screen" />
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
<%@ include file="ListHeader.jsp" %>


<div class="main">
   <h3 class="tit" style="border-bottom:2px solid #08b702; padding-bottom:5px; color:#08b702;"><span>Overall Data Structure</span></h3>
   <div class="content" style="width:927px; height:1317px; background:url(images/tree.jpg) no-repeat;padding-bottom:5px; border-bottom:2px solid #08b702; position:relative;">
     <div class="edi">
       <div class="e1"><a href="#">Brief introduction of our Resources</a></div>
	   <div class="e2"><a href="/maizego/Germplasmlines/germplas.jsp">Germplasm Collection</a></div>
	   <div class="e3"><a href="/maizego/Genotypic/genotypic_new.jsp">Genotypic Variation</a></div>
	   <div class="e4"><a href="/maizego/Expression/expressionIndex.jsp">Transcriptome Variation</a></div>
	   <div class="e5"><a href="/maizego/Phenotypic/phenoagritraits_new.jsp">Phenotypic Data</a></div>
	   <div class="e6"><a href="/maizego/Metabolite/metabolite.jsp">Metabolome Data</a></div>
	   <div class="e7"><a href="/maizego/MappingResult/gwas.jsp">Mapping Results</a></div>
	   <div class="e8"><a href="#">Software or package(s)</a></div>
	   <div class="e9"><a href="#">527 Elite Inbred Lines</a></div>
	   <div class="e10"><a href="#">10 RILs (200 families each)</a></div>
	   <div class="e11"><a href="#">12 Heterogeneous Inbred Families (HIF)</a></div>
	   <div class="e12"><a href="#" style="color:grey;">5,000 Inbred Lines and more RILs in next 3 years</a></div>
	   <div class="e13"><a href="#">>50,000 SNPs from MaizeSNP50 BeadChip of all 527 Inbred lines and all 10 RIL families</a></div>
	   <div class="e14"><a href="#">>1,000,000 SNPs from RNA-seq (15 DAP) of 368 Inbred lines</a></div>
	   <div class="e15"><a href="#" style="color:grey;">Genotypic variation of all Lines from GBS protocol</a></div>
	   <div class="e16"><a href="#">28,769 genes' expression in 15DAP kernel among 368 lines</a></div>
	   <div class="e17"><a href="#" style="color:grey;">More tissues in next 3 years</a></div>
	   <div class="e18"><a href="#">All lines were planted in multiple locations and several years</a></div>
	   <div class="e19"><a href="#">12 Agronomic traits</a></div>
	   <div class="e20"><a href="#">11 yield traits</a></div>
	   <div class="e21"><a href="#">17 Amino acids</a></div>
	   <div class="e22"><a href="#">More than 700 metabolites from 3 different Experiments of Association Panel</a></div>
	   <div class="e23"><a href="#">More than 700 metabolites of 2 RILS (B73 X BY804,ZONG3 X 87-1)</a></div>
	   <div class="e24"><a href="#">Linkage mapping results of each trait,each RIL in every year</a></div>
	   <div class="e25"><a href="#">Association mapping results of each trait (after blup)</a></div>
	   <div class="e26"><a href="#">eQTL mapping results</a></div>
	   <div class="e27"><a href="#">Other mapping results by our own methods</a></div>
	   <div class="e28"><a href="#">R package for ADGWAS (Linux/Windows)</a></div>
	 </div>
   </div>
</div>

<%@ include file="ListFooter.jsp" %>
</body>
</html>
