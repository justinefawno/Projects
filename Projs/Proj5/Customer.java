
/**
 * (this project lets a user input information to find and calculate work tickets for a car shop)
 * @author (Justine Onnen)
 * @version (5)
*/ import java.util.Random;

/*
 * Justine Onnen
 * Project 5
 * Dennis Lang
 * M W F 9:30-10:45
 * This program is to produce a work ticket for a mechanic workshop
 */
public class Customer {
private String custID;
private String name;
private String address;
private String city;
private String state;
private String zip;
private String phone;
private int appendNum;
private StringBuilder custIDFinal = new StringBuilder();
Random r = new Random();
/**
 * (sets up default values in case user does not input)s
 */ 

public Customer()
{
	custID = "unintialized";
	name = "unintialized";
	address = "unintialized";
	city = "unintialized";
	state = "unintialized";
	zip = "unintialized";
	phone = "unintialized";
}
/**
 * (sets user inputed information set to correct variables)
 * @param (name of customer)
 * @param (address of customer)
 * @param (city of customer)
 * @param (state of customer)
 * @param (zip of customer)
 * @param (phone number of customer)
 */ 

public Customer(String nameOfCust, String addressOfCust, String cityOfCust, String stateOfCust, String zipOfCust, String phoneOfCust)
{	
	//need to use a random num generator to get the custID then append to the first four letters of last name with 6 random numbers (do I need six different numbers or can I do a six digit random number?)
	name = nameOfCust;
	address = addressOfCust;
	city = cityOfCust;
	state = stateOfCust;
	zip = zipOfCust;
	phone = phoneOfCust;
	custID = name.substring(0,4);
	int i = r.nextInt((10000-1000)+1)+1000;
	custIDFinal.append(custID);
	custIDFinal.append(i);
	custID = custIDFinal.toString();
}
/**
 * (method helps in determining whether or not there is a duplicate object by comparing customer ids)
 * @param (passes in a comparable customer object)
 * @return (returns a boolean value corresponding to whether or not they were equal)
 */ 

public boolean equals(Customer another)
{
	if(this.custID.equals(another.custID))
	{
		return true;
	}
	else
	{
		return false;
	}
}
/**
 * (method creates the string to be displayed)
 * @return (returns the string that is to be displayed)
 */ 

public String toString()
{
	String display = "Customer ID: " + custID + "\n" + name + "\n" + address + "\n" + city + ", " + state + " " + zip + "\n" + phone;
	return display;
}
}//end overall class