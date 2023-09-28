package searchAlgorithms;


public class LinearSearch {

    public static void main(String [] args) {
        var input = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        var result = search(input, 10);

        if (result != null) {
            System.out.println("Value found at position: " + result);
        } else {
            System.out.println("Value not found in the array");
        }
    }

    public static Integer search(Integer[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return null;
    }
}
