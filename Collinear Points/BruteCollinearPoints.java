import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;
import java.util.ArrayList;

public class BruteCollinearPoints {
    private LineSegment[] lineSegments;
    private int segsIndex = 0;
    public BruteCollinearPoints(Point[] points) {
        // finds all line segments containing 4 points
        ArrayList<Point> tuplePoints = new ArrayList<Point>();
        
        if (points.length == 0) throw new java.lang.NullPointerException();
        for (int i = 0; i < points.length; i++) {
            if (points[i] == null) throw new java.lang.NullPointerException();
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].compareTo(points[j]) == 0) 
                    throw new java.lang.IllegalArgumentException();
            }
        }
        
        for (int i = 0; i < points.length - 3; i++) {
            for (int j = 1; j < points.length - 2; j++) {
                double sp1 = points[i].slopeTo(points[j]);
                for (int k = j + 1; k < points.length; k++) {
                    double sp2 = points[i].slopeTo(points[k]);
                    if (sp1 == sp2) {
                        for (int l = k + 1; l < points.length; l++) {
                            double sp3 = points[i].slopeTo(points[l]);
                            if (sp2 == sp3) {
                                Point beginPoint = g(g(points[i], points[j]), g(points[k], points[l]));
                                Point endPoint = m(m(points[i], points[j]), m(points[k], points[l]));
                                boolean repeatFlag = false;
                                for (int m = 0; m < tuplePoints.size(); m += 2) 
                                    if (beginPoint == tuplePoints.get(m) && endPoint == tuplePoints.get(m + 1)) 
                                    repeatFlag = true;
                                if (!repeatFlag) {
                                    tuplePoints.add(beginPoint);
                                    tuplePoints.add(endPoint);
                                    segsIndex++;
                                }
                                break;
                            }
                        }
                    }
                }
            }
        }
        lineSegments  = new LineSegment[segsIndex];
        for (int i = 0; i < segsIndex; i++) {
            lineSegments[i] = new LineSegment(tuplePoints.get(i*2), tuplePoints.get(i*2 + 1)); 
        }

    }
    
    private LineSegment lineWith4(Point p1, Point p2, Point p3, Point p4) {
        Point begin = g(g(p1, p2), g(p3, p4));
        Point end = m(m(p1, p2), m(p3, p4));
        return new LineSegment(begin, end);
    }
    
    private Point g(Point p1, Point p2) {
        return (p1.compareTo(p2) > 0) ? p1 : p2;
    }
    
    private Point m(Point p1, Point p2) {
        return (p1.compareTo(p2) > 0) ? p2 : p1;
    }
    public int numberOfSegments() {       
        // the number of line segments
        return segsIndex;
    }
    public LineSegment[] segments() {
        LineSegment[] segs = new LineSegment[lineSegments.length];
        for (int i = 0; i < lineSegments.length; i++) 
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
        BruteCollinearPoints collinear = new BruteCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}