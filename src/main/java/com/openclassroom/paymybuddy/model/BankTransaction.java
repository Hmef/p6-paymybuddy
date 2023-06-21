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

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="virementbancaire")
public class BankTransaction {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="virementbancaire_Id")
	private long virementBancaireId;
	
	@Column(name="numero")
	private int numero;
	
	@Column(name="dateVirement")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateVirement;
	
	@Column(name="amount")
	private double amount;
	
	// il faut ajouter le type : Virement ou Retrait 
	
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="user_id", nullable = false)
	private User user = new User();

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="bankaccount_id", nullable = false)
	private BankAccount bankaccount = new BankAccount();
	
	
	public BankTransaction() {
		
	}

	
	public BankTransaction(int numero, Date dateVirement, double amount, User user, BankAccount bankaccount) {
		super();
		this.numero = numero;
		this.dateVirement = dateVirement;
		this.amount = amount;
		this.user = user;
		this.bankaccount = bankaccount;
	}



	public long getVirementBancaireId() {
		return virementBancaireId;
	}

	public void setVirementBancaireId(long virementBancaireId) {
		this.virementBancaireId = virementBancaireId;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Date getDateVirement() {
		return dateVirement;
	}

	public void setDateVirement(Date dateVirement) {
		this.dateVirement = dateVirement;
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


	@Override
	public String toString() {
		return "VirementBancaire [virementBancaireId=" + virementBancaireId + ", numero=" + numero + ", dateVirement="
				+ dateVirement + ", amount=" + amount + ", user=" + user + "]";
	}
	
	
	
}
