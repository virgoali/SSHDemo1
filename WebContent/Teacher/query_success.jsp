<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
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

<title>��ʦ��Ϣ</title>

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
		<col width="5%">
		<col width="5%">
		<col width="5%">
		<tr class="title">
			<td>�̹���</td>
			<td>����</td>
			<td>����</td>
			<td>�Ա�</td>
			<td>����</td>
			<td>רҵ</td>
			<td>�ڿ�</td>
			<td>����</td>
		</tr>

		<!-- ������ʼ -->
		<s:iterator value="#session.teacher_list" var="t">
			<tr class="list">
				<td><s:property value="#t.tid" /></td>
				<td><s:property value="#t.tpassword" /></td>
				<td><s:property value="#t.tname" /></td>
				<td><s:property value="#t.tsex" /></td>
				<td><s:property value="#t.tage" /></td>
				<td><s:property value="#t.tdepartment" /></td>
				<td><s:property value="#t.tclass" /></td>
				<td><a
					href="<%=path%>/Teacher/Teacher_delete.action?tid=<s:property value="#t.tid"/>"
					onclick="javascript: return confirm('ȷ��Ҫɾ����');">ɾ��</a>
					<a href="<%=path%>/Teacher/Teacher_queryone.action?tid=<s:property value="#t.tid"/>">�޸�</a></td>
			</tr>
		</s:iterator>
		<!-- �������� -->
	</table>
	<form name="add" action="<%=path%>/Teacher/add_success.jsp" method="post">
		<div class="button">
			<input type="submit" name="addstudent" id="add" value="���">
		</div>
	</form>
</body>
</html>
