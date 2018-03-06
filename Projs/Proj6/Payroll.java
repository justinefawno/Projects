/**
* (this project is allowing the user to enter information for as many employees as they want and calculating the gross pay of those employees; also allows user to remove employees)
* @author (Justine Onnen)
* @version (6)
*/
/*
 * Justine Onnen
 * Project 6
 * Professor Lang
 * 9:30-10:45
 * Due: October 27th 2017
 */
public class Payroll {
	private String name;
	private int idNumber;
	private double payRate;
	private double hoursWorked;
	private double grossPay;
	public Payroll()
	{
		
	}
	/**
	* (this method is for setting the nameEntered to the name and same with idNumber)
	* @param (user inputed name)
	* @param (user inputed id number)
	*/ 
	public Payroll(String nameEntered, int idNumEntered)
	{
		name = nameEntered;
		idNumber = idNumEntered;
	}
	/**
	* (this method determines whether or not there is duplicate id numbers)
	* @param (another payroll object used for comparison)
	* @return (returns boolean true false depending on whether the id numbers were equilivant)
	*/ 
	public boolean equals(Payroll another)
	{
		if(this.idNumber == another.idNumber)
			return true;
		else
			return false;
	}
	/**
	* (this method is creating the string for display purposes; method also calculates gross pay for object)
	* @return (returns the string made for displaying later)
	*/ 
	public String toString()
	{
		if (hoursWorked > 40)
		{
			double overtime = hoursWorked - 40;
			grossPay = (payRate * 40) + (overtime * (payRate*1.5));
			
		}
		else
		{
			grossPay = hoursWorked * payRate;
		}
		
		String display = name + "\n" + "ID#" + idNumber + "\nGross Pay - $" + grossPay;
		return display;
	}
	/**
	* (this method set the hours worked in the payrollapp class)
	* @param (this is the user inputed hours worked)
	*/ 
	public void setHoursWorked(double hw)
	{
		hoursWorked = hw;
	}
	/**
	* (this method sets the pay rate in the payrollapp class)
	* @param (this is the user inputed pay rate)
	*/ 
	public void setPayRate(double pr)
	{
		payRate = pr;
	}
	/**
	* (this method gives the payrollapp class the idnumber)
	* @return (returns the id number for use in the payrollapp class)
	*/ 
	public int getID()
	{
		return idNumber;
	}
	
}//end overall class
