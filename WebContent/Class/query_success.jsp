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

<title>课程信息</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<style>
@charset "GBK";

@font-face {
	font-family: 'entypo';
	font-style: normal;
	font-weight: normal;
}

table.default {
	border: 1px solid #0283c5;
	border-collapse: collapse;
	margin-top: 5px;
}

table.default td {
	text-align: center;
	padding: 2 5 2 5;
	height: 26px;
	border: 1px solid #ffffff;
}

table.default tr {
	background-color: #f0f0f0;
}

table.default tr.title td {
	font-weight: bold;
	background: #0283c5;
	color: #ffffff;
	border: 1px solid #ffffff;
	white-space: nowrap;
	height: 26px;
	line-height: 26px;
	vertical-align: middle;
}

table.default tr.title td {
	text-align: center;
	line-height: 26px;
	vertical-align: middle;
	background-color: #383B42;
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

div.button {
	text-align: right;
	margin-top: 20px;
}
</style>
</head>

<body>
	<table class="default" width="100%">
		<col width="5%">
		<col width="5%">
		<col width="5%">
		<col width="5%">
		<col width="5%">
		<tr class="title">
			<td>编号</td>
			<td>课程名</td>
			<td>教师</td>
			<td>课时</td>
			<td>操作</td>
		</tr>

		<!-- 遍历开始 -->
		<s:iterator value="#session.class_list" var="c">
			<tr class="list">
				<td><s:property value="#c.cid" /></td>
				<td><s:property value="#c.cname" /></td>
				<td><s:property value="#c.cteacher" /></td>
				<td><s:property value="#c.ctime" /></td>
				<td><a
					href="<%=path%>/Class/Class_delete.action?cid=<s:property value="#c.cid"/>"
					onclick="javascript: return confirm('确定要删除吗？');">删除</a>
					<a href="<%=path%>/Class/Class_queryone.action?cid=<s:property value="#c.cid"/>">修改</a></td>
			</tr>
		</s:iterator>
		<!-- 遍历结束 -->
	</table>
	<form name="add" action="<%=path%>/Class/add_success.jsp" method="post">
		<div class="button">
			<input type="submit" name="addstudent" id="add" value="添加">
		</div>
	</form>
</body>
</html>
