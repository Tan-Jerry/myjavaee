<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>
<s:text name="addPersonPage" />
</title>
</head>
<body>
<s:form action="addperson">
	<s:textfield name="personname" key="name" />
	<s:textfield name="school1" key="school 1" />
	<s:textfield name="school2" key="school 2" />
	<s:submit key="add" />
	<s:debug/>
</s:form>
</body>
</html>