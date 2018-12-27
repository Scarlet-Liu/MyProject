package com.jx.maven.service;



import com.jx.maven.model.User;

public interface UserService {

	User selectUserById(Integer userId);
}
