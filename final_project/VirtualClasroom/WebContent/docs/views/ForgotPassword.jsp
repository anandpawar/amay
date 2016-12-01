<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#303030">

  <div  style=" position:absolute; left: 30%;top: 30%;width: 40%;height: 40%;background-color: white;">
  
  <font style="position:absolute; left:30px;top:40px;">Your Password will send to your Registered Email Id </font>
 
 <form action="../../SendingPasswordHandler " method="post">
  <input type="text" name="userid" style="position:absolute; left:50px;top:100px; width: 200px;height: 20px;" placeholder="User_Id" >
  
  <input type="submit" value="ok" style="position:absolute; left:80px;top:150px; width: 80px; " >
  <input type="button" value="back" style="position:absolute; left:200px;top:150px; width: 80px; " >
  
  </form>
  </div>

</body>
</html>