package sortingAlgorithms.utils;

public class HelperFunctions {
    public static boolean less(Comparable a, Comparable b){
        return a.compareTo(b) <0;
    }

    public static void exchange(Comparable[] array, int i, int j) {
        var temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
