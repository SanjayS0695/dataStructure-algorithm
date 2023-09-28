package sortingAlgorithms;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MergeSort {

    public static void main(String[] args) {
        var array = new int[] {5, 4, 3, 2, 1, 10, 9, 17, 13, 0};
        printArray(array);

        mergeSort(array, array.length);

        printArray(array);
    }

    private static void printArray(int[] array) {
        IntStream stream = Arrays.stream(array);

        // Displaying elements in Stream
        stream.forEach(str -> System.out.print(str + " "));
        System.out.println("");
    }
    public static void mergeSort(int[] array, int size) {
        if (size < 2) {
            return;
        }
        int mid = size/2;
        int[] left = new int[mid];
        int[] right = new int[size-mid];

        for (int i =0; i<mid; i++) {
            left[i] = array[i];
        }
        for (int j = mid; j < size; j++) {
            right[j-mid] = array[j];
        }
        mergeSort(left, mid);
        mergeSort(right, size-mid);
        merge(array, left, right, mid, size-mid);
    }

    private static void merge(int[] array, int[] left, int[] right, int leftSize, int rightSize) {
        int i=0; int j=0; int k=0;
        while(i < leftSize && j < rightSize) {
            if (left[i] < right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        while(i < leftSize) {
            array[k++] = left[i++];
        }
        while(j < rightSize) {
            array[k++] = right[j++];
        }
    }
}
