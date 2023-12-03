package SEM;

import java.util.Iterator;

public class EX3<T> implements Iterable<T> {

    private static final int INITIAL_CAPACITY = 10;
    private Object[] array;
    private int size;

    public EX3() {
        this.array = new Object[INITIAL_CAPACITY];
        this.size = 0;
    }

    public void add(T element) {
        ensureCapacity();
        array[size++] = element;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        int elementsToMove = size - index - 1;
        if (elementsToMove > 0) {
            System.arraycopy(array, index + 1, array, index, elementsToMove);
        }
        array[--size] = null;  // Clear the last element
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return (T) array[index];
    }

    public int size() {
        return size;
    }

    private void ensureCapacity() {
        if (size == array.length) {
            array = java.util.Arrays.copyOf(array, array.length * 2);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new CustomArrayListIterator();
    }

    private class CustomArrayListIterator implements Iterator<T> {

        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            return get(currentIndex++);
        }
    }

    public static void main(String[] args) {
        EX3<String> stringList = new EX3<>();
        stringList.add("One");
        stringList.add("Two");
        stringList.add("Three");

        // Использование итератора
        Iterator<String> iterator = stringList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
