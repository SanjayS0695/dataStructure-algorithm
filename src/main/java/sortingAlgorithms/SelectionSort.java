package sortingAlgorithms;

import java.util.Arrays;

import static sortingAlgorithms.utils.HelperFunctions.exchange;
import static sortingAlgorithms.utils.HelperFunctions.less;

public class SelectionSort<T> {

    public static void main(String[] args) {
        var testArray = new Integer[] {5, 7, 2, 8 ,6, 9, 0, 5};
        System.out.println(Arrays.toString(testArray));
        //[5, 7, 2, 8, 6, 9, 0, 5]
        selectionSort(testArray);
        System.out.println(Arrays.toString(testArray));
        //[0, 2, 5, 5, 6, 7, 8, 9]

        var testArray1 = new Integer[] {9,14,3,2,43,11,58,22};
        System.out.println(Arrays.toString(testArray1));
        //[9, 14, 3, 2, 43, 11, 58, 22]
        selectionSort(testArray1);
        System.out.println(Arrays.toString(testArray1));
        //[2, 3, 9, 11, 14, 22, 43, 58]
        var testArray2 = new String[] {"one","two","three","four","five","siz","seven","eight"};
        System.out.println(Arrays.toString(testArray2));
        selectionSort(testArray2);
        System.out.println(Arrays.toString(testArray2));
        //[eight, five, four, one, seven, siz, three, two]
    }

    private static void selectionSort(Comparable[] array) {
        //var sortedArray = new int[array.length];
        for (int i=0; i< array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (!less(array[i], array[j])) {
                    exchange(array, i, j);
                }
            }
        }
    }
}
