package edu.gatech.cs1332.mod1;

import edu.gatech.cs1332.x1.mod1.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayListTest {
    ArrayList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new ArrayList<>();
    }

    @Test
    void addToFront() {
        for (int i = 0; i < 42; i++) {
            list.addToFront(i+1);
        }

        assertEquals(42, list.size());
        printList();
    }

    @Test
    void addToBack() {
        for (int i = 0; i < 42; i++) {
            list.addToBack(i+1);
        }

        assertEquals(42, list.size());
        printList();
    }

//    @Test
    void removeFromFront() {
        for (int i = 0; i < 42; i++) {
            list.addToBack(i+1);
        }

        assertEquals(42, list.size());
        assertEquals(1, list.removeFromFront());
        assertEquals(2, list.removeFromFront());
        assertEquals(3, list.removeFromFront());
    }

    @Test
    void removeFromBack() {

        for (int i = 0; i < 42; i++) {
            list.addToBack(i+1);
        }

        assertEquals(42, list.size());
        assertEquals(42, list.removeFromBack());
        assertEquals(41, list.removeFromBack());
        assertEquals(40, list.removeFromBack());
    }

    @Test
    void getBackingArray() {
    }

    @Test
    void size() {
        for (int i = 0; i < 42; i++) {
            list.addToFront(i+1);
        }

        assertEquals(42, list.size());
        printList();
        assertEquals(0, list.size());
    }

    void printList() {
        System.out.print("ArrayList[");
        while (list.size() > 0) {
            System.out.print(list.removeFromFront() + ", ");
        }
        System.out.print("]");
        System.out.println();
    }
}