package code;

public class Driver {
	
	public static void main(String[] args) {
		
		Customer customer1 = new Customer("Sarah", "Smith", "319 grand ave", 24, 111223333);
		BankAccount account = new BankAccount(200, 15000, "Armchaps1", customer1);
		
		System.out.println(account.toString());
		account.transferS_to_C(1600);
		System.out.println(account.getChecking());
		System.out.println(account.getSavings());
		account.depositChecking(306.35);
		System.out.println(account.getChecking());
		
		
	}
}