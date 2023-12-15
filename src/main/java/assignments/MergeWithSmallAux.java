package assignments;

import java.util.Arrays;

public class MergeWithSmallAux {

    public static void main(String[] args) {
        Comparable[] a = {40, 61, 70, 71, 99, 20, 51, 55, 75, 100};
        merge(a, a.length);
        System.out.println(Arrays.toString(a));
    }

    public static void merge(Comparable[] a, int N) {
        Comparable[] aux = new Comparable[N/2];
        int M = N/2;
        for (int i = 0; i < M; i++) {
            aux[i] = a[i];
        }

        int i = 0;
        int j = M;
        int k = 0;
        while(k < N) {
            if (i >= M) {
                a[k++] = a[j++];
            } else if (j >= N) {
                a[k++] = aux[i++];
            } else if (aux[i].compareTo(a[j]) < 0) {
                a[k++] = aux[i++];
            } else {
                a[k++] = a[j++];
            }
        }
    }
}
