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
        if (hasDifferentSize(other)) {
            return false;
        }
        for (int i = 0; i < this.height(); i++) {
            if (!Arrays.equals(this.matrix[i], other.matrix[i])) {
                return false;
            }
        }
        return true;
    }

    public boolean isZero() {
        if (this.equals(new Matrix(this.height(), this.width()))) {
            return true;
        }
        return false;
    }

    public boolean isSquare() {
        if (this.height() == this.width()) {
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
        Matrix res = new Matrix(this.height(), this.width());
        for (int i = 0; i < res.matrix.length; i++) {
            res.matrix[i][i] = 1;
        }
        return res;
    }

    public int get(int row, int col) throws IllegalArgumentException {
        try {
            return matrix[row][col];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Specified position is beyond matrix.");
        }
    }

    public void set(int row, int col, int value) throws IllegalArgumentException {
        try {
            matrix[row][col] = value;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Specified position is beyond matrix.");
        }
    }

    public Matrix add(Matrix other) throws IllegalArgumentException {
        if (other == null || hasDifferentSize(other)) {
            throw new IllegalArgumentException("Invalid parameters of matrix.");
        }
        Matrix res = new Matrix(this.height(), this.width());
        for (int row = 0; row < this.height(); row++) {
            for (int col = 0; col < this.width(); col++) {
                res.matrix[row][col] = this.matrix[row][col] + other.matrix[row][col];
            }
        }
        return res;
    }

    private int height() {
        return this.matrix.length;
    }

    private int width() {
        return this.matrix[0].length;
    }

    private boolean hasDifferentSize(Matrix other) {
        if (other.height() != this.height() ||
                other.width() != this.width()) {
            return true;
        }
        return false;
    }
}