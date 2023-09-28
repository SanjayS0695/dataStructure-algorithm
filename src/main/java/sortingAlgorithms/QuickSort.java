package sortingAlgorithms;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        var testArray = new int[] {5, 7, 2, 8 ,6, 9, 0, 5};
        System.out.println(Arrays.toString(testArray));
        //[5, 7, 2, 8, 6, 9, 0, 5]
        quickSort(testArray, 0, testArray.length-1);
        System.out.println(Arrays.toString(testArray));
        //[0, 2, 5, 5, 6, 7, 8, 9]

        var testArray1 = new int[] {9,14,3,2,43,11,58,22};
        System.out.println(Arrays.toString(testArray1));
        //[9, 14, 3, 2, 43, 11, 58, 22]
        quickSort(testArray1, 0, testArray.length-1);
        System.out.println(Arrays.toString(testArray1));
        //[2, 3, 9, 11, 14, 22, 43, 58]
    }

    private static void quickSort(int[] array, int low, int high) {
        int i = low; int j = high;

        var pivot = array[(low + (high-low)/2)];
        while (i <=j) {
            while(array[i] < pivot) {
                i++;
            }
            while(array[j] > pivot) {
                j--;
            }

            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j) {
            quickSort(array, low, j);
        }
        if (i < high) {
            quickSort(array, i, high);
        }
    }
}
