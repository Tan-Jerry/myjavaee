<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to Struts2</title>
</head>
<body>
	Welcome <%=session.getAttribute("user") %> to Struts2!!!
	<s:debug/>
</body>
</html>