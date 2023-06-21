package com.openclassroom.paymybuddy.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.openclassroom.paymybuddy.Repository.BankAccountRepository;
import com.openclassroom.paymybuddy.Repository.UserRepository;
import com.openclassroom.paymybuddy.model.BankAccount;
import com.openclassroom.paymybuddy.model.User;

@Service
public class BankAccountServiceImpl implements BankAccountService{

	
	@Autowired
	private BankAccountRepository bankAccountRepository;
	
	@Autowired
	private UserService userService;
	
	
	
	public Iterable<BankAccount> getBankAccount() {
		
		return bankAccountRepository.findAll();
		
	}
	
	
	public Optional<BankAccount> getBankAccountById(long id){
		
		return bankAccountRepository.findById(id);
		
	}


	@Override
	public Iterable<BankAccount> listBankAccount() {
		
		return bankAccountRepository.findAll();
	}


	@Override
	public List<BankAccount> findByUser(long userId) {
		
		
		return bankAccountRepository.findByUser_UserId(userId);
	}

	@Override
	public void saveBankAccount(BankAccount bankAccount) {
		
		bankAccountRepository.save(bankAccount);
		
	}


	@Override
	public void deleteBankAccount(long bankaccountId) {
		
		bankAccountRepository.deleteById(bankaccountId);
		
	}



	@Override
	public Page<BankAccount> findPaginatedBankAccount(int pageNo, int pageSize) {
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);

		return this.bankAccountRepository.findAll(pageable);
	}
	
	
	/*
	@Override
	public void addAmount(long userId, double amount) {
		
		//BankAccount bankAccount = this.getBankAccountById(bankaccountId).get();
		//double newBalance = bankAccount.get

		
	}
	
	*/
	
	
}
