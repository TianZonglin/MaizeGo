<%@ page contentType="text/html;charset=gbk"  import="java.util.*"  language="java" pageEncoding="UTF-8"%>
<%@ page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page import="java.util.Map"%>
<%@ page import="com.sun.rowset.CachedRowSetImpl" %>
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
		  String[] traits=(String [])attributes.get("trait");
		  String table=(String)attributes.get("table");
		  String material=(String)attributes.get("material");
		  String chr=(String)attributes.get("chr");
		  String year=(String)attributes.get("year");
		  String location=(String)attributes.get("location");	
		  String color[]={"#00CD00","#551A8B","#8B0A50","#B7B7B7","#EE2C2C","#AEEEEE"};	  
		  
		  ArrayList<CachedRowSetImpl> temp=new ArrayList<CachedRowSetImpl>();
		  for(String trait:traits){
		  CachedRowSetImpl temp_data=(CachedRowSetImpl)attributes.get(trait);
		  if(temp_data!=null&&temp_data.size()>0){
		      temp.add((CachedRowSetImpl)attributes.get(trait));		
		      }  
		  }

		 %>

<script type="text/javascript">
<%if(temp.size()>0){if(table.equals("AMP")){%>
   $(function () {
        $('#container').highcharts({
            chart: {
                type: 'scatter',
                zoomType: 'xy',
              //  width:5000
                //plotBackgroundImage:"../img/bg.png"
            },
            title: {
                text: 'The GWAS result of AMP'
            },
          /*  subtitle: {
                text: 'Source: BB_qtl_el,result_lrt_el'
            },*/
            xAxis: {
                title: {
                    enabled: true,
                    text: 'pos'
                },

                //startOnTick: true,
                //endOnTick: true,
                showLastLabel: true,
                maxPadding:0.05
            },
            yAxis: {
                title: {
                    text: '-LogP'
                },
                lineColor:"#C0D0E0",
                lineWidth:1,
                //startOnTick:false
                plotBands: [{  
                color: 'red',//设置数据块的颜色  plotBands
                width: 1,  
                value: 5.69, 
                dashStyle:'longdashdot',  
                label: {  
                    text: 'log(1/0.5M)',  
                    style: {color: 'red',font:'normal 8px Georgia, sans-serif' },//设置数据块对应字体颜色  
                    align: 'left',  
                    textAlign:'left',  
                    verticalAlign:'bottom',  
                    x: 0  
                }   
                        
            }]  

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

                scatter: {
                    marker: {
                    //fillColor:'#000000',
                        radius: 1,
    
                    },

                    tooltip: {
                        headerFormat: '<b>{series.name}</b><br>',
                        pointFormat: '{point.x}, {point.y}'
                    }
                }
            },
            series: [
            
            <%int i=0;for(CachedRowSetImpl data:temp){%>
            {
                name: '<%=traits[i]%>',
                color: '<%=color[i]%>',
                data: [<%while(data.next()){%>[<%=(String)data.getString(1)%>,<%=(String)data.getString(2)%>],<%}%>]
    
            },
            <%i++;}%>
         
            ]
        });
    });
    
<%}else if(table.equals("RIL")){%>
   $(function () {
        $('#container').highcharts({
            chart: {
                type: 'line',
                zoomType: 'xy',
              //  width:5000
                //plotBackgroundImage:"../img/bg.png"
            },
            title: {
                text: '<%=table%>-<%=material%>'
            },
            subtitle: {
                text: 'chr<%=chr%>-<%=year%>-<%=location%>'
            },
            xAxis: {
                title: {
                    enabled: true,
                    text: 'pos'
                },
                //startOnTick: true,
                //endOnTick: true,
                showLastLabel: true,
                maxPadding:0.05
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

                line: {
                    marker: {
                    //fillColor:'#000000',
                        radius: 0,
    
                    },

                    tooltip: {
                        headerFormat: '<b>{series.name}</b><br>',
                        pointFormat: '{point.x}, {point.y}'
                    }
                }
            },
            series: [
            
            <%boolean flag=false;int i=0;for(CachedRowSetImpl data1:temp){%>
            {
                name: '<%=traits[i]%>',
                color: '<%=color[i]%>',
                data: [<%int k=0;while(data1.next()){//%>[<%=(String)data1.getString(1)%>,<%=(String)data1.getString(2)%>]<%if(k<(data1.size()-1)){%>,<%}%><%k++;}%>]
            }
            <%i++;}%>
          

            ]
        });
    });
<%}}%>
		</script>
	</head>

<body>

<!--LOGO+导航开始-->
<%@ include file="../ListHeader.jsp" %>
<!--导航结束-->  
<!--主体部分开始-->  


		
<div class="main" style="min-height:400px" >		
<%if(temp.size()>0){
         if(table.equals("AMP")){%>	
<div style="position:relative;overflow-x:scroll;overflow-y:hidden;height: 400px">
	<div id="container"style="width:5000px" ></div>
</div>
<%}else if(table.equals("RIL")){ %>

	<div id="container"style="width:950px" ></div>

<%}} else{%>
<span class="Phenotypicstrongblack">There is no data!</span>
<%} %>
</div>




<!--主体部结束--> 
<!--版权信息开始--> 
<%@ include file="../ListFooter.jsp" %>

</body>
</html>



