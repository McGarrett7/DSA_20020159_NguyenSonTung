package Coursera.Week8;

import edu.princeton.cs.algs4.Stack;

public class Board {

    private int size;
    private int[][] blocks;

    // create a board from an n-by-n array of tiles,
    // where tiles[row][col] = tile at (row, col)
    public Board(int[][] blocks) {
        size = blocks.length;
        this.blocks = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.blocks[i][j] = blocks[i][j];
            }
        }
    }

    // string representation of this board
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(dimension() + "\n");
        for (int i = 0; i < dimension(); i++) {
            for (int j = 0; j < dimension(); j++) {
                s.append(String.format("%2d ", blocks[i][j]));
            }
            s.append("\n");
        }
        return s.toString();
    }

    // board dimension n
    public int dimension() {
        return size;
    }

    // number of blocks out of place
    public int hamming() {
        int hamming = 0;
        for (int i = 0; i < blocks.length; i++)
            for (int j = 0; j < blocks.length; j++)
                if (blocks[i][j] != 0 && blocks[i][j] != j + i * dimension() + 1) hamming++;
        return hamming;
    }

    // sum of Manhattan distances between blocks and goal
    public int manhattan() {
        int manhattan = 0;
        for (int i = 0; i < dimension(); i++) {
            for (int j = 0; j < dimension(); j++) {
                if (blocks[i][j] == 0) {
                    continue;
                }
                manhattan += Math.abs(i - (blocks[i][j] - 1) - dimension())
                        + Math.abs(j - (blocks[i][j] - 1) / dimension());
            }
        }
        return manhattan;
    }

    // is this board the goal board?
    public boolean isGoal() {
        return hamming() == 0;
    }

    // does this board equal y?
    public boolean equals(Object y) {
        if (y == this) {
            return true;
        }

        if (y == null) {
            return false;
        }

        if (y.getClass() != this.getClass()) {
            return false;
        }

        Board other = (Board) y;

        if (this.dimension() != other.dimension()) {
            return false;
        }

        for (int i = 0; i < blocks.length; i++) {
            if (blocks[i] != other.blocks[i]) {
                return false;
            }
        }

        return true;
    }

    // all neighboring boards
    public Iterable<Board> neighbors() {
        Stack<Board> neighbours = new Stack<>();
        int pos = 0;
        for (int i = 0; i < blocks.length; i++)
            for (int j = 0; j < blocks.length; j++)
                if (blocks[i][j] == 0)
                    pos = j + i * dimension();
        else pos = -1;

        int i = pos / dimension();
        int j = pos % dimension();
        if (i > 0)
            neighbours.push(new Board(swap(i, j, i - 1, j)));
        if (i < blocks.length - 1)
            neighbours.push(new Board(swap(i, j, i + 1, j)));
        if (j > 0)
            neighbours.push(new Board(swap(i, j, i, j - 1)));
        if (j < blocks.length - 1)
            neighbours.push(new Board(swap(i, j, i, j + 1)));

        return neighbours;
    }

    // a board that is obtained by exchanging any pair of blocks
    public Board twin() {
        int[][] twinTiles = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                twinTiles[i][j] = blocks[i][j];
            }
        }

        if (twinTiles[0][0] != 0 && twinTiles[0][1] != 0)
            return new Board(swap(0, 0, 0, 1));
        else
            return new Board(swap(1, 0, 1, 1));

    }

    private int[][] swap(int i1, int j1, int i2, int j2) {
        int[][] copy = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                copy[i][j] = blocks[i][j];
            }
        }
        int temp = copy[i1][j1];
        copy[i1][j1] = copy[i2][j2];
        copy[i2][j2] = temp;
        return copy;
    }
}