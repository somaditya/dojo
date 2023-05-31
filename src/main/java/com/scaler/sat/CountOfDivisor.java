package com.scaler.sat;

import java.util.ArrayList;

public class CountOfDivisor {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < A.size(); i++) {
            result.add(countDiv(A.get(i)));
        }

        return result;
    }

    public int countDiv(int N) {
        int d = 0;

        for (int i = 1; i <= N; i++) {
            if (N % i == 0) d++;
        }

        return d;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(2);
        A.add(3);
        A.add(4);
        A.add(5);

        CountOfDivisor cd = new CountOfDivisor();

        System.out.println(cd.solve(A));
    }
}
