package airlineticketing;

import java.util.*;

public class PassangerDetails {
	String bookId;
	String PassangerId;
	String PassangerName;
	int PassangerAge;
	String bookingStatus;
	PassangerDetails(){
		
	}
	PassangerDetails(int flightId){
		bookId = "B"+"100"+flightId;
		PassangerId="P"+100+bookId;	
		bookingStatus ="Booked";
	}
	public String getBookId() {
		return bookId;
	}
	public String getPassangerId() {
		return PassangerId;
	}
	public String getPassangerName() {
		return PassangerName;
	}
	public void setPassangerName(String PassangerName) {
		this.PassangerName=PassangerName;
		PassangerId=PassangerId+this.PassangerName;
	}
	public int getPassangerAge() {
		return PassangerAge;
	}
	public void setPassangerAge(int PassangerAge) {
		this.PassangerAge= PassangerAge;
	}
	
	
	public static  void addPassanger() {
		PassangerDetails pd = new PassangerDetails(BookFlight.fligthNumber);
		Scanner sc= new Scanner(System.in);
		String name;
		System.out.println("Enter Passanger Name: ");
		name=sc.next();
		int age=0;
		try {
		System.out.println("Enter the passanger Age");
		age=sc.nextInt();
		}
		catch(Exception e1){
			System.out.println("please enter valid age!");
			try {
			age=sc.nextInt();
			}
			catch(Exception e1c){
				System.out.println("User is restricted, please login again to continue!");
				Main.main(null);
			}
		}
		pd.setPassangerName(name);
		pd.setPassangerAge(age);	
		Login.passangerDetails.put(pd.PassangerId,pd);
	}
	public static void showPassangerDetails() {
		if(Login.passangerDetails.size()!=0) {
			System.out.println("Passanger Details are : ");
			for (Map.Entry<String, PassangerDetails> e : Login.passangerDetails.entrySet()) {
				System.out.println("[ Booking Id : "+e.getValue().getBookId()+", Passanger Id : "+e.getValue().getPassangerId() +", Name : "+e.getValue().getPassangerName()+", Age : "+e.getValue().getPassangerAge()+" ]");
			}
		}
		else {
			System.out.println("No Passager Found yet!");
		}
		
	}
	public static void deletePassanger(String passId) {
		if(Login.passangerDetails.containsKey(passId)) {
			Login.passangerDetails.remove(passId);
			System.out.println("Passanger Is Removed From The Booking List.");
		}
		else {
			System.out.println("Invalid Passanger Id");
		}	
	}
}
