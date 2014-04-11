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
		<th>名称</th>
		<th>URL地址</th>
		<th>目标</th>
		<th>排序</th>
		<th>操作</th>
	</tr>
	<s:iterator id="navi" value="#request.naviList">
	<tr>
		<td><s:property value="#navi.id"/></td>
		<td style="font-weight:bold; background-color: #EEE;"><s:if test="#navi.children.size()>0"><img src="${basePath}admin/images/icons/directoryPlus.gif"/></s:if> <s:property value="#navi.name"/></td>
		<td><s:property value="#navi.url"/></td>
		<td><s:property value="#navi.target"/></td>
		<td><s:property value="#navi.orderNum"/></td>
		<td><a href="${basePath}admin/navi/edit?navi.id=${navi.id}">编辑</a> <a href="${basePath}admin/navi/edit?navi.id=&navi.parent.id=${navi.id}">添加子导航</a> <a href="${basePath}admin/navi/delete?navi.id=${navi.id}">删除</a></td>
	</tr>
		<s:iterator id="child" value="#navi.children">
		<tr>
			<td><s:property value="#child.id"/></td>
			<td><img src="${basePath}admin/images/icons/directoryMinus.gif"/> <s:property value="#child.name"/></td>
			<td><s:property value="#child.url"/></td>
			<td><s:property value="#navi.target"/></td>
			<td><s:property value="#child.orderNum"/></td>
			<td><a href="${basePath}admin/navi/edit?navi.id=${child.id}">编辑</a> <a href="${basePath}admin/navi/delete?navi.id=${child.id}">删除</a></td>
		</tr>
		</s:iterator>
	</s:iterator>
</table>

<div><a href="${basePath}admin/navi/edit?navi.id=&navi.parent.id=">新增一个父级导航</a></div>

</body>
</html>
