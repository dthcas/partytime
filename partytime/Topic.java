package partytime;

public class Topic {
	private String name;
	private int interest;
	private double importance;
	private String [] statements; // List of statements about topic
	private String [] replies; // List of responses
	
	public Topic(Topic t) { this.name = t.name; this.interest = t.getInterest();
							this.importance = t.getImportance(); 
							this.statements = t.statements;
							this.replies = t.replies;
	}
	public Topic(String t_name, String[] t_statements, String[] t_replies) {
		
		this.name = t_name;
		this.statements = t_statements;
		this.replies = t_replies;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public int getInterest()
	{
		return this.interest;
	}
	
	public double getImportance()
	{
		return importance;
	}
	
	public String getStatement(int i) {
		int x = i;
		
		if(i<0) x = 0;
		else if(i>9) x = 9;
		
		if(this.statements.length-1 < x) x = this.statements.length-1;

		return this.statements[x].toString();
	}

	public String getReply(int i) {
		int x = i;
		
		if(i<0) x = 0;
		else if(i>9) x = 9;
		
		if(this.replies.length-1 < x) x = this.replies.length-1;
		
		return this.replies[x].toString();
	}
	
	public void setInterest(int i)
	{
		this.interest = i;
	}
	
	public void setImportance(double i)
	{
		this.importance = i;
	}
	
	// Dependency for Person.java
	public void setInterestRatio(double tk) {this.interest *= tk;}

}
