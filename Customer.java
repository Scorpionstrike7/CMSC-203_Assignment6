
public class Customer {
	
	//Declares instance variables of the customer's name and age
	private String customerName;
	private int customerAge;
	
	//Creates a parameterized constructor
	public Customer(String customerName, int customerAge) {
		this.setName(customerName);
		this.setAge(customerAge);
	}

	//Creates a copy constructor
	public Customer(Customer c) {
		this.customerName = c.customerName;
		this.customerAge = c.customerAge;
	}

	//Program generated toString method used to print the information of the customer's name and age 
	@Override
	public String toString() {
		return "Customer [customerName=" + customerName + ", customerAge=" + customerAge + "]";
	}

	//sets the current instance of the customer name to the String name parameter
	public void setName(String customerName) {
		this.customerName = customerName;
	}

	//gets the current instance of the customer name
	public String getName() {
		return this.customerName;
	}

	//gets the current instance of the customer age
	public int getAge() {
		return this.customerAge;
	}

	//sets the current instance of the customer age to the age parameter
	public void setAge(int customerAge) {
		this.customerAge = customerAge;
	}
}
