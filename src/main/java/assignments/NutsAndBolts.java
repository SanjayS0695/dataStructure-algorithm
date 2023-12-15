package assignments;

import sortingAlgorithms.QuicksortComparable;
import sortingAlgorithms.Shuffling;

import java.util.Arrays;

import static sortingAlgorithms.utils.HelperFunctions.exchange;
import static sortingAlgorithms.utils.HelperFunctions.less;

public class NutsAndBolts {

    public static void main(String[] args) {
        var nuts = new Integer[] {5, 4, 3, 2, 1, 10, 9, 17, 13, 0};
        Shuffling.shuffle(nuts);
        sort(nuts, 0 , nuts.length-1);
        System.out.println(Arrays.toString(nuts));
        //[0, 1, 2, 3, 4, 5, 9, 10, 13, 17]

        var bolts = new Integer[] {3, 5, 4, 10, 1, 2, 17, 13, 9, 0};
        Shuffling.shuffle(bolts);
        sort(bolts, 0, bolts.length -1);
        System.out.println(Arrays.toString(bolts));
        //[0, 1, 2, 3, 4, 5, 9, 10, 13, 17]
    }


    private static void sort(Comparable[] a, int low, int high) {
        if (high<=low) {
            return;
        }

        int p = partition(a, low, high);

        sort(a, low, p-1);
        sort(a, p+1, high);
    }

    private static int partition(Comparable[] a, int low, int high) {
        int i = low;
        int j = high + 1;

        while(true) {
            while (less(a[++i], a[low])) {
                if (i == high) {
                    break;
                }
            }

            while(!less(a[--j], a[low])) {
                if (j == low) {
                    break;
                }
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
