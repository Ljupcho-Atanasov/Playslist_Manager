
public class SongNode912 {
	   private String songTitle;
	   private int songLength;
	   private String songArtist;
	   private SongNode912 nextNodeRef; // Reference to the next node                                   

	   public SongNode912() {
	      songTitle = "";
	      songLength = 0;
	      songArtist = "";
	      nextNodeRef = null;
	   }

	   // Constructor                                                                                     
	   public SongNode912(String songTitleInit, int songLengthInit, String songArtistInit) {
	      this.songTitle = songTitleInit;
	      this.songLength = songLengthInit;
	      this.songArtist = songArtistInit;
	      this.nextNodeRef = null;
	   }

	   // Constructor                                                                                     
	   public SongNode912(String songTitleInit, int songLengthInit, String songArtistInit, SongNode912 nextLoc) {
	      this.songTitle = songTitleInit;
	      this.songLength = songLengthInit;
	      this.songArtist = songArtistInit;
	      this.nextNodeRef = nextLoc;
	   }

	   // insertAfter
	   public void insertAfter(SongNode912 nodeLoc) {
	      SongNode912 tmpNext;

	      tmpNext = this.nextNodeRef;
	      this.nextNodeRef = nodeLoc;
	      nodeLoc.nextNodeRef = tmpNext;
	   }

	   // Get location pointed by nextNodeRef                                                            
	   public SongNode912 getNext() {
	      return this.nextNodeRef;
	   }

	   public void printSongInfo() {
	System.out.println("Title: " + this.songTitle);
	System.out.println("Length: " + this.songLength);
	System.out.println("Artist: " + this.songArtist);
	System.out.println();
	}


}

