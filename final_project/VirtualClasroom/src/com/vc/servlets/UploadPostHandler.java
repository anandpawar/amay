package com.vc.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vc.model.Post;
import com.vc.service.PostService;
import com.vc.serviceImpl.PostServiceImpl;

/**
 * Servlet implementation class UploadPostHandler
 */
public class UploadPostHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */ private	PostService postservice=null;
    public UploadPostHandler() {
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
		   Post post=new Post();
		   System.out.println(request.getSession(true).getAttribute("username"));
	       post.setUpLoadedBy((String)request.getSession(true).getAttribute("username"));  
		 
		   post.setPostcontent(request.getParameter("textarea1"));
         
		 System.out.println("psot content is "+ post.getPostcontent()); 
         System.out.println("seesion value "+post.getUpLoadedBy());
         
         postservice = new PostServiceImpl();
 		
 		boolean uploadpost =	postservice.UpLoadPost(post);
 		
 		   System.out.println("upload post status : "+ uploadpost);
 		   
 			//request.getRequestDispatcher("/docs/views/Home.jsp").forward(request, response);
 		  response.sendRedirect("docs/views/Home.jsp");
           
		
         
		
	}

}
