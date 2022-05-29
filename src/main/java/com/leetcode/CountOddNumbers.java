package com.leetcode;

public class CountOddNumbers {
    public int countOdds(int low, int high) {
        return (low%2 == 1 || high%2 ==1)? (high-low)/2 +1 : (high-low)/2;
    }
}
