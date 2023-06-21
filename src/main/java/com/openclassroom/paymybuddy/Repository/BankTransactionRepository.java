package com.openclassroom.paymybuddy.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.openclassroom.paymybuddy.model.BankTransaction;

@Repository
public interface BankTransactionRepository extends JpaRepository<BankTransaction, Long>{

	//BankTransaction findByBankAccount_BankaccountId(long bankaccountId);
	
	//BankTransaction findByUser_UserId(long userId);
}
