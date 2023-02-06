package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	//global declaration of variable
    static Connection con;

    public static Connection createConnection(){

        try{
        	//used to get instance of the class with specified class name
            Class.forName("com.mysql.cj.jdbc.Driver");
            //user name of mysql 
            String user="root";
            //pass word of mysql
            String pass="Surya@311004";
            /*provides a way of identifying a database so that appropriate driver 
              recognizes it and connects to it */
            String url = "jdbc:mysql://localhost:3306/ars?autoReconnect=true&useSSL=false";
            //Driver manager class attempts to establish a connection to the database
            con= DriverManager.getConnection(url,user, pass);

        }
        catch(Exception ex){
            ex.printStackTrace();
        }

        return con;
    }

}