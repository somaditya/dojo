package com.codeforces.contests.r895div3;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            System.out.println(solve(a, b, c));
        }
    }

    public static int solve(int a, int b, int c) {
        int ans = 0;

        if (a == b) return ans;

        return (int) Math.ceil((((a + b) / 2.0) - Math.min(a , b)) / c);
    }
}
