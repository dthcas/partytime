package partytime;

import java.util.*;

public class Party {
	double start_time;
	double datetime;
	double end_time;
	int attendees = 0;
	int max;
	int songs = 0;
	Person [] guests;
	Conversation [] conversations;
	int convo_num = 0;
	Playlist playlist;
	
	public Party() {;}
	public Party(int people, int songs) { this.attendees = people; this.songs = songs; }
	
	public void startParty() {
		Import ip = new Import();
		Scanner scan = new Scanner(System.in);
		if(this.attendees==0) {
			System.out.print("What is the maximum amount of people that can be in the party?");
			this.attendees = scan.nextInt();
		}
		if(this.songs==0) {
			System.out.print("How many songs will the party go for?");
			this.songs = scan.nextInt();
		}
		this.guests = ip.getPeople(this.attendees);
		this.attendees = this.guests.length;
		this.playlist = new Playlist(ip.getPlaylist(songs));
		this.songs = playlist.getSize();
		int total_convos = attendees*songs/2;
		this.conversations = new Conversation[total_convos];
		
		System.out.println("The party has started with "+this.attendees+" guests and "+this.songs+" songs to play");
		
		Person p1;
		Person p2;
		//main loop of conversations
		while(this.playlist.getCurrentSong()!=null) {
			
			for(int j=0; j<this.attendees/2; j++) {
				p1 = getFreeGuest();
				if(p1 != null) p1.startConversation();
				else continue;
				
				p2 = getFreeGuest();
				if(p2 != null) p2.startConversation();
				else continue;
				
				this.conversations[this.convo_num] = new Conversation(p1,p2,this.convo_num);
				System.out.println("Conversation "+(convo_num+1)+":");
				this.conversations[this.convo_num].beginConversation();
				this.conversations[this.convo_num].endConversation();
				this.convo_num++;
			}
			
			for(int k=0; k<attendees; k++) {
				
				this.guests[k].endConversation();
			}
			
			this.changeMusic();
		}
	}
	
	// Find a guest that isn't in a conversation
	private Person getFreeGuest() {
		
		int total = this.attendees;
		int index = (int) (Math.random()*total);
		int counter = 0;
		
		while(this.guests[index].isInConversation() && counter<=total*3) {
			index = (int) (Math.random()*total);
			counter++;
		}
		
		if(!this.guests[index].isInConversation()) return this.guests[index];
		else {
			for(int i=0; i<total; i++) {
				if(this.guests[i].isInConversation()==false) return this.guests[i];
			}
		}
		
		return null;
	}
	
	private void changeMusic() {
		Music cur_song = this.playlist.getNextSong();
		if(cur_song != null)
			System.out.println("** "+cur_song.getTitle()+" by "+cur_song.getArtist()+" is now playing **");
	}
	
	public int getGuests() {
		return attendees;
	}
	
	public void addGuest(Person p) {
		if (attendees<max) {
			guests[attendees]=p;
		}
		else {
			System.out.println("Opps, there is too many people in the party");
		}
	}
	
	/*public void conversation() {
		//p1
		boolean p1inconversation = true;
		int p1;
		int p2;
		while (p1inconversation==true) {
			p1 = (int)(Math.random() * attendees + 1);
			p1inconversation = false;
			for (int i=0; i<attendees; i++) {
				if (guests[p1].equals(guests[i])) {
					p1inconversation = true;
				}
				else {
					p1inconversation = false;
				}
			}
		}
		Person person1 = guests[p1];
		//p2
		boolean p2inconversation = true;
		while (p2inconversation==true) {
			p2 = (int)(Math.random() * attendees + 1);
			p2inconversation = false;
			for (int i=0; i<attendees; i++) {
				if (guests[p2].equals(guests[i])) {
					p2inconversation = true;
				}
				else {
					p2inconversation = false;
				}
			}
		}
		Person person2 = guests[p2];
		//Start conversation
		Conversation c1 = new Conversation(person1 , person2);
	} */
	
	public void endParty() {
		
		System.out.println("** The music stops, guests go home.. the party is over **");
		Person p;
		Person pi;
		Impression[] imp;
		
		for(int i=0; i<attendees; i++) {
			
			p = this.guests[i];
			imp = p.getImpressions();
			System.out.println(p.getName()+" had the following impressions of the guests: ");
			
			for(int j=0; j<imp.length; j++) {
				pi = getPerson(imp[j].getId());
				System.out.println("\t"+pi.getName()+": "+imp[j].getImpression());
			}
			
		}
		
	}
	
	public static void main(String[] args) { 
		
		Party p = new Party();
		p.startParty();
		p.endParty();
		
		return;
	}
	
	private Person getPerson(int id) {
		
		for(int i=0; i<this.attendees; i++) {
			if(guests[i].getId()==id) return guests[i];
		}
		
		return null;
	}
	
}
