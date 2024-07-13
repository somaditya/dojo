package edu.gatech.cs1332.x2.mod6;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.concurrent.Callable;

import static org.junit.jupiter.api.Assertions.*;
class MinHeapTest {

    @Test
    void add() {
        MinHeap<Integer> minHeap = new MinHeap<>();

        for (int i = 1; i < 10; i++) {
            minHeap.add(i);
        }

        minHeap.add(0);

        System.out.println(Arrays.toString(minHeap.getBackingArray()));
    }

    @Test
    void remove() {
        MinHeap<Integer> minHeap = new MinHeap<>();

        minHeap.add(0);
        minHeap.add(1);
        minHeap.add(2);
        minHeap.add(4);
        minHeap.add(3);
        minHeap.add(5);
        minHeap.add(7);
        minHeap.add(6);
        minHeap.add(8);
        minHeap.add(9);
        minHeap.add(10);

        minHeap.remove();

        System.out.println(Arrays.toString(minHeap.getBackingArray()));
    }
}