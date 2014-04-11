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

<div>
	<div>新增或修改一个导航数据</div>
	<s:form action="saveOrUpdate" namespace="/admin/archive" method="post" enctype="multipart/form-data">
		<s:textfield name="archive.id" label="文档UUID" value="%{#request.archive.id}" readonly="true"/>
		<s:textfield name="archive.page.id" label="所属页面UUID" value="%{#request.archive.page.id}" readonly="true"/>
		<s:textfield name="archive.title" label="名称(标题)" value="%{#request.archive.title}"/>
		<s:textfield name="archive.datetime" label="发布日期" value="%{#request.archive.datetime}">
			<s:param name="value"><s:date name="#request.archive.datetime" format="yyyy-MM-dd hh:mm:ss"/></s:param>
		</s:textfield>
		<div>${archive.datetime}</div>
		<s:textarea name="archive.html" label="HTML内容" value="%{#request.archive.html}"/>
		<s:file name="file" label="预览图"/>
		<s:submit value="提交"/>
	</s:form>
</div>

</body>
</html>
