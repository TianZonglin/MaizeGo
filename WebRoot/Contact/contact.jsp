<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=gbk" language="java" pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>MaizeGo DataMine Platform</title>


	<script type="text/javascript" src="http://api.map.baidu.com/api?v=1.5&ak=954577783a062a2573db29b5b12290fc"></script>
<script src="http://d1.lashouimg.com/static/js/release/jquery-1.4.2.min.js" type="text/javascript"></script>  
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
</head>

<body>
<%@ include file="../ListHeader.jsp"%>
<div class="main"style="height:540px">
<h3 class="tit" style="border-bottom:2px solid #08b702; padding-bottom:5px; color:#08b702;"><span>CONTACT US</span></h3>
<p  class="tit"style="color:#08b702">National Key Laboratory of Crop Genetic Improvement<br/>
 Huazhong Agricultural University Wuhan 430070, China<br/>

Phone:86-27-87280110<br/>
Email:yjianbing@gmail.com

  
  
  <p> </p>
  <br/>
  <div></div> 
 <!--   <div style="width:800px;height:400px;border:1px solid gray;float:left" id="container"></div>   -->


 </div>




     
     
<%@ include file="../ListFooter.jsp" %>

</body>
</html>







  
 



<script type="text/javascript">  
	var map = new BMap.Map('container');
	map.centerAndZoom(new BMap.Point(114.365,30.482), 15);
    map.enableScrollWheelZoom();
    	
	var icon = new BMap.Icon("/maizego/images/button_08.jpg", new BMap.Size(20, 25), {
	    anchor: new BMap.Size(10, 30),
	     infoWindowAnchor: new BMap.Size(10, 0)
	});
	
	var marker = new BMap.Marker(new BMap.Point(114.364,30.480), {
	    icon: icon
	});
	
	map.addOverlay(marker);
	
  
      
    var licontent="<b>华中农业大学生命科学技术学院</b><br>";  
        licontent+="<span><strong>地址：</strong></span>作物遗传改良重点实验室<br>";  
        licontent+="<span><strong>电话：</strong>86-27-87280110</span><br>";  
        licontent+="<span class=\"input\"><strong></strong><input class=\"outset\" type=\"text\" name=\"origin\" value=\"华中农业大学\"/><input class=\"outset-but\" type=\"button\" value=\"公交\" onclick=\"gotobaidu(1)\" /><input class=\"outset-but\" type=\"button\" value=\"驾车\"  onclick=\"gotobaidu(2)\"/><a class=\"gotob\" href=\"url=\"http://api.map.baidu.com/direction?destination=latlng:"+marker.getPosition().lat+","+marker.getPosition().lng+"|name:天安门"+"®ion=北京"+"&output=html\" target=\"_blank\"></a></span>";
 
    var hiddeninput="<input type=\"hidden\" value=\""+'武汉'+"\" name=\"region\" /><input type=\"hidden\" value=\"html\" name=\"output\" /><input type=\"hidden\" value=\"driving\" name=\"mode\" /><input type=\"hidden\" value=\"latlng:"+marker.getPosition().lat+","+marker.getPosition().lng+"|name:华中农业大学"+"\" name=\"destination\" />";
 
    var content1 ="<form id=\"gotobaiduform\" action=\"http://api.map.baidu.com/direction\" target=\"_blank\" method=\"get\">" + licontent +hiddeninput+"</form>";
   
    var opts1 = { width: 250 };  
       
    var  infoWindow = new BMap.InfoWindow(content1, opts1);  
    marker.openInfoWindow(infoWindow);  
    marker.addEventListener('click',function(){
        marker.openInfoWindow(infoWindow);
    });  
     
    function gotobaidu(type)  
    {  
        if($.trim($("input[name=origin]").val())=="")  
        {  
            alert("请输入起点！");  
            return;  
        }else{  
            if(type==1)  
            {  
                $("input[name=mode]").val("transit");  
                $("#gotobaiduform")[0].submit();  
            }else if(type==2)  
            {      
                $("input[name=mode]").val("driving");          
                $("#gotobaiduform")[0].submit();  
            }  
        }  
    }    
</script>
