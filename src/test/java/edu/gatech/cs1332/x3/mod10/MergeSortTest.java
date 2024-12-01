package edu.gatech.cs1332.x3.mod10;

import org.junit.jupiter.api.Test;

class MergeSortTest {

    @Test
    void bubbleSort() {
        Integer[] arr = new Integer[20];

        for (int i = 0; i < 20; i++) {
            arr[i] = (int) (Math.random() * 100);
        }

        System.out.println("\nBUBBLE SORT:");
        System.out.println("before sorting:");
        for (int i = 0; i < 20; i++) {
            System.out.print(arr[i] + ", ");
        }

        Sorting.bubbleSort(arr, Integer::compareTo);

        System.out.println("\nafter sorting: ");
        for (int i = 0; i < 20; i++) {
            System.out.print(arr[i] + ", ");
        }

        System.out.println();
    }

    @Test
    void selectionSort() {
        Integer[] arr = new Integer[11];

        for (int i = 0; i < 11; i++) {
            arr[i] = (int) (Math.random() * 100);
        }

        System.out.println("\nSELECTION SORT:");
        System.out.println("before sorting:");
        for (int i = 0; i < 11; i++) {
            System.out.print(arr[i] + ", ");
        }

        Sorting.bubbleSort(arr, Integer::compareTo);

        System.out.println("\nafter sorting: ");
        for (int i = 0; i < 11; i++) {
            System.out.print(arr[i] + ", ");
        }

        System.out.println();
    }

    @Test
    void insertionSort() {
        Integer[] arr = new Integer[20];

        for (int i = 0; i < 20; i++) {
            arr[i] = (int) (Math.random() * 100);
        }

        System.out.println("\nINSERTION SORT:");
        System.out.println("before sorting:");
        for (int i = 0; i < 20; i++) {
            System.out.print(arr[i] + ", ");
        }

        Sorting.bubbleSort(arr, Integer::compareTo);

        System.out.println("\nafter sorting: ");
        for (int i = 0; i < 20; i++) {
            System.out.print(arr[i] + ", ");
        }

        System.out.println();
    }
}