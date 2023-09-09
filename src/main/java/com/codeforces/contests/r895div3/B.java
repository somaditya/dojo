package com.codeforces.contests.r895div3;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();

            int[] d = new int[n];
            int[] s = new int[n];

            for (int j = 0; j < n; j++) {
                d[j] = sc.nextInt();
                s[j] = sc.nextInt();
            }

            System.out.println(solve(n, d, s));
        }
    }

    public static int solve(int n, int[] d, int[] s) {
        int k = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int trap = d[i] - 1;
            int time = s[i];

            int maxK = trap + (time + 1) / 2;

            k = Math.min(k, maxK);
        }

        return k;
    }
}
