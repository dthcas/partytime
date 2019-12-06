package partytime;

public class Topic {
	private String name;
	private double interest;
	private double importance;
	
	public String getName()
	{
		return name;
	}
	
	public double getInterest()
	{
		return interest;
	}
	
	public void setInterest(double i)
	{
		interest = i;
	}
	
	public void setImportance(double i)
	{
		importance = i;
	}
	
	// Dependency for Person.java
	public void setInterestRatio(double tk) {this.interest *= tk;}

}
