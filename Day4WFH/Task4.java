import java.util.LinkedList;
public class Task4 {
     public static void main(String[] args) {
    LinkedList<String> songs= new LinkedList<>();
        songs.add("Shape of You");
        songs.add("Perfect");
        songs.add("Believer");
        songs.add("Memories");
        System.out.println("Playlist: " + songs);
         songs.addFirst("Found");
        System.out.println("After Adding First: " + songs);
        songs.addLast("Done");
        System.out.println("After Adding Last: " + songs);
        songs.removeFirst();
         System.out.println("After Removing First: " + songs);
         songs.removeLast();
          System.out.println("After Removing Last: " + songs);
           System.out.println("First Song: " + songs.getFirst());
        System.out.println("Last Song: " + songs.getLast());
          System.out.println("Is Perfect Available?"+songs.contains("Perfect"));
           System.out.println("Now Playing: " + songs.removeFirst());
        System.out.println("Updated Playlist: " + songs);
     }    
}
