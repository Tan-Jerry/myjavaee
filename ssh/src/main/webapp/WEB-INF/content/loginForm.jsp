<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>
<s:text name="loginPage" />
</title>
</head>
<body>

<script type="text/javascript">
function regist2()
{
	targetForm = document.forms[0];
	targetForm.action = "regist";
}
</script>
<s:form action="login">
	<s:textfield name="username" key="user" />
	<s:textfield name="password" key="pass" />
	<s:submit key="login" />
	<s:submit key="regist" onclick="regist2();" />
	<s:debug/>
</s:form>
</body>
</html>