package com.codeforces;

import java.util.Scanner;

public class WayTooLongWords {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            String word = in.next();
            int length = word.length();

            if (length <= 10) {
                System.out.println(word);
            } else {
                int mid = length - 2;
                System.out.println("" + word.charAt(0) + mid + word.charAt(length - 1));
            }
        }
    }
}