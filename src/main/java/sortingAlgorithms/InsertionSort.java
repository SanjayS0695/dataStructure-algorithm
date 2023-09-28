package sortingAlgorithms;

import java.util.Arrays;

import static sortingAlgorithms.utils.HelperFunctions.exchange;
import static sortingAlgorithms.utils.HelperFunctions.less;

public class InsertionSort {

    public static void main(String[] args) {
        var testArray = new Integer[] {5, 7, 2, 8 ,6, 9, 0, 5};
        System.out.println(Arrays.toString(testArray));
        //[5, 7, 2, 8, 6, 9, 0, 5]
        sort(testArray);
        System.out.println(Arrays.toString(testArray));
        //[0, 2, 5, 5, 6, 7, 8, 9]

        var testArray1 = new Integer[] {9,14,3,2,43,11,58,22};
        System.out.println(Arrays.toString(testArray1));
        //[9, 14, 3, 2, 43, 11, 58, 22]
        sort(testArray1);
        System.out.println(Arrays.toString(testArray1));
        //[2, 3, 9, 11, 14, 22, 43, 58]
        var testArray2 = new String[] {"one","two","three","four","five","siz","seven","eight"};
        System.out.println(Arrays.toString(testArray2));
        sort(testArray2);
        System.out.println(Arrays.toString(testArray2));
        //[eight, five, four, one, seven, siz, three, two]
    }

    public static void sort(Comparable[] array) {
        var N = array.length;
        for (int i = 0; i<N; i++) {
            for (int j = i; j > 0; j--) {
                if (!less(array[j-1], array[j])) {
                    exchange(array, j, j-1);
                } else {
                    break;
                }
            }
        }
    }
}
