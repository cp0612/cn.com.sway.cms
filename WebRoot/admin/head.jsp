<%@ page language="java" import="java.util.*" contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<link rel="stylesheet" type="text/css" href="${basePath}admin/style.css">

<!-- fancybox部分 -->
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
<script>
	!window.jQuery && document.write('<script src="${basePath}js/jquery-1.4.3.min.js"><\/script>');
</script>
<script type="text/javascript" src="${basePath}plugins/fancybox/jquery.mousewheel-3.0.4.pack.js"></script>
<script type="text/javascript" src="${basePath}plugins/fancybox/jquery.fancybox-1.3.4.pack.js"></script>
<link rel="stylesheet" type="text/css" href="${basePath}plugins/fancybox/jquery.fancybox-1.3.4.css" media="screen" />


<%-- <!-- 配置文件 -->
<script type="text/javascript" charset="utf-8" src="${basePath}plugins/ueditor/ueditor.config.js"></script>
<!-- 编辑器源码文件 -->
<script type="text/javascript" charset="utf-8" src="${basePath}plugins/ueditor/ueditor.all.js"></script>
<!-- 语言包文件(建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败) -->
<script type="text/javascript" charset="utf-8" src="${basePath}plugins/ueditor/lang/zh-cn/zh-cn.js"></script> --%>


<script charset="utf-8" src="${basePath}plugins/kindeditor/kindeditor.js"></script>
<script charset="utf-8" src="${basePath}plugins/kindeditor/lang/zh_CN.js"></script>