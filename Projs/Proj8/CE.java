import java.text.DecimalFormat;

/** (This project gathers information of students and calculates grades then display them individually with all information)
 * @author (Justine Onnen)
 * @version (8)
*/ 
public class CE extends Student{
	protected double labAvg;
	
	public CE(ContactInfo contactInfo, String name, String widNumber, int [] score, double labAverage)
	{
		this.contact = contactInfo;
		this.name = name;
		this.widNumber = widNumber;
		this.score = score;
		labAvg = labAverage;
		this.major = "CE";
	}
	
	/** (this method creates a string for later displaying)
	 * @return (returns string for displaying purposes)
	 */ 
	@Override
	public String toString()
	{
		DecimalFormat df = new DecimalFormat("##.0");
		String display = super.toString() + "\nLab Average: " + df.format(labAvg);
		return display;
	}
	
	/** (this method calculates the letter grade of CE students)
	 */ 
	@Override
	public void calcGrade()
	{
		if (average > 89.0 || (average > 88.0 && labAvg > 90.0))
		{
			this.letterGrade = 'A';
		}else if (average > 79.0 || (average > 78.0 && labAvg > 80.0))
		{
			this.letterGrade = 'B';
		}else if (average > 69.0)
		{
			this.letterGrade = 'C';
		}else if(average > 59.0)
		{
			this.letterGrade = 'D';
		}else
		{
			this.letterGrade = 'F';
		}
	}
}
