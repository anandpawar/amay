package com.vc.serviceImpl;

import com.vc.dao.ReplyDao;
import com.vc.daoImpl.ReplyDaoImpl;
import com.vc.model.Replay;
import com.vc.service.ReplyService;

public class ReplyServiceImpl implements ReplyService {

	
	
	private ReplyDao replydao =null;
	public boolean replyService(Replay replyobj) {
		// TODO Auto-generated method stub
		
		System.out.println("inside reply service");
		replydao = new ReplyDaoImpl();
		
		
		return replydao.replyDao(replyobj);
	}

}
