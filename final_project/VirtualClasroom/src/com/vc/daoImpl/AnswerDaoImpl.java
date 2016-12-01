package com.vc.daoImpl;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.vc.dao.AnswerDao;
import com.vc.model.Answer;
import com.vc.utils.ConnectionUtility;

public class AnswerDaoImpl implements AnswerDao {

	
	
	Connection connection=null;
	@Override
	public boolean answerDao(Answer answerobj) {
		// TODO Auto-generated method stub
		
		
		// TODO Auto-generated method stub
		 connection=(Connection)ConnectionUtility.getConnection();
		  
		  
		   try{
			     System.out.println("inside dao");
				Statement statment = (Statement) connection.createStatement();
				
				String query = "insert into answer values(null,'"+answerobj.getAnswer_content()+"',"+answerobj.getAnswer_on()+",'"
				                      +answerobj.getAnswer_by()+"', now())";
				System.out.println("post query :" + query);
				statment.execute(query);
				return true;

			
			   
			   
		   }catch (Exception e) {
			// TODO: handle exception
			   System.out.println("exception in Dao"+e);
		}

		return false;
	}

}
