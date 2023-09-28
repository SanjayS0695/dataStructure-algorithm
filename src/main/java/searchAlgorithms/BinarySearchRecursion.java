package searchAlgorithms;

import java.util.Arrays;

public class BinarySearchRecursion {

    public static void main(String [] args) {
        var input = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        var result = searchWithRecursion(input, 9);

        if (result) {
            System.out.println("Value found");
        } else {
            System.out.println("Value not found");
        }
    }

    public static boolean searchWithRecursion(Integer[] array, int target) {
        if (array.length == 0) {
            return false;
        } else {
            var midpoint = (int)Math.floor((array.length)/2);
            if (array[midpoint] == target) {
                return true;
            } else {
                if (array[midpoint] < target) {
                    return searchWithRecursion(Arrays.copyOfRange(array, midpoint + 1, array.length), target);
                } else {
                    return searchWithRecursion(Arrays.copyOfRange(array, 0, midpoint), target);
                }
            }
        }
    }
}
