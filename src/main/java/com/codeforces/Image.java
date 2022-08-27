package com.codeforces;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Image {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            Map<Character, Integer> map = new HashMap<>();
            String line1 = in.next();
            String line2 = in.next();

            Character[] colors = new Character[4];
            colors[0] = line1.charAt(0);
            colors[1] = line1.charAt(1);
            colors[2] = line2.charAt(0);
            colors[3] = line2.charAt(1);

            for (Character color : colors) {
                if (!map.containsKey(color)) {
                    map.put(color, 1);
                } else {
                    map.put(color, map.get(color) + 1);
                }
            }

            System.out.println(map.size() - 1);
        }
    }
}
