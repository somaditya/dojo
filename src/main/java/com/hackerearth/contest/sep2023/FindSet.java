package com.hackerearth.contest.sep2023;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class FindSet {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        Set<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String newWord = s.next();

            if (set.size() == 0) {
                set.add(newWord);
                continue;
            }
            boolean covered = false;

            Iterator<String> it = set.iterator();

            while (it.hasNext()) {
                String setWord = it.next();

                if (setWord.contains(newWord)) covered = true;

                break;
            }

            if (!covered) set.add(newWord);
        }

        System.out.println(set.size());
    }
}
