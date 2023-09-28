package assignments;

import sortingAlgorithms.ShellSort;

import java.util.Arrays;

public class DutchNationalFlag {

    /*
    Question 3
    Dutch national flag. Given an array of N buckets, each containing a red, white, or blue pebble, sort them by color. The allowed operations are:
    swap(i,j): swap the pebble in bucket i with the pebble in bucket j.
    color(i): color of pebble in bucket i.
    The performance requirements are as follows:
    At most N calls to color().
    At most N calls to swap().
    Constant extra space.
     */

    public static void main(String[] args) {
        var a = new Bucket[]{new Bucket(Pebble.WHITE), new Bucket(Pebble.RED),
                new Bucket(Pebble.WHITE), new Bucket(Pebble.BLUE),
                new Bucket(Pebble.WHITE), new Bucket(Pebble.RED)};
        System.out.println(Arrays.toString(a));
        //[Bucket{pebble=WHITE}, Bucket{pebble=RED}, Bucket{pebble=WHITE}, Bucket{pebble=BLUE}, Bucket{pebble=WHITE}, Bucket{pebble=RED}]
        sort(a);
        System.out.println(Arrays.toString(a));
        //[Bucket{pebble=RED}, Bucket{pebble=RED}, Bucket{pebble=WHITE}, Bucket{pebble=WHITE}, Bucket{pebble=WHITE}, Bucket{pebble=BLUE}]
    }
    enum Pebble {
        RED,
        WHITE,
        BLUE
    }

    public static class Bucket{
        private Pebble pebble;

        @Override
        public String toString() {
            return "Bucket{" +
                    "pebble=" + pebble +
                    '}';
        }

        Bucket(Pebble pebble) {
            this.pebble = pebble;
        }
    }

    public static void sort(Bucket[] buckets) {
        assert buckets.length > 0;
        var N = buckets.length;
        int i = 0;
        while (i < N) {
            for (int j = i+1; j < N; j++) {
                if (color(buckets, i).ordinal() > color(buckets, j).ordinal()) {
                    swap(buckets, i, j);
                }
            }
            i++;
        }
    }

    private static Pebble color(Bucket[] buckets, int i) {
        return buckets[i].pebble;
    }

    private static void swap(Bucket[] buckets, int i, int j) {
        var temp = buckets[i];
        buckets[i] = buckets[j];
        buckets[j] = temp;
    }
}
