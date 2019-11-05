/* *****************************************************************************
 *  Name:    Artemis Veizi
 *  NetID:   aveizi
 *  Precept: P03
 *
 *  Partner Name:    N/A
 *  Partner NetID:   N/A
 *  Partner Precept: N/A
 *
 *  Description:  Implements A* search to solve n-by-n slider puzzles. Uses
 *                MinPQ and Manhattan distance as heuristic to find shortest
 *                solution path for a board. Finds solution and stores path to
 *                solution.
 *
 **************************************************************************** */

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Solver {
    // final solution node
    private Node solution;
    // stack to represent the solution path
    private final Stack<Board> solvedPath;

    // Node class to keep track of boards
    private class Node implements Comparable<Node> {
        // this board
        private final Board board;
        // the parent of this board
        private final Node parent;
        // number of moves to arrive at state
        private final int moves;

        // constructor
        public Node(Board b, Node p, int m) {
            board = b;
            parent = p;
            moves = m;
        }

        // number of moves to arrive at this position
        public int moves() {
            return moves;
        }

        // comparator here
        public int compareTo(Node c) {
            return board.manhattan() + moves - (c.board.manhattan() + c.moves());
        }

        // is this the solved board?
        public boolean solved() {
            return board.isGoal();
        }

        // all neighbors
        public Iterable<Board> possibleMoves() {
            return board.neighbors();
        }
    }

    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {
        if (initial == null || !initial.isSolvable())
            throw new IllegalArgumentException();

        // instantiate instance variable solvedPath
        solvedPath = new Stack<Board>();

        // MinPQ for game tree: add initial board
        MinPQ<Node> queue = new MinPQ<Node>();
        Node root = new Node(initial, null, 0);
        queue.insert(root);

        // if this board has a solution, find the solution by searching all
        // game paths (neighbors), using manhattan distance as the heuristic
        if (initial.isSolvable()) {
            while (!queue.isEmpty()) {
                Node node = queue.delMin();

                // if this board is the solution board, leave loop
                if (node.solved()) {
                    solution = node;
                    // store path to solution in the stack (b/c LIFO)
                    Node current = solution;
                    while (current != null) {
                        solvedPath.push(current.board);
                        current = current.parent;
                    }
                    break;
                }

                // parse all neighbors (next possible moves of this board)
                for (Board move : node.possibleMoves()) {
                    // if this node has not already been visited
                    if (node.parent == null || !move.equals(node.parent.board)) {
                        Node child = new Node(move, node, node.moves() + 1);
                        queue.insert(child);
                    }
                }
            }
        }
    }

    // min number of moves to solve initial board
    public int moves() {
        return solution.moves();
    }

    // sequence of boards in a shortest solution
    public Iterable<Board> solution() {
        return solvedPath;
    }

    // test client (see below)
    public static void main(String[] args) {
        String filename = args[0];
        In reader = new In(filename);
        int size = reader.readInt();
        int[][] file = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                file[i][j] = reader.readInt();
            }
        }
        Board tester = new Board(file);
        Solver solve = new Solver(tester);
        for (Board b : solve.solution()) {
            StdOut.println(b);
        }
        StdOut.println("# OF MOVES TO SOLUTION: " + solve.moves());
    }

}
