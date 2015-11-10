<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>通鼎智能ODN管理平台</title>
<link href="<%=request.getContextPath()%>/js/dwz/themes/css/login.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<div id="login">
		<div id="login_header">
			<h1 class="login_logo">
				<a href="#"><img src="<%=request.getContextPath()%>/js/dwz/themes/default/images/login_logo.gif" /></a>
			</h1>
			<div class="login_headerContent">
				<div class="navList">
					<ul>
						<li><a href="#">设为首页</a></li>
						<li><a href="#">升级说明</a></li>
						<li><a href="#">反馈</a></li>
						<li><a href="#">帮助</a></li>
					</ul>
				</div>
				<h2 class="login_title"><img src="<%=request.getContextPath()%>/js/dwz/themes/default/images/login_title.png" /></h2>
			</div>
		</div>
		<div id="login_content" >
			<div class="loginForm" style="margin-top:20px;">
				<form action="<%=request.getContextPath()%>/login/loginIn.do" method="post">
					<p style="text-align:center;color:red;">${errorMsg}</p>
					<p>
						<label>员工号：</label>
						<input name ="userName" type="text" size="20" value="" class="login_input" />
					</p>
					<br />
					<p>
						<label>密&nbsp;&nbsp;&nbsp;&nbsp;码：</label>
						<input name ="password" type="password" size="21" value="" class="login_input" />
					</p>
				<!-- 	<p>
						<label>验证码：</label>
						<input class="code" type="text" size="5" />
						<span><img src="<%=request.getContextPath()%>/js/dwz/themes/default/images/header_bg.png" alt="" width="75" height="24" /></span>
					</p> -->
					<div class="login_bar">
						<input class="sub" type="submit" value=" " />
					</div>
				</form>
			</div>
			<div class="login_banner"><img src="<%=request.getContextPath()%>/js/dwz/themes/default/images/login_banner.jpg" /></div>
			<div class="login_main">
				<ul class="helpList">
				
				</ul>
				<div class="login_inner">
					
				</div>
			</div>
		</div>
		<div id="login_footer">
		</div>
	</div>
</body>
</html>