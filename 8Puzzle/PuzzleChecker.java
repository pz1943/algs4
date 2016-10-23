public class PuzzleChecker {

    public static void main(String[] args) {

        // for each command-line argument
        for (String filename : args) {
            In in = new In(args[0]);
            int n = in.readInt();
            int[][] blocks = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                blocks[i][j] = in.readInt();
            Board initial = new Board(blocks);
            
            Solver solver = new Solver(initial);
            StdOut.println(filename + ": " + solver.moves());
        }
    }
}