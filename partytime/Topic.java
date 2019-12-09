package partytime;

public class Topic {
	private final String name;
	private double interest;
	private double importance;
	private final String [] statements; // List of statements about topic
	private final String [] responses; // List of responses
	
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
