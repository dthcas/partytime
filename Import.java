/* Import.java will allow a class to import various data from CSV files to allow for people, conversations and topics */

import java.io.*;
import java.util.ArrayList;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Import {
	
	public static Person[] getPeopleFromCSV(int num, String fileName) throws IOException {
		
		// find the path to the file
		Reader fr = new FileReader("people.csv"); 
		// create an instance of BufferedReader
        BufferedReader br = new BufferedReader(fr);
        
        // create a new list of people for returning to user
        Person [] pList = new Person[num];
        // make an arraylist to hold all people from the file.  This way we can 
        // choose random people from the list instead of the same first few.
        ArrayList<Person> allPeople = new ArrayList<>();
        String name; int age;
        // read the first line from the text file
        String line = br.readLine();
        
        // temp person information variables
        int p_id,p_age;
        String p_name; 
        Double p_hm, p_em, p_at, p_in, p_ch;
        
        // loop until all lines are read
        while (line != null) {

        	// use string.split to load a string array with the values from
        	// each line of the file, using a comma as the delimiter
        	String[] values = line.split(",");
        	if(values.length<8) {
        		System.out.print("Please check input file "+fileName);
        		return pList;
        	}
        	p_id = Integer.parseInt(values[0]);
        	p_name = values[1];
        	p_age = Integer.parseInt(values[2]);
        	p_hm = Double.parseDouble(values[3]);
        	p_em = Double.parseDouble(values[4]);
        	p_at = Double.parseDouble(values[5]);
        	p_in = Double.parseDouble(values[6]);
        	p_ch = Double.parseDouble(values[7]);
        	Person p = new Person(p_age,p_name,p_id,p_hm,p_em,p_at,p_in,p_ch);

        	// adding this new person into ArrayList of all people
        	allPeople.add(p);

            // read next line before looping
            // if end of file reached, line would be null
            line = br.readLine();
        }
        
        int ap_size = allPeople.size();
        int p_index;
        
		for(int i=0; i<num; i++) {
			p_index = (int) (Math.random()*(ap_size-1));
			pList[i] = allPeople.get(p_index);
			allPeople.remove(p_index);
			ap_size--;
		}
		
		return pList;
	}
	
	
	
}