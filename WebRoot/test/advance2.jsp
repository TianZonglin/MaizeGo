<%@ page contentType="text/html;charset=gbk"  import="java.util.*"  language="java" pageEncoding="UTF-8"%>
<%@ page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page import="org.hibernate.HibernateException"%>
<%@ page import="org.hibernate.Session"%>
<%@ page import="org.db.phenoype_agri_traits.*"%>
<%@ page import="java.io.*" %> 


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
  <title>MaizeGo DataMine Platform</title>

  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">
  <meta http-equiv="keywords" content="maize">
  <meta http-equiv="description" content="This is a database search engine of maize!">
 

  <link href="../css/bg.css" rel="stylesheet" type="text/css" />
  <link href="../css/link.css" rel="stylesheet" type="text/css" />
  <link href="../css/exhibition.css" rel="stylesheet" type="text/css" />
  <link rel="stylesheet" href="../css/cb24.css" />
  <link href="../css/company.css" rel="stylesheet" type="text/css" />
  <link href="../css/paul.css" rel="stylesheet" type="text/css" />
  
  
    <link href="../Script/search.css" rel="stylesheet" type="text/css" />
    <script language="javascript" type="text/javascript" src="http://g.wanfangdata.com.cn/share/Script/jquery-1.7.1.min.js"></script>
    <script language="javascript" type="text/javascript" src="../Script/search.js"></script>


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
		<div class="LOGO"><span class="flaot_l"><img src="../pic/header_maizego.jpg" width="935" height="85" /></span>
	  </div>
	</div>
	<div class="span_24 padding_lr">
		  <div class="nav" >  <a href="/maizego"  class="White14">Home</a>　　<a href="/maizego" class="White14">Search</a>　　<a href="/maizego" class="White14">Download</a>　　<a href="/maizego" class="White14">Contact Us</a>　</div>
	</div>
	                           
</div>
<!--导航结束-->  
<!--主体部分开始-->      
<div class="box">	
  <div class="span_24 padding_lr">
      
      <div class="span_30">
   
        <div class="r1_bg">
          <h6>&nbsp;&nbsp;&nbsp;&nbsp; Advanced Search</h6>
          
          <div>
	                  <form name="form" id="phenotypic_scopesearch"  method="post" action="phenoagritraits_scopesearch.action">
	                    <div>
	                     <span class="Phenotypicstrongblack">&nbsp;Input：</span>   
	                        <input class="textlen" type="text" name="germplasmname" id="textfield" />
			                <span class="Grand9">(Please input the name of germplasm)</span>
	                    </div>
			               <span class="Phenotypicstrongblack"><br />&nbsp;Genotype</span><span class="Grand9">(Please input the gonotype features to search)</span> 
		                 
		                 <div id="AdvancedSearchList">&nbsp;  
		                   <table id="SeniorSearchTable" cellpadding="0" cellspacing="0" style="border-collapse:collapse;">
		                    <tr id="s1">
		                        <td ><input id="addqbtn" type="button" class="w-button1" onclick="javascript:addQueryCondition();"  /></td>
		                        <td ><input id="redqbtn" onclick="javascript:reduceQueryCondition();" class="w-button2" type="button" /></td>
		                        <td><select name="sel"  class="td2"></select></td>
		                        <td><input name="exp" type="text" class="input_1" /></td>
		                    </tr>
		                    <tr id="s2">
		                        <td colspan="2">&nbsp;</td>
		                        <td> <select name="sel" class="td2"></select></td>
		                        <td><input name="exp" type="text" class="input_1" /></td>
		                    </tr>
		                    <tr id="s3">
		                        <td colspan="2">&nbsp;</td>
		                        <td><select name="sel" class="td2"></select></td>
		                        <td><input name="exp" type="text" class="input_1" /></td>
		                    </tr>
		                    <tr id="s4" style="display: none;">
		                        <td colspan="2">&nbsp;</td>
		                        <td><select name="sel" class="td2"></select></td>
		                        <td><input name="exp" type="text" class="input_1" /></td>
		                    </tr>
		                    <tr id="s5" style="display: none;">
		                        <td colspan="2">&nbsp;</td>
		                        <td><select name="sel" class="td2"></select></td>
		                        <td><input name="exp" type="text" class="input_1" /></td>
		                    </tr>
		                    <tr id="s6" style="display: none;" >
		                        <td colspan="2">&nbsp;</td>
		                        <td><select name="sel" class="td2"></select></td>
		                        <td><input name="exp" type="text" class="input_1" /></td>
		                        <td>&nbsp;</td>
		                    </tr>
		                  </table>
		                   <div class="clearall"></div>
		                 </div> 
	
	                     <div class="quick"><input class="searchphenotypic" type="submit" value="search" style="width:80px;"> </div>
	                  </form>
	             </div>
          
          
          
          <div class="quick">
            <ul>
              <li> <a href="exportphenotypic_csv.jsp" class="blue12">CSV File</a></li>
            </ul>
            <ul>
              <li> <a href="exportphenotypic_txt.jsp" class="blue12">Text File</a></li>
            </ul>
          </div>
          
          
          <div>
          </div>
        </div>
      </div>
    
    <div class="list_middle_right_content">
        <table width="940" border="0" cellspacing="1" cellpadding="1" bgcolor="#A9D9EF" style="text-align:center">
				   <tr bgcolor="#CFEEF8">
				  
						    <td width="220" align="center">Trait</td>
						    <td width="180" align="center">Plantheight</td>
						    <td width="180" align="center">Earheight</td>
						    <td width="180" align="center">Earleafwidth</td>
						    <td width="180" align="center">Earleaflength</td>
					   </tr>  
			</table>

    </div>
    
  
  </div>   

<!--右分栏结束--> 
    </div>
</div>
<!--主体部结束--> 
<!--版权信息开始--> 
<div class="box">
  <div class="span_24 padding_lr">    
    <div class="foot">
      <div class="padding_tf"><img src="../pic/foot.gif" width="940" height="5" /></div>
  <!--  <p><a href="http://www.maizego.org/index.html" class="Grand6">About MaizeGo</a> | <a href="#" class="Grand6">联系我们</a></p>   -->    
        <p> Tel:+86-27-87280169　E-mail:<a href="#">heroalone2@gmail.com</a><br />
        Copyright reserved by Aruo &copy; 2013 &middot; Yan's lab <br />
      </p>
      <p></p>
    </div>
  </div>
</div>                                            
<!--版权结束-->
</body>


</html>



