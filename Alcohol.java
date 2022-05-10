
//Creates subclass of Beverage for Alcohol orders
public class Alcohol extends Beverage {
	
	private final double WEEKENDP = 0.6; //Final attribute sets cost of alcohol order to $0.6
	private boolean weekendD; //Instance boolean variable checks to see if the drink is offered on the weekend
	
	//Creates a parameterized constructor
	public Alcohol(String bevName, SIZE bevSize, boolean weekendD) {
		super(bevName, bevSize, TYPE.ALCOHOL);
		this.weekendD = weekendD;
	}
	
	//Program generated toString method used to print the information of the price, name, weekend day, and size of the alcohol order
	@Override
	public String toString() {
		return "Alcohol [calcPrice()=" + calcPrice() + ", getBevName()=" + getBevName() + ", getWeekendD()="
				+ getWeekendD() + ", getSize()=" + getSize() + "]";
	}

	//Method used to get the price of the order
	@Override
	public double calcPrice() {
		double p = getBASEP(); //Price of the order starts at the base price
		if(getSize() == SIZE.MEDIUM) { //Adds the size up price to the price if the size is medium
			p += getSIZEUP();
		}
		if(getSize() == SIZE.LARGE) { //Adds the size up price times 2 to the price if the size price is large
			p += (getSIZEUP()*2);
		}
		if(weekendD == true) { //If the day the order is placed is on the weekend, the weekend price is added
			p += WEEKENDP;
		}
		return p; //returns the order price
	}
	
	//Creates a boolean equals method with new object
	@Override
	public boolean equals(Object bev) {
		boolean status = false; //Sets boolean variable to false
		//calls the equals method from beverage and checks if the current instances of name, type, size, and weekend drink
		//of the beverage matches the name, type, size, and weekend drink of an object beverage
		if(super.equals(bev) && this.weekendD == ((Alcohol)bev).weekendD) {
			status = true; //changes status to true if the variables equal each other
		}
		return status; //Returns status
	}

	//Gets the base price by calling the get base price method from Beverage
	public double getBasePrice() {
		return super.getBASEP();
	}

	//Gets the beverage name by calling the get beverage name method from Beverage
	public String getBevName() {
		return super.getBevName();
	}

	//Gets the current instance of the weekend drink
	public boolean getWeekendD() {
		return this.weekendD;
	}
}
