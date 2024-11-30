package edu.gatech.cs1332.x3.exam;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Your implementation of Merge Sort.
 */
public class Sorting {

    /**
     * Implement merge sort.
     *
     * It should be: out-of-place stable not adaptive
     *
     * Have a worst case running time of: O(n log n) And a best case running time
     * of: O(n log n)
     *
     * You can create more arrays to run merge sort, but at the end, everything
     * should be merged back into the original T[] which was passed in.
     *
     * When splitting the array, if there is an odd number of elements, put the
     * extra data on the right side.
     *
     * Hint: You may need to create a helper method that merges two arrays back into
     * the original T[] array. If two data are equal when merging, think about which
     * subarray you should pull from first.
     *
     * You may assume that the passed in array and comparator are both valid and
     * will not be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array to be sorted.
     * @param comparator The Comparator used to compare the data in arr.
     */
    public static <T> void mergeSort(T[] arr, Comparator<T> comparator) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        int n = arr.length;
        if (n < 2) return;

        // divide
        int mid = n/2;
        T[] left = Arrays.copyOfRange(arr, 0, mid);
        T[] right = Arrays.copyOfRange(arr, mid, n);

        // conquer
        mergeSort(left, comparator);
        mergeSort(right, comparator);

        merge(left, right, arr, comparator);
    }

    private static <T> void merge(T[] left, T[] right, T[] arr, Comparator<T> comparator) {
        int i = 0, j = 0;

        while (i + j < arr.length) {
            if (j == right.length || (i < left.length && comparator.compare(left[i], right[j]) < 0)) {
                arr[i+j] = left[i++];
            } else {
                arr[i+j] = right[j++];
            }
        }
    }
}