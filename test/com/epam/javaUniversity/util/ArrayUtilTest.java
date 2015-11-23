package com.epam.javaUniversity.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayUtilTest {

    @Test
    public void testResizeArrayIsNull() {
        assertArrayEquals(new int[]{0}, ArrayUtil.resize(null, 1));
    }

    @Test
    public void testResizeArrayIsEmpty() {
        assertArrayEquals(new int[]{0}, ArrayUtil.resize(new int[]{}, 1));
    }

    @Test
    public void testResizeSizeIsNegative() {
        assertArrayEquals(new int[]{}, ArrayUtil.resize(new int[]{1, 2}, -1));
    }

    @Test
    public void testResizeSizeIsZero() {
        assertArrayEquals(new int[]{}, ArrayUtil.resize(new int[]{1, 2}, 0));
    }

    @Test
    public void testResizeNewSizeIsSmaller() {
        assertArrayEquals(new int[]{1}, ArrayUtil.resize(new int[]{1, 2, 3}, 1));
    }

    @Test
    public void testResizeNewSizeIsBigger() {
        assertArrayEquals(new int[]{1, 0, 0}, ArrayUtil.resize(new int[]{1}, 3));
    }
}