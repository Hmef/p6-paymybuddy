package com.openclassroom.paymybuddy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.openclassroom.paymybuddy.model.Transaction;

@Controller
@RequestMapping("/")
public class TransactionController {

	
	@GetMapping(value = "transfer")
	public String showTransferForm() {
		
		return "transfer";
	}
	
	@PostMapping( value = "addNewTransaction")  
	public String saveNewTransaction(@ModelAttribute("transaction") Transaction transaction) {
		
		// transactionService.saveTransaction(transaction);
		
		return "transfer";
	}
	
	
	@PostMapping(value="payement")
	public String payement() {
		
		// choose a connection 
		// add an amount 
		return "transfer";
	}
	
}
