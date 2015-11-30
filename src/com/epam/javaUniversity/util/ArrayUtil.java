package com.epam.javaUniversity.util;

import java.util.Arrays;
import java.util.Random;

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
        int[] firstSort = Arrays.copyOf(first, first.length);
        int[] secondSort = Arrays.copyOf(second, second.length);
        Arrays.sort(firstSort);
        Arrays.sort(secondSort);
        if (Arrays.equals(firstSort, secondSort)) {
            return true;
        }
        return false;
    }

    public static int[] shuffle(int[] input) {
        if (input == null || input.length == 0) {
            return new int[]{};
        }
        int[] output = Arrays.copyOf(input, input.length);
        Random rand = new Random();
        for (int i = output.length - 1; i > 0; i--) {
            int pos = rand.nextInt(i);
            int tmp = output[i];
            output[i] = output[pos];
            output[pos] = tmp;
        }
        return output;
    }

    public static void print(int[] input) {
        if (input == null || input.length == 0) {
            return;
        }
        for (int element : input) {
            System.out.print("| ");
            System.out.print(element);
            System.out.print(" ");
        }
        System.out.print("|");
    }
}