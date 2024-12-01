package edu.gatech.cs1332.x3.exam;

import java.util.Comparator;

/**
 * Your implementation of Merge Sort.
 */
public class Sorting {

    /**
     * Implement merge sort.
     * <p>
     * It should be: out-of-place stable not adaptive
     * <p>
     * Have a worst case running time of: O(n log n) And a best case running time
     * of: O(n log n)
     * <p>
     * You can create more arrays to run merge sort, but at the end, everything
     * should be merged back into the original T[] which was passed in.
     * <p>
     * When splitting the array, if there is an odd number of elements, put the
     * extra data on the right side.
     * <p>
     * Hint: You may need to create a helper method that merges two arrays back into
     * the original T[] array. If two data are equal when merging, think about which
     * subarray you should pull from first.
     * <p>
     * You may assume that the passed in array and comparator are both valid and
     * will not be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array to be sorted.
     * @param comparator The Comparator used to compare the data in arr.
     */
    public static <T> void mergeSort(T[] arr, Comparator<T> comparator) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        int size = arr.length;

        if (size == 1) return;

        int mid = size / 2;

        T[] leftArr = (T[]) new Object[mid];
        T[] rightArr = (T[]) new Object[size - mid];

        for (int i = 0; i < mid; i++) {
            leftArr[i] = arr[i];
        }

        for (int i = 0; i < size - mid; i++) {
            rightArr[i] = arr[i + mid];
        }

        mergeSort(leftArr, comparator);
        mergeSort(rightArr, comparator);

        int l = 0, r = 0, curr = 0;

        while (l < mid && r < size - mid) {
            if (comparator.compare(leftArr[l], rightArr[r]) <= 0) {
                arr[curr++] = leftArr[l++];
            } else {
                arr[curr++] = rightArr[r++];
            }
        }

        while (l < mid) {
            arr[curr++] = leftArr[l++];
        }

        while (r < size - mid) {
            arr[curr++] = rightArr[r++];
        }
    }
}