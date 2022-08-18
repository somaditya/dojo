package com.codechef;

import java.util.*;

public class Attendance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();

            String[][] names = new String[N][2];
            Map<String, Integer> freq = new HashMap<>();

            for (String[] name : names) {
                name[0] = sc.next();
                name[1] = sc.next();

                if (!freq.containsKey(name[0])) {
                    freq.put(name[0], 1);
                } else {
                    freq.put(name[0], freq.get(name[0]) + 1);
                }
            }

            for (String[] name : names) {
                if (freq.get(name[0]) == 1) {
                    System.out.println(name[0]);
                } else {
                    System.out.println(name[0] + " " + name[1]);
                }
            }
        }
    }
}