import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;

public class BruteCollinearPoints {
    private LineSegment[] segs;
    private int segsIndex = 0;
    private int n;
    public BruteCollinearPoints(Point[] points) {
        // finds all line segments containing 4 points
        n = points.length * points.length;
        segs = new LineSegment[n];

        for (int i = 0; i < points.length - 3; i++) {
            for (int j = 1; j < points.length - 2; j++) {
                double sp1 = points[i].slopeTo(points[j]);
                for (int k = j + 1; k < points.length; k++) {
                    double sp2 = points[i].slopeTo(points[k]);
                    if (sp1 == sp2) {
                        for (int l = k + 1; l < points.length; l++) {
                            double sp3 = points[i].slopeTo(points[l]);
                            if (sp2 == sp3) {
                                segs[segsIndex] = lineWith4(points[i], points[j], points[k], points[l]);
                                segsIndex++;
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
    
    private LineSegment lineWith4(Point p1, Point p2, Point p3, Point p4) {
        Point begin = g(g(p1, p2), g(p3, p4));
        Point end = m(m(p1, p2), m(p3, p4));
        return new LineSegment(begin, end);
    }
    
    private Point g(Point p1, Point p2) {
        return (p1.compareTo(p2) == 1) ? p1 : p2;
    }
    
    private Point m(Point p1, Point p2) {
        return (p1.compareTo(p2) == 1) ? p2 : p1;
    }
    public int numberOfSegments() {       
        // the number of line segments
        return segsIndex;
    }
    public LineSegment[] segments() {
        LineSegment[] resultSegments = new LineSegment[segsIndex];
        for (int i = 0; i < segsIndex; i++) {
            resultSegments[i] = segs[i];
        }
        return resultSegments;
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