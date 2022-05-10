
//Creates subclass of Beverage for Smoothie orders
public class Smoothie extends Beverage {

	//Declares instance variables for the number of fruits and if protien is added
	private int numOfFruits = 0;
	private boolean addProtien;
	private final double FRUITCOST = 0.5; //Final attribute makes it so that each fruit added costs $0.5
	private final double PROTIENCOST = 1.5; //Final attribute adds $1.5 to the cost if the order protein powder
	
	//Parameterized constructor
	public Smoothie(String bevName, SIZE bevSize, int numOfFruits, boolean addProtien) {
		super(bevName, bevSize, TYPE.SMOOTHIE);
		this.numOfFruits = numOfFruits;
		this.addProtien = addProtien;
	}

	//Computer generated toString method used to print the information of the price, name, number of fruits, if protein powder is added,
	//and the size of the smoothie order
	@Override
	public String toString() {
		return "Smoothie [calcPrice()=" + calcPrice() + ", getBevName()=" + getBevName() + ", getNumOfFruits()="
				+ getNumOfFruits() + ", getAddProtien()=" + getAddProtein() + ", getSize()=" + getSize() + "]";
	}

	//Calculates the price of the smoothie order
	@Override
	public double calcPrice() {
		double p = getBASEP(); //Declares price variable starting at base price
		if(getSize() == SIZE.MEDIUM) { //Adds the size up price to the price if the size is medium
			p += getSIZEUP();
		}
		if(getSize() == SIZE.LARGE) { //Adds the size up price times 2 to the price if the size price is large
			p += (getSIZEUP()*2);
		}
		if(getAddProtein() == true) { //If protein powder is added, add cost of protein powder to order
			p += PROTIENCOST;
		}
		p += this.numOfFruits*FRUITCOST; //Muliply the number of fruits by the cost of adding fruits and add to the order price
		
		return p; //Return the order price
	}
	
	//Creates a boolean equals method with new object
	@Override
	public boolean equals(Object bev) {
		boolean status = false; //Sets boolean variable to false
		//calls the equals method from beverage and checks if the current instances of name, type, size, and protein powder 
		//of a beverage matches the name, type, size, and protein powder of an object beverage
		if(super.equals(bev) && addProtien == ((Smoothie)bev).addProtien) {
			status = true; //changes status to true if the variables equal each other
		}
		return status; //return status
	}

	//Gets the base price by calling the get base price method from Beverage
	public double getBasePrice() {
		return super.getBASEP();
	}
	
	//Gets the beverage name by calling the get beverage name method from Beverage
	public String getBevName() {
		return super.getBevName();
	}

	//Gets the current instance of the number of fruits in the smoothie order
	public int getNumOfFruits() {
		return this.numOfFruits;
	}
	
	//Gets the current instance of protein powder in the order
	public boolean getAddProtein() {
		return this.addProtien;
	}
}