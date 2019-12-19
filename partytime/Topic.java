package partytime;

public class Topic {
	private String name;
	private double interest;
	private double importance;
	private String [] statements; // List of statements about topic
	private String [] replies; // List of responses
	
	public Topic(String t_name, String[] t_statements, String[] t_replies) {
		
		name = t_name;
		statements = t_statements;
		replies = t_replies;
	}
	
	public String getName()
	{
		return name;
	}
	
	public double getInterest()
	{
		return interest;
	}
	
	public String getStatement(int i) {
		int x = i;
		
		if(i<0) x = 0;
		else if(i>9) x = 9;
		System.out.println(this.statements[x].toString());
		return this.statements[x];
	}

	public String getReply(int i) {
		int x = i;
		
		if(i<0) x = 0;
		else if(i>9) x = 9;
		
		return this.replies[x];
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
