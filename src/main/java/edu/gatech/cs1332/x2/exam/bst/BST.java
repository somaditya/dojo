package edu.gatech.cs1332.x2.exam.bst;

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
     * Returns the data from the tree matching the given parameter.
     * <p>
     * This should be done recursively.
     * <p>
     * Do not return the same data that was passed in. Return the data that
     * was stored in the tree.
     * <p>
     * Hint: Should you use value equality or reference equality?
     * <p>
     * Must be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data The data to search for. You may assume data is never null.
     * @return The data in the tree equal to the parameter.
     * @throws java.util.NoSuchElementException If the data is not in the tree.
     */
    public T get(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        return findRecurse(data, root);
    }

    private T findRecurse(T data, BSTNode<T> node) {
        if (node.getData().compareTo(data) > 0) {
            return findRecurse(data, node.getLeft());
        } else if (node.getData().compareTo(data) < 0) {
            return findRecurse(data, node.getRight());
        }

        return node.getData();
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
     * 3: The node containing the data has 2 children. Use the PREDECESSOR to
     * replace the data. You should use recursion to find and remove the
     * predecessor (you will likely need an additional helper method to
     * handle this case efficiently).
     * <p>
     * Do NOT return the same data that was passed in. Return the data that
     * was stored in the tree.
     * <p>
     * Hint: Should you use value equality or reference equality?
     * <p>
     * Must be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data The data to remove. You may assume that data is never null.
     * @return The data that was removed.
     * @throws java.util.NoSuchElementException If the data is not in the tree.
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
                node.setRight(removePredecessor(node.getRight(), dummy2));
                node.setData(dummy2.getData());
            }
        }

        return node;
    }

    private BSTNode<T> removePredecessor(BSTNode<T> node, BSTNode<T> dummy2) {
        if (node.getRight() == null) {
            dummy2.setData(node.getData());
            return node.getLeft();
        } else {
            node.setRight(removePredecessor(node.getRight(), dummy2));
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