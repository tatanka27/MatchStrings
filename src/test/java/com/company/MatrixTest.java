package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class MatrixTest {

    private final Random random = new Random();
    private int n;
    private int m;
    private Matrix matrix;

    @BeforeEach
    public void setUp() {
        n = random.nextInt( 10) + 1;
        m = random.nextInt( 10) + 1;
        matrix = new Matrix(n, m);
    }

    @Test
    public void shouldSetCount() {
        int count = random.nextInt(10);

        int i = random.nextInt(n);
        int j = random.nextInt(m);

        Assertions.assertNull(matrix.getItemMatrix(i, j));
        matrix.setCount(i, j, count);
        Assertions.assertEquals(count, matrix.getItemMatrix(i, j));
    }

    @Test
    public void shouldSetUnavailable() {
        int i = random.nextInt(n);
        int j = random.nextInt(m);
        Pair pair = new Pair(i, j);

        Assertions.assertTrue(matrix.getItemAvailableRows(i));
        Assertions.assertTrue(matrix.getItemAvailableCols(j));
        matrix.setUnavailable(pair);
        Assertions.assertFalse(matrix.getItemAvailableRows(i));
        Assertions.assertFalse(matrix.getItemAvailableCols(j));
    }

    @Test
    public void shouldReturnMax() {
        int i = random.nextInt(n);
        int j = random.nextInt(m);
        generateMatrix();
        int count = matrix.getItemMatrix(i, j);
        matrix.setCount(i, j, count + 10);

        Pair pair = matrix.findMax();
        Assertions.assertEquals(i, pair.i);
        Assertions.assertEquals(j, pair.j);
    }

    private void generateMatrix() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix.setCount(i, j, random.nextInt(10));
            }
        }
    }
}