package com.openclassroom.paymybuddy.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.openclassroom.paymybuddy.model.BankAccount;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Long>{
	
	List<BankAccount> findByUser_UserId(long userId);

}
