<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<div class="footwrap">
   <div class="foot">
       <div class="f1"><a href="/maizego/Contact/contact.jsp" class="m1"></a></div>
	   <div class="f2">
	   <p>Huazhong Agricultural University,Wuhan, China<br />
Code：430072<br />
Tel：+86-027-87280169<br/>
E-mail：liujianxiao@mail.hzau.edu.cn</p>
<p>National Key Laboratory of Crop Genetic Improvement</p>
       </div>
	   <div class="f3">
	       <p><span style="color:#57cee6;">more</span><br />www.maizego.com<br />Copyright reserved by Aruo. 2014 · Yan's lab</p>
	   </div>
   </div>
</div>




<div style="display: none;">
			<div id="inline1" style="width:280px;height:250px;overflow:auto; text-align:center; padding-top:30px;">
			<form name="form" action="doLogin.action" method="post" onSubmit="return checkLogin()">
			<input type="hidden" name="url" value="<%=url%>">
			<table cellpadding="0" cellspacing="10" width="100%" align="center" border="0">
			   <tr><td style="width:247px; height:44px; background:url(/maizego/images/username.jpg) center no-repeat;"><input type="text" id="user" name="user" value="" style="border:none;" /></td></tr>
			   <tr><td style="width:247px; height:44px; background:url(/maizego/images/password.jpg) center no-repeat;"><input type="password" id="password" name="password" value="" style="border:none;" /></td></tr>
			   <tr><td colspan="2" align="right" style="padding-right:15px;"><a href="#">Forgot your password?</a></td></tr>
			   <tr><td colspan="2" align="left"><input type="image" src="/maizego/images/login.jpg" />　　<input type="image" src="/maizego/images/reset.jpg" /></td></tr>
			</table>
			</form>
			</div>
</div>


<script type="text/javascript"> 
$.fn.extend({
	myMenu: function() {
		$(this).children('ul').children('li').hover(
			function() {
				if(!$(this).children('ul').hasClass('focus')) {
					$(this).addClass('focus');
					$(this).children('ul:first').stop(true, true).animate({ height:'show' }, 'fast');
				}
			},
			function() {
				$(this).removeClass('focus');
				$(this).children('ul:first').stop(true, true).animate({height:'hide', opacity:'hide'}, 'slow');
			}
		);
		$(this).children('ul').children('li').children('ul').hover(
			function() {
				$(this).addClass('focus');
			},
			function() {
				$(this).removeClass('focus');
			}
		);
	}
});
$(document).ready(function() {
	$('.nav').myMenu();
});
</script>









