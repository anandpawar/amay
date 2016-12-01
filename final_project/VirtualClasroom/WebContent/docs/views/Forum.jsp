<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.io.*,java.util.*, javax.servlet.*,java.sql.ResultSet,
 java.sql.SQLException, java.util.ArrayList, java.util.List,com.mysql.jdbc.Connection, com.mysql.jdbc.Statement
,com.sun.jmx.snmp.Timestamp, com.vc.dao.PostDao,com.vc.model.*, com.vc.utils.ConnectionUtility" %>

<html>
<head>
<script src="/VirtualClasroom/docs/js/jquery-1.11.2.js"></script>
<%int count=0; %>
<script type="text/javascript">

  function myfunction2(y)
  {
	   var x = document.getElementById(y);
	    if(x.style.display=="block")           
	    	x.style.display="none";

	    	else
	    		x.style.display="block";

	    		 
	  }

</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forum Page</title>
<link rel="stylesheet" href="../css/Style.css">
</head>


<body>
<%@ include file='Header.jsp' %>
      <div id="forumaskquestion" >
              <h2 >Ask your question</h2>
              <form action="../../AskQuestionHandler" method="post">
                    <h3 style="position:absolute;left:30px;top:55px;z-index:0;">select category</h3>
                    <select id="askquestionselect"  name="selectcategory"  >
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
                         <option value="Others">Others</option>
                                     
                    </select>

                    <input id="askquestiontitle" type="text" placeholder="Title" name="title" >
                    <textarea name="textarea1" ></textarea>
                     <input id="askquestionfile" type="file"  >
                     <h3 style="position:absolute;left:30px;top:265px;z-index:0;"  >attache file</h3>
                     <input id="askquestionsubmit" type="submit" name="submit" value="Submit" >
              </form>
         </div>
 
         <div id="forumsearchbox" >
                    <h2>search question </h2>
                     <form action="Searchquestion" >
                    <h3 style="position:absolute;left:5px;top:40px;z-index:0; color: white;">select category</h3>
                    <select id="Searchquestionselect"  name="select category"  >
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
                         <option value="Admin">All</option>
                                     
                    </select>

                    <input id="Searchquestiontitle"type="text" placeholder="Question" >
                    <input id="Searchquestionsubmit" type="submit" name="submit" value="Search" >
              </form>
                    
         </div>
         
         
         <div id="Homenewsevent" >
           <h2 align="center">events and news</h2>
                 <marquee id="news" direction="up" >
                        <h3 id="news1" align="center"> submission of srs on 15april </h3>
                        <h3 id="news2" align="center"> submission of report on 25april </h3>
                        <h3 id="news3" align="center"> submission of project on 30april </h3>
                   </marquee>
       
        
        </div>    
       
        
        
         <div id="uploadedpost" style="position:absolute;  overflow:hidden; left:16%; 
                  top:480px; width:50%;  z-index:0  ;background: #DFDFDF;">
     
                               <% 
                                                              
                                   Connection connection=null;
                                    System.out.println("inside dao... [getAllPostSortByLatest]");
		                        try {
			                               connection = (Connection)ConnectionUtility.getConnection();
		 	                               System.out.println("connected");
			                               Statement statement = (Statement)connection.createStatement();
			                               Statement statement1 = (Statement)connection.createStatement();
			                               System.out.println("statement created");
		                                  	String query = "SELECT * FROM askquestion ORDER BY uploadtime DESC";
		                                  //	Statement statement1 = (Statement)connection.createStatement();
	                                     	//	System.out.println("query result genrate");
			
			
		                                       	ResultSet resultSet = statement.executeQuery(query);
			
		                                     	System.out.println("query result genrate");
			
			
		                                             	while(resultSet.next()){
		                                             		
		                                               		AskQuestion question = new AskQuestion();
		                                                	question.setId(resultSet.getInt("question_id"));
			                                             	question.setUpLoadedBy(resultSet.getString("uploaded_by"));
			                                               	question.setContent(resultSet.getString("content"));
		                                            		question.setSubject(resultSet.getString("subject"));
		                                            		question.setTitle(resultSet.getString("title"));
		                                               		System.out.println("after store data");  
		                                               		String content= question.getContent().replaceAll("\n+" ,"<br />");
				
		                                          	//	question.setUpLoadtime((Timestamp)resultSet.getObject("uploadtime"));
			                                    	//post.setUpLoadtime((Timestamp)resultSet.getString("upload_time")); 
				%>
	                   <div id="uploadedpostdiv" style="position:relative ; background: white; top:5px;left:5px;width:98%; height: auto;">
	                        <img alt="" src="/VirtualClasroom/docs/images/profile.jpg" style="left: 16%;width:60px;height:60px; ">
			             	<h3 style="position: relative;left: 60px; top:-40px;"><span style="color:red;">
			             	 <%out.println(question.getUpLoadedBy()); %></span>asked an question</h3>
			             	
			                <font style="position: relative; top:-30px;">question ID :  <%out.println(question.getId()); %>  
			                <b>   <%out.println(question.getTitle()); %></b></font>
			               	<P style="position: relative;left: 30px; top:-40px; width:80%">
			               	<% out.println("  " +content); %> </P>
			            	  
			            	 
			            	  <input id="answer" type="submit" value=answer name="answer"  
			            	            style=" position:relative; top:-40px; left:10%;" onclick= "myfunction2(<%=count %>)" >
				
		                          <div id=<%=count%> style="position: relative;top:-30px; left:0%;height:auto; display: none; background-color: #1C184E;">
		                             
                                    <% 	System.out.println("statement created");
				   			        String query1 = "SELECT * FROM answer where answer_on="+question.getId()+" order by answer_time desc";
				   			
				   		          	System.out.println("query result genrate");
				   			
				   			
				   			        ResultSet resultSet1 = statement1.executeQuery(query1);  
				   			        resultSet1.afterLast();
				   			     while(resultSet1.previous())
				   			        {
		                          
				   			     %><div id="answerdiv" style="position:relative;height: auto;width: 100%;left:10%;
				   			        	  " >
				   			            <h4 style="position:relative;top:0px; color: red; "><%out.print(resultSet1.getString("answer_by")); %></h4>
				   			            <font style="position:relative;top:-15px; color:white; "><%out.print(resultSet1.getString("answer_content")); %></font>
                                         
				   			           
				   			        
				   			        
				   			        
				   			        	</div>
				   			        	<%} %>
				   			        	 <form action="../../AnswerHandler" method="post" style=" position:relative; left: 5%; top:5px;">
				                              
				                              
				                            <input type="hidden" value="<%=question.getId() %>" name="id">  
				                           <textarea id="answercontent" rows="5" cols="60" id="replycontent" name="content"></textarea>
                                            <input type="submit" >				                         
				                         </form>
				           
				   			        	
				   			     
				   			     
				   			     </div>
			
                                  <h1></h1><h1></h1>
                                   <h1></h1>
					
			           </div>
				<% 			count++;	
				  System.out.print("count value"+count);
		}
		} catch (SQLException e) {
			System.out.println("[getAllPostSortByLatest] Exception : "+e);
		}
		
		%>
      </div>  
    
        
        
      
      
       </body>
</html>