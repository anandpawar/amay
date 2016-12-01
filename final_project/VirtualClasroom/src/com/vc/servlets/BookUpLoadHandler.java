package com.vc.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.mysql.jdbc.Connection;
import com.vc.utils.ConnectionUtility;

/**
 * Servlet implementation class BookUpLoadHandler
 */

@WebServlet("/uploadServlet")
@MultipartConfig(maxFileSize = 16177215)

public class BookUpLoadHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	    Connection connection= null ;
	    
	    
	      
	  
	  public BookUpLoadHandler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    String uploadedby=(String) request.getSession(true).getAttribute("username");
	    String subject= request.getParameter("subject");
	    String filetype= request.getParameter("filetype");
	    String title= request.getParameter("title").replaceAll(" " , "_");
	     
	    String writername= request.getParameter("writername");
	    String filename = title+"."+filetype;
	   
	    InputStream inputStream = null;
	  //  Systemoutprintln("before file part");
	    // obtains the upload file part in this multipart request
        Part filepart=   request.getPart("book");
       // Systemoutprintln("after multipart");
        if (filepart != null) {
            // prints out some information for debugging
            System.out.println(filepart.getName());
            System.out.println(filepart.getSize());
            System.out.println(filepart.getContentType());
  
            
            // obtains input stream of the upload files
            inputStream = filepart.getInputStream();
        }
         
         // connection to the database
        String message = null;  // message will be sent back to client
         
       try {
            // connects to the database
        	connection=(Connection)ConnectionUtility.getConnection();
 
            // constructs SQL statement
            String sql = "INSERT INTO library(uploadedby,subject,title,filename,writername,filetype,filecontent) values ( ?, ?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,uploadedby);
            statement.setString(2, subject);
            statement.setString(3, title);
            statement.setString(4, filename);
            statement.setString(5, writername);
            statement.setString(6, filetype);
            
             
            if (inputStream != null) {
                // fetches input stream of the upload file for the blob column
                statement.setBlob(7, inputStream);
            }
 
            // sends the statement to the database server
            int row = statement.executeUpdate();
            if (row > 0) {
                message = "File uploaded and saved into database";
            }
        } catch (SQLException ex) {
            message = "ERROR: " + ex.getMessage();
            ex.printStackTrace();
        } finally {
            if (connection != null) {
                // closes the database connection
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            // sets the message in request scope
           // request.setAttribute("Message", message); 
           // getServletContext().getRequestDispatcher("/docs/views/Library.jsp").forward(request, response);
	       response.sendRedirect("docs/views/Library.jsp");
        
        
        }
	}
        }

	


