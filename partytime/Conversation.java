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
	private static String begindecides(Person p1,Person p2) {
		String prefix = "[CONVERSATION::FIRST IMPRESSION] ";
		String impression;
		double p2a = p2.getAttribute("attractiveness");
		double p2c = p2.getAttribute("charisma");
		
		if(p2a>1.8) {
			impression=p1.getName()+" is mesmerized by "+p2.getName();
		}
		else if(p2a>1.6) {
			impression = p1.getName() + " thinks " + p2.getName() + " is dreamy";
		}
		else if(p2a>1.4) {
			impression = p1.getName() + " finds " + p2.getName() + " very attractive";
		}
		else if(p2a>1.2) {
			impression = p1.getName() + " smiles at " + p2.getName();
		}
		else if(p2a>1.0) {
			impression = p1.getName() + " thinks " + p2.getName() + " quite good looking";
		}
		else if(p2a>0.8) {
			impression=p1.getName()+" thinks "+p2.getName()+" seems nice";
		}
		else if(p2a>0.6) {
			impression=p1.getName()+" is not that attracted to "+p2.getName();
		}
		else if(p2a>0.4) {
			impression=p1.getName()+" finds "+p2.getName() + " quite unattractive";
		}
		else if(p2a>0.2) {
			impression = p1.getName() + " is quite repulsed by " + p2.getName();
		}
		else  {
			impression=p2.getName()+" avoids looking at "+p2.getName();
		}
		
		if((p2a>1 && p2c>1) || (p2a<1 && p2c<1)) impression += " and ";
		else impression += " but ";
		
		if(p2c>1.7) {
			impression += "extremely charming.";
		}
		else if(p2c>1.4) {
			impression += "thinks there is something very interesting about them.";
		}
		else if(p2c>1.0) {
			impression += "seems pretty cool.";
		}
		else if(p2c>0.6) {
			impression += "not so interesting.";
		}
		else if(p2c>0.3) {
			impression += "pretty boring.";
		}
		else {
			impression += "can't wait to talk to someone else.";
		}
		
		return prefix+impression;
	}
	//make it neater
	private void middledecides(Person p1, Person p2) {
		String prefix = new String("[CONVERSATION::JUDGEMENT] ");
		String output = new String("");
		String p1n = p1.getName();
		String p2n = p2.getName();
		double p2i;  // how interested p2 is in p1's topic
		Topic p1t;	// the topic p1 talks about
		double p1ci = p2.getImpression(p1); // the current impression of p1
		double p1ni; // the new impression of p1 by p2
		
		p1t = p1.speak();
		p2i = p2.listen(p1, p1t);
		System.out.println("[CONVERSATION::TOPIC] "+p1n +" talks about "+p1t.getName());
		System.out.println("\n\t"+p1n +" says, \"" + p1t.getStatement(p1t.getInterest()) + "\"");
		System.out.println("\t"+p2n +" replies, \"" + p2.reply(p1t) + "\"\n");
		p1ni = p2i*p1.getAttribute("charisma")*p1.getAttribute("intelligence");
		p2.setImpression(p1, (p1ni+p1ci)/2);
		
		if(p1ni>p1ci+0.1) {
			output += p2n+" likes "+p1n+" more after that conversation.";
		}
		else if(p1ni > p1ci) {
			output += p2n + " feels a little better about " + p1n + " following their talk";
		}
		else if(p1ni > p1ci-0.1) {
			output += p2n + " lost some regard for " + p1n + " after talking";
		}
		else {
			output += p2n +" likes " + p1n + " much less after that conversation";
		}
		
		System.out.println(prefix+output);
	}
	
	

	private static void enddecides(Person p1,Person p2) {
		String prefix = "[CONVERSATION::FINAL] ";
		String statement1 = new String("");
		String statement2 = new String("");
		double interestp1=p1.getImpression(p1);
		double interestp2=p2.getImpression(p2);
		String p1n = p1.getName();
		String p2n = p2.getName();
		//the down shows the different situation for different interest level
		if(interestp1>1.8) {
			
			if(interestp2>1.8) {
				statement1 += p1n+" and "+p2n+" love each other";
			}
			else if(interestp2>1.2) {
				statement1 += p1n+" loves "+p2n;
				statement2 += p2n+" found "+p1n+" quite attractive";
			}
			else if(interestp2>0.6) {
				statement1 += p1n+" loves "+p2n;
				statement2 += p2n+" is friends with "+p1n;
			}
			else if(interestp2>0.0) {
				statement1 += p1n+" loves "+p2n;
				statement2 += p2n+" really hates "+p1n;
			}
		}
		else if(interestp1>1.2) {
			
			if(interestp2>1.8) {
				statement1 += p1n+" finds "+p2n+" quite interesting";
				statement2 += p2n+" loves "+p1n;
			}
			else if(interestp2>1.2) {
				
				statement1 += p2n+" and "+p1n+" find each other quite interesting";
			}
			else if(interestp2>0.6) {
				statement1 += p1n+" finds "+p2n+" quite interesting";
				statement2 += p2n+" is okay with "+p1n;
			}
			else if(interestp2>0.0) {
				statement1 += p1n+" finds "+p2n+" quite interesting";
				statement2 += p2n+" really hates "+p1n;
			}
		}
		else if(interestp1>0.6) {
			
			if(interestp2>1.8) {
				statement1 += p1n+" is okay with "+p2n;
				statement2 += p2n+" loves "+p1n;
				
			}
			else if(interestp2>1.2) {
				statement1 += p1n+" is okay with "+p2n;
				statement2 += p2n+" finds "+p1n+" quite interesting";
				
			}
			else if(interestp2>0.6) {
	
				statement1 += p2n+"and "+p1n+" are okay with each other";
			}
			else if(interestp2>0.0) {
				statement1 += p1n+" is okay with "+p2n;
				statement2 += p2n+" really dislikes "+p1n;
			}
		}
		else {
			if(interestp2>1.8) {
				statement1 += p1n+" really dislikes "+p2n;
				statement2 += p2n+" loves "+p1n;
			}
			else if(interestp2>1.2) {
				statement1 += p1n+" really dislikes "+p2n;
				statement2 += p2n+" found "+p1n+" quite attractive";
			}
			else if(interestp2>0.6) {
				statement1 += p1n+" really dislikes "+p2n;
				statement2 += p2n+" is friends with "+p1n;
			}
			else if(interestp2>0.0) {
				statement1 += p2n+" and "+p1n+" really dislike each other";
			}
		}
		
		System.out.println(prefix+statement1);
		if(!statement2.equals("")) System.out.println(prefix+statement2);
		
	}
	public void beginConversation() {
		status=true;

		//int rand=(int)(Math.random()*2);
		System.out.println("[CONVERSATION] The conversation between "+p1.getName()+" and "+p2.getName()+" has started");
		System.out.println(begindecides(p1,p2));
		System.out.println(begindecides(p2,p1));

		//the upper tells their interests when there are no conversation begins
		//the down tells who start the conversation and who did the another likes it
		middledecides(p1, p2);
		middledecides(p2,p1);
	}
	
	public void endConversation() {
		System.out.println("[CONVERSATION] The conversation between "+p1.getName()+" and "+p2.getName()+" has ended");
		enddecides(p1,p2);
		
		status=false;
	}

}