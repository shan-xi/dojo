package org.spin.crackinterview;

import org.spin.crackinterview.util.TreeNode;

public class Successor {
    public static void main(String[] args) {
        Successor s = new Successor();
        TreeNode<Integer> n = new TreeNode<>(20);
        n.right = new TreeNode<>(22);
        n.right.parent = n;
        n.right.left = new TreeNode<>(21);
        n.right.left.parent = n.right;
        n.left = new TreeNode<>(8);
        n.left.parent = n;
        n.left.right = new TreeNode<>(12);
        n.left.right.parent = n.left;
        n.left.right.left = new TreeNode<>(10);
        n.left.right.left.parent = n.left.right;
        n.left.right.right = new TreeNode<>(14);
        n.left.right.right.parent = n.left.right;
        n.left.left = new TreeNode<>(4);
        n.left.left.parent = n.left;

        System.out.println(s.inorderSucc(n.right.left).data);
    }
    TreeNode<Integer> inorderSucc(TreeNode<Integer> n) {
        if (n == null) return null;

        if (n.right != null) {
            return leftMostChild(n.right);
        } else {
            TreeNode<Integer> q = n;
            TreeNode<Integer> x = q.parent;
            while (x != null && x.left != q) {
                q = x;
                x = x.parent;
            }
            return x;
        }
    }

    TreeNode<Integer> leftMostChild(TreeNode<Integer> n) {
        if (n == null) {
            return null;
        }
        while (n.left != null) {
            n = n.left;
        }
        return n;
    }
}
