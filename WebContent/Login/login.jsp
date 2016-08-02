<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>

<title>教务管理</title>

<style>
html,body,div,span,h1,a,s,ul,li {
	margin: 0;
	padding: 0;
	border: 0;
	font-size: 100%;
	font: inherit;
	vertical-align: baseline
}

article,aside,details,figcaption,figure,footer,header,hgroup,menu,nav,section
	{
	display: block
}

body {
	line-height: 1
}

table {
	border-collapse: collapse;
	border-spacing: 0
}

* {
	box-sizing: border-box;
}

body {
	color: white;
	font-size: 12px;
	background: #383B42;
}

form {
	background: #383B42;
	width: 300px;
	margin: 30px auto;
	border-radius: 0.4em;
	border: 1px solid #191919;
	overflow: hidden;
	position: relative;
	box-shadow: 0 5px 10px 5px rgba(0, 0, 0, 0.2);
}

form:after {
	content: "";
	display: block;
	position: absolute;
	height: 1px;
	width: 100px;
	left: 20%;
	top: 0;
}

form:before {
	content: "";
	display: block;
	position: absolute;
	width: 8px;
	height: 5px;
	border-radius: 50%;
	left: 34%;
	top: -7px;
}

.inset {
	padding: 5px;
	border-top: 1px solid #19191a;
}

.error {
	font-size: 12px;
	text-align: center;
	color: red;
	padding: 10px;
}

form h1 {
	font-size: 18px;
	text-shadow: 0 1px 0 black;
	text-align: center;
	padding: 15px 0;
	border-bottom: 1px solid black;
	position: relative;
}

label {
	color:;
	display: red;
	padding-bottom: 9px;
}

input[type=text],input[type=password] {
	width: 100%;
	padding: 8px 5px;
	background: #707070;
	border: 1px solid #222;
	box-shadow: 0 1px 0 rgba(255, 255, 255, 0.1);
	border-radius: 0.3em;
	margin-bottom: 20px;
}

label[for=aname],label[for=apassword] {
	color: white;
	display: inline-block;
	padding-bottom: 10;
	padding-top: -5px;
}

input[type=checkbox] {
	display: inline-block;
	vertical-align: top;
}

.p-container {
	padding: 0 10px 20px 20px;
}

.p-container:after {
	clear: both;
	display: table;
	content: "";
}

.p-container span {
	display: block;
	float: left;
	color: #0d93ff;
	padding-top: 8px;
}

input[type=submit]:hover {
	box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.3), inset 0 -10px 10px
		rgba(255, 255, 255, 0.1);
}

input

[type=text]:hover,input[type=password]:hover,label:hover ~ input

[type=text],label:hover ~ input[type=password] {
	background: #696969;
}

input[type=submit] {
	padding: 5px 20px;
	border: 1px solid rgba(0, 0, 0, 0.4);
	text-shadow: 0 -1px 0 rgba(0, 0, 0, 0.4);
	box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.3), inset 0 10px 10px
		rgba(255, 255, 255, 0.1);
	border-radius: 0.3em;
	background: #0184ff;
	color: white;
	float: right;
	font-weight: bold;
	cursor: pointer;
	font-size: 13px;
}

.radio {
	vertical-align: middle;
	margin-top: 8px;
	margin-bottom: 10px;
}
</style>

</head>

<body>

	<form name="login" action="<%=path%>/Login/Admin_login.action"
		method="post">
		<h1>用户登录</h1>
		<div class="inset">
			<p>
				<label for="aname">用户名:</label> <input type="text" name="aname"
					id="aname">
			</p>
			<p>
				<label for="apassword">密码:</label> <input type="password"
					name="apassword" id="apassword">
			</p>
		</div>
		<div class="error">
			<s:fielderror />
		</div>
		<p class="p-container" align="center">
			<label for="radio" > 
			<input type="radio" class="radio" name="choose" value="student" checked="checked" />学生 
			<input type="radio" class="radio" name="choose" value="teacher" align="middle" />教师 
			<input type="radio" class="radio" name="choose" value="admin" align="middle" />管理员 
			<input type="submit" name="login" id="login" value="登陆">
			</label>
		</p>
	</form>
</body>

</html>