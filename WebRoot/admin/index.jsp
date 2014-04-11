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

<s:include value="head.jsp"/>
	
<frameset rows="30,*"  frameborder="0" border="0" bordercolor="#FF0000" noresize="noresize" framespacing="0">
	<frame name="top" src="${basePath}admin/top">
	<frameset cols="160,*" >
		<frame name="sidebar" src="${basePath}admin/sidebar">
		<frame name="main" src="${basePath}admin/information">
	</frameset>
</frameset>

</head>
<body>

</body>
</html>
