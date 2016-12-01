<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.io.*,java.util.*, javax.servlet.*,java.sql.ResultSet,
 java.sql.SQLException, java.util.ArrayList, java.util.List,com.mysql.jdbc.Connection, com.mysql.jdbc.Statement
,com.sun.jmx.snmp.Timestamp, com.vc.dao.PostDao,com.vc.model.Post, com.vc.utils.ConnectionUtility" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
   <title>Home Page</title>
             <link rel="stylesheet" href="/VirtualClasroom/docs/css/calendarview.css">
             <link rel="stylesheet" href="/VirtualClasroom/docs/css/Style.css">
             <script src="/VirtualClasroom/docs/js/prototype.js"></script>
             <script src="/VirtualClasroom/docs/js/calendarview.js"></script>
             <script src="/VirtualClasroom/docs/js/Home.js"></script>
             <script src="/VirtualClasroom/docs/js/jquery-2.1.3.min.js"></script>
             <script src="/VirtualClasroom/docs/js/jquery-1.11.2.js"></script>
   <%int count=0; %>
    
             <script>

             function myfunction2(y)
             {
           	   var x = document.getElementById(y);
           	    if(x.style.display=="block")           
           	    	x.style.display="none";

           	    	else
           	    		x.style.display="block";

           	    		 
           	  }
    
                 function setupCalendars() {



                		                     
                    // Embedded Calendar
                          Calendar.setup(
                                     {
                                        dateField: 'embeddedDateField',
                                         parentElement: 'embeddedCalendar'
                                      }
                                    )

                    // Popup Calendar
                          Calendar.setup(
                                    {
                                          dateField: 'popupDateField',
                                           triggerElement: 'popupDateField'
                                      }
                                          )
                            }

                        Event.observe(window, 'load', function() { setupCalendars() })
                  </script>
</head>
     <body  >
              <%@ include file='Header.jsp' %>   <%--this include header file in all jsp --%>
              
                  <div id="Homecalender" >       <%-- this div for calender --%>  
                      <h3>Academic Calendar</h3>
                      <div id="embeddedExample" >
                         <div id="embeddedCalendar" style="margin-left: auto; margin-right: auto">
                         </div>
                       <br />
             
                         <div id="embeddedDateField" class="dateField">
                         </div>
                        <br />
                       </div>
                   </div>
                   
                   
               <div id="Homesearchbox">            <%-- this is serach box division of home page --%>
                  <form id="searchboxform"  action="Search">
                     <input id="searchbox" type="text" name="searchbox"  placeholder="Search for classroom" align="middle"  >
                     <input id="searchboxbutton" type="submit" value="search">
                  </form>
              </div>
          
          
              <div id="Homenewsevent" >             <%-- this is news and event division --%>
                          <h2 align="center">events and news</h2>
                            <marquee id="news" direction="up" >
                                    <h3 id="news1"> Submission of SRS on 15april </h3>
                                    <h3 id="news2"> Submission of report on 25april </h3>
                                    <h3 id="news3"> Final submission  on 30april </h3>
                   </marquee>
       
        
        </div>    
        
         <div id="Homeuploadpost">                   <%-- this division is for upload post --%>  
              <h2>Upload your post</h2>
                   <form action="../../UploadPostHandler" method="post">
                      <textarea name="textarea1"  placeholder ="WHATS ON IN YOUR MIND"></textarea>
                       <input id="homefilepost" type="file" name="post" value="post">
                       <h3 >attache file</h3>
                      <input id="postsubmit" type="submit" name="post" value="post" >
                  </form>
         </div>  
   
   
 <%--this is for uploaded post to display on home page --%>  
   
        <div id="uploadedpost" class="displypost" >
     
          <% 
               // this is java code for display   
             
                Connection connection=null;
                System.out.println("inside dao... [getAllPostSortByLatest]");
		         try {
		     	     connection = (Connection)ConnectionUtility.getConnection();
		         	System.out.println("connected");
			        Statement statement = (Statement)connection.createStatement();
			        Statement statement1 = (Statement)connection.createStatement();
		        	System.out.println("statement created");
			        String query = "SELECT * FROM documents ORDER BY upload_time DESC";
			
		          	System.out.println("query result genrate");
			
			
			        ResultSet resultSet = statement.executeQuery(query);
			
			
			
			
			while(resultSet.next()){
				
				Post post = new Post();
				post.setId(resultSet.getInt("post_id"));
				post.setUpLoadedBy(resultSet.getString("upload_by"));
				post.setPostcontent(resultSet.getString("postcontent"));
				
				
				//post.setUpLoadtime((Timestamp)resultSet.getString("upload_time")); 
				
				String content= post.getPostcontent().replaceAll("\n+" ,"<br />");
				System.out.println(content);
				%>
	              
	              
	           <%-- this is division  for display each post --%>   
	              
	                <div id="uploadedpostdiv"  class="displayeachpost" >
	                  
	                    <img alt="" src="/VirtualClasroom/docs/images/profile.jpg" style="left: 16%;width:60px;height:60px; ">
		 		        <h3 style="position: relative;left: 60px; top:-40px;">
				        <span style="color:red;"> <%out.println(post.getUpLoadedBy()); %>
				                  </span>  upload a new post</h3>
			
				        <P style="position: relative;left: 30px; top:-40px; width:90%">
				                   <% out.println(content); %> </P>
				
				
			
				
				        <input id="reply" type="button" value="Reply" name="Reply"
				                 style="position:relative ; top:-40px; left:10%; " onclick= "myfunction2(<%=count %>)" >
				        
				           <div id=<%=count %> style="position: relative;top:-30px; left: 0%; width: 100%; display:none;background-color: #1C184E; height:auto;" >
				                       
				                       <%
				                    
				   		        	System.out.println("statement created");
				   			        String query1 = "SELECT * FROM reply where reply_on="+post.getId()+" order by reply_time desc";
				   			
				   		          	System.out.println("query result genrate");
				   			
				   			
				   			        ResultSet resultSet1 = statement1.executeQuery(query1);  
				   			        resultSet1.afterLast();
				   			        while(resultSet1.previous())
				   			        {
				   			        	%>
				   			        	<div id="replydiv" style="position:relative;height: auto;width: 100%;left:10%;
				   			        	  " >
				   			            <h4 style="position:relative;top:0px; color: red; "><%out.print(resultSet1.getString("reply_by")); %></h4>
				   			            <font style="position:relative;top:-15px; color:white; "><%out.print(resultSet1.getString("content")); %></font>
                                         
				   			           
				   			        
				   			        
				   			        
				   			        	</div>
				   			        	
				   			        	
				   			        	
				   			        	<% 
				   			        }
				                       
				                       
				                       
				                       
				                       
				                       %>
				                       
				                       
				                         <form action="../../ReplyHandler" method="post" style=" position:relative; left: 9%; top:5px;">
				                              
				                              
				                            <input type="hidden" value="<%=post.getId() %>" name="id">  
				                           <textarea id="replycontent" rows="2" cols="40" id="replycontent" name="content"></textarea>
                                            <input type="submit" >				                         
				                         </form>
				           
				                
				           
				           </div>    
		            	 
			
<h1></h1><h1></h1>
<h1></h1>
					
			</div>
				<% 		count++;								
		}
		} catch (SQLException e) {
			System.out.println("[getAllPostSortByLatest] Exception : "+e);
		}
		
		%>
      </div>  
   
</body>
</html>