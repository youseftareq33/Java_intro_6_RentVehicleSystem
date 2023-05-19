package Classes;

import java.util.ArrayList;

   public class Customer implements Comparable {
	protected String name;
	protected String address;
	protected String plan;
	protected ArrayList<String> request;
	protected ArrayList<String> rented;
	/////////////////////////////////////////////////
	public Customer(String name, String address, String plan) {
		this.name = name;
		this.address = address;
		this.plan = plan;
		request = new ArrayList<String>();
		rented = new ArrayList<String>();
	}

	public Customer(String name) {
		this.name = name;
		request = new ArrayList<String>();
		rented = new ArrayList<String>();
	}
	/////////////////////////////////////////////////
	public String getName() {
		return name;
	}

	public String getPlan() {
		return plan;
	}
	/////////////////////////////////////////////////
	@Override
	public String toString() {
		return ("Customer"+" "+"Name: "+ name + " " + "|Address: " + address + " " + "|Plan: " + plan.toUpperCase() + "\nRented: " + rented + "  "
				+ "cart: " + request);
	}
	/////////////////////////////////////////////////
	@Override
	public int compareTo(Object op) {
		Customer c = (Customer) op;
		return (this.getName().compareTo(c.getName()));
	}

}
