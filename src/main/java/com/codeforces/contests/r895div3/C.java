package com.codeforces.contests.r895div3;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();

            System.out.println(solve(l, r));
        }
    }

    public static String solve(int l, int r) {
        for (int a = 2; a <= (int) Math.sqrt(l + r); a++) {
            for (int b = Math.max(a, l - a); b <= (r - a); b++) {
                if (gcd(a, b) != 1) return a + " " + b;
            }
        }

        return "-1";
    }
    public static int gcd(int a, int b) {
        if (a == 0) return b;

        return gcd(b % a, a);
    }
}
