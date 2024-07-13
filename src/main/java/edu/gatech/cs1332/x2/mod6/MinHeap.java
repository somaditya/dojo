package edu.gatech.cs1332.x2.mod6;

import java.util.NoSuchElementException;

/**
 * Your implementation of a MinHeap.
 */
@SuppressWarnings("ALL")
public class MinHeap<T extends Comparable<? super T>> {

    /**
     * The initial capacity of the MinHeap.
     * <p>
     * DO NOT MODIFY THIS VARIABLE!
     */
    public static final int INITIAL_CAPACITY = 13;

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private T[] backingArray;
    private int size;

    /**
     * This is the constructor that constructs a new MinHeap.
     * <p>
     * Recall that Java does not allow for regular generic array creation,
     * so instead we cast a Comparable[] to a T[] to get the generic typing.
     */
    public MinHeap() {
        //DO NOT MODIFY THIS METHOD!
        backingArray = (T[]) new Comparable[INITIAL_CAPACITY];
    }

    /**
     * Adds an item to the heap. If the backing array is full (except for
     * index 0) and you're trying to add a new item, then double its capacity.
     * <p>
     * Method should run in amortized O(log n) time.
     *
     * @param data The data to add.
     * @throws java.lang.IllegalArgumentException If the data is null.
     */
    public void add(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (data == null) throw new IllegalArgumentException();

        int index = ++size;

        if (size >= backingArray.length) {
            T[] newBackingArray = (T[]) new Comparable[backingArray.length * 2];

            for (int i = 0; i < backingArray.length; i++) {
                newBackingArray[i] = backingArray[i];
            }

            backingArray = newBackingArray;
        }

        backingArray[index] = data;
        int parent = index / 2;

        upHeap(parent, index);
    }

    private void upHeap(int parent, int index) {
        if (parent < 1 || backingArray[index].compareTo(backingArray[parent]) > 0) {
            return;
        }

        swap(parent, index);
        index = parent;
        parent = index / 2;

        upHeap(parent, index);
    }
    private void swap(int i, int j) {
        T temp = backingArray[i];
        backingArray[i] = backingArray[j];
        backingArray[j] = temp;
    }

    /**
     * Removes and returns the min item of the heap. As usual for array-backed
     * structures, be sure to null out spots as you remove. Do not decrease the
     * capacity of the backing array.
     * <p>
     * Method should run in O(log n) time.
     *
     * @return The data that was removed.
     * @throws java.util.NoSuchElementException If the heap is empty.
     */
    public T remove() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (size == 0) throw new NoSuchElementException();

        int index = size--;
        T data = backingArray[1];
        backingArray[1] = backingArray[index];
        backingArray[index] = null;

        downHeap(1);

        return data;
    }

    private void downHeap(int startIndex) {
        if (!hasLeftChild(startIndex)) return;

        if (hasLeftChild(startIndex) && !hasRightChild(startIndex)) {
            int leftChildIndex = leftChildIndex(startIndex);
            T leftChild = backingArray[leftChildIndex];

            if (backingArray[startIndex].compareTo(leftChild) < 0) return;

            swap(startIndex, leftChildIndex);
            downHeap(leftChildIndex);
        } else {
            T leftChild = backingArray[leftChildIndex(startIndex)];
            T rightChild = backingArray[rightChildIndex(startIndex)];

            T smaller;
            int smallerIndex;

            if (leftChild.compareTo(rightChild) < 0) {
                smaller = leftChild;
                smallerIndex = startIndex * 2;
            } else {
                smaller = rightChild;
                smallerIndex = (startIndex * 2) + 1;
            }

            if (backingArray[startIndex].compareTo(smaller) < 0) {
                return;
            } else {
                swap(startIndex, smallerIndex);
                downHeap(smallerIndex);
            }
        }
    }

    private boolean hasLeftChild(int index) {
        return size >= index * 2;
    }

    private boolean hasRightChild(int index) {
        return size >= (index * 2) + 1;
    }

    private int leftChildIndex(int index) {
        return index * 2;
    }

    private int rightChildIndex(int index) {
        return (index * 2) + 1;
    }

    /**
     * Returns the backing array of the heap.
     * <p>
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The backing array of the list
     */
    public T[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
    }

    /**
     * Returns the size of the heap.
     * <p>
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The size of the list
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}