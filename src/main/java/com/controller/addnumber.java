package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.AddNumber;
import com.bean.UserBean;

@Controller
public class addnumber {
	
	@PostMapping("/addNumber")
	public String addnumber(AddNumber obj,Model model)
	{
		model.addAttribute("obj", obj);
		return "DisplayNumbers";
	}
	@GetMapping("/takeNumber")
	public String takenumber()
	{
		return "TakeNumbers";
	}
}
