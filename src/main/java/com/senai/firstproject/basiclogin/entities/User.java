package com.senai.firstproject.basiclogin.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String firstname;
	
	@Column(nullable = false)
	private String lastname;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false)
	private String numberphone;
	
	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private boolean agreedToTerms;
	
	
	public User(Long id, String firstname, String lastname, String email, String numberphone, String password, boolean agreedToTerms) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.numberphone = numberphone;
		this.password = password;
		this.agreedToTerms = agreedToTerms;
	}
	
	public User() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumberphone() {
		return numberphone;
	}

	public void setNumberphone(String numberphone) {
		this.numberphone = numberphone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAgreedToTerms() {
		return agreedToTerms;
	}

	public void setAgreedToTerms(boolean agreedToTerms) {
		this.agreedToTerms = agreedToTerms;
	}

	@Override
	public int hashCode() {
		return Objects.hash(agreedToTerms, email, firstname, id, lastname, numberphone, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return agreedToTerms == other.agreedToTerms && Objects.equals(email, other.email)
				&& Objects.equals(firstname, other.firstname) && Objects.equals(id, other.id)
				&& Objects.equals(lastname, other.lastname) && Objects.equals(numberphone, other.numberphone)
				&& Objects.equals(password, other.password);
	}

	
	
	
}
