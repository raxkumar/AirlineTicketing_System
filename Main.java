package airlineticketing;
import java.util.*;

class InvalidUser extends Exception{
	public InvalidUser(String invalidUser) {
		super(invalidUser);
	}
}
class Login{
	
	public static int invalidUserCount=0;
	public static HashMap<String,BookFlight> passangerbooking = new HashMap<>();
	public static HashMap<String,PassangerDetails> passangerDetails = new HashMap<>();
	public static void  bookingStart(String userid, String pass) {
		Scanner sc = new Scanner(System.in);
		System.out.println("::::::::::BOOK FLIGHT:::::::::\n");

		int userChoice,flightOption=0;
		do {
			int option=0;
			System.out.println("1. StartBooking   2.   Booking Details 3.   Passanger Details  4.   Add Passanger  5.   Delete Passanger\n");
			try {
			option = sc.nextInt();
			}
			catch(NumberFormatException e1){
				System.out.println("Please Enter Valid option!");
				System.out.println("User is restricted, please login again to continue!");
				Main.main(null);
			}
			if(option==1 || option==4) {
				System.out.println("Available Filghts are : ");
				System.out.println("1. F1001\n2. F1002\n");
				flightOption=sc.nextInt();
				BookFlight.fligthNumber=flightOption;
			}
			switch(option) {
			case 1 : BookFlight.addBooking(flightOption,userid);
					 break;
			case 2:  BookFlight.showBookingDetails();
					 break;
			case 3 : PassangerDetails.showPassangerDetails();
					 break;
			case 4 : PassangerDetails.addPassanger();
					 break;
			case 5 : System.out.println("enter the passanger Id :");
					 String passangerId = sc.next();
					 PassangerDetails.deletePassanger(passangerId);
					 break;
			default : System.out.println("::::::::Invalid Choice::::::::");
					  break;
			}
			System.out.println("Do you want to continue ? 1/0 ");
			userChoice = sc.nextInt();
			if(userChoice !=1 && userChoice != 0) {
				System.out.println("::::::::Invalid Choice::::::::\n");
				Main.main(null);
				//System.exit(0);
			}
			
		}while(userChoice==1);
		
	}
	void validate(String userid,String pass) {
		Scanner sc = new Scanner(System.in);
		if(Main.validUsers.containsKey(userid) && Main.validUsers.get(userid).equals(pass)) {
			Login.bookingStart(userid,pass);
		}
		else {
			try {
				invalidUserCount++;
				throw new InvalidUser("*****INVALID USER*****\n");
			}
			catch(InvalidUser invalidUser) {
				System.out.println(invalidUser.getMessage());
				if(invalidUserCount == 5) {
					System.out.println("\n!!!You Have Reached The Maximum Limit For The Day!!!");
				}
				else {
					Main.main(null);
				}
			}
					
		}
	}
	
}
public class Main {
	public static HashMap<String,String> validUsers = new HashMap<>();
	public static void main(String[] args) {
		validUsers.put("abc","1234");
		validUsers.put("xyz","1234");
		validUsers.put("rax","1234");
		Scanner sc = new Scanner(System.in);
		Login login = new Login();
		
		String userId, password;
		System.out.print("Enter user Id :");
		userId = sc.next();
		System.out.print("Enter password :");
		password =sc.next();
		
		login.validate(userId, password);
		
	}
	

}
