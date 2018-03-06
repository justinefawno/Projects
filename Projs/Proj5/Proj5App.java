
/**
 * (this project lets a user input information to find and calculate work tickets for a car shop)
 * @author (Justine Onnen)
 * @version (5)
*/ /*
 * Justine Onnen
 * Project 5
 * Dennis Lang
 * M W F 9:30-10:45
 * This program is to produce a work ticket for a mechanic workshop
 */ 
import java.util.*;
public class Proj5App {
	/**
	 * (main method that holds the user implementation)
	 */ 
	public static void main(String args[])
	{
	WorkTicket[] workTickets = new WorkTicket[50];
	String answer;
	Scanner s = new Scanner(System.in);
	int i = 0;
	do
	{
		System.out.print("Enter customer name: ");
		String custName = s.next();
		System.out.print("Enter customer address: ");
		String custAddress = s.next();
		System.out.print("Enter customer city: ");
		String custCity = s.next();
		System.out.print("Enter customer state: ");
		String custState = s.next();
		System.out.print("Enter customer zip: ");
		String custZip = s.next();
		System.out.print("Enter customer phone: ");
		String custPhone = s.next();
		Customer customer = new Customer(custName, custAddress, custCity, custState, custZip, custPhone);
		
		System.out.print("Enter VIN: ");
		String VIN = s.next();
		System.out.print("Enter make: ");
		String make = s.next();
		System.out.print("Enter model: ");
		String model = s.next();
		System.out.print("Enter year: ");
		int year = s.nextInt();
		Car car = new Car(VIN, make, model, year);
		
		System.out.print("Enter parts charge: ");
		double pCharge = s.nextDouble();
		System.out.print("Enter labor charge: ");
		double lCharge = s.nextDouble();
		ServiceQuote serviceQuote = new ServiceQuote(pCharge, lCharge);
		
		WorkTicket tempWT = new WorkTicket(customer, car, serviceQuote);
		
		if(i==0)
		{
			workTickets[i] = tempWT;
		}
		else
		{
			for(int e = 0; e<=i; e++)
		{
			boolean duplicate = tempWT.equals(workTickets[e].getTicketNum(), workTickets[e].getCustomer(), workTickets[e].getCar(), workTickets[e].getServiceQuote());
			if (duplicate == false)
			{
				workTickets[i] = tempWT;
			}
		}
		}
			
		
		System.out.print("To stop entering information enter 'stop', to continue type continue: ");
		answer = s.next();
		i++;
	}while(i<50 && answer.equals("continue"));
	
	for (int e = 0; e < i; e++)
	{
		System.out.print(workTickets[e].toString());
		System.out.println();
	}
	System.out.println();
	String keepSearching = "yes";
	System.out.print("Would you like to search for a ticket? 'yes or no' ");
	keepSearching = s.next();
	if (keepSearching != "no" && keepSearching != "No")
	{
		String findAnotherTicket = "Y";
		do
		{
		System.out.print("Please enter a work ticket number: ");
		String wtNum = s.next();
		System.out.println();
		int foundYN;
		foundYN = findTicketIndex(wtNum, i, workTickets);
		
		
		
		if (foundYN != -1)
		{
			System.out.println("Ticket found!");
			System.out.print(workTickets[foundYN].toString());
			findAnotherTicket = s.next();
		}
		else
		{
			System.out.println("Ticket not found! Try Again? Y/N");
			findAnotherTicket = s.next();
		}
		
		}while(findAnotherTicket.equals("Y") || findAnotherTicket.equals("y"));
	}//end if statement
	
	
	
	
	}//end main class
	/**
	 * (this method goes through and finds the index of the found tickets so they may be displayed)
	 * @param (the user inputed string of ticket to find the string)
	 * @param (the index of i)
	 * @return (the index of the found ticket)
	 */ 
	public static int findTicketIndex(String ticketNumEntered, int nums, WorkTicket[] workTickets)
	{
		int ticketIndex = -1;
		for (int y = 0; y < nums; y++)
		{
			if(workTickets[y].getTicketNum().equals(ticketNumEntered))
		{
			ticketIndex = (nums - 1);
		}
		}
		return ticketIndex;
	}
	
}//end overall class
