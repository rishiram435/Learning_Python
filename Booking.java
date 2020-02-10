package javaarray1;

import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author msi1
 */
public class Booking implements Comparable<Booking> {
    
    Scanner in = new Scanner(System.in);

    public Booking() {
        
    }
    
    public Booking(String bookingName, int guests){
        super();
        this.bookingName= bookingName;
        this.guests= guests;
    }
    private String bookingName;
    private int guests;

    /**
     * @return the bookingName
     */
    public String getBookingName() {
        return bookingName;
    }
    
    /**
     * @param bookingName the bookingName to set
     */
    public void setBookingName(String bookingName) {
        this.bookingName = bookingName;
    }

    /**
     * @return the guests
     */
    public int getGuests() {
        return guests;
    }

    /**
     * @param guests the guests to set
     */
    public void setGuests(int guests) {
        this.guests = guests;
    }
    
    
    public double calculatePrice(int guests){
        guests= getGuests();
        double intialPrice= 0.0;
        if (guests < 11){
            exit();
        }
        
        else if(guests<41){
            intialPrice= 590.00;
            intialPrice += 24.50 * guests;
            return intialPrice;
        }
        
        else{
            intialPrice= 1080.00;
            intialPrice += 19.50 * guests;
            return intialPrice;
        }
        return 0;   
    }

    private void exit() {
        System.out.println("Error. Number of guests must be 10"); //To change body of generated methods, choose Tools | Templates.
        
    }
    
    public static void main(String[] args){
       
        Booking price = new Booking();
        
        
    }
    
    @Override
    public String toString(){
        return ("(" + bookingName + ", " + guests + ")");
    }

    @Override
    public int compareTo(Booking o) {
        return toString().compareTo(o.toString());
    }
    
    
}
