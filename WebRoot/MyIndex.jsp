<%@ page contentType="text/html;charset=gbk" language="java" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
  <title>MaizeGo DataMine Platform</title>

  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">
  <meta http-equiv="keywords" content="maize">
  <meta http-equiv="description" content="This is a database search engine of maize!">
  
  <link rel="stylesheet" href="css/cb24.css" type="text/css"/>
  <link href="css/bg.css" rel="stylesheet" type="text/css" />
  <link href="css/link.css" rel="stylesheet" type="text/css" />
  <link href="css/exhibition.css" rel="stylesheet" type="text/css" />

</head>
  
<body>
<!--top开始-->
<div class="box">
  <div class="span_24 padding_lr">
    <div class="top ">
      <div class="flaot_l">Welcome to Maizego Datamine Platform！ </div>
      <div class="flaot_r"> Help | About | FAQ </div>
    </div>
  </div>
</div>
<!--LOGO+导航开始-->
<div class="box">
	<div class="span_24 padding_lr">
		<div class="LOGO"><span class="flaot_l"><img src="pic/header_maizego.jpg" width="935" height="85" /></span>
	  </div>
	</div>
	<div class="span_24 padding_lr">
		  <div class="nav" >  <a href="/maizego/index.jsp"  class="White14">Home</a>　　<a href="/maizego" class="White14">Search</a>　　<a href="dbtablesearch.action" class="White14">Download</a>　　<a href="/maizego" class="White14">Contact Us</a>　</div>
	</div>
	                           
</div>
<!--导航结束-->  
<!--主体部分开始-->      
<div class="box">	
  <div class="span_24 padding_lr">
      <!--左分栏开始-->
    <div class="span_8 l_0">
     
      <div class="span_8 l_0 r_0 margin_tf">
        <div class="L2_bg padding_lr"><span class="black14">Search</span></div>
        <div class="L2_p padding_tf">
          <ul>
            <li><span>Advanced |</span>  <a href="/maizego/Advance/advance3.jsp" class="Grand3">Advanced Search</a></li>
            <li><span>Advanced |</span>  <a href="/maizego/Advance/newadvance.jsp" class="Grand3">NewAdvanced Search</a></li>
            <li><span>Germplasmlines |</span>  <a href="/maizego/Germplasmlines/germ.jsp" class="Grand3">Germplasmlines Search</a></li>
            <li><span>Genetic |</span>  <a href="/maizego/Genotypic/genotypic.jsp" class="Grand3">Genetic Data Search</a></li>
            <li><span>Genotypic |</span>  <a href="#" class="Grand3">Genotypic Data Search</a></li>
            <li><span>Expression |</span>  <a href="#" class="Grand3">Expression Data Search</a></li>
            <li><span>Phenotypic |</span>  <a href="/maizego/Phenotypic/phenoagritraits.jsp" class="Grand3">Phenotypic Data Search</a></li>
            <li><span>ChartDisplay |</span>  <a href="/maizego/ChartDisplay/chartDisplay.jsp" class="Grand3">ChartDisplay Search</a></li>
            <li><span>Chromosome |</span>  <a href="/maizego/Chromosome/chromosome.jsp" class="Grand3">Chromosome Search</a></li>
            <li><span>Chromosome |</span>  <a href="/maizego/BB_qtl_el/bb_qtl_el.jsp" class="Grand3">BB_qtl_el Search</a></li>
          </ul>
        </div>
        <div class="jiaob"></div>
      </div>
      <div class="span_8 l_0 r_0 margin_tf">
        <div class="L2_bg padding_lr"><span class="black14">Download</span>　　　　　　　　　　<a href="#" class="Grand6">More&gt;&gt;</a></div>
        <div class="L2_p padding_tf">
          <ul>
            <li><a href="#" class="Grand3">Genetic Resources</a></li>
            <li><a href="#" class="Grand3">Genotypic Data</a></li>
            <li><a href="#" class="Grand3">Expression data </a></li>
            <li><a href="#" class="Grand3">Phenotypic Data</a></li>
          </ul>
        </div>
        <div class="jiaob"></div>
      </div>
    </div> 
    
      <!--右分栏开始-->
    <div class="span_16 r_0"> 
      <div class="span_16 l_0 r_0 margin_tf">
        <div class="R3_bg"><span class="White14">Search</span></div>
        <div class="R3_p">
        
        
                <div class="span_13">
                  <div><span class="Grand9">Input the content to search:</span>
                  <form id="form1" name="form1" method="post" action="basicsearch.action">
                  <label>
                    <input type="text" name="name" id=""/>     <input type="submit" value="search" style="width:80px;">  
                
                  </label>
                </form>
                <div>
                  <form id="form3" name="form3" method="post" action="">
                    <span class="strongred">Data：</span>
                      <label><input type="radio" name="RadioGroup1" value="单选" id="RadioGroup1_0" /> metabolic_traits_zy</label>
                      <label><input type="radio" name="RadioGroup1" value="单选" id="RadioGroup1_1" /> metabolic_traits_bb</label>
                      <label><input type="radio" name="RadioGroup1" value="单选" id="RadioGroup1_2" /> metabolic_traits_e1</label>                      
                      <label><input type="radio" name="RadioGroup1" value="单选" id="RadioGroup1_4" /> metabolic_traits_e2</label>
                      <label><input type="radio" name="RadioGroup1" value="单选" id="RadioGroup1_3" /> metabolic_traits_e3</label>
                      
                      
                  </form>
                </div>
        
        </div>
      </div>
    </div>   

<!--右分栏结束--> 
    </div>
</div>

<!--主体部结束--> 
<!--版权信息开始--> 
<div class="box">
  <div class="span_25 padding_lr">    
    <div class="foot">
      <div class="padding_tf"><img src="pic/foot.gif" width="940" height="5" /></div>
  <!--  <p><a href="http://www.maizego.org/index.html" class="Grand6">About MaizeGo</a> | <a href="#" class="Grand6">联系我们</a></p>   -->    
        <p> Tel:+86-27-87280169　E-mail:<a href="#">heroalone2@gmail.com</a><br/>
        Copyright reserved by Aruo &copy; 2013 &middot; Yan's lab  <br/>
      </p>
      <p></p>
    </div>
  </div>
</div>                                            
<!--版权结束-->
</body>
</html>
