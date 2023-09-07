package com.register.controller;


import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.register.entity.User;
import com.register.repository.UserRepository;

@Controller
public class ParentController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/")
	
	public String show() {
		return "home";
	}
	
	//handler for showing register page
	@GetMapping("/register")
	public String regististrationPage(User user) {
		return "registrationPage";
	}
	
	//handler for showing login page
	@GetMapping("/login")
	public String loginPage(User user) {
		return "login";
	}
	
	//handler for register process
	@PostMapping("/register")
	@ResponseBody
	public String register(@ModelAttribute ("user") User user) {
		System.out.println(user);
		String encodedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12));
		user.setPassword(encodedPassword);
		userRepository.save(user);
		return "login";
	}
	
	
	//handler for login process
	@PostMapping("/login")
	@ResponseBody
	public String loginProcess(@RequestParam("username") String username, @RequestParam("password") String password) {
		User dbUser=userRepository.findByUsername(username);
		Boolean isPasswordMatch=BCrypt.checkpw(password, dbUser.getPassword());
		if(isPasswordMatch)
		      return "Welcome to dashboard user" + dbUser.getName();
		else
			return "Failed to login";
	}
	

}
