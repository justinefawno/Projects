import java.text.DecimalFormat;

/** (This project gathers information of students and calculates grades then display them individually with all information)
 * @author (Justine Onnen)
 * @version (8)
*/ 
public class Student extends Person implements Cloneable, Comparable<Student> {

	
	protected String widNumber;
	protected String major;
	protected int numTest;
	protected int [] score;
	protected double average;
	protected char letterGrade;
	//protected CS csMajor = new CS();
	//protected CE ceMajor = new CE();
	
	/** (this method compares 2 students objects widNumbers and checks to see if they are equal)
	 * @param (takes in a comparable student object's widNumber)
	 * @return (returns boolean value determined by whether the two widNumbers were equal)
	 */ 
	public boolean equals(Student another)
	{
		if(this.widNumber == another.widNumber)
			return true;
		else
			return false;
	}
	
	/** (this method creates a string for later displaying)
	 * @return (returns string for displaying purposes)
	 */ 
	public String toString()
	{		
		DecimalFormat df = new DecimalFormat("##.0");
		String display = super.toString() + "\n\nWID: " + widNumber + "\nMajor: " + major + "\nExam Average: " + df.format(average);
		return display;
	}
	
	public String getWidNumber()
	{
		return widNumber;
	}

	/** (This method calculates the average exam score of a student)
	 */ 
	public void calcAvg() {
		for (int i = 0; i < score.length; i++)
		{
			average += score[i];
		}
		average = average / score.length;
		
	}

	/** (this method compares the average of student objects)
	 * @param (brings in a comparable student object)
	 * @return (returns in based on how the averages compare)
	 */ 
	@Override
	public int compareTo(Student another) {
		
		if (this.average > another.average)
		{
			return 1;
		}else if (this.average < another.average)
		{
			return -1;
		}else
		{
			return 0;
		}
	}

	@Override
	public void calcGrade() {
		System.out.print("using student calc grade");
		
	}

}
