package com.epam.javaUniversity;

import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixTest {

    @Test
    public void testEqualsNewMatrixIsNull() {
        assertFalse(new Matrix(2, 3).equals(null));
    }

    @Test
    public void testEqualsNewMatrixHasDifferentSize() {
        assertFalse(new Matrix(2, 3).equals(new Matrix(3, 1)));
    }

    @Test
    public void testEqualsMatricesHaveDifferentElements() {
        Matrix A = new Matrix(2, 2);
        A.set(0, 0, 7);
        assertFalse(new Matrix(2, 2).equals(A));
    }

    @Test
    public void testEqualsMatricesHaveIdenticalElements() {
        Matrix A = new Matrix(2, 2);
        A.set(0, 0, 7);
        Matrix B = new Matrix(2, 2);
        B.set(0, 0, 7);
        assertTrue(A.equals(B));
    }

    @Test
    public void testIsZeroMatrixConsistsOfZeros() {
        assertTrue(new Matrix(3, 3).isZero());
    }

    @Test
    public void testIsZeroMatrixContainsNonzeroElements() {
        Matrix A = new Matrix(3, 3);
        A.set(1, 1, 1);
        assertFalse(A.isZero());
    }

    @Test
    public void testIsSquareMatrixHeightIsDifferentOfWidth() {
        assertFalse(new Matrix(2, 4).isSquare());
    }

    @Test
    public void testIsSquareMatrixHeightEqualsWidth() {
        assertTrue(new Matrix(3, 3).isSquare());
    }

    @Test
    public void testIsIdentityMatrixIsNotEqual() {
        Matrix A = new Matrix(2, 3);
        A.set(0, 0, 1);
        A.set(1, 1, 1);
        assertFalse(A.isIdentity());
    }

    @Test
    public void testIsIdentitySquareMatrixContainsIncorrectElements() {
        Matrix A = new Matrix(3, 3);
        A = A.makeIdentity();
        A.set(1, 2, 3);
        assertFalse(A.isIdentity());
    }

    @Test
    public void testIsIdentityMatrixElementsAreCorrect() {
        assertTrue(new Matrix(3,3).makeIdentity().isIdentity());
    }

    @Test
    public void testMakeIdentity() {
        Matrix A = new Matrix(3, 3);
        A.set(0, 0, 7);
        A.set(0, 1, 2);
        A.set(1, 2, 3);
        A.set(2, 2, 8);
        Matrix B = new Matrix(3, 3);
        B.set(0, 0, 1);
        B.set(1, 1, 1);
        B.set(2, 2, 1);
        assertTrue(A.makeIdentity().equals(B));
    }

    @Test
    public void testSetAndGet() {
        Matrix A = new Matrix(3, 3);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                A.set(i, j, i + j);
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(i + j, A.get(i, j));
            }
        }
    }

    @Test
    public void testAdd() {

    }
}