package com.example.Phase3;

import java.sql.Date;

public class Transaction {
	private String productName;
	private String userName;
	private Date transactionDate;
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Transaction(String productName, String userName, Date transactionDate) {
		super();
		this.productName = productName;
		this.userName = userName;
		this.transactionDate = transactionDate;
	}
	
}
