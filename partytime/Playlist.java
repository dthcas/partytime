package partytime;

//This is the playlist class for storing music.

public class Playlist {
   private Music[] playlist;
   private int cur_song;
   
   public Playlist(Music[] m) {
	   this.playlist = m;
	   this.cur_song = 0;
   }
   public Music getCurrentSong() {
	   
	   if(this.playlist == null) return null;
	   else if(cur_song >= this.playlist.length) return null;
	   else return this.playlist[cur_song];
   }
   
   public Music getNextSong() {
   
	   if(cur_song+1 < this.playlist.length) {
		   cur_song++;
		   return this.playlist[cur_song];
	   }
	   else {
		   System.out.println("The playlist has ended");
		   cur_song++;
		   return null;
	   }
   }
   
   public int getSize() {
	   return this.playlist.length;
   }
}
