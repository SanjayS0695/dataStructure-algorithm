package sortingAlgorithms;

import java.util.Arrays;

import static sortingAlgorithms.utils.HelperFunctions.exchange;

public class QuickSort3Way {

    public static void main(String[] args) {
        var array = new Integer[] {5, 4, 3, 2, 1, 10, 9, 5, 17, 5, 13, 0};
        System.out.println(Arrays.toString(array));
        sort(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
        //[0, 1, 2, 3, 4, 5, 5, 5, 9, 10, 13, 17]
    }
    private static void sort(Comparable[] a, int low, int high) {
        if (high <= low) {
            return;
        }
        int lt = low;
        int gt = high;
        int i = low;
        Comparable v = a[low];

        while(i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) {
                exchange(a, i++, lt++);
            } else if (cmp > 0) {
                exchange(a, gt--, i);
            } else {
                i++;
            }
        }

        sort(a, low, lt -1);
        sort(a, gt+1, high);
    }
}
