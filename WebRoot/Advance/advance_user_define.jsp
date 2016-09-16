<%@ page contentType="text/html;charset=gbk" language="java" pageEncoding="UTF-8"%>
<%@ page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page import="org.hibernate.Session"%>
<%@ page import="java.util.*"%>
<%@ page import="org.db.phenoype_agri_traits.*"%>
<%@ page import="org.hibernate.HibernateException"%>
<%@ page import="org.hibernate.Session"%>
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
    <link rel="StyleSheet" href="../css/dtree.css" type="text/css" />
	<script type="text/javascript" src="../Script/dtree.js"></script>
	
	
	
	
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
  
  <script language="javascript">

          function selectGoal()
          {
	         var arry = $("input[name=checkbox]:checked");
			//alert("aaa");
			var str = ""; 
			var val = "";
			var content=$("#ly");
			
			for(var i=0;i<arry.length;i++)
			{
				//str += $(arry[i]).attr("id")+";";
				val += $(arry[i]).parent().text()+";";		 
			}
			//location.href="getProcess.action?checkbox="+val;
			content.val(val);
			//var a="";
	  
   }
</script>
  
  
  <style type="text/css">
.STYLE_title {
font-size: 20px;
font-family: "楷体";
color:#2986C4;
}
.STYLE1 {
font-size: 16px;
font-family: "黑体";
color:#2986C4;
}
.STYLE2 {
color: #FF0000;
font-size: 14px;
}
.STYLE3 
{font-size: 15px;
font-family: "黑体";
color:#2986C4;
}
.STYLE4 {color: #FF0000}


.STYLE_select {
font-size: 15px;
font-family: "宋体";
color:#1C4B7B;
}
</style>

  <script type="text/javascript">
function selectGoal22()
{
   var userName = document.getElementById('Content').value;
   if(userName=="")
   {
      alert("请输入信息");
  
     return false;
   }

  return true;
 

 }
</script>  


</head>
  
<body>


  <%
			//Map attibutes = ActionContext.getContext().getSession();					
			List<PhenoypeAgriTraits> phenotypesrlist = new ArrayList<PhenoypeAgriTraits>();
			DbBean db = new DbBean();
			ResultSet rrs = null;					
			
			try
			{
			    String sql="SELECT * FROM phenoype_agri_traits;";
		
				//PhenoypeAgriTraitsDAO dao = new PhenoypeAgriTraitsDAO();
				//phenotypesrlist=dao.findAll();
			    rrs = db.executeQuery(sql);
			
			} 
			catch (HibernateException e) 
			{
				System.err.println("Entity retrieval failed.");
				e.printStackTrace();
			} 
	  %>
	



<!--LOGO+导航开始-->
<%@ include file="../ListHeader.jsp" %>



<!--导航结束-->  
<!--主体部分开始--> 
<div class="main">  

	   <h3 class="tit" style="border-bottom:2px solid #08b702; padding-bottom:5px; color:#08b702;"><span>Advanced Search</span></h3>
	   <div id="Advance_content">   
	                  <form name="form" id="phenotypic_scopesearch"  method="post" action="advancese.action">
	                    <div>
	                    
	                    <div>
	                     <span class="Phenotypicstrongblack"><br />&nbsp;Input:</span><span class="Grand9">(Please input the traits to search)</span> 
	                    </div>
	                    
	                    <textarea class=button11 id=Content name="germplasmname" rows=7 cols=30 style="width: 225px;height: 100px; border: 1px solid #CCC;"></textarea>
	                    

			                <input class="searchphenotypic" type="file" value="upload" name="upload" style="width:180px;"/>
	                    </div>
	            
	
	                    <div>
	                     <span class="Phenotypicstrongblack"><br />&nbsp;Trait</span><span class="Grand9">(Please select the trait features to search)</span> 
	                    </div>



     <div>
		     <b style="color:#08b702">&nbsp;&nbsp;&nbsp;year:</b><select  class="select" name="year" id="phenotypeicmenujumpMenu">
		                      <option>Search all year</option>
		                      <option>2011</option>
		                      <option>2012</option>
		                      <option>2013</option> 
	                    </select>		
						

			 <b style="color:#08b702">location:</b>	<select  class="select" name="location" id="phenotypeicmenujumpMenu">
		                      <option>Search all location</option>
		                      <option>CQ</option>
		                      <option>HN</option>      
	                    </select>
	                    

			<b style="color:#08b702">trait:	</b><select  class="select" name="trait" id="phenotypeicmenujumpMenu">
		                      <option>Search all trait</option>
		                      <option>HKW</option>
		                      <option>KL</option>            
	                    </select>				
	 </div>	
						
		
						
		                 <div>
	                     <span class="Phenotypicstrongblack"><br />&nbsp;Genotype</span><span class="Grand9">(Please input the gonotype features to search)</span> 
	                    </div>				
						
			             
		                   <table id="SeniorSearchTable" cellpadding="0" cellspacing="0" style="border-collapse:collapse;">
		                       <tr id="t1">
			                        <td ><input id="addqbtn" type="button" class="w-button1" onclick="javascript:addQueryConditiont();"  /></td>
			                        <td ><input id="redqbtn" onclick="javascript:reduceQueryConditiont();" class="w-button2" type="button" /></td>
			                        <td>
			                        <select id="sel" name="sel"  class="select">
					                      <option>choose</option>
					                      <option>chr1_merged_all_snp</option>
					                      <option>chr2_merged_all_snp</option>
					                      <option>chr3_merged_all_snp</option>		                   		                 
			                      </select>
			                      </td>
		                          <td><input id="exp" name="exp" type="text" class="input1" style="width:185px;margin-left:5px"/></td><td>---</td>
		                          <td><input id="ecp" name="ecp" type="text" class="input1" style="width:185px"/></td>
		                    </tr>
		                            <tr id="t2">
		                        <td colspan="2">&nbsp;</td>
		                        <td>
		                         <select id="sel2_choose" name="sel2" class="select">
		                          <option>choose</option>
		                      <option>chr1_merged_all_snp</option>
		                      <option>chr2_merged_all_snp</option>
		                      <option>chr3_merged_all_snp</option>
		                      </select>
		                      </td>
		                        <td><input id="exp2" name="exp2" type="text" class="input1" style="width:185px;margin-left:5px"/></td>
		                        <td>---</td>
		                         <td><input id="ecp2" name="ecp2" type="text" class="input1" style="width:185px"/></td>
		                    </tr>
		                      <tr id="t3">
		                        <td colspan="2">&nbsp;</td>
		                        <td><select name="sel3" class="select">
		                      <option>choose</option>
		                      <option>chr1_merged_all_snp</option>
		                      <option>chr2_merged_all_snp</option>
		                      <option>chr3_merged_all_snp</option>
		                        </select></td>
		                        <td><input name="exp3" type="text" class="input1" style="width:185px;margin-left:5px"/></td>
		                        <td>---</td>
		                         <td><input name="ecp3" type="text" class="input1" style="width:185px"/></td>
		                    </tr>
		                    <tr id="t4" style="display: none;">
		                        <td colspan="2">&nbsp;</td>
		                        <td><select name="sel4" class="select">
		                       <option>choose</option>
		                      <option>chr1_merged_all_snp</option>
		                      <option>chr2_merged_all_snp</option>
		                      <option>chr3_merged_all_snp</option>
		                        </select></td>
		                        <td><input name="exp4" type="text" class="input1" style="width:185px;margin-left:5px"/></td>
		                        <td>---</td>
		                         <td><input name="ecp4" type="text" class="input1" style="width:185px"/></td>		                        
		                    </tr>
		                    <tr id="t5" style="display: none;">
		                        <td colspan="2">&nbsp;</td>
		                        <td><select name="sel5" class="select">
		                       <option>choose</option>
		                      <option>chr1_merged_all_snp</option>
		                      <option>chr2_merged_all_snp</option>
		                      <option>chr3_merged_all_snp</option>		                        
		                        </select></td>
		                        <td><input name="exp5" type="text" class="input1" style="width:185px;margin-left:5px"/></td>
		                        <td>---</td>
		                         <td><input name="ecp5" type="text" class="input1" style="width:185px"/></td>	
		                    </tr>
		                    <tr id="t6" style="display: none;" >
		                        <td colspan="2">&nbsp;</td>
		                        <td><select name="sel6" class="select">
		                       <option>choose</option>
		                      <option>chr1_merged_all_snp</option>
		                      <option>chr2_merged_all_snp</option>
		                      <option>chr3_merged_all_snp</option>		                        
		                        </select></td>
		                        <td><input name="exp6" type="text" class="input1" style="width:185px;margin-left:5px"/></td>
		                        <td>---</td>
		                         <td><input name="ecp6" type="text" class="input1" style="width:185px"/></td>	
		                        <td>&nbsp;</td>
		                    </tr>
		                     
		                  </table>
		                  
		            
		              <br/>
		                <div>
		                  <span class="Phenotypicstrongblack">Phenotype</span><span class="Grand9">(Please select the phonotype features to search)</span> 
		                 </div>
		                 
		
					
	
             <table width="600" border="1"  cellpadding="5" cellspacing="1" bgcolor="#08b702">
					<tr>
						
					<td bgcolor="#FFFFFF" align="left">
	                    <p><a href="javascript: d.openAll();">open all</a> | <a href="javascript: d.closeAll();">close all</a></p>
						
							<script type="text/javascript">
								d = new dTree('d');
								
								d.add(0,-1,'Trait');
								d.add(1,0,'PhenotypeAgriTrait');
								d.add(2,0,'C');
								
						        <%for (int i=2;i<rrs.getMetaData().getColumnCount();i++){ %>
						
						            d.add(<%=i+1%>,1,'<%=rrs.getMetaData().getColumnName(i+1)%>');
					            <%}%>
								
								
								d.add(23,2,'C1');
								d.add(24,2,'C2');
								d.add(25,2,'C3');
                                document.write(d);
							</script>
						</td>
					</tr>
				</table>
											
		                 
	                    <div style="padding:5px 5px;">
	                    <input type="image" src="../images/button_08.jpg" onclick="return selectGoal22();"/>
	                  
	                    </div>
	                  </form>

        
        </div>
   </div>  
<!--主体部结束--> 
<!--版权信息开始--> 
<%@ include file="../ListFooter.jsp" %>
                                           
<!--版权结束-->
</body>
</html>
