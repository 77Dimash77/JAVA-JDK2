package SEM;

import java.util.Arrays;

public class EX2<T> {

    private static final int INITIAL_CAPACITY = 10;
    private Object[] array;
    private int size;

    public EX2() {
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
            array = Arrays.copyOf(array, array.length * 2);
        }
    }

    public static void main(String[] args) {
        EX2<String> stringList = new EX2<>();
        stringList.add("One");
        stringList.add("Two");
        stringList.add("Three");

        System.out.println("List size: " + stringList.size());

        for (int i = 0; i < stringList.size(); i++) {
            System.out.println("Element at index " + i + ": " + stringList.get(i));
        }

        stringList.remove(1);

        System.out.println("List size after removal: " + stringList.size());

        for (int i = 0; i < stringList.size(); i++) {
            System.out.println("Element at index " + i + ": " + stringList.get(i));
        }
    }
}
