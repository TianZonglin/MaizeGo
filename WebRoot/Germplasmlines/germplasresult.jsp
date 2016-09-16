<%@ page contentType="text/html;charset=gbk"  import="java.util.*"  language="java" pageEncoding="UTF-8"%>
<%@ page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page import="com.sun.rowset.CachedRowSetImpl"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html >
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

  <%
  Map attribute=ActionContext.getContext().getSession(); 
  CachedRowSetImpl amp=(CachedRowSetImpl)attribute.get("amp");
  CachedRowSetImpl f1=(CachedRowSetImpl)attribute.get("f1");
 CachedRowSetImpl ril=(CachedRowSetImpl)attribute.get("ril");

  //页面回退或刷新时使CachedRowSetImpl游标回到首位
  if(amp!=null)
  	amp.beforeFirst();
  if(f1!=null)
  	f1.beforeFirst();
  if(ril!=null)
  	ril.beforeFirst();

  %>



<body>

<!--LOGO+导航开始-->
<%@ include file="../ListHeader.jsp" %>



<!--导航结束-->  
<!--主体部分开始-->   
<div class="main">
	
   <div class="content">
   
   	<div style=" float:right;">
		           <a href="/maizego/Germplasmlines/exportgerm_csv.jsp" title="CSV File"><img src="/maizego/images/down1.jpg" /></a>　
		           <a href="/maizego/Germplasmlines/exportgerm_txt.jsp" title=" TXT File"><img src="/maizego/images/down2.jpg" /></a>
	</div><br />
   			
   <!--这里的是屏蔽的     search go
         <div>
		 　　　　<div class="inser">
		           <select name="cata" style="border:2px solid #09b801; padding:7px 15px; position:relative; top:2px; color:#666;">
				       <option>CATEGORY</option>
					   <option>CATEGORY</option>
					   <option>CATEGORY</option>
				   </select>
				   <input type="text" value="SEARCH" onblur="this.style.color='#999';if (this.value == '') this.value = 'SEARCH';" onfocus="this.style.color='#666';this.value = ''" style="height:30px; border-top:2px solid #09b801; border-bottom:2px solid #09b801; color:#666; width:260px; line-height:30px; border-left:2px solid #09b801; text-indent:15px;" /><input type="image" src="/maizego/images/ingo.jpg" style="margin-left:-2px;" />
		        </div>

		 </div>
	-->        
          <%if(amp!=null) {%>

    		<div>
                <h3 class="tit" style=" color:#08b702;">
			    <span>AMP</span>
			    </h3> 
            </div>   <hr style=" border-top:2px solid #08b702;" />
                   
                         
            <div style="overflow:auto;height:400px">
            
		      <div class="table-head">
		      <table cellpadding="0" cellspacing="0" style=" border:1px solid #08b702;padding:0px ;table-layout:fixed;word-break: break-all; word-wrap: break-word; text-align:center;">
		      
		          <thead>
		              <tr bgcolor="#CFEEF8">
		              <th style=" border:1px solid #08b702;padding:0px ;">ID</th>
		              <th style=" border:1px solid #08b702;padding:0px ;">SUBPOP</th>
		              <th style=" border:1px solid #08b702;padding:0px ;">LINES</th>
		              <th style=" border:1px solid #08b702;padding:0px ;">SS</th>
		              <th style=" border:1px solid #08b702;padding:0px ;">NSS</th>
		              <th style=" border:1px solid #08b702;padding:0px ;">TST</th>
		              <th style=" border:1px solid #08b702;padding:0px ;">PEDIGREE</th>
		              <th style=" border:1px solid #08b702;padding:0px ;">ORIGIN</th>
		              </tr>
		         </thead>
		     </table>
		     </div>
		     
		   	 <div class="table-body">
		     <table cellpadding="0" cellspacing="0" style="table-layout:fixed;word-break: break-all; word-wrap: break-word;text-align:center; border:1px solid #08b702; background-color:#fff;" >
		         
		         <tbody>
		            <%int id1 =0;while(amp.next()){id1++; %>
				   <tr>
				   <td style=" border:1px solid #08b702;padding:0px ;" ><%=id1%></td>
				   <%for(int i=1;i<=amp.getMetaData().getColumnCount();i++){ %>
				   <td style=" border:1px solid #08b702;padding:0px ;" ><%=amp.getString(i) %>
				   </td>
				   <%} %>
				   </tr>
				   <%} %>
		         </tbody>
		     </table>
		     </div>
            
        <!--  
              <table cellpadding="0" cellspacing="0" width="100%" align="center" class="tab1" style="ord-break:break-all;word-wrap:break-word;text-align:center ">
				   <tr bgcolor="#CFEEF8">	
					   <td>ID</td>
					   <td>SUBPOP</td>
					   <td>LINES</td>
					   <td>SS</td>
					   <td>NSS</td>
					   <td>TST</td>
					   <td>PEDIGREE</td>
					   <td>ORIGIN</td>
				   </tr>



			</table>
			-->
			</div>
			<%} %>
			

      <%if(ril!=null) {%>
      
              <div>
                <h3 class="tit" style="color:#08b702;">
			    <span>RIL</span></h3> 
            </div>  <hr style=" border-top:2px solid #08b702;" />
          
            <div style="overflow:auto;height:400px">
            
            
            
            
            
            
            
            
            <div class="table-head">
		      <table cellpadding="0" cellspacing="0" style=" border:1px solid #08b702;padding:0px ;table-layout:fixed;word-break: break-all; word-wrap: break-word; text-align:center;">
		      
		          <thead>
		              <tr bgcolor="#CFEEF8">
		              <th style=" border:1px solid #08b702;padding:0px ;">ID</th>
		              <th style=" border:1px solid #08b702;padding:0px ;">POP</th>
		              <th style=" border:1px solid #08b702;padding:0px ;">ARRAY_ID</th>
		              </tr>
		         </thead>
		     </table>
		     </div>
		     
		   	 <div class="table-body">
		     <table cellpadding="0" cellspacing="0" style="table-layout:fixed;word-break: break-all; word-wrap: break-word;text-align:center; border:1px solid #08b702; background-color:#fff;" >
		         
		         <tbody>
		           <%int id2=0;while(ril.next()){id2++; %>
				   <tr>
				   <td style=" border:1px solid #08b702;padding:0px ;"><%=id2 %></td>
				   <%for(int i=1;i<=ril.getMetaData().getColumnCount();i++){ %>
				   <td style=" border:1px solid #08b702;padding:0px ;"><%=ril.getString(i) %>
				   </td>
				   <%} %>
				   </tr>
				   <%} %>

		         </tbody>
		     </table>
		     </div>
            
			</div>	
			<%} %>	



			

         
          <%if(f1!=null) {%>

          	<div>
                <h3 class="tit" style=" color:#08b702;">
			    <span>AMP×tester</span></h3> 
            </div>  <hr style=" border-top:2px solid #08b702;" />
          
            <div style="overflow:auto;height:400px">
            
            
            
              <div class="table-head">
		      <table cellpadding="0" cellspacing="0" style=" border:1px solid #08b702;padding:0px ;table-layout:fixed;word-break: break-all; word-wrap: break-word; text-align:center;">
		      
		          <thead>
		              <tr bgcolor="#CFEEF8">
		              <th style=" border:1px solid #08b702;padding:0px ;">ID</th>
		              <th style=" border:1px solid #08b702;padding:0px ;">POP</th>
		              <th style=" border:1px solid #08b702;padding:0px ;">LINE</th>
		              </tr>
		         </thead>
		     </table>
		     </div>
		     
		   	 <div class="table-body">
		     <table cellpadding="0" cellspacing="0" style="table-layout:fixed;word-break: break-all; word-wrap: break-word;text-align:center; border:1px solid #08b702; background-color:#fff;" >
		         
		         <tbody>
		            <%int id3=0;while(f1.next()){ id3++;%>
				   <tr>
				   <td style=" border:1px solid #08b702;padding:0px ;"><%=id3 %></td>
				  <!--  <%for(int i=1;i<=f1.getMetaData().getColumnCount();i++){ %> --> 
				   <td style=" border:1px solid #08b702;padding:0px ;"><%=f1.getString(1).split("×")[1] %></td>				   
				    <td style=" border:1px solid #08b702;padding:0px ;"><%=f1.getString(1) %></td>
				 <!--  <%} %> --> 
				   </tr>
				   <%} %>
		         </tbody>
		     </table>
		     </div>
            

			</div>	
			<%} %>
			
			
			
    		
			
			
					
			

    </div>
    

    
  
  </div>   

<!--主体部结束--> 
<!--版权信息开始--> 
<%@ include file="../ListFooter.jsp" %>                                          
<!--版权结束-->

  </body>


</html>



