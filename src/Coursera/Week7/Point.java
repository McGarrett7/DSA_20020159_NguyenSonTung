package Coursera.Week7;

import java.util.Comparator;
import edu.princeton.cs.algs4.StdDraw;

public class Point implements Comparable<Point> {

    private final int x;     // x-coordinate of this point
    private final int y;     // y-coordinate of this point

    /**
     * Initializes a new point.
     *
     * @param  x the <em>x</em>-coordinate of the point
     * @param  y the <em>y</em>-coordinate of the point
     */
    public Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
    }

    /**
     * Draws this point to standard draw.
     */
    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }

    /**
     * Draws the line segment between this point and the specified point
     * to standard draw.
     *
     * @param that the other point
     */
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    public double slopeTo(Point that) {
        if (this.y == that.y && this.x == that.x) {
            return Double.NEGATIVE_INFINITY;
        } else if (this.x == that.x) {
            return Double.POSITIVE_INFINITY;
        } else if (this.y == that.y) {
            return 0;
        } else {
            return (double) (that.y - this.y) / (that.x - this.x);
        }
    }

    public int compareTo(Point that) {
        if (this.y == that.y && this.x == that.x) {
            return 0;
        } else if (this.y < that.y || this.y == that.y && this.x < that.x) {
            return -1;
        } else {
            return 1;
        }
    }

    /**
     * Compares two points by the slope they make with this point.
     * The slope is defined as in the slopeTo() method.
     *
     * @return the Comparator that defines this ordering on points
     */
    public Comparator<Point> slopeOrder() {
        return new SlopeComparator(this);
    }

    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }

    private class SlopeComparator implements Comparator<Point> {

        Point comparePoint;

        private SlopeComparator(Point compare) {
            this.comparePoint = compare;
        }

        @Override
        public int compare(Point o1, Point o2) {
            double slope1 = comparePoint.slopeTo(o1);
            double slope2 = comparePoint.slopeTo(o2);
            return Double.compare(slope1, slope2);
        }

    }

    /**
     * Unit tests the Point data type.
     */
    public static void main(String[] args) {
        Point p1 = new Point(5000,2000);
        Point p2 = new Point (2000,8000);
        Point p3 = new Point(1000,9000);
        System.out.println(p1.slopeTo(p2));
        System.out.println(p1.slopeTo(p3));
        System.out.println(p3.slopeTo(p2));
    }
}
