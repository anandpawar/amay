package com.vc.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vc.model.Answer;
import com.vc.model.Replay;
import com.vc.service.AnswerService;
import com.vc.serviceImpl.AnswerServiceImpl;
import com.vc.serviceImpl.ReplyServiceImpl;

/**
 * Servlet implementation class AnswerHandler
 */
public class AnswerHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	 private AnswerService answerservice=null;
    public AnswerHandler() {
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
	
		 System.out.println("inside answer handler");
		   
		   
		   Answer answerobj= new Answer();
		   
		   
		   String content=request.getParameter("content");
		   content  = content.replaceAll("\n+", "<br />");
		   answerobj.setAnswer_content(content);
		   //String a= request.getParameter("id");
		    long id= Integer.parseInt(request.getParameter("id"));
		   answerobj.setAnswer_by((String)request.getSession(true).getAttribute("username"));
		   answerobj.setAnswer_on(id);
		   System.out.println("replay on id: " +answerobj.getAnswer_on());
		    System.out.println("reply by : "+ answerobj.getAnswer_by());   
		   System.out.println("Reply Content is : "+ answerobj.getAnswer_content());
		   
		   answerservice=new AnswerServiceImpl();
		   
		   boolean answerresult =	answerservice.answerService(answerobj);
			
			   System.out.println("upload post status : "+answerresult);
			   
				//request.getRequestDispatcher("/docs/views/Home.jsp").forward(request, response);
			  response.sendRedirect("docs/views/Forum.jsp");
	       
		
		   
		   
		
		
		
		}
	
	

}
