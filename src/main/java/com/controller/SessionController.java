package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.UserBean;

@Controller
public class SessionController {

	@GetMapping("/login")     //When we want to 
	public String login() {
		return "Login";
	}
	
	@GetMapping("/signup")
	public String signup() {
		return "Signup";
	}
	
	@GetMapping("/fp")
	public String forgotpassword() {
		
		return "ForgotPassword";
	}
	
	@PostMapping("/saveUser")
	public String saveUser(UserBean obj,Model model)
	{
		System.out.println("Email: "+obj.getEmail());
		System.out.println("Password: "+obj.getPassword());
		model.addAttribute("user", obj);
		return "Home";
	}
}
