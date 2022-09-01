package com.jpmorganchase;

import java.util.Arrays;

public class ReverseArray {
    static int[] reverseArray(int[] input) {
        int l = input.length;

        for (int i = 0; i < l/2; i++) {
            int temp = input[i];
            input[i] = input[l - 1 - i];
            input[l - i - 1] = temp;
        }

        return input;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(reverseArray(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(reverseArray(new int[]{1, 2, 3, 4, 5, 6})));
    }
}
