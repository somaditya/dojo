package com.codeforces.contests.r881div3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();

            if (n == 1) {
                System.out.println(0);
                continue;
            } else if (n == 2) {
                int num1 = scanner.nextInt();
                int num2 = scanner.nextInt();

                System.out.println(Math.abs(num1 - num2));
            }
            List<Integer> arr = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                arr.add(scanner.nextInt());
            }

            Collections.sort(arr);

            int colors = arr.size() / 2;
            int totalCost = 0;

            for (int k = 0; k < colors; k++) {
                totalCost += arr.get(arr.size() - k - 1) - arr.get(k);
            }

            System.out.println(totalCost);
        }
    }
}
