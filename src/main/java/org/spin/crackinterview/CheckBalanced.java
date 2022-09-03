package org.spin.crackinterview;

import org.spin.crackinterview.util.TreeNode;

public class CheckBalanced {
    public static void main(String[] args) {
        TreeNode<String> root = new TreeNode<>("1");
        root.left = new TreeNode<>("11");
        root.right = new TreeNode<>("12");
        root.left.left = new TreeNode<>("111");
        root.left.right = new TreeNode<>("112");
        root.right.left = new TreeNode<>("121");
        root.right.right = new TreeNode<>("122");
        CheckBalanced cb = new CheckBalanced();
//        System.out.println(cb.getHeight(root));
        System.out.println(cb.isBalanced2(root));
    }

    int getHeight(TreeNode root) {
//        System.out.println(root != null ? root.data : "NULL");
        if (root == null) return -1;
        int v = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
//        System.out.println("v="+v);
        return v;
    }

    boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        int heightDiff = getHeight(root.left) - getHeight(root.right);
        if (Math.abs(heightDiff) > 1) {
            return false;
        } else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    int checkHeight(TreeNode root) {
//        System.out.println(root!=null?root.data:"NULL");
        if (root == null) return -1;

        int leftHeight = checkHeight(root.left);
        if (leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int rightHeight = checkHeight(root.right);
        if (rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

//        System.out.println("leftHeight="+leftHeight+", rightHeight="+rightHeight);
        int heightDiff = leftHeight - rightHeight;
//        System.out.println("heightDiff="+heightDiff);
        if (Math.abs(heightDiff) > 1) {
            return Integer.MIN_VALUE;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    boolean isBalanced2(TreeNode root) {
        return checkHeight(root) != Integer.MIN_VALUE;
    }
}
