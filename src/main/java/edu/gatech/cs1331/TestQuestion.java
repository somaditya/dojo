package edu.gatech.cs1331;

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
}