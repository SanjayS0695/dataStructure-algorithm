package assignments;

public class CountingInversions {

    public static void main(String[] args) {
        Comparable[] a = {5, 3, 2, 4, 1};
        System.out.println(countInversions(a));
    }

    public static int countInversions(Comparable[] a) {
        int N = a.length;
        return  mergesort(a, N);
    }

    private static int mergesort(Comparable[] a, int size) {
        int count = 0;
        if (size < 2) {
            return 0;
        }
        int mid = size/2;

        Comparable[] left = new Comparable[mid];
        Comparable[] right = new Comparable[size-mid];
        int i = 0;
        int j = mid;
        while (i < mid || j < size) {
            if (i < mid) {
                left[i] = a[i];
                i++;
            }
            if (j < size) {
                right[j-mid] = a[j];
                j++;
            }
        }

        count += mergesort(left, mid);
        count += mergesort(right, size-mid);
        count += merge(a, left, right, mid, size - mid);
        return count;
    }

    public static int merge(Comparable[] a, Comparable[] left, Comparable[] right, int leftSize, int rightSize) {
        int i = 0;
        int j = 0;
        int k = 0;
        int count = 0;
        while(i < leftSize && j < rightSize) {
            if (left[i].compareTo(right[j]) < 0) {
                a[k++] = left[i++];
            } else {
                count += (leftSize - i);
                a[k++] = right[j++];
            }
        }

        while(i < leftSize) {
            a[k++] = left[i++];
        }

        while(j < rightSize) {
            a[k++] = right[j++];
        }
        return count;
    }
}
