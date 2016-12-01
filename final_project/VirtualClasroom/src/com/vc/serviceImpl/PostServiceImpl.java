package com.vc.serviceImpl;

import java.util.List;

import com.vc.dao.PostDao;
import com.vc.daoImpl.PostDaoImpl;
import com.vc.model.Post;
import com.vc.service.PostService;

public class PostServiceImpl implements PostService {
	private PostDao postdao = null;
	@Override
	public boolean UpLoadPost(Post post) {
		// TODO Auto-generated method stub
		postdao=new PostDaoImpl();
		System.out.println("post processing service called");
        
		return postdao.UpLoadPost(post);
		
		
	}
	


	
}
