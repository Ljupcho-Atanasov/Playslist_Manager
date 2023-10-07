//Implements SongEntry class
import java.util.*;
//import java.util.LinkedList; MUST DO WITHOUT !
public class Playlist {
	static SongEntry headNode = new SongEntry();
	static LinkedList<SongEntry> pllist = new LinkedList<SongEntry>();
	public static void printMenu(String playListName)
	{
		System.out.println(playListName + " PLAYLIST MENU");
		System.out.println("a - Add song");
		System.out.println("d - Remove song");
		System.out.println("c - Change position of song");
		System.out.println("s - Output songs by specific artist");
		System.out.println("t - Output total time of playlist (in seconds)");
		System.out.println("o - Output full playlist");
		System.out.println("q - Quit");
		System.out.println();
	}
	
	public static SongEntry executeMenu(char c, String playListName, SongEntry firstNode, Scanner s)// fix STUB
	{
		//returns the headNode of a manipulated linked list
		if (c == 'a') headNode = addSong (s);
		
			
		if (c == 'd') headNode = removeSong (s);
				
		if (c == 'c') headNode = changePositionOfSong (s);
				
		if (c == 's') headNode = outputSongsBySpecificArtist (s);
			
		if (c == 't') headNode = outputTotalTimeOfPlaylist ();
					
		if (c == 'o') headNode = outputFullPlaylist(playListName, firstNode);
									
		return headNode;
	}
	
	public static SongEntry outputTotalTimeOfPlaylist ()
	{
		System.out.println("OUTPUT TOTAL TIME OF PLAYLIST (IN SECONDS)");
		
		int sum = 0;
		SongEntry currNode = headNode.getNext();
		if (currNode == null) 
		{
			System.out.println("Playlist is empty"); 
			System.out.println(); 
		}
		while (currNode != null)
		{
			sum += currNode.getSongLength();
			currNode = currNode.getNext();
		}
		
		System.out.println("Total time: " + sum + " seconds");
		System.out.println();
		return headNode;
	}
	
	public static SongEntry  outputSongsBySpecificArtist (Scanner s)
	{
		System.out.println("OUTPUT SONGS BY SPECIFIC ARTIST");
		System.out.println("Enter artist's name:");
		s.nextLine();
		String artist = s.nextLine();	
		//String nl = s.next();
		int pos = 0;
		int count = 0;
		
		SongEntry currNode = headNode.getNext();
		
		if (currNode == null) 
		{
			System.out.println("Playlist is empty"); 
			System.out.println(); 
		}
		while (currNode != null)
		{
			++pos;
			if (currNode.getArtistName().compareTo(artist) == 0) 
			{
				++count;
			System.out.println(pos + ".");
			currNode.printPlaylistSongs();
			System.out.println();
			}
			currNode = currNode.getNext();
		}
		if (count == 0) System.out.println("There are no songs by the artist " + "\""+ artist +"\""+ " in this list!");
		return headNode;
	}
	
	public static SongEntry changePositionOfSong (Scanner s)
	{
		SongEntry currNode = headNode;
		int numNodes = 0;
		while (currNode.getNext() != null)
		{
			++numNodes;
			currNode = currNode.getNext(); 
		}
		System.out.println("CHANGE POSITION OF SONG");
		System.out.println("Enter song's current position:");
		int cPos = s.nextInt();
		if (cPos < 1) cPos = 1;
		if (cPos > numNodes) cPos = numNodes;
		System.out.println("Enter new position for song:");
		int nPos = s.nextInt();
		if (nPos < 1) nPos = 1;
		if (nPos > numNodes) nPos = numNodes;
		SongEntry cTemp = headNode.getNext();
		SongEntry cPrev = headNode;
		SongEntry nTemp = headNode.getNext();
		SongEntry nPrev = headNode;
		for (int i = 1; i < cPos; ++i) 
			{
			cTemp = cTemp.getNext();
			cPrev = cPrev.getNext();
			}
		for (int i = 1; i < nPos; ++i) 
			{
			nTemp = nTemp.getNext();
			nPrev = nPrev.getNext();
			}
		System.out.println("\"" + cTemp.getSongName() +"\"" + " moved to position " + nPos);
		System.out.println();
        if (cPos > nPos)
        {
            nPrev.setNext(cTemp);
            cPrev.setNext(cTemp.getNext());
            cTemp.setNext(nTemp);
        }
        if (nPos > cPos)
        {
        	cPrev.setNext(cTemp.getNext());
        	cTemp.setNext(nTemp.getNext());
        	nTemp.setNext(cTemp);
      
        }
		
		return headNode;
	}
	
	public static SongEntry removeSong (Scanner s)
	{
		int i = 0;
		SongEntry temp;
		SongEntry currNode;
		SongEntry prevNode;
		String id;
		System.out.println("REMOVE SONG");
		System.out.println("Enter song's unique ID:");
		id = s.next();
		
		/*Iterator it = pllist.iterator();
		while (it.hasNext()) 
		{
			if (pllist.get(i).getID().compareTo(id) == 0) pllist.remove(i);
			++i;
		}*/
		String iD = headNode.getID();
		if (iD.compareTo(id) == 0)
			{
			temp = headNode;
			headNode = headNode.getNext();
			
			System.out.println( "\"" + temp.getSongName() + "\""  + " removed.");
			System.out.println();
			temp.setNext(null);
			temp = null;
			return headNode;
			}
		else 
			{
			currNode = headNode.getNext();
			prevNode = headNode;
			}
		
		
		while (currNode != null)
		{
			iD = currNode.getID();
			if (iD.compareTo(id) == 0)
			{
				temp = currNode;
				currNode = currNode.getNext();
				prevNode.setNext(currNode);
				
				System.out.println( "\"" + temp.getSongName() + "\""  + " removed.");
				System.out.println();
				temp.setNext(null);
				temp = null;
				
				return headNode;
			}
			currNode = currNode.getNext();
			prevNode = prevNode.getNext();
		}
		return headNode;   
	}
	
	//adds node at the end of a linked list
	public static SongEntry addSong (Scanner s)
	{
		String id;
		String sName;
		String arName; 
		
		SongEntry currNode;
		int sLength;
		
		s.nextLine();
		
		System.out.println("ADD SONG");
		
		System.out.println("Enter song's unique ID:");
		id = s.nextLine();
		
		System.out.println("Enter song's name:"); 
		sName = s.nextLine();
		
		System.out.println("Enter artist's name:");
		arName = s.nextLine();

		System.out.println("Enter song's length (in seconds):");
		sLength = s.nextInt();
		s.nextLine();
		System.out.println();
		SongEntry addNode = new SongEntry(id, sName, arName, sLength, null);
		//pllist.add(addNode);
		currNode = headNode;
		
		while (currNode.getNext() !=null ) currNode = currNode.getNext();
		currNode.insertAfter(addNode);
		
		return headNode;
	}
	
	public static SongEntry outputFullPlaylist(String playListName,SongEntry firstNode)	//1.
	{
		int pos = 0;
		SongEntry currNode = headNode.getNext();
		System.out.println(playListName + " - OUTPUT FULL PLAYLIST");
		if (currNode == null) 
		{
			System.out.println("Playlist is empty"); 
			System.out.println(); 
		}
		while (currNode != null)
		{
			++pos;
			System.out.println(pos + ".");
			currNode.printPlaylistSongs();
			System.out.println();
			currNode = currNode.getNext();
		}
		return headNode;
	}

	public static void main(String[] args) 
	{
	Scanner s = new Scanner(System.in);
	pllist.add(headNode);
	
	char option;
	System.out.println("Enter playlist's title:");
	System.out.println();
	String plName = s.nextLine();
	printMenu(plName);
	do 
	{
		do
		{
			System.out.println("Choose an option:");
			option = s.next().charAt(0);
		} 
		
		while ((option != 'a')&&(option != 'd')&&(option != 'c')&&(option != 's')&&(option != 't')&&(option != 'o')&&(option != 'q'));
		headNode = executeMenu(option, plName, headNode, s);
		if (option != 'q') printMenu(plName);
	} while (option != 'q');
	
	}

}
