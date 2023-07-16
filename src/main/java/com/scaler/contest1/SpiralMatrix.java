package com.scaler.contest1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class SpiralMatrix {
    public ArrayList<ArrayList<Integer>> solve(ArrayList<Integer> A, int B, int C) {
        int[] dx = new int[4];
        int[] dy = new int[4];

        dx[0] = 0;
        dy[0] = 1;
        dx[1] = 1;
        dy[1] = 0;
        dx[2] = 0;
        dy[2] = -1;
        dx[3] = -1;
        dy[3] = 0;

        ArrayList<ArrayList<Integer>> spiral = new ArrayList<>();

        for (int r = 0; r < B; r++) {
            spiral.add(new ArrayList<>());

            for (int c = 0; c < C; c++) {
                spiral.get(r).add(0);
            }
        }

        int j = 0;
        int x = 0;
        int y = -1;
        for (int i = 0; i < B * C; i++) {
            int xx = x + dx[j];
            int yy = y + dy[j];

            if (xx < 0 || xx >= B || yy < 0 || yy >= C || spiral.get(xx).get(yy) != 0) {
                j = (j + 1) % 4;
                xx = x + dx[j];
                yy = y + dy[j];
            }

            spiral.get(xx).set(yy, A.get(i));
            x = xx;
            y = yy;
        }

        return spiral;
    }


    public static void main(String[] args) throws IOException {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int B = 3;
        int C = 3;
        ArrayList<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toCollection(ArrayList::new));

        SpiralMatrix sm = new SpiralMatrix();
        System.out.println(sm.solve(list, B, C));
    }
}
