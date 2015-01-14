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
		<h1>恭喜你，注册成功!</h1><br>
		<s:form action="/bound" method="post">
    		<s:submit name="submit" value="绑定微信账户" />
  		</s:form>  		
	</div>
</body>

</html>