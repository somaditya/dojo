package com.scaler.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
Given a sorted array of integers (not necessarily distinct) A and an integer B,
find and return how many pair of integers ( A[i], A[j] ) such that i != j have sum equal to B.

Since the number of such pairs can be very large, return number of such pairs modulo (109 + 7).
 */
public class Q4PairsWithGivenSum {
    public int solve(ArrayList<Integer> A, int B) {
        int n = A.size();
        int p1 = 0;
        int p2 = n - 1;
        long count = 0L;
        long mod = 1000000007L;

        while (p1 < p2) {
            if (A.get(p1) + A.get(p2) > B) {
                p2--;
            } else if (A.get(p1) + A.get(p2) < B) {
                p1++;
            } else {
                if (A.get(p1).equals(A.get(p2))) {
                    long dupCount = p2 - p1 + 1;
                    count += (dupCount * (dupCount - 1)) / 2;
                    break;
                } else {
                    int leftCount = 0;
                    int rightCount = 0;
                    int x = A.get(p1);
                    int y = A.get(p2);

                    while (A.get(p1) == x) {
                        leftCount++;
                        p1++;
                    }

                    while (A.get(p2) == y) {
                        rightCount++;
                        p2--;
                    }

                    count += (long) leftCount * rightCount;
                }
            }
        }

        count %= mod;
        return (int) count;
    }

    public static void main(String[] args) {
        int[] arr = {4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666};
        int B = 9259332;
        ArrayList<Integer> A = Arrays.stream(arr).boxed().collect(Collectors.toCollection(ArrayList::new));

        Q4PairsWithGivenSum sol = new Q4PairsWithGivenSum();
        System.out.println(sol.solve(A, B));
    }
}
