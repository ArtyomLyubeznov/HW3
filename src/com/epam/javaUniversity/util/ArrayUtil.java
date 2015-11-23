package com.epam.javaUniversity.util;

import java.util.Arrays;

public final class ArrayUtil {
    private ArrayUtil() {
    }

    public static int[] resize(int[] input, int newSize) {
        if (newSize <= 0) {
            return new int[]{};
        }
        if (input == null){
            return new int[newSize];
        }
        return Arrays.copyOf(input, newSize);
    }

    public static boolean equal(int[] first, int second) {
        return false;
    }

    public static int[] shuffle(int[] input) {
        return null;
    }

    public static void print(int[] input) {

    }
}
