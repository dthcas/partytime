package partytime;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Import data = new Import();
		
		int p = 6;
		int t = 4;
		int m = 10;
		Person[] p_test = data.getPeople(p);
		Topic[] t_test = data.getTopics(t);
		Music[] m_test = data.getPlaylist(m);
		
		p = p_test.length;
		t = t_test.length;
		m = m_test.length;
		
		System.out.println("List of People");
		for(int i=0; i<p; i++) {
			System.out.println("Person "+(i+1)+" Name: "+p_test[i].getName()+" Age: "+ p_test[i].getAge() + " Statement: Test later");	
		}
		System.out.println("List of Topics");
		for(int i=0; i<t; i++) {
			System.out.println("Topic "+(i+1)+" Name: "+t_test[i].getName()+" Statement L"+(i+1)+": "+ t_test[i].getStatement(i%10));	
		}
		for(int i=0; i<m; i++) {
			System.out.println("List of Music");
			System.out.println("Song "+(i+1)+" Name: "+m_test[i].getTitle()+" Artist: "+ m_test[i].getArtist() + " Duration: " + m_test[i].getDuration());	
		}
		
		
	}

}
