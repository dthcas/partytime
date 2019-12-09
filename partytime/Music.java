/* Music will define a class of song which will be played at a party */

// Music has an artist, title and running time.
// Methods will be: 
// 	getNextSong() which will a return a new song
//  getPlaylist(int numsongs) which will return a list of songs
//  importMusic() which will scan an input file for songs and store them for use during operation
import java.time.LocalDate;

public class Music {
	private String artist, title;
	private Duration duration;

	public Music(String artist, String title, int minDuration, int secDuration) {
		this.artist = artist;
		this.title = title;
		this.duration = Duration.of((secDuration + minDuration*60), ChronoUnit.SECONDS);
	}
}