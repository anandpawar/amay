<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<script language="JavaScript"> 
var i = 0; var path = new Array(); 

// LIST OF IMAGES 
path[0] = "docs/images/elearning.jpg"; 
path[1] = "docs/images/promo.jpg"; 
path[2] = "docs/images/promo1.jpg"; 

function swapImage() 
{ 
document.slide.src = path[i]; 
if(i < path.length - 1) i++; 
else i = 0; 
setTimeout("swapImage()",3000); 
} 
window.onload=swapImage; 

</script>
<style type="text/css">
div{ background:pink }
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title >REGISTER PAGE</title>
</head>
<body bgcolor=lightyellow >
<img height="200" name="slide" src="docs/images/elearning.jpg" style="position:absolute; 
       overflow:hidden; left:20px; 
      top:100px; width:460px; height:400px; z-index:0" />

<h1  style="position:absolute; color :red; left:600px; 
      top:25px; width:300px; height:50px; z-index:0" >RGISTER HERE</h1>

<form action="RegistrationHandler">
<div  style="position:absolute;  overflow:hidden; left:500px; 
      top:100px; width:500px; height:629px; z-index:0" >
<table width="400" height="400" align="center" >
  <tr>
  <td> First Name </td>
  <td><input type="text" name="firstname"></td>
  </tr>
  <tr>
  <td> Last Name </td>
  <td><input type="text" name="lastname"></td>
  </tr>
  <tr>
  <td> College ID </td>
  <td><input type="text" name="collegeid"></td>
  </tr>
  <tr>
  <td> Email ID </td>
  <td><input type="text" name="emailid"></td>
  </tr>
  <tr>
  
  <td> Branch </td>
<td> <select name="branch" >
<option value="CSE">CSE</option>
<option value="IT">IT</option>
<option value="EC">EC</option>
<option value="ME">ME</option>
<option value="CIVIL">CIVIL</option>
</select></td>  
</tr>
  <tr>
  <td> Year </td>
  <td><select name="year" >
<option value="1st">1st</option>
<option value="2nd">2nd</option>
<option value="3rd">3rd</option>
<option value="4th">4th</option>
</select>
</td>
  </tr>
   <tr>
  <td> Class </td>
  <td><input type="text" name="class"></td>
  </tr>
  <tr>
  <td> sex </td>
  <td><select name="sex" >
<option value="male">MALE</option>
<option value="female">FEMALE</option>
</select></td>
  </tr>
<tr>
  <td> DOB </td>
   
  <td><input type="date" name="dob"></td>
  </tr>
  <tr>
  <td> Password </td>
  <td><input type="password" name="password"></td>
  </tr>
  <tr>
  <td> Confirm Password </td>
  <td><input type="password" name="confirmpassword"></td>
  </tr>
  <tr>
     <td>
        <input  onclick="required" type="submit" name="register"  value="submit">
  
     </td>
  </tr>
  
  
   

</table>

</div>
</form>
</body>
</html>