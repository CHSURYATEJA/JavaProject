package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import DBConnection.DBConnection;
import Model.Passenger;


public class ARSDao implements ARSDaoInterface{

    @Override
    public boolean insertPassenger(Passenger p) {
        boolean flag=false;
        try{
        	// Returns a new instance of the provider's class that implements the DBConnection class
            Connection con= DBConnection.createConnection();
            
            //Inserting Data
            String query="insert into ars(pname,from_city ,to_city ,ticket_price) value(?,?,?,?)";
            
            /*preparedStatement object provides a feature to execute a parameterized query. To return
              the object of preparedStatement.*/
            PreparedStatement pst=con.prepareStatement(query);
            
            //data insertion into database
            pst.setString(1,p.getPname());
            pst.setString(2,p.getFrom_city());
            pst.setString(3,p.getTo_city());
            pst.setInt(4,p.getTicket_price());
            
            //execution of Update
            //execution of DML statement update which return int value, count of the effected rows
            pst.executeUpdate();
            flag=true;

        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return flag;
    }

    
    @Override
    public boolean delete(int passId) {
      boolean flag = false;
      try {
        Connection con = DBConnection.createConnection();
        String query = "DELETE FROM ars WHERE id = ?";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setInt(1, passId);
        int rowsAffected = pst.executeUpdate();
        if (rowsAffected > 0) {
          flag = true;
        }
        pst.close();
        con.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
      return flag;
    }


    @Override
    public boolean update(int id, String update, int ch, Passenger p) {
    	//updation of passenger details 
        int choice=ch;
        boolean flag=false;
        try{
            if(choice==1){
            	//returns the new instance of the data providers class that implements DBConnection class  
                Connection con=DBConnection.createConnection();
                String query="update ars set pname=? where id =?";
                PreparedStatement ps=con.prepareStatement(query);
                //updating the passenger details based on passenger id inputs.
                ps.setString(1,update);
                ps.setInt(2,id);
                
                //execution of DML statement update which return int value, count of the effected rows
                ps.executeUpdate();
                flag=true;

            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return flag;
    }

    @Override
    public void showAllPassengers() {
        try{
        	//getting all passengers details 
        	
        	
        	//returns a new instance of the provider's class that implements the DBConnection class
            Connection con=DBConnection.createConnection();
            //query is used to update the details and run the queries 
            String query="select * from ars";
            //To return the object of the prepared statement 
            Statement stmt=con.createStatement();
            //executing result query 
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next()){
                System.out.println("passenerID : "+rs.getInt(1)+"\n" +
                        "Name: "+rs.getString(2)+"\n" +
                        "From: "+rs.getString(3)+"\n" +
                        "To: "+rs.getString(4)+"\n" +
                        "Ticket_price: "+rs.getInt(5));
                System.out.println("----------------------------------");

                
            }

        }
        catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public boolean showPassengersById(int passengerId) {
        boolean flag=false;
        try{
        	//getting passenger details by passenger id
        	
        	//returns a new instance of the provider's class that implements the DBConnection class
            
        	Connection con=DBConnection.createConnection();
        	
            String query="select * from ars where Id = "+ passengerId;
            Statement stmt=con.createStatement();
            //executing the result query 
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next()){
                System.out.println("passengerId: "+rs.getInt(1)+"\n" +
                        "Name: "+rs.getString(2)+"\n" +
                        "From: "+rs.getString(3)+"\n" +
                        "To: "+rs.getString(4)+"\n" +
                        "Ticket_price+"+rs.getString(5));
                System.out.println("----------------------------------");
                flag=true;

            }

        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        return flag;
    }
}