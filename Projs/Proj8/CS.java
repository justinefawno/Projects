import java.text.DecimalFormat;

/** (This project gathers information of students and calculates grades then display them individually with all information)
 * @author (Justine Onnen)
 * @version (8)
*/ 
public class CS extends Student {

	protected double projectAvg;
	
	public CS()
	{
		projectAvg = 0.0;
	}
	
	public CS(ContactInfo contactInfo, String name, String widNumber, int [] score, double projAvg)
	{
		this.contact = contactInfo;
		this.name = name;
		this.widNumber = widNumber;
		this.score = score;
		projectAvg = projAvg;
		this.major = "CS";
	}
	
	
	/** (this method creates a string for later displaying)
	 * @return (returns string for displaying purposes)
	 */ 
	@Override
	public String toString()
	{
		DecimalFormat df = new DecimalFormat("##.0");
		String display = super.toString() + "\nProject Average: " + df.format(projectAvg) + "\nGrade: " + this.letterGrade;
		//name and contact info from abstract class
		//and WID, major, and exam average from super class
		//project average to 1 decimal
		//final letter grade
		return display;
	}
	
	/** (this method calculates the letter grade of CS students)
	 */ 
	@Override
	public void calcGrade()
	{
	
		if (average > 91.0 || (average > 89.0 && projectAvg > 92.0))
		{
			this.letterGrade = 'A';
		}else if (average > 81.0 || (average > 79.0 && projectAvg > 82.0))
		{
			this.letterGrade = 'B';
		}else if (average > 71.0 || (average > 69.0 && projectAvg > 72.0))
		{
			this.letterGrade = 'C';
		}else if (average > 61.0)
		{
			this.letterGrade = 'D';
		}else
		{
			this.letterGrade = 'F';
		}
	}
}
