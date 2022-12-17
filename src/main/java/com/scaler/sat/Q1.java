package com.scaler.sat;

import java.util.ArrayList;

public class Q1 {
    public int solve(ArrayList<Integer> A) {
        int maxEven = Integer.MIN_VALUE;
        int minOdd = Integer.MAX_VALUE;

        for (int i : A) {
            if (i % 2 == 0 && i > maxEven) {
                maxEven = i;
            }

            if (i % 2 != 0 && i < minOdd) {
                minOdd = i;
            }
        }

        return maxEven - minOdd;
    }
}
