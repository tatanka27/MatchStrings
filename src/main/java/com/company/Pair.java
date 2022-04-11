package com.company;

public class Pair implements Comparable<Pair>{
    int i;
    int j;

    Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public int compareTo(Pair p) {
        int result = internalCompare(i, p.i);
        if ( result != 0) {
            return result;
        }

        return internalCompare(j, p.j);
    }

    private int internalCompare(int p1, int p2) {
        if (p1 == -1 && p2 == -1) {
            return 0;
        }
        if (p1 == -1 && p2 != -1) {
            return 1;
        }
        if (p1 != -1 && p2 == -1) {
            return -1;
        }
        return Integer.compare(p1, p2);
    }

}
