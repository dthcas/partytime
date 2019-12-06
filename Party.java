package partytime;

public class Party {
	double start_time;
	double datetime;
	double end_time;
	int attendees = 0;
	Person [] guests;
	Conversation [] conversation;
	Music [] playlist;
	
	public void startParty() {
		
	}
	
	public void endParty() {
		
	}
	
	private boolean changeMusic() {
		return false;
	}
	
	public int getGuests() {
		attendees = guests.length;
		return attendees;
	}
	
	public boolean addGuest(Person p) {
		return false;
	}
	
	public static void main(String[] args) { 
		
	}
	
}
