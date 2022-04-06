package com.company;

import java.util.Arrays;

public class Matrix {
    private final Integer[][] matrix;
    private final boolean[] isAvailableRows;
    private final boolean[] isAvailableCols;

    Matrix(int n, int m) {
        matrix = new Integer[n][m];
        isAvailableRows = new boolean[n];
        Arrays.fill(isAvailableRows, Boolean.TRUE);
        isAvailableCols = new boolean[m];
        Arrays.fill(isAvailableCols, Boolean.TRUE);
    }

    void setCount(int i, int j, int count) {
        matrix[i][j] = count;
    }

    Pair findMax() {
        int max = 0;
        Pair pair = new Pair(-1, -1);
        for (int i = 0; i < matrix.length; i++) {
            if (!isAvailableRows[i]) {
                continue;
            }
            for (int j = 0; j < matrix[i].length; j++) {

                if (!isAvailableCols[j]) {
                    continue;
                }

                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                    pair.i = i;
                    pair.j = j;
                }
            }
        }

        if (pair.i == -1) {
            for (int i = 0; i < isAvailableRows.length; i++) {
                if (isAvailableRows[i]) {
                    pair.i = i;
                    break;
                }
            }

            for (int i = 0; i < isAvailableCols.length; i++) {
                if (isAvailableCols[i]) {
                    pair.j = i;
                    break;
                }
            }
        }

        return pair;
    }

    void setUnavailable(Pair pair) {
        if (pair.i != -1) {
            isAvailableRows[pair.i] = false;
        }
        if (pair.j != -1) {
            isAvailableCols[pair.j] = false;
        }
    }
}
