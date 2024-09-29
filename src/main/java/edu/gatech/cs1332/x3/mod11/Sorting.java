package edu.gatech.cs1332.x3.mod11;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Your implementation of various divide & conquer sorting algorithms.
 */

public class Sorting {

    /**
     * Implement merge sort.
     * <p>
     * It should be:
     * out-of-place
     * stable
     * not adaptive
     * <p>
     * Have a worst case running time of: O(n log n)
     * And a best case running time of: O(n log n)
     * <p>
     * You can create more arrays to run merge sort, but at the end, everything
     * should be merged back into the original T[] which was passed in.
     * <p>
     * When splitting the array, if there is an odd number of elements, put the
     * extra data on the right side.
     * <p>
     * Hint: You may need to create a helper method that merges two arrays
     * back into the original T[] array. If two data are equal when merging,
     * think about which subarray you should pull from first.
     * <p>
     * You may assume that the passed in array and comparator are both valid
     * and will not be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array to be sorted.
     * @param comparator The Comparator used to compare the data in arr.
     */
    public static <T> void mergeSort(T[] arr, Comparator<T> comparator) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        int len = arr.length;
        int mid = len / 2;

        if (len < 2) return;

        T[] left = (T[]) new Object[mid];
        T[] right = (T[]) new Object[len - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }

        for (int i = 0; i < len - mid; i++) {
            right[i] = arr[i + mid];
        }

        mergeSort(left, comparator);
        mergeSort(right, comparator);

        int l = 0;
        int r = 0;
        int c = 0;

        while (l < mid && r < (len - mid)) {
            if (comparator.compare(left[l], right[r]) < 1) {
                arr[c] = left[l++];
            } else {
                arr[c] = right[r++];
            }

            c++;
        }

        while (l < mid) {
            arr[c++] = left[l++];
        }

        while (r < len - mid) {
            arr[c++] = right[r++];
        }
    }

    /**
     * Implement LSD (least significant digit) radix sort.
     * <p>
     * It should be:
     * out-of-place
     * stable
     * not adaptive
     * <p>
     * Have a worst case running time of: O(kn)
     * And a best case running time of: O(kn)
     * <p>
     * Feel free to make an initial O(n) passthrough of the array to
     * determine k, the number of iterations you need.
     * <p>
     * At no point should you find yourself needing a way to exponentiate a
     * number; any such method would be non-O(1). Think about how how you can
     * get each power of BASE naturally and efficiently as the algorithm
     * progresses through each digit.
     * <p>
     * You may use an ArrayList or LinkedList if you wish, but it should only
     * be used inside radix sort and any radix sort helpers. Do NOT use these
     * classes with merge sort. However, be sure the List implementation you
     * choose allows for stability while being as efficient as possible.
     * <p>
     * Do NOT use anything from the Math class except Math.abs().
     * <p>
     * You may assume that the passed in array is valid and will not be null.
     *
     * @param arr The array to be sorted.
     */
    public static void lsdRadixSort(int[] arr) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        List<Integer>[] buckets = new ArrayList[19];
        int len = arr.length;

        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        int k = 0;
        for (int i = 0; i < len; i++) {
            int num = arr[i];
            int d = 0;

            while (num > 0) {
                d++;
                num /= 10;
            }

            k = Math.max(k, d);
        }

        int base = 1;

        for (int i = 0; i <= k; i++) {
            System.out.println("\nIteration " + (i+1));
            for (int j = 0; j < len; j++) {
                int digit = (arr[j] / base) % 10;
                buckets[digit + 9].add(arr[j]);
            }

            int index = 0;
            for (List<Integer> bucket : buckets) {
                while (!bucket.isEmpty()) {
                    arr[index++] = bucket.remove(0);
                }
            }

            base *= 10;

            for (int n : arr) {
                System.out.print(n + ", ");
            }
        }
    }
}