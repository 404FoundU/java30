package Snippets.DesignPattern;

import java.util.Arrays;

// Iterator Interface
interface Iterator<T> {
    boolean hasNext();

    T next();
}

// Aggregate Interface
interface Aggregate<T> {
    Iterator<T> createIterator();
}

// This class is only for storing - COntainer
class PlaylistCollection implements Aggregate<String> {
    private String[] songs;  // Array of songs

    public PlaylistCollection(String[] songs) {
        this.songs = songs;
    }

    @Override
    public Iterator<String> createIterator() {
        return new PlaylistForwardIterator(songs);  // Return a PlaylistIterator
    }
}


// Forward Iterator. We can create a reverse iterator
// This class is algorithm for traversing.
class PlaylistForwardIterator implements Iterator<String> {
    private String[] songs;// switch to LL
    private int position = 0;  // Keep track of the current position

    public PlaylistForwardIterator(String[] songs) {
        this.songs = songs;
    }

    @Override
    public boolean hasNext() {
        return position < songs.length;  // Check if more songs exist
    }

    @Override
    public String next() {
        if (hasNext()) {
            return songs[position++];  // Return the current song and move to the next
        }
        return null;  // If no more songs, return null
    }
}


// Ipod with next and previous button
public class IteratorPatternExample {
    public static void main(String[] args) {
        // Create a playlist of songs
        String[] songs = {"Song A", "Song B", "Song C", "Song D"};
        PlaylistCollection playlistCollection = new PlaylistCollection(songs);

        // Get an iterator for the playlist
        Iterator<String> iterator = playlistCollection.createIterator();

        // Use the iterator to navigate through the playlist
        System.out.println("Playlist:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        Arrays.stream(songs)
                .forEach((song) -> System.out.println(song));// similar to observer pattern
    }
}

