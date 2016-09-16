
<%@ page contentType="text/html;charset=gbk" language="java"
	pageEncoding="UTF-8"%>
<%@ page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page import="org.hibernate.Session"%>
<%@ page import="java.util.*"%>
<%@ page import="org.db.phenoype_agri_traits.*"%>
<%@ page import="org.hibernate.HibernateException"%>
<%@ page import="org.hibernate.Session"%>
<%@ page import="org.util.DbBean"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="org.bean.*"%>
<%@ page import="com.sun.rowset.CachedRowSetImpl"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<title>MaizeGo DataMine Platform</title>

		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="maize" />
		<meta http-equiv="description"
			content="This is a database search engine of maize!" />




		<!-- 新版本添加的 -->
		<link href="../style.css" type="text/css" rel="stylesheet" />
		<script type="text/javascript" src="../js/jquery-1.4.2.min.js"></script>
		<script type="text/javascript" src="../js/jquery.fancybox-1.3.4.js"></script>
		<script type="text/javascript" src="../js/jquery.mousewheel-3.0.4.js"></script>
		<link rel="stylesheet" type="text/css"
			href="../css/jquery.fancybox-1.3.4.css" media="screen" />
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
	CachedRowSetImpl rs1=Seed.getFieldFrom("seed_amp x mo17 f1");	
	CachedRowSetImpl rs2=Seed.getFieldFrom("seed_amp x zheng58 f1");	
	CachedRowSetImpl rs3=Seed.getFieldFrom("seed_amp");
	CachedRowSetImpl rs4=Seed.getFieldFrom("seed_b73/by804");	
	CachedRowSetImpl rs5=Seed.getFieldFrom("seed_kui3/b77");	
	CachedRowSetImpl rs6=Seed.getFieldFrom("seed_k22/ci7");	
	CachedRowSetImpl rs7=Seed.getFieldFrom("seed_d340/k22");	
	CachedRowSetImpl rs8=Seed.getFieldFrom("seed_zheng58/sk");	
	CachedRowSetImpl rs9=Seed.getFieldFrom("seed_mo17/x26-4");	
	CachedRowSetImpl rs10=Seed.getFieldFrom("seed_yu8701/bk");	
	CachedRowSetImpl rs11=Seed.getFieldFrom("seed_zong3/yu87-1");		
%>



<script type="text/javascript">
function noPermitInput(e){     
       var evt = window.event || e ;   
        if(isIE()){   
            evt.returnValue=false; //ie 禁止键盘输入   
        }else{   
            evt.preventDefault(); //fire fox 禁止键盘输入   
        }      
}   
function isIE() {   
    if (window.navigator.userAgent.toLowerCase().indexOf("msie") >= 1)   
        return true;   
    else   
        return false;   
}    
	
	function check(){
	//var number=document.getElementById("number").value;
	var name=document.getElementById("name").value;
	if(name.length==0){
	    //document.getElementById("tip").innerHTML="name is illegal!";
	    alert("Error: name is illegal !");
	   return false;
	
	 }
	 return true;
	}
	/*
	if(number.length==0||isNaN(number)){
	   document.getElementById("tip").innerHTML="number is illegal!";
	   return false;
	   }
	}
	*/
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
     
        
        {'val': 'AMP X MO17 F1', 'menu': [
            <%while(rs1.next()){ if(rs1.getString(1).endsWith("_NAME")){%>
	        {'val':"<%=rs1.getString(1)%>"},<%}}%>]
        },
        
        {'val': 'AMP X ZHENG58 F1', 'menu':[
            <%while(rs2.next()){ if(rs2.getString(1).endsWith("_NAME")){%>
	        {'val':"<%=rs2.getString(1)%>"},<%}}%>]
        },
  
         {'val': 'AMP', 'menu':[
            <%while(rs3.next()){ if(rs3.getString(1).endsWith("_NAME")){%>
	        {'val':"<%=rs3.getString(1)%>"},<%}}%>]
        }, 
  
         {'val': 'B73/BY804', 'menu':[
            <%while(rs4.next()){ if(rs4.getString(1).endsWith("_NAME")){%>
	        {'val':"<%=rs4.getString(1)%>"},<%}}%>]
        }, 
  
         {'val': 'KUI3/B77', 'menu':[
            <%while(rs5.next()){ if(rs5.getString(1).endsWith("_NAME")){%>
	        {'val':"<%=rs5.getString(1)%>"},<%}}%>]
        }, 
  
         {'val': 'K22/CI7', 'menu':[
            <%while(rs6.next()){ if(rs6.getString(1).endsWith("_NAME")){%>
	        {'val':"<%=rs6.getString(1)%>"},<%}}%>]
        },
        
        
         {'val': 'D340/K22', 'menu':[
            <%while(rs7.next()){ if(rs7.getString(1).endsWith("_NAME")){%>
	        {'val':"<%=rs7.getString(1)%>"},<%}}%>]
        },       
        
        
          {'val': 'ZHENG58/SK', 'menu':[
            <%while(rs8.next()){ if(rs8.getString(1).endsWith("_NAME")){%>
	        {'val':"<%=rs8.getString(1)%>"},<%}}%>]
        },      
        
        
            {'val': 'MO17/X26-4', 'menu':[
            <%while(rs9.next()){ if(rs9.getString(1).endsWith("_NAME")){%>
	        {'val':"<%=rs9.getString(1)%>"},<%}}%>]
        },    
        
        
            {'val': 'YU8701/BK', 'menu':[
            <%while(rs10.next()){ if(rs10.getString(1).endsWith("_NAME")){%>
	        {'val':"<%=rs10.getString(1)%>"},<%}}%>]
        },    
        
        
            {'val': 'ZONG3/YU87-1', 'menu':[
            <%while(rs11.next()){ if(rs11.getString(1).endsWith("_NAME")){%>
	        {'val':"<%=rs11.getString(1)%>"},<%}}%>]
        }  
        
        
        
        
        
        
         
  
    ];
    
    var sel=["sel1", "sel2"];
    
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








	</head>

	<body>
		<%@ include file="../ListHeader.jsp"%>
		<%if(user==null)response.sendRedirect("/maizego"); %>
		<!--导航结束-->
		<!--主体部分开始-->
		<!--导航结束-->
		<!--主体部分开始-->
		<%   
	request.setCharacterEncoding("UTF-8");

 response.setCharacterEncoding("UTF-8"); %>
		<div class="main">

			<div id="Jobs_caption">
				<ul>
					<li class="b" >Seed Info Search </li>
				</ul>
			</div>
			<div id="Jobs_content" style="font-size:16px; padding-left:10px;height:420px">
				<form name="form1" id="phenotypic" method="post"
					action="seedBorrow.action" onsubmit="return check();">



					<div class="sel">
						<span class="Phenotypicstrongblack">Table:</span>
						<select id="sel1" name="table" class="select"></select>
						<span class="Phenotypicstrongblack">Type:</span>
						<select id="sel2" name="type" class="select"></select>
						
						<span class="Grand9">&nbsp; &nbsp;</span>
						<span class="Phenotypicstrongblack">Name:</span>
						<input id="name" type="text" name="name" class="input1"
							onkeyup="value=value.replace(/[^\a-\z\A-\Z0-9]/g,'')"
							style="ime-mode: disabled" />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input style="margin-top: 5px" type="image"
							src="../images/button_08.jpg" height="36" width="100" />

						<span id="tip"></span>
					</div>


				</form>
			</div>
		</div>

		<!--主体部结束-->
		<!--版权信息开始-->
		<%@ include file="../ListFooter.jsp"%>
		<!--版权结束-->
	</body>
</html>
