
public class SongEntry 
{
	private String uniqueID;
	private String songName;
	private String artistName;
	private int songLength;
	private SongEntry nextNode;
	private int position = 0; // The position of the song
	
	//Default Constructor:
	public SongEntry ()
	{
		uniqueID = "none"; songName = "none"; 
		artistName = "none"; nextNode = null;
		songLength = 0;	
	}
	
	//parameterized Constructor:
	public SongEntry (String id, String name, String artist, int length, SongEntry next)
	{
		this.uniqueID = id; this.songName = name; this.artistName = artist;
		this.songLength = length;	this.nextNode = next;
	}
	//ZyBook's version of the parameterized Constructor:
	public SongEntry (String id, String name, String artist, int length)
	{
		this.uniqueID = id; this.songName = name; this.artistName = artist;
		this.songLength = length;	this.nextNode = null;
	}
	
	public void insertAfter(SongEntry currNode) 
	{
		SongEntry tempNode = this.nextNode;
		this.nextNode = currNode;
		currNode.nextNode = tempNode;
	}
	
	public void setNext(SongEntry nextNode)
	{
		this.nextNode = nextNode;
	}
	
	public String getID() {return uniqueID;}
	
	public String getSongName() {return songName;}
	
	public String getArtistName() {return artistName;}
	
	public int getSongLength() {return songLength;}
	
	public SongEntry getNext() {return nextNode;}	
	
	public void printPlaylistSongs()
	{
		System.out.println("Unique ID: " + uniqueID);
		System.out.println("Song Name: " + songName);
		System.out.println("Artist Name: " + artistName);
		System.out.println("Song Length (in seconds): " + songLength);
	}
	
	public void setPosition (int pos) {this.position = pos;}
	public int getPosition() {return this.position;}
	
}
