import java.util.ArrayList;
import java.util.Random;

//Order class implements the orderInterfaces and the computer generated interface Comparable with order parameters
public class Order implements OrderInterface, Comparable<Order> {
	
	//Declares instance variables of the order number, time, day, and customer information
	private int number;
	private int time;
	private DAY orderD;
	private Customer customer;
	private ArrayList <Beverage> beverageList = new ArrayList<Beverage>(); //Declares an arrayList for keeping beverages
	
	//Sets parameterized constructor
	public Order(int time, DAY orderD, Customer customer) {
		this.number = randomN();
		this.time = time;
		this.orderD = orderD;
		this.customer = customer;
		this.beverageList = new ArrayList<Beverage>();
	}
	//Creates random number between 10000 and 90000
	public int randomN() {
		int min = 10000; 
		int max = 90000;
		Random rand = new Random(min);
		int randInt = rand.nextInt(max - min)+1;
		return randInt;
	}
	
	//Program generated toString method used to print the information of the beverage arrayList, number, customer name and age,
	//total price, time, and day of the order
	@Override
	public String toString() {
		return "Order [beverageList=" + beverageList + ", getOrderNo()=" + getOrderNo() + ", getCustomer()="
				+ getCustomer() + ", calcOrderTotal()=" + calcOrderTotal() + ", getOrderTime()=" + getOrderTime()
				+ ", getOrderDay()=" + getOrderDay() + "]";
	}
	
	//Creates a method that compares the order number to another order number
	@Override
	public int compareTo(Order o) {
		int rtn;
		if(this.number > o.getOrderNo()) {
			rtn = 1;
		}
		else if(this.number < o.getOrderNo()) {
			rtn = -1;
		}
		else {
			rtn = 0;
		}
		return rtn;
	}
	
	//Returns the beverage listed in the itemNo of the order
	@Override
	public Beverage getBeverage(int itemNo) {
		return beverageList.get(itemNo);
	}
	
	//Gets the current instance of order number
	public int getOrderNo() {
		return this.number;
	}
	
	//Gets the current instance of the customer variables
	public Customer getCustomer() {
		return new Customer(customer);
	}
	
	//Get total items in the beverage list
	public int getTotalItems() {
		return beverageList.size();
	}

	//Boolean method checks to see if the order day is a weekend day (Saturday or Sunday)
	@Override
	public boolean isWeekend() {
		if(orderD == DAY.SATURDAY || orderD == DAY.SUNDAY) {
			return true;
		}
		else {
			return false;
		}
	}

	//adds a new coffee beverage to the beverage list
	@Override
	public void addNewBeverage(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
		Coffee c = new Coffee(bevName, size, extraShot, extraSyrup); //Creates a new Coffee object with the coffee's name, size, 
		//if the coffee has an extra shot, and if the coffee has extra syrup
		beverageList.add(c); //adds the new coffee object to the beverage list
	}

	//adds a new alcohol beverage to the beverage list
	@Override
	public void addNewBeverage(String bevName, SIZE size) {
		Alcohol a = new Alcohol(bevName, size, isWeekend()); //Creates a new Alcohol object with the Alcohol's name, size, and
		//if it's a weekend drink
		beverageList.add(a); //adds the new alcohol object to the beverage list
	}

	//adds a new coffee beverage to the beverage list
	@Override
	public void addNewBeverage(String bevName, SIZE size, int numOfFruits, boolean addPRotien) {
		Smoothie s = new Smoothie(bevName, size, numOfFruits, addPRotien);  //Creates a new Smoothie object with the Smoothie's name, 
		//size, number of fruits, and if protein powder is added
		beverageList.add(s); //adds the new smoothie object to the beverage list
	}

	//Calculates the total amount for this order
	@Override
	public double calcOrderTotal() {
		double p = 0; //Declares the price of the order starting at 0
		//for loop that checks each order in the beverage list until the number of time it loops is the same as the list's size
		for (int i = 0; i < beverageList.size(); i++) { 
			p += beverageList.get(i).calcPrice(); //Adds the price of the order based on what beverage it is
		}
		return p; //Returns the price of all the beverages in the order 
	}
	
	//Finds the number of beverages of same type in an order
	@Override
	public int findNumOfBeveType(TYPE type) {
		int num = 0; //Declares a counting variable to 0
		//for loop that checks each beverage in the order until the number of times it loops is the same as the list's size
		for (int i = 0; i < beverageList.size(); i++) {
			//Checks to see if a beverage in the order is the same type as the desired type
			if (beverageList.get(i).getType() == type) {
				num++; //Increments number of times the beverage type is found 
			}
		}
		return num; //returns the number of times the desired beverage type in this order was found
	}

	//Gets the current instance of the order's time
	public int getOrderTime() {
		return this.time;
	}

	//Gets the current instance of the order's day
	public DAY getOrderDay() {
		return this.orderD;
	}
}
