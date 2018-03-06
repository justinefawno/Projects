/** (This project gathers information of students and calculates grades then display them individually with all information)
 * @author (Justine Onnen)
 * @version (8)
*/ 
public abstract class Person {
	protected String name;
	protected ContactInfo contact;
	
	/** (this method determines whether or not one person object is equal to another)
	 * @param (passes in a comparable person object)
	 * @return (returns boolean value in relevance to whether the two objects were equal)
	 */ 
	public boolean equals(Person another)
	{
		if (this.name.equalsIgnoreCase(another.name))
			return true;
		else
			return false;
	}
	
	/** (this method creates a string for later displaying)
	 * @return (returns string for displaying purposes)
	 */ 
	public String toString()
	{
		String display = name + "\n" + contact.toString();
		return display;
	}
	
	/** (abstract method that calculates the grade: CE or CS major)
	 */ 
	public abstract void calcGrade();
	
	/** (abstract method that calculates the average: CE or CS major)
	 */
	public abstract void calcAvg();
}
