/* Impression: A class which models a person's impressions of another person */

public class Impression{
	//testt
	private int id;
	private double interesting;
	private double attractive;
	private double kind;
	private double chemistry;
	private double overallimpression;
	
	public void setInteresting(double i) {
		interesting = i;
	}
	
	public void setAttractive(double a) {
		attractive = a;
	}
	
	public void setKind(double k) {
		kind = k;
	}

	public void setChemistry(double c) {

		chemistry = c;
	}	
	
	public double getImpression(Person person1, Person person2) {
		overallimpression = (interesting + attractive + kind + getChemistry(person1,person2))/4;
		return overallimpression;
	}
	
	
}
