package com.epam.javaUniversity.util;

import java.util.Arrays;

public final class ArrayUtil {
    private ArrayUtil() {
    }

    public static int[] resize(int[] input, int newSize) {
        if (newSize <= 0) {
            return new int[]{};
        }
        if (input == null) {
            return new int[newSize];
        }
        return Arrays.copyOf(input, newSize);
    }

    public static boolean equals(int[] first, int[] second) {
        if (first == null && second == null) {
            return true;
        }
        if ((first == null && second != null) ||
                (first != null && second == null)) {
            return false;
        }
        if (first.length != second.length) {
            return false;
        }
        if (matchElements(first, second)) {
            return true;
        }
        return false;
    }

    private static boolean matchElements(int[] first, int[] second) {
        int[] firstSort = first.clone();
        int[] secondSort = second.clone();
        Arrays.sort(firstSort);
        Arrays.sort(secondSort);
        if (Arrays.equals(firstSort, secondSort)) {
            return true;
        }
        return false;
    }

    public static int[] shuffle(int[] input) {
        return null;
    }

    public static void print(int[] input) {

    }
}
