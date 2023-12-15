package assignments.collinearPoints;

import java.util.Comparator;


public class Point implements Comparable<Point>{

    public final  Comparator<Point> SLOPE_ORDER = new ByOrder();
    private int x,y;
    Point(int x, int y ){
        this.x = x;
        this.y = y;
    }

    // plot this point to standard drawing
    public void draw() {
        /* DO NOT MODIFY */
        //StdDraw.point(x, y);
    }

    public void drawTo(Point point) {
        //
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public double slopeTo(Point p) {
        if (this.compareTo(p) == 0) {
            return Double.NEGATIVE_INFINITY;
        }

        if (this.x == p.x) {
            return Double.POSITIVE_INFINITY;
        }

        if (this.y == p.y) {
            return 0;
        }

        return (p.y - this.y) / (p.x - this.x);
    }

    @Override
    public int compareTo(Point o) {
        if (( this.x < o.x )|| ( this.y < o.y)) {
            return -1;
        } else if ((this.x > o.x) || (this.y > o.y)) {
            return 1;
        }
        return 0;
    }

    public class ByOrder implements Comparator<Point> {

        @Override
        public int compare(Point o1, Point o2) {
            double slope1 = o1.slopeTo(Point.this);
            double slope2 = o2.slopeTo(Point.this);

            if (slope1 < slope2) {
                return -1;
            } else if (slope1 > slope2) {
                return 1;
            }
            return 0;
        }
    }
}
