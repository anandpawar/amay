<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>logout</title>
</head>
<body>
     <%
        HttpSession s=request.getSession(false);
        s.invalidate();
     %>
     <h1>Logout </h1>
     <p> you are now logout succefully</p>
     <a href="Login.jsp" > go back to home page</a> 
 </body>
</html>