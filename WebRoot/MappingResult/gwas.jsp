
<%@ page contentType="text/html;charset=gbk" language="java"
	pageEncoding="UTF-8"%>
<%@ page import="org.util.DbBean"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="com.sun.rowset.CachedRowSetImpl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<title>MaizeGo DataMine Platform</title>

		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="maize" />
		<meta http-equiv="description" content="This is a database search engine of maize!" />



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

<style type="text/css">
.sel select {
	width: 130px;
	height: 200px
}
#sel2 {
	width: 160px;
}
#sel3 {
	width: 170px;
}
</style>


		<%		
	String []material={"B73/BY804","BY815/KUI3","DAN340/K22","DE3/BY815","K22/BY815","K22/CI7","KUI3/B77","YU87-1/BK","ZHENG58/SK","ZONG3/YU87-1"};
	
		 %>
         <%		
	String []material2={"chr1","chr2","chr3","chr4","chr5","chr6","chr7","chr8","chr9","chr10"};
	
		 %>
	</head>

	<body>
		<%@ include file="../ListHeader.jsp"%>
		<!--导航结束-->
		<!--主体部分开始-->
		<div class="main">

			<div id="Jobs">
				<div id="Jobs_caption">
					<ul>
						<li class="b">
							Mapping
							<br />
						</li>

					</ul>
				</div>
				 <div id="Jobs_content" style="font-size:16px; padding-left:10px;height:420px">
                   <form action="gwas.action" method="post" onsubmit="return check();">
					<div>
						<span class="Phenotypicstrongblack"><br />&nbsp;Input:</span><span class="Grand9">(Please select the Germpalsm-Traits:)</span>
					</div>

					<div class="sel">
						<select id="sel1" name="table"  size="5" class="select" style="margin-left:30px" onchange="secBoard();"></select>
						<select id="sel2" name="trait" multiple="multiple" size="5" class="select"></select>
						<select id="sel3" name="material"  size="5" class="select"></select>

					</div>


<br/>
			
					<div id="information" class="a">	
					
						<b style="color: #08b702;vertical-align:top">&nbsp;&nbsp;&nbsp;chr:</b>
						<select class="select" size="5"name="chr" id="phenotypeicmenujumpMenu"style="height:150px">

	<!--		        	<option value="0" value="0" selected>
								Search all chr
							</option>
							
						  -->		
							<option value="1" selected>
								chr1
							</option>
							<option value="2">
								chr2
							</option>
							<option value="3">
								chr3
							</option>
							<option value="4">
								chr4
							</option>	
							<option value="5">
								chr5
							</option>
							<option value="6">
								chr6
							</option>	
							<option value="7">
								chr7
							</option>
							<option value="8">
								chr8
							</option>
							<option value="9">
								chr9
							</option>
							<option value="10">
								chr10
							</option>																										
						</select>					
					
					
						<b style="color: #08b702;vertical-align:top">&nbsp;&nbsp;&nbsp;year:</b>
						<select class="select" name="year" id="phenotypeicmenujumpMenu"  size="5" style="height:150px">
				<!--		<option selected>
								Search all year
							</option>                            -->
							<option selected>
								2011
							</option>
							<option>
								2012
							</option>
						</select>


						<b style="color: #08b702;vertical-align:top">location:</b>
						<select class="select" name="location" id="phenotypeicmenujumpMenu" size="5" style="height:150px" >
	<!-- 					<option selected>
								Search all location
							</option>                              -->	
							<option selected>
								CQ
							</option>
							<option>
								HN
							</option>
							<option>
								YN
							</option>
							<option>
								HB
							</option>							
							<option>
								DHN
							</option>							
							
							
						</select>

					</div>               
                  <input style="margin-top: 10px" type="image"src="/maizego/images/button_08.jpg" height="36"width="100"/>
				</form>
				</div>
			</div>



			<!--右分栏结束-->
		</div>
		<!--主体部结束-->
		<!--版权信息开始-->
		<%@ include file="../ListFooter.jsp"%>
		<!--版权结束-->
	</body>



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
             {'val': 'Earlength','menu':[<%for(String mate:material2){%>{'val':"<%=mate%>"},<%}%>]
            },
           
            {'val': 'Earweight','menu':[<%for(String mate:material2){%>{'val':"<%=mate%>"},<%}%>]
	            },
            {'val': 'Rowsperear','menu':[<%for(String mate:material2){%>{'val':"<%=mate%>"},<%}%>]
	            }]
        },
        
        {'val': 'RIL', 'menu':[
	        {'val':'EarLength','menu':[<%for(String mate:material){%>{'val':"<%=mate%>"},<%}%>]},
	        {'val':'EarDiameter','menu':[<%for(String mate:material){%>{'val':"<%=mate%>"},<%}%>]},    
	        {'val':'EarRowNumber','menu':[<%for(String mate:material){%>{'val':"<%=mate%>"},<%}%>]},         
	        {'val':'RowKernelNumber','menu':[<%for(String mate:material){%>{'val':"<%=mate%>"},<%}%>]},     
	        {'val':'EarWeight','menu':[<%for(String mate:material){%>{'val':"<%=mate%>"},<%}%>]},        
	        {'val':'CobWeight','menu':[<%for(String mate:material){%>{'val':"<%=mate%>"},<%}%>]}    
         ]
         }

         
         
         
  
    ];
    
    var sel=["sel1", "sel2", "sel3"];
    
    var val=["AMP", "TST", "CHOOSE"];
    
    var cs = new CascadeSelect(sel, menu, { Default: val });
    

            var elem = document.getElementById("sel2");
          elem.options[0].selected = false;

   
    
}

function secBoard(){
		 var elem = document.getElementById("sel1");
		  var inf = document.getElementById("information");
		 if(elem.value=="AMP"){
		    inf.className="a";
		    $("#Jobs_content").css("height",330);
		 }else if(elem.value=="RIL"){
		      inf.className="b";
		        $("#Jobs_content").css("height",500);
		 }
}

function check(){
    var elem = document.getElementById("sel1");
    var elem1 = document.getElementById("sel2");
    var elem2 = document.getElementById("sel3");
    if(elem.value=="AMP"){
	     if(elem1.value==""){
	       alert("Trait can not be null");
	        return false;
	    }else if(elem2.value==""){
	       alert("Chr can not be null");
	        return false;
	    } 
}
  else if(elem.value=="RIL"){
	     if(elem1.value==""){
	       alert("Trait can not be null");
	        return false;
	    }else if(elem2.value==""){
	       alert("Material can not be null");
	        return false;
	    } 
  }
    return true;



}

</script>



</html>
