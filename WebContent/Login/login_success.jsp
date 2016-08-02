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
@charset "UTF-8";

@font-face {
	font-family: 'entypo';
	font-style: normal;
	font-weight: normal;
}

body {
	display: -webkit-box;
	display: -moz-box;
	display: -ms-flexbox;
	display: -webkit-flex;
	display: flex;
	margin: 0;
	padding: 0;
	background-color: #f0f0f0;
	font-family: Muli, sans-serif;
	color: #444;
}

ul {
	list-style: none;
	margin-top: 0;
	padding: 0;
}

a {
	cursor: pointer;
	display: block;
	color: #b3b3b3;
	text-decoration: none;
}

.bckg {
	background-color: #383B42;
	box-shadow: -4px 0px 10px rgba(14, 14, 14, 0.48) inset;
	width: 200px;
	height: 100%;
	position: fixed;
	left: 0;
	top: 0;
}

h1 {
	text-align: center;
	font-weight: normal;
	color: #F6F6EF;
	line-height: 60px;
	margin: 0;
	font-size: 30px;
	letter-spacing: 2px;
	border-bottom: 1px solid rgba(101, 116, 134, 0.57);
}

h2 {
	font-size: 20px;
	text-transform: uppercase;
	margin: 0;
	letter-spacing: 3px;
	color: #919191;
	font-weight: normal;
	padding-left: 40px;
	line-height: 60px;
	text-shadow: 1px 1px 2px #fff;
	position: relative;
	flex: 1;
	-webkit-flex: 1;
	-ms-flex: 1;
}

h2:before {
	content: '';
	width: 36px;
	height: 36px;
	position: absolute;
	left: -19px;
	top: 12px;
	background-color: #34363A;
	-webkit-transform: rotate(45deg);
	-moz-transform: rotate(45deg);
	transform: rotate(45deg);
}

h3 {
	font-size: 17px;
	margin: 0;
	line-height: 40px;
	color: #555;
	cursor: pointer;
	position: relative;
}

.header {
	width: 200px;
	height: 100%;
	float: left;
	position: relative;
	z-index: 99;
}

.header ul li {
	border-bottom: 1px solid #42454D;
	padding-left: 55px;
	transition: all 0.6s;
	border-top: 1px solid #2E3036;
}

.header ul li:hover {
	background-color: #454952;
	transition: all 0.6s;
	border-bottom: 1px solid #797979;
}

.header ul li:hover a {
	color: #fff;
	transition: all 0.6s;
}

.header ul li a {
	line-height: 55px;
	font-size: 18px;
	position: relative;
	letter-spacing: 1px;
	transition: all 0.6s;
}

.header ul li a:before {
	font-family: 'entypo', sans-serif;
	font-size: 20px;
	position: absolute;
	left: -32px;
}

.main {
	flex: 1;
	-webkit-flex: 1;
	-ms-flex: 1;
}

.title {
	background-color: #fff;
	border-bottom: 1px solid #C0C1C0;
	height: 60px;
	display: -webkit-box;
	display: -moz-box;
	display: -ms-flexbox;
	display: -webkit-flex;
	display: flex;
}

.title a {
	color: #AAA;
	width: auto;
	margin: 0 20px;
	float: right;
	line-height: 62px;
	position: relative;
	text-decoration: none;
	transition: all .5s;
}

.title a:before {
	content: "\1f464";
	font-size: 38px;
	position: absolute;
	left: -50px;
	font-family: 'entypo';
}

a:hover {
	color: #33526B;
	transition: all .5s;
}

.larg {
	max-width: 960px;
	margin: 30px auto;
	padding: 0 30px;
}

.larg div {
	background-color: #F7F7F7;
	border: 1px solid #E2E2E2;
	padding: 0 20px;
	margin: 15px 0;
}

.larg div:hover {
	background-color: #fafafa;
}

.larg div h3 span {
	font-family: 'entypo';
	font-size: 19px;
	position: absolute;
	right: 0;
	transition: all .6s;
}

.larg div h3 span.close {
	-webkit-transform: rotate(180deg);
	transition: all .5s;
}

.larg div p {
	display: none;
	margin-left: 10px;
	padding: 0 15px;
	border-left: 1px solid #ccc;
}
</style>

</head>

<body>

	<span class='bckg'></span>
	<div class="header">
	<h1>教务系统</h1>
	<ul>
		<li><a href="<%=path%>/Login/main.jsp" target="show">首页信息</a></li>
		<li><a href="<%=path%>/Student/Student_query.action" target="show">学生管理</a></li>
		<li><a href="<%=path%>/Teacher/Teacher_query.action" target="show">教师管理</a></li>
		<li><a href="<%=path%>/Class/Class_query.action" target="show">课程管理</a></li>
		<li><a href="<%=path%>/Login/updatepassword.jsp" target="show">修改密码</a></li>
		<li><a href="<%=path%>/Login/Admin_LoginOut.action">安全退出</a></li>
	</ul>
	</div>
	<div class="main">

	<div class='title'>
		<h2>欢迎进入教务管理系统</h2>
		<a href='#' title='Profil'> Hello ${sessionScope.AdminLoginName} !
		</a>
	</div>
		<iframe name="show" src="main.jsp"
			style="width:100%;height:100%;" frameborder="0" scrolling="no"></iframe>

	</div>
</body>

</html>