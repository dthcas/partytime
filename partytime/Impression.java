package partytime;

/* Impression: A class which models a person's impressions of another person */

public class Impression {
	private int id;
	private double interesting;
	private double attractive;
	private double kind;
	private double chemistry;
	private double overallimpression;
	
	public Impression(int i_id, double i_interesting, double i_attractive, double i_kind){
		id = i_id;
		interesting = i_interesting;
		attractive = i_attractive;
		kind = i_kind;
	}
	
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
	
	public double getChemistry() {
		
		return this.chemistry;
	}
	
	public int getId() {
		return this.id;
	}
	
	public double getImpression() {
		this.overallimpression = (this.interesting + this.attractive + this.kind + this.chemistry)/4;
		return overallimpression;
	}
	
	public void setImpression(double tk) {overallimpression *= tk;}
	
}
