package DAO;

import Model.Passenger;

public interface ARSDaoInterface {
    
	// specifies the behaviour of a class by providing an abstract class 
	/*Interfaces are used in java to achieve abstraction (A process of hiding implementation 
	  details and showing only function details to the user*/
	
	public boolean insertPassenger(Passenger p);
	
    public boolean delete(int id);
    
    public boolean update(int id,String update,int ch,Passenger p);
    
    public void showAllPassengers();
    
    public boolean showPassengersById(int id);
    
}
