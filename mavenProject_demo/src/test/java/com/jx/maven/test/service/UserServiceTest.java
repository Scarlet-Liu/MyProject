package com.jx.maven.test.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jx.maven.model.User;
import com.jx.maven.service.UserService;
import com.jx.maven.test.SpringTestCase;

public class UserServiceTest extends SpringTestCase {

    @Autowired  
    private UserService userService; 

    @Test  
    public void selectUserByIdTest(){  
        User user = userService.selectUserById(2);  
        System.out.println(user.getUserName() + ":" + user.getUserPassword());
    }  

}
