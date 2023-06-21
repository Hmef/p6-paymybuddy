package com.openclassroom.paymybuddy.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.openclassroom.paymybuddy.model.BankTransaction;
import com.openclassroom.paymybuddy.model.User;
import com.openclassroom.paymybuddy.service.BankAccountService;
import com.openclassroom.paymybuddy.service.BankTransactionService;
import com.openclassroom.paymybuddy.service.UserService;

@Controller
@RequestMapping("/")
public class BankTransactionController {

	@Autowired
	private BankTransactionService banTransactionService;
	
	@Autowired
	private UserService userService;
	
	@Autowired 
	private BankAccountService bankAccountService;
	
	@GetMapping(value = "showFormBankTransaction")
	public String showFormBankTransaction() {
		
		return "bankTransaction";
	}
	
	
	@GetMapping(value = "showNewFormBankTransaction")
	public String showNewFormBankTransaction(Model model, Principal principal) {
		
		User user = userService.findByEmail(principal.getName());
		
		model.addAttribute("user", user);
		
		model.addAttribute("bankAccountList", bankAccountService.findByUser(user.getUserId()));
		
		System.out.println("  user.getFirstname() =============> " + user.getUserId());
		
		return "addBankTransaction";
	}
	
	@PostMapping(value ="addBankTransaction")
	public String addBankTransaction(@ModelAttribute("banktransaction") BankTransaction banktransaction) {
		
		banTransactionService.saveBankTransaction(banktransaction);
		
		return "bankTransaction";
	}
	
	
	
	
}
