package edu.gatech.cs1331.hw07;

public class LinkedList<T> implements List<T> {
    Node<T> head;
    Node<T> tail;
    int size;

    @Override
    public void addAtIndex(Object data, int index) {

    }

    @Override
    public T getAtIndex(int index) {
        if (index >= size) {
            return null;
        }

        Node<T> node = head;

        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node.data;
    }

    @Override
    public T removeAtIndex(int index) {
        if (index >= size) {
            return null;
        }

        Node<T> node = head;
        int i = 0;

        while (i < index) {
            node = node.next;
            i++;
        }

        Node<T> removed = node;

        node.next = node.next.next;
        return removed.data;
    }

    @Override
    public T remove(Object data) {
        Node<T> node = head;

        while (node.next != null && !(node.data.equals(data))) {
            node = node.next;
        }

        Node<T> removed = node;
        removed.next = null;

        node.next = node.next.next;
        return removed.data;
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
