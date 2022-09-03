package org.spin.crackinterview;

import org.spin.crackinterview.util.TreeNode;

public class MinimalTree {
    public static void main(String[] args) {
        MinimalTree mt = new MinimalTree();
        int [] arr = new int[]{1,3,4,6,7,8,10,13,14};
        TreeNode<Integer> root = mt.createMinimalBST(arr);
        System.out.println(root.data);
        System.out.println(root.left.data);
        System.out.println(root.left.left.data);
        System.out.println(root.left.right.data);
    }
    TreeNode<Integer> createMinimalBST(int array[]) {
        return createMinimalBST(array, 0, array.length - 1);
    }

    TreeNode<Integer> createMinimalBST(int arr[], int start, int end) {
        if (end < start) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode<Integer> n = new TreeNode(arr[mid]);
        n.left = createMinimalBST(arr, start, mid - 1);
        n.right = createMinimalBST(arr, mid + 1, end);
        return n;
    }
}
