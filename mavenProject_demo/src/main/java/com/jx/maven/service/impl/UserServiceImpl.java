package com.jx.maven.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jx.maven.dao.UserDao;
import com.jx.maven.model.User;
import com.jx.maven.service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;	
	
	public User selectUserById(Integer userId) {
		System.out.println("dao");
		
		return userDao.selectUserById(userId);
	}

}
