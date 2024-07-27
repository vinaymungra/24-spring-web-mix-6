package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PaymentController {
	@GetMapping("/checkout")
	public String checkout() {
		
		return "Checkout";
	}
	@PostMapping("/checkout")
	public String checkoutPageSubmitted( ) {
		
		return "Checkout";
	}
}
