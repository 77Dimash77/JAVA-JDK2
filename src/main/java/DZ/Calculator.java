package DZ;

public class Calculator {

    public static <T extends Number> T sum(T num1, T num2) {
        if (num1 instanceof Double || num2 instanceof Double) {
            return (T) Double.valueOf(num1.doubleValue() + num2.doubleValue());
        } else if (num1 instanceof Float || num2 instanceof Float) {
            return (T) Float.valueOf(num1.floatValue() + num2.floatValue());
        } else {
            return (T) Integer.valueOf(num1.intValue() + num2.intValue());
        }
    }

    public static <T extends Number> T multiply(T num1, T num2) {
        if (num1 instanceof Double || num2 instanceof Double) {
            return (T) Double.valueOf(num1.doubleValue() * num2.doubleValue());
        } else if (num1 instanceof Float || num2 instanceof Float) {
            return (T) Float.valueOf(num1.floatValue() * num2.floatValue());
        } else {
            return (T) Integer.valueOf(num1.intValue() * num2.intValue());
        }
    }

    public static <T extends Number> T divide(T num1, T num2) {
        if (num2.doubleValue() == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }

        if (num1 instanceof Double || num2 instanceof Double) {
            return (T) Double.valueOf(num1.doubleValue() / num2.doubleValue());
        } else if (num1 instanceof Float || num2 instanceof Float) {
            return (T) Float.valueOf(num1.floatValue() / num2.floatValue());
        } else {
            return (T) Integer.valueOf(num1.intValue() / num2.intValue());
        }
    }

    public static <T extends Number> T subtract(T num1, T num2) {
        if (num1 instanceof Double || num2 instanceof Double) {
            return (T) Double.valueOf(num1.doubleValue() - num2.doubleValue());
        } else if (num1 instanceof Float || num2 instanceof Float) {
            return (T) Float.valueOf(num1.floatValue() - num2.floatValue());
        } else {
            return (T) Integer.valueOf(num1.intValue() - num2.intValue());
        }
    }

    public static void main(String[] args) {
        // Пример использования
        int intResult = Calculator.sum(5, 3);
        double doubleResult = Calculator.multiply(2.5, 4.0);

        System.out.println("Sum: " + intResult);
        System.out.println("Multiply: " + doubleResult);

        // Деление и вычитание с использованием чисел с плавающей точкой
        double divideResult = Calculator.divide(10.0, 2.0);
        double subtractResult = Calculator.subtract(8.0, 3.5);

        System.out.println("Divide: " + divideResult);
        System.out.println("Subtract: " + subtractResult);
    }
}
