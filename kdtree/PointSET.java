import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.Queue;
public class PointSET {
    
    private SET<Point2D> pointSet;
    public PointSET() {
        // construct an empty set of points 
        pointSet = new SET<Point2D>();
    }
    public boolean isEmpty() {
        // is the set empty? 
        return size() == 0;
    }
    public int size() {
        // number of points in the set 
        return pointSet.size();
    }
    public void insert(Point2D p) {
        // add the point to the set (if it is not already in the set)
        pointSet.add(p);
    }
    public boolean contains(Point2D p) {
        // does the set contain point p? 
        return pointSet.contains(p);
    }
    public void draw() {
        // draw all points to standard draw 
        for (Point2D p : pointSet) {
            p.draw();
        }
    }
    public Iterable<Point2D> range(RectHV rect) {
        // all points that are inside the rectangle 
        Queue<Point2D> q = new Queue<Point2D>();
        for (Point2D p : pointSet) {
            if (rect.contains(p)) q.enqueue(p);
        }
        return q;
    }
    public Point2D nearest(Point2D p) {
        // a nearest neighbor in the set to point p; null if the set is empty 
        Point2D nearestP = null;
        double nearestSqureDis = Double.POSITIVE_INFINITY;
        for (Point2D pInSet : pointSet) {
            double squreDis = pInSet.distanceSquaredTo(p);
            if (squreDis < nearestSqureDis) {
                nearestP = pInSet;
                nearestSqureDis = squreDis;
            }
        }
        return nearestP;
    }

    public static void main(String[] args) {
        // unit testing of the methods (optional) 
    }
}