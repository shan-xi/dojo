package org.spin.eduactive.levelordertraversalofbinarytree;

//https://www.educative.io/m/level-order-traversal-binary-tree

import org.spin.eduactive.common.BinaryTree;
import org.spin.eduactive.common.BinaryTreeNode;
import org.spin.eduactive.common.LinkedList;
import org.spin.eduactive.common.LinkedListNode;

import java.util.*;


class Solution {
    public static void level_order_traversal(BinaryTreeNode root) {
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

    public static void main(String[] args) {
        List<Integer> input = new ArrayList<Integer>();
        input.add(100);
        input.add(50);
        input.add(200);
        input.add(25);
        input.add(75);
        input.add(350);
        BinaryTreeNode root = BinaryTree.create_BST(input);
        level_order_traversal(root);
        System.out.println();
    }
}