package edu.gatech.cs1332.x2.mod7;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class ExternalChainingHashMapTest {

    @Test
    void put() {
        ExternalChainingHashMap<Integer, Integer> hashMap = new ExternalChainingHashMap<>();

        for (int i = 0; i <= 40; i +=5) {
            hashMap.put(i, i);
            System.out.printf("Adding (%d, %d) | Size: %d\n", i, i, hashMap.size());
        }

        System.out.println("-------------------------------");
        print(hashMap);

        assertThrows(IllegalArgumentException.class, () -> hashMap.put(null, null));
        assertEquals(hashMap.put(0, 2), 0);
        assertNull(hashMap.put(100, 100));
    }

    private static void print(ExternalChainingHashMap<Integer, Integer> hashMap) {
        for (ExternalChainingMapEntry<Integer, Integer> entry : hashMap.getTable()) {
            System.out.print(entry + " ");


            while (entry != null && entry.getNext() != null) {
                System.out.print(" -> " + entry.getNext() + " -> ");
                entry = entry.getNext();
            }

            System.out.println();
        }
    }

    @Test
    void remove() {
        ExternalChainingHashMap<Integer, Integer> hashMap = new ExternalChainingHashMap<>();

        for (int i = 0; i < 100; i +=5) {
            hashMap.put(i, i);
            System.out.printf("Adding (%d, %d) | Size: %d\n", i, i, hashMap.size());
        }

        System.out.println("***** BEFORE *****");
        System.out.println("SIZE: " + hashMap.size());
        print(hashMap);

        assertEquals(60, hashMap.remove(60));

        System.out.println("***** AFTER *****");
        System.out.println("SIZE: " + hashMap.size());
        print(hashMap);

        assertEquals(10, hashMap.remove(10));
        System.out.println("***** REMOVE KEY 10 *****");
        System.out.println("SIZE: " + hashMap.size());
        print(hashMap);
        assertThrows(NoSuchElementException.class, () -> hashMap.remove(101));
    }
}