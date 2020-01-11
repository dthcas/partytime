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
		if(pp2.getAttribute("attractiveness")>1.8) {
			impression=pp1.getName()+" fell in love with "+pp2.getName();
		}
		else if(pp2.getAttribute("attractiveness")>1.4) {
			impression=pp1.getName()+" finds "+pp2.getName()+" quite attractive";
		}
		else if(pp2.getAttribute("attractiveness")>1.0) {
			impression=pp1.getName()+" has no feeling about "+pp2.getName();
		}
		else if(pp2.getAttribute("attractiveness")>0.5) {
			impression=pp1.getName()+" finds "+pp2.getName() + " quite unattractive";
		}
		else  {
			impression=pp2.getName()+" is creeped out by "+pp2.getName();
		}
		return impression;
	}
	//make it neater
	private void middledecides(Person p1, Person p2) {
		int p1id = p1.getId();
		int p2id = p2.getId();
		String p1n = p1.getName();
		String p2n = p2.getName();
		double p1i;  // how interested p1 is in p2's topic
		double p2i;  // how interested p2 is in p1's topic
		Topic p1t;	// the topic p1 talks about
		Topic p2t;	// the topic p2 talks about
		double p1ci = p1.getImpression(p2.getId()); // the current impression of p2
		double p2ci = p2.getImpression(p1.getId()); // the current impression of p1
		double p1ni; // the new impression of p2 by p1
		double p2ni; // the new impression of p1 by p2
		
		p1t = p1.speak();
		p2i = p2.listen(p1, p1t);
		System.out.println(p1n +" talks about "+p1t.getName());
		System.out.println(p1n +" says, \"" + p1t.getStatement(p1t.getInterest()) + "\"");
		System.out.println(p2n +" replies, \"" + p2.reply(p1t) + "\"");
		p2ni = p2ci*p2i*p1.getAttribute("charisma");
		p2.setImpression(p1id, (p2ni+p2ci)/2);
		
		
		if(p2ni>p2ci+0.1) {
			System.out.println(p2n+"  likes "+p1n+" more after that conversation.");//the pronoun still need to change
		}
		else if(p2ni > p2ci) {
			System.out.println(p2n + "feels a little better about " + p1n + " following their talk");
		}
		else if(p2ni > p2ci-0.1) {
			System.out.println(p2n + "lost some regard for " + p1n + "after talking");
		}
		else {
			System.out.println(p2n +" likes " + p1n + " much less after that conversation");
		}
		
		p2t = p2.speak();
		p1i = p1.listen(p2, p2t);
		System.out.println(p2.getName()+" talks about "+p2.speak().getName());
		System.out.println(p2.getName()+" says, \"" + p2t.getStatement(p2t.getInterest()) + "\"");
		System.out.println(p1.getName()+" replies, \"" + p1.reply(p2t) + "\"");
		p1ni = p1ci*p1i*p2.getAttribute("charisma");
		p1.setImpression(p2id, (p1ni+p1ci)/2);
		
		if(p1ni>p1ci+0.1) {
			System.out.println(p1n+"  likes "+p2n+" more after that conversation.");//the pronoun still need to change
		}
		else if(p1ni > p1ci) {
			System.out.println(p1n + "feels a little better about " + p2n + " following their talk");
		}
		else if(p1ni > p1ci-0.1) {
			System.out.println(p1n + "lost some regard for " + p2n + "after talking");
		}
		else {
			System.out.println(p1n +" likes " + p2n + " much less after that conversation");
		}
		
	}
	
	

	private static void enddecides(Person ppp1,Person ppp2) {
		double interestp1=ppp1.getImpression(ppp1.getId());
		double interestp2=ppp2.getImpression(ppp2.getId());
		//the down shows the different situation for different interest level
		if(interestp1>1.8) {
			
			if(interestp2>1.8) {
				System.out.print(ppp1.getName()+" and "+ppp2.getName()+" love each other");
			}
			else if(interestp2>1.2) {
				System.out.print(ppp1.getName()+" love "+ppp2.getName());
				System.out.print(ppp2.getName()+" found "+ppp1.getName()+" quite attractive");
			}
			else if(interestp2>0.6) {
				System.out.print(ppp1.getName()+" love "+ppp2.getName());
				System.out.print(ppp2.getName()+" is friend with "+ppp1.getName());
			}
			else if(interestp2>0.0) {
				System.out.print(ppp1.getName()+" love "+ppp2.getName());
				System.out.print(ppp2.getName()+" really hates "+ppp1.getName());
			}
		}
		else if(interestp1>1.2) {
			
			if(interestp2>1.8) {
				System.out.print(ppp2.getName()+" love "+ppp1.getName());
				System.out.print(ppp1.getName()+" found "+ppp2.getName()+" quite attractive");
			}
			else if(interestp2>1.2) {
				
				System.out.print(ppp2.getName()+" and "+ppp1.getName()+" both found each other wuite attractive");
			}
			else if(interestp2>0.6) {
				System.out.print(ppp1.getName()+" found "+ppp2.getName()+" quite attractive");
				System.out.print(ppp2.getName()+" is friend with "+ppp1.getName());
			}
			else if(interestp2>0.0) {
				System.out.print(ppp1.getName()+" found "+ppp2.getName()+" quite attractive");
				System.out.print(ppp2.getName()+" really hates "+ppp1.getName());
			}
		}
		else if(interestp1>0.6) {
			
			if(interestp2>1.8) {
				System.out.print(ppp2.getName()+" love "+ppp1.getName());
			System.out.print(ppp1.getName()+" is friend with "+ppp2.getName());
		}
		else if(interestp2>1.2) {
			System.out.print(ppp2.getName()+" found "+ppp1.getName()+" quite attractive");
			System.out.print(ppp1.getName()+" is friend with "+ppp2.getName());
		}
		else if(interestp2>0.6) {

			System.out.print(ppp2.getName()+" is friend with "+ppp1.getName());
		}
			else if(interestp2>0.0) {
				System.out.print(ppp1.getName()+" is friend with "+ppp2.getName());
				System.out.print(ppp2.getName()+" really hates "+ppp1.getName());
			}
		}
		else {
			if(interestp2>1.8) {
				System.out.print(ppp2.getName()+" love "+ppp1.getName());
				System.out.print(ppp1.getName()+" really hates "+ppp2.getName());
			}
			else if(interestp2>1.2) {
				System.out.print(ppp2.getName()+" found "+ppp1.getName()+" quite attractive");
				System.out.print(ppp1.getName()+" really hates "+ppp2.getName());
			}
			else if(interestp2>0.6) {
				System.out.print(ppp1.getName()+" really hates "+ppp2.getName());
				System.out.print(ppp2.getName()+" is friend with "+ppp1.getName());
			}
			else if(interestp2>0.0) {

				System.out.print(ppp2.getName()+" and "+ppp1.getName()+" really hates each other");
			}
		}
		
	}
	public void beginConversation() {
		status=true;

		int rand=(int)(Math.random()*2);
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