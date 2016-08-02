<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'main.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
.para {
    font-size: 14px;
    word-wrap: break-word;
    color: #333;
    margin-bottom: 15px;
    text-indent: 2em;
    line-height: 24px;
    zoom: 1;
}
</style>
  </head>
  
  <body>
    <h3>学生信息管理</h3>
<div class="para">教务人员通过学生信息管理模块来管理学生信息，如进行学生信息的添加、修改、删除等。在进行信息的添加时，首先在新的窗口进行学生信息的录入，
在保存的时候要进行学生学号是否有重复的检查，如果添加的学生编号有重复就要对用户进行提示。只有在不重复的情况下才能进行信息的添加。在进行信息的删除时，要首先打开提示窗口让用户确认是否要删除，
只有在用户确认的情况下才能进行信息的删除。在进行信息的修改时，要根据用户选定的学生进行修改，即列出用户选定的学生的所有信息，在这个基础上进行学生信息的修改。</div>
<h3>教师信息管理</h3>
<div class="para">教务工作人员通过此模块来管理教师信息，包括教师信息的添加、修改、删除等。在进行信息的添加时候，打开新的窗口进行教师信息的记入，
在保存的时候要进行教师编号是否重复的检验，如果添加的教师编号重复要对用户进行提示，只有在不重复的情况下才能进行信息的添加。在进行信息的删除时，要首先打开提示窗口让用户确认是否删除，
只有在用户确认后才能够进行信息的删除。在进行信息的修改时，要能够根据用户选定的教师项进行修改，即列出用户选定的教师的所有信息，在这个基础上进行教师信息的修改。</div>
<h3>课程信息管理</h3>
<div class="para">教务工作人员通过该模块来管理课程的基本信息，包括课程信息的添加，修改，删除和班级课程的设置等。在进行信息的添加时，打开新的窗口进行信息的录入，
在保存的时候要进行课程的编号是否重复的检查，如果添加的课程编号重复的要对用户进行提示，只有在不重复的情况下才能进行信息的添加。在进行信息的删除的时候，要首先打开窗口让用户确认是否要删除，
只有只被确认后才能进行删除操作。在进行信息的修改的时候，要根据用户选定的课程进行修改，即列出用户选定课程的信息，在这个基础上进行课程信息的修改。</div>
  </body>
</html>
