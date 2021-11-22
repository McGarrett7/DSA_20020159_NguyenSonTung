package Coursera.Week7;

import java.util.Queue;
import java.util.Arrays;
import java.util.LinkedList;

public class FastCollinearPoints {
    private int n;            // the number of line segments
    private LineSegment[] line;    // the line segments

    // finds all line segments containing 4 or more points
    public FastCollinearPoints(Point[] points) {
        if (points == null) {
            throw new IllegalArgumentException();
        }

        int length = points.length;
        for (int i = 0; i < length; i++) {
            if (points[i] == null) {
                throw new IllegalArgumentException();
            }
        }

        Point[] dup = points.clone();
        Arrays.sort(dup);
        for (int i = 0; i < length - 1; i++) {
            if (dup[i].compareTo(dup[i + 1]) == 0) {
                throw new IllegalArgumentException();
            }
        }

        n = 0;
        Queue<LineSegment> lineQueue = new LinkedList<LineSegment>();
        for (int i = 0; i < length; i++) {
            Arrays.sort(dup, points[i].slopeOrder());
            int head = 1;
            int tail = head + 1;
            while (tail < length) {
                double headSlope = points[i].slopeTo(dup[head]);
                while (tail < length && headSlope == points[i].slopeTo(dup[tail])) {
                    tail++;
                }
                if (tail - head >= 3) {
                    boolean check = true;
                    Point max = new Point(-32767, -32767);
                    for (int j = head; j < tail; j++) {
                        if (points[i].compareTo(dup[j]) > 0) {
                            check = false;
                            break;
                        }
                        if (dup[j].compareTo(max) > 0) {
                            max = dup[j];
                        }
                    }
                    if (check) {
                        LineSegment tmpLine = new LineSegment(points[i], max);
                        lineQueue.add(tmpLine);
                        n++;
                    }
                }

                head = tail;
                tail++;
            }
        }

        line = new LineSegment[n];
        for (int i = 0; i < n; i++) {
            line[i] = lineQueue.remove();
        }
    }

    // the number of line segments
    public int numberOfSegments() {
        return n;
    }

    // the line segments
    public LineSegment[] segments() {
        return line.clone();
    }
}
