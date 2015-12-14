package com.epam.javaUniversity;

import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixTest {

    @Test
    public void testEqualsNewMatrixIsNull() throws Exception {
        assertFalse(new Matrix(2, 3).equals(null));
    }

    @Test
    public void testEqualsNewMatrixHasDifferentSize() throws Exception {
        assertFalse(new Matrix(2, 3).equals(new Matrix(3, 1)));
    }

    @Test
    public void testEqualsMatricesHaveDifferentElements() throws Exception {
        Matrix A = new Matrix(2, 2);
        A.set(0, 0, 7);
        assertFalse(new Matrix(2, 2).equals(A));
    }

    @Test
    public void testEqualsMatricesHaveIdenticalElements() throws Exception {
        Matrix A = new Matrix(2, 2);
        A.set(0,0,7);
        Matrix B = new Matrix(2,2);
        B.set(0,0,7);
        assertTrue(A.equals(B));
    }

    @Test
    public void testIsZero() throws Exception {

    }

    @Test
    public void testIsSquare() throws Exception {

    }

    @Test
    public void testIsIdentity() throws Exception {

    }

    @Test
    public void testMakeIdentity() throws Exception {

    }

    @Test
    public void testGet() throws Exception {

    }

    @Test
    public void testSet() throws Exception {

    }

    @Test
    public void testAdd() throws Exception {

    }
}