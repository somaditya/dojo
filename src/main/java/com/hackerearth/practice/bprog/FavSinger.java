package com.hackerearth.practice.bprog;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FavSinger {
    public static void main(String[] args) throws Exception {
        //Scanner
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();

        Map<Long, Integer> hm = new HashMap<>();

        for (int i = 0; i < N; i++) {
            long singer = s.nextLong();

            if (hm.containsKey(singer)) {
                hm.put(singer, hm.get(singer) + 1);
            } else {
                hm.put(singer, 1);
            }
        }

        int maxFreq = Integer.MIN_VALUE;

        for (Map.Entry<Long, Integer> entry : hm.entrySet()) {
            maxFreq = Math.max(maxFreq, entry.getValue());
        }

        int countFav = 0;

        for (Map.Entry<Long, Integer> entry : hm.entrySet()) {
            if (entry.getValue() == maxFreq) countFav++;
        }

        System.out.println(countFav);
    }
}
