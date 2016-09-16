<%@ page contentType="text/html;charset=gbk"  import="java.util.*"  language="java" pageEncoding="UTF-8"%>
<%@ page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page import="org.hibernate.HibernateException"%>
<%@ page import="org.hibernate.Session"%>
<%@ page import="org.download.*"%>
<%@ page import="java.io.*" %> 
<%@ page import="com.sun.rowset.CachedRowSetImpl" %>
<%@ page import="java.util.Map.Entry" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
  <title>MaizeGo DataMine Platform</title>

  <meta http-equiv="pragma" content="no-cache"/>
  <meta http-equiv="cache-control" content="no-cache"/>
  <meta http-equiv="expires" content="0"/>
  <meta http-equiv="keywords" content="maize"/>
  <meta http-equiv="description" content="This is a database search engine of maize!"/>
 
<script type="text/javascript" src="/maizego/Script/jquery-1.7.1.js"></script>
<script type="text/javascript" src="/maizego/js/highcharts.js"></script>
<script type="text/javascript" src="/maizego/js/modules/exporting.src.js"></script>  
  
   <!-- 新版本添加的 -->
<link href="/maizego/style.css" type="text/css" rel="stylesheet" />

<script type="text/javascript" src="/maizego/js/jquery.fancybox-1.3.4.js"></script>
<script type="text/javascript" src="/maizego/js/jquery.mousewheel-3.0.4.js"></script>
<link rel="stylesheet" type="text/css" href="/maizego/css/jquery.fancybox-1.3.4.css" media="screen" />
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
             Map attribute = ActionContext.getContext().getSession();
			 CachedRowSetImpl data2=	(CachedRowSetImpl)attribute.get("data2");
			 CachedRowSetImpl data3=	(CachedRowSetImpl)attribute.get("data3");
			 CachedRowSetImpl data4=	(CachedRowSetImpl)attribute.get("data4");
			 CachedRowSetImpl data5=	(CachedRowSetImpl)attribute.get("data5");
			 CachedRowSetImpl dataPicture=(CachedRowSetImpl)attribute.get("dataPicture");
			 String trait=(String)attribute.get("trait");
			 
			 
			 ArrayList<Map.Entry<String, Integer>> bb=(ArrayList<Map.Entry<String ,Integer>>)attribute.get("bb");
			 ArrayList<Map.Entry<String, Integer>> zy=(ArrayList<Map.Entry<String ,Integer>>)attribute.get("zy");
			 ArrayList<Map.Entry<String, Integer>> e1=(ArrayList<Map.Entry<String ,Integer>>)attribute.get("e1"); 
			 ArrayList<Map.Entry<String, Integer>> e2=(ArrayList<Map.Entry<String ,Integer>>)attribute.get("e2"); 
			 ArrayList<Map.Entry<String, Integer>> e3=(ArrayList<Map.Entry<String ,Integer>>)attribute.get("e3"); 
			 int e_size=0;
			 if(e1!=null){
			 e_size=e1.size();
			 }else if(e2!=null){
			 e_size=e2.size();
			 }else if(e3!=null){
			 e_size=e3.size();
			 }
			 




        
  %>

</head>

<body>&nbsp; 
 
 
<!--LOGO+导航开始-->
<%@ include file="../ListHeader.jsp" %> 
<!--导航结束-->  
<!--主体部分开始-->      
<div class="main">	

        <div>
            <h3 class="tit" style="color:#08b702">List of 983 metabolite features</h3>
       </div>     
      <div style="overflow:auto" >
          <table cellpadding="0" cellspacing="0" width="100%" align="center" class="tab1">
              <tr bgcolor="#CFEEF8">
			        <td align="center">NO</td>		
			        <td align="center">Peak no.</td>		
			        <td align="center">Ret.Time(min)</td>	
			        <td align="center">Putative metabolite name</td>	
			        <td align="center">Metabolite Class</td>
			        <td align="center">Mol formula</td>
			        <td align="center">ES(+) Theor m/z</td>
			        <td align="center">ES(+) Found m/z</td>
			        <td align="center">m/z error (ppm)</td>
			        <td align="center">MS/MS ES(+) fragments</td>
			        <td align="center">MS/MS ES(+) CE (eV)</td>
			        <td align="center">Species detected before</td>
			        <td align="center">References</td>
			        <td align="center">Identification level (A-D)</td>
			        <td align="center">InChI</td>
			        <td align="center">InChI Key</td>
			        <td align="center">CID</td>   
			        <td align="center">Database comparisons</td>    	
		      </tr>
		      <%    int columnCount=data2.getMetaData().getColumnCount();
		       while(data2.next()) {%>
		      <tr>
				<%
				      for(int i=1;i<=columnCount;i++){
			     %>
			     <td align="center"><%=data2.getString(i) %></td>
			     <%} %>
         </tr>
         <%} %>
         </table>
</div>

<br/>
        <div>
            <h3 class="tit" style="color:#08b702">Significant loci identified by GWAS</h3>
       </div>     
      <div style="overflow:auto" >
          <table cellpadding="0" cellspacing="0" width="100%" align="center" class="tab1">
              <tr bgcolor="#CFEEF8">
				        <td align="center" >NO</td>		
				        <td align="center">Experiment</td>		
				        <td align="center">Metabolic Trait</td>	
				        <td align="center">Lead SNP</td>	
				        <td align="center">Chromosome</td>
				        <td align="center">Position (bp)<sup>a</sup></td>
				        <td align="center">Allele</td>
				        <td align="center">MAF<sup>b</sup></td>
				        <td align="center">P value<sup>c</sup></td>
				        <td align="center">N</td>
				        <td align="center">R<sup>2</sup>(%)<sup>d</sup></td>
				        <td align="center">ID</td>
				        <td align="center">Candidate Gene<sup>e</sup></td>
				        <td align="center">P value (eQTL)<sup>f</sup></td>
				        <td align="center">Correlation(Phenotype vs expression)<sup>g</sup></td>
				        <td align="center">Locus repeatedly identified-1<sup>h</sup></td>
				        <td align="center">Locus repeatedly identified-2<sup>i</sup></td>   
				        <td align="center">QTL<sup>j</sup></td>    
				        <td align="center">Annotation</td>	        	
		      </tr>
		      <%    int columnCount1=data3.getMetaData().getColumnCount();
		       while(data3.next()) {%>
		      <tr>
				<%
				      for(int i=1;i<=columnCount1;i++){
			     %>
			     <td align="center"><%=data3.getString(i) %></td>
			     <%} %>
         </tr>
         <%} %>
         </table>
</div>




<br/>


        <div>
            <h3 class="tit" style="color:#08b702">QTL mapping summary</h3>
       </div>     
      <div style="overflow:auto" >
          <table cellpadding="0" cellspacing="0" width="100%" align="center" class="tab1">
              <tr bgcolor="#CFEEF8">
				        <td align="center">NO</td>		
				        <td align="center">Metabolic Trait</td>		
				        <td align="center">Chromosome</td>	
				        <td align="center">Confidence Interval（Mb）<sup>a</sup></td>	
				        <td align="center">LOD<sup>b</sup></td>
				        <td align="center">R<sup>2</sup>（%）<sup>c</sup></td>
				        <td align="center">Linkage Population<sup>d</sup></td>		        	
		      </tr>
		      <%    int columnCount2=data4.getMetaData().getColumnCount();
		       while(data4.next()) {%>
		      <tr>
				<%
				      for(int i=1;i<=columnCount2;i++){
			     %>
			     <td align="center"><%=data4.getString(i) %></td>
			     <%} %>
         </tr>
         <%} %>
         </table>
</div>



<br/>
        <div>
            <h3 class="tit" style="color:#08b702">List of possible candidate genes</h3>
       </div>     
      <div style="overflow:auto" >
          <table cellpadding="0" cellspacing="0" width="100%" align="center" class="tab1">
              <tr bgcolor="#CFEEF8">
				        <td align="center">NO</td>		
				        <td align="center">Experiment ID</td>		
				        <td align="center">Metabolite ID</td>	
				        <td align="center">Putative metabolite name</td>	
				        <td align="center">Lead SNP</td>
				        <td align="center">Chromosome</td>
				        <td align="center">Position (bp)</td>
				        <td align="center">Additional Candidate Gene List</td>        	
		      </tr>
		      <%    int columnCount3=data5.getMetaData().getColumnCount();
		       while(data5.next()) {%>
		      <tr>
				<%
				      for(int i=1;i<=columnCount3;i++){
			     %>
			     <td align="center"><%=data5.getString(i) %></td>
			     <%} %>
         </tr>
         <%} %>
         </table>
       
</div>




<br/>
<br/>
<%if(dataPicture.size()>0){ %>
<h3 class="tit" style="color:#08b702">
<% int columnCount4=dataPicture.getMetaData().getColumnCount();
 while(dataPicture.next()) {
  for(int i=2;i<=columnCount4;i++)
  {%>
<%=dataPicture.getString(i) %>  
<%} }%>
</h3>
<div style="overflow:auto" >


  <img src="../metabolitepicture/<%=trait%>.jpg"/>
</div>

<%} %>




<!-- 柱形图部分 -->

<script><!--
$(function () {


<% if(bb!=null&&bb.size()>0) {%>



    $('#container').highcharts({
        chart: {
            type: 'column'
        },
        title: {
            text: 'Metabolic_Traits_BB'
        },
        /*
        subtitle: {
            text: 'Source: WorldClimate.com'
        },
        */
        xAxis: {
        
	        labels:{
	        rotation:90,
            style: { 
              // writingMode:'tb-rl'    //文字竖排样式
            }
	        },                         

            categories: [
            <%for(int i=0 ; i<bb.size() ;i++){
            
           //  System.out.println(bb.get(i).getKey());
            
            %>
           "<%=bb.get(i).getKey()%>",
           <%} %>

                               
            ],

            minorGridLineWidth: 0,
            minorTickInterval: 'auto',
            minorTickLength: 50,
            minorTickWidth: 5           
                    
            
            
            
            
        },
        yAxis: {
            min: 0,
            title: {
                text: 'Rainfall (mm)'
            }
        },
        tooltip: {
            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                '<td style="padding:0"><b>{point.y:.1f} mm</b></td></tr>',
            footerFormat: '</table>',
            shared: true,
            useHTML: true
        },
        plotOptions: {
            column: {
                pointPadding: 0.2,
                borderWidth: 0
            }
        },
        series: [{
            name: 'bb',
            data: [
            <%for(int i=0 ; i<bb.size() ;i++){
          //  System.out.println(bb.get(i).getValue());
            
            %>
           <%=bb.get(i).getValue()%>,
           <%} %>
            
            
            
            ]

        }]
    });
    
 <%}  if(zy!=null){%>   
    
$('#container1').highcharts({
        chart: {
            type: 'column'
        },
        title: {
            text: 'Metabolic_Traits_ZY'
        },
        /*
        subtitle: {
            text: 'Source: WorldClimate.com'
        },
        */
        xAxis: {
            
	        labels:{
	        rotation:90,
            style: { 
              // writingMode:'tb-rl'    //文字竖排样式
            }
	        }, 
        

            categories: [
            <%for(int i=0 ; i<zy.size() ;i++){
            
             //System.out.println(zy.get(i).getKey());
            
            %>
           "<%=zy.get(i).getKey()%>",
           <%} %>

                               
            ],

            minorGridLineWidth: 0,
            minorTickInterval: 'auto',
            minorTickLength: 50,
            minorTickWidth: 5           
                    
            
            
            
            
        },
        yAxis: {
            min: 0,
            title: {
                text: 'Rainfall (mm)'
            }
        },
        tooltip: {
            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                '<td style="padding:0"><b>{point.y:.1f} mm</b></td></tr>',
            footerFormat: '</table>',
            shared: true,
            useHTML: true
        },
        plotOptions: {
            column: {
                pointPadding: 0.2,
                borderWidth: 0
            }
        },
        series: [{
            name: 'zy',
            data: [
            <%for(int i=0 ; i<zy.size() ;i++){
            //System.out.println(zy.get(i).getValue());
            
            %>
           <%=zy.get(i).getValue()%>,
           <%} %>
            
            
            
            ]

        }]
    });    
    
<%}if(e1!=null||e2!=null||e3==null){%>



    $('#container2').highcharts({
        chart: {
            type: 'column'
        },
        title: {
            text: 'Metabolic_Traits_E1~E3'
        },
        /*
        subtitle: {
            text: 'Source: WorldClimate.com'
        },
        */
        xAxis: {
  	        labels:{
	        rotation:90,
	        // rotation: 0, 
            style: { 
           //    writingMode:'tb-rl'    //文字竖排样式
            }
	        },       

            categories: [
            <%for(int i=0 ; i<e_size ;i++){
            
           //  System.out.println(bb.get(i).getKey());
            if(e1!=null){
            %>
           "<%=e1.get(i).getKey()%>",
           <%}else if(e2!=null){%> 
            "<%=e2.get(i).getKey()%>",
            <%}else if(e3!=null){%>
            "<%=e3.get(i).getKey()%>",
          <% }}%>

                               
            ],

            minorGridLineWidth: 0,
            minorTickInterval: 'auto',
            minorTickLength: 50,
            minorTickWidth: 5           
                    
            
            
            
            
        },
        yAxis: {
            min: 0,
            title: {
                text: 'Rainfall (mm)'
            }
        },
        tooltip: {
            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                '<td style="padding:0"><b>{point.y:.1f} mm</b></td></tr>',
            footerFormat: '</table>',
            shared: true,
            useHTML: true
        },
        plotOptions: {
            column: {
                pointPadding: 0.2,
                borderWidth: 0
            }
        },
        series: [
          <% boolean flag=false;       //flag 判断前面是否已有数据
          if(e1!=null){flag=true;%>{
            name: 'e1',
            data: [
          <%
            for(int i=0 ; i<e_size ;i++){
          //  System.out.println(bb.get(i).getValue());
            
            %>
           <%=e1.get(i).getValue()%>,
           <%} %>

            ]

        }
        <%}%>
  
          <%if(e2!=null){ flag=true;%>
          <%if(flag){%>,<%}%>
          
          {
            name: 'e2',
            data: [
          <%
            for(int i=0 ; i<e_size ;i++){
          //  System.out.println(bb.get(i).getValue());
            
            %>
           <%=e2.get(i).getValue()%>,
           <%} %>
            
            
            
            ]

        }
        <%}%>  

          <%if(e3!=null){%>
          <%if(flag){%>,<%}%>
          {
            name: 'e3',
            data: [
          <%
            for(int i=0 ; i<e_size ;i++){
          //  System.out.println(bb.get(i).getValue());
            
            %>
           <%=e3.get(i).getValue()%>,
           <%} %>
            
            
            
            ]

        }
        <%}%>        
        
        
        
        ]
    });


    
 <%}%>   
    
    
    
});				
  --></script>




<% if(bb!=null&&bb.size()>0) {%>


<br/>
<br/>
        <div>
            <h3 class="tit" style="color:#08b702">Metabolic_Traits_BB:</h3>
       </div>



<div style="position:relative;overflow-x:auto;overflow-y:auto;height: 400px">
  <div id="container" style="width:4000px;height:400px;"></div>
</div>
<% }%>



<% if(zy!=null) {%>
<br/>
<br/>


        <div>
            <h3 class="tit" style="color:#08b702">Metabolic_Traits_ZY:</h3>
       </div>



<div style="position:relative;overflow-x:auto;overflow-y:auto;height: 400px">
  <div id="container1" style="width:6000px;height:400px;"></div>
</div>
<% }%>



<% if(e1!=null||e2!=null||e3==null) {%>


<br/>
<br/>
        <div>
            <h3 class="tit" style="color:#08b702">Metabolic_Traits_E1~E3:</h3>
       </div>



<div style="position:relative;overflow-x:auto;overflow-y:auto;height: 400px">
  <div id="container2" style="width:10000px;height:400px;"></div>
</div>
<% }%>





</div>



 


<!--主体部结束--> 
<!--版权信息开始--> 
<%@ include file="../ListFooter.jsp" %>                                           
<!--版权结束-->
</body>


</html>



