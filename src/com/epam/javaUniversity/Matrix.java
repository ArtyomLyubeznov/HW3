package com.epam.javaUniversity;

import java.util.Arrays;

public class Matrix {

    private int[][] matrix;

    public Matrix(int row, int col) throws IllegalArgumentException {
        if (row < 1 || col < 1) {
            throw new IllegalArgumentException("Invalid parameters of matrix.");
        }
        matrix = new int[row][col];
    }

    public boolean equals(Matrix other) {
        if (other == null) {
            return false;
        }
        if (other.matrix.length != this.matrix.length ||
                other.matrix[0].length != this.matrix[0].length) {
            return false;
        }
        for (int i = 0; i < this.matrix.length; i++) {
            if (!Arrays.equals(this.matrix[i], other.matrix[i])) {
                return false;
            }
        }
        return true;
    }

    public boolean isZero() {
        if (this.equals(new Matrix(this.matrix.length, this.matrix[0].length))) {
            return true;
        }
        return false;
    }

    public boolean isSquare() {
        if (matrix.length == matrix[0].length) {
            return true;
        }
        return false;
    }

    public boolean isIdentity() {
        if (!this.isSquare()) {
            return false;
        }
        if (this.equals(this.makeIdentity())) {
            return true;
        }
        return false;
    }

    public Matrix makeIdentity() throws UnsupportedOperationException {
        if (!this.isSquare()) {
            throw new UnsupportedOperationException("Matrix must be square.");
        }
        Matrix res = new Matrix(this.matrix.length, this.matrix.length);
        for (int i = 0; i < res.matrix.length; i++) {
            res.matrix[i][i] = 1;
        }
        return res;
    }

    public int get(int row, int col) throws IllegalArgumentException {
        try {
            return matrix[row][col];
        } catch (ArrayIndexOutOfBoundsException ex) {
            throw new IllegalArgumentException("Specified position is beyond matrix.");
        }
    }

    public void set(int row, int col, int value) throws IllegalArgumentException {
        try {
            matrix[row][col] = value;
        } catch (ArrayIndexOutOfBoundsException ex) {
            throw new IllegalArgumentException("Specified position is beyond matrix.");
        }
    }
}