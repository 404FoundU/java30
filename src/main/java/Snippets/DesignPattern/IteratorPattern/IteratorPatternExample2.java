package Snippets.DesignPattern.IteratorPattern;


import java.util.Iterator;
import java.util.NoSuchElementException;

// 1. Custom Iterable Collection
class NameRepository implements Iterable<String> {
    private String[] names;

    NameRepository(String[] names) {
        this.names = names;
    }

    @Override
    public Iterator<String> iterator() {
        return new NameIterator();
    }

    // 2. Inner IteratorPattern class
    private class NameIterator implements Iterator<String> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < names.length;
        }

        @Override
        public String next() {
            if (!hasNext()) throw new NoSuchElementException();
            return names[index++];
        }
    }
}


public class IteratorPatternExample2 {
    public static void main(String[] args) {
        String[] names = {"Unni", "Rishi", "Bo"};
        NameRepository repo = new NameRepository(names);

        Iterator<String> iterator = repo.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
