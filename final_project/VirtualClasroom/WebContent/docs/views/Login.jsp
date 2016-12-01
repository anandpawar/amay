<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>login Page</title>
 <link rel="stylesheet" href="/VirtualClasroom/docs/css/Style.css">
</head>
<script language="javaScript">

</script>

 <body bgcolor="#303030">
  <div id="lfdiv" align ="center" >
<form id="lform" action ="../../LoginHandler" method="post">
    
    <h1 id="lfdivh1" align="center">Login</h1>
    <select id="lfselect"  name="user" >
     <option value="Student">Student</option>
     <option value="Faculty">Faculty</option>
     <option value="Admin">Admin</option>
    </select>
     <input id="lfinputuserid" type="text" name="userid"  placeholder="UserId">
     <input id="lfinputpassword" type="password" name="password" placeholder="Password">
     <input id="lfinputsubmit" type="submit" name="submit" value="Login">
     <input id="lfinputclear"  type="reset" name="clear" value="Clear" >
      <a id="lfforgotpassword" href=www.google.com >forgot password</a>  
      <h4 id="lferrormessage" align="center" ><%
           if(null!=request.getSession(true).getAttribute("errorMessage"))
           {
        	   
        	   out.print(request.getSession(true).getAttribute("errorMessage"));
        	   request.getSession().setAttribute("errorMessage","");
           }
         %></h4>  
         
         </form>
    
           <a id="lfforgotpassword" href="/VirtualClasroom/docs/views/ForgotPassword.jsp" >forgot password</a>  
   
</div>
</body>
</html>