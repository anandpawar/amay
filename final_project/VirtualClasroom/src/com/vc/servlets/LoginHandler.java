package com.vc.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import com.mysql.jdbc.Statement;
import com.vc.service.iLoginService;
import com.vc.serviceImpl.Loginservice;
import com.vc.utils.ConnectionUtility;

/**
 * Servlet implementation class LoginHandler
 */
public class LoginHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginHandler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//in dopost of Login handler
		String user =request.getParameter("user");
		String userid =request.getParameter("userid");
		String password = request.getParameter("password");
       System.out.println("User is " +user);
       System.out.println("Userid is " +userid);
       System.out.println("password is " +password);
     iLoginService  a= new Loginservice();
     boolean isuservalid = a.isUserValid(user, userid, password);
     if(isuservalid)
     {
      System.out.println("user is validate succesfully");
      request.getSession().setAttribute("userid", userid);
      request.getSession().setAttribute("password",password);
      Connection connection=null;
      try {
			connection = (Connection)ConnectionUtility.getConnection();
			System.out.println("connected");
			Statement statement = (Statement)connection.createStatement();
			System.out.println("statement created");
			String query = "SELECT first_name,last_name from user where userid ='"+userid+"'";
			System.out.println("query result genrate");
			System.out.println("query is "+query);
			 ResultSet resultSet = statement.executeQuery(query);
			 System.out.println("before gettin name");
			 while(resultSet.next()){
			 System.out.println(resultSet.getString("first_name"));
			 String firstname= resultSet.getString("first_name");
			 String lastname= resultSet.getString("last_name");
			 
            String username=firstname+" "+lastname;
            System.out.println("username is : " +username );
           request.getSession().setAttribute("username", username);
			 }
			 }catch (Exception e) {
		// TODO: handle exception
    	  System.out.println("exception in sessiom "+e);
	}
     // request.getRequestDispatcher("docs/views/Home.jsp").forward(request, response);
        response.sendRedirect("docs/views/Home.jsp");
       
  	}else{
		System.out.println("user not found in database");
		
       // RequestDispatcher rd = request.getRequestDispatcher("docs/views/Login.jsp");
       // rd.forward(request, response);  
		request.getSession().setAttribute("errorMessage","inavalid username or password");
	     response.sendRedirect("docs/views/Login.jsp");
		//request.getRequestDispatcher("docs/views/Login.jsp").forward(
		//, response);
	}
     
	}
}

