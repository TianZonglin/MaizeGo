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

  <%
  Map attribute=ActionContext.getContext().getSession(); 
  ArrayList<String> data=(ArrayList<String>)attribute.get("data");
  int columnCount=(Integer)attribute.get("columnCount"); 

  %>



<body>

<!--LOGO+导航开始-->
<%@ include file="../ListHeader.jsp" %>

<!--导航结束-->  
<!--主体部分开始-->   
<div class="main">
   <div class="content">
         <div>
		 　　　　<div class="inser">
		           <select name="cata" style="border:2px solid #09b801; padding:7px 15px; position:relative; top:2px; color:#666;">
				       <option>CATEGORY</option>
					   <option>CATEGORY</option>
					   <option>CATEGORY</option>
				   </select>
				   <input type="text" value="SEARCH" onblur="this.style.color='#999';if (this.value == '') this.value = 'SEARCH';" onfocus="this.style.color='#666';this.value = ''" style="height:30px; border-top:2px solid #09b801; border-bottom:2px solid #09b801; color:#666; width:260px; line-height:30px; border-left:2px solid #09b801; text-indent:15px;" /><input type="image" src="/maizego/images/ingo.jpg" style="margin-left:-2px;" />
		        </div>
		 　　　　<div style=" float:right">
		           　<a href="/maizego/file/Supplementary Data 2.xlsx" title=" XLSX File"><img src="/maizego/images/down2.jpg" /></a>　
				</div>
		 </div>
          <div style="clear:both"></div>
          <div style="overflow:auto;height:400px">
              <table cellpadding="0" cellspacing="0" width="100%" align="center" class="tab1" >
				   <tr bgcolor="#CFEEF8">	
				        <td align="center">NO</td>		
				        <td align="center">Peak no.</td>		
				        <td align="center">Ret.Time(min)</td>	
				        <td align="center">Putative metabolite name</td>	
				        <td align="center">Metabolite Class</td>
				        <td align="center">Mol formula</td>
				        <td align="center">ES(+) Theor m/z</td>
				        <td align="center">ES(+) Found m/z</td>
				        <td align="center">m/z error (ppm)</td>
				        <td align="center">MS/MS ES(+) fragments</td>
				        <td align="center">MS/MS ES(+) CE (eV)</td>
				        <td align="center">Species detected before</td>
				        <td align="center">References</td>
				        <td align="center">Identification level (A-D)</td>
				        <td align="center">InChI</td>
				        <td align="center">InChI Key</td>
				        <td align="center">CID</td>   
				        <td align="center">Database comparisons</td>    	          
				  </tr> 
				       <%				    				        
							for(int i=0;i<data.size()/columnCount;i++)
				            { 				          	         
		               %>
		                      <tr>

					           <%
					           //System.out.println(String.valueOf(seed.get(12*i)));
							for(int j=0;j<columnCount;j++)
				            { 	
				            %>
							    <td  align="center"><%=data.get(columnCount*i+j)%></td> 
							   
							  <% }}%>
						   </tr> 

			</table>
	<div >
    <p>Supplemental Data 2: List and detailed information of 983 metabolites detected in this study.</p>			
    <p>UPLC-QTOF-MS metabolites	</p>		
    <p>Experiment title:</p>			
	<p>Organism/Plant species:	</p>	
	<p>Organ/tissue:</p>		
	<p>Analytical tool:	</p>			
	<p>Peak no.- number referenced back to the main text </p>		
	<p>Ret . Time- Retention time, in minutes (difference in Ret.Time between ES(+) and ES(-modeswas less than XX minutes)</p>		
	<p>Putative Name- putative identification of the metabolite	</p>	
	<p>Mol. Formula- molecular formula of the metabolite or its FA adduct;	</p>	
	<p>Theor. m/z- theoretical monoisotopic mass calculated for the ion (M-H)<sup>-</sup> , (M+H)<sup>+</sup> or (M+FA)<sup>-</sup></p>		
	<p>Found m/z- mass detected in the experiment</p>		
	<P>m/z error (ppm)- difference between theoretical and found m/z values in ppm</P>		
	<p>MSMS fragments- fragments, obtained from the ion (M-H)<sup>-</sup> , (M+H)<sup>+</sup> or (M+FA)<sup>-</sup></p>	
	<p>MS/MS CE (eV)- collision energy used for fragmentation optional</p>		
	<P>UV/Vis- UV/ Vis absorbance maxima</P>		
	<p>() FA- formic acid adduct</p>		
	<p>(S)- identification confirmed by a standard compound</p>		
	<p>I, II, III- different isomers</p>		
	<p>Identification level (A; B; C; D)- (A) standard or NMR; (B) MS/MS; (C) MS<sup>E</sup>; (D) MS only</p> 		
	<p>InchI-accurate structure identifiers		</p>
	<p>InChI Key-international Chemical Identifier Keys</p>		
	<p>CID-PubChem Compound Identifiers	</p>	
	<p>Database comparisons-Souce of comparisons</p>		
    </div>			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			</div>

    </div>
    
  
  </div>   

<!--主体部结束--> 
<!--版权信息开始--> 
<%@ include file="../ListFooter.jsp" %>                                          
<!--版权结束-->

  </body>


</html>



