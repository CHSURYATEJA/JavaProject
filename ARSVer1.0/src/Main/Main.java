package Main;

import java.util.Scanner;

import DAO.ARSDaoInterface;
import Model.Passenger;
import DAO.ARSDao;


public class Main {
	 public static void main(String[] args) {
		 //Scanner Class to give console based inputs
		 	Scanner sc = new Scanner(System.in);
		 //Object Creation	
		 	ARSDaoInterface dao=new ARSDao();
		 	 System.out.println("Welcome to ARS- Airline Reservation System");
		 //This is the main interface of the ARS application
		 	while(true){
		 		System.out.println("\n1.Add Paassenger" +
		 				"\n2.Show All Passengers" +
		 				"\n3.Get Passengers based on Passenger Id" +
		 				"\n4.Delete Passenger"+
		 				"\n5.Update Passenger" +
		 				"\n6.Exit");
		 
		 //Using switch cases for different modules of application	
		 	
		 	System.out.println("Enter choice");
		 	 int ch=sc.nextInt();
		 	 switch (ch){
		 	case 1:
		 		//Case for adding a new passenger
		 		System.out.println("Add Passenger");
		 		
		 		System.out.println("Enter Passenger name");
		 		String pass_name=sc.next();
		 		System.out.println("Enter From City");
		 		String from_city=sc.next();
		 		System.out.println("Enter To City");
		 		String to_city =sc.next();
		 		System.out.println("Enter Price of Ticket");
		 		int ticket_price =sc.nextInt();
		 		//Object Creation for passenger along with parameters
		 		Passenger psg=new Passenger(pass_name,from_city,to_city,ticket_price);
		 		boolean ans=dao.insertPassenger(psg);
		 		if(ans)
		 		System.out.println("Passenger inserted Successfully!!!");
		 		
		 		System.out.println("something went wrong, please try again");
		 		//break statement takes the flow of control out of the switch statement
		 		break;
		 	 
		 	 
	 		case 2:
	 			//Case for showing all the passengers in our database
	 			System.out.println("Show all Passengers ");
	 			dao.showAllPassengers();
	 			break;
	 			
	 		 case 3:
	 			 //case for showing passengers based on passenger Id
	 			System.out.println("Get passengers based on Passenger ID");
	 			System.out.println("enter passenger id");
	 			int passengerId=sc.nextInt();
	 			//Condition if passenger not available in our database
	 			boolean f= dao.showPassengersById(passengerId);
	 			if(!f)
	 			System.out.println("Passenger with this id is not available in our system");
	 			//break statement takes the flow of control out of the switch statement
	 			break;
	 			
	 		 case 4:
	 			 //case for Deleting the passenger from our Database
	 			System.out.println("Delete Passenger");
	 			System.out.println("enter Passenger ID to delete");
	 			int passId =sc.nextInt();
	 			
	 			boolean ff=dao.delete(passId);
	 			if(ff)
	 			System.out.println("Record deleted successfully...");
	 			else
	 			System.out.println("Something went wrong");
	 			//break statement takes the flow of control out of the switch statement
	 			break;
	 			
	 		 case 5:
	 			 //Case for Updating passenger Name By id 
	 			
	 			System.out.println("\n1.Update name");
	 			System.out.println("enter your choice");
	 			int choice=sc.nextInt();
	 			
	 			
	 			//Passenger Name Updating
	 			if(choice==1){
	 				
	 				System.out.println("enter passenger id");
	 				int pid=sc.nextInt();
	 				System.out.println("Enter new name");
	 				String pname=sc.next();
	 				Passenger psg1=new Passenger();
	 				psg1.setPname(pname);
	 				//dao refers to the Data Access Object
	 				boolean flag=dao.update(ch,pname,choice,psg1);
	 				if(flag)
	 				System.out.println("Name updated successfully");
	 				else
	 				System.out.println("Something went wrong...");
	 			}
	 			else 
	 				System.out.println("Some Thing went wrong please select a numbers given above");
	 			//break statement takes the flow of control out of the switch statement
		 			break;
		 	
	 		case 6:
	 			//Case for Exiting the application 
	 			System.out.println("Thank You for using ATS - Airline Reservation System !!!");
	 			//Terminates the current java running machine
	 			System.exit(0);
	 			//Application exits and terminates the program
	 			
	 		default:
	 			//Case for specifing that entered choice is incorrect 
	 			System.out.println("Please enter valid choice..");
	 			
	 			
}
}
}
}