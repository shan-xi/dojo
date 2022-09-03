package org.spin.eduactive.isbinarytreeabinarysearchtree;

//https://www.educative.io/m/is-binary-tree-a-binary-search-tree

import org.spin.eduactive.common.BinaryTree;
import org.spin.eduactive.common.BinaryTreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;


class Solution {
    public static boolean is_bst(BinaryTreeNode root) {
        //TODO: Write - Your - Code
        return false;
    }

    public static void main(String[] args) {
        BinaryTreeNode root = BinaryTree.create_random_BST(5,100);
        BinaryTree.display_level_order(root);
        System.out.println();
        System.out.println("Is it BST?: " + Boolean.toString(is_bst(root)));

        BinaryTreeNode root2 = BinaryTree.create_binary_tree(5);
        System.out.println();
        BinaryTree.display_level_order(root2);
        System.out.println("Is it BST?: " + Boolean.toString(is_bst(root2)));
    }
}