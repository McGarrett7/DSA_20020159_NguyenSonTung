package Coursera.Week2;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private final double[] thresholds;
    private int t;
    private static final double CONFIDENCE_95 = 1.96;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException();
        }

        int sitesCount = n * n;
        thresholds = new double[trials];

        for (int i = 0; i < trials; i++) {
            Percolation pc = new Percolation(n);
            while (!pc.percolates()) {
                int row = StdRandom.uniform(n) + 1;
                int col = StdRandom.uniform(n) + 1;
                if (!pc.isOpen(row, col)) {
                    pc.open(row, col);
                }
            }
            thresholds[i] = (double) pc.numberOfOpenSites() / sitesCount;
        }
    }

    // sample mean of percolation threshold
    public double mean() {
//        double sum = 0;
//        for (int i = 0; i < t; i++) {
//            sum = sum + thresholds[i];
//        }
//        return sum / t;
        return StdStats.mean(this.thresholds);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(thresholds);
    }

    // low  endpoint of 95% confidence interval
    public double confidenceLo() {
        //return mean() - (CONFIDENCE_95 * stddev() / Math.sqrt(t));
        return mean() - CONFIDENCE_95 * stddev() / Math.sqrt(thresholds.length);
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + (CONFIDENCE_95 * stddev() / Math.sqrt(t));
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        PercolationStats ps = new PercolationStats(n, trials);
        System.out.println(ps.mean());
        System.out.println(ps.stddev());
        System.out.println(ps.confidenceLo());
        System.out.println(ps.confidenceHi());
    }
}






