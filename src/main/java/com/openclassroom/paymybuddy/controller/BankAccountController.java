package com.openclassroom.paymybuddy.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.openclassroom.paymybuddy.model.BankAccount;
import com.openclassroom.paymybuddy.model.User;
import com.openclassroom.paymybuddy.service.BankAccountService;
import com.openclassroom.paymybuddy.service.UserService;

@Controller
@RequestMapping("/")
public class BankAccountController {

	@Autowired
	private BankAccountService bankAccountService;
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("showBankAccountListForm")
	public String showBankAccountListForm(Model model) {
		
		model.addAttribute("userList", userService.getUsers());
		model.addAttribute("bankAccountList", bankAccountService.listBankAccount());
		
		return "bankAccountListt";
	}
	
	@GetMapping("getBankAccount/{userId}")
	public String getBankAccount(@PathVariable("userId")long userId, Model model) {
		
		
		model.addAttribute("userList",userService.getUsers());
		
		model.addAttribute("bankAccountlist", bankAccountService.findByUser(userId));
		

		return "bankAccountListt";
	}
	
	
	  // Principal 
	@GetMapping("profil")
	public String profil(Model model, Principal principal) {
		
		User user = userService.findByEmail(principal.getName());
		
		model.addAttribute("user", user);
		
		model.addAttribute("bankAccountList", bankAccountService.findByUser(user.getUserId()));
		
		System.out.println(" user.getFirstname() =============> " + user.getFirstname());
		
		System.out.println(" user.getUserId() =============> " + user.getUserId());
		
		return "profil";
	}
	
	
	
	@GetMapping(value ="showNewBankAccountForm")
	public String showNewBankAccountForm( Model model) {
		
		model.addAttribute("userList", userService.getUsers());
		//User user = userService.getUserById(userId).get();
		//model.addAttribute("user", user);
		
		
		return "addBankAccount";
	}
	
	
	@PostMapping(value = "saveBankAccount")
	public String saveBankAccount(@ModelAttribute("bankAccount") BankAccount bankAccount) {
		
		bankAccountService.saveBankAccount(bankAccount);
		
		return "bankAccountList";
	}
	
	
	
	@GetMapping(value = {"/bankAccountList"})
	public String viewBankAccountPage(Model model) {
		
		
		return findPaginatedBankAccount(1, model);
		
	}
	
	@GetMapping("/pagee/{pageNo}")
	public String findPaginatedBankAccount(@PathVariable(value = "pageNo") int pageNo, Model model) {
		
		int pageSize = 5;
		
		Page<BankAccount> pagee = bankAccountService.findPaginatedBankAccount(pageNo, pageSize);
		
		List<BankAccount> bankaccountList = pagee.getContent();
		

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", pagee.getTotalPages());
		model.addAttribute("totalItems", pagee.getTotalElements());
		
		model.addAttribute("bankaccountList",bankaccountList);
		
		return "/bankAccountList";
	}

	
	
}
