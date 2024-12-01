package edu.gatech.cs1332.x3.exam;

import java.util.Comparator;

/**
 * Your implementation of Selection Sort.
 */
public class SelectionSort {

    /**
     * Implement selection sort.
     *
     * It should be: in-place unstable not adaptive
     *
     * Have a worst case running time of: O(n^2) And a best case running time of:
     * O(n^2)
     *
     * You may assume that the passed in array and comparator are both valid and
     * will never be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array that must be sorted after the method runs.
     * @param comparator The Comparator used to compare the data in arr.
     */
    public static <T> void selectionSort(T[] arr, Comparator<T> comparator) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        int len = arr.length;

        for (int i = len-1; i >= 0; i--) {
            int maxIdx = i;

            for (int j = 0; j < i; j++) {
                if (comparator.compare(arr[j], arr[maxIdx]) > 0) {
                    maxIdx = j;
                }
            }

            swap(arr, i, maxIdx);
        }
    }

    private static <T> void swap(T[] arr, int first, int second) {
        T tmp = arr[first];
        arr[first] = arr[second];
        arr[second] = tmp;
    }
}