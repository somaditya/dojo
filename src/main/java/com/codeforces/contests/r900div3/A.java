package com.codeforces.contests.r900div3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();

        for (int i = 0; i < t; i++) {
            int n = s.nextInt();
            int k = s.nextInt();

            List<Integer> list = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                list.add(s.nextInt());
            }

            System.out.println(solve(list, k));
        }
    }

    static String solve(List<Integer> l, int e) {
        String result = "NO";

        if (l.indexOf(e) > -1) result = "YES";

        return result;
    }
}
