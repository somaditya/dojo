package com.scaler.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddOneToNumber {
    public static ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        long num = 0;
        int exp = 0;

        for (int i = A.size() - 1; i >= 0; i--) {
            num += (long) Math.pow(10, exp++) * A.get(i);
        }

        num++;

        ArrayList<Integer> result  = new ArrayList<>();

        while (num > 0) {
            result.add((int) (num % 10));
            num /= 10;
        }

        Collections.reverse(result);

        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>(List.of(1, 1, 1, 3, 2, 1, 1, 2, 5, 9, 6, 6));

        System.out.println(plusOne(input));
    }
}
