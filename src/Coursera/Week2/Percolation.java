package Coursera.Week2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private final int n;
    private boolean percolated;
    private int openSites;
    private final WeightedQuickUnionUF uf;
    private boolean[] sites;

    // create N-by-N grid, with all sites blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }

        percolated = false;
        this.n = n;
        uf = new WeightedQuickUnionUF(n * n + 2);
        sites = new boolean[n * n];
    }

    // open site (row, col) if it is not open already
    public void open(int row, int col) {
        check(row, col);
        int itemIndex = n * (row - 1) + col;
        if (!isOpen(row, col)) {
            sites[itemIndex - 1] = true;
            openSites++;
        }
        checkNodesAround(row, col);
    }

    // is site (row, col) open?
    public boolean isOpen(int row, int col) {
        check(row, col);
        return sites[n * (row - 1) + col - 1];
    }

    // is site (row, col) full?
    public boolean isFull(int row, int col) {
        check(row, col);
        boolean connect = isOpen(row, col);
        connect = connect && uf.find(0) == uf.find((row - 1) * n + col);
        return connect;
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openSites;
    }

    // does the system percolate?
    public boolean percolates() {
        return (uf.find(0) == uf.find(n * n + 1));
    }

    private void check(int row, int col) {
        if (row <= 0 || row > n) {
            throw new IllegalArgumentException();
        }
        if (col <= 0 || col > n) {
            throw new IllegalArgumentException();
        }
    }

    private void checkNodesAround(int row, int col) {
        int itemIndex = n * (row - 1) + col;
        if (row == 1) {
            uf.union(itemIndex, 0);
        }
        if (row == n)
            uf.union(itemIndex, n * n + 1);
        if (row != 1 && isOpen(row - 1, col))
            uf.union(itemIndex, n * (row - 1) + col - n);
        if (row != n && isOpen(row + 1, col))
            uf.union(itemIndex, n * (row - 1) + col + n);
        if (col > 1 && isOpen(row, col - 1))
            uf.union(itemIndex, n * (row - 1) + col - 1);
        if (col < n && isOpen(row, col + 1))
            uf.union(itemIndex, n * (row - 1) + col + 1);
    }
}