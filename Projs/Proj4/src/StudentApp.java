/**
 * <Proj4.java>
 * <Justine Onnen / Mon-Wed-Fri / 9:30-10:45>
 *
 * <This project takes in student grades for sections of a class then calculates the overall weighted grade>
*/ 
import java.util.*;
public class StudentApp {
	public static void main(String[] args)
	{
	Scanner s = new Scanner(System.in);
	/*
	 * Instantiate an object that can be used to hold an array of student objects.
	-Read in the values for the current possible points for each category.
	-Calculate adjusted points for each category.
	do
	{ -Read in student’s name, WID and total score on labs, projects, exams, codelab, and final exam
 	-Create and store object in the array
 	-Enter Another?
	} while (your condition);
	-Loop through and use the toString method to display the output for each student 
	 */
	Student totalLabObj = new Student();
	
	
	Student[] students = new Student[20];
	System.out.print("Please enter the total possible points for the lab category: ");
	double totalLab = s.nextDouble();
	totalLabObj.setLab(totalLab);
	System.out.print("Please enter the total possible points for the project category: ");
	double totalProject = s.nextDouble();
	totalLabObj.setProject(totalProject);
	System.out.print("Please enter the total possible points for the exam category: ");
	double totalExam = s.nextDouble();
	totalLabObj.setExam(totalExam);
	System.out.print("Please enter the total possible points for the codelab category: ");
	double totalCodelab = s.nextDouble();
	totalLabObj.setCodelab(totalCodelab);
	System.out.print("Please enter the total possible points for the final exam: ");
	double totalFinalExam = s.nextDouble();	
	totalLabObj.setFinalExam(totalFinalExam);
	
	//HOW DO I CALCULATE THE ADJUSTED POINTS FOR EACH CATEGORY??????????
	String first, last, WID;
	double labScore, projectScore, examScore, codelabScore, finalExamScore;
	int i = 0;
	String decision;
	do
	{
		System.out.print("Please enter the student's first name: ");
		first = s.next();
		System.out.print("Please enter the student's last name: ");
		last = s.next();
		System.out.print("Please enter student's wildcat ID number: ");
		WID = s.next();
		System.out.print("Please enter student's total score on labs: ");
		labScore = s.nextDouble();
		System.out.print("Please enter student's total score on projects: ");
		projectScore = s.nextDouble();
		System.out.print("Please enter student's total score on exams: ");
		examScore = s.nextDouble();
		System.out.print("Please enter student's total score on codelab: ");
		codelabScore = s.nextDouble();
		System.out.print("Please enter student's total score on the final exam: ");
		finalExamScore = s.nextDouble();
		students[i] = new Student(first, last, WID, labScore, projectScore, examScore, codelabScore, finalExamScore);
		i++;
		System.out.print("Would you like to enter another students informatio? Y/N" );
		decision = s.next();
	}while(decision.equalsIgnoreCase("Y") && i < 20);
	//Set up some kind of if statement or loop that pauses toString method after each student is displayed: probably a for statement
	for (int y = 0; y < students.length; y++)
	{
		Student outputStudent = students[y];
		if (outputStudent == null)
		{
			break;
		}
		System.out.println(outputStudent.toString());
		System.out.println("Press enter to display the next students...");
		s.nextLine();
	}
	
	}//end main
}//end class
