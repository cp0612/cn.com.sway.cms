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

<title>通知跳转页面...</title>

<s:include value="head.jsp"/>

</head>
<body>


<table border="1" cellpadding="5">
	<tr>
		<td align="center" valign="middle">
			${redirectNotic}<br/>正在跳转往 - <a href="${redirectURL}">${redirectURL}</a>
		</td>
	</tr>
</table>


</body>
</html>
