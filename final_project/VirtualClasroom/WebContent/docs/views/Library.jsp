<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.io.*,java.util.*, javax.servlet.*,java.sql.ResultSet,
 java.sql.SQLException, java.util.ArrayList, java.util.List,com.mysql.jdbc.Connection, com.mysql.jdbc.Statement
,com.sun.jmx.snmp.Timestamp, com.vc.dao.PostDao,com.vc.model.*, com.vc.utils.ConnectionUtility" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Library Page</title>
<link rel="stylesheet" href="../css/Style.css">
</head>
<body>
 <%@ include file='Header.jsp' %>
 
 
  <div id="forumaskquestion"  style="width:40%; top:170px; ">
      <form action="../../BookUpLoadHandler" method="post" enctype="multipart/form-data">
              <h2 >Upload notes or book in Library</h2>
 
                     <h3 style="position: absolute;left: 30px;top: 94px;"> File Type</h3>
                     <select id="askquestionselect"  name="filetype" 
                      style="position:absolute;top:110px;z-index:0;"  >
                          <option value="">File Type</option>
                          <option value="pdf">pdf</option>
                          <option value="txt">txt</option>
                          <option value="ppt">ppt</option>
                          <option value="doc">.doc</option>
                          <option value="rar">rar</option>
                          <option value="zip">zip</option>
                      
                                     
                    </select>
                     <h3 style="position: absolute;left: 30px; top:50px; "> select subject</h3>
                    <select id="askquestionselect"  name="subject"   >
                         
                         <option value="C">C</option>
                         <option value="C++">C++</option>
                         <option value="Java">Java</option>
                         <option value=".NET">.Net</option>
                         <option value="C#">C#</option>
                         <option value="HTML">HTML</option>
                         <option value="CSS">CSS</option>
                         <option value="Java Script">Java Script</option>
                         <option value="DBMS">DBMS</option>
                         <option value="Data Structure">Data Structure</option>
                         <option value="Computer Network">Computer Network</option>
                         <option value="Admin">Others</option>
                                     
                    </select>
                      

                     <input id="askquestiontitle" type="text" name="title" placeholder="Title" style="top:150px;">
                     <input  style="position: absolute;top:190px;" id="askquestiontitle" type="text" name="writername"
                               placeholder="writer name if have" >
                   
                     <input id="askquestionfile" type="file"  name="book" size="50" multiple  >
                     <h3 style="position:absolute;left:30px;top:265px;z-index:0;"  >attache file</h3>
                     <input id="askquestionsubmit" type="submit" name="Upload" value="Upload" 
                     style="left:60%">
              </form>
         </div> 
       
       
       <div id="forumaskquestion"  style="width:40%; left:58%; top:170px; ">
               <h2 >Download notes or book from Library</h2>
               <form action="askquestion" >
                    
                    
                                     
                    <h3 style="position: absolute;left: 30px; top:50px; "> select subject</h3>
                    <select id="askquestionselect"  name="select category"  >
                          
                         <option value="Student">C</option>
                         <option value="Faculty">C++</option>
                         <option value="Admin">Java</option>
                         <option value="Student">.Net</option>
                         <option value="Faculty">C#</option>
                         <option value="Admin">HTML</option>
                         <option value="Student">CSS</option>
                         <option value="Faculty">Java Script</option>
                         <option value="Admin">DBMS</option>
                         <option value="Student">Data Structure</option>
                         <option value="Faculty">Computer Network</option>
                         <option value="Admin">Others</option>
                                     
                    </select>
                      
                    
                     <h3 style="position: absolute;left: 30px;top: 94px;"> File Type</h3>
                     <select id="askquestionselect"  name="select category"
                      style="position:absolute;top:110px;z-index:0;"  >
                          <option value="Student">File Type</option>
                          <option value="Student">pdf</option>
                          <option value="Faculty">txt</option>
                          <option value="Admin">ppt</option>
                          <option value="Student">.doc</option>
                          <option value="Faculty">excel</option>
                     </select>
                      <input id="askquestiontitle"type="text" style="position: absolute;top:150px;" placeholder="Title" >
                      <input  style="position: absolute;top:190px;" id="askquestiontitle"type="text" placeholder="writer name if have" >
                  
                     <input id="askquestionsubmit" type="submit" name="submit" value="Submit" style="left:38%; border-radius: 50px 50px 50px 50px;  ">
              </form>
              
         </div> 
         <div style="position: absolute;top:520px;left: 8%; width:84%;">
         
         <h2 style="overflow:hidden; left:-50px; text-align:center; 
          top:0px; width:100%; height:50px; z-index:0 ;background:purple ;color:white; border-radius:15px ;"
	       >Latest Updates in Library</h2>
	        <TABLE BORDER="1" style="background-color: #1C184E; color: white; height:500px; width: 100%; border-radius:5px;text-align: center; font-size:20px; ;">
            <TR>
                <TH  width="35px"><span style="color: red;font:bold;">ID</span></TH>
                <TH width="350px"><span style="color: red;font:bold;">Title</span></TH>
                <TH width="100px"><span style="color: red;font:bold;">Uploaded by</span></TH>
                <TH width="100px"><span style="color: red;font:bold;">Subject</span></TH>
                <TH width="70px"><span style="color: red;font:bold;">Download</span></TH>
            </TR>
            <%
            Connection connection=null;
            System.out.println("inside dao... [libray table search]");
  		   try {
  			 connection = (Connection)ConnectionUtility.getConnection();
   		 	System.out.println("connected");
  			Statement statement = (Statement)connection.createStatement();
  			System.out.println("statement created");
  			String query = "SELECT * FROM library ORDER BY uploadtime DESC limit 10";
  			
  			
  			
  			
  			ResultSet resultSet = statement.executeQuery(query);
  			System.out.println("query result genrate");
  			while(resultSet.next()) {
  			
  			
  			
  			
  			%>
  			
            
            
              <TR>
              
                <TD><%out.print(resultSet.getInt("book_id")); %> </TD>
                <TD><%out.print(resultSet.getString("filename")); %> </TD>
                <TD><%out.print(resultSet.getString("uploadedby"));%></TD>
                <TD><%out.print(resultSet.getString("subject")); %></TD>
                <TD><form action="../../BookDownloadHandler" method="post""> 
                <input type="image" src="/VirtualClasroom/docs/images/download.jpg"
                 name="book_id" value="<%=resultSet.getInt("book_id")%>" style="position:relative; width: 20px;height: 20px; left: 20px; " align="middle" >
                                 
                  </form>
                                   </TD>
            
             </TR>
             
    
            
        
        	<% 		
  			}
		
		} catch (SQLException e) {
			System.out.println("[getAllPostSortByLatest] Exception : "+e);
		}
		
		%>
     
	
         </TABLE>
         
         <div style="height: 100px;">
         <h1> hello</h1>
         
         </div>
         
         </div>
         


</body>
</html>