package com.vc.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.vc.utils.ConnectionUtility;

/**
 * Servlet implementation class BookDownloadHandler
 */
public class BookDownloadHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn= null ;
	private static final int BUFFER_SIZE = 4096;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookDownloadHandler() {
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
		
		System.out.println("inside servlet of bookdownload");
		String a= request.getParameter("book_id");
		System.out.println("book_id " +a);
		int uploadId = Integer.parseInt(request.getParameter("book_id"));
		
		 System.out.println("before try block "); 
		 try {
	            // connects to the database
			  conn=(Connection)ConnectionUtility.getConnection();

	 
	            // queries the database
	            String sql = "select * from library WHERE book_id = ?";
	            System.out.println("before execute query");
	            PreparedStatement statement = conn.prepareStatement(sql);
	            statement.setInt(1, uploadId);
	        
	            ResultSet result = statement.executeQuery();
	            System.out.println("after execute query");
	            if (result.next()) {
	                // gets file name and file blob data
	                String fileName = result.getString("filename");
	                Blob blob = result.getBlob("filecontent");
	                InputStream inputStream = blob.getBinaryStream();
	                int fileLength = inputStream.available();
	                 
	                System.out.println("fileLength = " + fileLength);
	 
	                ServletContext context = getServletContext();
	 
	                // sets MIME type for the file download
	                String mimeType = context.getMimeType(fileName);
	                if (mimeType == null) {        
	                    mimeType = "application/octet-stream";
	                }              
	                 
	                // set content properties and header attributes for the response
	                response.setContentType(mimeType);
	                response.setContentLength(fileLength);
	                String headerKey = "Content-Disposition";
	                String headerValue = String.format("attachment; filename=\"%s\"", fileName);
	                response.setHeader(headerKey, headerValue);
	 
	                // writes the file to the client
	                OutputStream outStream = response.getOutputStream();
	                 
	                byte[] buffer = new byte[BUFFER_SIZE];
	                int bytesRead = -1;
	                 
	                while ((bytesRead = inputStream.read(buffer)) != -1) {
	                    outStream.write(buffer, 0, bytesRead);
	                }
	                 
	                inputStream.close();
	                outStream.close();             
	            } else {
	                // no file found
	                response.getWriter().print("File not found for the id: " + uploadId);  
	            }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	            response.getWriter().print("SQL Error: " + ex.getMessage());
	        } catch (IOException ex) {
	            ex.printStackTrace();
	            response.getWriter().print("IO Error: " + ex.getMessage());
	        } finally {
	            if (conn != null) {
	                // closes the database connection
	                try {
	                    conn.close();
	                } catch (SQLException ex) {
	                    ex.printStackTrace();
	                }
	            }          
	        }
		}


	
	
	}


