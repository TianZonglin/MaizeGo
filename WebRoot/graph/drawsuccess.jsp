<%@ page contentType="text/html;charset=gbk"  import="java.util.*"  language="java" pageEncoding="UTF-8"%>
<%@ page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page import="org.hibernate.HibernateException"%>
<%@ page import="org.hibernate.Session"%>
<%@ page import="java.io.*" %> 



<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
		
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
  <script type="text/javascript" src="./js/canvasXpress.min.js"></script>
    <link rel="stylesheet" href="./css/canvasXpress.css" type="text/css"/>
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
  Map attribute=ActionContext.getContext().getSession(); 
     TreeSet node1=(TreeSet)attribute.get("node1");
	TreeSet node2=	(TreeSet)attribute.get("node2");
	TreeSet node3=(TreeSet)	attribute.get("node3");
	TreeSet node4=	(TreeSet)attribute.get("node4");
	TreeSet node12=	(TreeSet)attribute.get("node12");
	TreeSet node13=	(TreeSet)attribute.get("node13");
	TreeSet node14=	(TreeSet)attribute.get("node14");
	TreeSet node23=	(TreeSet)attribute.get("node23");
	TreeSet node24=	(TreeSet)attribute.get("node24");
	TreeSet node34=	(TreeSet)attribute.get("node34");
	TreeSet node123= (TreeSet)attribute.get("node123");
	TreeSet node124= (TreeSet)attribute.get("node124");
	TreeSet node134= (TreeSet)attribute.get("node134");
	TreeSet node234= (TreeSet)attribute.get("node234");
	TreeSet node1234= (TreeSet)attribute.get("node1234");
  String str=(String)attribute.get("str");
%> 
 <script id='demoScript'>

      var showDemo = function () {

        var cx1 = new CanvasXpress('canvas1',
          {
            'venn': {
              'data': {
                'A': <%=node1.toString()%>,
                'B': <%=node2.toString()%>,
                'C':<%=node3.toString()%>,
                'D': <%=node4.toString()%>,
                'AB': <%=node12.toString()%>,
                'AC': <%=node13.toString()%>,
                'AD': <%=node14.toString()%>,
                'BC': <%=node23.toString()%>,
                'BD': <%=node24.toString()%>,
                'CD': <%=node34.toString()%>,
                'ABC': <%=node123.toString()%>,
                'ABD': <%=node124.toString()%>,
                'ACD': <%=node134.toString()%>,
                'BCD': <%=node234.toString()%>,
                'ABCD': <%=node1234.toString()%>,
              },
              'legend': {
                'A': 'List 1',
                'B': 'List 2',
                'C': 'List 3',
                'D': 'List 4'
              }
            }
          },
          {'graphType': 'Venn',
          'vennGroups': 4}
        );

        var cx2 = new CanvasXpress('canvas2',
          {
            'venn': {
              'data': {
                'A': 340,
                'B': 562,
                'C': 620,
                'D': 592,
                'AB': 639,
                'AC': 456,
                'AD': 257,
                'BC': 915,
                'BD': 354,
                'CD': 143,
                'ABC': 552,
                'ABD': 578,
                'ACD': 298,
                'BCD': 613,
                'ABCD': 148
              },
              'legend': {
                'A': 'List 1',
                'B': 'List 2',
                'C': 'List 3',
                'D': 'List 4'
              }
            }
          },
          {'graphType': 'Venn',
          'vennGroups': 3}
        );

        var cx3 = new CanvasXpress('canvas3',
          {
            'venn': {
              'data': {
                'A': "340,123,245,356",
                'B': 562,
                'C': 620,
                'D': 592,
                'AB': 639,
                'AC': 456,
                'AD': 257,
                'BC': 915,
                'BD': 354,
                'CD': 143,
                'ABC': 552,
                'ABD': 578,
                'ACD': 298,
                'BCD': 613,
                'ABCD': 148
              },
              'legend': {
                'A': 'List 1',
                'B': 'List 2',
                'C': 'List 3',
                'D': 'List 4'
              }
            }
          },
          {'graphType': 'Venn',
          'vennGroups': 2}
        );

      }

      var showCode = function (e, id) {
        var cx = CanvasXpress.getObject(id)
        cx.stopEvent(e);
        cx.cancelEvent(e);
        cx.updateCodeDiv(10000);
        return false;
      }

    </script>

 
 
 
 
 
 
 
 
 
 
 
  
  
  
  <style type="text/css">
  .backgroundLiner {
    background-image: url("/maizego/img/bg.png");
    background-repeat: repeat;
}



  </style>
  
</head>



<body onload="showDemo();">
<script type="text/javascript">

function cnvs_getCoordinates(e)
{
        x=e.clientX+10;
		y=e.clientY;
		document.getElementById("xycoordinates").style.position="fixed";
		document.getElementById("xycoordinates").style.top=y+"px";
		document.getElementById("xycoordinates").style.left=x+"px";
		document.getElementById("xycoordinates").innerHTML="hello";
		
}
function cnvs_clearCoordinates()
{
document.getElementById("xycoordinates").innerHTML="";
}

function click(e)
{
        confirm("queding");
}

de</script>





 












<!--LOGO+导航开始-->
<%@ include file="/ListHeader.jsp" %>

<!--导航结束-->  
<!--主体部分开始-->  
<div class="main">
<div style="width:980px" align="center" class="content">	

	    
		<div>
		<table>
		
        <tr>
		<td style="width:840px;height:40px">	
			<canvas id="22222" width="840" height="640"class="backgroundLiner"  style="vertical-align:middle;" onmousemove="cnvs_getCoordinates(event)"onmouseout="cnvs_clearCoordinates()" onclick="click(event)" >		
			</canvas>
	    </td>
        </tr>   
	     </table>
		</div>





              <table class='example'>
                <tr>
                  <td  style="font-size: 13px;">
                    
                    <br>
                    <a href='' onclick='showCode(event, "canvas1")'>Show CanvasXpress Code</a>
                  </td>
                </tr>
                <tr>
                  <td><canvas id='canvas1' width='540' height='540'></canvas></td>
                </tr>
              </table><br/>





		
  <div id="xycoordinates" class="Phenotypicstrongblack" style="text-align:left;padding-top:10px;padding-bottom:10px"></div>
 
 </div>
 </div>
 
<script type = "text/javascript" language="javascript">

   
   	var canvas = document.getElementById("22222");
    var context = canvas.getContext("2d"); 
    //context.globalCompositeOperation = "lighter";
    //context.fillStyle="red"
    context.beginPath();
    //context.strokeStyle = "#009100";
     context.strokeStyle="red";
    context.lineWidth=5;
    context.arc(400,400,150,0,2*Math.PI, true);
   // context.fill();
    context.stroke();
    
    
    //context.globalCompositeOperation = "lighter";
    //context.fillStyle="yellow";
    //context.fillStyle="#FFFF00";
    context.beginPath();
    //context.strokeStyle = "#009100";
    context.strokeStyle="yellow";
    context.lineWidth=5;
    context.arc(300,200,150,0,2*Math.PI, true);
    //context.fill();
    context.stroke();
    
    
    //context.globalCompositeOperation = "lighter";
    //context.fillStyle="green";
    context.beginPath();
    //context.strokeStyle = "#009100";
    context.strokeStyle="green";
    context.lineWidth=5;
    context.arc(500,200,150,0,2*Math.PI, true);
    
    //context.fill();
    context.stroke();
    
    context.font="30px Georgia";
    context.fillText(<%=node1.toString()%>,300,200);
    context.fillText(<%=node2.toString()%>,500,200);
    context.fillText(<%=node12.toString()%>,400,200);
    context.fillText(<%=node123.toString()%>,400,280);
    context.fillText(<%=node3.toString()%>,400,400);
    context.fillText(<%=node13.toString()%>,350,300);
    context.fillText(<%=node23.toString()%>,450,300);
    context.font="20px Georgia";
    context.fillText("List1:",600,400);
    context.fillText("List2:",600,450);
    context.fillText("List3:",600,500);
    context.fillStyle="yellow";
    context.fillRect(600,400,80,10);
    context.fillStyle="green";
    context.fillRect(600,450,80,10);
    context.fillStyle="red";
    context.fillRect(600,500,80,10);
</script>	
<!--主体部结束--> 
<!--版权信息开始--> 
<%@ include file="/ListFooter.jsp" %>

</body>
</html>


