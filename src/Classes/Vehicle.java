package Classes;

public class Vehicle implements Comparable{
	
	protected String name;
	protected String type;
	///////////////////////////////////////////////////
	public Vehicle() {
		this.name=" ";
		this.type=" ";
	}
	
	public Vehicle(String name, String type) {
		this.name=name;
		this.type=type;
	}
	/////////////////////////////////////////////////
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	////////////////////////////////////////////////
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	//////////////////////////////////////////////////
	@Override
	public String toString() {
		return "Vehicle name:" + name + " type:" + type;
	}

	////////////////////////////////////////////////
	@Override
	public int compareTo(Object op) {

		Vehicle v = (Vehicle) op;

		return (this.getName().compareTo(v.getName()));
	}

	
}
