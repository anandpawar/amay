<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
<link rel="stylesheet" href="/VirtualClasroom/docs/css/Style.css">

</head>
<script type="text/javascript">

function myfunction(){

	<% 
	String s= (String)request.getSession(true).getAttribute("username");
	 if(s==null)
		 
		  //request.getRequestDispatcher("Login.jsp").forward(request, response); 
		 response.sendRedirect("Login.jsp");
	
	%>
}

</script>



<body onload="myfunction">
     
   <div id="headertopdiv" >
       
         <%--  <img  src = "docs/images/logo.jpg"  style="position:absolute;  overflow:hidden; left:40%; 
            top:8px; width:200px; height:60px; z-index:1 ;" />--%>
            <div style="position:absolute; color:white; text-align: center; top:0%;left: 40%">
            
            <h3 >Welcome  <% out.print(request.getSession(true).getAttribute("username"));%> </h3>
            <font style="top:-10px;"> <%out.print(request.getSession(true).getAttribute("userid"));%> </font>
            
            </div>
                <div style="position:absolute; left:90%; top:28%; width: 100%; ">
                 
                  <form action="Logout.jsp" method="post">
                      <input type="image"   src="/VirtualClasroom/docs/images/signout.jpg"
                                name="signout" value="signout" 
                                 style="height:35px;width:35px; left: 10px;  ">
                        
                        <h3 style="position:absolute; color: white; top:18px;left:-10px; text-align: center; ">signout</h3>
                </form>
                </div>
                
                
           
      
      <div id="headermenulist">
        <ul>
          <li><a href="/VirtualClasroom/docs/views/Home.jsp" >Home</a> </li>
          <li><a href="/VirtualClasroom/docs/views/Forum.jsp" >Discussion Forum </a> </li>
          <li><a href="/VirtualClasroom/docs/views/Library.jsp" >Library</a> </li>
          <li><a href="/VirtualClasroom/docs/views/Lecture.jsp" >Video Lecture</a> </li>
          <li><a href="/VirtualClasroom/docs/views/Profile.jsp" >View Profile</a> </li>
        </ul>
      </div>
</div>
  <div id="headerleftdiv" >
      <img id="headerleftprofile"  src="/VirtualClasroom/docs/images/profile.jpg" />
      <input  id ="hederleftuploadphoto" type="file" name="change profile">
      <h4 id="headernewsfeed" align="center" ><strong>News Feed</strong></h4> 
      <ul id="headernewsfeedlist">
                  <li><a style="text-decoration: none;text-align: center;" href="">message(0)</a></li>
                  <li><a style="text-decoration: none;text-align: center;" href="">notification(0)</a></li>
                  <li><a style="text-decoration: none;text-align: center;" href="">mail(0)</a></li>
                  <li><a style="text-decoration: none;text-align: center;" href="">group</a></li>
                 <li><a style="text-decoration: none;text-align: center;" href="">assignment</a></li>
      </ul>   


</div>
<div id="chatbox" style="position:fixed;  overflow:hidden; left:77%; 
      top:94%; width:23%; height:6%; z-index:1 ;">
      <h3 align="center"" style="color:black;">chat</h3></div>

</body>
</html>