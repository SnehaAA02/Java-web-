<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String user=null;
String sessionID=null;
if(session.getAttribute("user")==null){
	response.sendRedirect("login.html");
}
else{
	user=(String) session.getAttribute("user");
	
	Cookie[] cookies=request.getCookies();
	if(cookies!=null){
		for(Cookie cookie:cookies){
			if(cookie.getName().equals("JSESSIONID")){
				sessionID=cookie.getValue();
			}
		}
	}
}


%>
<h3> Hi <%=user %>, Login Successful. Your session ID = <%= sessionID %> </h3>
<form action="LogoutServlet" method="post">
<input type="submit" value="Logout">
</form>
</body>
</html>