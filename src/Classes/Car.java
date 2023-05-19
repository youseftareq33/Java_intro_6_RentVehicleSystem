package Classes;

public class Car extends Vehicle{
	private int numOfCarAvailable;
	private String rating;
	private int numOfPassenger;
	
	public Car(String name, String type, int numOfCarAvailable, String rating, int numOfPassenger) {
		super(name, type);
		this.numOfCarAvailable=numOfCarAvailable;
		this.rating=rating;
		this.numOfPassenger=numOfPassenger;
	}
	//////////////////////////////////////////////////////////////////
	public int getNumOfCarAvailable() {
		return numOfCarAvailable;
	}

	public void setNumOfCarAvailable(int numOfCarAvailable) {
		this.numOfCarAvailable = numOfCarAvailable;
	}
	//////////////////////////////////////////////////////////////////
	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}
	//////////////////////////////////////////////////////////////////
	public int getNumOfPassenger() {
		return numOfPassenger;
	}

	public void setNumOfPassenger(int numOfPassenger) {
		this.numOfPassenger = numOfPassenger;
	}
	//////////////////////////////////////////////////////////////////
	
	
	public void carAvailable(boolean add) {

		if (add) {
			this.numOfCarAvailable++;
		} else {
			this.numOfCarAvailable--;
		}

	}
	
	public void passengerAvailable(boolean add) {

		if (add) {
			this.numOfPassenger++;
		} else {
			this.numOfPassenger--;
		}

	}
	//////////////////////////////////////////////////////////////////
	@Override
	public String toString() {
		return ("Car"+"   "+"Name: "+name+"  "+"| Type: "+type+" "+"|number Of Car Available: "+numOfCarAvailable+
				" "+"|Rating: "+rating+" "+"|number of passenger: "+numOfPassenger);
	}
	
	
}
