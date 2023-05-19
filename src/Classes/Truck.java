package Classes;

public class Truck extends Vehicle{

	private double weight;
	private double load;
	private int numOfTruckAvailable;
	/////////////////////////////////////////////////
	public Truck(String name, String type, double weight, double load, int numOfTruckAvailable) {
		super(name, type);
		this.weight=weight;
		this.load=load;
		this.numOfTruckAvailable=numOfTruckAvailable;
	}
   /////////////////////////////////////////////////
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	/////////////////////////////////////////////////
	public double getLoad() {
		return load;
	}
	public void setLoad(double load) {
		this.load = load;
	}
	/////////////////////////////////////////////////
	public int getNumOfTruckAvailable() {
		return numOfTruckAvailable;
	}
	public void setNumOfTruckAvailable(int numOfTruckAvailable) {
		this.numOfTruckAvailable = numOfTruckAvailable;
	}
	//////////////////////////////////////////////////
	public void truckAvailable(boolean add) {

		if (add) {
			this.numOfTruckAvailable++;
		} else {
			this.numOfTruckAvailable--;
		}

	}
	
	//////////////////////////////////////////////////
	@Override
	public String toString() {
		return ("Truck"+" "+"Name: "+name+" "+"| Type: "+type+" | Weight: "+weight+" | Load: "+load+
				" | Number of truck Available: "+numOfTruckAvailable);
	}

}
