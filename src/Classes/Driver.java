package Classes;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Driver {
	
	static Scanner in=new Scanner(System.in);
	
	public static void main(String[] args)throws IOException {
		int menu=0;
		RentVehicleSystem op=new RentVehicleSystem();
		File cust_data=new File("cust_data.txt");
		
		File veh_data=new File("veh_data.txt");
		if(cust_data.exists()==false) {
			System.out.println("there isnt customer data file !!!");
		}
		if(veh_data.exists()==false) {
			System.out.println("there isnt vehicle data file !!!");
		}
		
		
		try {
			Scanner c_data=new Scanner(cust_data);
			Scanner v_data=new Scanner(veh_data);
			String[] x;
			if(cust_data.length()>0) {
				try {
					while(c_data.hasNextLine()) {
						x=c_data.nextLine().split(" ");
						op.addCustomer(x[1], x[2], x[3]);
						
					}
					System.out.println("all customer data was loaded successfully");
				}
				catch(ArrayIndexOutOfBoundsException e) {
					System.out.println("customer data file empty");
				}
			}
			else {
				System.out.println("customer data file empty");
			}
			
			if(veh_data.length()>0) {
				try {
					
					while(v_data.hasNextLine()) {
						x=v_data.nextLine().split(" ");
						
						if(x[0].equals("Car")) {
							op.addCar(x[1], x[2], Integer.parseInt(x[3]), x[4], Integer.parseInt(x[5]));
						}
						else if(x[0].equals("Truck")) {
							op.addTruck(x[1], x[2], Double.parseDouble(x[3]), Double.parseDouble(x[4]), Integer.parseInt(x[5]));
						}
						else if(x[0].equals("Bus")) {
							op.addBus(x[1], x[2], Integer.parseInt(x[3]), Integer.parseInt(x[4]));
						}
						
					}
					System.out.println("all vehicle data was loaded successfuly\n");
				}
				catch(ArrayIndexOutOfBoundsException e) {
					System.out.println("vehicle file empty");
				}
			}
	            
			else {
					System.out.println("vehicle file empty");
				}
				
				FileWriter c_w=new FileWriter("cust_data.txt",true);
				FileWriter v_w=new FileWriter("veh_data.txt",true);
				System.out.println(op.getAllCustomersInfo());
			 	System.out.println("----------------------------------------------------------\n"
				+op.getAllVehicleInfo());
			 	for(;;) {
			 	System.out.println("----------------------------------------------------------");
				System.out.println("please enter whats do you want to do: \n");
			 	System.out.print("1-Add Customer\n2-Add Vehicle\n3-Add cart\n4-Remove cart\n"
			 			+ "5-Request one\n6-Request two\n7-Return Vehicle\n8-Search Vehicle\n9-Sort Vehicle\n"
			 			+ "10-Sort Customer\n");
			 	
			 	System.out.print("\nchoice number: ");
			 	menu=in.nextInt();
			 	System.out.print("------------------------------------------------------------\n");
			 	switch(menu) {
			 	case 1:{
					AddingCustomers(c_w);
					break;
			 	}
			 	case 2:{
			 		testAddingVehicle(v_w);
			 		break;
			 	}
			 	case 3:{
			 		testingAddingToCart();
			 		break;
			 	}
			 	case 4:{
			 		testingRemovingFromCart();
			 		break;
			 	}
			 	case 5:{
			 		testProcessingRequestsOne();
			 		break;
			 	}
			 	case 6:{
			 		testProcessingRequestsTwo();
			 		break;
			 	}
			 	case 7:{
			 		testReturnVehicle();
			 		break;
			 	}
			 	case 8:{
			 		testReturnVehicle();
			 		break;
			 	}
			 	case 9:{
			 		System.out.println(op.getAllVehicleInfo());
			 		break;
			 	}
			 	case 10:{
			 		System.out.println(op.getAllCustomersInfo()); 
			 		break;
			 	}
			 }
			 	
			 	
			 	c_w.close();
			 	v_w.close();
			 	c_data.close();
			 	v_data.close();
		}
		}
	
		catch(FileNotFoundException e) {
			System.out.println("not found");
		}
		
	}	
	public static void AddingCustomers(FileWriter c_w) throws IOException{
		RentVehicleSystem op1=new RentVehicleSystem();
		Scanner in=new Scanner(System.in);
		String name;
		String address;                    
	 	String plan;
		System.out.print("please enter the customer name: ");
		name=in.next();
		System.out.print("please enter the customer address: ");
		address=in.next();
		System.out.print("please enter the customer plan(LIMITED/UNLIMITED): ");
		plan=in.next();
		while(!plan.equals("LIMITED") && !plan.equals("UNLIMITED") && !plan.equals("limited") && !plan.equals("unlimited")) {
			System.out.println("the plan should be just LIMITED or UNLIMITED!!!!");
			System.out.print("please re-enter the plan: ");
			plan=in.next();
			plan.toUpperCase();
		}
		plan.toUpperCase();
		op1.addCustomer(name, address, plan.toUpperCase());
		c_w.write("Customer"+" "+name +" "+address+" "+plan.toUpperCase()+" "+"\n");
	}
	public static void testAddingVehicle(FileWriter m_w) throws IOException{
		RentVehicleSystem op2=new RentVehicleSystem();
		Scanner in=new Scanner(System.in);
		String name;
		String type;
		////////////////////
		int numOfCarAvailable;
		String rating;
		int numOfPassenger;
		////car////////
		double weight;
		double load;
		int numOfTruckAvailable;
		/////truck//////////
		int numOfBusAvailable;
		int capacity;
		/////bus////////
 		System.out.print("1-Car\n2-Truck\n3-Bus\n\n");
 		int z;
 		System.out.print("please enter whats do you want to add: ");
 		z=in.nextInt();
 		switch(z) {
 		case 1:{
 			System.out.print("please enter name of car: ");
 			name=in.next();
 			System.out.print("please enter the type of car: ");
 			type=in.next();
 			System.out.print("please enter number of car avilable: ");
 			numOfCarAvailable=in.nextInt();
 			System.out.print("please enter the rating of car(HC/SP/NC): ");
 			rating=in.next();
 			while(!rating.equals("HC") && !rating.equals("hc") && !rating.equals("SP") && !rating.equals("sp")
 					&& !rating.equals("NC") && !rating.equals("nc")) {
 				System.out.println("not valid rating");
 				System.out.println("the rating is (HC), (SP), (NC) ");
 				System.out.print("please choose one of these rating: ");
 				rating=in.next();
 			}
 			rating.toUpperCase();
 			System.out.print("please enter number of passenger: ");
 			numOfPassenger=in.nextInt();
 			op2.addCar(name, type, numOfCarAvailable, rating, numOfPassenger);
 			m_w.write("Car"+" "+name+" "+type+" "+numOfCarAvailable+" "+rating+" "+numOfPassenger+"\n");
 			break;
 		}
 		case 2:{
 			System.out.print("please enter name of truck: ");
 			name=in.next();
 			System.out.print("please enter type of truck: ");
 			type=in.next();
 			System.out.print("please enter the weight of truck: ");
 			weight=in.nextDouble();
 			while(weight<0) {
 				System.out.println("the weight cannot be 0 or less!!!");
 				System.out.print("please enter the weight of game: ");
 				weight=in.nextDouble();
 			}
 			System.out.print("please enter the load of truck: ");
 			load=in.nextDouble();
 			System.out.print("please enter number of truck avilable: ");
 			numOfTruckAvailable=in.nextInt();
 			op2.addTruck(name, type, weight, load, numOfTruckAvailable);
 			m_w.write("Truck"+" "+name+" "+type+" "+weight+" "+load+" "+numOfTruckAvailable+"\n");
 			break;
 		}
 		case 3:{
 			System.out.print("please enter name of bus: ");
 			name=in.next();
 			System.out.print("please enter type of bus: ");
 			type=in.next();
 			System.out.print("please enter number of bus available: ");
 			numOfBusAvailable=in.nextInt();
 			System.out.print("please enter capacity of bus: ");
 			capacity=in.nextInt();
 			op2.addBus(name, type, numOfBusAvailable, capacity);
 			m_w.write("Bus"+" "+name+" "+type+" "+numOfBusAvailable+" "+capacity+"\n");
 			break;
 		}
 		}
	}
	
	public static void testingAddingToCart() {
		RentVehicleSystem op3=new RentVehicleSystem();
		Scanner in=new Scanner(System.in);
		String customer_name;
		String vehicle_name;
		System.out.print("please enter name of customer: ");
		customer_name=in.next();
		System.out.print("please enter name of vehicle: ");
		vehicle_name=in.next();
		op3.addTocart(customer_name, vehicle_name);
	}
	
	public static void testingRemovingFromCart() {
		RentVehicleSystem op4=new RentVehicleSystem();
		Scanner in=new Scanner(System.in);
		String customer_name;
		String vehicle_name;
		System.out.print("please enter name of customer: ");
		customer_name=in.next();
		System.out.print("please enter name of vehicle: ");
		vehicle_name=in.next();
		op4.removeFromcart(customer_name, vehicle_name);
	}
	
	public static void testProcessingRequestsOne() {
		RentVehicleSystem op5=new RentVehicleSystem();
		System.out.println(op5.processRequests());
	}
	
	public static void testProcessingRequestsTwo() {
		RentVehicleSystem op6=new RentVehicleSystem();
		System.out.println(op6.processRequests());
	}
	
	public static void testReturnVehicle() {
		RentVehicleSystem op7=new RentVehicleSystem();
		Scanner in=new Scanner(System.in);
		String customer_name;
		String vehicle_name;
		System.out.print("please enter name of customer: ");
		customer_name=in.next();
		System.out.print("please enter name of vehicle: ");
		vehicle_name=in.next();
		op7.returnVehicle(customer_name, vehicle_name);
	}
	
	public static void testSearchVehicle() {
		RentVehicleSystem op8=new RentVehicleSystem();
		Scanner in=new Scanner(System.in);
		
		String name;
		String type;
		String rating;
		
			System.out.print("please enter name of vehicle: ");
			name=in.next();
			System.out.print("please enter type of vehicle: ");
			type=in.next();
			System.out.print("please enter the rating of vehicle: ");
			rating=in.next();
			while(rating!="HC" ||rating!="hc"|| rating!="SP" ||rating!="sp"|| rating !="NC"||rating!="nc") {
 				System.out.println("not valid rating");
 				System.out.println("the rating is (HC), (SP), (NC) ");
 				System.out.print("please choose one of these rating: ");
 				rating=in.next();
 			}

			
			op8.searchVehicle(name,type,rating);
	}
}
