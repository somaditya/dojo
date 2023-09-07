package com.codeforces.contests.r895div3;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();

            int a = l;
            int b = r - a;

            solve(a, b);
        }
    }

    public static String solve(int a, int b) {
        while (a <= b) {
            if (gcd(a, b) != 1) {
                return (a + " " + b);
            }

            a++;
            b--;
        }

        return "-1";
    }
    public static int gcd(int a, int b) {
        if (a == 0) return b;

        return gcd(b % a, a);
    }
}
