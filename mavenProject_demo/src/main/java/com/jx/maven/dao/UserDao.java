package com.jx.maven.dao;


import com.jx.maven.model.User;

public interface UserDao {

	 /**
     * @param userId
     * @return User
     */
    public User selectUserById(Integer userId);
}
