
/**
 * (this project lets a user input information to find and calculate work tickets for a car shop)
 * @author (Justine Onnen)
 * @version (5)
*/ import java.util.*;
/*
 * Justine Onnen
 * Project 5
 * Dennis Lang
 * M W F 9:30-10:45
 * This program is to produce a work ticket for a mechanic workshop
 */
/**
 * (this method declares all needed variables)
 */ 
public class ServiceQuote {
	private String quoteNum;
	private double partsCharges;
	private double laborCharges;
	private double SALESTAX = 0.065;
	private double totalCharge;
	private double salesTaxCharge;
	private String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private int letter1Space, letter2Space;
	StringBuilder quoteNumBuild = new StringBuilder();
	Random r = new Random();

	/**
	 * (this method sets variables equal to defaults in case the user does not input what they need to)
	 */ 
public ServiceQuote()
{
	quoteNum = "unintialized";
	partsCharges = 0.0;
	laborCharges = 0.0;
}
/**
 * (this method create the quote num identifier and sets the labor and part charges)
 * @param (passes in the parts charge)
 * @param (passes in the labor charge)
 */ 
public ServiceQuote(double partCharge, double laborCharge)
{
	letter1Space = r.nextInt(26);
	letter2Space = r.nextInt(26);
	quoteNumBuild.append(alphabet.charAt(letter1Space));
	quoteNumBuild.append(alphabet.charAt(letter2Space));
	int n = 10000 - 1000 + 1;
	int i = r.nextInt() % n;
	int appendNum = 1000 + i;
	quoteNumBuild.append(appendNum);
	quoteNum = quoteNumBuild.toString();
	partsCharges = partCharge;
	laborCharges = laborCharge;
}
/**
 * (this method helps determine whether or not their is a duplicate)
 * @param (passes in a comparable ServiceQuote object)
 * @return (returns a boolean value based on whether the values were equal or not)
 */ 
public boolean equals(ServiceQuote another)
{
	if(this.quoteNum.equals(another.quoteNum))
	{
		return true;
	}
	else
	{
		return false;
	}
}
/**
 * (this method creates a string to be displayed)
 * @return (returns the string that is to be displayed)
 */ 
public String toString()
{
	String resultSalesTax;
	if (partsCharges == 0)
	{
		resultSalesTax = getSalesTax("0");
	}
	else
		resultSalesTax = getSalesTax();
	
	
	String display = ("Quote Number: " + quoteNum + "\n Parts: " + partsCharges + "\n Labor Charges: " + laborCharges + "\n Sales Tax: " + resultSalesTax + "\n Total estimated expenses: " + totalCharge);
	return display;
}
/**
 * (this method determines the sales tax)
 * @param (string that tells the method that there is no sales tax)
 * @return (returns a string of 0)
 */ 
private String getSalesTax(String a)
{
	salesTaxCharge = 0;
	a = "0";
	return a;
	//this is an overloaded method
}
/**
 * (this method determines the sales tax)
 * @return (returns sales tax)
 */
private String getSalesTax()
{
	double findCharges = partsCharges + laborCharges;
	findCharges = findCharges * SALESTAX;
	String sendCharges = Double.toString(findCharges);
	return sendCharges;
}
/**
 * (gets the total estimated charges)
 * @return (returns the total charges)
 */ 
private double getTotalCharges()
{
	totalCharge = salesTaxCharge + partsCharges + laborCharges;
	return totalCharge;
}
	
	
	
	
	
	
	
}//end overall class
