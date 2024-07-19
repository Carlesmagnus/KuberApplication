package com.kubedemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "accounts")
public class KubeEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_holder_name", nullable = false)
    private String accountHolderName;

    @Column(nullable = false)
    private double balance;
    
    public KubeEntity() {
    	
    }
    
    public KubeEntity(Long id, String accountHolderName, double balance) {
    	this.id=id;
    	this.accountHolderName=accountHolderName;
    	this.balance=balance;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
    
    
}
