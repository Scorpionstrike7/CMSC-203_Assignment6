import java.util.ArrayList;

/**
 * Class: CMSC203 
 *  Program: Assignment #6
 *  Instructor: Professor Grinberg
 * Description: This program offers 3 types of beverages and 3 different sizes. The program creates and processes orders of 
 * the three different types of beverages, provides information on all the orders, finds the total amount on a specific order, 
 * finds the monthly total number of orders, and gets the monthly sale report
 * Due: MM/DD/YYYY (<05/02/2022>)
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Bradley Hughes
*/

//Class implements the BevShopInterface
public class BevShop implements BevShopInterfce {
	
	private int numOfDrinks; //Declares instance variable for the number of drinks
	private final int maxOrder = MAX_ORDER_FOR_ALCOHOL; //Constant attribute for most alcoholic drinks ordered to 5
	private ArrayList<Order> orderList = new ArrayList<Order>(); //Declares new arraylist for keeping track of orders
	private final int minAge = MIN_AGE_FOR_ALCOHOL; //Constant attribute for minimum drinking age to 21
	private int time; //Declares instance variable for the order time
	private DAY orderDay; //Declares DAY variable for the order day
	private Customer customer; //Declares Customer variable for the customer
	private Order currentOrder; //Declares Order variable for the current order

	//Creates a list of beverages within an order
	BevShop() {
		ArrayList<Order> bevOrderList = new ArrayList<Order>(orderList);
		numOfDrinks = 0; //Sets the number of drinks ordered to 0
	}
	
	//Program generated toString() method for printing the information of the orderList
	@Override
	public String toString() {
		String s = ""; //Declares the instance variable that contains the information
		//for loop that loops until the number of times it repeats matches the size of the order list
		for (int i = 0; i < orderList.size(); i++) {
			//adds the information for each order to the string variable.  
		s += "BevShop [orderList=" + orderList + ", time=" + time + ", orderDay=" + orderDay + ", customer="
				+ customer + ", currentOrder=" + currentOrder + ", eligibleForMore()=" + eligibleForMore()
				+ ", totalNumOfMonthlyOrders()=" + totalNumOfMonthlyOrders() + ", getCurrentOrder()=" + getCurrentOrder()
				+ ", getNumOfAlcoholDrink()=" + getNumOfAlcoholDrink() + "] /n";
		}
		s += "totalMonthlySale()=" + totalMonthlySale(); //adds the total monthly sales to end of the String
		return s; //returns the string variable
	}

	//Checks if the time parameter is in between 8 and 23
	@Override
	public boolean validTime(int time) {
		if(time >= MIN_TIME && time <= MAX_TIME) {
			return true;
		}
		else {
			return false;
		}
	}

	//Checks if the number of alcohol beverages for the current order has reached the maximum order number
	@Override
	public boolean eligibleForMore() {
		if(getNumOfAlcoholDrink() == maxOrder) {
			return false;
		}
		else {
			return true;
		}
	}

	//Checks to see if the parameter age is above the minimum age required for ordering an alcohol drink
	@Override
	public boolean validAge(int age) {
		if(age > minAge) {
			return true;
		}
		else {
			return false;
		}
	}
	//locates an order based on the order number
	@Override
	public int findOrder(int orderNo) {
		int index = 0; //Sets index variable to 0
		//for loop that loops until the number of times it repeats matches the size of the order list
		for (int i = 0; i < orderList.size(); i++) {
			index = i; //Sets index to i
			if (orderList.get(i).getOrderNo() == orderNo) { //if orderNo of beverage equals the given order number
				break; //break out of the for loop if the order number is found
			}
			else {
				index = -1; //Set index to -1 if the order number is not found
			}
		}
		return index;  //return the index
	}
	
	//Locates the order number and finds the price of the order 
	@Override
	public double totalOrderPrice(int orderNo) {	
		double totalP = 0; //Sets the price variable to 0
		//for loop that loops until the number of times it repeats matches the size of the order list
		for (int i = 0; i < orderList.size(); i++) {
			if(orderList.get(i).getOrderNo() == orderNo) { //if orderNo of beverage equals the given order number 
				totalP += getCurrentOrder().calcOrderTotal(); //adds the calculated total amount for this order
				break; //break out of the for loop if the order number is found
			}
		}
		return totalP; //Returns the total order price
	}

	//Calculates the total sale of all the orders for this beverage shop
	
	@Override
	public double totalMonthlySale() {
		double totS = 0; //Sets the price variable to 0
		//for loop that loops until the number of times it repeats matches the size of the order list
		for (int i = 0; i < orderList.size(); i++) {
			totS += orderList.get(i).calcOrderTotal(); //adds the calculated total amount for this order
		}
		return totS; //Returns the total monthly sale
	}

	//sorts the orders within this bevShop using the Selection sort algorithm
	@Override
	public void sortOrders() {
		//for loop that loops until the number of times it repeats is 1 lower than the size of the order list
		for (int i = 0; i < orderList.size()-1; i++) {
			int min = i; //Declares the min value in the order the same as the order number
			//Second for loop that loops a variable until the number of times it repeats matches the size of the order list
			for(int s = i+1; s < orderList.size(); s++) {
				if (orderList.get(s).compareTo(orderList.get(min)) == -1) { //Checks to see if the beverage is less than the min value 
					min = s; //Sets the min value to the beverage order number that is smaller than the min
				}
			}
			//The min value and order number switch places in the order 
			orderList.set(min, orderList.get(i));
			orderList.set(i, orderList.get(min));
		}
	}

	//Gets the minimum age
	public int getMinAgeForAlcohol() {
		return minAge;
	}

	//Gets the current order
	public Order getCurrentOrder() {
		return this.currentOrder;
	}

	//Starts a new order
	@Override
	public void startNewOrder(int time, DAY day, String customerName, int customerAge) {
		currentOrder = new Order(time, day, new Customer(customerName, customerAge)); //Sets the current order as a new Order object
		orderList.add(currentOrder); //Adds the current order to the order array list
		numOfDrinks = 0; //Resets the number of drinks to 0
	}

	//Processes the Coffee order for the current order
	@Override
	public void processCoffeeOrder(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
		 //calls the addNewBeverage for Coffee from order to current order
		currentOrder.addNewBeverage(bevName, size, extraShot, extraSyrup);
		orderList.set(orderList.size()-1, currentOrder); //Puts the new coffee order 1 less than the order list size
	}
	
	//Processes the Alcohol order for the current order
	@Override
	public void processAlcoholOrder(String bevName, SIZE size) {
		currentOrder.addNewBeverage(bevName, size); //calls the addNewBeverage for Alcohol from order to current order
		orderList.set(orderList.size()-1, currentOrder);  //Puts the new alcohol order 1 less than the order list size
		numOfDrinks++; //Increments the number of drinks
	}
	
	//Processes the Smoothie order for the current order
	@Override
	public void processSmoothieOrder(String bevName, SIZE size, int numOfFruits, boolean addProtien) {
		//calls the addNewBeverage for Smoothie from order to current order
		currentOrder.addNewBeverage(bevName, size, numOfFruits, addProtien); 
		orderList.set(orderList.size()-1, currentOrder); //Puts the new Smoothie order 1 less than the order list size
	}

	//returns the current instance of the number of drinks
	public int getNumOfAlcoholDrink() {
		return this.numOfDrinks;
	}

	//Checks to see if the number of fruit is at the max
	public boolean isMaxFruit(int numOfFruits) {
		//Checks to see if the number of fruits equals the maximum number of fruit (which for some reason is 6 not 5)
		if(numOfFruits == MAX_FRUIT+1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//Gets the max order number of Alcohol that can be ordered
	public int getMaxOrderForAlcohol() {
		return maxOrder;
	}

	//Gets the order in the list of orders at the index 
	@Override
	public Order getOrderAtIndex(int index) {
		int indexO = 0; //Declares comparing index to 0
		//for loop that loops until the number of times it repeats matches the size of the order list
		for (int i = 0; i < orderList.size(); i++) {
			indexO = i; //Set comparing index to order number 
			if (indexO == index) { //Checks to see if the comparing index is the same as the index
				return orderList.get(index); //returns order of the index
			}
		}
		return null; //returns null if the index is not found
	}

	//gets the total number of monthly orders 
	public Object totalNumOfMonthlyOrders() {
		int num = 0; //Declares the counting variable as 0
		//for loop that loops until the number of times it repeats matches the size of the order list
		for (int i = 0; i < orderList.size(); i++) {
			num++; //Increments the counting variable
		}
		return num; //returns the counting variable
	}
}