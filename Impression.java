/* Impression: A class which models a person's impressions of another person */

public class Impression{
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
	
	public double getImpression() {
		overallimpression = (interesting + attractive + kind + getChemistry(id,id))/4;
		return overallimpression;
	}
	
	
}
