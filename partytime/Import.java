/* Import.java will allow a class to import various data from CSV files to allow for people, conversations and topics
// To use: create an Index object and use the public methods to pull data as needed.
*/

package partytime;

import java.io.*;
import java.text.DecimalFormat;
import java.time.Duration;
//import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
//import java.net.URL;
//import java.nio.charset.StandardCharsets;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;

public class Import {
	
	private ArrayList<Person> allPeople = new ArrayList<Person>();
	private ArrayList<Topic> allTopics = new ArrayList<Topic>();
	private ArrayList<Music> allMusic = new ArrayList<Music>();
	
	public ArrayList<Person> getAllPeople() {return this.allPeople;}
	
	public Import() {
		
		File pdir = new File("partytime/imports/people.csv");
		File tdir = new File("partytime/imports/topics.csv");
		File mdir = new File("partytime/imports/music.csv");
		
		try {
			getTopicsFromCSV(tdir.getAbsolutePath());
			getPeopleFromCSV(pdir.getAbsolutePath());
			getMusicFromCSV(mdir.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		  }
		
	}
	
	private void getPeopleFromCSV(String fileName) throws IOException {
		
		// find the path to the file and create an instance of BufferedReader
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		
		// create a new list of people for returning to user
		// make an arraylist to hold all people from the file.  This way we can 
		// choose random people from the list instead of the same first few.
		//ArrayList<Person> allPeople = new ArrayList<>();
		// read the first line from the text file
		String line = br.readLine();
		// temp person information variables
		Person p;
		String p_name = "";
		int p_id,p_age;
		Double p_hm, p_em, p_at, p_in, p_ch;
		int lineNum=1;
		String[] values = new String[8];

		// loop until all lines are read
		while (line != null) {

			if(lineNum==1) { lineNum++; line = br.readLine(); }// Ignore the first line and increment the line number
			
			// loop to turn all valid commas into tabs for proper input as some quotes will have commas
			line = commaToTabSwitcher(line);
			// use string.split to load a string array with the values from
			// each line of the file, using a comma as the delimiter
			values = line.split("\t");
			if(values.length<8) {
				System.out.println("Please check input file "+fileName);
				break;
			}
			p_id = Integer.parseInt(values[0]);
			p_name = values[1];
			p_age = Integer.parseInt(values[2]);
			p_hm = Double.parseDouble(values[3]);
			p_em = Double.parseDouble(values[4]);
			p_at = Double.parseDouble(values[5]);
			p_in = Double.parseDouble(values[6]);
			p_ch = Double.parseDouble(values[7]);

			// adding this new person into ArrayList of all people
			p = new Person(p_age,p_name,p_id,p_hm,p_em,p_at,p_in,p_ch);
			p.setTopics(this.getTopics(3));
			this.allPeople.add(p);
			for(int j=0; j<p.getTopics().length; j++) {
				p.getTopics()[j].setInterest((int)(Math.random()*10)+1);
			}
			// read next line before looping
			// if end of file reached, line would be null
			line = br.readLine();
			lineNum++;
		}

		br.close(); // close the file reader
		//System.out.println("Person import completed with "+(lineNum-1)+" people added to master list");
		
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
		//ArrayList<Topic> allTopics = new ArrayList<>();
		// read the first line from the text file
		String line = br.readLine();

		// temp person information variables
		String t_name;
		//String t_l1,t_l2,t_l3,t_l4,t_l5,t_l6,t_l7,t_l8,t_l9,t_l10;
		//String t_r1,t_r2,t_r3,t_r4,t_r5,t_r6,t_r7,t_r8,t_r9,t_r10;
		int lineNum=1;
		String [] t_statements = new String[10];
		String [] t_replies = new String[10];
		String [] values = new String[21];

		// loop until all lines are read
		while (line != null) {

			if(lineNum==1) { line = br.readLine(); lineNum++; }// Ignore the first line and increment the line number

			// turn all valid commas into tabs for proper input as some quotes will have commas
			line = commaToTabSwitcher(line);
			//System.out.println("topic converted: "+line);
			// use string.split to load a string array with the values from
			// each line of the file, using a comma as the delimiter.
			values = line.split("\t");
			if(values.length<21) {
				System.out.println("Please check input file "+fileName);
				System.out.println("Incorrect length of "+values.length+" found for input string: "+line);
				line = br.readLine();
				lineNum++;
				break;
			}
			t_name = values[0];
			for(int i=0,j=0; i<20; i+=2,j++) {
				t_statements[j] = values[i+1];
				t_replies[j] = values[i+2];
				//System.out.println("Topic "+t_name+ " added statement: "+ t_statements[j]);
				//System.out.println("Topic "+t_name+ " added reply: "+ t_replies[j]);
			}

			// add this topic into the master list of all topics
			this.allTopics.add(new Topic(t_name,t_statements.clone(),t_replies.clone()));
			//System.out.println("New Topic Added: "+t_name);
			// read next line before looping
			// if end of file reached, line would be null
			line = br.readLine();
			lineNum++;
		}

		br.close(); // close the file reader
		//System.out.println("Topic import completed with "+(lineNum-1)+" topics added to master list");
		
		return;
	}
	
	
	// Used by other classes to receive a fixed number of Topics in array form
	public Topic[] getTopics(int num) {

		Topic [] tList = new Topic[num];
		ArrayList<Topic> cloneList = new ArrayList<Topic>(allTopics);
		
		int at_size = cloneList.size();
		int t_index;
        
		for(int i=0; i<num && at_size>0; i++) {
			t_index = (int) (Math.random()*(at_size));
			tList[i] = cloneList.get(t_index);
			cloneList.remove(t_index);
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
		String[] values = new String[3];
	
		// loop until all lines are read
		while (line != null) {
	
			if(lineNum==1) { line = br.readLine(); lineNum++; } // Ignore the first line and increment the line number
	
			line = commaToTabSwitcher(line);
			
			// use string.split to load a string array with the values from
			// each line of the file, using a comma as the delimiter
			values = line.split("\t");
			String[] timer;
			
			if(values.length<3) {
				//System.out.println("Please check input file "+fileName);
				line = br.readLine();
				continue;
			}
			artist = values[0];
			title = values[1];
			dur = values[2];
			timer = dur.split(":");
			length = Duration.ZERO;
			//Add minutes and seconds to the length of the track
			length = length.plusMinutes(Long.parseLong(timer[0]));
			length = length.plusSeconds(Long.parseLong(timer[1]));
	
			// adding this new person into ArrayList of all people
			this.allMusic.add(new Music(artist,title,length));
	
			// read next line before looping
			// if end of file reached, line would be null
			line = br.readLine();
			lineNum++;
		}
	
		br.close(); // close the file reader
		//System.out.println("Music import completed with "+(lineNum-1)+" songs added to master list");
		
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
	
	private String commaToTabSwitcher(String input) {
		
		// loop to turn all valid commas into tabs for proper input as some quotes will have commas
		boolean quotemark = false;
		String out = "";
		for(int i=0; i<input.length(); i++) {
			if(quotemark) {
				if(input.charAt(i) == '\"') {
					quotemark = false;
					//System.out.println("Close quote at index "+ Integer.toString(i));
					//System.out.println("New string: "+out);
				}
				else {
					out = out+input.charAt(i);
					//System.out.println("New string: "+out);
				}
			}
			else {
				if(input.charAt(i) == ',') { 
					out = out+"\t";
					//System.out.println("One tab inserted at index "+Integer.toString(i));
					//System.out.println("New string: "+out);
				}
				else if(input.charAt(i) == '\"') {
					quotemark = true;
					//System.out.println("Open quote at index "+ Integer.toString(i));
				}
				else {
					out = out+input.charAt(i);
				}
			}
		}
		
		//System.out.println("Refactored string: "+out);
		
		return out;
	}
	
}
