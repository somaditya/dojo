package com.scaler.hashing;

import java.util.HashMap;

public class WindowString {
    public String minWindow(String A, String B) {
        HashMap<Character, Integer> bFreq = new HashMap<>();
        int bLen = B.length();
        int aLen = A.length();
        int counter = bLen;

        for (int i = 0; i < bLen; i++) {
            int count = bFreq.getOrDefault(B.charAt(i), 0);
            bFreq.put(B.charAt(i), count + 1);
        }

        int start = 0;
        int end = 0;
        int r = Integer.MAX_VALUE;
        int l = 0;

        while (end < aLen) {
            char ch = A.charAt(end);

            if (bFreq.containsKey(ch)) {
                int count = bFreq.get(ch) - 1;
                bFreq.put(ch, count);

                if (count >= 0) {
                    counter--;
                }

                while (counter == 0 && start <= end) {
                    int cur = end - start;

                    if (cur < (r - l)) {
                        l = start;
                        r = end;
                    }
                    char st = A.charAt(start);
                    if (bFreq.containsKey(st)) {
                        count = bFreq.get(st) + 1;
                        bFreq.put(st, count);
                        if (count > 0) {
                            counter++;
                        }
                    }

                    start++;
                }
            }

            end++;
        }

        if (r == Integer.MAX_VALUE) {
            return "";
        }

        return A.substring(l, r + 1);
    }
}
