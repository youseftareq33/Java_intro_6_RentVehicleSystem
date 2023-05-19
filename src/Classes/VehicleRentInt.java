package Classes;

import java.util.ArrayList;

public interface VehicleRentInt {
	
	public void addCustomer(String name, String address, String plan);
	
	public void addCar(String name,String type,int numOfCarAvailable,String rating,int numOfPassenger);
	public void addTruck(String name,String type,double weight,double load, int numOfTruckAvailable);
	public void addBus(String name, String type, int numOfBusAvailable, int capacity);
	
	public void setLimitedPlanLimit(int value);
	
	public String getAllCustomersInfo();
	public String getAllVehicleInfo();
	
	public boolean addTocart(String customerName,String vehicleName);
	public boolean removeFromcart(String customerName,String vehicleName);
	
	public String processRequests();
	public boolean returnVehicle(String customerName, String vehicleName);
	public ArrayList<String> searchVehicle(String name, String type,String rating);
	
}
