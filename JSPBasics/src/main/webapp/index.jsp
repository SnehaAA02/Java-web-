<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP Demo</title>
</head>
<body>
	<%! int x=10; %>
	<%= x %>
	<% for(int i=1;i<=10;i++){ %>
	<h3 align='center'>7 x <%=i %> = <%=i*7 %></h3>
	<%} %>
	
	<jsp:include page="header.jsp"></jsp:include>
	<form action="ProductServlet">
	<table align='center'>
	<tr>
	<td>ID:</td>
	<td><input type="text" name="id"></td>
	</tr>
	<tr>
	<td>Password:</td>
	<td><input type="text" name="pwd"></td>
	</tr>
	<tr>
	<td><input type="submit" name="action" value="login"></td>
	</tr>
	</table>
	</form>
	</body>
</html>