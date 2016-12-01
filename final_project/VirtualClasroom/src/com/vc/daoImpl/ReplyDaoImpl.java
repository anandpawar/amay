package com.vc.daoImpl;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.vc.dao.ReplyDao;
import com.vc.model.Replay;
import com.vc.utils.ConnectionUtility;

public class ReplyDaoImpl implements ReplyDao{

	
	Connection connection=null;
	public boolean replyDao(Replay replyobj) {
		// TODO Auto-generated method stub
		 connection=(Connection)ConnectionUtility.getConnection();
		  
		  
		   try{
			     System.out.println("inside dao");
				Statement statment = (Statement) connection.createStatement();
				
				String query = "insert into reply values(null,'"+replyobj.getContent()+"','"+replyobj.getReplyBy()+"',"
				                      +replyobj.getReplyon()+", now())";
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


