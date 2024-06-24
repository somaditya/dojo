package edu.gatech.cs1332.x2.mod5;

import java.util.NoSuchElementException;

/**
 * Your implementation of a BST.
 */
public class BST<T extends Comparable<? super T>> {

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private BSTNode<T> root;
    private int size;

    /*
     * Do not add a constructor.
     */

    /**
     * Adds the data to the tree.
     * <p>
     * This must be done recursively.
     * <p>
     * The new data should become a leaf in the tree.
     * <p>
     * Traverse the tree to find the appropriate location. If the data is
     * already in the tree, then nothing should be done (the duplicate
     * shouldn't get added, and size should not be incremented).
     * <p>
     * Should be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data The data to add to the tree.
     * @throws java.lang.IllegalArgumentException If data is null.
     */
    public void add(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (data == null) throw new IllegalArgumentException();

        root = addRecurse(data, root);
    }

    private BSTNode<T> addRecurse(T data, BSTNode<T> node) {
        if (node == null) {
            size++;
            return new BSTNode<>(data);
        } else if (data.compareTo(node.getData()) < 0) {
            node.setLeft(addRecurse(data, node.getLeft()));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRight(addRecurse(data, node.getRight()));
        }

        return node;
    }

    /**
     * Removes and returns the data from the tree matching the given parameter.
     * <p>
     * This must be done recursively.
     * <p>
     * There are 3 cases to consider:
     * 1: The node containing the data is a leaf (no children). In this case,
     * simply remove it.
     * 2: The node containing the data has one child. In this case, simply
     * replace it with its child.
     * 3: The node containing the data has 2 children. Use the SUCCESSOR to
     * replace the data. You should use recursion to find and remove the
     * successor (you will likely need an additional helper method to
     * handle this case efficiently).
     * <p>
     * Do NOT return the same data that was passed in. Return the data that
     * was stored in the tree.
     * <p>
     * Hint: Should you use value equality or reference equality?
     * <p>
     * Must be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data The data to remove.
     * @return The data that was removed.
     * @throws java.lang.IllegalArgumentException If data is null.
     * @throws java.util.NoSuchElementException   If the data is not in the tree.
     */
    public T remove(T data) {
        if (data == null) throw new IllegalArgumentException();
        BSTNode<T> dummy = new BSTNode<>(null);
        root = removeRecurse(data, root, dummy);

        return dummy.getData();
    }

    private BSTNode<T> removeRecurse(T data, BSTNode<T> node, BSTNode<T> dummy) {
        if (node == null) {
            throw new NoSuchElementException();
        } else if (data.compareTo(node.getData()) < 0) {
            node.setLeft(removeRecurse(data, node.getLeft(), dummy));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRight(removeRecurse(data, node.getRight(), dummy));
        } else {
            size--;

            dummy.setData(node.getData());

            if (node.getLeft() == null && node.getRight() == null) {
                throw new NoSuchElementException();
            } else if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            } else {
                BSTNode<T> dummy2 = new BSTNode<>(null);
                node.setRight(removeSuccessor(node.getRight(), dummy2));
                node.setData(dummy2.getData());
            }
        }

        return node;
    }

    private BSTNode<T> removeSuccessor(BSTNode<T> node, BSTNode<T> dummy2) {
        if (node.getLeft() == null) {
            dummy2.setData(node.getData());
            return node.getRight();
        } else {
            node.setLeft(removeSuccessor(node.getLeft(), dummy2));
            return node;
        }
    }

    /**
     * Returns the root of the tree.
     * <p>
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The root of the tree
     */
    public BSTNode<T> getRoot() {
        // DO NOT MODIFY THIS METHOD!
        return root;
    }

    /**
     * Returns the size of the tree.
     * <p>
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The size of the tree
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}