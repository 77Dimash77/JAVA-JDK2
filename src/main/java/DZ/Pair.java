package DZ;

public class Pair<T, U> {

    private T first;
    private U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }

    public static void main(String[] args) {
        // Пример использования
        Pair<Integer, String> pair1 = new Pair<>(1, "one");
        Pair<Double, Boolean> pair2 = new Pair<>(3.14, true);

        System.out.println("Pair 1: " + pair1);
        System.out.println("Pair 2: " + pair2);

        // Получение значений из пары
        Integer firstValue = pair1.getFirst();
        String secondValue = pair1.getSecond();

        System.out.println("First value of Pair 1: " + firstValue);
        System.out.println("Second value of Pair 1: " + secondValue);
    }
}
