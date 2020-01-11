package partytime;

import java.util.Random;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Import data = new Import();
		
		int p = 20;
		int t = 7;
		int m = 10;

		Person[] p_test = data.getPeople(p);
		Topic[] t_test = data.getTopics(t);
		Music[] m_test = data.getPlaylist(m);
		
		p = p_test.length;
		t = t_test.length;
		m = m_test.length;
		
		Topic[] p_topics;
		String fname;
		Topic speakTopic;
		
		System.out.println("\nList of People");
		for(int i=0; i<p; i++) {
			System.out.println("Person "+(i+1)+" Name: "+p_test[i].getName()+" Age: "+ p_test[i].getAge() + " Charisma: " + p_test[i].getAttribute("charisma"));
			fname = p_test[i].getName().substring(0, p_test[i].getName().indexOf(" "));
			System.out.print(fname+" can discuss topics ");
			p_topics = p_test[i].getTopics();
			for(int j=0; j<p_topics.length-1; j++) {
				if(j>0) System.out.print(", ");
				System.out.print(p_topics[j].getName()+" ("+p_topics[j].getInterest()+")");
			}
			System.out.print(" and "+p_topics[p_topics.length-1].getName()+" ("+p_topics[p_topics.length-1].getInterest()+")");
			speakTopic = p_test[i].speak();
			System.out.println("\n"+fname+" says \""+speakTopic.getStatement((int)(speakTopic.getInterest()*10))+"\"");
		}
		System.out.println("\nList of Topic Statements");
		for(int i=0; i<t; i++) {
			System.out.println("Topic "+(i+1)+": "+t_test[i].getName()+" Statement L"+(i+1)+": "+ t_test[i].getStatement(i%10));	
		}
		System.out.println("\nList of Topic Replies");
		for(int i=0; i<t; i++) {
			System.out.println("Topic "+(i+1)+": "+t_test[i].getName()+" Reply L"+(i+1)+": "+ t_test[i].getReply(i%10));	
		}
		System.out.println("\nList of Music");
		for(int i=0; i<m; i++) {
			System.out.println("Song "+(i+1)+": "+m_test[i].getTitle()+" by "+ m_test[i].getArtist() + " Duration: " + m_test[i].getDuration());	
		}
		
		
	}

}
