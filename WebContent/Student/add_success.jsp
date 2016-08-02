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
<base href="<%=basePath%>">

<title>添加学生信息</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<style type="text/css">
table.default {
	border: 1px solid #0283c5;
	border-collapse: collapse;
	margin-top: 20px;
}

table.default td {
	text-align: center;
	padding: 2 5 2 5;
	height: 26px;
	border: 1px solid #ffffff;
}

table.default td.title,table.default td.list {
	font-weight: bold;
	background-color: #383B42;
	color: #ffffff;
	border: 1px solid #ffffff;
	white-space: nowrap;
	height: 26px;
	line-height: 26px;
	vertical-align: middle;
}

table.default td.title {
	text-align: center;
	line-height: 26px;
	vertical-align: middle;
	background-color: #383B42;
}

input[type=text] {
	width: 100%;
	padding: 5px 5px;
	border: 1px solid #222;
	box-shadow: 0 1px 0 rgba(255, 255, 255, 0.1);
	border-radius: 0.3em;
	margin-bottom: 0px;
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
	font-weight: bold;
	cursor: pointer;
	font-size: 13px;
	margin-left: auto;
	margin-right: auto;
}

input[type=submit]:hover {
	box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.3), inset 0 -10px 10px
		rgba(255, 255, 255, 0.1);
}
.button_right {
	float: right;
	margin: 0 0 0 10px;
	border: 0px #000 solid;
	margin-top: 20px;
}
.button_cancel {
	float: right;
	margin: 0 0 0 10px;
	border: 0px #000 solid;
	margin-top: 4px;
}
</style>
</head>

<body>
	<form name="add" action="<%=path%>/Student/Student_add.action"
		method="post">
		<table class="default" width="100%">
			<tr>
				<td class="title">密码:</td>
				<td class="list"><input type="text" name="spassword"
					id="spassword"></td>
			</tr>
			<tr>
				<td class="title">姓名:</td>
				<td class="list"><input type="text" name="sname" id="sname"></td>
			</tr>
			<tr>
				<td class="title">性别:</td>
				<td class="list"><input type="text" name="ssex" id="ssex"></td>
			</tr>
			<tr>
				<td class="title">年龄:</td>
				<td class="list"><input type="text" name="sage" id="sage"></td>
			</tr>
			<tr>
				<td class="title">地址:</td>
				<td class="list"><input type="text" name="saddress"
					id="saddress"></td>
			</tr>
			<tr>
				<td class="title">专业:</td>
				<td class="list"><input type="text" name="department"
					id="department"></td>
			</tr>
			<tr>
				<td class="title">辅导员:</td>
				<td class="list"><input type="text" name="tname"
					id="tname"></td>
			</tr>
		</table>

		<div class="button_right">

			<input type="submit" name="right" id="right" value="确定">

		</div>
	</form>
	<div class="button_cancel">
		<form name="cancel" action="<%=path%>/Student/query_success.jsp"
			method="post">
			<input type="submit" name="cancel" id="cancel" value="取消">
		</form>
	</div>
</body>
</html>
