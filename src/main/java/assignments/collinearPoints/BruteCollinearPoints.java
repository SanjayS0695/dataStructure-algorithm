package assignments.collinearPoints;

import searchAlgorithms.LinearSearch;

import java.util.Arrays;

public class BruteCollinearPoints {

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
        new BruteCollinearPoints(points);
    }

    BruteCollinearPoints(Point[] points) {
        int count = 0;
        Arrays.sort(points);
        int N = points.length;
        for (int p = 0; p < N; p++) {
            for (int q = p+1; q < N; q ++) {
                double pq = points[p].slopeTo(points[q]);
                for (int r = q+1; r < N; r++) {
                    double pr = points[p].slopeTo(points[r]);
                    for (int s = r+1; s < N; s++) {
                        double ps = points[p].slopeTo(points[s]);
                        if (pq == pr && pr == ps && pq == ps) {
                            System.out.printf("%s -> %s -> %s -> %s\n",
                                    points[p], points[q], points[r], points[s]);
                            count++;
                        }
                    }
                }
            }
        }
    }

    public int lineSegments() {
        return  0;
    }

    public class LineSegment {
        private Point p,q;

        LineSegment(Point p, Point q) {
            this.p = p;
            this.q = q;
        }

        @Override
        public String toString() {
            return "LineSegment{" +
                    "p=" + p +
                    ", q=" + q +
                    '}';
        }
    }
}
