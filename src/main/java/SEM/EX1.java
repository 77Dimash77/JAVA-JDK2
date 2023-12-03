package SEM;

import java.io.DataInputStream;

public class EX1<T extends Comparable<T>, V extends DataInputStream, K extends Number> {

    private T variable1;
    private V variable2;
    private K variable3;

    public EX1(T variable1, V variable2, K variable3) {
        this.variable1 = variable1;
        this.variable2 = variable2;
        this.variable3 = variable3;
    }

    public T getVariable1() {
        return variable1;
    }

    public V getVariable2() {
        return variable2;
    }

    public K getVariable3() {
        return variable3;
    }

    public void printClassNames() {
        System.out.println("Type of variable1: " + variable1.getClass().getName());
        System.out.println("Type of variable2: " + (variable2 != null ? variable2.getClass().getName() : "null"));
        System.out.println("Type of variable3: " + variable3.getClass().getName());
    }

    public static void main(String[] args) {
        // Пример использования класса
        String str = "Hello";
        DataInputStream dataInput = null; // Ваш объект типа, реализующий DataInput
        Integer number = 42;

        EX1<String, DataInputStream, Integer> genericObj = new EX1<>(str, dataInput, number);
        genericObj.printClassNames();
    }
}
