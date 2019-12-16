package partytime;
/* Import.java will allow a class to import various data from CSV files to allow for people, conversations and topics */

import java.io.*;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.net.URL;
//import java.nio.charset.StandardCharsets;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;

public class Import {
	
	private static ArrayList<Person> allPeople;
	private static ArrayList<Topic> allTopics;
	private static ArrayList<Music> allMusic;
	
	public ArrayList<Person> getAllPeople() {return this.allPeople;}
	
	public Import() {
		
		File pdir = new File("partytime/imports/people.csv");
		File tdir = new File("partytime/imports/topics.csv");
		File mdir = new File("partytime/imports/music.csv");
		
		try {
			getPeopleFromCSV(pdir.getAbsolutePath());
			getTopicsFromCSV(tdir.getAbsolutePath());
			getMusicFromCSV(mdir.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		  }
		
	}
	
	public void getPeopleFromCSV(String fileName) throws IOException {
		
		// find the path to the file and create an instance of BufferedReader
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		
		// create a new list of people for returning to user
		// make an arraylist to hold all people from the file.  This way we can 
		// choose random people from the list instead of the same first few.
		//ArrayList<Person> allPeople = new ArrayList<>();
		// read the first line from the text file
		String line = br.readLine();
		System.out.println("Reading line: "+line);
		// temp person information variables
		int p_id,p_age;
		Double p_hm, p_em, p_at, p_in, p_ch;
		int lineNum=1;

		// loop until all lines are read
		while (line != null) {

			if(lineNum==1) { lineNum++; line = br.readLine(); }// Ignore the first line and increment the line number
			System.out.println("Reading line: "+line);
			// use string.split to load a string array with the values from
			// each line of the file, using a comma as the delimiter
			String[] values = line.split(",");
			if(values.length!=8) {
				System.out.print("Please check input file "+fileName);
				return;
			}
			p_id = Integer.parseInt(values[0]);
			p_age = Integer.parseInt(values[2]);
			p_hm = Double.parseDouble(values[3]);
			p_em = Double.parseDouble(values[4]);
			p_at = Double.parseDouble(values[5]);
			p_in = Double.parseDouble(values[6]);
			p_ch = Double.parseDouble(values[7]);

			// adding this new person into ArrayList of all people
			Import.allPeople.add(new Person(p_age,values[1],p_id,p_hm,p_em,p_at,p_in,p_ch));

			// read next line before looping
			// if end of file reached, line would be null
			line = br.readLine();
		}

		br.close(); // close the file reader
		
		return;
	}
	
	// Returns a list of people generated from the master list of all people imported.
	// Does so by making a clone of the master list then removing people from it and adding it to
	// a regular array.
	
	public Person[] getPeople(int num) {
		
		Person [] pList = new Person[num];
		ArrayList<Person> cloneList = new ArrayList<Person>(allPeople);
		
		int ap_size = cloneList.size();
		int p_index;
        
		for(int i=0; i<num && i<ap_size; i++) {
			p_index = (int) (Math.random()*(ap_size-1));
			pList[i] = cloneList.get(p_index);
			cloneList.remove(p_index);
			ap_size--;
		}
		
		return pList;
	}

	
	private void getTopicsFromCSV(String fileName) throws IOException {
		
		// find the path to the file and create an instance of BufferedReader
		BufferedReader br = new BufferedReader(new FileReader(fileName));

		// make an arraylist to hold all people from the file.  This way we can 
		// choose random people from the list instead of the same first few.
		ArrayList<Topic> allTopics = new ArrayList<>();
		// read the first line from the text file
		String line = br.readLine();

		// temp person information variables
		String t_name;
		String t_l1,t_l2,t_l3,t_l4,t_l5,t_l6,t_l7,t_l8,t_l9,t_l10;
		String t_r1,t_r2,t_r3,t_r4,t_r5,t_r6,t_r7,t_r8,t_r9,t_r10;
		int lineNum=1;
		String [] t_statements = new String[10];
		String [] t_replies = new String[10];

		// loop until all lines are read
		while (line != null) {

			if(lineNum++==1) continue; // Ignore the first line and increment the line number

			// use string.split to load a string array with the values from
			// each line of the file, using a comma as the delimiter.
			String[] values = line.split(",");
			if(values.length!=11) {
				System.out.print("Please check input file "+fileName);
				return;
			}
			t_name = values[0];
			for(int i=0,j=0; i<20; i+=2,j++) {
				t_statements[j] = values[i+1];
				t_replies[j] = values[i+2];
			}

			// add this topic into the master list of all topics
			Import.allTopics.add(new Topic(t_name,t_statements,t_replies));

			// read next line before looping
			// if end of file reached, line would be null
			line = br.readLine();
		}

		br.close(); // close the file reader
		
		return;
	}
	
	
	// Used by other classes to receive a fixed number of Topics in array form
	public Topic[] getTopics(int num) {

		Topic [] tList = new Topic[num];
		ArrayList<Topic> cloneList = new ArrayList<Topic>(allTopics);
		
		int at_size = cloneList.size();
		int t_index;
        
		for(int i=0; i<num && i<at_size; i++) {
			t_index = (int) (Math.random()*(at_size-1));
			tList[i] = allTopics.get(t_index);
			allTopics.remove(t_index);
			at_size--;
		}
		
		return tList;
	}	
	
	// Internal function to import music from a CSV file for use in the party
	private void getMusicFromCSV(String fileName) throws IOException {
		
		// find the path to the file and create an instance of BufferedReader
		BufferedReader br = new BufferedReader(new FileReader(fileName));
	
		// create a new list of people for returning to user
		// make an arraylist to hold all people from the file.  This way we can 
		// choose random people from the list instead of the same first few.
		//ArrayList<Person> allPeople = new ArrayList<>();
		// read the first line from the text file
		String line = br.readLine();
	
		// temp person information variables
		String artist,title,dur;
		Duration length = Duration.ZERO;
		int lineNum=1;
	
		// loop until all lines are read
		while (line != null) {
	
			if(lineNum++==1) continue; // Ignore the first line and increment the line number
	
			// use string.split to load a string array with the values from
			// each line of the file, using a comma as the delimiter
			String[] values = line.split(",");
			String[] timer;
			
			if(values.length!=3) {
				System.out.print("Please check input file "+fileName);
				return;
			}
			artist = values[0];
			title = values[1];
			dur = values[3];
			timer = dur.split(":");
			length = Duration.ZERO;
			length.plusMinutes(Long.parseLong(timer[0]));
			length.plusSeconds(Long.parseLong(timer[1]));
	
			// adding this new person into ArrayList of all people
			Import.allMusic.add(new Music(artist,title,length));
	
			// read next line before looping
			// if end of file reached, line would be null
			line = br.readLine();
		}
	
		br.close(); // close the file reader
		
		return;
	}
	
	// Returns a list of people generated from the master list of all people imported.
	// Does so by making a clone of the master list then removing people from it and adding it to
	// a regular array.
	
	public Music[] getPlaylist(int num) {
		
		Music [] mList = new Music[num];
		ArrayList<Music> cloneList = new ArrayList<Music>(allMusic);
		
		int am_size = cloneList.size();
		int m_index;
	    
		for(int i=0; i<num && i<am_size; i++) {
			m_index = (int) (Math.random()*(am_size-1));
			mList[i] = cloneList.get(m_index);
			cloneList.remove(m_index);
			am_size--;
		}
		
		return mList;
	}
	
}
