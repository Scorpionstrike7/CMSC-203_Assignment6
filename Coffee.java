
//Creates subclass of Beverage for Coffee orders
public class Coffee extends Beverage {
	
	private final double EXTRAC = 0.5; //Constant attributes increases the coffee price by 0.5 if there's an extra shot of coffee
	private final double EXTRAS = 0.5; //Constant attributes increases the coffee price by 0.5 if there's extra syrup
	private boolean extraShot; //Used for if there is an extra shot of coffee
	private boolean extraSyrup; //Used for if there is extra syrup
	
	//A parameterized constructor
	public Coffee(String bevName, SIZE bevSize, boolean extraShot, boolean extraSyrup) {
		super(bevName, bevSize, TYPE.COFFEE);
		this.extraShot = extraShot;
		this.extraSyrup = extraSyrup;
	}
	
	//Program generated toString method used to print the information of the extra shot of coffee, extra syrup, price, size, and
	//name of the coffee order
	@Override
	public String toString() {
		return "Coffee [getExtraShot()=" + getExtraShot() + ", getExtraSyrup()=" + getExtraSyrup()
				+ ", calcPrice()=" + calcPrice() + ", getSize()=" + getSize() + ", getBevName()=" + getBevName() + "]";
	}

	//Creates a boolean equals method with new object
	@Override
	public boolean equals(Object bev) {
		boolean status = false; //Sets boolean variable to false
		//calls the equals method from beverage and checks if the current instances of name, type, size, extra shot of coffee, and 
		//extra syrup of a beverage matches the name, type, size, extra shot of coffee, and extra syrup of an object beverage
		if(super.equals(bev) && this.extraShot == ((Coffee)bev).extraShot && this.extraSyrup == ((Coffee)bev).extraSyrup) {
			status = true; //sets status to true if they all equal each other
		}
		return status; //Returns status
	}
	
	//Gets the current instance of extraShot 
	public boolean getExtraShot() {
		return this.extraShot;
	}

	//Gets the current instance of extra syrup 
	public boolean getExtraSyrup() {
		return this.extraSyrup;
	}

	//Gets the get base price getter from Beverage
	public double getBasePrice() {
		return super.getBASEP();
	}

	//Create method that calculates price based on Coffee variables
	@Override
	public double calcPrice() {
		double p = getBasePrice(); //Sets up the price holding variable, starting at the base price
		if(getSize() == SIZE.MEDIUM) { //Adds the size up price to the price if the size is medium
			p += getSIZEUP();
		}
		if(getSize() == SIZE.LARGE) { //Adds the size up price times 2 to the price if the size price is large
			p += (getSIZEUP()*2);
		}
		if(extraShot){ //If there is an extra shot, add price of extra shot to price 
			p += EXTRAC;
		}
		if(extraSyrup){ //If there is extra syrup, add price of extra syrup to price
			p += EXTRAS;
		}
		return p; //Return price of coffee order
	}
}
