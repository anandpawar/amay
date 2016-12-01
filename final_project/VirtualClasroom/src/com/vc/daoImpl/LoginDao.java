package com.vc.daoImpl;

import java.sql.*;

import com.vc.dao.iLoginDao;
import com.vc.utils.ConnectionUtility;

public class LoginDao implements iLoginDao {
         Connection connection=null;  
	
	public boolean isUserValid(String user, String userid, String password) {
		System.out.println("inside Dao implementation");
		connection=ConnectionUtility.getConnection();
		try{
			 System.out.println("inside dao");
			 Statement statment=connection.createStatement();
			 String query=null;
			   
			    if("Student".equals(user))
			       query ="select count(*) as rowcount from student_login where userid='"+userid+"' and Password='"+password+"'";
			    if("Faculty".equals(user)) 
				   query ="select count(*) as rowcount from admin_login where Enroll_No='"+userid+"' and Password='"+password+"'";
			    if("Admin".equals(user))
			    	query ="select count(*) as rowcount from admin_login where Enroll_No='"+userid+"' and Password='"+password+"'";
			  
			    System.out.println("query:"+query);
				ResultSet resultset=  statment.executeQuery(query);
				resultset.next();
				int count = resultset.getInt("rowcount");
				resultset.close();
				
				System.out.println("result :"+count);
				 if(count==1)
				  {
					return true;  
					
				  }
				  else
				  {
					  return false;
		          }
		} catch (Exception e) {
			System.out.println("inside Dao exception "+e);
		}
		
	return false;	
	}

}
