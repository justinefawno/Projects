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
import java.util.*;

public class PayrollApp {
	public static void main(String[] args) throws Exception {
		String nameEntered = "";
		int idNumberEntered = 0;
		double payRollEntered = 0;
		double hoursWorkedEntered = 0;
		String continuation;
		Scanner s = new Scanner(System.in);
		int overallCounter = 0;
		boolean anotherFound = false;
		int counterForFound = 0;
		ArrayList<Payroll> employees = new ArrayList<Payroll>(2);
		do {

			overallEntries(employees, s);
			System.out.print("Would you like to enter another employee? (Y/N): ");
			continuation = s.next();
			overallCounter++;
		} while (continuation.equalsIgnoreCase("Y"));

		System.out.println("Current contents of ArrayList...");
		for (

				int u = 0; u < employees.size(); u++) {
			System.out.println(employees.get(u).toString() + "\n");
		}

		System.out.print("Enter an ID number to delete corresponding record: ");
		int deletedEmployee = s.nextInt();
		deletionEmployee(deletedEmployee, employees);
		System.out.println("Employee with ID # " + deletedEmployee + " removed from ArrayList");
		System.out.print("Enter the info for final employee to be added to the list\n");
		// copy and paste all exceptions down here with .add function for arrayLIst
		overallEntries(employees, s);
		
		
		
		System.out.println("Final contents of ArrayList...");
		for (int p = 0; p < employees.size(); p++) {
			System.out.println(employees.get(p).toString() + "\n");
		} // displaying final contents of ArrayList

	}// end main class
	/**
	* (this method is to verify that the user entered a six digit number for the idNumber)
	* @param (this is the input that the user entered)
	*/ 
	public static void verifySixDigits(Integer input) throws Exception {
		if (input < 100000 || input > 999999) {
			throw new Exception("Number must be 6 digits.");
		}
	}
	/**
	* (this method is to verify that the user entered an integer for the idNumber)
	* @param (this is the input that the user entered)
	* @return (returns what was inputed)
	*/ 
	public static Integer verifyInteger(String input) throws Exception {
		try {
			return Integer.parseInt(input);
		} catch (Exception e) {
			throw new Exception("No characters allowed. Enter integers only.");
		}
	}
	/**
	* (this method is used to determine verify that the user is not entering a duplicate idNumber)
	* @param (this is the payroll object so that non duplicates can be verified)
	* @param (array of employees so that all others in array can be compared)
	*/ 
	public static void verifyNonDuplicate(Payroll num, ArrayList<Payroll> employees) throws Exception {

		for (Payroll existing : employees) {
			if (existing.equals(num)) {
				throw new Exception("ID already exists. Please re-enter.");
			}
		}
	}
	/**
	* (this method is used to delete the employee)
	* @param (id number that user entered to be deleted)
	* @param (array of employees so that search can be carried out))
	*/ 
	public static void deletionEmployee(int id, ArrayList<Payroll> employees) {
		for (int i = 0; i < employees.size(); i++) {
			int temp = employees.get(i).getID();
			if (temp == id) {
				employees.remove(i);
				break;
			}
		}
		
	}
	/**
	* (methods that contain all the verifications; cleaner code in main)
	* @param (array of employees)
	* @param (scanner object)
	*/ 
	public static void overallEntries(ArrayList <Payroll> employees, Scanner s)
	{
		String nameEntered = "";
		int idNumberEntered = 0;
		double payRollEntered = 0;
		double hoursWorkedEntered = 0;
		Payroll payroll = null;
		do {
			try {
				System.out.print("Enter employee's name: ");
				nameEntered = s.nextLine();
				if (nameEntered.length() == 0)
					throw new Exception();
			} catch (Exception e)// needs to catch if there is nothing entered
			{
				System.out.print("Name required. Please re-enter.");
			}
		} while (nameEntered.equals(""));

		boolean validID = false;
		do {
			try {
				System.out.print("Enter employee's ID #: ");
				String input = s.nextLine();
				Integer number = verifyInteger(input);
				verifySixDigits(number);
				payroll = new Payroll(nameEntered, number);
				verifyNonDuplicate(payroll, employees);
				
				validID = true;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} while (validID == false);


		try {
			System.out.print("Enter " + nameEntered + "'s pay rate: ");
			payRollEntered = s.nextDouble();
		} catch (Exception g) {
			System.out.println("No characters allowed. Enter doubles only.");
			s.next();
		} // also need to catch if pay rate is between 5 -99
		if (payRollEntered < 5 || payRollEntered > 99) {
			do {
				System.out.println("Payrate must be at least $5 and no more than $99.99");
				System.out.print("Enter " + nameEntered + "'s pay rate: ");
				payRollEntered = s.nextDouble();
			} while (payRollEntered < 5.0 || payRollEntered > 99.99);
		}

		try {
			System.out.print("Enter " + nameEntered + "'s hours worked: ");
			hoursWorkedEntered = s.nextDouble();

		} catch (Exception q) {
			System.out.println("No characters allowed. Enter doubles only.");
			s.next();
		} // also needs to be 0-80 inclusive
		if (hoursWorkedEntered > 81 || hoursWorkedEntered < 0) {
			do {
				System.out.println("Hours must be between 0-80 (inclusive): ");
				hoursWorkedEntered = s.nextDouble();
			} while (hoursWorkedEntered > 81 || hoursWorkedEntered < 0);
		}
		
		payroll.setHoursWorked(hoursWorkedEntered);
		payroll.setPayRate(payRollEntered);
		employees.add(payroll);
	}
}// end overall class
