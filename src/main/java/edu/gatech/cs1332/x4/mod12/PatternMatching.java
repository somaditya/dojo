package edu.gatech.cs1332.x4.mod12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Your implementations of the Boyer Moore string searching algorithm.
 */
public class PatternMatching {
    /**
     * Boyer Moore algorithm that relies on a last occurrence table.
     * This algorithm Works better with large alphabets.
     *
     * Make sure to implement the buildLastTable() method, which will be
     * used in this boyerMoore() method.
     *
     * Note: You may find the getOrDefault() method from Java's Map class useful.
     *
     * You may assume that the passed in pattern, text, and comparator will not be null.
     *
     * @param pattern    The pattern you are searching for in a body of text.
     * @param text       The body of text where you search for the pattern.
     * @param comparator You MUST use this to check if characters are equal.
     * @return           List containing the starting index for each match found.
     */
    public static List<Integer> boyerMoore(CharSequence pattern, CharSequence text, CharacterComparator comparator) {
        List<Integer> matches = new ArrayList<>();

        if (pattern.length() == 0 || text.length() == 0 || pattern.length() > text.length()) {
            return matches;
        }

        // Build the last occurrence table
        Map<Character, Integer> lastTable = buildLastTable(pattern);

        int i = 0; // Position of the pattern's right end in the text
        while (i <= text.length() - pattern.length()) {
            int j = pattern.length() - 1; // Start comparing from the right end of pattern

            // Keep matching characters from right to left as long as they match
            while (j >= 0 && comparator.compare(pattern.charAt(j), text.charAt(i + j)) == 0) {
                j--;
            }

            if (j == -1) {
                // Pattern found - add the starting index to matches
                matches.add(i);
                // Move pattern by 1 to find overlapping patterns
                i++;
            } else {
                // Character mismatch - calculate shift
                char mismatchChar = text.charAt(i + j);
                int lastOccurrence = lastTable.getOrDefault(mismatchChar, -1);

                // Calculate the shift
                // If character not in pattern: shift pattern length
                // If character in pattern: shift to align last occurrence
                int shift = Math.max(1, j - lastOccurrence);
                i += shift;
            }
        }

        return matches;
    }

    /**
     * Builds the last occurrence table that will be used to run the Boyer Moore algorithm.
     *
     * Note that each char x will have an entry at table.get(x).
     * Each entry should be the last index of x where x is a particular
     * character in your pattern.
     * If x is not in the pattern, then the table will not contain the key x,
     * and you will have to check for that in your Boyer Moore implementation.
     *
     * Ex. pattern = octocat
     *
     * table.get(o) = 3
     * table.get(c) = 4
     * table.get(t) = 6
     * table.get(a) = 5
     * table.get(everything else) = null, which you will interpret in
     * Boyer-Moore as -1
     *
     * If the pattern is empty, return an empty map.
     * You may assume that the passed in pattern will not be null.
     *
     * @param pattern A pattern you are building last table for.
     * @return A Map with keys of all of the characters in the pattern mapping
     *         to their last occurrence in the pattern.
     */
    public static Map<Character, Integer> buildLastTable(CharSequence pattern) {
        Map<Character, Integer> lastTable = new HashMap<>();

        // For each character in the pattern, store its last occurrence index
        for (int i = 0; i < pattern.length(); i++) {
            lastTable.put(pattern.charAt(i), i);
        }

        return lastTable;
    }
}