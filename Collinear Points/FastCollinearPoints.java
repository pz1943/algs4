// pz1943@163.com

import java.util.Arrays;
import edu.princeton.cs.algs4.StdDraw;
import java.util.Comparator;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;

public class FastCollinearPoints {
    
    private int segsIndex = 0;
    private LineSegment[] lineSegments;
    public FastCollinearPoints(Point[] points) {
        // finds all line segments containing 4 or more points
        lineSegments = new LineSegment[points.length * points.length];
        Point[] reSortedCopy;
        Point[] sortedCopy = new Point[points.length];
        if (points.length == 0) throw new java.lang.NullPointerException();
        for (int i = 0; i < points.length; i++) {
            if (points[i] == null) throw new java.lang.NullPointerException();
            sortedCopy[i] = points[i];
        }
        Arrays.sort(sortedCopy);
        for (int i = 0; i < points.length - 1; i++) {
            if (sortedCopy[i].compareTo(sortedCopy[i + 1]) == 0) 
                throw new java.lang.IllegalArgumentException();
        }
        reSortedCopy = Arrays.copyOf(sortedCopy, sortedCopy.length);
        
        for (int i = 0; i < points.length; i++) {
            Comparator<Point>  myCom = sortedCopy[i].slopeOrder();
            Arrays.sort(reSortedCopy, myCom); 
            for (int j = 1; j < points.length - 1;) {
                double sp1;
                double sp2;
                int k = j;
                do {
                    sp1 = sortedCopy[i].slopeTo(reSortedCopy[j]);
                    sp2 = sortedCopy[i].slopeTo(reSortedCopy[++j]);
                    if (j == points.length - 1) {
                        if (sp1 == sp2)
                            j += 1;
                        break;
                    }
                } while (sp1 == sp2);
                if (j > k + 2) {
                    Point[] tmpPoints = Arrays.copyOfRange(reSortedCopy, k, j);
                    Point endPoint = getEnd(tmpPoints);
                    Point beginPoint = getBegin(tmpPoints);
                    if (sortedCopy[i].compareTo(beginPoint) < 0) {
                        lineSegments[segsIndex] = new LineSegment(sortedCopy[i], endPoint); 
                        segsIndex++;
                    }
                }
            }
        }
    }
    

    private Point getEnd(Point[] points) {
        Point end = points[0];
        for (int i = 1; i < points.length; i++) {
            if (end.compareTo(points[i]) < 0)
                end = points[i];
        }
        return end;
    }
    private Point getBegin(Point[] points) {
        Point begin = points[0];
        for (int i = 1; i < points.length; i++) {
            if (begin.compareTo(points[i]) > 0)
                begin = points[i];
        }
        return begin;
    }
    public int numberOfSegments() {       
        // the number of line segments
        return segsIndex;
    }
    
    public LineSegment[] segments() {
        LineSegment[] segs = new LineSegment[segsIndex];
        for (int i = 0; i < segsIndex; i++) 
            segs[i] = lineSegments[i];
        return segs;
    }
    
    public static void main(String[] args) {
        
        // read the n points from a file
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }
        
        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        
        StdDraw.show();
        
        // print and draw the line segments
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}