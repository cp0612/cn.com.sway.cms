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
	<s:form action="saveOrUpdate" namespace="/admin/navi" method="post">
		<s:textfield name="navi.id" label="UUID" value="%{#request.navi.id}" readonly="true"/>
		<s:textfield name="navi.parent.id" label="所属上级的UUID" value="%{#request.navi.parent.id}" readonly="true"/>
		<s:textfield name="navi.name" label="名字" value="%{#request.navi.name}"/>
		<s:textfield name="navi.url" label="URL地址" value="%{#request.navi.url}"/>
		<s:radio name="navi.target" label="目标" list="%{#{'_blank':'_blank','_self':'_self','_parent':'_parent','_top':'_top'}}" value="%{#request.navi.target}"/>
		<s:textfield name="navi.orderNum" label="排序号码" value="%{#request.navi.orderNum}"/>
		<s:submit value="提交"/>
	</s:form>
</div>

</body>
</html>
