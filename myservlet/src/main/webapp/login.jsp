<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<span style="color:red;font-weight:bold">
		<% if (request.getAttribute("err") != null)
		{
			out.println(request.getAttribute("err") + "<br/>");
		}
		if (request.getAttribute("tip") != null)
		{
			out.println(request.getAttribute("tip") + "<br/>");
		}
		%>
	</span>
	<form id="login" method="post" action="login">
		UserName: <input type="text" name="username" /><br/>
		Password: <input type="password" name="pass" /><br/>
		<input type="submit" value="login"/><br/>
	</form>
</body>
</html>