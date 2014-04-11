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

<s:include value="../head.jsp"/>

</head>
<body>


<table border="1" cellpadding="5">
	<tr>
		<th>UUID</th>
		<th>所属板块</th>
		<th>标题</th>
		<th>发布日期</th>
		<th>操作</th>
	</tr>
	<s:iterator id="archive" value="#request.archiveList">
	<tr>
		<td><s:property value="#archive.id"/></td>
		<td><a href="${basePath}admin/archive/index?archive.page.id=${archive.page.id}"><s:property value="#archive.page.name"/></a></td>
		<td><s:property value="#archive.title"/></td>
		<td><s:date name="#archive.datetime" format="yyyy-MM-dd hh:mm:ss"/></td>
		<td><a href="archive?archive.id=<s:property value="#archive.id"/>">预览</a> <a href="admin/archive/edit?archive.id=<s:property value="#archive.id"/>">编辑</a> <a href="admin/archive/delete?archive.id=<s:property value="#archive.id"/>">删除</a></td>
	</tr>
	</s:iterator>
</table>

</body>
</html>
