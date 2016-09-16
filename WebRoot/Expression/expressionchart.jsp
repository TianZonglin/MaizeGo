<%@ page contentType="text/html;charset=gbk"  import="java.util.*"  language="java" pageEncoding="UTF-8"%>
<%@ page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page import="org.db.phenotypes_294_rils_441_crosses.*"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.util.Map"%>
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
<link href="../style.css" type="text/css" rel="stylesheet" />

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
  
  
  
  

  
  

<script type="text/javascript" src="../Script/jquery-1.7.1.js"></script>
<script type="text/javascript" src="../js/highcharts.js"></script>
<script type="text/javascript" src="../js/modules/exporting.src.js"></script>  

		<%
		  Map attributes=ActionContext.getContext().getSession();
		  ArrayList trait=(ArrayList)attributes.get("trait");
		   ArrayList material=(ArrayList)attributes.get("material");
		  ArrayList[] name=new ArrayList[material.size()];
		 // System.out.println(name.length);
		  for(int i=0;i<material.size();i++)
		  {
		     String a=(String)material.get(i);
		     name[i]=(ArrayList)attributes.get(a);
		     //System.out.println(name[i].toString());		  
		  }
           System.out.println(name[0].size());
		 %>

	<script type="text/javascript">
$(function () {
        $('#container').highcharts({
            chart: {
                type: 'line',
                zoomType: 'xy',
                width:850
                //plotBackgroundImage:"../img/bg.png"
            },
            title: {
                text: 'The Information of Expression'
            },
            subtitle: {
                text: 'Source: Expression'
            },
            xAxis: {
                tickInterval:1000,
                title: {
                    enabled: true,
                    text: 'pos'
                },
                //startOnTick: true,
                endOnTick: true,
                showLastLabel: true,
                categories:[<%for(int t=0;t<trait.size();t++){%><%=(String)trait.get(t)%>,<%}%>]
            },
            yAxis: {
                title: {
                    text: 'Lod'
                },
                lineColor:"#C0D0E0",
                lineWidth:1,
                //startOnTick:false

            },
            legend: {
                layout: 'vertical',
                align: 'left',
                verticalAlign: 'top',
                x:100,
                y:70,
                floating: true,
                backgroundColor: '#FFFFFF',
                borderWidth: 1
            },
            plotOptions: {
                series: {
                    lineWidth:0.5
                    },
                line: {
                    marker: {
                    //fillColor:'#000000',
                        radius: 0,
                        states: {
                            hover: {
                                enabled: true,
                                lineColor: 'rgb(100,100,100)'
                            }
                        }
                    },
                    states: {
                        hover: {
                            marker: {
                                enabled: false
                            }
                        }
                    },
                    tooltip: {
                        headerFormat: '<b>{series.name}</b><br>',
                        pointFormat: '{point.x}, {point.y}'
                    }
                }
            },
            series: [
            <%for(int i=0;i<material.size();i++){%>
            {
                name: '<%=(String)material.get(i)%>',
                color: 'rgba(255, 0,0, .5)',
                data: [<%for(int j=0;j<name[i].size();j++){ %>[<%=(String)name[i].get(j)%>],<%}%>]
    
            },
            <%}%>

         
            ]
        });
    });
    

		</script>
	</head>

<body>


<!--LOGO+导航开始-->
<%@ include file="../ListHeader.jsp" %>
<!--导航结束-->  
<!--主体部分开始-->  


		
<div class="main">			
	
	<div id="container"style="margin: 0 auto;" ></div>

</div>




<!--主体部结束--> 
<!--版权信息开始--> 
<%@ include file="../ListFooter.jsp" %>

</body>
</html>



