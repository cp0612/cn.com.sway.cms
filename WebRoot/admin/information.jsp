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

<title>My JSP 'index.jsp' starting page</title>

<s:include value="head.jsp"/>

</head>
<body>

<style>
th{
	text-align:left;
}
</style>
<table>
	<tr>
		<th width="170">Java的运行环境版本</th>
		<td width="*"><%=System.getProperties().getProperty("java.version")%></td>
	</tr>
	<tr>
		<th>Java的运行环境供应商</th>
		<td><%=System.getProperties().getProperty("java.vendor")%></td>
	</tr>
	<tr>
		<th>Java供应商的URL</th>
		<td><%=System.getProperties().getProperty("java.vendor.url")%></td>
	</tr>
	<tr>
		<th>Java的安装路径</th>
		<td><%=System.getProperties().getProperty("java.home")%></td>
	</tr>
	<tr>
		<th>Java的虚拟机规范版本</th>
		<td><%=System.getProperties().getProperty("java.vm.specification.version")%></td>
	</tr>
	<tr>
		<th>Java的虚拟机规范供应商</th>
		<td><%=System.getProperties().getProperty("java.vm.specification.vendor")%></td>
	</tr>
	<tr>
		<th>Java的虚拟机规范名称</th>
		<td><%=System.getProperties().getProperty("java.vm.specification.name")%></td>
	</tr>
	<tr>
		<th>Java的虚拟机实现版本</th>
		<td><%=System.getProperties().getProperty("java.vm.version")%></td>
	</tr>
	<tr>
		<th>Java的虚拟机实现供应商</th>
		<td><%=System.getProperties().getProperty("java.vm.vendor")%></td>
	</tr>
	<tr>
		<th>Java的虚拟机实现名称</th>
		<td><%=System.getProperties().getProperty("java.vm.name")%></td>
	</tr>
	<tr>
		<th>Java运行时环境规范版本</th>
		<td><%=System.getProperties().getProperty("java.specification.version")%></td>
	</tr>
	<tr>
		<th>Java运行时环境规范供应商</th>
		<td><%=System.getProperties().getProperty("java.specification.vender")%></td>
	</tr>
	<tr>
		<th>Java运行时环境规范名称</th>
		<td><%=System.getProperties().getProperty("java.specification.name")%></td>
	</tr>
	<tr>
		<th>Java的类格式版本号</th>
		<td><%=System.getProperties().getProperty("java.class.version")%></td>
	</tr>
	<tr>
		<th>Java的类路径</th>
		<td><%=System.getProperties().getProperty("java.class.path")%></td>
	</tr>
	<tr>
		<th>加载库时搜索的路径列表</th>
		<td><%=System.getProperties().getProperty("java.library.path")%></td>
	</tr>
	<tr>
		<th>默认的临时文件路径</th>
		<td><%=System.getProperties().getProperty("java.io.tmpdir")%></td>
	</tr>
	<tr>
		<th>一个或多个扩展目录的路径</th>
		<td><%=System.getProperties().getProperty("java.ext.dirs")%></td>
	</tr>
	<tr>
		<th>操作系统的名称</th>
		<td><%=System.getProperties().getProperty("os.name")%></td>
	</tr>
	<tr>
		<th>操作系统的构架</th>
		<td><%=System.getProperties().getProperty("os.arch")%></td>
	</tr>
	<tr>
		<th>操作系统的版本</th>
		<td><%=System.getProperties().getProperty("os.version")%></td>
	</tr>
	<tr>
		<th>文件分隔符</th>
		<td><%=System.getProperties().getProperty("file.separator")%></td>
	</tr>
	<tr>
		<th>路径分隔符</th>
		<td><%=System.getProperties().getProperty("path.separator")%></td>
	</tr>
	<tr>
		<th>行分隔符</th>
		<td><%=System.getProperties().getProperty("line.separator")%></td>
	</tr>
	<tr>
		<th>用户的账户名称</th>
		<td><%=System.getProperties().getProperty("user.name")%></td>
	</tr>
	<tr>
		<th>用户的主目录</th>
		<td><%=System.getProperties().getProperty("user.home")%></td>
	</tr>
	<tr>
		<th>用户的当前工作目录</th>
		<td><%=System.getProperties().getProperty("user.dir")%></td>
	</tr>
</table>

</body>
</html>
