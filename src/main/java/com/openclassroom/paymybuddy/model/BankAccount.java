package com.openclassroom.paymybuddy.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "bankaccount")
public class BankAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bankaccount_id")
	private long bankaccountId;

	@Column(name = "numero")
	private int numero;

	@Column(name = "IBAN")
	private int IBAN;

	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="user_id", nullable = false)
	private User user;
	
	
	@OneToMany(mappedBy = "bankaccount")
	private List<BankTransaction> virementlist = new ArrayList<>();
	

	public BankAccount() {

	}

	
	// A modifier après le test 
	/*
	public BankAccount(long bankaccountId, int numero, int iBAN) {
		this.bankaccountId = bankaccountId;
		this.numero = numero;
		IBAN = iBAN;
	}
	
	*/
	

	public BankAccount(long bankaccountId, int numero, int iBAN, User user) {
		
		this.bankaccountId = bankaccountId;
		this.numero = numero;
		IBAN = iBAN;
		this.user = user;
	}
	


	public long getBankaccountId() {
		return bankaccountId;
	}


	public void setBankaccountId(long bankaccountId) {
		this.bankaccountId = bankaccountId;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getIBAN() {
		return IBAN;
	}

	public void setIBAN(int iBAN) {
		IBAN = iBAN;
	}

	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "BankAccount [bankaccountId=" + bankaccountId + ", numero=" + numero + ", IBAN=" + IBAN + ", user="
				+ user + ", virementlist=" + virementlist + "]";
	}

	

}
