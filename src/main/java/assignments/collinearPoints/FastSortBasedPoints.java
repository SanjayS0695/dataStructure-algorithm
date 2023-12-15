package assignments.collinearPoints;

import java.util.Arrays;

public class FastSortBasedPoints {

    public static void main(String[] args) {
        var p1 = new Point(10000, 0);
        var p2 = new Point(0, 10000);
        var p3 = new Point(3000, 7000);
        var p4 = new Point(7000, 3000);
        var p5 = new Point(20000, 21000);
        var p6 = new Point(3000, 4000);
        var p7 = new Point(14000, 15000);
        var p8 = new Point(3000, 6000);
        var points = new Point[]{p1, p2, p3, p4, p5, p6, p7, p8};

        var temp = points;
        for (int i = 0; i < points.length; i++) {
            var point = points[i];
            Arrays.sort(temp, point.SLOPE_ORDER);
            checkForCollinearPoints(temp, point);
        }
    }

    public static void checkForCollinearPoints(Point[] points, Point p) {
        var lastSlope = p.slopeTo(points[1]);
        var adj = 1;
        var start = 1;
        for (int i = 1; i < points.length; i ++) {
            var slope = p.slopeTo(points[i]);
            if (slope == lastSlope) {
                adj++;
            } else if (adj >= 3) {
                System.out.println(points[start] + " -> " + points[i]);
                //points from start to i is collinear
                adj = 1;
                lastSlope = slope;
                start = i;
            } else {
                adj = 1;
                lastSlope = slope;
                start = i;
            }
        }
        if (adj >= 3) {
            System.out.println(points[start] + " -> " + points[adj]);
            //collinear from start to adj
        }
    }
}
