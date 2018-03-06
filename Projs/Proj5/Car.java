/**
 * (this project lets a user input information to find and calculate work tickets for a car shop)
 * @author (Justine Onnen)
 * @version (5)
*/ 
public class Car {
private String VIN;
private String make;
private String model;
private int year;
/**
 * (sets all variables to default in case user does not enter values)
 */ 

public Car()
{
	VIN = "unintialized";
	make = "unintialized";
	model = "unintialized";
	year = 0;
}
/**
 * (sets all data gathered from the user to corresponding variables)
 * @param (VIN number of car)
 * @param (make of the car)
 * @param (model of the car)
 * @param (year of the car)
 */ 

public Car(String vinNum, String makeCar, String modelCar, int yearCar)
{
	VIN = vinNum;
	make = makeCar;
	model = modelCar;
	year = yearCar;
}
/**
 * (method helps in determining whether or not there is a duplicate object by comparing car objects)
 * @param (passes in a comparable car object)
 * @return (returns a boolean value corresponding to whether or not they were equal)
 */ 

public boolean equals(Car another)
{
	if(this.VIN.equals(another.VIN))
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
	String display = ("Vin #: " + VIN + "\n" + year + " " + make + " " + model);
	return display;
}
}//end overall class
