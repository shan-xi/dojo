package org.spin.crackinterview.util;

public class TreeNode<T> {
    public T data;
    public TreeNode<T> left;
    public TreeNode<T> right;
    public TreeNode<T> parent;
    public TreeNode(T d){
        data = d;
    }
}
