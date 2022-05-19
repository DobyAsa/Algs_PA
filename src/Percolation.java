import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;
public class Percolation {
    boolean[] status;
    int wide;
    int opensize;
    WeightedQuickUnionUF box;
    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n){
        status = new boolean[n];
        box = new WeightedQuickUnionUF(n+2);
        opensize = 0;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col){
        if(!isOpen(row, col)) {
            status[(row - 1) * (wide - 1)] = true;
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        return status[(row - 1) * (wide - 1)];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col){
        return false;
    }

    // returns the number of open sites
    public int numberOfOpenSites(){
        return opensize;
    }

    // does the system percolate?
    public boolean percolates(){
        return box.find(0) == box.find(wide+1);
    }

    // test client (optional)
    public static void main(String[] args){}
}