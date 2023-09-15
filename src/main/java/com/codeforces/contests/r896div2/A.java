package com.codeforces.contests.r896div2;

import java.util.Scanner;

// incorrect
public class A {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int t = s.nextInt();

        for (int i = 0; i < t; i++) {
            int n = s.nextInt();
            int[] a = new int[n];

            for (int j = 0; j < n; j++) {
                a[j] = s.nextInt();
            }

            solve(a);
        }
    }

    static void solve(int[] a) {
        int n = a.length;
        int l = 0;
        int r = l + 1;
        int k = 0;
        int[][] ranges = new int[8][2];

        while (!allZeroes(a)) {
            int[] maxXorRange = findMaxXorRange(a);
            ranges[k][0] = maxXorRange[0];
            ranges[k][1] = maxXorRange[1];
            k++;
        }

        System.out.println(k);

        for (int i = 0; i < k; i++) {
            System.out.println(ranges[i][0] + " " + ranges[i][1]);
        }
    }

    static int[] findMaxXorRange(int[] a) {
        int n = a.length;
        int maxXor = Integer.MIN_VALUE;
        int l = 0;
        int r = n-1;

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int xor = a[i];

                for (int k = i+1; k <= j; k++) {
                    xor ^= a[k];
                }

                if (xor >= maxXor) {
                    maxXor = xor;
                    l = i;
                    r = j;
                }
            }
        }

        return new int[]{l, r};
    }

    static boolean allZeroes(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
