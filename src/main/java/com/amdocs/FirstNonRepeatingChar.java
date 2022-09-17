package com.amdocs;

import java.util.HashMap;

public class FirstNonRepeatingChar {

    public static void main(String[] args) {
        String input = "india";

        System.out.println(find(input));
    }

    private static char find(String input) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : input.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }

        char result = 0;

        for (char c : input.toCharArray()) {
            if (map.get(c) < 2) {
                result = c;
                break;
            }
        }

        return result;
    }
}
