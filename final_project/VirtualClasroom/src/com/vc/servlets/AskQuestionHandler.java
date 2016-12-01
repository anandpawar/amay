package com.vc.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vc.model.AskQuestion;
import com.vc.service.AskQuestionService;
import com.vc.serviceImpl.AskQuestionServiceImpl;

/**
 * Servlet implementation class AskQuestionHandler
 */
public class AskQuestionHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private	AskQuestionService askquestionservice=null;
    public AskQuestionHandler() {
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
		AskQuestion question= new AskQuestion();
		 System.out.println(request.getSession(true).getAttribute("username"));
	       question.setUpLoadedBy((String)request.getSession(true).getAttribute("username"));  
	       question.setTitle(request.getParameter("title")); 
	       question.setSubject(request.getParameter("selectcategory"));  
		 
		   question.setContent(request.getParameter("textarea1"));
		   System.out.println("psot title  is "+ question.getTitle());
		   System.out.println("psot category  is "+ question.getSubject());
		 System.out.println("psot content is "+ question.getContent()); 
       System.out.println("seesion value "+question.getUpLoadedBy());
       
       askquestionservice = (AskQuestionService) new AskQuestionServiceImpl();
		
		boolean askquestion = askquestionservice.askquestion(question);
		   System.out.println("inside askwuestion handler before servicce calling");
		   System.out.println("upload post status : "+ askquestion);
		   System.out.println("inside askwuestion handler after servicce called");
		   
			//request.getRequestDispatcher("/docs/views/Home.jsp").forward(request, response);
		  response.sendRedirect("docs/views/Forum.jsp");
      
		
		
		
		
		
	}

}
