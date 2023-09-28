package sortingAlgorithms;

import java.util.Arrays;

import static sortingAlgorithms.utils.HelperFunctions.exchange;
import static sortingAlgorithms.utils.HelperFunctions.less;

public class ShellSort {

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
        int N = array.length;
        int h = 1;
        while(h < N/3) {
            h += (3*h +1);
        }
        while(h>=1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >=h && less(array[j], array[j-h]); j -= h) {
                    exchange(array, j, j-h);
                }
            }
            h = h/3;
        }
    }
}
