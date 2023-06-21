package com.openclassroom.paymybuddy.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.openclassroom.paymybuddy.Repository.BankTransactionRepository;
import com.openclassroom.paymybuddy.model.BankAccount;
import com.openclassroom.paymybuddy.model.BankTransaction;
import com.openclassroom.paymybuddy.model.User;

@Service
public class BankTransactionServiceImpl implements BankTransactionService{

	
	@Autowired
	private BankTransactionRepository bankTransactionRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BankAccountService bankAccountService;
	
	
	public Iterable<BankTransaction> listBankTransaction(){
		
		return bankTransactionRepository.findAll();
		
	}
	
	
	public Optional<BankTransaction> getBankTransactionById(long id){
		
		return bankTransactionRepository.findById(id);
	}


	@Override
	public void saveBankTransaction(BankTransaction bankTransaction) {
		
		bankTransactionRepository.save(bankTransaction);
		
	}


	@Override
	public void deleteBankTransaction(long id) {
		
		bankTransactionRepository.deleteById(id);
		
	}


	@Override
	public Page<BankTransaction> findPaginatedBankTransaction(int pageNo, int pageSize) {
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		
		return this.bankTransactionRepository.findAll(pageable);

	}


	@Override
	public void makeTransaction(long userId, long bankaccountId, double amount, int numero) {
	
		//  Retrait : from Bank Account To User Account 
		User user = userService.getUserById(userId).get();
		
		BankAccount bankAccount = bankAccountService.getBankAccountById(bankaccountId).get();
		
		BankTransaction bankTransaction = new BankTransaction(numero, new Date(), amount, user, bankAccount);
		
		double NewSolde =  user.getSolde() + amount;
		user.setSolde(NewSolde);
		
		userService.updateUser(user); // Update Solde 
		
		this.saveBankTransaction(bankTransaction);
		
		bankAccount.getIBAN();
		
	}


	/*
	
	public BankTransaction findByBankAccount(long bankaccountId) {
		
		
		return bankTransactionRepository.findByBankAccount_BankaccountId(bankaccountId);
	}


	
	public BankTransaction findByUser(long userId) {
		
		
		return bankTransactionRepository.findByUser_UserId(userId);
	}
	
	*/
}
