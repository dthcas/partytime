// package partytime;

// Person class - To model a person who attends a party, interacts and forms opinions about the guests
// Please check https://github.com/dthcas/partytime/blob/master/Person.md for further references

import java.util.Random;

public class Person {

	private int age; private String name; private final int id;
	private final double humor, empathy, attractiveness, intelligence, charisma;
	private Impression[] impressions; private Topic[] topics;
	
	public Person(int age, String name, int id, double hm, double em, double at, double in, double ch) {
		this.age = age; this.name = name; this.id = id;
		this.humor = hm; this.empathy = em; this.attractiveness = at;
		this.intelligence = in; this.charisma = ch;
		if (!Person_Util.verifyAttributes(hm, em, at, in, ch)) {
			System.out.print("Please check all final variables are between 0 and 2!");
			System.exit(0);
		}
	}
	
	public int getAge() {return this.age;}
	public String getName() {return this.name;}
	public int getId() {return this.id;}
	public Impression[] getImpressions() {return this.impressions;}
	public Topic[] getTopics() {return this.topics;}
	
	public void setAge(int a) {this.age = a;}
	public void setName(String n) {this.name = n;}

	public double getInterestLevel(int id, String name) {
		Party p = new Party();
		int lenI = this.impressions.length; int lenP = p.guests.length - 1;
		int resT = Person_Util.linearSearchTopic(this.topics, name);
		Person[] guestsSorted = Person_Util.quickSortPerson(p.guests, 0, lenP);
		int resI = Person_Util.binarySearchPerson(guestsSorted, 0, lenI - 1, id);
		return p.guests[resI].getTopics()[resT].getInterest();
	}

	public void updateInterestLevelManual(int id, String name, double tk) {
		Party p = new Party();
		int lenI = this.impressions.length; int lenP = p.guests.length - 1;
		int resT = Person_Util.linearSearchTopic(this.topics, name);
		Person[] guestsSorted = Person_Util.quickSortPerson(p.guests, 0, lenP);
		int resI = Person_Util.binarySearchPerson(guestsSorted, 0, lenI - 1, id);
		p.guests[resI].getTopics()[resT].setInterest(tk);
	}
	
	public double getAttribute(String arg) {
		if (arg.toLowerCase().equals("humor")) return this.humor;
		if (arg.toLowerCase().equals("empathy")) return this.empathy;
		if (arg.toLowerCase().equals("attractiveness")) return this.attractiveness;
		if (arg.toLowerCase().equals("intelligence")) return this.intelligence;
		if (arg.toLowerCase().equals("charisma")) return this.charisma;
		return -1;
	}
	
	public double listen(Person p, Topic t) {
		return Math.sqrt(p.getInterestLevel(p.getId(), t.getName()) * ((attractiveness+intelligence+charisma)/3));
	}
	
	private void judge(Person p, Topic t) {
		
	}
	
	public Topic speak() {
		return topics[(int) Math.random()*(topics.length-1)];
	}
	
	public void updateInterestLevel(String name, double tk, boolean upOrDown) {
		int resT = Person_Util.linearSearchTopic(this.topics, name);
		if (upOrDown) {this.getTopics()[resT].setInterestRatio(1 + tk);}
		else {this.getTopics()[resT].setInterestRatio(1 - tk);}
	}
	
	public double getImpressionOfPerson(int id) {
		Party p = new Party();
		int lenI = this.impressions.length; int lenP = p.guests.length - 1;
		Person[] guestsSorted = Person_Util.quickSortPerson(p.guests, 0, lenP);
		int resI = Person_Util.binarySearchPerson(guestsSorted, 0, lenI - 1, id);
		return impressions[resI].getImpression(this, guestsSorted[resI]);
	}
	
	// under construction
	public void setImpression(int id, double tk) {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


// TODO Dummy classes for compiling

class Person_Impression {
	
	private int id; private double interesting, attractive, kind, chemistry;
	
	public void setInteresting(double i) {this.interesting = i;}
	public void setAttractive(double a) {this.attractive = a;}
	public void setKind(double k) {this.kind = k;}
	public void setChemistry(double c) {this.chemistry = c;}
	
}

class Person_Topic {
	
	private String name; private double interest, importance;
	
	public String getName() {return this.name;}
	public double getInterest() {return this.interest;}
	public double getImportance() {return this.importance;}
	
	public void setInterest(double i) {this.interest = i;}
	public void setInterestRatio(double tk) {this.interest *= tk;}
	public void setImportance(double i) {this.importance = i;}
	
}

// TODO Utility tools for clean workspace

class Person_Util {
	
	public static int partition(int arr[], int low, int high) { 
		int pivot = arr[high]; int i = (low-1); 
		for (int j=low; j<high; j++) { 
			if (arr[j] < pivot) { 
				i++; int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp; 
			} 
		} 							

		int temp = arr[i+1]; arr[i+1] = arr[high]; arr[high] = temp; 
		return i+1; 
	} 
	
	public static int binarySearchPerson(Person arr[], int l, int r, int x) {
		Person[] arr2 = quickSortPerson(arr, 0, arr.length-1);
		if (r >= l) { 
			int mid = l + (r - l) / 2; 
			if (arr2[mid].getId() == x) return mid; 
			if (arr2[mid].getId() > x) return binarySearchPerson(arr, l, mid - 1, x);
			return binarySearchPerson(arr, mid + 1, r, x); 
		} 

		return -1; 
	}

	public static Person[] quickSortPerson(Person arr[], int low, int high) {
		int[] tmp = new int[arr.length];
		for (int i=0; i<tmp.length-1; i++) {tmp[i] = arr[i].getId();}
		if (low < high) { 
		    int pi = partition(tmp, low, high);
			quickSortPerson(arr, low, pi-1); quickSortPerson(arr, pi+1, high); 
		}

		return arr;
	} 

	public static int linearSearchTopic(Topic arr[], String name) { 
		int n = arr.length; 
		for(int i = 0; i < n; i++) {if (arr[i].equals(name)) return i;} 
		return -1; 
	} 

	public static boolean verifyAttributes(double hm, double em, double at, double in, double ch) {
		if (hm > 2 || em > 2 || at > 2 || in > 2 || ch > 2 ||
				hm < 0 || em < 0 || at < 0 || in < 0 || ch < 0) return false;
		else return true;
	}
	
	public static boolean verifyPercentage(double pt) {
		if (0 <= pt && pt <= 1) return true;
		else {
			System.out.println("Please check your range again! 0 <= x <= 1");
			System.exit(0); return false;
		}
	}
	
}
