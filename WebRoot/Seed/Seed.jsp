<%@ page contentType="text/html;charset=gbk"  import="java.util.*"  language="java" pageEncoding="UTF-8"%>
<%@ page import="com.opensymphony.xwork2.ActionContext"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
   <title>MaizeGo DataMine Platform</title>

  <meta http-equiv="pragma" content="no-cache"/>
  <meta http-equiv="cache-control" content="no-cache"/>
  <meta http-equiv="expires" content="0"/>
  <meta http-equiv="keywords" content="maize"/>
  <meta http-equiv="description" content="This is a database search engine of maize!"/>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

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

<body>
<%@ include file="../ListHeader.jsp" %>

<!--主体部分开始-->    
<div class="main"> 
  	
<h3 class="tit" style="border-bottom:2px solid #08b702; padding-bottom:5px; color:#08b702;"><span>Seed Search</span></h3> 
<div id="Jobs_content" style="font-size:16px; padding-left:10px;height:420px">                             
          <ul>
            <li><span >Seed Search |</span>  <a href="seed_select.jsp" class="Grand3">Seed Information</a></li>
            <%if(type!=null){ %>
             <li><span >Seed Search |</span>  <a href="modification.action" class="Grand3">Seed Modification</a></li>
            <li><span>Seed Search |</span>  <a href="borrow.action" class="Grand3">Borrow Information</a></li>
             <li><span>Seed Search |</span>  <a href="/maizego/Seed/list.jsp" class="Grand3"> Search Seed Location</a></li>
             <li><span>Seed Search |</span>  <a href="/maizego/Seed/source.jsp" class="Grand3">Search Seed Source</a></li>
             <%}if(type!=null&&type.equals("guest")){ %>
             <li><span>Seed Search |</span>  <a href="/maizego/Seed/seedBorrow.jsp" class="Grand3">Go to Borrow Seed</a></li>
             
             <%}if(type!=null&&type.equals("admin")){ %>
             <li><span>Seed Search |</span>  <a href="affiliation.action" class="Grand3">Affiliation Borrow Information</a></li>
              <li><span>Seed Search |</span>  <a href="/maizego/Seed/batchImport.jsp" class="Grand3">BatchImport</a></li>
             <%} %>             
          </ul>
 
        </div>
</div>

<!--主体部结束--> 
<!--版权信息开始--> 
<%@ include file="../ListFooter.jsp" %>

</body>
</html>