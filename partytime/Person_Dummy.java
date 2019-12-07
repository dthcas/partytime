package partytime;

// This class is a dummy file if you can't read the original, compressed version which I prefer to use
// This class may also be behind the compressed file by around two commits. Please wait patiently.
// Person class - To model a person who attends a party, interacts and forms opinions about the guests
// Please check https://github.com/dthcas/partytime/blob/master/Person.md for further references

import java.util.Random;

public class Person {

	private int age;
	private String name;
	private final int id;
	private final double humor, empathy, attractiveness, intelligence, charisma;
	private Impression[] impressions;
	private Topic[] topics;

	// constructor method
	public Person(int age, String name, int id, double hm, double em, double at, double in, double ch) {
		this.age = age;
		this.name = name;
		this.id = id;
		this.humor = hm;
		this.empathy = em;
		this.attractiveness = at;
		this.intelligence = in;
		this.charisma = ch;
		if (!Person_Util.verifyAttributes(hm, em, at, in, ch)) {
			System.out.print("Please check all final variables are between 0 and 2!");
			System.exit(0);
		}
	}

	// retriever methods
	public int getAge() {
		return this.age;
	}

	public String getName() {
		return this.name;
	}

	public int getId() {
		return this.id;
	}

	public Impression[] getImpressions() {
		return this.impressions;
	}

	public Topic[] getTopics() {
		return this.topics;
	}

	// updater methods
	public void setAge(int a) {
		this.age = a;
	}

	public void setName(String n) {
		this.name = n;
	}

	// returns the interest level of a specific topic
	public double getInterestLevel(int id, String name) {
		// create a new party object and lengths
		Party p = new Party();
		int lenT = this.topics.length
		int lenI = this.impressions.length;
		// loop through the users and the user's topics
		int resT = Person_Util.binarySearchTopic(this.topics, 0, lenT - 1, name);
		int resI = Person_Util.binarySearchImpression(p.guests, 0, lenI - 1, id);
		// get the topics and then return it
		Topic guest_topic = p.guests[resI].getTopics()[resT];
		guest_topic.getInterest();
	}

	public void updateInterestLevelManual(int id, String name, double tk) {
		// create a new party object and lengths
		Party p = new Party();
		int lenT = this.topics.length;
		int lenI = this.impressions.length;
		// loop through the users and the user's topics
		int resT = Person_Util.binarySearchTopic(this.topics, 0, lenT - 1, name);
		int resI = Person_Util.binarySearchImpression(p.guests, 0, lenI - 1, id);
		// get the topics and then change it
		Topic guest_topic = p.guests[resI].getTopics()[resT];
		guest_topic.setInterest(tk);
	}

	// a combined function of attributes
	// all attributes are final variables; reads an argument
	public double getAttribute(String arg) {
		if (arg.toLowerCase().equals("humor")) {
			return this.humor;
		}
		if (arg.toLowerCase().equals("empathy")) {
			return this.empathy;
		}
		if (arg.toLowerCase().equals("attractiveness")) {
			return this.attractiveness;
		}
		if (arg.toLowerCase().equals("intelligence")) {
			return this.intelligence;
		}
		if (arg.toLowerCase().equals("charisma")) {
			return this.charisma;
		}
		return -1;
	}

	// listen to a conversation; returns interest level (double)
	public double listen(Person p, Person_Topic t) {
		// determine the factor through self's attrs
		double factor = (attractiveness + intelligence + charisma)/3);
		return Math.sqrt(p.getInterestLevel(p.getId(), t.getName()) * factor);
	}

	private void judge(Person p, Topic t) {
		// TODO finish this sometime :/
	}

	// choose a random topic to start another conversation
	public Topic speak() {
		return topics[(int) Math.random() * (topics.length-1)];
	}

	// update the interest level of a topic; automated
	// differenciates the manual method from that the user is already given here
	public void updateInterestLevel(String name, double tk, boolean upOrDown) {
		// extract variables
		int lenT = this.topics.length;
		Person_Util.verifyPercentage(tk);
		int resT = Person_Util.binarySearchTopic(this.topics, 0, lenT - 1, name);
		Topic current_topic = this.getTopics()[resT];
		// increase or decrease the ratio
		if (upOrDown) {
			current_topic.setInterestRatio(1 + tk);
		} else {
			current_topic.setInterestRatio(1 - tk);
		}
	}

	// get the impression of a person
	public double getImpression(int id) {
		// create a new party and impression object and lengths
		Party p = new Party();
		Impression i = new Impression();
		int lenI = this.impressions.length;
		int resI = Person_Util.binarySearchImpression(p.guests, 0, lenI - 1, id);
		// return after finalized variables
		return i.getImpression(this, p.guests[resI]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


// TODO Dummy classes for compiling
// not elaborating on the comments here

class Person_Impression {

	private int id;
	private double interesting, attractive, kind, chemistry;

	public void setInteresting(double i) {
		this.interesting = i;
	}

	public void setAttractive(double a) {
		this.attractive = a;
	}

	public void setKind(double k) {
		this.kind = k;
	}

	public void setChemistry(double c) {
		this.chemistry = c;
	}

}

class Person_Topic {

	private String name; private double interest, importance;

	public String getName() {
		return this.name;
	}

	public double getInterest() {
		return this.interest;
	}

	public double getImportance() {
		return this.importance;
	}

	public void setInterest(double i) {
		this.interest = i;
	}

	public void setInterestRatio(double tk) {
		this.interest *= tk;
	}

	public void setImportance(double i) {
		this.importance = i;
	}

}

// TODO Utility tools for clean workspace

class Person_Util {
	
	public static int binarySearchTopic(Topic arr[], int l, int r, String x) { 
		if (r >= l) { 
			int mid = l + (r - l) / 2; 
			if (arr[mid].getName().compareTo(x) == 0) {
				return mid;
			}
			if (arr[mid].getName().compareTo(x) > 0) {
				return binarySearchTopic(arr, l, mid - 1, x); 
			}
            return binarySearchTopic(arr, mid + 1, r, x); 
        } 
        return -1; 
    } 
	
	public static int binarySearchImpression(Person arr[], int l, int r, int x) { 
		if (r >= l) { 
			int mid = l + (r - l) / 2; 
			if (arr[mid].getId() == x) return mid; 
			if (arr[mid].getId() > x) {
				return binarySearchImpression(arr, l, mid - 1, x); 
			}
			return binarySearchImpression(arr, mid + 1, r, x); 
        }
		return -1; 
	} 

	public static boolean verifyAttributes(double hm, double em, double at, double in, double ch) {
		if (hm > 2 || em > 2 || at > 2 || in > 2 || ch > 2 || hm < 0 || em < 0 || at < 0 || in < 0 || ch < 0) {
			return false;
		} else {
			return true;
		}
	}
	
	public static boolean verifyPercentage(double pt) {
		if (0 <= pt && pt <= 1) {
			return true;
		} else {
			System.out.println("Please check your range again! 0 <= x <= 1");
			System.exit(0);
			return false;
		}
	}
	
}
