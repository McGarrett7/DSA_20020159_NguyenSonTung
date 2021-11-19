package Coursera.Week8;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;

public class Solver {
    private final Board Board;
    private Node searchNode;
    private boolean isSolvable = true;

    private class Node implements Comparable {
        private Board board;
        private Node parent;
        private int moves;
        private int priority;
        private int manhattan;

        private Node(Board board, Node parent) {
            this.board = board;
            this.parent = parent;
            if (parent == null) {
                moves = 0;
            } else {
                moves = parent.moves + 1;
            }
            manhattan = board.manhattan();
            priority = manhattan + moves;
        }

        @Override
        public int compareTo(Object that) {
            int thatPriority = ((Node) that).priority;
            if (this.priority > thatPriority)        return 1;
            else if (this.priority < thatPriority)   return -1;
            else                                     return 0;
        }
    }

    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {
        if (initial == null) throw new IllegalArgumentException();

        MinPQ<Node> pq = new MinPQ<Node>();
        MinPQ<Node> pqtwin = new MinPQ<Node>();
        Board = initial;
        searchNode = new Node(Board, null);
        Node twinNode = new Node(Board.twin(), null);

        while (true) {
            if (searchNode.board.isGoal()) {
                break;
            }
            searchNode = process(searchNode, pq);

            if (twinNode.board.isGoal()) {
                isSolvable = false;
                break;
            }
            twinNode = process(twinNode, pqtwin);
        }
    }

    private Node process(Node node, MinPQ<Node> pq) {
        Iterable<Board> n = node.board.neighbors();
        for (Board b : n) {
            if (node.parent == null || !node.parent.board.equals(b)) {
                pq.insert(new Node(b, node));
            }
        }
        return pq.delMin();
    }

    // is the initial board solvable?
    public boolean isSolvable() {
        return isSolvable;
    }

    // min number of moves to solve initial board; -1 if unsolvable
    public int moves() {
        if (isSolvable()) {
            return searchNode.moves;
        }
        return -1;
    }

    // sequence of boards in a shortest solution; null if unsolvable
    public Iterable<Board> solution() {
        if (!isSolvable) {
            return null;
        }
        Stack<Board> result = new Stack<Board>();
        Node node = searchNode;
        while (node != null) {
            result.push(node.board);
            node = node.parent;
        }
        return result;
    }

    public static void main(String[] args) {

        // create initial board from file
        In in = new In(args[0]);
        int n = in.readInt();
        int[][] tiles = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                tiles[i][j] = in.readInt();
        Board initial = new Board(tiles);

        // solve the puzzle
        Solver solver = new Solver(initial);

        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
    }
}