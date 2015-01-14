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
		<h1>注册声明</h1><br>
		<s:form action="/disclaimer" method="post">
			<s:textarea name="disclaimer" cols="10" rows="5" label="免责声明"></s:textarea>
			<s:radio list="#{'1':'同意','0':'不同意'}" name="AcceptedDisclaimer" value="1"/>
    		<s:submit name="submit" value="下一步" />
  		</s:form>  		
	</div>
</body>

</html>