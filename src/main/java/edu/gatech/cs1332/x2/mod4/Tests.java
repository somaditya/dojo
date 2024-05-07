package edu.gatech.cs1332.x2.mod4;

import java.util.List;

public class Tests {
    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(50);
        root.setLeft(new TreeNode<>(25));
        root.setRight(new TreeNode<>(100));

        root.getLeft().setLeft(new TreeNode<>(10));
        root.getRight().setLeft(new TreeNode<>(75));
        root.getRight().setRight(new TreeNode<>(125));
        root.getRight().getRight().setLeft(new TreeNode<>(110));

        Traversals<Integer> t = new Traversals<>();
        List<Integer> pre = t.preorder(root);
        List<Integer> post = t.postorder(root);
        List<Integer> in = t.inorder(root);

        System.out.println(pre.toString());
        System.out.println(in.toString());
        System.out.println(post.toString());
    }
}
