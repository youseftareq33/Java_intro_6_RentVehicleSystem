package Classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RentVehicleSystem implements VehicleRentInt{
	private int value;
	protected List<Customer> customer_data;
	protected List<Vehicle> vehicle_data;
	
/////////////////////////////////////////////////
	public RentVehicleSystem() {
		this.value = 2;
		this.customer_data = new ArrayList<Customer>();
		this.vehicle_data = new ArrayList<Vehicle>();
	}
	
/////////////////////////////////////////////////
	@Override
	public void addCustomer(String name, String address, String plan) {
		customer_data.add(new Customer(name, address, plan));
	}
	
/////////////////////////////////////////////////
	@Override
	public void addCar(String name,String type,int numOfCarAvailable,
			String rating,int numOfPassenger) {
		vehicle_data.add(new Car(name,type,numOfCarAvailable,rating,numOfPassenger));
		
	}
/////////////////////////////////////////////////
	@Override
	public void addTruck(String name, String type,double weight,
			double load, int numOfTruckAvailable) {
		vehicle_data.add(new Truck(name, type, weight, load, numOfTruckAvailable));
	}
/////////////////////////////////////////////////
	@Override
	public void addBus(String name, String type, int numOfBusAvailable, int capacity) {
		vehicle_data.add(new Bus(name, type, numOfBusAvailable, capacity));
	}
/////////////////////////////////////////////////
	@Override
	public void setLimitedPlanLimit(int value) {
		this.value=value;
	}
/////////////////////////////////////////////////
	@Override
	public String getAllCustomersInfo() {
		String customerInfo = "Customers Information: \n";
		Collections.sort(customer_data);
		for (int i = 0; i < customer_data.size(); i++) {
			customerInfo += customer_data.get(i).toString() + "\n";
		}
		return customerInfo;
	}
/////////////////////////////////////////////////
	@Override
	public String getAllVehicleInfo() {
		String vehicleInfo = "Vehicle Information:  \n";
		Collections.sort(vehicle_data);
		for (int i = 0; i < vehicle_data.size(); i++) {
			vehicleInfo += vehicle_data.get(i).toString() + "\n";
		}

		return vehicleInfo;
	}
/////////////////////////////////////////////////
	@Override
	public boolean addTocart(String customerName, String vehicle_name) {
		int index = -1;
		for (int i = 0; i < customer_data.size(); i++) {
			if (customer_data.get(i).getName() == customerName) {
				index = i;
			}
		}

		if (index == -1) {
			return false;
		}

		for (int i = 0; i < customer_data.get(index).request.size(); i++) {
			if (customer_data.get(index).request.get(i) == vehicle_name) {
				return false;
			}
		}
		customer_data.get(index).request.add(vehicle_name);
		return true;
	}
/////////////////////////////////////////////////
	@Override
	public boolean removeFromcart(String customerName, String vehicleName) {
		for (int i = 0; i < customer_data.size(); i++) {
			if (customer_data.get(i).getName() == customerName) {
				customer_data.get(i).request.remove(vehicleName);
				return true;
			}
		}
		return false;
	}
/////////////////////////////////////////////////
	@Override
	public String processRequests() {

		String processedRequests = "";
		
		Collections.sort(customer_data);
		
		for (int i = 0; i < customer_data.size(); i++) {
			
			Customer c = customer_data.get(i);
			
			int size = c.request.size();
			
			int x = 0;
			if (c.getPlan() == "LIMITED") {
				
			for (int j = 0; j < size; j++) {
			   for (int k = 0; k < vehicle_data.size(); k++) {
				   Car v_c = (Car) vehicle_data.get(k);
				   
					String vehicle_name = v_c.getName();	
					System.out.println(c.request.size());
					if (vehicle_name.equals(c.request.get(x))) {
						
							if (v_c.getNumOfCarAvailable() > 0) {
								
								if (c.rented.size() < value) {
									c.request.remove(x);
									c.rented.add(vehicle_name);
									v_c.carAvailable(false);
									processedRequests += "Sending " + 
									vehicle_name + " to " + c.getName() + "\n";
									break;
								}
							} 
							else {
								x++;
							}

						}
					}

				}
			
			for (int j = 0; j < size; j++) {
				   for (int k = 0; k < vehicle_data.size(); k++) {
					   Truck v_t= (Truck) vehicle_data.get(k);
						String vehicle_name = v_t.getName();	///
						System.out.println(c.request.size());
						if (vehicle_name.equals(c.request.get(x))) {
							
								if (v_t.getNumOfTruckAvailable() > 0) {
									
									if (c.rented.size() < value) {
										c.request.remove(x);
										c.rented.add(vehicle_name);
										v_t.truckAvailable(false);
										processedRequests += "Sending " + 
										vehicle_name + " to " + c.getName() + "\n";
										break;
									}
								} 
								else {
									x++;
								}

							}
						}

					}
			
			for (int j = 0; j < size; j++) {
				   for (int k = 0; k < vehicle_data.size(); k++) {
					   Bus v_b= (Bus) vehicle_data.get(k);
						String vehicle_name = v_b.getName();	///
						System.out.println(c.request.size());
						if (vehicle_name.equals(c.request.get(x))) {
							
								if (v_b.getNumOfBusAvailable() > 0) {
									
									if (c.rented.size() < value) {
										c.request.remove(x);
										c.rented.add(vehicle_name);
										v_b.busAvailable(false);
										processedRequests += "Sending " + 
										vehicle_name + " to " + c.getName() + "\n";
										break;
									}
								} 
								else {
									x++;
								}

							}
						}

					}
			}
			
			
			else if (c.getPlan() == "UNLIMITED") { 
				
					for (int j = 0; j < size; j++) {

					
					for (int k = 0; k < vehicle_data.size(); k++) {

						 Car v_c = (Car) vehicle_data.get(k);

						String vehicleName = v_c.getName();
						if (vehicleName.equals(c.request.get(x))) {
							if (v_c.getNumOfCarAvailable() > 0) {

						c.request.remove(x);

							c.rented.add(vehicleName);

								v_c.carAvailable(false);

								processedRequests += "Sending " + 
								vehicleName + " to " + c.getName() + "\n";

								break;

							} else {
								x++;
							}
						}

					}

				}
		
					for (int j = 0; j < size; j++) {

						
						for (int k = 0; k < vehicle_data.size(); k++) {

							Truck v_t = (Truck)vehicle_data.get(k);

							String vehicleName = v_t.getName();
							if (vehicleName.equals(c.request.get(x))) {
								if (v_t.getNumOfTruckAvailable() > 0) {

							c.request.remove(x);

								c.rented.add(vehicleName);

									v_t.truckAvailable(false);

									processedRequests += "Sending " + 
									vehicleName + " to " + c.getName() + "\n";

									break;

								} else {
									x++;
								}
							}

						}

					}
		
					for (int j = 0; j < size; j++) {

						
						for (int k = 0; k < vehicle_data.size(); k++) {

							Bus v_b = (Bus) vehicle_data.get(k);

							String vehicleName = v_b.getName();
							if (vehicleName.equals(c.request.get(x))) {
								if (v_b.getNumOfBusAvailable() > 0) {

							c.request.remove(x);

								c.rented.add(vehicleName);

									v_b.busAvailable(false);

									processedRequests += "Sending " + 
									vehicleName + " to " + c.getName() + "\n";

									break;

								} else {
									x++;
								}
							}

						}

					}
			}

		}

		return processedRequests;

	}
/////////////////////////////////////////////////
	@Override
	public boolean returnVehicle(String customerName, String vehicleName) {
		int index = -1;
		for (int i = 0; i < customer_data.size(); i++) {
			if (customer_data.get(i).getName().equals(customerName)) {
				index = i;
			}
		}

		if (index == -1) {
			return false;
		}

		Customer c = customer_data.get(index);

		for (int i = 0; i < c.rented.size(); i++) {
			if (c.rented.get(i).equals(vehicleName)) {
				c.rented.remove(vehicleName);

				for (int j = 0; j < vehicle_data.size(); j++) {
					if (vehicle_data.get(j).getName().equals(vehicleName)) {
						
					}
				}

				return true;

			}
		}

		return false;

	}
/////////////////////////////////////////////////
	@Override
	public ArrayList<String> searchVehicle(String name, String type,String rating) {
		ArrayList<String> sorted = new ArrayList<String>();
		boolean nameCond = false, ratingCond = false, typeCond = false;
		for (Vehicle v : vehicle_data) {
			nameCond = (name == null || v.getName().equals(name));
			if (v instanceof Car) {
				Car ca = (Car) v;
				ratingCond = (rating == null || ca.getRating().equals(rating));
				nameCond = (name == null);
				typeCond = (type == null);
			} else if (v instanceof Truck) {
				Truck tr = (Truck) v;
				nameCond = (name == null || tr.getName().equals(name));
				typeCond = (type == null || tr.getType().equals(type));
				
			}
			if (nameCond && ratingCond && typeCond) {
				sorted.add(v.getName());
			}
		}
		Collections.sort(sorted);
		return sorted;
	}
	
	
}
