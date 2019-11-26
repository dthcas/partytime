/*Person
Variables:   
•	int age
•	String name
•	private final int id
•	private final double empathy
•	private final double attractiveness
•	private final double intelligence
•	private final double charisma
•	private Impression [] impressions
•	Topic [] topics

Methods:
•	public int getAge()
•	public void setAge(int a)
•	public String getName()
•	public void setName(String n)
•	public double getInterestLevel(String name) – takes the name of a topic and returns how interested that person is from 0 to 2
•	public double listen(Person p, Topic t) – takes a person speaking and the topic they are speaking about and returns a score based on their interest and empathy settings from 0 to 2.
•	private void judge(Person p, Topic t) – forms an internal Impression about that person from the topic they are talking about and their non-verbal attributes.
•	private void updateInterestLevel(String name, double factor) – if someone is very interesting or compelling, then its possible that a person may update their own interest in that topic by a factor from 0.7 to 1.3 (+/- 30%). By the same token, if someone really is negative, then they may decrease a person’s enjoyment of that topic.
•	public Topic speak() – return a topic to talk about in a conversation.
•	public double getAttractiveness()
•	public Impression getImpression(int i) – takes an ID of a person and returns the impression of that person
*/
