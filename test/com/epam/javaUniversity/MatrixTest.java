package com.epam.javaUniversity;

import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixTest {

    @Test
    public void testEqualsInputMatrixIsNull() {
        assertFalse(new Matrix(2, 3).equals(null));
    }

    @Test
    public void testEqualsInputMatrixHasDifferentSize() {
        assertFalse(new Matrix(2, 3).equals(new Matrix(3, 1)));
    }

    @Test
    public void testEqualsMatricesHaveDifferentElements() {
        Matrix A = new Matrix(2, 2);
        A.setElement(0, 0, 7);
        assertFalse(new Matrix(2, 2).equals(A));
    }

    @Test
    public void testEqualsMatricesHaveIdenticalElements() {
        Matrix A = new Matrix(2, 2);
        A.setElement(0, 0, 7);
        Matrix B = new Matrix(new int[][]{
                {7, 0},
                {0, 0}
        });
        assertTrue(A.equals(B));
    }

    @Test
    public void testIsZeroMatrixConsistsOfZeros() {
        assertTrue(new Matrix(3, 3).isZero());
    }

    @Test
    public void testIsZeroMatrixContainsNonzeroElements() {
        Matrix A = new Matrix(3, 3);
        A.setElement(1, 1, 1);
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
        A.setElement(0, 0, 1);
        A.setElement(1, 1, 1);
        assertFalse(A.isIdentity());
    }

    @Test
    public void testIsIdentitySquareMatrixContainsIncorrectElements() {
        Matrix A = new Matrix(3, 3);
        A = A.makeIdentity();
        A.setElement(1, 2, 3);
        assertFalse(A.isIdentity());
    }

    @Test
    public void testIsIdentityMatrixElementsAreCorrect() {
        assertTrue(new Matrix(3, 3).makeIdentity().isIdentity());
    }

    @Test
    public void testMakeIdentity() {
        Matrix A = new Matrix(3, 3);
        A.setElement(0, 0, 7);
        A.setElement(0, 1, 2);
        A.setElement(1, 2, 3);
        A.setElement(2, 2, 8);
        Matrix B = new Matrix(3, 3);
        B.setElement(0, 0, 1);
        B.setElement(1, 1, 1);
        B.setElement(2, 2, 1);
        assertTrue(A.makeIdentity().equals(B));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testMakeIdentityIncorrectMatrix() {
        new Matrix(2, 3).makeIdentity();
    }

    @Test
    public void testSetElementAndGetElement() {
        Matrix A = new Matrix(3, 3);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                A.setElement(i, j, i + j);
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(i + j, A.getElement(i, j));
            }
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetElementInvalidParameters() {
        new Matrix(2, 2).setElement(2, 2, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetElementInvalidParameters() {
        new Matrix(2, 2).getElement(2, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddInputMatrixIsNull() {
        new Matrix(2, 2).add(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddInputMatrixHasDifferentSize() {
        new Matrix(2, 3).add(new Matrix(3, 1));
    }

    @Test
    public void testAdd() {
        Matrix A = new Matrix(2, 2);
        A.setElement(0, 0, 2);
        A.setElement(0, 1, 3);
        A.setElement(1, 0, 5);
        A.setElement(1, 1, 7);
        Matrix B = new Matrix(2, 2);
        B.setElement(0, 0, 2);
        B.setElement(0, 1, 1);
        B.setElement(1, 0, -1);
        B.setElement(1, 1, -3);
        Matrix C = new Matrix(2, 2);
        C.setElement(0, 0, 4);
        C.setElement(0, 1, 4);
        C.setElement(1, 0, 4);
        C.setElement(1, 1, 4);
        assertTrue(C.equals(A.add(B)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMultiplyInputMatrixIsNull() {
        new Matrix(3, 3).multiply(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMultiplyInputMatrixIsIncorrect() {
        new Matrix(2, 3).multiply(new Matrix(2, 4));
    }

    @Test
    public void testMultiply() {
        Matrix A = new Matrix(2, 3);
        A.setElement(0, 0, 1);
        A.setElement(0, 1, 2);
        A.setElement(0, 2, 3);
        A.setElement(1, 0, 4);
        A.setElement(1, 1, 5);
        A.setElement(1, 2, 6);
        Matrix B = new Matrix(3, 4);
        B.setElement(0, 0, 12);
        B.setElement(0, 1, 11);
        B.setElement(0, 2, 10);
        B.setElement(0, 3, 9);
        B.setElement(1, 0, 8);
        B.setElement(1, 1, 7);
        B.setElement(1, 2, 6);
        B.setElement(1, 3, 5);
        B.setElement(2, 0, 4);
        B.setElement(2, 1, 3);
        B.setElement(2, 2, 2);
        B.setElement(2, 3, 1);
        Matrix C = new Matrix(2, 4);
        C.setElement(0, 0, 40);
        C.setElement(0, 1, 34);
        C.setElement(0, 2, 28);
        C.setElement(0, 3, 22);
        C.setElement(1, 0, 112);
        C.setElement(1, 1, 97);
        C.setElement(1, 2, 82);
        C.setElement(1, 3, 67);
        assertTrue(C.equals(A.multiply(B)));
    }

    @Test
    public void testGetDeterminant() {
        Matrix A = new Matrix(new int[][]{
                {1, 2, 0, 1},
                {3, 1, 2, 2},
                {0, 4, 1, 2},
                {3, 2, 1, 0},
        });
        assertEquals(25, A.getDeterminant());
    }
}