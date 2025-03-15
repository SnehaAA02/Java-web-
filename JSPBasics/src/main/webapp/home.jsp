<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<% String name=(String)session.getAttribute("name"); %>
	<h4 align="right">Welcome, <%=name %></h4>
	<a href="another.jsp">Click here for next page</a>
</body>
</html>