package jp.atcoder.abc325.b;

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int t = s.nextInt();
        int[][] data = new int[t][2];

        for (int i = 0; i < t; i++) {
            int w = s.nextInt();
            int x = s.nextInt();

            data[i][0] = w;
            data[i][1] = x;
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < 24; i++) {
            int cnt = 0;

            for (int j = 0; j < t; j++) {
                data[j][1] = (data[j][1] + i) % 24;

                if (data[j][1] >= 9 && data[j][1] < 18) cnt += data[j][0];
            }

            max = Math.max(cnt, max);
        }

        System.out.println(max);
    }
}