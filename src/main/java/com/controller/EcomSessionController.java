package com.controller;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.bean.EUserBean;
import com.dao.EUserDao;
import com.service.FileUploadService;
import jakarta.servlet.http.HttpSession;

@Controller
public class EcomSessionController {
	
	@Autowired
	EUserDao dao;
	
	@Autowired
	FileUploadService fileUploadService;
	
	
	@GetMapping(value={"/","/elogin"})
	public String welcome() {
		return "EcomLogin";
	}
	
	
	@PostMapping("/elogin")
	public String eLogin(EUserBean userBean,Model model,HttpSession session)
	{
		EUserBean dbUser = dao.authenticate(userBean.getEmail(), userBean.getPassword());
		if (dbUser == null) {
			model.addAttribute("error", "Invalid Credentials");
			return "EcomLogin";
		} 
		else {
			session.setAttribute("user", dbUser);
			model.addAttribute("firstName", dbUser.getFirstName());
			model.addAttribute("profilePicPath", dbUser.getProfilePicPath());
			return "EcomHome";
		}
	}
	@GetMapping("/esignup")
	public String signup() {
		
		return "EcomSignup";
	}
	
	@PostMapping("/esignup")
	public String signupPost(EUserBean obj,Model model) {
		boolean isError=false;
		
		String alphaRegEx ="[a-zA-Z]+";
		System.out.println(obj.getFirstName());
		if(obj.getFirstName()==null||obj.getFirstName().trim().length()==0)
		{
			//System.out.println("1");
			isError=true;
			model.addAttribute("firstNameError","Please Enter First Name");
		}
		else if(obj.getFirstName().matches(alphaRegEx)==false)
		{
			//System.out.println("2");
			isError=true;
			model.addAttribute("firstNameError","Please Enter Valid First Name");
		}
		else {
			model.addAttribute("firstNameValue",obj.getFirstName());
		}
		
		if(obj.getEmail()==null) {
			//System.out.println("3 ");
			isError=true;
			model.addAttribute("emailTypeError","Please Enter Email");
		}
		else {
			model.addAttribute("email",obj.getEmail());
		}
		if(obj.getPassword()==null) {
			//System.out.println("3 ");
			isError=true;
			model.addAttribute("passwordTypeError","Please Enter password");
		}
		else {
			model.addAttribute("password",obj.getPassword());
		}
		
		if(isError)
		{
			return "EcomSignup";
		}
		
		
		System.out.println(obj.getProfilePic().getOriginalFilename());
		
		String profilePicName=obj.getProfilePic().getOriginalFilename();
		
		obj.setProfilePicPath("images/profilePic/"+obj.getEmail()+"/"+profilePicName);
		System.out.println(obj.getProfilePicPath());
		String path="D:\\SpringBoot\\24-spring-web-mix-6\\src\\main\\webapp\\images\\profilePic\\"+obj.getEmail()+"\\";
		fileUploadService.uploadProductImage(obj.getProfilePic(),path);
		
		dao.insertUser(obj);
		
		return "EcomLogin";
	}
	
	@GetMapping("/ehome")
	public String home()
	{
		return "EcomHome";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		//destroy session 
		session.invalidate();
		return "redirect:/elogin";
	}

	
}
