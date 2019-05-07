<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><s:text name="loginPage" /></title>
</head>
<body>
<s:form action="login">
	<s:textfield name="username" key="user" />
	<s:textfield name="password" key="pass" />
	<s:submit key="login" />
</s:form>
</body>
</html>