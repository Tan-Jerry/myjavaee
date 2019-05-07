<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>forward original file</title>
</head>
<body>
	<jsp:forward page="forward-result.jsp">
		<jsp:param value="29" name="age"/>
	</jsp:forward>
</body>
</html>