package edu.gatech.cs1332.x4.practice.patternmatching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Your implementations of the Boyer Moore string searching algorithm.
 */
public class PatternMatching {
    /**
     * Boyer Moore algorithm that relies on a last occurrence table.
     * This algorithm Works better with large alphabets.
     * <p>
     * Make sure to implement the buildLastTable() method, which will be
     * used in this boyerMoore() method.
     * <p>
     * Note: You may find the getOrDefault() method from Java's Map class useful.
     * <p>
     * You may assume that the passed in pattern, text, and comparator will not be null.
     *
     * @param pattern    The pattern you are searching for in a body of text.
     * @param text       The body of text where you search for the pattern.
     * @param comparator You MUST use this to check if characters are equal.
     * @return List containing the starting index for each match found.
     */
    public static List<Integer> boyerMoore(CharSequence pattern, CharSequence text, CharacterComparator comparator) {
        List<Integer> matches = new ArrayList<>();

        if (pattern.length() == 0 || text.length() < pattern.length()) {
            return matches;
        }

        Map<Character, Integer> lastTable = buildLastTable(pattern);
        int m = pattern.length();
        int n = text.length();
        int i = 0;

        while (i <= n - m) {
            int j = m - 1;

            while (j >= 0 && comparator.compare(text.charAt(i + j), pattern.charAt(j)) == 0) {
                j--;
            }

            if (j == -1) {
                matches.add(i);
                i++;
            } else {
                char mismatchedChar = text.charAt(i + j);
                int lastOccurrence = lastTable.getOrDefault(mismatchedChar, -1);
                i += Math.max(1, j - lastOccurrence);
            }
        }

        return matches;
    }

    /**
     * Builds the last occurrence table that will be used to run the Boyer Moore algorithm.
     * <p>
     * Note that each char x will have an entry at table.get(x).
     * Each entry should be the last index of x where x is a particular
     * character in your pattern.
     * If x is not in the pattern, then the table will not contain the key x,
     * and you will have to check for that in your Boyer Moore implementation.
     * <p>
     * Ex. pattern = octocat
     * <p>
     * table.get(o) = 3
     * table.get(c) = 4
     * table.get(t) = 6
     * table.get(a) = 5
     * table.get(everything else) = null, which you will interpret in
     * Boyer-Moore as -1
     * <p>
     * If the pattern is empty, return an empty map.
     * You may assume that the passed in pattern will not be null.
     *
     * @param pattern A pattern you are building last table for.
     * @return A Map with keys of all of the characters in the pattern mapping
     * to their last occurrence in the pattern.
     */
    public static Map<Character, Integer> buildLastTable(CharSequence pattern) {
        Map<Character, Integer> lastTable = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            lastTable.put(pattern.charAt(i), i);
        }

        return lastTable;
    }
}