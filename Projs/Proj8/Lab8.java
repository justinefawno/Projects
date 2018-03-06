/** (This project gathers information of students and calculates grades then display them individually with all information)
 * @author (Justine Onnen)
 * @version (8)
*/ 
import java.util.*;

public class Lab8 {
	public static void main (String[] args) {
		ArrayList <Student> students = new ArrayList <Student> ();
		String userInput = "";
		Scanner s = new Scanner(System.in);
		
		
		do {
			//how do I assign properties that are not in the student class but in the aggregated class of the super of the student class
			//Student newStudent = new Student();
			ContactInfo contactInfo = new ContactInfo();
			System.out.print("Enter in student name: ");
			String name = s.nextLine();
			System.out.print("Enter in student address: ");
			contactInfo.address = s.nextLine();
			System.out.print("Enter in city: ");
			contactInfo.city = s.nextLine();
			System.out.print("Enter in state: ");
			contactInfo.state = s.nextLine();
			System.out.print("Enter in zip: ");
			contactInfo.zip = s.nextLine();
			System.out.print("Enter in mobile phone number (or 'none'): ");
			contactInfo.mobilePhone = s.nextLine();
			System.out.print("Enter in home phone number (or 'none'): ");
			contactInfo.homePhone = s.nextLine();
			System.out.print("Enter in WID #: ");
			String widNumber = s.nextLine();
			System.out.print("Enter in major (CS or CE): ");
			String major = s.nextLine();
			
			if (major.equalsIgnoreCase("CS"))
			{
				
				System.out.print("Enter in number of exams: ");
				int numTest = s.nextInt();
				int [] score = new int [numTest];
				System.out.print("Enter in average on all progamming projects: ");
				double projectAvg = s.nextDouble();
				//newStudent.csMajor.projectAvg = s.nextDouble();
				for (int i = 0; i < numTest; i++)
				{
					System.out.print("Enter in exam score " + (i+1) + ": ");
					score[i] = s.nextInt();
				}
				CS csMajor = new CS(contactInfo, name, widNumber, score, projectAvg);
				students.add(csMajor);//adds new student into arraylist
			}//end case for CS major
			else {
				System.out.print("Enter in number of exams: ");
				int numTest = s.nextInt();
				int [] score = new int [numTest];
				System.out.print("Enter in average on all Lab projects: ");
				double labAvg = s.nextDouble();
				//temp.ceMajor.labAvg = s.nextDouble();
				for (int i = 0; i < numTest; i++)
				{
					System.out.print("Enter in exam score " + (i+1) + ": ");
					score[i] = s.nextInt();
				}
				CE ceMajor = new CE(contactInfo, name, widNumber, score, labAvg);
				students.add(ceMajor);//adds new student into arraylist
			}//end case for CE major
			
			System.out.print("Enter another student? (Y/N): ");
			userInput = s.next();
			
		}while(userInput.equalsIgnoreCase("Y"));
		
		for(int i = 0; i < students.size(); i++) //should display all information
		{
			System.out.println();
			students.get(i).calcAvg();
			students.get(i).calcGrade();
			System.out.println(students.get(i).toString());			
		}
		
		
		
		for (int i = 0; i < students.size()-1; i ++)
		{
			if (students.get(i).equals(students.get(i+1)))
			{
				System.out.println("Duplicate found");
				break;
			}
		}
		
	
		
	}//end main
}//end class
