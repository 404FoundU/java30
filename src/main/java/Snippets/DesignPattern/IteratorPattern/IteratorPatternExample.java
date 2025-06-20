package Snippets.DesignPattern.IteratorPattern;

// IteratorPattern Interface
interface Iterator<T> {
    boolean hasNext();

    T next();
}

// allows to swap playlist collection with video collection
interface MyCollection<T> {
    Iterator<T> createIterator();
}


// This class is only for storing - COntainer
class PlaylistCollection implements MyCollection<String> {
    private final String[] songs;  // Array of songs

    public PlaylistCollection(String[] songs) {
        this.songs = songs;
    }

    @Override
    public Iterator<String> createIterator() {
        return new PlaylistForwardIterator();  // Return a PlaylistIterator
    }

    // Forward IteratorPattern. We can create a reverse iterator
    class PlaylistForwardIterator implements Iterator<String> {
        private int position = 0;  // Keep track of the current position

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
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

