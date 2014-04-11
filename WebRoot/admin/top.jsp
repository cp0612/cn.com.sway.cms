<%@ page language="java" import="java.util.*" contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>My JSP 'index.jsp' starting page</title>
<style>
body{
	font-size:12px;
	color:#EEE;
	background-color: #222;
	padding:0px;
	margin:0px;
}
a{
	color:#BBB;
	text-decoration: none;
}
a:hover{
	color:#BBB;
	text-decoration: underline;
}
</style>
</head>
<body>


<div style="float:left;">Java CMS</div>

<div style="float:right;">[ <a href="account/logout">退出管理</a> ]</div>

<div style="clear:both;"></div>


</body>
</html>
