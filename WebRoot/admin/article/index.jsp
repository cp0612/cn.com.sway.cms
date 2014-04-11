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
		<th>id</th>
		<th>标题</th>
		<th>发布日期</th>
		<th>操作</th>
	</tr>
	<s:iterator id="_article" value="#request.articleList">
	<tr>
		<td><s:property value="#_article.id"/></td>
		<td><s:property value="#_article.title"/></td>
		<td><s:property value="#_article.datetime"/></td>
		<td><a href="${basePath}article?article.id=${_article.id}">查看</a> <a href="${basePath}admin/article/index?article.id=${_article.id}">编辑</a> <a href="${basePath}admin/article/delete?article.id=${_article.id}">删除</a></td>
	</tr>
	<tr><s:property value="#_article.html"/></tr>
	</s:iterator>
</table>

<div>
	<div>新增或修改一个导航数据</div>
	<s:form action="saveOrUpdate" namespace="/admin/article" method="post">
		<s:textfield name="article.id" label="id" value="%{#request.article.id}" readonly="true"/>
		<s:textfield name="article.title" label="标题" value="%{#request.article.title}"/>
		<s:textfield name="article.datetime" label="发布日期" value="%{#request.article.datetime}"/>
		<s:textarea name="article.html" label="文章HTML内容" value="%{#request.article.html}"/>
		<s:submit value="提交"/>
	</s:form>
</div>

</body>
</html>
