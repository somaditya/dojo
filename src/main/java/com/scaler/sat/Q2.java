package com.scaler.sat;

import java.util.ArrayList;

public class Q2 {
    public int solve(ArrayList<Integer> A, int B) {
        int count = 0;

        for (int i = 0; i < A.size(); i++) {
            for (int j = i + 1; j < A.size(); j++) {
                if (A.get(i) + A.get(j) == B) count++;
            }
        }

        return count;
    }
}