package code;



public class Customer {
	

	private String firstName;
	private String lastName;
	private String address;
	private int age;
	private int ssn;

	
	
	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	public String getFristName(){
		return this.firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName(){
		return this.lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	public String getaddress(){
		return this.address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getAge(){
		return this.age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}

	public Customer(String firstName, String lastName, String address, int age, int ssn) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.age = age;
		this.ssn = ssn;
	}


	public String toString() {
		return "Customer [\nfirstName= " + firstName + "\nlastName= " + lastName + "\naddress= " + address + "\nage= " + age
				+ "\nssn= " + ssn;
		}
}
