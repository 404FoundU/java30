package DSA.Arrays;



import java.util.Arrays;

public class ArrayListExample<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elementData;
    private int size =0;
    public ArrayListExample() {
        this.elementData = new Object[DEFAULT_CAPACITY];
    }
    public void add(E e) {
        ensureCapacity();
        this.elementData[size++] = e;
    }

    public E get(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.size);
        }
        return (E) this.elementData[index];
    }

    public E remove(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.size);
        }
        E oldValue = (E) this.elementData[index];
        int lengthToMove = this.size - 1 - index;
        if (lengthToMove > 0) {

            System.arraycopy(this.elementData, index + 1, this.elementData, index, lengthToMove);
        }
        this.elementData[--this.size] = null ;// reduce size
        return oldValue;
    }

    private void ensureCapacity() {
        int length = this.elementData.length;
        if (this.size == length) {
            int newCapacity = length + (length >> 1);// right shift 1 bit = 1.5 times
            this.elementData = Arrays.copyOf(this.elementData, newCapacity);
        }
    }

    private void printList(ArrayListExample<Integer> l) {
        for (int i = 0; i < l.size() ; i++) {
            System.out.println(l.get(i));
        }
    }

    private int size() {
        return this.size;
    }


    public Iterator<Object> createIterator() {
        return new ArrayListIterator(elementData);  // Return a PlaylistIterator
    }

    public static void main(String[] args) {
        ArrayListExample<Integer> ll = new ArrayListExample<>();

        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.printList(ll);
        ll.remove(2);
        ll.printList(ll);

    }

    public interface Iterator<T> {
        boolean hasNext();

        T next();
    }

}

class ArrayListIterator implements ArrayListExample.Iterator<Object> {

    Object[] elements;
    int position = 0;

    ArrayListIterator(Object[] elements) {
        this.elements = elements;
    }

    @Override
    public boolean hasNext() {
        return position < elements.length;
    }

    @Override
    public Object next() {
        if (hasNext()) {
            return elements[position++];
        }
        return null;
    }
}
