package assignments;

import sortingAlgorithms.ShellSort;

import java.util.Arrays;

public class IntersectionOfTwoPoints {

    //    Intersection of two sets.
    //    Given two arrays a[] and b[], each containing N distinct 2D points in the plane,
    //    design a subquadratic algorithm to count the number of points that are contained both in array a[] and array b[].

    public static void main(String[] args) {
        var a = new Point[] {new Point(8,9), new Point(0,1), new Point(1,2), new Point(2,3) ,new Point(3,4), new Point(4,5)};
        System.out.println(Arrays.toString(a));
        //[Point{x=8, y=9}, Point{x=0, y=1}, Point{x=1, y=2}, Point{x=2, y=3}, Point{x=3, y=4}, Point{x=4, y=5}]
        var b = new Point[] {new Point(9,10), new Point(8,9), new Point(7,8), new Point(6,7) ,new Point(5,6), new Point(4,5)};
        System.out.println(Arrays.toString(a));
        //[Point{x=8, y=9}, Point{x=0, y=1}, Point{x=1, y=2}, Point{x=2, y=3}, Point{x=3, y=4}, Point{x=4, y=5}]
        System.out.println(Arrays.toString(evaluate(a, b)));
        //[Point{x=4, y=5}, Point{x=8, y=9}, null, null, null, null]
    }

    public static class Point implements Comparable<Point> {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        @Override
        public int compareTo(Point that) {
            if (this.x < that.x) {
                return -1;
            }
            if (this.y < that.y) {
                return -1;
            }
            if (this.x > that.x) {
                return 1;
            }
            if (this.y > that.y) {
                return 1;
            }
            return 0;
        }

    }

    public static Point[] evaluate(Point[] a, Point[] b) {
        ShellSort.sort(a);
        ShellSort.sort(b);

        var i = 0;
        var j = 0;
        var count = 0;
        var N = a.length;
        var intersectingPoints = new Point[N];
        int k = 0;
        while(i < N && j < N) {
            if (a[i].compareTo(b[j]) == 0) {
                intersectingPoints[k++] = a[i];
                count++;
                i++;
                j++;
            } else if (a[i].compareTo(b[j]) < 0) {
                i++;
            } else {
                j++;
            }
        }
        return intersectingPoints;
    }
}
