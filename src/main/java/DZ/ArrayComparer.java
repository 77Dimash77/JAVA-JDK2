package DZ;

public class ArrayComparer {

    public static <T> boolean compareArrays(T[] array1, T[] array2) {
        if (array1 == null || array2 == null || array1.length != array2.length) {
            return false;
        }

        for (int i = 0; i < array1.length; i++) {
            if (!array1[i].equals(array2[i])) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Integer[] intArray1 = {1, 2, 3, 4, 5};
        Integer[] intArray2 = {1, 2, 3, 4, 5};
        Integer[] intArray3 = {1, 2, 3, 4, 6};

        String[] strArray1 = {"one", "two", "three"};
        String[] strArray2 = {"one", "two", "three"};
        String[] strArray3 = {"one", "two", "four"};

        System.out.println("Compare intArray1 and intArray2: " + compareArrays(intArray1, intArray2)); // true
        System.out.println("Compare intArray1 and intArray3: " + compareArrays(intArray1, intArray3)); // false

        System.out.println("Compare strArray1 and strArray2: " + compareArrays(strArray1, strArray2)); // true
        System.out.println("Compare strArray1 and strArray3: " + compareArrays(strArray1, strArray3)); // false
    }
}
