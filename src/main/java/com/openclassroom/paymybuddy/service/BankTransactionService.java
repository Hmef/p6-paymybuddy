package com.openclassroom.paymybuddy.service;

import java.util.Optional;

import org.springframework.data.domain.Page;

import com.openclassroom.paymybuddy.model.BankTransaction;

public interface BankTransactionService {
	
	
	public Iterable<BankTransaction> listBankTransaction();
	
	public Optional<BankTransaction> getBankTransactionById(long id);
	
	//public List<BankTransaction> findByUser(long userId);
	
	//public List<BankTransaction> findByBankAccount(long bankaccountId);
	
	public void saveBankTransaction(BankTransaction bankTransaction);
	
	public void deleteBankTransaction(long id);
	
	public void makeTransaction(long userId, long bankaccountId, double amount, int numero);
	
	public Page<BankTransaction> findPaginatedBankTransaction(int pageNo, int pageSize);

	
}
