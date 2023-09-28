package sortingAlgorithms;

import java.util.Arrays;
import java.util.Random;

public class BogoSort {

    private static final  Random generator = new Random();

    public static void main(String[] args) {
        var testArray = new int[] {5, 7, 2, 8 ,6, 9, 0, 5};
        System.out.println(Arrays.toString(testArray));
        bogoSort(testArray);
        System.out.println(Arrays.toString(testArray));
    }

    private static void bogoSort(int[] array) {
        while (!isSorted(array)) {
            for (int i=0; i< array.length; i++) {
                int randomPosition = generator.nextInt(array.length);
                int temp = array[i];
                array[i] = array[randomPosition];
                array[randomPosition] = temp;
            }
        }
    }

    private static boolean isSorted(int[] array) {
        for (int i = 1; i< array.length; i++) {
            if (array[i-1] > array[i]) {
                return false;
            }
        }
        return true;
    }
}
