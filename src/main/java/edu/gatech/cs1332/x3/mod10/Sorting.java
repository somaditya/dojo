package edu.gatech.cs1332.x3.mod10;

import java.util.Comparator;

/**
 * Your implementation of various iterative sorting algorithms.
 */
public class Sorting {

    /**
     * Implement bubble sort.
     *
     * It should be:
     * in-place
     * stable
     * adaptive
     *
     * Have a worst case running time of: O(n^2)
     * And a best case running time of: O(n)
     *
     * NOTE: You should implement bubble sort with the last swap optimization.
     *
     * You may assume that the passed in array and comparator
     * are both valid and will never be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array that must be sorted after the method runs.
     * @param comparator The Comparator used to compare the data in arr.
     */
    public static <T> void bubbleSort(T[] arr, Comparator<T> comparator) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        int stop = arr.length - 1;
        
        while (stop > 0) {
            int i = 0;
            int lastSwap = 0;
            
            while (i < stop) {
                if (comparator.compare(arr[i], arr[i + 1]) > 0) {
                    swap(arr, i, i + 1);
                    lastSwap = i;
                }
                
                i++;
            }
            
            stop = lastSwap;
        }
    }

    private static <T> void swap(T[] arr, int p1, int p2) {
        T tmp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = tmp;
    }

    /**
     * Implement selection sort.
     *
     * It should be:
     * in-place
     * unstable
     * not adaptive
     *
     * Have a worst case running time of: O(n^2)
     * And a best case running time of: O(n^2)
     *
     * You may assume that the passed in array and comparator
     * are both valid and will never be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array that must be sorted after the method runs.
     * @param comparator The Comparator used to compare the data in arr.
     */
    public static <T> void selectionSort(T[] arr, Comparator<T> comparator) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        int len = arr.length;

        for (int i = len-1; i >= 0; i--) {
            T max = arr[i];
            int maxInd = i;

            for (int j = 0; j < i; j++) {
                if (comparator.compare(arr[j], max) > 0) {
                    max = arr[j];
                    maxInd = j;
                }
            }

            swap(arr, maxInd, i);
        }
    }

    /**
     * Implement insertion sort.
     *
     * It should be:
     * in-place
     * stable
     * adaptive
     *
     * Have a worst case running time of: O(n^2)
     * And a best case running time of: O(n)
     *
     * You may assume that the passed in array and comparator
     * are both valid and will never be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array that must be sorted after the method runs.
     * @param comparator The Comparator used to compare the data in arr.
     */
    public static <T> void insertionSort(T[] arr, Comparator<T> comparator) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        int len = arr.length;

        for (int i = 0; i < len; i++) {
            int j = i;

            while (j > 0 && comparator.compare(arr[j-1], arr[j]) > 0) {
                swap(arr, j, j-1);
                j--;
            }
        }
    }
}