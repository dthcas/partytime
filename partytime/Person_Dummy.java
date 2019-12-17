// package partytime;

// Person class - To model a person who attends a party, interacts and forms opinions about the guests
// Please check https://github.com/dthcas/partytime/blob/master/Person.md for further references

import java.util.Random;

public class Person {

	// first declare all the variables
	private int age;
	private String name;
	private final int id;
	private final double humor, empathy, attractiveness, intelligence, charisma;
	private Impression[] impressions;
	private Topic[] topics;
	
	// the initial constructor
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
	
	// the retriever functions
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
	
	// the set functions
	public void setAge(int a) {
		this.age = a;
	}
	public void setName(String n) {
		this.name = n;
	}

	// returns a person `id`'s interest level regarding a topic `name`
	public double getInterestLevel(int id, String name) {
		// create a new party and all the necessary variables
		Party p = new Party();
		int lenI = this.impressions.length;
		int lenP = p.guests.length - 1;
		int resT = Person_Util.linearSearchTopic(this.topics, name);
		
		// remember to sort the array before binary search it
		// binary search is used because person array may be long (efficient)
		// then return the specific guest's topic's interest level
		Person[] guestsSorted = Person_Util.quickSortPerson(p.guests, 0, lenP);
		int resI = Person_Util.binarySearchPerson(guestsSorted, 0, lenI - 1, id);
		return p.guests[resI].getTopics()[resT].getInterest();
	}

	// updates a person `id`'s interest level regarding a topic `name`
	// by a token `tk` between 0 and 1, a ratio of increase or decrease
	public void updateInterestLevelManual(int id, String name, double tk) {
		// create a new party and all the necessary variables
		Party p = new Party();
		int lenI = this.impressions.length;
		int lenP = p.guests.length - 1;
		int resT = Person_Util.linearSearchTopic(this.topics, name);
		
		// remember to sort the array before binary search it
		// not explaining again why binary search is used (see l. 68)
		// check the percentage first before adding it
		Person[] guestsSorted = Person_Util.quickSortPerson(p.guests, 0, lenP);
		int resI = Person_Util.binarySearchPerson(guestsSorted, 0, lenI - 1, id);
		if (verifyPercentage(tk) {
			p.guests[resI].getTopics()[resT].setInterest(tk);
		} else {
			System.out.println("Please check your tk: between 0 and 1");
		}
	}
	
	// get the attributes - specifically the final variables - of a person
	// takes an argument to simplify the overlapped code
	public double getAttribute(String arg) {
		if (arg.toLowerCase().equals("humor")) return this.humor;
		if (arg.toLowerCase().equals("empathy")) return this.empathy;
		if (arg.toLowerCase().equals("attractiveness")) return this.attractiveness;
		if (arg.toLowerCase().equals("intelligence")) return this.intelligence;
		if (arg.toLowerCase().equals("charisma")) return this.charisma;
		return -1;
	}
	
	// takes a topic, a person speaking, and returns this user's interest level
	public double listen(Person p, Topic t) {
		return Math.sqrt(p.getInterestLevel(p.getId(), t.getName()) * ((attractiveness+intelligence+charisma)/3));
	}
	
	// judges a person based on how interesting while listening to his speech
	private void judge(Person pr, Topic t) {
		// create all the necessary variables
		double temp = listen(pr, t); Party p = new Party();
		
		// set the impressions by creating a new object,
		// initialize the impressions variable to an array with the length of the guests
		// set the impressions at a specific index, pre-set to the id of the person
		Impression i = new Impression(pr.getId(), temp, temp, temp);
		this.impressions = new Impression[p.guests.length];
		impressions[pr.getId()] = i;
	}
	
	// returns a random topic that the user knows about to awkwardly start a conversation
	public Topic speak() {
		return topics[(int) Math.random()*(topics.length-1)];
	}
	
	// updates the interest level of a topic `name`
	// if the boolean is true, means increase, otherwise it's decrease by token tk
	public void updateInterestLevel(String name, double tk, boolean upOrDown) {
		// create all the necessary variables
		int resT = Person_Util.linearSearchTopic(this.topics, name);
		
		// check whether to increase or decrease the percentage
		if (upOrDown) {
			this.getTopics()[resT].setInterestRatio(1 + tk);
		} else {
			this.getTopics()[resT].setInterestRatio(1 - tk);
		}
	}
	
	// returns the impression of a person of `id`
	public double getImpressionOfPerson(int id) {
		// create all the necessary variables
		Party p = new Party();
		int lenI = this.impressions.length;
		int lenP = p.guests.length - 1;
		
		// assumes that the impression of a person is situated
		// at the same index of the `guests` list:
		// after sorting + searching, return the value
		Person[] guestsSorted = Person_Util.quickSortPerson(p.guests, 0, lenP);
		int resI = Person_Util.binarySearchPerson(guestsSorted, 0, lenI - 1, id);
		return impressions[resI].getImpression(this, guestsSorted[resI]);
	}
	
	// sets the impression of a person `id` by token `tk` between 0 and 1
	public void setImpression(int id, double tk) {
		// create all the necessary variables
		Party p = new Party();
		int lenI = this.impressions.length; int lenP = p.guests.length - 1;
		
		// again, assumes that all the contents are ordered
		// changes the value of the impression by token `tk` between 0 and 1
		Person[] guestsSorted = Person_Util.quickSortPerson(p.guests, 0, lenP);
		int resI = Person_Util.binarySearchPerson(guestsSorted, 0, lenI - 1, id);
		this.impressions[resI].setImpression(tk);
	}
	
	// why the heck is this even here? Dammmmmmmmmn
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


// TODO Dummy classes for compiling

class Person_Impression {
	
	private int id; private double interesting, attractive, kind, chemistry;
	
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
	
	public static int partition(int arr[], int low, int high) { 
		int pivot = arr[high];
		int i = (low-1);
		
		for (int j=low; j<high; j++) { 
			if (arr[j] < pivot) { 
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp; 
			} 
		} 							

		int temp = arr[i+1];
		arr[i+1] = arr[high];
		arr[high] = temp; 
		
		return i+1; 
	} 
	
	// search for the FIRST topic with the name x
	public static int binarySearchPerson(Person arr[], int l, int r, int x) {
		Person[] arr2 = quickSortPerson(arr, 0, arr.length-1);
		if (r >= l) {
			// find the middle index
			// return the index if it fits the requirement
			// delete the half partition where the number won't be at through checking the value
			// otherwise, return the other half
			int mid = l + (r - l) / 2;
			int mid_id = arr2[mid].getId();
			if (mid_id == x) {
				return mid;
			}
			if (mid_id > x) {
				return binarySearchPerson(arr, l, mid - 1, x);
			}
			return binarySearchPerson(arr, mid + 1, r, x); 
		} 

		return -1; 
	}

	public static Person[] quickSortPerson(Person arr[], int low, int high) {
		int[] tmp = new int[arr.length];
		for (int i=0; i<tmp.length-1; i++) {
			tmp[i] = arr[i].getId();
		}
		if (low < high) { 
		    int pi = partition(tmp, low, high);
			quickSortPerson(arr, low, pi-1);
			quickSortPerson(arr, pi+1, high); 
		}

		return arr;
	} 

	public static int linearSearchTopic(Topic arr[], String name) { 
		int n = arr.length; 
		for(int i = 0; i < n; i++) {
			if (arr[i].equals(name)) return i;
		} 
		return -1; 
	} 
	
	// verify that if the attribute is in the right range between 0 and 2
	public static boolean verifyAttributes(double hm, double em, double at, double in, double ch) {
		// check whether any variable exceeds this border
		// otherwise return true
		if (hm > 2 || em > 2 || at > 2 || in > 2 || ch > 2 ||
				hm < 0 || em < 0 || at < 0 || in < 0 || ch < 0) {
			return false;
		} else {
			return true;
		}
		
	}
	
	// verify that the percentage given is between 0 and 1
	// else, print message and exit to prevent bugs if false
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
