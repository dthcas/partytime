package partytime;

/* 	Chemistry
	Add some comments here
	public static double getChemistry(Person p1, Person p2) returns the chemistry value for two people, based on some mystical, magical quality that the universe decides.  Value between 0 and 2.
*/

public class Chemistry {
	public static double getChemistry(Person p1, Person p2){
		double chemistry = Math.random();
		if(p1.getAge()-p2.getAge()<=5)chemistry += Math.random();
		return chemistry;
	}
}