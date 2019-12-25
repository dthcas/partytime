package partytime;

//This is the playlist class for storing music.

public class Playlist {
   private Music[] playlist;
   private int cur_song;
   
   public Playlist(Music[] m) {
	   this.playlist = m;
	   cur_song = 0;
   }
   
   public Music getNextSong() {
   
	   if(cur_song+1 < this.playlist.length-1) {
		   cur_song++;
		   return this.playlist[cur_song];
	   }
	   else {
		   return null;
	   }
   }
}
