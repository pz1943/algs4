// email: pz1943@163.com

import java.util.Comparator;

public class Solver {
    
    
    private NodeComparator cmp = new NodeComparator();
    private MinPQ<TreeNode> queue = new MinPQ<TreeNode>(cmp);
    private MinPQ<TreeNode> twinQueue = new MinPQ<TreeNode>(cmp);
    private int moves = 0;
    
    public Solver(Board initial) {
        // find a solution to the initial board (using the A* algorithm)
        
        queue.insert(initial);
        twinQueue.insert(initial.twin());
        while(queue.min().isGoal() == false & twinQueue.min().isGoal() == false) {
            Board cur = queue.delMin();
            Board twinCur = twinQueue.delMin();
            moves++;
            for (Board board : cur.neighbors()) {
                if (!board.equals(cur))
                    queue.insert(board);
            }
            for (Board board : twinCur.neighbors()) {
                if (!board.equals(twinCur))
                    twinQueue.insert(board);
            }
        }
    }
    public boolean isSolvable() {
        // is the initial board solvable?
        return queue.min().isGoal();
        
    }
    public int moves() {
        // min number of moves to solve initial board; -1 if unsolvable
        if (!isSolvable()) return -1;
        return moves;
    }
    public Iterable<Board> solution() {
        // sequence of boards in a shortest solution; null if unsolvable
        
    }

    private class NodeComparator implements Comparator<TreeNode> {
        public int compare(TreeNode b1, TreeNode b2) {
            int cnt1 = b1.manhattan() + b1.hamming();
            int cnt2 = b2.manhattan() + b2.hamming();
            if (cnt1 > cnt2) return 1;
            else if (cnt1 < cnt2) return -1;
            else return 0;
        }
    }
    
    private class TreeNode extends Board{
        private TreeNode father;
        public TreeNode(Board board) {
        dimension = board.dimension;
        blocks = board.blocks;
        }
    }
    
    public static void main(String[] args) {
        // solve a slider puzzle (given below)
    }
    
}