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

<script type="text/javascript">
/* 	$(document).ready(function() {
		$(".fancybox").fancybox({
			'width'				: '75%',
			'height'			: '75%',
			'autoScale'			: false,
			'transitionIn'		: 'none',
			'transitionOut'		: 'none',
			'type'				: 'iframe'
		});
	}); */
</script>

</head>
<body>


<table border="1" cellpadding="5">
	<tr>
		<th>id</th>
		<th>名称</th>
		<th>排序</th>
		<th>电脑版模板文件</th>
		<th>手机版模板文件</th>
		<th>操作</th>
	</tr>
	<s:iterator id="page" value="#request.pageList">
	<tr>
		<td><s:property value="#page.id"/></td>
		<td style="font-weight:bold; background-color: #EEE;"><s:if test="#page.children.size()>0"><img src="${basePath}admin/images/icons/directoryPlus.gif"/></s:if> <s:property value="#page.name"/></td>
		<td><s:property value="#page.orderNum"/></td>
		<td><s:property value="#page.templateFile"/></td>
		<td><s:property value="#page.templateFileForMobile"/></td>
		<td><a target="_blank" href="${basePath}page?page.id=${page.id}">预览</a> <a href="${basePath}admin/archive/index?archive.page.id=${page.id}">文档列表</a> <a class="fancybox" href="${basePath}admin/archive/edit?archive.id=&archive.page.id=${page.id}">添加一篇文档</a> <a href="${basePath}admin/page/edit?page.id=&page.parent.id=${page.id}">添加子分类</a> <a href="${basePath}admin/page/edit?page.id=${page.id}">编辑</a> <a href="${basePath}admin/page/delete?page.id=${page.id}">删除</a></td>
	</tr>
		<s:iterator id="child" value="#page.children">
		<tr>
		<td><s:property value="#child.id"/></td>
		<td><img src="${basePath}admin/images/icons/directoryMinus.gif"/> <s:property value="#child.name"/></td>
		<td><s:property value="#child.orderNum"/></td>
		<td><s:property value="#child.templateFile"/></td>
		<td><s:property value="#child.templateFileForMobile"/></td>
		<td><a target="_blank" href="${basePath}page?page.id=${child.id}">预览</a> <a href="${basePath}admin/archive/index?archive.page.id=${child.id}">文档列表</a> <a class="fancybox" href="${basePath}admin/archive/edit?archive.id=&archive.page.id=${child.id}">添加一篇文档</a> <a href="${basePath}admin/page/edit?page.id=${child.id}">编辑</a> <a href="${basePath}admin/page/delete?page.id=${child.id}">删除</a></td>
	</tr>
		</s:iterator>
	</s:iterator>
</table>

<a href="${basePath}admin/page/edit?page.id=&page.parent.id=">添加一个父级分类</a>

</body>
</html>
