
public abstract class Beverage {
	
	//Sets up instance variables for the order's name, type, and size
	private String bevName;
	private TYPE bevType;
	private SIZE bevSize;
	private final double BASEP = 2.0; //constant attribute makes the price of adding a new beverage start at $2
	private final double SIZEUP = 1; //constant attribute makes the price to increase size of beverage is $1

	//Parameterized constructor to create a new beverage object
	public Beverage(String bevName, SIZE bevSize, TYPE bevType) {
		this.bevName = bevName;
		this.bevSize = bevSize;
		this.bevType = bevType;
	}

	//abstract method calculates and returns the beverage price 
	public abstract double calcPrice();

	//Program generated toString() method for printing the information of the Beverage including the name and size
	@Override
	public String toString() {
		return "Beverage [bevName=" + bevName + ", bevType=" + bevType + ", bevSize=" + bevSize + "]";
	}

	//Creates a boolean equals method with new object
	@Override
	public boolean equals(Object bev) {
		boolean status = false; //Sets boolean variable to false
		//checks if the current instances of name, type, and size of a beverage matches the name, type, and size of an object beverage
		if (this.bevName.equals(((Beverage)bev).getBevName()) && this.bevType == ((Beverage)bev).getType() && 
		this.bevSize == ((Beverage)bev).getSize()) {
			status = true; //sets status to true if they all equal each other
		}
		return status; //returns the status variable
	}

	//gets the current instance of the beverage type
	public TYPE getType() {
		return this.bevType;
	}
	
	//sets the current instance of the beverage type to the TYPE type parameter
	public void setType(TYPE type) {
		this.bevType = type;
	}

	//gets the current instance of the beverage size
	public SIZE getSize() {
		return this.bevSize;
	}
	
	//sets the current instance of the beverage size to the SIZE size parameter
	public void setSize(SIZE size) {
		this.bevSize = size;
	}

	//gets the current instance of the beverage name
	public String getBevName() {
		return this.bevName;
	}
	
	//sets the current instance of the beverage name to the String name parameter
	public void setBevName(String name) {
		this.bevName = name;
	}

	//returns the Base Price
	public double getBASEP() {
		return BASEP;
	}
	
	//returns the size up price
	public double getSIZEUP() {
		return SIZEUP;
	}
}
