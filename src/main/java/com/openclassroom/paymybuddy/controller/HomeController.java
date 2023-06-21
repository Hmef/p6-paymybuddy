package com.openclassroom.paymybuddy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

	@GetMapping(value = "/login")
	public String loginPage() {
		
		return "login";
	}
	
	@GetMapping(value="/contact")
	public String contact(Model model) {
		
		model.addAttribute("title", "Contact");
		
		return "contact";
	}
	
	
	@GetMapping(value="/logOff")
	public String logOff(Model model) {
		
		model.addAttribute("title", "LogOff");
		
		return "logOff";
		
	}
	
}
