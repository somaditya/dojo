package edu.gatech.cs1332.x3.mod8.part2;

import java.util.NoSuchElementException;

/**
 * Your implementation of an AVL.
 */
public class AVL<T extends Comparable<? super T>> {

    private AVLNode<T> root;
    private int size;

    /**
     * Adds the element to the tree.
     * @param data The data to add.
     * @throws IllegalArgumentException If data is null.
     */
    public void add(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null");
        }
        root = addHelper(root, data);
    }

    private AVLNode<T> addHelper(AVLNode<T> node, T data) {
        if (node == null) {
            size++;
            return new AVLNode<>(data);
        }

        int compareResult = data.compareTo(node.getData());
        if (compareResult < 0) {
            node.setLeft(addHelper(node.getLeft(), data));
        } else if (compareResult > 0) {
            node.setRight(addHelper(node.getRight(), data));
        } else {
            return node; // Duplicate, no action
        }

        return balance(node);
    }

    /**
     * Removes and returns the element from the tree matching the given parameter.
     * @param data The data to remove.
     * @return The data that was removed.
     * @throws IllegalArgumentException If the data is null.
     * @throws NoSuchElementException If the data is not found.
     */
    public T remove(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null");
        }
        AVLNode<T> dummy = new AVLNode<>(null);
        root = removeHelper(root, data, dummy);
        if (dummy.getData() == null) {
            throw new NoSuchElementException("Data not found in the tree");
        }
        size--;
        return dummy.getData();
    }

    private AVLNode<T> removeHelper(AVLNode<T> node, T data, AVLNode<T> dummy) {
        if (node == null) {
            return null;
        }

        int compareResult = data.compareTo(node.getData());
        if (compareResult < 0) {
            node.setLeft(removeHelper(node.getLeft(), data, dummy));
        } else if (compareResult > 0) {
            node.setRight(removeHelper(node.getRight(), data, dummy));
        } else {
            dummy.setData(node.getData());
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            } else {
                node.setData(getMin(node.getRight()));
                node.setRight(removeHelper(node.getRight(), node.getData(), new AVLNode<>(null)));
            }
        }

        return balance(node);
    }

    private T getMin(AVLNode<T> node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node.getData();
    }

    /**
     * Updates the height and balance factor of a node.
     * @param node The node to update the height and balance factor of.
     */
    private void updateHeightAndBF(AVLNode<T> node) {
        int leftHeight = (node.getLeft() == null) ? -1 : node.getLeft().getHeight();
        int rightHeight = (node.getRight() == null) ? -1 : node.getRight().getHeight();

        node.setHeight(Math.max(leftHeight, rightHeight) + 1);
        node.setBalanceFactor(leftHeight - rightHeight);
    }

    /**
     * Performs a left rotation.
     * @param currentNode The node to rotate.
     * @return The new root of the subtree.
     */
    private AVLNode<T> rotateLeft(AVLNode<T> currentNode) {
        AVLNode<T> rightChild = currentNode.getRight();
        currentNode.setRight(rightChild.getLeft());
        rightChild.setLeft(currentNode);

        updateHeightAndBF(currentNode);
        updateHeightAndBF(rightChild);

        return rightChild;
    }

    /**
     * Performs a right rotation.
     * @param currentNode The node to rotate.
     * @return The new root of the subtree.
     */
    private AVLNode<T> rotateRight(AVLNode<T> currentNode) {
        AVLNode<T> leftChild = currentNode.getLeft();
        currentNode.setLeft(leftChild.getRight());
        leftChild.setRight(currentNode);

        updateHeightAndBF(currentNode);
        updateHeightAndBF(leftChild);

        return leftChild;
    }

    /**
     * Balances the tree.
     * @param node The node to balance.
     * @return The balanced node.
     */
    private AVLNode<T> balance(AVLNode<T> node) {
        if (node == null) {
            return null;
        }

        updateHeightAndBF(node);

        if (node.getBalanceFactor() > 1) {
            if (node.getLeft().getBalanceFactor() < 0) {
                node.setLeft(rotateLeft(node.getLeft()));
            }
            return rotateRight(node);
        }
        if (node.getBalanceFactor() < -1) {
            if (node.getRight().getBalanceFactor() > 0) {
                node.setRight(rotateRight(node.getRight()));
            }
            return rotateLeft(node);
        }

        return node;
    }

    /**
     * Returns the root of the tree.
     * @return The root of the tree.
     */
    public AVLNode<T> getRoot() {
        return root;
    }

    /**
     * Returns the size of the tree.
     * @return The size of the tree.
     */
    public int size() {
        return size;
    }

    /**
     * Verifies that the tree is a valid AVL tree.
     * @return true if the tree is a valid AVL tree, false otherwise.
     */
    private boolean isValidAVL() {
        return isValidAVLHelper(root);
    }

    private boolean isValidAVLHelper(AVLNode<T> node) {
        if (node == null) {
            return true;
        }

        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) > 1) {
            return false;
        }

        return isValidAVLHelper(node.getLeft()) && isValidAVLHelper(node.getRight());
    }

    private int getBalanceFactor(AVLNode<T> node) {
        int leftHeight = (node.getLeft() == null) ? -1 : node.getLeft().getHeight();
        int rightHeight = (node.getRight() == null) ? -1 : node.getRight().getHeight();
        return leftHeight - rightHeight;
    }
}