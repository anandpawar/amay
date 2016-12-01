package com.vc.daoImpl;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.vc.dao.AskquestionDao;
import com.vc.model.AskQuestion;
import com.vc.utils.ConnectionUtility;

public class AskQuestionDaoImpl implements AskquestionDao {

	@Override
	public boolean askQuestion(AskQuestion question) {
		
		// TODO Auto-generated method stub
		System.out.println("post processing dao called");
		Connection connection=null;
		
	
			  connection=(Connection)ConnectionUtility.getConnection();
			  
			  
			   try{
				     System.out.println("inside dao");
					Statement statment = (Statement) connection.createStatement();
					
					String query = "insert into askquestion() values(null,'"+question.getSubject()+"', '"+question.getTitle() +"' ,'"
							+ question.getUpLoadedBy() + "','" + question.getContent() + "',null,null,now())";
					System.out.println("AskQuestion  query :" + query);
					statment.execute(query);
					return true;

				
				   
				   
			   }catch (Exception e) {
				// TODO: handle exception
				   System.out.println("exception in askquestionDao "+e);
			}
			  	return false;
		}

	}


