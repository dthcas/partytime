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
		double interests;
		double interests2;
		Topic p1t;	// the topic p1 talks about
		Topic p2t;	// the topic p2 talks about
		
		p1t = p1.speak();
		System.out.println(p1.getName()+" talks about "+p1t.getName());
		System.out.println(p1.getName()+" says, \"" + p1t.getStatement(p1t.getInterest()) + "\"");
		System.out.println(p2.getName()+" replies, \"" + p2.reply(p1t) + "\"");
		interests = p2.listen(p1, p1t);
		if(interests>1.2) {
			System.out.println(p2.getName()+"  likes "+p1t.getName()+" too.");//the pronoun still need to change
		}
		else if(interests>0.8) {
			System.out.println(p2.getName()+" pretends to listen but got distracted by something.");
		}
		else {
			System.out.println(p2.getName()+" yawns");
		}
		System.out.println(p2.getName()+" talks about "+p2.speak().getName());
		interests2=p1.listen(p2,p2.speak());
		p1.setImpression(p2.getId(),interests);
		if(interests>1.2) {
			System.out.println(p2.getName()+" says he likes "+prompt(p1).getName()+" too");//the pronoun still need to change
		}
		else if(interests>0.8) {
			System.out.println(p2.getName()+" pretend to listen but got distracted by something.");
		}
		else {
			System.out.println(p2.getName()+" yawns");
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