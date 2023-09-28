package assignments;

import sortingAlgorithms.ShellSort;

import java.util.Arrays;

public class Permutation {
    /*
    Question 2
    Permutation.
    Given two integer arrays of size N, design a subquadratic algorithm to determine whether one is a permutation of the other.
    That is, do they contain exactly the same entries but, possibly, in a different order.
     */
    public static void main(String[] args) {
        var a = new Integer[] {0, 1, 2, 3 ,4};
        System.out.println(Arrays.toString(a));
        //[0, 1, 2, 3, 4]
        var b = new Integer[] {4, 2, 3, 1 ,0};
        System.out.println(Arrays.toString(b));
        //[4, 2, 3, 1, 0]
        System.out.println(evaluate(a, b));
        //true

        var c = new Integer[] {0, 1, 2, 3 ,4};
        System.out.println(Arrays.toString(c));
        //[0, 1, 2, 3, 4]
        var d = new Integer[] {4, 5, 3, 1 ,0};
        System.out.println(Arrays.toString(d));
        //[4, 5, 3, 1, 0]
        System.out.println(evaluate(c, d));
        //false
    }

    public static boolean evaluate(Integer[] a, Integer[] b) {
        ShellSort.sort(a);
        ShellSort.sort(b);
        var N = a.length;
        for (int i=0;i<N;i++) {
            if (a[i] != b[i]){
                return false;
            }
        }
        return true;
    }
}
