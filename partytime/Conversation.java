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
	
	public Conversation(Person a, Person b,int idd) {
		p1 = a;
		p2 = b;
		ID=idd;

	}
	public int getID() {
		return ID;
	}
	
	public static Topic prompt(Person p) {
		
		Topic t = p.speak();
		return(t);
	}
	private static String begindecides(Person pp1,Person pp2) {
		String impression;
		double p2a = pp2.getAttribute("attractiveness");
		
		if(p2a>1.8) {
			impression=pp1.getName()+" fell in love with "+pp2.getName();
		}
		else if(p2a>1.2) {
			impression = pp1.getName() + " thinks " + pp2.getName() + " is dreamy";
		}
		else if(p2a>0.8) {
			impression=pp1.getName()+" finds "+pp2.getName()+" quite attractive";
		}
		else if(p2a>0.5) {
			impression=pp1.getName()+" has no feeling about "+pp2.getName();
		}
		else if(p2a>0.3) {
			impression=pp1.getName()+" finds "+pp2.getName() + " quite unattractive";
		}
		else  {
			impression=pp2.getName()+" is creeped out by "+pp2.getName();
		}
		return impression;
	}
	//make it neater
	private void middledecides(Person p1, Person p2) {
		String p1n = p1.getName();
		String p2n = p2.getName();
		double p2i;  // how interested p2 is in p1's topic
		Topic p1t;	// the topic p1 talks about
		double p2ci = p2.getImpression(p1); // the current impression of p1
		double p2ni; // the new impression of p1 by p2
		
		p1t = p1.speak();
		p2i = p2.listen(p1, p1t);
		System.out.println(p1n +" talks about "+p1t.getName());
		System.out.println(p1n +" says, \"" + p1t.getStatement(p1t.getInterest()) + "\"");
		System.out.println(p2n +" replies, \"" + p2.reply(p1t) + "\"");
		p2ni = p2ci*p2i*p1.getAttribute("charisma");
		p2.setImpression(p1, (p2ni+p2ci)/2);
		
		if(p2ni>p2ci+0.1) {
			System.out.println(p2n+" likes "+p1n+" more after that conversation.");//the pronoun still need to change
		}
		else if(p2ni > p2ci) {
			System.out.println(p2n + " feels a little better about " + p1n + " following their talk");
		}
		else if(p2ni > p2ci-0.1) {
			System.out.println(p2n + " lost some regard for " + p1n + " after talking");
		}
		else {
			System.out.println(p2n +" likes " + p1n + " much less after that conversation");
		}
		
	}
	
	

	private static void enddecides(Person p1,Person p2) {
		double interestp1=p1.getImpression(p1);
		double interestp2=p2.getImpression(p2);
		String p1n = p1.getName();
		String p2n = p2.getName();
		//the down shows the different situation for different interest level
		if(interestp1>1.8) {
			
			if(interestp2>1.8) {
				System.out.println(p1n+" and "+p2n+" love each other");
			}
			else if(interestp2>1.2) {
				System.out.println(p1n+" loves "+p2n);
				System.out.println(p2n+" found "+p1n+" quite attractive");
			}
			else if(interestp2>0.6) {
				System.out.println(p1n+" love "+p2n);
				System.out.println(p2n+" is friend with "+p1n);
			}
			else if(interestp2>0.0) {
				System.out.println(p1n+" love "+p2n);
				System.out.println(p2n+" really hates "+p1n);
			}
		}
		else if(interestp1>1.2) {
			
			if(interestp2>1.8) {
				System.out.println(p2n+" loves "+p1n);
				System.out.println(p1n+" finds "+p2n+" quite interesting");
			}
			else if(interestp2>1.2) {
				
				System.out.println(p2n+" and "+p1n+" find each other quite interesting");
			}
			else if(interestp2>0.6) {
				System.out.println(p1n+" finds "+p2n+" quite interesting");
				System.out.println(p2n+" is okay with "+p1n);
			}
			else if(interestp2>0.0) {
				System.out.println(p1n+" finds "+p2n+" quite interesting");
				System.out.println(p2n+" really hates "+p1n);
			}
		}
		else if(interestp1>0.6) {
			
			if(interestp2>1.8) {
				System.out.println(p2n+" loves "+p1n);
				System.out.println(p1n+" is okay with "+p2n);
			}
			else if(interestp2>1.2) {
				System.out.println(p2n+" finds "+p1n+" quite interesting");
				System.out.println(p1n+" is okay with "+p2n);
			}
			else if(interestp2>0.6) {
	
				System.out.println(p2n+"and "+p1n+" are okay with each other");
			}
			else if(interestp2>0.0) {
				System.out.println(p1n+" is okay with "+p2n);
				System.out.println(p2n+" really dislikes "+p1n);
			}
		}
		else {
			if(interestp2>1.8) {
				System.out.println(p2n+" love "+p1n);
				System.out.println(p1n+" really dislikes "+p2n);
			}
			else if(interestp2>1.2) {
				System.out.println(p2n+" found "+p1n+" quite attractive");
				System.out.println(p1n+" really dislikes "+p2n);
			}
			else if(interestp2>0.6) {
				System.out.println(p1n+" really dislikes "+p2n);
				System.out.println(p2n+" is friend with "+p1n);
			}
			else if(interestp2>0.0) {

				System.out.println(p2n+" and "+p1n+" really dislike each other");
			}
		}
		
	}
	public void beginConversation() {
		status=true;

		//int rand=(int)(Math.random()*2);
		System.out.println("The conversation between "+p1.getName()+" and "+p2.getName()+" has started");
		System.out.println(begindecides(p1,p2));
		System.out.println(begindecides(p2,p1));

		//the upper tells their interests when there are no conversation begins
		//the down tells who start the conversation and who did the another likes it
		middledecides(p1, p2);
		middledecides(p2,p1);
	}
	
	public void endConversation() {
		System.out.println("The conversation between "+p1.getName()+" and "+p2.getName()+" has ended");
		enddecides(p1,p2);
		
		status=false;
	}

}