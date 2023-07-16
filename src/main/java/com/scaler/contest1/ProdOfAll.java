package com.scaler.contest1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class ProdOfAll {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> input = new ArrayList<>(IntStream.range(1, 5).boxed().toList());

        ProdOfAll p = new ProdOfAll();
        System.out.println(p.solve(input).toString());
    }

    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int N = A.size();
        final int MOD = 1000000000 + 7;

        ArrayList<Long> pf = new ArrayList<>();
        ArrayList<Long> sf = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            pf.add(1L);
            sf.add(1L);
        }

        for (int i = 1; i < N; i++) {
            pf.set(i, (pf.get(i - 1) * Long.valueOf(A.get(i - 1))) % MOD);
        }

        for (int i = N - 2; i >= 0; i--) {
            sf.set(i, (sf.get(i + 1) * Long.valueOf(A.get(i + 1))) % MOD);
        }

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            result.add(Math.toIntExact((pf.get(i) * sf.get(i)) % MOD));
        }

        return result;
    }
}
