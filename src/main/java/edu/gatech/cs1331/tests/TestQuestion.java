package edu.gatech.cs1331.tests;

import java.util.ArrayList;
import java.util.Random;

public class TestQuestion {
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        for (int i = 0; i < 10_000; i++) {
            Random random = new Random();
            System.out.println(random.nextInt(8) + 3);
        }
    }

    public static void letsGetEven(ArrayList<Integer> nums) {
        for (int i = nums.size() - 1; i >= 0; i--) {
            if (nums.get(i) / 2 == 0) {
                nums.remove(i);
            }
        }
    }
}