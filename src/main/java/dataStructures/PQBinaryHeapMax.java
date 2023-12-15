package dataStructures;

import java.util.Arrays;

public class PQBinaryHeapMax <T extends Comparable<T>> {

    private T[] pq;
    private int N;

    public PQBinaryHeapMax(int capacity) {
        this.pq = (T[]) new Comparable[capacity+1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void insert(T key) {
        pq[++N] = key;
        swim(N);
    }

    public T delMax() {
        T max = pq[1];
        exchange(1, N--);
        sink(1);
        pq[N+1] = null;
        return max;
    }

    private void sink(int k) {
        while (2*k < N) {
            int j = 2*k;
            if (j < N && less(j, j+1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            exchange(k, j);
            k = j;
        }
    }

    private void swim(int k) {
        while(k > 1 && less(k/2, k)) {
            exchange(k, k/2);
            k = k/2;
        }
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exchange(int i, int j) {
        T temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    @Override
    public String toString() {
        return "PQBinaryHeapMax{" +
                "pq=" + Arrays.toString(pq) +
                ", N=" + N +
                '}';
    }
}
