package com.hackerrank;

import java.util.*;

public class JavaArrayList<I extends Number> {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<List<Integer>> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            int d = sc.nextInt();
            List<Integer> line = new ArrayList<>();

            if (d == 0) {
                list.add(null);
            } else {
                for (int j = 1; j <= d; j++) {
                    line.add(sc.nextInt());
                }
                list.add(line);
            }
        }

        int q = sc.nextInt();

        for (int i = 1; i <= q; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            try {
                System.out.println(list.get(x - 1).get(y - 1));
            } catch (RuntimeException e) {
                System.out.println("ERROR!");
            }
        }
    }
}

