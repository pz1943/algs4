import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdDraw;
public class KdTree {
    
    private Node root;
    private int size;
    
    private static class Node {
        private Point2D p;      // the point
        private RectHV rect;    // the axis-aligned rectangle corresponding to this node
        private Node lb;        // the left/bottom subtree
        private Node rt;        // the right/top subtree
        private Boolean isV;    // vertical if true, horizontal if false;
        
        public Node(Point2D p, boolean isV, RectHV rect) {
            this.p = p;
            this.isV = isV;
            this.rect = rect;
        }
    }
    
    public KdTree() {
        // construct an empty set of points 
        size = 0;
    }
    public boolean isEmpty() {
        // is the set empty? 
        return size == 0;
    }
    public int size() {
        // number of points in the set 
        return size;
    }
    public void insert(Point2D p) {
        // add the point to the set (if it is not already in the set)
        if (root == null) root = put(null, p, true, new RectHV(0, 0, 1, 1));
        else root = put(root, p, false, root.rect);
    }
    
    private Node put(Node x, Point2D p, boolean isV, RectHV rect) { // put under node x, with direction isV & V
        if (x == null) {
            size++;
            return new Node(p, isV, rect);
        }
        double cmp;
        if (isV) {
            cmp = p.y() - x.p.y(); // father is H, >node means on top.
        } else cmp = p.x() - x.p.x();
        if (cmp < 0) {
            if (x.lb != null) 
                x.lb = put(x.lb,  p, !isV, null);
            else {
                size++;
                x.lb = new Node(p, isV, newRect(x.rect, !isV, true, x.p));
            }
        }
        else if (cmp >= 0) {
            if ((p.y() == x.p.y()) && (p.x() == x.p.x())) return x;
            if (x.rt != null) 
                x.rt = put(x.rt,  p, !isV, null);
            else {
                size++;
                x.rt = new Node(p, isV, newRect(x.rect, !isV, false, x.p));
            }
        }
        return x;
    }
    
    private RectHV newRect(RectHV origin, boolean isV, boolean isLB, Point2D p) { 
        RectHV rect;
        if (!isV) { // if new node is V, father node is H,father node split its rect to two top and bottom half
            if (isLB) {
                rect = new RectHV(origin.xmin(), origin.ymin(), origin.xmax(), p.y());
            } else {
                rect = new RectHV(origin.xmin(), p.y(), origin.xmax(), origin.ymax());
            }
        } else {
            if (isLB) {
                rect = new RectHV(origin.xmin(), origin.ymin(), p.x(), origin.ymax());
            } else {
                rect = new RectHV(p.x(), origin.ymin(), origin.xmax(), origin.ymax());
            }
        }
        return rect;
    }
    
    public boolean contains(Point2D p) {
        // does the set contain point p? 
        return get(p);
    }
    
    private boolean get(Point2D p) {
        return get(root, p);
    }

    private boolean get(Node x, Point2D p) {
        if (x == null) return false;
        
        double cmp;
        if (!x.isV) {
            cmp = p.y() - x.p.y(); // father is H, >node means on top.
        } else cmp = p.x() - x.p.x();
        if      (cmp < 0) return get(x.lb, p);
        else if (cmp > 0) return get(x.rt, p);
        else if ((p.y() == x.p.y()) && (p.x() == x.p.x())) return true;
        else return get(x.rt, p);
    }
    public void draw() {
        // draw all points to standard draw 
        draw(root);
    }
    
    private void draw(Node x) {
        if (x == null) return;
        draw(x.lb);
        x.p.draw();
        Point2D from, to;
        if (x.isV) {
            from = new Point2D(x.p.x(), x.rect.ymin());
            to = new Point2D(x.p.x(), x.rect.ymax());
            StdDraw.setPenColor(StdDraw.RED);
        } else {
            from = new Point2D(x.rect.xmin(), x.p.y());
            to = new Point2D(x.rect.xmax(), x.p.y());
            StdDraw.setPenColor(StdDraw.BLUE);
        }
        from.drawTo(to);
        draw(x.rt);
    }
    /*
    private void printTree() {
        printTree(root);
    }
    private void printTree(Node x) {
        if (x == null) return;
        
        StdOut.print(x.p);
        StdOut.print("  ");
        StdOut.print(x.isV);
        StdOut.print("  ");
        StdOut.println(x.rect);
        StdOut.print("left");
        printTree(x.lb);
        StdOut.print("right");
        printTree(x.rt);
    }
    */
    
    public Iterable<Point2D> range(RectHV rect) {
        // all points that are inside the rectangle 
        Queue<Point2D> q = new Queue<Point2D>();
        if (root == null) return q;
        q = nodesMayIntersects(root, rect, q);
        q.enqueue(root.p);
        Queue<Point2D> result = new Queue<Point2D>();
        
        for (Point2D p : q) {
            if (rect.contains(p)) result.enqueue(p);
        }
        return result;
    }
    
    private Queue<Point2D> nodesMayIntersects(Node x, RectHV that, Queue<Point2D> queue) {
        if (x != null) {
            if (x.lb != null) {
                if (x.lb.rect.intersects(that)) {
                    queue.enqueue(x.lb.p);
                    nodesMayIntersects(x.lb, that, queue);
                }
            }
            if (x.rt != null) {
                if (x.rt.rect.intersects(that)) {
                    queue.enqueue(x.rt.p);
                    nodesMayIntersects(x.rt, that, queue);
                }
            }
        }
        return queue;
    }
    
    private class Nearest {
        private double dis;
        private Point2D p;
        public Nearest(double dis, Point2D p) {
            this.dis = dis;
            this.p = p;
        }
    }
    
    public Point2D nearest(Point2D p) {
        // a nearest neighbor in the set to point p; null if the set is empty 
        if (root == null) return null;
        Nearest n = new Nearest(Double.POSITIVE_INFINITY, root.p);
        return nearest(root, p, n).p;
    }
    
    private Nearest nearest(Node x, Point2D p, Nearest n) {
        if (x == null) return n;
        double dis = p.distanceSquaredTo(x.p);
        if (dis < n.dis) {
            n.dis = dis;
            n.p = x.p;
        }
        double cmp = 0;
        if (x.isV) cmp = p.x() - x.p.x();
        else cmp = p.y() - x.p.y();
        
        if (cmp < 0) {   // on the left/bottom part
            n = nearest(x.lb, p, n);
            RectHV rect = newRect(x.rect, x.isV, false, x.p); // right/top rect
            if (n.dis > rect.distanceSquaredTo(p)) {
                n = nearest(x.rt, p, n);
            }
        } else {
            n = nearest(x.rt, p, n);
            RectHV rect = newRect(x.rect, x.isV, true, x.p); // left/bottom rect
            if (n.dis > rect.distanceSquaredTo(p)) {
                n = nearest(x.lb, p, n);
            }
        }
        return n;
    }

    public static void main(String[] args) {
        // unit testing of the methods (optional) 
        /*
        String filename = args[0];
        In in = new In(filename);

        StdDraw.enableDoubleBuffering();

        // initialize the two data structures with point from standard input
        KdTree kdtree = new KdTree();
        while (!in.isEmpty()) {
            double x = in.readDouble();
            double y = in.readDouble();
            Point2D p = new Point2D(x, y);
            kdtree.insert(p);
            StdDraw.clear();
            kdtree.draw();
            StdDraw.show();
        }
        Point2D p = new Point2D(0.3, 0.3);
        p = kdtree.nearest(p);
        StdOut.print(p);
        for (Point2D p1 : kdtree.range(new RectHV(0, 0, 1, 1))) {
            StdOut.println(p1);
            StdOut.println(kdtree.contains(p1));
        }
        */
    }
}