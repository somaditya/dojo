package edu.gatech.cs1332.x3.exam;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

class SortingTest {
    static Integer[] arr;

    @BeforeAll
    public static void setup() {
        arr = new Integer[100];

        System.out.println("Generating random array...\n");
        for (int i = 0; i < 100; i++) {
            arr[i] = (int) (Math.random() * 100);
            System.out.print(arr[i] + ", ");
        }

        System.out.println();
    }

    @Test
    void mergeSort() {
        Sorting.mergeSort(arr, Comparator.comparingInt(Integer::intValue));
        System.out.println("After merge sort: \n");

        for (int i = 0; i < 100; i++) {
            System.out.print(arr[i] + ", ");
        }
    }
}