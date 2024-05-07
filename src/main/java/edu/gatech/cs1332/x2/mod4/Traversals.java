package edu.gatech.cs1332.x2.mod4;

import java.util.List;
import java.util.LinkedList;

/**
 * Your implementation of the pre-order, in-order, and post-order
 * traversals of a tree.
 */
public class Traversals<T extends Comparable<? super T>> {

    /**
     * DO NOT ADD ANY GLOBAL VARIABLES!
     */

    /**
     * Given the root of a binary search tree, generate a
     * pre-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the pre-order traversal of the tree.
     */
    public List<T> preorder(TreeNode<T> root) {
        if (root != null) {
            List<T> list = new LinkedList<>();
            preorderHelper(root, list);

            return list;
        }

        return null;
    }

    /**
     * Given the root of a binary search tree, generate an
     * in-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the in-order traversal of the tree.
     */
    public List<T> inorder(TreeNode<T> root) {
        if (root != null) {
            List<T> list = new LinkedList<>();
            inorderHelper(root, list);

            return list;
        }

        return null;
    }

    /**
     * Given the root of a binary search tree, generate a
     * post-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the post-order traversal of the tree.
     */
    public List<T> postorder(TreeNode<T> root) {
        if (root != null) {
            List<T> list = new LinkedList<>();
            postorderHelper(root, list);

            return list;
        }

        return null;
    }

    private void preorderHelper(TreeNode<T> node, List<T> list) {
        if (node == null) return;

        list.add(node.getData());
        preorderHelper(node.getLeft(), list);
        preorderHelper(node.getRight(), list);
    }

    private void inorderHelper(TreeNode<T> node, List<T> list) {
        if (node == null) return;

        inorderHelper(node.getLeft(), list);
        list.add(node.getData());
        inorderHelper(node.getRight(), list);
    }

    private void postorderHelper(TreeNode<T> node, List<T> list) {
        if (node == null) return;

        postorderHelper(node.getLeft(), list);
        postorderHelper(node.getRight(), list);
        list.add(node.getData());
    }
}