package searchAlgorithms;

import sortingAlgorithms.Shuffling;

import java.util.Arrays;

import static sortingAlgorithms.utils.HelperFunctions.exchange;
import static sortingAlgorithms.utils.HelperFunctions.less;

public class QuickSelect {

    public static void main(String[] args) {
        var array = new Integer[] {3, 4, 7, 10, 15, 20};
        //3, 4, 7, 10, 15, 20
        System.out.println(Arrays.toString(array));
        int i = 0;
        while (i < 10) {
            System.out.println(select(array, 4, false));
            i++;
        }

//        i = 0;
//        while (i < 10) {
//            System.out.println(select(array, 5, false));
//            i++;
//        }
//
//        i = 0;
//        while (i < 10) {
//            System.out.println(select(array, 4, false));
//            i++;
//        }
//
//        i = 0;
//        while (i < 10) {
//            System.out.println(select(array, 3, false));
//            i++;
//        }
//
//        i = 0;
//        while (i < 10) {
//            System.out.println(select(array, 2, false));
//            i++;
//        }


    }

    private static Comparable select(Comparable[] a, int k, boolean isSmallest) {
        if (k-1 <= 0 || k-1 >= a.length) {
            throw new IllegalArgumentException("index is not between 0 and " + a.length + ": " + k);
        }
        int lo = 0, hi = a.length - 1;
        while (hi > lo) {  // Note here is the equal
            int j = partition(a, lo, hi);
            if (j < k-1) {
                lo = j + 1;
            } else if (j > k-1) {
                hi = j - 1;
            } else {
                return a[j];
            }
        }

        return a[lo];
    }

    private static int partition(Comparable[] a, int low, int high) {
        int i = low;
        int j = high + 1;

        while(true) {
            while (less(a[++i], a[low])) {
                if (i == high) break;
            }

            while (less(a[low], a[--j])) {
                if (j == low) break;
            }

            if (i >= j) {
                break;
            }
            exchange(a, i, j);
        }
        exchange(a, low, j);
        return j;
    }
}
