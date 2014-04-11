<%@ page language="java" import="java.util.*" contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>


<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<base href="<%=basePath%>">
	<title>会员登录 - ${application.configMap.webTitle}</title>
	<s:include value="../templates/igongcha/head.jsp"/>
</head>
<body>


<script type="text/javascript"> 
function changeValidateCode(obj) { 
//获取当前的时间作为参数，无具体意义 
var timenow = new Date().getTime(); 
//每次请求需要一个不同的参数，否则可能会返回同样的验证码 
//这和浏览器的缓存机制有关系，也可以把页面设置为不缓存，这样就不用这个参数了。 
obj.src="rand.action?d="+timenow; 
} 
</script> 

<div style="width:340px; height:180px; border:1px solid #DDD; padding:5px; position:absolute; left:50%; top:50%; margin-left:-170px; margin-top:-90px;">
	<div style="color:#FFF; font-weight:bold; text-align:center; background-color: #999; margin-top: 10px; margin-bottom: 10px;">账号登录</div>
	<s:form action="loginCheck" namespace="/account" method="post" theme="simple">
		<div>账&nbsp;&nbsp;号: <s:textfield name="account.username" label="账 号"/></div><div><s:fielderror fieldName="account.username"/></div>
		<div>密&nbsp;&nbsp;码: <s:password name="account.password" label="密 码"/></div><div><s:fielderror fieldName="account.password"/></div>
		<div>
			验证码:
			<s:textfield name="captcha" label="验证码" value=""/>
			<img alt="code..." name="randImage" id="randImage" src="utils/captcha.jsp" width="60" height="20" border="1" align="absmiddle"/>
		</div><div><s:fielderror fieldName="captcha"/></div>
		<div style="padding-left:100px;"><s:submit value="提交"/></div>
	</s:form>
	<div style="color:#FFF; font-weight:bold; text-align:center; background-color: #999; margin-top: 10px; margin-bottom: 10px;">技术支持：由<a target="_blank" href="http://www.xinsiwei.net.cn">新思维</a>提供<a target="_blank" href="http://www.xinsiwei.net.cn">网络营销外包</a>服务</div>
</div>

</body>
</html>
