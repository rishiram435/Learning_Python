package javaarray1;

// TODO -- create header comments

import java.util.Scanner;
import java.util.*;
import javax.swing.JOptionPane;

// TODO -- create the Booking class (separate file: Booking.java)

public class RockyCateringMenu extends javax.swing.JFrame
{
	final int ENTER_BOOKING = 1;
	final int DISPLAY_BOOKINGS = 2;
	final int DISPLAY_STATISTICS = 3;
	final int SEARCH_BOOKINGS = 4;
	final int SORT_BOOKINGS = 5;
	final int EXIT = 6;

	// TODO -- declare any further constants

	// TODO -- declare array of booking objects
        Booking[] booking = new Booking[10];
	// TODO -- declare variable for the current booking entered (integer)
        int count;

	Scanner inputMenuChoice = new Scanner(System.in);



	private int getMenuItem()
	{
		System.out.println("\nPlease select from the following");
		System.out.println(ENTER_BOOKING + ". Enter booking name and number of guests");
		System.out.println(DISPLAY_BOOKINGS + ". Display all booking names, number of guests and charges");
		System.out.println(DISPLAY_STATISTICS + ". Display Statistics");
		System.out.println(SEARCH_BOOKINGS + ". Search for booking");
		System.out.println(SORT_BOOKINGS + ". Sort the bookings");
		System.out.println(EXIT + ". Exit the application");
		System.out.print("Enter choice==> ");

		String choice = inputMenuChoice.nextLine();
		while (choice.equals("") || !isStringNumeric(choice))
		{
			JOptionPane.showMessageDialog(null, "Error - Menu selection name cannot be blank and must be numeric",
											"Input Menu Choice", JOptionPane.ERROR_MESSAGE);

			System.out.print("Enter choice==> ");

			choice = inputMenuChoice.nextLine();
		}

		return Integer.parseInt(choice);
	}

	private boolean isStringNumeric(String str)
	{
		for (int i = 0; i < str.length(); i++)
		{
			if (!Character.isDigit(str.charAt(i)))
				return false;
		}

		return true;
	}


	private void processBookings()
	{
		int choice = getMenuItem();
		while (choice != EXIT)
		{
			switch (choice)
			{
				case ENTER_BOOKING:
					enterBooking();
					break;
				case DISPLAY_BOOKINGS:
					displayAllBookings();
					break;
				case DISPLAY_STATISTICS:
					displayStatistics();
					break;
				case SEARCH_BOOKINGS:
					searchBookings();
					break;
				case SORT_BOOKINGS:
					sortBookings();
					break;
				default:
					System.out.println("ERROR choice not recognised");
			}
			choice = getMenuItem();
		}
	}

	private void enterBooking()
	{
		displayHeading();
		// TODO -- check if maximum bookings has been reached (do this after getting the other functionality working)
            while (count < 10){
                
		// TODO -- read in the booking name via a dialog (as a string)
                String bookingName = JOptionPane.showInputDialog("Please! enter the booking name ");
                // TODO -- create validation loop (do this after getting the other functionality working)
                while (true){
                if (bookingName.equals("")){
                    JOptionPane.showMessageDialog(null, "Error- the Booking input cannot be blank", "Inane Error" ,JOptionPane.ERROR_MESSAGE);
                    bookingName = JOptionPane.showInputDialog("Please! enter the booking name ");
                }
                
                    // Display message
                else {
                    JOptionPane.showMessageDialog(null, "Hello " + bookingName);
                    break;
                }
                }
                
                
		// TODO -- read in the number of passengers via a dialog and convert into an integer
                String guestNumber = JOptionPane.showInputDialog("Please! enter the number of guests ");
                int guest=Integer.parseInt(guestNumber);
		// TODO -- create validation loop (do this after getting the other functionality working)
                while (true){
                if (guestNumber.equals("")){
                    JOptionPane.showMessageDialog(null, "Error- the Guest number input cannot be blank", "Inane Error" ,JOptionPane.ERROR_MESSAGE);
                }
                else if (guest < 10 ){
                    JOptionPane.showMessageDialog(null, "Error- the Guest number input must be over 10", "Inane Error" ,JOptionPane.ERROR_MESSAGE);
                }
                // Display message
                else {
                    JOptionPane.showMessageDialog(null, "Successfully added: " + guest);
                    break;
                }
                guestNumber = JOptionPane.showInputDialog("Please! enter the number of guests ");
                }
		// TODO -- add the data to the array (use the new keyword and the parameterised constructor in Booking class)
                booking[count]= new Booking(bookingName,guest);
		// TODO -- display the booking name, number of guests and the charge
                System.out.println(booking[count].getBookingName() + "\t\t\t\t" + booking[count].getGuests() + "\t\t$" + 
                                   booking[count].calculatePrice(guest));
		// TODO -- increment the current booking variable for the next entry
                Scanner scan = new Scanner(System.in);
                System.out.println("Do you want input more?(y/n): ");
                String input = scan.nextLine();
                if (input.equals("y")){
                    count++;
                    continue;
                }
                else{
                    break;
                }
            }
	}


	private void displayHeading()
	{
		System.out.printf("%-30s%-17s%-6s\n", "Booking Name", "Guests", "Charge");
	}


	private void displayAllBookings()
	{
            displayHeading();
		// TODO -- check if there has been a booking entered (do this after getting the other functionality working)
		// TODO -- display all of the entries entered so far (just display the current entries not the whole array, use the current booking variable as the termination condition)
                for (int i =0;i<booking.length;i++){
                    if (booking[i] == null){
                        System.out.print("No entries of Booking yet");
                        break;
                    }
                    
                    else {
                        System.out.println(booking[i].getBookingName() + "\t\t\t\t" + booking[i].getGuests() + "\t\t$"+
                                booking[i].calculatePrice(booking[i].getGuests()));
                    }
                }
	}

	private void displayStatistics()
	{
		// TODO -- check if there has been a booking entered (do this after getting the other functionality working)
		// TODO -- loop though the current entries in the array and calculate and display the statistics
            double total=0;
            double avg=0;
            int count=0;
            int totalGuest=0;
            for (int i=0;i<booking.length;i++) {
                if (booking[i] != null){
                    System.out.println(booking[i].getBookingName() + " has the maximum guest of " + booking[i].getGuests());
                    total += booking[i].calculatePrice(booking[i].getGuests());
                    totalGuest += booking[i].getGuests();
                    count++;
                    avg = totalGuest/count;
                }
                
                else{ 
                    break;
                }
            }
            System.out.println("Average number of guests are " + avg);
            System.out.println("The total charges are:"+ total);
	}

	private void searchBookings()
	{
		// TODO -- check if there has been a booking entered (do this after getting the other functionality working)
		// TODO -- read the search key using a dialog
                String searchkey = JOptionPane.showInputDialog( "Please enter the booking name");
		// TODO -- loop though the current entries in the array to search for the search key
                for(int i=0;i<booking.length;i++){
                    if(booking[i] != null){
                        if(booking[i].getBookingName().equals(searchkey)){
                            System.err.println("Found at " + i);
                            displayHeading();
                            System.out.println(booking[i].getBookingName() + "\t\t\t\t" + booking[i].getGuests() + "\t\t$"+
                                               booking[i].calculatePrice(booking[i].getGuests()));
                            break;
                        }
                    }
                    
                    else{
                         JOptionPane.showMessageDialog(null, searchkey + " - the booking name can't be found", "Inane Error" ,JOptionPane.ERROR_MESSAGE);
                         break;
                    }
                }
		// TODO -- display the found item or report it has not been found
               
	}

	private void sortBookings()
	{
		// TODO -- check if there has been two bookings entered (do this after getting the other functionality working)
		// TODO -- sort the entries
            displayHeading();
            String string[] = new String[]{booking[0].getBookingName(),booking[1].getBookingName()};
            for(int i=0;i<1;i++){
                if (booking[i] != null) {
                    Arrays.sort(string);
                    System.out.println(string[0] + "\t\t\t\t" + booking[0].getGuests() + "\t\t$"+
                                booking[i].calculatePrice(booking[i].getGuests()));
                    System.out.println(string[1] + "\t\t\t\t" + booking[1].getGuests() + "\t\t$"+
                                booking[1].calculatePrice(booking[1].getGuests()));
                }
                
                else {
                    break;
                }
            }
            
//            String temp;
//                for (int i=0;i<booking.length;i++){
//                    for (int j=i+1;i<booking.length;j++){
//                        
//                        if (booking[i].getBookingName().compareTo(booking[j].getBookingName())> 0) {
//                            temp= booking[i].getBookingName();
//                            booking[i].getBookingName() = booking[j].getBookingName();
//                            temp = booking[j].getBookingName() ;
//                        }
//                    }
//                }
//                
//                for(int i=0;i<booking.length;i++){
//                    System.out.print(booking[i].getBookingName());
//                }
		// TODO -- display the sorted list

	}
            
        
	public static void main(String [] args)
	{
		RockyCateringMenu app = new RockyCateringMenu();
                Booking[] RockyCateringMenu1 = new Booking[10];
                
                for (int i =0;i<RockyCateringMenu1.length;i++){
                    RockyCateringMenu1[i]= new Booking();
                }
                
		app.processBookings();
	}
        
//        public static Booking[] add(Booking[] arr, Booking... elements){
//            Booking[] temparr = new Booking[arr.length+elements.length];
//            System.arraycopy(arr,0,temparr,0,arr.length);
//            
//            for(int i=0; i<elements.length;i++)
//                temparr[arr.length+i] = elements[i];
//            return temparr; 
//        }
}