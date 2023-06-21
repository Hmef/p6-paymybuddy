package com.openclassroom.paymybuddy.service;


import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.openclassroom.paymybuddy.model.BankAccount;



public interface BankAccountService {

	
	public Iterable<BankAccount> listBankAccount();
	
	public Optional<BankAccount> getBankAccountById(long id);
	
	public List<BankAccount> findByUser(long userId);
	
	public void saveBankAccount(BankAccount bankAccount);
	
	public void deleteBankAccount(long bankaccountId);
	
	//public void addAmount(long userId, double amount);
	
	public Page<BankAccount> findPaginatedBankAccount(int pageNo, int pageSize);
}
