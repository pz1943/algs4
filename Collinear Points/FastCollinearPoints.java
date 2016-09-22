import java.util.ArrayList;
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
        int n = points.length * points.length;
        ArrayList<Point> tuplePoints = new ArrayList<Point>();
        Point[] unOrdered = new Point[points.length];
        
        for (int i = 0; i < points.length; i++) {
            unOrdered[i] = points[i];
        }
        for (int i = 0; i < points.length; i++) {
            Comparator<Point>  myCom = unOrdered[i].slopeOrder();
            Arrays.sort(points, myCom); 
            for (int j = 1; j < points.length - 1;) {
                double sp1;
                double sp2;
                int k = j;
                do {
                    sp1 = unOrdered[i].slopeTo(points[j]);
                    sp2 = unOrdered[i].slopeTo(points[++j]);
                    if (j == points.length - 1) {
                        j += 1;
                        break;
                    }
                } while (sp1 == sp2);
                
                Point beginPoint;
                Point endPoint;
                if (j > k + 2) {
                    if (unOrdered[i].compareTo(points[k]) == 1) {
                        beginPoint = points[k];
                        if (unOrdered[i].compareTo(points[j - 1]) == 1) 
                            endPoint = unOrdered[i];
                        else endPoint = points[j - 1];
                    } else { 
                        beginPoint = unOrdered[i];
                        endPoint = points[j - 1];
                    }
                    boolean repeatFlag = false;
                    for (int l = 0; l < tuplePoints.size(); l += 2) 
                        if (beginPoint == tuplePoints.get(l) && endPoint == tuplePoints.get(l + 1)) 
                            repeatFlag = true;
                    if (!repeatFlag) {
                        tuplePoints.add(beginPoint);
                        tuplePoints.add(endPoint);
                        segsIndex++;
                    }
                }
            }
        }
        lineSegments  = new LineSegment[segsIndex];
        for (int i = 0; i < segsIndex; i++) {
            lineSegments[i] = new LineSegment(tuplePoints.get(i*2), tuplePoints.get(i*2 + 1)); 
        }
//        for (LineSegment segment : segs) {
//            if segment
//        }
//        
        
    }
    
    public int numberOfSegments() {       
        // the number of line segments
        return segsIndex;
    }
    
    
    public LineSegment[] segments() {
        return lineSegments;
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