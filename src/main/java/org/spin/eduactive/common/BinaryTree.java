package org.spin.eduactive.common;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

// https://www.softwaretestinghelp.com/binary-search-tree-in-java/
public class BinaryTree {
    public static BinaryTreeNode create_BST(List<Integer> input) {
        BST bst = new BST();
        for (int i : input) {
            bst.insert(i);
        }
        return bst.root;
    }

    public static void display_level_order(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        ArrayList<Queue<BinaryTreeNode>> queues = new ArrayList<Queue<BinaryTreeNode>>();

        queues.add(new ArrayDeque<BinaryTreeNode>());
        queues.add(new ArrayDeque<BinaryTreeNode>());

        Queue<BinaryTreeNode> current_queue = queues.get(0);
        Queue<BinaryTreeNode> next_queue = queues.get(1);

        current_queue.add(root);
        int level_number = 0;

        while (!current_queue.isEmpty()) {
            BinaryTreeNode temp = current_queue.poll();
            System.out.print(temp.data + ",");

            if (temp.left != null) {
                next_queue.add(temp.left);
            }

            if (temp.right != null) {
                next_queue.add(temp.right);
            }

            if (current_queue.isEmpty()) {
                System.out.println();
                ++level_number;
                current_queue = queues.get(level_number % 2);
                next_queue = queues.get((level_number + 1) % 2);
            }
        }
        System.out.println();
    }

    public static BinaryTreeNode create_random_BST(int from, int to){
        return null;
    }

    public static BinaryTreeNode create_binary_tree(int level){
        return null;
    }
}

class BST {
    BinaryTreeNode root;

    BST() {
        root = null;
    }

    void insert(int key) {
        root = insert_recursive(root, key);
    }

    BinaryTreeNode insert_recursive(BinaryTreeNode root, int data) {
        if (root == null) {
            root = new BinaryTreeNode(data);
            return root;
        }
        if (data < root.data) {
            root.left = insert_recursive(root.left, data);
        } else if (data > root.data) {
            root.right = insert_recursive(root.right, data);
        }
        return root;
    }

    void deleteKey(int key) {
        root = delete_recursive(root, key);
    }

    BinaryTreeNode delete_recursive(BinaryTreeNode root, int data) {
        if (root == null) {
            return null;
        }
        if (data < root.data) {
            root.left = delete_recursive(root.left, data);
        } else if (data > root.data) {
            root.right = delete_recursive(root.right, data);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.data = minValue(root.right);
            root.right = delete_recursive(root.right, root.data);
        }
        return root;
    }

    int minValue(BinaryTreeNode node) {
        int minval = root.data;
        while (root.left != null) {
            minval = root.left.data;
            root = root.left;
        }
        return minval;
    }

    void inorder() {
        inorder_recursive(root);
    }

    void inorder_recursive(BinaryTreeNode root) {
        if (root != null) {
            inorder_recursive(root.left);
            System.out.println(root.data + " ");
            inorder_recursive(root.right);
        }
    }

    boolean search(int data) {
        root = search_recursive(root, data);
        if (root != null) {
            return true;
        } else {
            return false;
        }
    }

    BinaryTreeNode search_recursive(BinaryTreeNode root, int data) {
        if (root == null || root.data == data) {
            return root;
        }
        if (root.data > data) {
            return search_recursive(root.left, data);
        }
        return search_recursive(root.right, data);
    }

    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(45);
        bst.insert(10);
        bst.insert(7);
        bst.insert(12);
        bst.insert(90);
        bst.insert(50);
        System.out.println("The BST Created with input data(Left-root-right):");
        bst.inorder();

        System.out.println("\nThe BST after Delete 12(leaf node):");
        bst.deleteKey(12);
        bst.inorder();

        //delete node with two children
        System.out.println("\nThe BST after Delete 45 (Node with two children):");
        bst.deleteKey(45);
        bst.inorder();
        //search a key in the BST
        boolean ret_val = bst.search(50);
        System.out.println("\nKey 50 found in BST:" + ret_val);
        ret_val = bst.search(12);
        System.out.println("\nKey 12 found in BST:" + ret_val);
    }
}
