package Week2;

import edu.princeton.cs.algs4.*;
public class UFClient2 {
    public static void main(String[] args) {
        int n = StdIn.readInt();
        int count = 0;
        UF uf = new UF(n);
        while (uf.count() != 1 && !StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            count++;
            if (uf.find(p) == uf.find(q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        if (uf.count() == 1) {
            StdOut.println(count);
        } else {
            StdOut.println("FAILED");
        }
    }
}
