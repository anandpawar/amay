package com.vc.serviceImpl;

import com.vc.dao.iLoginDao;
import com.vc.daoImpl.LoginDao;
import com.vc.service.iLoginService;

public class Loginservice implements iLoginService{
	private iLoginDao ilogin= null;

	@Override
	public boolean isUserValid(String user, String userid, String password) {
		// TODO Auto-generated method stub
		System.out.println("inside Loginservice");
		ilogin = new LoginDao();
		return ilogin.isUserValid(user, userid, password);
 	}
	
	

}
