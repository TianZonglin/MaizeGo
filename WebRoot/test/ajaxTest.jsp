<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Google自动补全<%=basePath %></title>

    <script type="text/javascript" src="../Script/jquery-1.7.1.js"></script>    
    
    
  </head>
  
<script type="text/javascript">
function auto()
{

 var query = document.getElementById("query");
 var auto = document.getElementById("auto");
 var tags = document.getElementById("tags");
 if(event.keyCode == 40)
 {  
  if(query.value != "" && auto.style.visibility != "hidden")
  {
   tags.focus();
   tags.selectedIndex = 0;
   query.value = tags.options[0].text;
   return;
  }
 }
//alert(query.value);
      $.ajax({
        url: 'test.action?key='+query.value,
        type: 'post',
        success: backFct
      });
}

function backFct(data)
{
  var rs = data.msg;
  if(rs != "")
  {
   var tagsRs = rs.split(",");
   var auto = document.getElementById("auto");
   var tags = document.getElementById("tags");
   var query = document.getElementById("query");
   tags.length = 0;
   tags.size = tagsRs.length;
   for(var i=0;i<tagsRs.length;i++)
   {
   // alert(tagsRs[i]);
    var option = document.createElement("option");
    //option.setAttribute("text", tagsRs[i]);
    option.innerHTML=tagsRs[i];
    tags.options[i] = option;
    //alert(option.text);
   }
   auto.style.width = query.style.width;
   tags.style.width = query.style.width;
   auto.style.left = query.offsetLeft - 1;
   auto.style.top = query.offsetTop + query.offsetHeight + 1;
   auto.style.visibility = "visible";

 }
}

</script>
  
  
  <body >
   <div align="center">
    <img src="logo_cn.png"><br/>
    <b><span style=" color: blue;">作者：Sean</span></b>
    <form action="" method="post">
     <input id="query" type="text" onkeyup="auto();" style=" width: 400px; height: 30px; font-size: 18px;"/><br>
     <input type="submit" style="height:32px; " value="Sean搜索"/>
     <input type="submit" style="height:32px; " value="手气不错"/>
    </form>
   </div>
   <div id="auto" style="border-style: solid; border-width: 1px; visibility: hidden; position: absolute;">
    <select id="tags" onkeyup="text();" size="0" style=" margin:-2px;">
  </select>
 </div>
  </body>
</html>