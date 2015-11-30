package com.epam.javaUniversity.util;

import org.junit.Test;

import java.util.Arrays;

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

    @Test
    public void testEqualsEmptyArrays() {
        assertTrue(ArrayUtil.equals(null, null));
        assertTrue(ArrayUtil.equals(new int[]{}, new int[]{}));
        assertFalse(ArrayUtil.equals(null, new int[]{}));
    }

    @Test
    public void testEqualsOneOfTheArraysIsNull() {
        assertFalse(ArrayUtil.equals(null, new int[]{1, 2, 3}));
    }

    @Test
    public void testEqualsOneOfTheArraysIsEmpty() {
        assertFalse(ArrayUtil.equals(new int[]{}, new int[]{1, 2, 3}));
    }

    @Test
    public void testEqualsArraysHaveDifferentSize() {
        assertFalse(ArrayUtil.equals(new int[]{1, 2}, new int[]{1, 2, 3}));
    }

    @Test
    public void testEqualsArraysHaveDifferentElements() {
        assertFalse(ArrayUtil.equals(new int[]{1, 2, 3}, new int[]{3, 4, 5}));
    }

    @Test
    public void testEqualsArraysHaveElementsInTheSameOrder() {
        assertTrue(ArrayUtil.equals(new int[]{1, 2, 3}, new int[]{1, 2, 3}));
    }

    @Test
    public void testEqualsArraysHaveElementsInTheDifferentOrder() {
        assertTrue(ArrayUtil.equals(new int[]{1, 2, 3}, new int[]{2, 3, 1}));
    }

    @Test
    public void testShuffleSourceArrayIsNull() {
        assertArrayEquals(new int[]{}, ArrayUtil.shuffle(null));
    }

    @Test
    public void testShuffleSourceArrayIsEmpty() {
        assertArrayEquals(new int[]{}, ArrayUtil.shuffle(new int[]{}));
    }

    @Test
    public void testShuffleNewArrayContainsOriginalElements() {
        assertTrue(ArrayUtil.equals(new int[]{1, 2, 3, 4, 5}, ArrayUtil.shuffle(new int[]{1, 2, 3, 4, 5})));
    }

    @Test
    public void testShuffleNewArrayNotEqualsToSourceArray() {
        assertFalse(Arrays.equals(new int[]{1, 2, 3, 4, 5}, ArrayUtil.shuffle(new int[]{1, 2, 3, 4, 5})));
    }

    @Test
    public void testShuffleNoElementIsOnAFormerPlace() {
        int[] src = new int[100];
        for (int i = 0; i < 100; i++) {
            src[i] = i;
        }
        int[] res = ArrayUtil.shuffle(src);
        for (int i = 0; i < 100; i++) {
            assertNotEquals(src[i], res[i]);
        }
    }
}