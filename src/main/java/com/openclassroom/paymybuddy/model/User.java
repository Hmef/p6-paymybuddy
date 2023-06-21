package com.openclassroom.paymybuddy.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.NonNull;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_id", nullable = false)
	private long userId;
	
	@Column(name="firstname")
	@NonNull
	private String firstname;
	
	@Column(name="lastname", nullable = false)
	private String lastname;
	
	@Column(name="birthdate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthdate;
	
	@Column(name="email") 
	@NonNull
	private String email;
	
	@Column(name="password")
	@NonNull
	private String password;

	@Column(name="phone")
	private String phone;
	
	@Column(name="address")
	private String address;
	
	@Column(name="solde")
	@NonNull
	private Double solde;
	
	private int active = 1;
	
	/*
	
	// Bidirectionnel : User a une liste de connections & 
   // Owner Side 
	 
	@ManyToMany(fetch = FetchType.LAZY,
			cascade = { 
					CascadeType.PERSIST, 
					CascadeType.MERGE 
					}	
			)
			@JoinTable(
					name = "user_user",
					joinColumns = @JoinColumn(name = "user_id"), 	
					inverseJoinColumns = @JoinColumn(name = "user_id")
			)
	private List<User> userlist = new ArrayList<>();
	
	*/
	@OneToMany(
			cascade = CascadeType.ALL, mappedBy = "user"
			)
	private List<BankTransaction> virementlist = new ArrayList<>();
	
	@OneToMany(
			cascade = CascadeType.ALL,
			mappedBy = "user"
			)
	private List<Transaction> transactionlist= new ArrayList<>();
	
	@OneToMany(
			cascade = CascadeType.ALL,
			mappedBy = "user"
			)  
	private List<BankAccount> bankaccountlist = new ArrayList<>();
	
	
	public User() {
		
	}
	
	
	public User(long userId, @NonNull String firstname, String lastname, Date birthdate, @NonNull String email,
			@NonNull String password, String phone, String address, @NonNull Double solde, int active,
			List<BankAccount> bankaccountlist) {
		
		this.userId = userId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthdate = birthdate;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.address = address;
		this.solde = solde;
		this.active = 1;
		this.bankaccountlist = bankaccountlist;
	}



	/*
	public User(long userId, String firstname, String lastname, Date birthdate, String email, String password,
			String phone, String address, Double solde, int active) {
		
		this.userId = userId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthdate = birthdate;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.address = address;
		this.solde = solde;
		this.active = 1;
	}

*/


	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getSolde() {
		return solde;
	}

	public void setSolde(Double solde) {
		this.solde = solde;
	}

	
	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	/*
	public List<User> getUserlist() {
		return userlist;
	}

	public void setUserlist(List<User> userlist) {
		this.userlist = userlist;
	}

	 */
	public List<BankTransaction> getVirementlist() {
		return virementlist;
	}

	public void setVirementlist(List<BankTransaction> virementlist) {
		this.virementlist = virementlist;
	}

	public List<Transaction> getTransactionlist() {
		return transactionlist;
	}

	public void setTransactionlist(List<Transaction> transactionlist) {
		this.transactionlist = transactionlist;
	}

	public List<BankAccount> getBankaccountlist() {
		return bankaccountlist;
	}

	public void setBankaccountlist(List<BankAccount> bankaccountlist) {
		this.bankaccountlist = bankaccountlist;
	}

	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstname=" + firstname + ", lastname=" + lastname + ", birthdate="
				+ birthdate + ", email=" + email + ", password=" + password + ", phone=" + phone + ", address="
				+ address + ", solde=" + solde + ", virementlist=" + virementlist + ", transactionlist="
				+ transactionlist + ", bankaccountlist=" + bankaccountlist + "]";
	}

	
}
