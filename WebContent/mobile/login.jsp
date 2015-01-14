<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="pragma" content="no-cache">
 	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="易就医，健康，陪护，专家">
	<meta http-equiv="description" content="易就医 - 您身边的健康陪护专家">
	<title>易就医</title> 
</head>

<body>
	<div>
		<h1>登陆</h1><br>
		<s:form action="/login" method="post">    		
    		<s:textfield name="UserName" placeholder="账号" />
    		<s:password name="Password" placeholder="密码" />    
    		<s:submit name="submit" value="登录" />
  		</s:form>

  		<div class="">
    		<a href="register.jsp">注册</a> • <a href="#">找回密码</a>
  		</div>
	</div>
</body>

</html>