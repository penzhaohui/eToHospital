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
		<h1>用户信息</h1><br>
		<s:form action="/register" method="post">
    		<s:select name="UserType" list="#{1:'用户',2:'健康客服',3:'健康专家'}" 
    			  headerKey="-1" headerValue="请选择您的注册类型" emptyOption="false"/>
   			<s:radio list="#{'1':'先生','0':'女士'}" name="Gender" value="1"/>
   			<s:textfield name="MobilePhone" placeholder="手机号码" />
   			<s:textfield name="IDNo" placeholder="身份证号码" />    		
    		<s:submit name="submit" value="提交" />
  		</s:form>  		
	</div>
</body>

</html>