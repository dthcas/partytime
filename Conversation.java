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
	
	public Conversation(Person a, Person b,int dd,int l) {
		p1 = a;
		p2 = b;
		ID=dd;
		length = l;
		topics = new Topic[5];
	}
	
	public Topic prompt(Person p) {
		
		Topic t = p.speak();
		return(t);
	}
	private static String decides(Person pp1,Person pp2) {
		String impression;
		if(pp1.getInterestLevel(prompt(pp2).getName())>1.8) {
			impressions=pp1.getName+" fell in love with "+pp2.getName;
		}
		else if(pp1.getInterestLevel(prompt(pp2).getName())>1.4) {
			impressions=pp1.getName+" finds"+pp2.getName+"quite attractive";
		}
		else if(pp1.getInterestLevel(prompt(pp2).getName())>1.0) {
			impressions=pp1.getName+"has a no feeling about"+pp2.getName;
		}
		else if(pp1.getInterestLevel(prompt(pp2).getName())>0.5) {
			impressions=pp1.getName+"has bad feeling about"+pp2.getName;
		}
		else  {
			impressions=p2.getName+"really dislike"+p1.getName;
		}
		return impressions;
	}
	private
	
	public void beginConversation() {
		status=true;
		int rand=(Math.random()*2)(int);
		System.out.println("A conversation between "+p1.getName()+" and "+p2.getName()+" has started");
		
		System.out.println(decides(p1,p2));
		System.out.println(decides(p2,p1));
		System.out.println(p1.getName()+" talks about "+ prompt(p1).getName());
		//the upper tells their interests when there are no conversation begins
		//the down tells who start the conversation and who did the another likes it
		if(rand>1) {
			System.out.println(p1.getName()+" talks about "prompt(p1).getName());
			p2.updateInterestLevel(prompt(p2).getName(),p2.getInterestLevel(prompt(p1).getName()));
			if(p2.getInterestLevel(prompt(p1).getName())>1.2) {
				System.out.println(p2.getName()+" says he likes animals too.");//the pronoun still need to change
			}
			else if(p2.getInterestLevel(prompt(p1).getName())>0.8) {
				System.out.println(p2.getName()+" pretend to listen but got distracted by something.");
			}
			else {
				System.out.println(p2.getName()+" yawns");
			}
		}
		else {
			System.out.println(p1.getName()+" talks about "prompt(p1).getName());
			p2.updateInterestLevel(prompt(p2).getName(),p2.getInterestLevel(prompt(p1).getName()));
			if(p2.getInterestLevel(prompt(p1).getName())>1.2) {
				System.out.println(p2.getName()+" says he likes animals too");//the pronoun still need to change
			}
			else if(p2.getInterestLevel(prompt(p1).getName())>0.8) {
				System.out.println(p2.getName()+" pretend to listen but got distracted by something.");
			}
			else {
				System.out.println(p2.getName()+" yawns");
			}
		}
		
		
		
		
	}
	private static void enddecides(Person ppp1,Person ppp2) {
		double interestp1=ppp1.getInterestLevel(prompt(p1).getName());
		double interestp2=ppp2.getInterestLevel(prompt(p2).getName());

		if(interestp1>1.8) {
			
			if(interestp2>1.8) {
				System.out.print(ppp1.getName()+" and "ppp2.getName()+" love each other");
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
	
	public void endConversation() {
		System.out.print("The conversation between "+p1.getName()+" and "+p2.getName()+" has ended");
		enddecides(p1,p2);
		
		status=false;
	}

}