package edu.gatech.cs1332.x2.mod7;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class ExternalChainingHashMapTest {

    @Test
    void put() {
        ExternalChainingHashMap<Integer, Integer> hashMap = new ExternalChainingHashMap<>();

        for (int i = 0; i < 100; i++) {
            hashMap.put(i, i);
        }

        for (ExternalChainingMapEntry<Integer, Integer> entry : hashMap.getTable()) {
            System.out.print(entry + " ");


            while (entry != null && entry.getNext() != null) {
                System.out.print(entry.getNext() + " ");
                entry = entry.getNext();
            }
        }

        assertThrows(IllegalArgumentException.class, () -> hashMap.put(null, null));
        assertEquals(hashMap.put(1, 2), 1);
        assertNull(hashMap.put(100, 100));
    }

    @Test
    void remove() {
        ExternalChainingHashMap<Integer, Integer> hashMap = new ExternalChainingHashMap<>();

        for (int i = 0; i < 100; i++) {
            hashMap.put(i, i);
        }

        for (ExternalChainingMapEntry<Integer, Integer> entry : hashMap.getTable()) {
            System.out.print(entry + " ");


            while (entry != null && entry.getNext() != null) {
                System.out.print(entry.getNext() + " ");
                entry = entry.getNext();
            }
        }

        for (int i = 0; i < 100; i++) {
            System.out.println(hashMap.remove(i));
        }

        assertThrows(NoSuchElementException.class, () -> hashMap.remove(101));
    }
}