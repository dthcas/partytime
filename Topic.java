public class Topic {
	private String name;
	private double interest;
	private double importance;
	public Topic()
	{
		
	}
	public Topic(String x)
	{
		name=x;
		interest = 1;
	}
	public Topic(String x, int y)
	{
		name=x;
		importance=y;
	}
	public String getName()
	{
		return name;
	}
	
	public double getInterest()
	{
		return interest;
	}
	
	public void setIn0terest(double i)
	{
		interest = i;
	}
	
	public void setImportance(double i)
	{
		importance = i;
	}

}
