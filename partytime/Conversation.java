package partytime;

/* Conversation

Variables:
	int ID
	boolean status for open or closed conversation
	Person p1
	Person p2
	int length
	Topic [] topics
..anything else??

Methods:
	public Topic prompt(Person p) asks a person to return a topic of conversation, which is returned
	public void beginConversation()  starts a conversation
	public void endConversation()  terminates a conversation
*/

public class Conversation {
	
	int ID;	
	boolean status;
	Person p1;
	Person p2;
	int length;
	Topic [] topics;
	
	public Conversation(Person a, Person b) {
		p1 = a;
		p2 = b;
		status = true;
		length = 0;
		topics = new Topic[5];
	}
	
	// Ask the person to return a topic of conversation
	public Topic prompt(Person p) {
		
		Topic t = p.speak();
		return(t);
	}
	
	public void beginConversation() {
		
		System.out.print("A conversation between "+p1.getName()+" and "+p2.getName()+" has started");
	}
	
	public void endConversation() {
		
		System.out.print("The conversation between "+p1.getName()+" and "+p2.getName()+" has ended");
	}

}