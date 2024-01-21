package edu.gatech.cs1331.hw07;

import java.util.NoSuchElementException;

public class LinkedList<T> implements List<T> {
    Node<T> head;
    Node<T> tail;
    int size;

    public LinkedList() {
        head = null;
        tail = null;
    }

    @Override
    public void addAtIndex(T data, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Your index is out of the list bounds");
        }

        if (data == null) {
            throw new IllegalArgumentException("You cannot add null data to the list");
        }

        Node<T> newNode = new Node<>(data);

        int i = 0;
        Node<T> curr = head;
        Node<T> prev = null;

        while (i < index && curr.next != null) {
            prev = curr;
            curr = curr.next;
            i++;
        }

        newNode.next = curr;

        if (prev != null) {
            prev.next = newNode;
        }

        if (index == 0) head = newNode;
        if (index == size  - 1) tail = newNode;
        size++;
    }

    @Override
    public T getAtIndex(int index) {
        if (index < 0 || index > (size - 1)) {
            throw new IllegalArgumentException("Your index is out of the list bounds");
        }

        Node<T> node = head;

        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node.data;
    }

    @Override
    public T removeAtIndex(int index) {
        if (index < 0 || index > (size - 1)) {
            throw new IllegalArgumentException("Your index is out of bounds");
        }

        Node<T> curr = head;
        Node<T> prev = null;
        int i = 0;

        while (i < index) {
            prev = curr;
            curr = curr.next;
            i++;
        }

        if (prev != null) {
            prev.next = curr.next;
        }

        if (index == 0) head = head.next;
        if (index == size - 1) tail = prev;
        size--;

        return curr.data;
    }

    @Override
    public T remove(T data) {
        boolean found = false;

        if (data == null) {
            throw new IllegalArgumentException("You cannot remove null data from the list");
        }

        Node<T> curr = head;
        Node<T> prev = null;

        while (curr.next != null) {
            if (curr.data.equals(data)) {
                found = true;
                break;
            }

            prev = curr;
            curr = curr.next;
        }

        if (!found) throw new NoSuchElementException("The data is not present in the list.");

        prev.next = curr.next;

        if (head.data.equals(data)) head = head.next;
        if (tail.data.equals(data)) tail = prev;
        size--;

        return curr.data;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return (head == null);
    }

    @Override
    public int size() {
        return size;
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }
}
