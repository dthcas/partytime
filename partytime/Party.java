package partytime;

import java.util.*;

public class Party {
	double start_time;
	double datetime;
	double end_time;
	int attendees = 0;
	int max;
	int songs;
	Person [] guests;
	Conversation [] conversation;
	Playlist playlist;
	
	public void startParty() {
		Import ip = new Import();
		System.out.print("What is the maximum amount of people that can be in the party?");
		Scanner scan = new Scanner(System.in);
		max = scan.nextInt();
		System.out.print("How many songs will the party go for?");
		songs = scan.nextInt();
		
		guests = ip.getPeople(max);
		playlist = new Playlist(ip.getPlaylist(songs));
		
		System.out.print("The party has started");
	}
	
	private void changeMusic() {
		Music cur_song = this.playlist.getNextSong();
		System.out.println(cur_song.getTitle()+" by "+cur_song.getArtist()+" is now playing");
	}
	
	public int getGuests() {
		return attendees;
	}
	
	public void addGuest(Person p) {
		guests[attendees]=p;
	}
	
	public void conversation() {
		//p1
		boolean p1inconversation = true;
		while (p1inconversation==true) {
			int p1 = (int )(Math.random() * attendees + 1);
			p1inconversation = false;
			for (int i=0; i<attendees; i++) {
				if (guests[p1].equals(guests[i])) {
					p1inconversation = true;
				}
			}
		}
		//p2
		boolean p2inconversation = true;
		while (p2inconversation==true) {
			int p2 = (int )(Math.random() * attendees + 1);
			p2inconversation = false;
			for (int i=0; i<attendees; i++) {
				if (guests[p2].equals(guests[i])) {
					p2inconversation = true;
				}
			}
		}
		//Start conversation
	}
	
	public void endParty() {
		
	}
	
	public static void main(String[] args) { 
		
	}
	
}
