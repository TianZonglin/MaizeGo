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
    <script type="text/javascript" src="../Script/dtree.js"> </script>  
    
    
    
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
    
    
    
    
    

	
		<%
		DbBean dbb=new DbBean();
		ResultSet rs;
		String sqll="SELECT `LINES` FROM germplasmlines;";
		rs=dbb.executeQuery(sqll);
		 %>
  
<script type="text/javascript" language="javascript">
function check1(){
var sel=document.getElementById('sel').value;
var sel2=document.getElementById('sel2_choose').value;
var exp=document.getElementById('exp').value;
var ecp=document.getElementById('ecp').value;
var exp2=document.getElementById('exp2').value;
var ecp2=document.getElementById('ecp2').value;	 
if(sel!="choose")
{
       if(exp.length==0||isNaN(exp)||exp.length>10||exp<0){	   
      // document.getElementById('tip1').innerHTML='minpos is not legal';
       alert("exp is illegal");
       document.form.exp.focus();
       return false;            
           }else if(ecp.length==0||isNaN(ecp)||ecp.length>10||parseInt(ecp)<=parseInt(exp)){
          // document.getElementById('tip1').innerHTML='&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;maxpos is illegal';
          alert("ecp is illegal");
           document.form.ecp.focus();
           return false;
           }
 }  
 if(sel2!="choose"){
  if(exp2.length==0||isNaN(exp2)||exp2.length>10||exp2<0){		   
       //document.getElementById('tip2').innerHTML='&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;minpos is not legal';
        alert("exp2 is illegal");
       document.form.exp2.focus();
       return false;            
           }else if(ecp2.length==0||isNaN(ecp2)||ecp2.length>10||parseInt(ecp2)<=parseInt(exp2)){
           //document.getElementById('tip2').innerHTML='&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;maxpos is illegal';
            alert("ecp2 is illegal");
           document.form.ecp2.focus();
           return false;
           }
     }
     document.form.submit();


}

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


<script type="text/javascript">
var $id = function (id) {
    return "string" == typeof id ? document.getElementById(id) : id;
};

function addEventHandler(oTarget, sEventType, fnHandler) {
    if (oTarget.addEventListener) {
        oTarget.addEventListener(sEventType, fnHandler, false);
    } else if (oTarget.attachEvent) {
        oTarget.attachEvent("on" + sEventType, fnHandler);
    } else {
        oTarget["on" + sEventType] = fnHandler;
    }
};

function Each(arrList, fun){
    for (var i = 0, len = arrList.length; i < len; i++) { fun(arrList[i], i); }
};

function GetOption(val, txt) {
    var op = document.createElement("OPTION");
    op.value = val; op.innerHTML = txt;
    return op;
};

var Class = {
  create: function() {
    return function() {
      this.initialize.apply(this, arguments);
    }
  }
}

Object.extend = function(destination, source) {
    for (var property in source) {
        destination[property] = source[property];
    }
    return destination;
}


var CascadeSelect = Class.create();
CascadeSelect.prototype = {
  //select集合，菜单对象
  initialize: function(arrSelects, arrMenu, options) {
    if(arrSelects.length <= 0 || arrMenu.lenght <= 0) return;//菜单对象
    
    var oThis = this;
    
    this.Selects = [];//select集合
    this.Menu = arrMenu;//菜单对象
    
    this.SetOptions(options);
    
    this.Default = this.options.Default || [];
    
    this.ShowEmpty = !!this.options.ShowEmpty;
    this.EmptyText = this.options.EmptyText.toString();
    
    //设置Selects集合和change事件
    Each(arrSelects, function(o, i){
        addEventHandler((oThis.Selects[i] = $id(o)), "change", function(){ oThis.Set(i); });
    });
    
    this.ReSet();
  },
  //设置默认属性
  SetOptions: function(options) {
    this.options = {//默认值
        Default:    [],//默认值(按顺序)
        ShowEmpty:    false,//是否显示空值(位于第一个)
        EmptyText:    "请选择"//空值显示文本(ShowEmpty为true时有效)
    };
    Object.extend(this.options, options || {});
  },
  //初始化select
  ReSet: function() {
  
    this.SetSelect(this.Selects[0], this.Menu, this.Default.shift());
    this.Set(0);
  },
  //全部select设置
  Set: function(index) {
    var menu = this.Menu
    
    //第一个select不需要处理所以从1开始
    for(var i=1, len = this.Selects.length; i < len; i++){
        if(menu.length > 0){
            //获取菜单
            var value = this.Selects[i-1].value;
            if(value!=""){
                Each(menu, function(o){ if(o.val == value){ menu = o.menu || []; } });
            } else { menu = []; }
            
            //设置菜单
            if(i > index){ this.SetSelect(this.Selects[i], menu, this.Default.shift()); }
        } else {
            //没有数据
            this.SetSelect(this.Selects[i], [], "");
        }
    }
    //清空默认值
    this.Default.length = 0;
  },
  //select设置
  SetSelect: function(oSel, menu, value) {
    oSel.options.length = 0; oSel.disabled = false;
    if(this.ShowEmpty){ oSel.appendChild(GetOption("", this.EmptyText)); }
    if(menu.length <= 0){ oSel.disabled = true; return; }
    
    Each(menu, function(o){
        var op = GetOption(o.val, o.txt ? o.txt : o.val); op.selected = (value == op.value);
        oSel.appendChild(op);
    });    
  },
  //添加菜单
  Add: function(menu) {
    this.Menu[this.Menu.length] = menu;
    this.ReSet();
  },
  //删除菜单
  Delete: function(index) {
    if(index < 0 || index >= this.Menu.length) return;
    for(var i = index, len = this.Menu.length - 1; i < len; i++){ this.Menu[i] = this.Menu[i + 1]; }
    this.Menu.pop()
    this.ReSet();
  }
};


window.onload=function(){
    
    var menu = [
     
        
        {'val': 'AMP', 'menu': [
            {'val': 'TST','menu':[
            <%while(rs.next()){%>
	            {'val':"<%=rs.getString(1)%>"},<%}%>]
            },
            {'val': 'SS'},
            {'val': 'NSS'},
            {'val': 'MIX'}]
        },
        
        {'val': ' RIL', 'menu':[
        {'val':'BB'},
      
         {'val':'SZ'}
         ]
         }
  
    ];
    
    var sel=["sel1", "sel2", "sel3"];
    
    var val=["AMP", "TST", "CHOOSE"];
    
    var cs = new CascadeSelect(sel, menu, { Default: val });
    
    $id("btnA").onclick=function(){cs.ShowEmpty=!cs.ShowEmpty;}
    
    $id("btnB").onclick=function(){
        cs.Add(
            {'val': '5 ->', 'menu': [
                {'val': '5_1 ->', 'menu': [
                    {'val': '5_1_1 ->', 'menu': [
                        {'val': '5_1_1_1 ->', 'menu': [
                            {'val': '5_1_1_1_1'}
                        ]}
                    ]}
                ]}
            ]}
        )
    }
    
    $id("btnC").onclick=function(){
        cs.Delete(3)
    }
}





</script>

<style type="text/css">


.sel select{ width:100px;height:200px}
#sel3{ width:170px;}
</style>


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


<%@ include file="../ListHeader.jsp"%>


<!--导航结束-->  
<!--主体部分开始-->  
<div class="main">
	
     
	  
         <h3 class="tit" style="border-bottom:2px solid #08b702; padding-bottom:5px; color:#08b702;"><span>Advanced Search</span></h3>
            <div id="Advance_content">       
	                  <form name="form" id="phenotypic_scopesearch"  method="post" action="advance_blup.action" onsubmit="return check1();">       
	                    <div>
	                     <span class="Phenotypicstrongblack"><br />&nbsp;Input:</span><span class="Grand9">(Please input the traits to search)</span> 
	                    </div>
            
	                   <div class="sel">
							<select id="sel1"name="inp1"multiple="multiple" size="5" class="select"></select>
							<select id="sel2"name="inp2"multiple="multiple" size="5" class="select"></select>
							<select id="sel3"name="germplasmname"multiple="multiple" class="select"></select>

                       </div>

	            

	                    <div>
	                     <span class="Phenotypicstrongblack"><br />&nbsp;Trait</span><span class="Grand9">(Please select the trait features to search)</span> 
	                    </div>
<div class="trait_css">

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
						
		</div>
						<div class="trait">
		                 <div>
	                     <span class="Phenotypicstrongblack"><br />&nbsp;Genotype</span><span class="Grand9">(Please input the gonotype features to search)</span> 
	                    </div>	
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
		                  
		           
		               
		                 
		             
		                
		            
		   
			
			<div>
		                  <span class="Phenotypicstrongblack"><br />&nbsp;Phenotype</span><span class="Grand9">(Please select the phonotype features to search)</span> 
		               
		                 </div>

             <table width="600" border="1"  cellpadding="5" bgcolor="#08b702">
					<tr>						
					<td bgcolor="#FFFFFF" >
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
				
				

					
		
		
		
						
		                
		             <!--    
		                <div id="AdvancedSearchList">&nbsp;
		                   <table id="SeniorSearchTable" cellpadding="0" cellspacing="0" style="border-collapse:collapse;">
		                    <tr id="t1">
		                        <td ><input id="addqbtn" type="button" class="w-button1" onclick="javascript:addQueryConditiont();"  /></td>
		                        <td ><input id="redqbtn" onclick="javascript:reduceQueryConditiont();" class="w-button2" type="button" /></td>
		                        <td><select name="selt"  class="select"></select></td>
		                        <td><input name="expt" type="text" class="input1" /></td>
		                    </tr>
		                    <tr id="t2">
		                        <td colspan="2">&nbsp;</td>
		                        <td> <select name="selt" class="select"></select></td>
		                        <td><input name="expt" type="text" class="input1" /></td>
		                    </tr>
		                    <tr id="t3">
		                        <td colspan="2">&nbsp;</td>
		                        <td><select name="selt" class="select"></select></td>
		                        <td><input name="expt" type="text" class="input1" /></td>
		                    </tr>
		                    <tr id="t4" style="display: none;">
		                        <td colspan="2">&nbsp;</td>
		                        <td><select name="selt" class="select"></select></td>
		                        <td><input name="expt" type="text" class="input1" /></td>
		                    </tr>
		                    <tr id="t5" style="display: none;">
		                        <td colspan="2">&nbsp;</td>
		                        <td><select name="selt" class="select"></select></td>
		                        <td><input name="expt" type="text" class="input1" /></td>
		                    </tr>
		                    <tr id="t6" style="display: none;" >
		                        <td colspan="2">&nbsp;</td>
		                        <td><select name="selt" class="select"></select></td>
		                        <td><input name="expt" type="text" class="input1" /></td>
		                        <td>&nbsp;</td>
		                    </tr>
		                  </table>
		                </div> 
		             -->    
		                
						
						
	
	                    <div style="padding:5px 5px;">
	                    <input type="image" src="../images/button_08.jpg" onclick="return selectGoal22();"/>	                  
	                    </div>  
	                    
	                  </form>	

        </div>
 </div>       
<!--主体部结束--> 
<!--版权信息开始--> 
<%@ include file="../ListFooter.jsp"%>

</body>
</html>
