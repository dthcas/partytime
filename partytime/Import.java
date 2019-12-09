package partytime;
/* Import.java will allow a class to import various data from CSV files to allow for people, conversations and topics */

import java.io.*;
import java.util.ArrayList;
import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;

public class Import {
	
	public static Person[] getPeopleFromCSV(int num, String fileName) throws IOException {
		
		// find the path to the file and create an instance of BufferedReader
		BufferedReader br = new BufferedReader(new FileReader("imports\\people.csv"));

		// create a new list of people for returning to user
		Person [] pList = new Person[num];
		// make an arraylist to hold all people from the file.  This way we can 
		// choose random people from the list instead of the same first few.
		ArrayList<Person> allPeople = new ArrayList<>();
		// read the first line from the text file
		String line = br.readLine();

		// temp person information variables
		int p_id,p_age;
		Double p_hm, p_em, p_at, p_in, p_ch;
		int lineNum=1;

		// loop until all lines are read
		while (line != null) {

			if(lineNum++==1) continue; // Ignore the first line and increment the line number

			// use string.split to load a string array with the values from
			// each line of the file, using a comma as the delimiter
			String[] values = line.split(",");
			if(values.length!=8) {
				System.out.print("Please check input file "+fileName);
				return pList;
			}
			p_id = Integer.parseInt(values[0]);
			p_age = Integer.parseInt(values[2]);
			p_hm = Double.parseDouble(values[3]);
			p_em = Double.parseDouble(values[4]);
			p_at = Double.parseDouble(values[5]);
			p_in = Double.parseDouble(values[6]);
			p_ch = Double.parseDouble(values[7]);

			// adding this new person into ArrayList of all people
			allPeople.add(new Person(p_age,values[1],p_id,p_hm,p_em,p_at,p_in,p_ch));

			// read next line before looping
			// if end of file reached, line would be null
			line = br.readLine();
		}

		br.close(); // close the file reader

		int ap_size = allPeople.size();
		int p_index;
        
		for(int i=0; i<num && i<ap_size; i++) {
			p_index = (int) (Math.random()*(ap_size-1));
			pList[i] = allPeople.get(p_index);
			allPeople.remove(p_index);
			ap_size--;
		}
		
		return pList;
	}

	
	public static Topic[] getTopicsFromCSV(int num, String fileName) throws IOException {
		
		// find the path to the file and create an instance of BufferedReader
		BufferedReader br = new BufferedReader(new FileReader(fileName));

		// create a new list of people for returning to user
		Topic [] tList = new Topic[num];
		// make an arraylist to hold all people from the file.  This way we can 
		// choose random people from the list instead of the same first few.
		ArrayList<Topic> allTopics = new ArrayList<>();
		// read the first line from the text file
		String line = br.readLine();

		// temp person information variables
		String t_name,t_l1,t_l2,t_l3,t_l4,t_l5,t_l6,t_l7,t_l8,t_l9,t_l10;
		int lineNum=1;
		String [] t_statements = new String[10];

		// loop until all lines are read
		while (line != null) {

			if(lineNum++==1) continue; // Ignore the first line and increment the line number

			// use string.split to load a string array with the values from
			// each line of the file, using a comma as the delimiter
			String[] values = line.split(",");
			if(values.length!=11) {
				System.out.print("Please check input file "+fileName);
				return tList;
			}
			t_name = values[0];
			for(int i=0; i<10; i++) {
				t_statements[i] = values[i+1];
			}

			// adding this new person into ArrayList of all people
			allTopics.add(new Topic(t_name,t_statements));

			// read next line before looping
			// if end of file reached, line would be null
			line = br.readLine();
		}

		br.close(); // close the file reader

		int at_size = allTopics.size();
		int t_index;
        
		for(int i=0; i<num && i<at_size; i++) {
			t_index = (int) (Math.random()*(ap_size-1));
			tList[i] = allTopics.get(t_index);
			allTopics.remove(t_index);
			at_size--;
		}
		
		return tList;
	}	
	
}
