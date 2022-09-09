package org.spin.crackinterview.util;

import java.util.Objects;
import java.util.Random;

public class TreeNode<T> {
    public T data;
    public TreeNode<T> left;
    public TreeNode<T> right;
    public TreeNode<T> parent;
    private int size = 0;

    public TreeNode(T d) {
        data = d;
        size = 1;
    }

    public void addLeft(TreeNode node) {
        this.left = node;
        node.parent = this;
    }

    public void addRight(TreeNode node) {
        this.right = node;
        node.parent = this;
    }

    public int size() {
        return size;
    }

}


