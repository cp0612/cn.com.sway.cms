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

<style>
body{
	line-height:200%;
	color:#FFF;
	
}
a{
	color:#FFF;
	text-decoration: none;
}
</style>

</head>
<body>

<div style="width:380px; height:150px; border:1px solid #DDD; padding:5px; position:absolute; left:50%; top:50%; margin-left:-191px; margin-top:-76px;">
	<div style="height:138px; text-align:center; background-color: #AAA;">
		<div style="margin-top:30px;">${redirectNotic}</div>
		<div><span id="secondRemain"></span>后跳转往 - [ <a href="<%=basePath%>${redirectURL}">立即跳转</a> ]</div>
	</div>
</div>

<%-- <table border="1" cellpadding="5">
	<tr>
		<td align="center" valign="middle">
			${redirectNotic}<br/><span id="secondRemain"></span>后跳转往 - <a href="${redirectURL}">${redirectURL}</a>
		</td>
	</tr>
</table> --%>



<script type="text/javascript">


var secondRemain = 5;

document.getElementById("secondRemain").innerHTML = secondRemain + "秒";

function countdownAndJump(){
	if(secondRemain==1){
		window.location.href = "<%=basePath%>${redirectURL}";
	}else{
		secondRemain--;
		document.getElementById("secondRemain").innerHTML = secondRemain + "秒";
	}
}

redirectInterval = setInterval("countdownAndJump()", 1000);

</script>


</body>
</html>
