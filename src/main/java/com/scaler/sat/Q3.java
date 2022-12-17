package com.scaler.sat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Q3 {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<Integer> result = new ArrayList<>();

        Map<Integer, Integer> mapA = new HashMap<>();
        Map<Integer, Integer> mapB = new HashMap<>();
        Map<Integer, Integer> mapC = new HashMap<>();

        for (int i : A) {
            if (mapA.containsKey(i)) {
                mapA.put(i, mapA.get(i) + 1);
            } else {
                mapA.put(i, 1);
            }
        }

        for (int i : B) {
            if (mapB.containsKey(i)) {
                mapB.put(i, mapB.get(i) + 1);
            } else {
                mapB.put(i, 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : mapA.entrySet()) {
            if (mapB.containsKey(entry.getKey())) {
                mapC.put(entry.getKey(), Math.min(mapA.get(entry.getKey()), mapB.get(entry.getKey())));
            }
        }


        for (Map.Entry<Integer, Integer> entry : mapC.entrySet()) {
            for (int i = 1; i <= entry.getValue(); i++) {
                result.add(entry.getKey());
            }
        }

        return result;
    }
}