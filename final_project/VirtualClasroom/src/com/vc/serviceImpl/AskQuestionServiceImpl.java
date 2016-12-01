package com.vc.serviceImpl;

import com.vc.dao.AskquestionDao;
import com.vc.daoImpl.AskQuestionDaoImpl;
import com.vc.model.AskQuestion;
import com.vc.service.AskQuestionService;

public class AskQuestionServiceImpl implements  AskQuestionService {
     
	private AskquestionDao askquestiondao=null;
	@Override
	public boolean askquestion(AskQuestion question) {
		// TODO Auto-generated method stub
		System.out.println("post processing service called");
		askquestiondao= new AskQuestionDaoImpl();
		return askquestiondao.askQuestion(question);
	}

}
