package com.vc.daoImpl;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.vc.dao.PostDao;
import com.vc.model.Post;
import com.vc.utils.ConnectionUtility;

public class PostDaoImpl implements PostDao {
  
	
	Connection connection=null;
	@Override
	public boolean UpLoadPost(Post post) {
		  connection=(Connection)ConnectionUtility.getConnection();
		  
		  
		   try{
			     System.out.println("inside dao");
				Statement statment = (Statement) connection.createStatement();
				
				String query = "insert into documents() values(null,now(),null,'"
						+ post.getUpLoadedBy() + "',null,'" + post.getPostcontent() + "')";
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
