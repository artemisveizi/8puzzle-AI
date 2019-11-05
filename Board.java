/* *****************************************************************************
 *  Name:    Artemis Veizi
 *  NetID:   aveizi
 *  Precept: P03
 *
 *  Partner Name:    N/A
 *  Partner NetID:   N/A
 *  Partner Precept: N/A
 *
 *  Description: Data type that models an n-by-n board with sliding tiles (the
 *               8 puzzle). Stores the Hamming and Manhattan distances of the
 *               board from the goal board.
 *
 **************************************************************************** */

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Board {
    // board (matrix) of tiles
    private int[][] tiles;
    // size of board (square boards, size x size)
    private final int size;
    // hamming distance
    private final int hamming;
    // manhattan distance
    private final int manhattan;
    // zero position (not tuple)
    private int zeropos;

    // create a board from an n-by-n array of tiles,
    // where tiles[row][col] = tile at (row, col)
    public Board(int[][] t) {
        size = t.length;
        tiles = new int[size][size];

        // calculate the manhattan and hamming distances, temp variables
        int hamm = 0;
        int man = 0;
        for (int i = 0; i < size; i++) {
            // using System.arraycopy() because its *slightly* more efficient.
            System.arraycopy(t[i], 0, tiles[i], 0, size);

            // compute the hamming & manhattan distances as well
            for (int j = 0; j < size; j++) {
                if (t[i][j] != 0) {
                    if (t[i][j] != i * size + j + 1) {
                        hamm++;
                    }
                    // vertical computation
                    man += Math.abs(i - (t[i][j] - 1) / size);
                    // horizontal computation
                    man += Math.abs(j - (t[i][j] - 1) % size);
                }
                else {
                    zeropos = i * size + j;
                }
            }
        }
        manhattan = man;
        hamming = hamm;


    }

    // string representation of this board
    public String toString() {
        StringBuilder rep = new StringBuilder();
        rep.append(size);
        // copy each row into String
        for (int i = 0; i < size; i++) {
            rep.append("\n ");
            for (int j = 0; j < size; j++)
                rep.append(String.format("%2d ", tileAt(i, j)));
        }
        return rep.toString();
    }

    // tile at (row, col) or 0 if blank
    public int tileAt(int row, int col) {
        if (row < 0 || row > size - 1 || col < 0 || col > size - 1)
            throw new IllegalArgumentException();
        return tiles[row][col];

    }

    // board size n
    public int size() {
        return size;
    }

    // number of tiles out of place
    public int hamming() {
        return hamming;
    }

    // sum of Manhattan distances between tiles and goal
    public int manhattan() {
        return manhattan;
    }

    // is this board the goal board?
    public boolean isGoal() {
        return hamming == 0;
    }

    // does this board equal y? needs a class check for argument
    public boolean equals(Object y) {
        if (y == null)
            return false;
        else if (y.getClass() != this.getClass())
            return false;
        // compare each subarray, if any unequal return false
        return Arrays.deepEquals(tiles, ((Board) y).tiles);
    }


    // all neighboring boards
    public Iterable<Board> neighbors() {
        Queue<Board> nbors = new Queue<>();
        // x and y position of the blank tile (0 tile)
        int xzero = zeropos / size;
        int yzero = zeropos % size;

        int[] xmoves = { xzero - 1, xzero + 1 };
        int[] ymoves = { yzero - 1, yzero + 1 };

        // up, down, left, and right if it is an option
        for (int x : xmoves) {
            if (x >= 0 && x < size) {
                tiles[xzero][yzero] = tiles[x][yzero];
                tiles[x][yzero] = 0;
                // append to neighbors queue
                Board tempLR = new Board(tiles);
                nbors.enqueue(tempLR);
                // return tiles to original state
                tiles[x][yzero] = tiles[xzero][yzero];
                tiles[xzero][yzero] = 0;
            }
        }
        for (int y : ymoves) {
            if (y >= 0 && y < size) {
                tiles[xzero][yzero] = tiles[xzero][y];
                tiles[xzero][y] = 0;
                // append to neighbors queue
                Board tempUD = new Board(tiles);
                nbors.enqueue(tempUD);
                // return tiles to original state
                tiles[xzero][y] = tiles[xzero][yzero];
                tiles[xzero][yzero] = 0;
            }
        }
        return nbors;
    }

    // is this board solvable?
    public boolean isSolvable() {
        int inversions = 0;
        int total = (int) Math.pow(size, 2);
        // count inversions
        for (int i = 0; i < total; i++) {
            int xRef = i / size;
            int yRef = i % size;
            // all following indices
            for (int j = i + 1; j < total; j++) {
                int xComp = j / size;
                int yComp = j % size;
                // if it is less/do not include zero in inversion calculations
                if (tiles[xRef][yRef] > tiles[xComp][yComp] &&
                        tiles[xRef][yRef] != 0 && tiles[xComp][yComp] != 0)
                    inversions++;
            }
        }
        // calculate for an even board
        if (size % 2 == 0) {
            return (inversions + zeropos / size) % 2 != 0;
        }
        // calculate for an odd sized board
        else
            return inversions % 2 == 0;
    }

    // unit testing (required)
    public static void main(String[] args) {
        int[][] testtiles = {
                { 1, 2, 3 },
                { 4, 0, 5 },
                { 7, 8, 6 }
        };
        Board tester = new Board(testtiles);
        StdOut.println(tester.size());
        StdOut.println(tester); // should print size = 3 and board as above
        StdOut.println("Hamming: " + tester.hamming()); // = 2 (5 & 6)
        StdOut.println("Manhattan: " + tester.manhattan()); // = 2 (5 = 1/6 = 1)
        StdOut.println("Goal: " + tester.isGoal()); // false
        StdOut.println("Solvable: " + tester.isSolvable()); // true
        StdOut.println("Bottom right corner: " + tester.tileAt(2, 2)); // = 6
        int[][] testtiles2 = {
                { 1, 2, 3 },
                { 4, 0, 5 },
                { 7, 8, 6 }
        };
        Board compare = new Board(testtiles2);
        StdOut.println("Equal? " + tester.equals(compare)); // true
        StdOut.println("Neighbors:");
        for (Board board : tester.neighbors()) // up down left right
            StdOut.println(board);

        // zero in corner
        int[][] cornertiles = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 0, 7, 8 }
        };
        Board corner = new Board(cornertiles);
        StdOut.println("CORNER ZERO:");
        for (Board board : corner.neighbors()) // up and right only
            StdOut.println(board);
        // unsolvable board
        int[][] nosolution = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 8, 7, 0 }
        };
        Board unsolvable = new Board(nosolution);
        StdOut.println("Unsolvable board is solvable?: "
                               + unsolvable.isSolvable());
    }
}
