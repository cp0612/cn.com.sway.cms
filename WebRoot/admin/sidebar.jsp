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
a:HOVER{
	color:#BBB;
	text-decoration: underline;
}
dl,dt,dd{
	margin: 0px;
	padding:0px;
}
dl{
	width:160px;
}
dt{
	padding-left:10px;
	line-height:34px;
	font-size: 14px;
}
dd{
	padding-left:10px;
	line-height:32px;
	background-color: #333333;
}
</style>
</head>
<body>
<dl>
	<dt>系统部分</dt>
	<dd><a href="admin/information" target="main">基本信息</a></dd>
	<dd><a href="admin/config/index" target="main">系统参数管理</a></dd>
	<dd><a href="admin/navi/index" target="main">导航栏</a></dd>
</dl>
<dl>
	<dt>页面部分</dt>
	<dd><a href="admin/page/index" target="main">页面管理</a></dd>
</dl>
<dl>
	<dt>内容部分</dt>
	<dd><a href="admin/archive/index" target="main">文档管理</a></dd>
</dl>
</body>
</html>
