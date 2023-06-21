package com.openclassroom.paymybuddy.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.openclassroom.paymybuddy.model.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long>{

}
