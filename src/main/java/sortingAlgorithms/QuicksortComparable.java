package sortingAlgorithms;

import java.util.Arrays;

import static sortingAlgorithms.utils.HelperFunctions.exchange;
import static sortingAlgorithms.utils.HelperFunctions.less;

public class QuicksortComparable {

    public static void main(String[] args) {
        var array = new Integer[] {5, 4, 3, 2, 1, 10, 9, 17, 13, 0};
        System.out.println(Arrays.toString(array));
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(Comparable[] a) {
        Shuffling.shuffle(a);
        sort(a, 0, a.length-1);
    }

    private static void sort(Comparable[] a, int low, int high) {
        if (high <= low) {
            return;
        }
        int p = partition(a, low, high);
        sort(a, low, p-1);
        sort(a, p+1, high);
    }

    private static int partition(Comparable[] a, int low, int high) {
        int k = low;
        int i = low;
        int j = high+1;

        while(true) {
            while(less(a[++i], a[k])) {
               if (i == high) {
                   break;
               }
            }

            while(!less(a[--j], a[k])) {
                if (j == k) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exchange(a, i , j);
        }
        exchange(a, k , j);
        return j;
    }
}
