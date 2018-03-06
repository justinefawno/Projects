/** (This project gathers information of students and calculates grades then display them individually with all information)
 * @author (Justine Onnen)
 * @version (8)
*/ 
public class ContactInfo {
	protected String address;
	protected String city;
	protected String  state;
	protected String  zip;
	protected String  mobilePhone;
	protected String homePhone;
	
	/** (this method creates a string for later displaying)
	 * @return (returns string for displaying purposes)
	 */ 
	public String toString()
	{
		String display = address + "\n" + city + ", " + state + " " + zip
				+ "\nMobile Phone: " + mobilePhone + "\nHome Phone: " + homePhone;
		return display;
	}
}
