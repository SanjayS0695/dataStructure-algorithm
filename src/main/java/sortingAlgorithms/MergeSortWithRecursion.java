package sortingAlgorithms;

import java.util.Arrays;

import static sortingAlgorithms.utils.HelperFunctions.less;

public class MergeSortWithRecursion {

    public static void main(String[] args) {
        var array = new Integer[] {5, 4, 3, 2, 1, 10, 9, 17, 13, 0};
        System.out.println(Arrays.toString(array));
        var aux = new Comparable[array.length];
        mergeSort(array, aux,0, array.length-1);

        System.out.println(Arrays.toString(array));
    }

    public static void mergeSort(Comparable[] a, Comparable[] aux, int low, int high) {
        if (high <= low) {
            return;
        }
        var mid = low+(high-low) /2;
        mergeSort(a, aux, low, mid);
        mergeSort(a, aux, mid+1, high);
        merge(a, aux, low, mid, high);
    }

    public static void merge(Comparable[] a, Comparable[] aux, int low, int mid, int high) {
        assert isSorted(a, low, mid);
        assert isSorted(a, mid+1, high);
        for (int k = low; k <= high; k++) {
            aux[k] = a[k];
        }

        int i = low;
        int j = mid+1;

        for (int k = low; k <= high; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > high) {
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }

        assert isSorted(a, low, high);
    }

    public static boolean isSorted(Comparable[] a, int low, int high) {
        for (int i = low; i < high-1; i++) {
            if (a[i].compareTo(a[i+1]) > 0) {
                return false;
            }
        }
        return true;
    }
}
