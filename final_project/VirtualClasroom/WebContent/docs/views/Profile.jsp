<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> View Profile</title>
</head>
<body>
<%@ include file='Header.jsp' %>
    <div style="position: absolute;top:150px; left:17%;width: 83%  ;height:400px; background-color:#DFDFDF;">
   <div style="position: relative;top:0px; left:2%;width: 80% ;background-color: white;">
      <form action="PasswordChange">
      <h1> Change Password</h1>
      <table  style="position: relative; left:10% ;width:50%; height: auto; background-color: white;">
         <tr>
           <td>Enter new password</td>
           <td><input type="text"></td>
           </tr>      
       <tr>
           <td>Confirm new password</td>
           <td><input type="text"></td>
           </tr>
           <tr>
           <td>Enter old password</td>
           <td><input type="text"></td>
           </tr>
       
       </table>
       <input type="submit" name="savechanges" value="Save Changes" align="middle" 
                 style="left:50%;position:relative; top:5px;;width: 100px; ">
                 <br>
                 <br>
                 </form>
      </div>
       <div style="position:relative;top:10px; left:2%;width: 80%;height:120px; background-color: white; ">
         <h1>Change your mobile number</h1>
         <form action=""  >
          <font style=" position:relative; left: 10%;width: 100%">Enter new mobile number  </font>
          <input type="text" style="position:relative; left: 12% " value="+91 ">
       
            <input type="submit" name="savechanges" value="Save Changes" align="middle" 
                 style="left:0%;position:relative; top:30px;;width: 100px;">
      
        </form>
       
       
       </div>
      
      
      </div>
</body>
</html>