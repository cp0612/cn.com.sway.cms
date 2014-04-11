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
	<s:form action="saveOrUpdate" namespace="/admin/article" method="post">
		<s:textfield name="article.id" label="id" value="%{#request.article.id}" readonly="true"/>
		<s:textfield name="article.title" label="名字" value="%{#request.article.title}"/>
		<s:textfield name="article.datetime" label="排序号码" value="%{#request.article.datetime}"/>
		<s:textarea name="article.html" label="页面HTML内容" value="%{#request.article.html}"/>
		<s:submit value="提交"/>
	</s:form>
</div>

</body>
</html>
