package com.vc.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vc.model.Replay;
import com.vc.service.ReplyService;
import com.vc.serviceImpl.ReplyServiceImpl;

/**
 * Servlet implementation class ReplyHandler
 */
public class ReplyHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	 private ReplyService replyservice=null;
    public ReplyHandler() {
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
	
	   System.out.println("inside reply handler");
	   
	   
	   Replay replyobj= new Replay();
	   
	   
	   String content=request.getParameter("content");
	   content  = content.replaceAll("\n+", "<br />");
	   replyobj.setContent(content);
	   //String a= request.getParameter("id");
	    long id= Integer.parseInt(request.getParameter("id"));
	   replyobj.setReplyBy((String)request.getSession(true).getAttribute("username"));
	   replyobj.setReplyon(id);
	   System.out.println("replay on id: " +replyobj.getReplyon());
	    System.out.println("reply by : "+ replyobj.getReplyBy());   
	   System.out.println("Reply Content is : "+ replyobj.getContent());
	   
	   replyservice=new ReplyServiceImpl();
	   
	   boolean replyresult =	replyservice.replyService(replyobj);
		
		   System.out.println("upload post status : "+ replyresult);
		   
			//request.getRequestDispatcher("/docs/views/Home.jsp").forward(request, response);
		  response.sendRedirect("docs/views/Home.jsp");
       
	
	   
	   
	
	
	
	}

}
