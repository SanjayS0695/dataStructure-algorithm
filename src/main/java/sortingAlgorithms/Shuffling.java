package sortingAlgorithms;

import java.util.Arrays;
import java.util.Random;

import static sortingAlgorithms.utils.HelperFunctions.exchange;

public class Shuffling {

    public static void main(String[] args) {
        var testArray = new Integer[]{5, 7, 2, 8, 6, 9, 0, 5};
        System.out.println(Arrays.toString(testArray));
        //[5, 7, 2, 8, 6, 9, 0, 5]
        shuffle(testArray);
        System.out.println(Arrays.toString(testArray));
        //[0, 7, 2, 6, 5, 9, 5, 8]
    }

    public static void shuffle(Comparable[] array) {
        Random random = new Random();
        int N = array.length;
        for (int i = 0; i<N; i++) {
            var r = random.nextInt(i+1);
            exchange(array, i , r);
        }
    }
}
