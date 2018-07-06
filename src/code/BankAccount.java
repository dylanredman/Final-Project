package code;

public class BankAccount{

	private double checking;
	private double savings;
	private long accountNumber;
	private String password;
	private Customer customer;
	
	

	public BankAccount(double checking, double savings, String password, Customer customer) {
		this.checking = checking;
		this.savings = savings;
		this.accountNumber = (long)(Math.random() * 1000000000 *1000 + 1);
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

	public long getAccountNumber() {
		return accountNumber;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
	// ********* to string**************
	public String toString() {
		return "BankAccount " + customer.toString() +"\nchecking= " + checking + "\nsavings= " + savings + "\naccountNumber= " + accountNumber + "]";
	}
	
	
	
	
	
	//**********Deposits/Withdraws and Transfers****************
	public double depositChecking(double depositA) {
		if(depositA > 0) {
			return checking = checking + depositA;
		}
		else
			return checking;
	}
	
	public double withdrawChecking(double withdrawA) {
		if(withdrawA > 0) 
			return checking = checking - withdrawA;
		else
			return checking;
	}
	
	public double depositSavings(double depositB) {
		if(depositB > 0) {
			return savings = savings + depositB;
		}
		else
			return savings;
	}
	
	public double withdraw(double withdrawB) {
		if(withdrawB > 0) 
			return savings = savings - withdrawB;
		else
			return savings;
	}
	
	public void transferS_to_C(double amount){
		if(amount > 0 && amount <= this.savings) {
			this.savings = savings - amount;
			this.checking = checking + amount;
			System.out.println("Transfer Successful!");
		}
		else
			System.err.println("\nInsufficient Funds ! Transfer Denied.");
		
	}
	
	public void transferC_to_S(double amount){
		if(amount > 0 && amount <= this.checking) {
			this.savings = savings + amount;
			this.checking = checking - amount;
			System.out.println("Transfer Successful!");
		}
		else
			System.err.println("\nInsufficient Funds! Transfer Denied.");	
	}
	

	
	

	//***************Login Screen**********************
	public boolean logIn(double id, String password) {
		if(id == this.accountNumber || password.equals(this.password)) {
			return true;
		}
		else {
			return false;
		}
			
	}
	
	
	
	
	
	//*********** Sign Out***********
	

	
	
	
	//*********** Create account************
	




	
	
	
	
	
	
	
	//*********** 
	
	
	
	
	

}
