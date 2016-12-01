
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script language="JavaScript"> 
var i = 0; var path = new Array(); 

// LIST OF IMAGES 
path[0] = "docs/images/welcome.jpg"; 
path[1] = "docs/images/welcome1.png"; 
path[2] = "docs/images/welcome2.jpg"; 

function swapImage() 
{ 
document.slide.src = path[i]; 
if(i < path.length - 1) i++; 
else i = 0; 
setTimeout("swapImage()",3000); 
} 
window.onload=swapImage; 

</script>
<title>Untitled</title>
<meta name="generator" content="Web Page Maker">
<style type="text/css">
/*----------Text Styles----------*/
.ws6 {font-size: 8px;}
.ws7 {font-size: 9.3px;}
.ws8 {font-size: 11px;}
.ws9 {font-size: 12px;}
.ws10 {font-size: 13px;}
.ws11 {font-size: 15px;}
.ws12 {font-size: 16px;}
.ws14 {font-size: 19px;}
.ws16 {font-size: 21px;}
.ws18 {font-size: 24px;}
.ws20 {font-size: 27px;}
.ws22 {font-size: 29px;}
.ws24 {font-size: 32px;}
.ws26 {font-size: 35px;}
.ws28 {font-size: 37px;}
.ws36 {font-size: 48px;}
.ws48 {font-size: 64px;}
.ws72 {font-size: 96px;}
.wpmd {font-size: 13px;font-family: Arial,Helvetica,Sans-Serif;font-style: normal;font-weight: normal;}
/*----------Para Styles----------*/
DIV,UL,OL /* Left */
{
 margin-top: 0px;
 margin-bottom: 0px;
}
</style>

</head>
<body bgColor="#993366">
<div id="text1" style="position:absolute; overflow:hidden; left:0px; top:33px; width:677px; height:90px; z-index:0">
<div class="wpmd">
<div><font color="#3366FF" class="ws72">V</font><font color="#FFFFFF" class="ws28">IRTUAL</font><font class="ws14"> </font><font color="#3366FF" class="ws72">C</font><font color="#FFFFFF" class="ws28">LASSROOM</font></div>
</div></div>
<form action="docs/views/Login.jsp">
<input name="formbutton1" type="submit" value="Login" style="position:absolute;
left:80%;top:66px;width:80px;height:40px; ;z-index:1" >
</form>
<form action="/VirtualClasroom" method="post">
<input name="formbutton2" type="submit" value="about us" style="position:absolute;left:90%;top:66px;width:80px;height:40px;z-index:2">
</form>
<img name="slide" src="docs/images/welcome.jpg" style="position:absolute; 
       overflow:hidden; left:20px; 
      top:200px; width:60%; height:60%; z-index:0" />


</body>
</html>
