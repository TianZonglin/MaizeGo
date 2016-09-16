<%@ page contentType="text/html;charset=gbk"  import="java.util.*"  language="java" pageEncoding="UTF-8"%>
<%@ page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page import="org.hibernate.HibernateException"%>
<%@ page import="org.hibernate.Session"%>
<%@ page import="org.download.*"%>
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
             Map attibutes = ActionContext.getContext().getSession();
             ArrayList<Dbtable> dbtablecrosses_list = (ArrayList<Dbtable>) attibutes.get("dbtablecrosses_list");
             ArrayList<Dbtable> whatclass_list = (ArrayList<Dbtable>) attibutes.get("whatclass_list");

             //String[] classnum=(String[])request.getAttribute("classnum");
             String[] classnum=(String[])attibutes.get("classnum");
             //System.out.println(classnum[0]);
        
  %>

</head>

<body>


<!--LOGO+导航开始-->
<%@ include file="../ListHeader.jsp" %> 
<!--导航结束-->  
<!--主体部分开始-->      
<div class="main">	
  <div class="span_24 padding_lr"> 
      <div class="span_30">
      <%
      int startpos=0;
      for(int j=0;j<whatclass_list.size();)
      {
      %>
      <div >
          <table cellpadding="0" cellspacing="0" width="100%" align="center" class="tab1">
              <tr bgcolor="#CFEEF8">
				   <td width="320" align="center">Data</td>
				   <td width="320" align="center">Description</td>
				   <td width="100" align="center">Update Time</td>
				   <td width="100" align="center">View</td>
				   <td width="100" align="center">Download</td>
		      </tr>
		  <br>
	

                   <div>
                        <h3 class="tit" style="color:#08b702"><%=whatclass_list.get(j).getCategory()%> Data</h3>
                   </div>

			  <%
				for(int i=0;i<dbtablecrosses_list.size();i++)
				{ 
				//System.out.println("jiu shi  ni ");
				    if(i>=startpos && i<=Integer.parseInt(classnum[j])-1)
				    {
				    %>
				    <tr>
					           
				<td align="center"><%=dbtablecrosses_list.get(i).getData()%></td>
				<td align="center"><%=dbtablecrosses_list.get(i).getDescription()%></td>
				<td align="center"><%=dbtablecrosses_list.get(i).getUpdatetime()%></td>

			    <td align="center"><a href="/maizego/file/<%=dbtablecrosses_list.get(i).getFilename()%>">View</a></td>
			    <td align="center"><a href="DbtableDown.action?did=<%=dbtablecrosses_list.get(i).getData()%>"> <img src="/maizego/images/down2.jpg" width="20" height="15" /></a></td>   
				</tr> 
			  <%
			  }
			}//for 
			  %>
  		</table>
    </div>
			   <%
				startpos=Integer.parseInt(classnum[j]);
				j++;
				}//for 
			   %>
			   <br>
			   <div>
                        <h3 class="tit" style="color:#08b702">Software and packages</h3>
                   </div>
			   <table cellpadding="0" cellspacing="0" width="100%" align="center" class="tab1">
			   <tr bgcolor="#CFEEF8">
			   <td align="center"> Software</td>
			   <td align="center">Download </td>
			   </tr>
			   <tr>
			   <td align="center"> A-D test </td>
			   <td align="center" ><a href="http://pan.baidu.com/s/1eQq2bqM" target="_blank"><font color="green">[R package for ADGWAS (Windows)][391 KB]</font></a></td>
			   </tr>
			   
			   <tr>
			   <td align="center"> A-D test </td>
			   <td align="center"><a href="http://pan.baidu.com/s/1bnsAamV" target="_blank"><font color="green">[R package for ADGWAS (Linux)][379 KB]</font></a></td>
			   </tr>
			   <tr>
			   <td align="center">ROAM</td>
			   <td align="center"><a href="http://pan.baidu.com/s/1dD4bnJb" target="_blank"><font color="green">[R source scripts][10.8 MB]</font></a></td>
			   </tr>
			   </table>
  
  </div>   

<!--右分栏结束--> 
    </div>
</div>
<!--主体部结束--> 
<!--版权信息开始--> 
<%@ include file="../ListFooter.jsp" %>                                           
<!--版权结束-->
</body>


</html>



