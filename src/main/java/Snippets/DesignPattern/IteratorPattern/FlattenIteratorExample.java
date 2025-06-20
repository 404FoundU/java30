package Snippets.DesignPattern.IteratorPattern;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class FlattenIteratorExample {
    public static void main(String[] args) {

        // { { 1, 1, 2, 3 }, { 4, 5, 6, 6 } } -> { 1, 1, 2, 3, 4, 5, 6, 6 }
        // { { 'A', 'B', 'C' }, { 'D', 'E' } } -> { 'A', 'B', 'C', 'D', 'E' }

        Iterator<Iterator<Integer>> i1 = List.of(List.of(1, 2, 3).iterator(),
                List.of(4, 5, 6).iterator(), List.of(7, 8, 9).iterator()).iterator();

        Iterator<Integer> flattened = flatten(i1);
        while (flattened.hasNext()) {
            System.out.println(flattened.next());
        }

    }

    public static <T> Iterator<T> flatten(final Iterator<Iterator<T>> input) {
        return new Iterator<T>() {
            Iterator<T> current = Collections.emptyIterator();

            @Override
            public boolean hasNext() {
                while (!current.hasNext() && input.hasNext()) {
                    current = input.next();
                }
                return current.hasNext();

            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return current.next();
            }
        };

    }

}
