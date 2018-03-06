
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
public class WorkTicket {
private String ticketNum;
private Customer customer;
private Car car;
private ServiceQuote theServiceQuote;
private String firstTwoLetters;
private String firstTwoNums;
Random r = new Random();
/**
 * (sets default string to variable)
 */ 

public WorkTicket()
{
	ticketNum = "unintialized";
	
}
/**
 * (sets all the user inputed information equal to corresponding variables)
 * @param (passes in a customer object)
 * @param (passes in a car object)
 * @param (passes in a servicequote object)
 */ 

public WorkTicket(Customer cust, Car carC, ServiceQuote serviceQuoteS)
{
	customer = cust;
	car = carC;
	theServiceQuote = serviceQuoteS;
	StringBuilder makeTicketNum = new StringBuilder();
	firstTwoLetters = customer.toString();
	firstTwoLetters = firstTwoLetters.substring(13,14);
	firstTwoNums = customer.toString();
	firstTwoNums = firstTwoNums.substring(17,18);
	makeTicketNum.append(firstTwoLetters);
	makeTicketNum.append(firstTwoNums);
	int n = 10000 - 1000 + 1;
	int i = r.nextInt() % n;
	int appendNum = 1000 + i;
	makeTicketNum.append(appendNum);
	ticketNum = makeTicketNum.toString();
}
/**
 * (method determines whether there is a duplicate object)
 * @param (passes in a comparable ticket)
 * @param (passes in a comparable customer object)
 * @param (passes in a comparable car object)
 * @param (passes in a comparable service quote object)
 * @return (returns a boolean value determining whether or not there is a duplicate object)
 */ 

public boolean equals(String anotherTicket, Customer anotherCust, Car anotherCar, ServiceQuote anotherSQ)
{
	if(this.ticketNum.equals(anotherTicket))
	{
		return true;
	}
	else if(this.car.equals(anotherCar))
	{
		return true;
	}
	else if(this.theServiceQuote.equals(anotherSQ))
	{
		return true;
	}
	else if(this.customer.equals(anotherCust))
	{
		return true;
	}
	else
	{
		return false;
	}
}	
/**
 * (get method for the ticket number)
 * @return (returns the ticket number)
 */ 

public String getTicketNum()
{
	return ticketNum;	
}
/**
 * (get method for the car object)
 * @return (returns the car object)
 */ 

public Car getCar()
{
	return car;
}
/**
 * (get method for the customer object)
 * @return (returns the customer object)
 */ 

public Customer getCustomer()
{
	return customer;
}
/**
 * (get method for the service quote object)
 * @return (returns the service quote object)
 */ 

public ServiceQuote getServiceQuote()
{
	return theServiceQuote;
}
/**
 * (method that creates the string to be displayed)
 * @return (returns the string that is to be displayed)
 */ 

public String toString()
{
	String display = ("Ticket Number: " + ticketNum + "\n" + this.customer.toString() + "\n" + this.car.toString() + "\n" + this.theServiceQuote.toString());
	return display;
}
}// end overall class
