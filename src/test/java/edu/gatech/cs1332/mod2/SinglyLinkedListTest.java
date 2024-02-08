package edu.gatech.cs1332.mod2;

import edu.gatech.cs1332.x1.mod2.SinglyLinkedList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListTest {

    @Test
    void addToFront() {
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();
        sll.addToFront(5);
        sll.addToFront(4);
        sll.addToFront(3);
        sll.addToFront(2);
        sll.addToFront(1);

        assertEquals(5, sll.size());
        assertEquals(1, sll.getHead().getData());
        assertEquals(5, sll.getTail().getData());
    }

    @Test
    void addToBack() {
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();
        sll.addToBack(1);
        sll.addToBack(2);
        sll.addToBack(3);
        sll.addToBack(4);
        sll.addToBack(5);

        assertEquals(5, sll.size());
        assertEquals(1, sll.getHead().getData());
        assertEquals(5, sll.getTail().getData());
    }

    @Test
    void removeFromFront() {
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();
        sll.addToBack(1);
        sll.addToBack(2);
        sll.addToBack(3);
        sll.addToBack(4);
        sll.addToBack(5);

        for (int i = 0; i < 5; i++) {
            System.out.println("Removing: " + sll.removeFromFront());
            System.out.println("New Size: " + sll.size());
            System.out.println("----------------------------------------");
        }

        assertEquals(0, sll.size());
        assertNull(sll.getHead());
        assertNull(sll.getTail());
    }

    @Test
    void removeFromBack() {
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();
        sll.addToBack(1);
        sll.addToBack(2);
        sll.addToBack(3);
        sll.addToBack(4);
        sll.addToBack(5);

        for (int i = 0; i < 5; i++) {
            System.out.println("Removing: " + sll.removeFromBack());
            System.out.println("New Size: " + sll.size());
            System.out.println("----------------------------------------");
        }

        assertEquals(0, sll.size());
        assertNull(sll.getHead());
        assertNull(sll.getTail());
    }
}