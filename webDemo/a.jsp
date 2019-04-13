<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>helloapp</title>
</head>
<body>
  <p><b>Hello: My first java ee web app</b></p>
  <%out.println(new java.util.Date());%>
  <!-- add jsp comment -->
  <%-- jsp comment --%>
  <%!
  // declare one variable
  public int count;
  public String info()
  {
	return "helo";
  }
  %>
  <p><%=count++%></p>
  <br/>
  <p><%=info()%></p>
  
  <table bgcolor="#999dd" border="1" width="300px">
  <%
  for (int i=0; i<10; i++)
  {
  %>
  	<tr>
  		<td>The Loop Value:</td>
  		<td><%=i %></td>
  	</tr>
  <%
  }
  %>
  </table>
</body>
</html>