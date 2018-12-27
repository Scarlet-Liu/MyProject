package com.jx.maven.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jx.maven.model.User;
import com.jx.maven.service.UserService;

@Controller
public class UserController {

	@Resource	
	private UserService userService;

	@RequestMapping("/")
	public ModelAndView getIndex() {
		System.out.println("begin");
		ModelAndView mav = new ModelAndView("index");
		System.out.println(mav.getViewName());
		System.out.println("aa");
		User user = userService.selectUserById(1);
		System.out.println(user.getUserName());
		mav.addObject("user", user);
		return mav;
	}
}
