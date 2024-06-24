package edu.gatech.cs1332.x2.mod5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BSTTest<T extends Comparable<? super T>> {

//    @BeforeEach
//    void setUp() throws ClassCastException {
//
//    }

    @Test
    void add() {
        BST<Integer> bst = new BST<>();

        bst.add(2);
        bst.add(1);
        bst.add(4);
        bst.add(3);
        bst.add(5);

        List<Integer> list = (List<Integer>) preorder((BSTNode<T>) bst.getRoot());
        System.out.println(list);
        Assertions.assertEquals(list, List.of(2, 1, 4, 3, 5));
    }

    @Test
    void remove() {
        BST<Integer> bst = new BST<>();

        bst.add(2);
        bst.add(1);
        bst.add(4);
        bst.add(3);
        bst.add(5);
        bst.remove(2);

        List<Integer> list = (List<Integer>) preorder((BSTNode<T>) bst.getRoot());
        System.out.println(list);
        Assertions.assertEquals(list, List.of(3, 1, 4, 5));
    }

    public List<T> preorder(BSTNode<T> root) {
        List<T> list = new LinkedList<>();
        preorderHelper(root, list);

        return list;
    }

    private void preorderHelper(BSTNode<T> node, List<T> list) {
        if (node == null) return;

        list.add(node.getData());
        preorderHelper(node.getLeft(), list);
        preorderHelper(node.getRight(), list);
    }
}