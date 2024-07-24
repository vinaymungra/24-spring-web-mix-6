package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.StudentBoxCricBean;

@Controller
public class StudentController {
	
	@GetMapping("/boxcricketregistration")
	public String boxRegistration() 
	{
		return "BoxCricReg";
	}
	
	@PostMapping("/savereg")
	public String saveRegistration(StudentBoxCricBean obj,Model model)
	{

		boolean isError=false;
		
		String alphaRegEx ="[a-zA-Z]+";
		
		if(obj.getStudentName()==null||obj.getStudentName().trim().length()==0)
		{
			isError=true;
			model.addAttribute("studentNameError","Please Enter Student Name");
		}
		else if(obj.getStudentName().matches(alphaRegEx)==false)
		{
			isError=true;
			model.addAttribute("studentNameError","Please Enter Valid Student Name");
		}
		else {
			model.addAttribute("studentNameValue",obj.getStudentName());
		}
		
		if(obj.getPlayerType()==null) {
			isError=true;
			model.addAttribute("playerTypeError","Please Select PlayerType");
		}
		else {
			model.addAttribute("studentPlayerValue",obj.getPlayerType());
		}
		
		if(obj.getFoodPreference().equals("-1"))
		{
			model.addAttribute("foodPreferenceError","Please Select FoodPreference");
			isError=true;
		}
		else {
			model.addAttribute("studentFoodValue",obj.getFoodPreference());
		}
		
		if(obj.getDrink()==null)
		{
			model.addAttribute("drinkError","Please Select Drink");
			isError=true;
		}
		else {
			model.addAttribute("studentDrinkValue",obj.getDrink());
		}
		
		if(isError)
		{
			return "BoxCricReg";
		}
		else {
		 
			model.addAttribute("reg",obj);
			return "RegDetails";
		}
	}
}
