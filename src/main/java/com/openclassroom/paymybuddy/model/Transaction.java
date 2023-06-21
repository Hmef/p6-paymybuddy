package com.openclassroom.paymybuddy.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "transaction_id")
	private long transactionId;

	@Column(name = "numero")
	private int numero;

	//@DateTimeFormat(pattern = "yyyy-MM-dd")
	//private LocalDate date;
	@Column(name = "date_transaction")
	private Date dateTransaction;

	@Column(name = "amount")
	private double amount;

	@ManyToOne
	@JoinColumn(name="user_id", nullable = false)
	private User user = new User();

	//private User crediteur;  // Test with One User, after Test with 2 users !! 

	
	public Transaction() {

	}
	

	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Date getDateTransaction() {
		return dateTransaction;
	}

	public void setDateTransaction(Date dateTransaction) {
		this.dateTransaction = dateTransaction;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	
}
