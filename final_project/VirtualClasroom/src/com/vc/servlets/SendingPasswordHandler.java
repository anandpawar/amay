package com.vc.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vc.utils.ConnectionUtility;
import com.vc.utils.EmailUtility;

/**
 * Servlet implementation class SendingPasswordHandler
 */
public class SendingPasswordHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	
	private String host;
	private String port;
	private String user;
	private String pass;

    public SendingPasswordHandler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    Connection connection=null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		host = "smtp.gmail.com";
		port = "587";
		user = "abhisheksahu1322@gmail.com";
		pass = "sahu@123";
	
	
		String userid=request.getParameter("userid");
		String recipient="";
		String content="";
		String subject="";
		connection=ConnectionUtility.getConnection();
		try{
			 System.out.println("inside dao");
			 Statement statment=connection.createStatement();
			 String query=null;
			       query ="select password , Emailid  from user where userid='"+userid+"'";
			  
			    System.out.println("query:"+query);
				ResultSet resultset=  statment.executeQuery(query);
				
				//resultset.beforeFirst();
				
				while(resultset.next()){
				
				 recipient = resultset.getString("Emailid");
				 subject = "Your virtual classroom password";
				 content = resultset.getString("password");
				//System.out.println("user id is : "+recipient);
			//	System.out.println("user password is "+content );

				}
				
				
		 } catch (Exception e) {
			System.out.println("inside Dao exception "+e);
		}
		 System.out.println("email id is : "+recipient);
			System.out.println("user password is "+content );
		String resultMessage = "";

		try {
			EmailUtility.sendEmail(host, port, user, pass, recipient, subject,
					content);
			resultMessage = "The e-mail was sent successfully";
		} catch (Exception ex) {
			ex.printStackTrace();
			resultMessage = "There were an error: " + ex.getMessage();
		} finally {
			request.setAttribute("Message", resultMessage);
			System.out.println("inside the servlet: "+resultMessage);
			getServletContext().getRequestDispatcher("/Result.jsp").forward(
					request, response);
		}
	
	
	}

}
