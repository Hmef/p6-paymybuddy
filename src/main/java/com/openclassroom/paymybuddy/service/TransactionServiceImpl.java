package com.openclassroom.paymybuddy.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassroom.paymybuddy.Repository.TransactionRepository;
import com.openclassroom.paymybuddy.model.Transaction;

@Service
public class TransactionServiceImpl {

	
	@Autowired
	private TransactionRepository transactionRepository;
	
	
	public Iterable<Transaction> getTransactions(){
		
		return transactionRepository.findAll();
		
	}
	
	public Optional<Transaction> getTransactionById(long id){
		
		return transactionRepository.findById(id);
		
	}
	
	/*
	 // sendMoney or Payement : choose after
	 public Transaction sendMoney(){
	 
	 Transaction transaction = new Transaction();
	 transaction.setAmount();
	 transaction.setUserSender().getAmount();
	 userSender.updateAmount();
	 transaction.setUserGetter().getAmount();
	 usergetter.updateAmount(); // add the amount send by userSender 
	 saveTransaction(Transaction transaction);
	 
	 // Amount User 1 : - amount 
	 // Amount User 2 : + amount
	  
	 
	 
	   }
	 */
}
