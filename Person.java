package partytime;

// Person class - To model a person who attends a party, interacts and forms opinions about the guests
// Please check https://github.com/dthcas/partytime/blob/master/Person.md for further references

import java.util.Random;

public class Person {

	private int age; private String name; private final int id;
	private final double humor, empathy, attractiveness, intelligence, charisma;
	private Person_Impression[] impressions; private Person_Topic[] topics;
	
	public Person(int age, String name, int id, double hm, double em, double at, double in, double ch) {
		this.age = age; this.name = name; this.id = id;
		this.humor = hm; this.empathy = em; this.attractiveness = at;
		this.intelligence = in; this.charisma = ch;
	}
	
	public int getAge() {return this.age;}
	public String getName() {return this.name;}
	public int getId() {return this.id;}
	public Person_Impression[] getImpressions() {return this.impressions;}
	public Person_Topic[] getTopics() {return this.topics;}
	
	public void setAge(int a) {this.age = a;}
	public void setName(String n) {this.name = n;}

	public double getInterestLevel(int id, String name) {
		Party p = new Party();
		int lenT = this.topics.length, lenI = this.impressions.length;
		int resT = Person_Util.binarySearchTopic(this.topics, 0, lenT - 1, name);
		int resI = Person_Util.binarySearchImpression(p.guests, 0, lenI - 1, id);
		return p.guests[resI].getTopics()[resT].getInterest();
	}
	
	public void updateInterestLevel(int id, String name, double tk) {
		Party p = new Party();
		int lenT = this.topics.length; int lenI = this.impressions.length;
		int resT = Person_Util.binarySearchTopic(this.topics, 0, lenT - 1, name);
		int resI = Person_Util.binarySearchImpression(p.guests, 0, lenI - 1, id);
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
	
	public double getImpression(int id, String topic) {
		return 0.0;
	}
	
	public void updateImpression(int id, String name, double tk) {
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


// TODO Dummy classes for compiling

class Person_Impression {
	
	private int id; private double interesting, attractive, kind, chemistry;
	
	public double getImpression() {return new Random().nextDouble();}
	
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
	public void setImportance(double i) {this.importance = i;}
	
}

// TODO Utility tools for clean workspace

class Person_Util {
	
	public static int binarySearchTopic(Person_Topic arr[], int l, int r, String x) { 
		if (r >= l) { 
        	int mid = l + (r - l) / 2; 
        	if (arr[mid].getName().compareTo(x) == 0) return mid; 
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

	
}
