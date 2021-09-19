package airlineticketing;

import java.util.Map;
import java.util.Scanner;

public class BookFlight {
	static int fligthNumber;
	String flightId;
	String BookId;
	String userClass;
	String dateOfJourney;
	int numberOfAdults;
	int numberOfChildren;
	int ticketFare;
	String CustomerId;
	BookFlight(){
		
	}
	BookFlight(int fn, String userId){
		this.fligthNumber= fn;
		this.flightId ="F"+"100"+fligthNumber;
		this.BookId ="B"+"100"+fligthNumber;
		this.CustomerId=userId;
		this.ticketFare=12000;
	}
	public String getflightId() {
		return this.flightId;
	}
	public String getBookId() {
		return this.BookId;
	}
	public String getCustomerId() {
		return this.CustomerId;
	}
	public String getUserClass() {
		return this.userClass;
	}
	public void setUserClass(String userClass) {
		this.userClass=userClass;
	}
	public String getdateOfJourney() {
		return this.dateOfJourney;
	}
	public void setdateOfJourney(String dateOfJourney) {
		this.dateOfJourney=dateOfJourney;
	}
	public int getnumberOfAdults() {
		return this.numberOfAdults;
	}
	public void setnumberOfAdults(int numberOfAdults) {
		this.numberOfAdults=numberOfAdults;
	}
	public int  getnumberOfChildren() {
		return this.numberOfChildren;
	}
	public void setnumberOfChildren(int numberOfChildren) {
		this.numberOfChildren=numberOfChildren;
	}
	public static void addBooking(int flightOption,String userid) {
		BookFlight bookflight = new BookFlight(flightOption,userid);
		Scanner sc = new Scanner(System.in);
		String userClass;
		String dateOfJourney;
		int numberOfAdults=0;
		int numberOfChildren=0;
		System.out.println("Enter the class\n1.First Class\n2.Business Class\n3. and Economy Class\n");
		int localClass=sc.nextInt();
		if(localClass==1) {
			userClass="First Class";
		}
		else if(localClass==2) {
			userClass="Business Class";
		}
		else {
			userClass="Economy Class";
		}
		System.out.println("Enter the date of journey(dd/mm/yyyy)");
		dateOfJourney=sc.next();
		try {
		System.out.println("Enter the number of Adults");
		numberOfAdults=sc.nextInt();
		}
		catch(NumberFormatException e1){
			System.out.println("Please Enter Valid Number!");
			System.out.println("User is restricted, please login again to continue!");
			Main.main(null);
		}
		try {
		System.out.println("Enter the number of Children");
		numberOfChildren=sc.nextInt();
		}
		catch(NumberFormatException e1){
			System.out.println("Please Enter Valid Number!");
			System.out.println("User is restricted, please login again to continue!");
			Main.main(null);
		}
		bookflight.setUserClass(userClass);
		bookflight.setdateOfJourney(dateOfJourney);
		bookflight.setnumberOfAdults(numberOfAdults);
		bookflight.setnumberOfChildren(numberOfChildren);
		Login.passangerbooking.put(bookflight.BookId, bookflight);
		
		for(int i=0;i<numberOfAdults;i++) {
			PassangerDetails.addPassanger();
		}
		for(int i=0;i<numberOfChildren;i++) {
			PassangerDetails.addPassanger();
		}	
	}
	public static void showBookingDetails() {
		if(Login.passangerbooking.size()!=0) {
			System.out.println("Booking Details are :");
			for(Map.Entry<String,BookFlight> obj : Login.passangerbooking.entrySet()) {
				System.out.println("[ Booking Id : "+obj.getValue().getBookId()+", Customer Id : "+obj.getValue().getCustomerId()+", "
						+ "Class : "+obj.getValue().getUserClass()+", Number of Adults : "+obj.getValue().getnumberOfAdults()+
						", Number of Childern : "+obj.getValue().getnumberOfChildren()+", Date of journey : "+obj.getValue().getdateOfJourney()+" ]");
				
			}
			
		}
		else {
			System.out.println("!!!No Booking is Available yet!!!");
		}
	}
}
