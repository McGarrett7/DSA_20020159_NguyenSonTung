package Coursera.Week7;

import java.util.Queue;
import java.util.Arrays;
import java.util.LinkedList;

public class BruteCollinearPoints {
    private int n;            // the number of line segments
    private LineSegment[] line;    // the line segments

    // finds all line segments containing 4 points
    public BruteCollinearPoints(Point[] points)
    {
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
            if (dup[i].slopeTo(dup[i + 1]) == Double.NEGATIVE_INFINITY) {
                throw new IllegalArgumentException();
            }
        }

        n = 0;
        Queue<LineSegment> lineQueue = new LinkedList<LineSegment>();
        for (int i = 0; i < (length - 3); i++) {
            for (int j = i + 1; j < (length - 2); j++) {
                for (int m = j + 1; m < (length - 1); m++) {
                    if (dup[i].slopeTo(dup[j]) != dup[i].slopeTo(dup[m])) {
                        continue;
                    }
                    for (int n = m + 1; n < length; n++) {
                        if (dup[i].slopeTo(dup[j]) == dup[i].slopeTo(dup[n])) {
                            n++;
                            LineSegment tmpLine = new LineSegment(dup[i], dup[n]);
                            lineQueue.add(tmpLine);
                        }
                    }
                }
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