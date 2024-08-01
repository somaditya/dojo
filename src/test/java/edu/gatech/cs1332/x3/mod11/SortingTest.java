package edu.gatech.cs1332.x3.mod11;

import org.junit.jupiter.api.Test;

class SortingTest {

    @Test
    void mergeSort() {
        Integer[] arr = new Integer[11];

        for (int i = 0; i < 11; i++) {
            arr[i] = (int) (Math.random() * 100);
        }

        System.out.println("\nMERGE SORT:");
        System.out.println("before sorting:");
        for (int i = 0; i < 11; i++) {
            System.out.print(arr[i] + ", ");
        }

        Sorting.mergeSort(arr, Integer::compareTo);

        System.out.println("\nafter sorting: ");
        for (int i = 0; i < 11; i++) {
            System.out.print(arr[i] + ", ");
        }

        System.out.println();
    }

    @Test
    void lsdRadixSort() {
        int[] arr = new int[20];

        for (int i = 0; i < 20; i++) {
            arr[i] = (int) (Math.random() * 100);
        }

        System.out.println("\nLSD RADIX SORT:");
        System.out.println("before sorting:");
        for (int i = 0; i < 20; i++) {
            System.out.print(arr[i] + ", ");
        }

        Sorting.lsdRadixSort(arr);

        System.out.println("\nafter sorting: ");
        for (int i = 0; i < 20; i++) {
            System.out.print(arr[i] + ", ");
        }

        System.out.println();
    }
}