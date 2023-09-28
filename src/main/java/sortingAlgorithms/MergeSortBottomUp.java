package sortingAlgorithms;

import java.util.Arrays;

import static sortingAlgorithms.utils.HelperFunctions.less;

public class MergeSortBottomUp {

    public static void main(String[] args) {
        var array = new Integer[] {5, 4, 3, 2, 1, 10, 9, 17, 13, 0};
        System.out.println(Arrays.toString(array));
        mergeSort(array, 0, array.length-1);

        System.out.println(Arrays.toString(array));
    }

    private static Comparable[] aux;
    public static void mergeSort(Comparable[] a, int low, int high) {

        int N = a.length;
        aux = new Comparable[N];
        for (int m = 1; m <= high-low; m = 2*m) {
            for (int i = low; i < high; i +=2*m) {
                int from = i;
                int mid = i + m -1;
                int min = Math.min(i + 2*m-1, high);
                merge(a, aux, from, mid, min);
            }

        }
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
