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
	<s:form action="saveOrUpdate" namespace="/admin/page" method="post">
		<s:textfield name="page.id" label="页面UUID" value="%{#request.page.id}" readonly="true"/>
		<s:textfield name="page.parent.id" label="所属页面的UUID" value="%{#request.page.parent.id}" readonly="true"/>
		<s:textfield name="page.name" label="名字(标题)" value="%{#request.page.name}"/>
		<s:textfield name="page.orderNum" label="排序号码" value="%{#request.page.orderNum}"/>
		<s:textarea id="editor" name="page.html" label="电脑版HTML内容" value="%{#request.page.html}"/>
		<s:textarea id="editorForMobile" name="page.htmlForMobile" label="手机版HTML内容" value="%{#request.page.htmlForMobile}"/>
		<s:textfield name="page.templateFile" label="电脑版模板文件" value="%{#request.page.templateFile}"/>
		<s:textfield name="page.templateFileForMobile" label="手机版模板文件" value="%{#request.page.templateFileForMobile}"/>
		<s:submit value="提交"/>
	</s:form>
</div>

<script>
        KindEditor.ready(function(K) {
        	window.editor = K.create('#editor');
        	window.editor = K.create('#editorForMobile');
        });
</script>



</body>
</html>
