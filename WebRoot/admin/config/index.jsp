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
系统参数管理
<table border="1">
	<tr>
		<th>id</th>
		<th>备注</th>
		<th>排序</th>
		<th>类型</th>
		<th>长度</th>
		<th>值</th>
		<th>操作</th>
	</tr>
	<s:iterator id="_config" value="#request.configList">
	<tr ${_config.allowDelete?"":"style=\"font-weight:bold; color:#F00;\""}>
		<td><s:property value="#_config.id"/></td>
		<td><s:property value="#_config.remark"/></td>
		<td><s:property value="#_config.orderNum"/></td>
		<td><s:property value="#_config.type"/></td>
		<td><s:property value="#_config.maxLength"/></td>
		<td><s:property value="#_config.value"/></td>
		<td><a href="${basePath}admin/config/index?config.id=${_config.id}">编辑</a> <a href="${basePath}admin/config/delete?config.id=${_config.id}">删除</a></td>
	</tr>
	</s:iterator>
</table>

<div>
	<div>新增一个系统变量</div>
	<s:form action="saveOrUpdate" namespace="/admin/config" method="post">
		<s:textfield name="config.id" label="id" value="%{#request.config.id}"/>
		<s:textfield name="config.remark" label="备注" value="%{#request.config.remark}"/>
		<s:radio name="config.allowDelete" label="允许删除" list="%{#{true:'是',false:'否'}}" value="%{#request.config.allowDelete}"/>
		<s:textfield name="config.orderNum" label="排序号码" value="%{#request.config.orderNum}"/>
		<s:radio name="config.type" label="类型" list="%{#{'int':'int','float':'float','boolean':'boolean','text':'text'}}" value="%{#request.config.type}"/>
		<s:textfield name="config.maxLength" label="最大长度" value="%{#request.config.maxLength}"/>
		<s:textfield name="config.value" label="值" value="%{#request.config.value}"/>
		<s:submit value="提交"/>
	</s:form>
</div>

</body>
</html>
