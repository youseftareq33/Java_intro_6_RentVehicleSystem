package Classes;

public class Bus extends Vehicle{
	private int numOfBusAvailable;
	private int capacity;
	///////////////////////////////////////////////
	public Bus(String name, String type, int numOfBusAvailable, int capacity) {
		super(name, type);
		this.numOfBusAvailable=numOfBusAvailable;
		this.capacity=capacity;
	}
	///////////////////////////////////////////////
	public int getNumOfBusAvailable() {
		return numOfBusAvailable;
	}
	public void setNumOfBusAvailable(int numOfBusAvailable) {
		this.numOfBusAvailable = numOfBusAvailable;
	}
	///////////////////////////////////////////////
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	//////////////////////////////////////////////////
	public void busAvailable(boolean add) {

		if (add) {
			this.numOfBusAvailable++;
		} else {
			this.numOfBusAvailable--;
		}

	}
	//////////////////////////////////////////////////
	@Override
	public String toString() {
		return ("Bus"+"   "+"Name: "+name+" "+"| Type: "+type+" | Number of bus available: "+numOfBusAvailable+
				" | Capacity: "+capacity);
	}

}
