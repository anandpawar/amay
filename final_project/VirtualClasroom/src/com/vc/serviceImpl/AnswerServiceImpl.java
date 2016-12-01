package com.vc.serviceImpl;

import com.vc.dao.AnswerDao;
import com.vc.daoImpl.AnswerDaoImpl;
import com.vc.model.Answer;
import com.vc.service.AnswerService;

public class AnswerServiceImpl implements AnswerService {

	
	
	private AnswerDao answerdao =null;
	@Override
	public boolean answerService(Answer answerobj) {
		// TODO Auto-generated method stub
		
		
		System.out.println("inside reply service");
		answerdao = new AnswerDaoImpl();
		
		return answerdao.answerDao(answerobj);
	}

}
