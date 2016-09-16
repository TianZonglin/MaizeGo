<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@ page import="java.sql.*"%>

<%@ page language="java"%>


<link rel="StyleSheet" href="css/dtree.css" type="text/css" />
		<script type="text/javascript" src="Script/dtree.js">
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



<script type="text/javascript" src="images/jquery.js"></script>
<script type="text/javascript" src="images/scroll.js"></script>
<script type="text/javascript">
	$(document).ready(function(){ 
		$("#test").rotation("mouseover","li");
		$("#test1").rotation("mouseover","li");
	});
</script>
<link href="images/cloud.css" rel="stylesheet" type="text/css" />
<script src="images/xl.js" type="text/javascript">
</script>






<body>
   
	
			<form name="form1" action="/CloudCrm/cloudrgps/service.jsp" method="post">
				<p>&nbsp;
					
				</p>
				
				
				

				<table width="600" border="0" align="center" cellpadding="5"
					cellspacing="1" bgcolor="#6699CC">
					
				
					
					
					
					
					<tr>
						
						<td bgcolor="#FFFFFF" align="left">
							<script type="text/javascript">


		d = new dTree('d');
		//根据角色判断选择哪个目标树
 
			d.add(0,-1,'出行者');
		d.add(1,0,'<input type="checkbox" name="check" value="1" id="0" checked onclick="checkStatus(1,this)">安排出行计划');
		
		
		
		
		d.add(2,1,'<input type="checkbox" name="check" value="2" id="1" checked  onclick="checkStatus(2,this)">预订机票');
		d.add(3,1,'<input type="checkbox" name="check" value="3" id="1" checked disabled="true" onclick="checkStatus(3,this)">预定酒店');
		d.add(4,1,'<input type="checkbox" name="check" value="4" id="1" checked disabled="true" onclick="checkStatus(4,this)">查询天气信息');
		d.add(5,1,'<input type="checkbox" name="check" value="5" id="1" checked disabled="true" onclick="checkStatus(5,this)">选择出行方式');
		d.add(6,1,'<input type="checkbox" name="check" value="6" id="1" checked disabled="true" onclick="checkStatus(6,this)">显示出行计划');
		
		
		
		
		d.add(7,5,'<input type="checkbox" name="check" value="7" id="5" onclick="checkStatus(7,this)">选择公交出行');
		d.add(8,5,'<input type="checkbox" name="check" value="8" id="5" checked disabled="true" onclick="checkStatus(8,this)">选择自驾车出行');
		d.add(9,6,'<input type="checkbox" name="check" value="9" id="6" onclick="checkStatus(9,this)">地图显示出行计划');
		d.add(10,6,'<input type="checkbox" name="check" value="10" id="6" onclick="checkStatus(10,this)">音频显示出行计划');
		d.add(11,6,'<input type="checkbox" name="check" value="11" id="6" onclick="checkStatus(11,this)">短信显示出行计划');
		d.add(12,6,'<input type="checkbox" name="check" value="12" id="6" onclick="checkStatus(12,this)">视频显示出行计划');
		d.add(13,7,'<input type="checkbox" name="check" value="13" id="7" onclick="checkStatus(13,this)">根据站点查询公交');
		d.add(14,7,'<input type="checkbox" name="check" value="14" id="7" onclick="checkStatus(14,this)">根据线路查询公交');
		d.add(15,8,'<input type="checkbox" name="check" value="15" id="8" checked disabled="true" onclick="checkStatus(15,this)">查询路况信息');
		d.add(16,8,'<input type="checkbox" name="check" value="16" id="8" checked disabled="true" onclick="checkStatus(16,this)">查询加油站');
		d.add(17,8,'<input type="checkbox" name="check" value="17" id="8" checked disabled="true" onclick="checkStatus(17,this)">查询停车场');
		d.add(18,16,'<input type="checkbox" name="check" value="18" id="16" checked disabled="true" onclick="checkStatus(18,this)">确定当前位置');
		d.add(19,16,'<input type="checkbox" name="check" value="19" id="16" checked disabled="true" onclick="checkStatus(19,this)">获取加油站信息');
		d.add(20,17,'<input type="checkbox" name="check" value="20" id="17" onclick="checkStatus(20,this)">查询最近停车场');
		d.add(21,17,'<input type="checkbox" name="check" value="21" id="17" onclick="checkStatus(21,this)">查询可用停车场');
		d.add(22,19,'<input type="checkbox" name="check" value="22" id="19" onclick="checkStatus(22,this)">获取最近加油站');
		d.add(23,19,'<input type="checkbox" name="check" value="23" id="19" onclick="checkStatus(23,this)">获取特点范围内所有加油站');
		d.add(24,0,'<input type="checkbox" name="check" value="24" id="10" onclick="checkStatus(24,this)">出行者的其它目标','','Pictures I\'ve taken over the years','','','img/imgfolder.gif'); 
		
		document.write(d);
		
		

       
	
		
	</script>
						</td>
					</tr>
					
					
					
					
				

				</table>

			</form>
		
	          
	           
	           
	           
	           
	           
	           
	           
 

</body>

