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

    public Matrix(int[][] param) throws IllegalArgumentException{
        for (int i = 1; i < param.length; i++){
            if (param[i].length != param[0].length){
                throw new IllegalArgumentException("Invalid parameter");
            }
        }
        this.matrix = new int[param.length][param[0].length];
        for (int i = 0; i < this.getRows(); i++){
            this.matrix[i] = Arrays.copyOf(param[i], param[0].length);
        }
    }

    public boolean equals(Matrix other) {
        if (other == null) {
            return false;
        }
        if (hasDifferentSize(other)) {
            return false;
        }
        for (int i = 0; i < this.getRows(); i++) {
            if (!Arrays.equals(this.matrix[i], other.matrix[i])) {
                return false;
            }
        }
        return true;
    }

    public boolean isZero() {
        if (this.equals(new Matrix(this.getRows(), this.getCols()))) {
            return true;
        }
        return false;
    }

    public boolean isSquare() {
        if (this.getRows() == this.getCols()) {
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
        Matrix res = new Matrix(this.getRows(), this.getCols());
        for (int i = 0; i < res.getRows(); i++) {
            res.matrix[i][i] = 1;
        }
        return res;
    }

    public int getElement(int row, int col) throws IllegalArgumentException {
        try {
            return matrix[row][col];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Specified position is beyond matrix.");
        }
    }

    public void setElement(int row, int col, int value) throws IllegalArgumentException {
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
        Matrix res = new Matrix(this.getRows(), this.getCols());
        for (int row = 0; row < this.getRows(); row++) {
            for (int col = 0; col < this.getCols(); col++) {
                res.matrix[row][col] = this.matrix[row][col] + other.matrix[row][col];
            }
        }
        return res;
    }

    public int getRows() {
        return this.matrix.length;
    }

    public int getCols() {
        return this.matrix[0].length;
    }

    private boolean hasDifferentSize(Matrix other) {
        if (other.getRows() != this.getRows() ||
                other.getCols() != this.getCols()) {
            return true;
        }
        return false;
    }

    public Matrix multiply(Matrix other) {
        if (other == null || this.hasInappropriateSize(other)) {
            throw new IllegalArgumentException("Invalid parameters of matrix.");
        }
        if (other.isZero()) {
            return new Matrix(this.getRows(), other.getCols());
        }
        Matrix res = new Matrix(this.getRows(), other.getCols());
        for (int row = 0; row < res.getRows(); row++) {
            for (int col = 0; col < res.getCols(); col++) {
                for (int i = 0; i < this.getCols(); i++) {
                    res.matrix[row][col] += this.matrix[row][i] * other.matrix[i][col];
                }
            }
        }
        return res;
    }

    private boolean hasInappropriateSize(Matrix other) {
        if (this.getCols() != other.getRows()) {
            return true;
        }
        return false;
    }

    public int getDeterminant() {
        if (!this.isSquare()) {
            throw new IllegalArgumentException("Invalid parameters of matrix.");
        }
        if (this.isZero()) {
            return 0;
        }
        if (this.isIdentity()) {
            return 1;
        }
        return countDeterminant(this.matrix);
    }

    private int countDeterminant(int[][] param) {
        if (param.length == 1) {
            return param[0][0];
        }
        if (param.length == 2) {
            return param[0][0] * param[1][1] - param[0][1] * param[1][0];
        }
        if (param.length == 3) {
            return param[0][0] * param[1][1] * param[2][2] +
                    param[0][2] * param[1][0] * param[2][1] +
                    param[0][1] * param[1][2] * param[2][0] -
                    param[0][2] * param[1][1] * param[2][0] -
                    param[0][0] * param[1][2] * param[2][1] -
                    param[0][1] * param[1][0] * param[2][2];
        }
        int det = 0;
        for (int col = 0; col < param.length; col++) {
            det += Math.pow(-1, col) * param[0][col] * countDeterminant(getCofactor(param, col));
        }
        return det;
    }

    private int[][] getCofactor(int[][] param, int col) {
        int[][] cofactor = new int[param.length - 1][param.length - 1];
        for (int i = 0; i < cofactor.length; i++) {
            for (int j = 0; j < col; j++) {
                    cofactor[i][j] = param[i + 1][j];
            }
            for (int j = col; j < cofactor.length; j++) {
                cofactor[i][j] = param[i + 1][j + 1];
            }
        }
        return cofactor;
    }
}