package code;

import java.io.Serializable;


public class BankAccount implements Serializable{

	private double checking;
	private double savings;
	private int accountNumber;
	private String password;
	private Customer customer;
	
	

	public BankAccount(double checking, double savings, String password, int accountNumber, Customer customer) {
		this.checking = checking;
		this.savings = savings;
		this.accountNumber = accountNumber;
		this.password = password;
		this.customer = customer;
	}
	
	
	
	
	

	//*************Getters and setters***************
	public double getChecking() {
		return checking;
	}

	public void setChecking(double checking) {
		this.checking = checking;
	}

	public double getSavings() {
		return savings;
	}

	public void setSavings(double savings) {
		this.savings = savings;
	}

	public int getAccountNumber() {
		return accountNumber;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}



	// ********* to string**************
	public String toString() {
		return customer.toString() +"," + checking + "," + savings + "," + password + "," + accountNumber;
	}


}
