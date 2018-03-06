/**
 * <Proj4.java>
 * <Justine Onnen / Mon-Wed-Fri / 9:30-10:45>
 *
 * <This project takes in student grades for sections of a class then calculates the overall weighted grade>
*/
public class Student {
private String firstName;
private String lastName;
private String wildcatID;
private double pointsLab;
private double pointsProject;
private double pointsExam;
private double pointsCodelab;
private double pointsFinalExam;
private double overallScore;
private double totalPoints;
private char finalGrade;
private static double totalLab;
private static double totalProject;
private static double totalExam;
private static double totalCodelab;
private static double totalFinalExam;
private double labWeight = 0.15;
private double projectWeight = 0.15;
private double examWeight = 0.30;
private double finalExamWeight = 0.30;
private double codelabWeight = 0.10;
private double totalAdjLab;
private double totalAdjProject;
private double totalAdjExam;
private double totalAdjCodelab;
private double totalAdjFinalExam;
private double earnedLab;
private double earnedProject;
private double earnedCodelab;
private double earnedExam;
private double earnedFinalExam;
private double totalAdjPoints;
private double totalEarnedPoints;
private int numOfStudents;
	//A default no-argument constructor to initialize a Student object to the following default values:
	//first/last name = "no name entered", WID = “no WID” / all numeric values explicitly to zero
public Student()
{
firstName = "no name entered";
lastName = "no name entered";
wildcatID = "no WID";
}//end default constructor

	//An 8-argument constructor to initialize a Student object to values passed-in for first & last name, WID
	//and student’s total, adjust/ed or adj % scores on labs, projects, exams, codelab, and final exam. (Overall
	//% is calculated) 
public Student(String first, String last, String WID,  double labScore, double projectScore, double examScore, double codelabScore, double finalExamScore)
{
	firstName = first;
	lastName = last;
	wildcatID = WID;
	pointsLab = labScore;
	pointsProject = projectScore;
	pointsExam = examScore;
	pointsCodelab = codelabScore;
	pointsFinalExam = finalExamScore;
}
	//A private method that ONLY calculates the weighted overall % for the student and stores in the proper
	//data property for a student object. Do not read in input or write output within this method
private void calcWeighted(/*double totLab, double totProject, double totExam, double totCodelab, double totFinalExam*/)
/** calcWeighted
 * (this method calculated the overall percentage of the student's grade)
 */ 
{
	totalPoints = totalLab + totalProject + totalExam + totalCodelab + totalFinalExam;
	totalAdjLab = totalPoints * labWeight;
	totalAdjProject = totalPoints * projectWeight;
	totalAdjExam = totalPoints * examWeight;
	totalAdjCodelab = totalPoints * codelabWeight;
	totalAdjFinalExam = totalPoints * finalExamWeight;
	earnedLab = (pointsLab / totalLab) * totalAdjLab;
	earnedProject = (pointsProject / totalProject) * totalAdjProject;
	earnedCodelab = (pointsCodelab / totalCodelab) * totalAdjCodelab;
	earnedExam = (pointsExam / totalExam) * totalAdjExam;
	earnedFinalExam = (pointsFinalExam / totalFinalExam) * totalAdjFinalExam;
	totalAdjPoints = totalAdjLab + totalAdjProject + totalAdjExam + totalAdjCodelab + totalAdjFinalExam;
	totalEarnedPoints = earnedLab + earnedProject + earnedCodelab + earnedExam + earnedFinalExam;
	overallScore = totalEarnedPoints / totalAdjPoints;
}//end calculation for the weighted grade
/** toString
 * (this method decides the letter grade of the overall percent and makes a string to be later displayed)
 * @return (a string to do final display is being returned)
 */ 

public String toString()
{
	calcWeighted();
	overallScore = overallScore * 100.0;
	if (overallScore > 89.5)
	{
		finalGrade = 'A';
	}
	else if (overallScore > 79.5)
	{
		finalGrade = 'B';
	}
	else if (overallScore > 69.5)
	{
		finalGrade = 'C';
	}
	else if (overallScore > 59.5)
	{
		finalGrade = 'D';
	}
	else
	{
		finalGrade = 'F';
	}
	//NEED TO CALCULATE WHAT LETTER GRADE IT IS
	String display;
	/*
	 * Student Name: Jones, Bob
	WID: 123456789
	Overall %: 79.5%
	Final Grade: B 
	 */
	//USE A LINE SPLIT SOMEHOW TO PUT THIS ON DIFFERENT LINE??
	display = ("Student name: " + lastName + ", " + firstName + "\nWID: " + wildcatID + "\nOverall %: " + overallScore + "\nFinal Grade: " + finalGrade);
	return display;
}
/** setLab
 * (this method is passing the total points possible for the lab category)
 *
 * @param (this is the total points possible for the lab category)
 */ 
public void setLab(double totLabPoint)
{
	totalLab = totLabPoint;
}
/** setProject
 * (this method is passing the total points possible for the project category)
 *
 * @param (this is the total points possible for the project category)
 */ 
public void setProject(double totProjectPoint)
{
	totalProject = totProjectPoint;
}
/** setExam
 * (this method is passing the total points possible for the exam category)
*
* @param (this is the total points possible for the exam category)
*/ 
public void setExam(double totExamPoint)
{
	totalExam = totExamPoint;
}
/** setCodelab
 * (this method is passing the total points possible for the codelab category)
 *
 * @param (this is the total points possible for the codelab category)
 */ 
public void setCodelab(double totCodelabPoint)
{
	totalCodelab = totCodelabPoint;
}
/** setFinalExam
 * (this method is passing the total points possible for the final exam category)
 *
 * @param (this is the total points possible for the final exam category)
 */ 
public void setFinalExam(double totFinalExamPoint)
{
	totalFinalExam = totFinalExamPoint;
}

}
