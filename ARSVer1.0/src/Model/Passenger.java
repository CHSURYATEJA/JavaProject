package Model;

public class Passenger {
    private int passengerId;
    private String pname;
    private String from_city;
    private String to_city;
    private int ticket_price;
	

    public Passenger(){

    }

    public Passenger(String pname, String from_city, String to_city, int ticket_price) {
        this.pname = pname;
        this.from_city = from_city;
        this.to_city = to_city;
        this.ticket_price = ticket_price;
    }

    public Passenger(int passengerId, String pname, String from_city, String to_city, int ticket_price) {
        this.passengerId = passengerId;
        this.pname = pname;
        this.from_city = from_city;
        this.to_city = to_city;
        this.ticket_price = ticket_price;
    }
    
    
    //getter and setters for constructor 
	public int getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getFrom_city() {
		return from_city;
	}

	public void setFrom_city(String from_city) {
		this.from_city = from_city;
	}

	public String getTo_city() {
		return to_city;
	}

	public void setTo_city(String to_city) {
		this.to_city = to_city;
	}

	public int getTicket_price() {
		return ticket_price;
	}

	public void setTicket_price(int ticket_price) {
		this.ticket_price = ticket_price;
	}
	
	 @Override
	 
	 //built in method of java which returns itself a String
	    public String toString() {
	        return "passenger{" +
	                "passengerID=" + passengerId+
	                ", pname='" + pname + '\'' +
	                ", from_city ='" + from_city+ '\'' +
	                ", to_city ='" + to_city+ '\'' +
	                ", ticket_price=" + ticket_price+
	                '}';
	    }
}