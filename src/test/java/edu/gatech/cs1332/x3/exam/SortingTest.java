package edu.gatech.cs1332.x3.exam;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class SortingTest {

    @Test
    void mergeSort() {
        Integer[] arr = new Integer[100];

        System.out.println("Generating random array...\n");
        for (int i = 0; i < 100; i++) {
            arr[i] = (int) (Math.random() * 100);
            System.out.print(arr[i] + ", ");
        }

        Sorting s = new Sorting();
        s.mergeSort(arr, Comparator.naturalOrder());
        System.out.println("After merge sort: \n");

        for (int i = 0; i < 100; i++) {
            System.out.print(arr[i] + ", ");
        }
    }
}