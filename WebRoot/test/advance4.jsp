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

  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">
  <meta http-equiv="keywords" content="maize">
  <meta http-equiv="description" content="This is a database search engine of maize!">
  
  <link rel="stylesheet" href="../css/cb24.css" type="text/css"/>
  <link href="../css/bg.css" rel="stylesheet" type="text/css" />
  <link href="../css/link.css" rel="stylesheet" type="text/css" />
  <link href="../css/exhibition.css" rel="stylesheet" type="text/css" />
  
  
    <link href="../Script/search.css" rel="stylesheet" type="text/css" />
    <script language="javascript" type="text/javascript" src="http://g.wanfangdata.com.cn/share/Script/jquery-1.7.1.min.js"></script>
    <script language="javascript" type="text/javascript" src="../Script/search.js"></script>
    
    
    
    
<link rel="StyleSheet" href="../css/dtree.css" type="text/css" />
		<script type="text/javascript" src="../Script/dtree.js">
        </script>
  
  <script language="javascript">

          function selectGoal(){
	   var role2='ttttt';
	   var domain_name='rrrrr';
	   var obj=document.getElementsByName("check");
       if(role2=="销售人员"){
		 
	     if(obj[7].checked==true||obj[8].checked==true){
	        window.location="/CloudCrm/cloudrgps/process.jsp?role="+role2+"&domain_name="+domain_name;
	     }
	     else{
		    alert("目标'文本显示'和'地图显示'至少选一个！");
	     }
	   }else if(role2=="市场人员"){

		 if(obj[2].checked==true||obj[3].checked==true||obj[4].checked==true){
	       window.location="/CloudCrm/cloudrgps/process.jsp?role="+role2+"&domain_name="+domain_name;
	     }
	     else{
		    alert("目标'通过电话获取'、'通过邮件获取'和'通过文档获取'至少选一个！");
	     }
	   }else{
		 window.location="/CloudCrm/cloudrgps/process.jsp?role="+role2+"&domain_name="+domain_name;  
	   }
	  
   }
</script>
  
  
  <script language="javascript">
function execute_market_service()
{  



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
	$(document).ready(function(){ 
		$("#test").rotation("mouseover","li");
		$("#test1").rotation("mouseover","li");
	});
</script>

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
<!--top开始-->

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
      <!--左分栏开始-->
    
      <!--右分栏开始-->
    <div class="span_32 r_0"> 
      <div class="span_32 l_0 r_0 margin_tf">
	  
        <div class="R3_bg"><span class="White14">Advanced Search</span></div>
		
        <div class="R10_p">
        <div class="xinzen">
                 
	                  <form name="form" id="phenotypic_scopesearch"  method="post" action="advancese.action">
	                    <div>
	                    
	                    <div>
	                     <span class="Phenotypicstrongblack"><br />&nbsp;Input:</span><span class="Grand9">(Please input the traits to search)</span> 
	                    </div>
	                    
	                    <textarea class=button11 id=Content name="germplasmname" rows=7
									cols=30 style="width: 225px;height: 100px; border: 1px solid #CCC;"></textarea>
	                    
	                        
	                        
	                        
			      
			                <input class="searchphenotypic" type="file" value="upload" name="upload" style="width:180px;">
	                    </div>
	            
	
	
	
	
	
	                    <div>
	                     <span class="Phenotypicstrongblack"><br />&nbsp;Genotype</span><span class="Grand9">(Please input the gonotype features to search)</span> 
	                    </div>



<div>
		year:		<select  class="selectlen" name="year" id="phenotypeicmenujumpMenu">
		                      <option>Search all year</option>
		                      <option>2011</option>
		                      <option>2012</option>
		                      <option>2013</option>
		                   
	                    </select>		
						

			location:	<select  class="selectlen" name="location" id="phenotypeicmenujumpMenu">
		                      <option>Search all location</option>
		                      <option>CQ</option>
		                      <option>HN</option>
		                   
	                    </select>
	                    

			trait:	<select  class="selectlen" name="trait" id="phenotypeicmenujumpMenu">
		                      <option>Search all trait</option>
		                      <option>HKW</option>
		                     
	                    </select>
						
						
						
						
					</div>	
						
						
						
						
						
						
						
			             <div id="AdvancedSearchList">&nbsp; 
		                   <table id="SeniorSearchTable" cellpadding="0" cellspacing="0" style="border-collapse:collapse;">
		                    <tr id="s1">
		                        <td ><input id="addqbtn" type="button" class="w-button1" onclick="javascript:addQueryCondition();"  /></td>
		                        <td ><input id="redqbtn" onclick="javascript:reduceQueryCondition();" class="w-button2" type="button" /></td>
		                        <td><select name="sel"  class="td2">
		                        
		                      <option>choose</option>
		                      <option>chr1_merged_all_snp</option>
		                      <option>chr2_merged_all_snp</option>
		                      <option>chr3_merged_all_snp</option>
		                   
		                      
		                      </select></td>
		                        <td><input name="exp" type="text" class="input_1" /></td><td>——</td>
		                         <td><input name="ecp" type="text" class="input_1" /></td>
		                    </tr>
		                            <tr id="s2">
		                        <td colspan="2">&nbsp;</td>
		                        <td> <select name="sel1" class="td2">
		                          <option>choose</option>
		                      <option>chr1_merged_all_snp</option>
		                      <option>chr2_merged_all_snp</option>
		                      <option>chr3_merged_all_snp</option>
		                   
		                      </select></td>
		                        <td><input name="exp1" type="text" class="input_1" /></td>
		                        <td>——</td>
		                         <td><input name="ecp1" type="text" class="input_1" /></td>
		                    </tr>
		                      <tr id="s3">
		                        <td colspan="2">&nbsp;</td>
		                        <td><select name="sel2" class="td2"></select></td>
		                        <td><input name="exp2" type="text" class="input_1" /></td>
		                    </tr>
		                    <tr id="s4" style="display: none;">
		                        <td colspan="2">&nbsp;</td>
		                        <td><select name="sel3" class="td2"></select></td>
		                        <td><input name="exp3" type="text" class="input_1" /></td>
		                    </tr>
		                    <tr id="s5" style="display: none;">
		                        <td colspan="2">&nbsp;</td>
		                        <td><select name="sel4" class="td2"></select></td>
		                        <td><input name="exp4" type="text" class="input_1" /></td>
		                    </tr>
		                    <tr id="s6" style="display: none;" >
		                        <td colspan="2">&nbsp;</td>
		                        <td><select name="sel5" class="td2"></select></td>
		                        <td><input name="exp5" type="text" class="input_1" /></td>
		                        <td>&nbsp;</td>
		                    </tr>
		                  </table>
		                  
		                </div> 
		                
		                <div>
		                  <span class="Phenotypicstrongblack">Phenotype</span><span class="Grand9">(Please select the phonotype features to search)</span> 
		                 </div>
		                 
		                 
		                 
		                 	<table width="600" border="0" align="center" cellpadding="5"
					cellspacing="1" bgcolor="#6699CC">
					
				
					
					
					
					
					<tr>
						
						<td bgcolor="#FFFFFF" align="left">
							<script type="text/javascript">


		d = new dTree('d');
		//根据角色判断选择哪个目标树
 
			d.add(0,-1,'PhenotypeAgriTrait');
		d.add(1,0,'<input type="checkbox" name="cel" value="" id="0"  onclick="checkStatus(1,this)">');
		
		
		        <%for (int i=1;i<rrs.getMetaData().getColumnCount();i++){
		                       %>
		
		d.add(<%=i+1%>,1,'<input type="checkbox" name="cel" value="<%=rrs.getMetaData().getColumnName(i+1)%>" id="1" onclick="checkStatus(2,this)"><%=rrs.getMetaData().getColumnName(i+1)%>');

		
		
		
	    <%
		                      } %>
		document.write(d);
		
		

       
	
		
	</script>
						</td>
					</tr>
					
					
					
					
				

				</table>
		                 
		                 
		                 
		              
						
						
						
						
						
	
		
		
		
		
		
		
						
		                
		             <!--    
		                <div id="AdvancedSearchList">&nbsp;
		                   <table id="SeniorSearchTable" cellpadding="0" cellspacing="0" style="border-collapse:collapse;">
		                    <tr id="t1">
		                        <td ><input id="addqbtn" type="button" class="w-button1" onclick="javascript:addQueryConditiont();"  /></td>
		                        <td ><input id="redqbtn" onclick="javascript:reduceQueryConditiont();" class="w-button2" type="button" /></td>
		                        <td><select name="selt"  class="td2"></select></td>
		                        <td><input name="expt" type="text" class="input_1" /></td>
		                    </tr>
		                    <tr id="t2">
		                        <td colspan="2">&nbsp;</td>
		                        <td> <select name="selt" class="td2"></select></td>
		                        <td><input name="expt" type="text" class="input_1" /></td>
		                    </tr>
		                    <tr id="t3">
		                        <td colspan="2">&nbsp;</td>
		                        <td><select name="selt" class="td2"></select></td>
		                        <td><input name="expt" type="text" class="input_1" /></td>
		                    </tr>
		                    <tr id="t4" style="display: none;">
		                        <td colspan="2">&nbsp;</td>
		                        <td><select name="selt" class="td2"></select></td>
		                        <td><input name="expt" type="text" class="input_1" /></td>
		                    </tr>
		                    <tr id="t5" style="display: none;">
		                        <td colspan="2">&nbsp;</td>
		                        <td><select name="selt" class="td2"></select></td>
		                        <td><input name="expt" type="text" class="input_1" /></td>
		                    </tr>
		                    <tr id="t6" style="display: none;" >
		                        <td colspan="2">&nbsp;</td>
		                        <td><select name="selt" class="td2"></select></td>
		                        <td><input name="expt" type="text" class="input_1" /></td>
		                        <td>&nbsp;</td>
		                    </tr>
		                  </table>
		                </div> 
		             -->    
		                
						
						
	
	                    <div>
	                     <input class="searchphenotypic" type="submit" value="search" style="width:80px;" onclick="return selectGoal22();"> 
	                    </div>
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
      <div class="padding_tf"><img src="../pic/foot.gif" width="940" height="5" /></div>
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
