package org.spin.crackinterview;

import org.spin.crackinterview.util.TreeNode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class BSTSequences {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode n1 = new TreeNode(9);
        TreeNode n2 = new TreeNode(11);
        TreeNode n11 = new TreeNode(8);
        root.addLeft(n1);
        root.addRight(n2);
        n1.addLeft(n11);
        BSTSequences b = new BSTSequences();
        ArrayList<LinkedList<Integer>> r = b.allSequences(root);
        for (LinkedList<Integer> a : r) {
            System.out.println(Arrays.toString(a.toArray()));
        }
    }

    ArrayList<LinkedList<Integer>> allSequences(TreeNode<Integer> node) {
        ArrayList<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();
        if (node == null) {
            result.add(new LinkedList<Integer>());
            return result;
        }

        LinkedList<Integer> prefix = new LinkedList<Integer>();
        prefix.add(node.data);
        ArrayList<LinkedList<Integer>> leftSeq = allSequences(node.left);
        ArrayList<LinkedList<Integer>> rightSeq = allSequences(node.right);

        for (LinkedList<Integer> left : leftSeq) {
            for (LinkedList<Integer> right : rightSeq) {
                ArrayList<LinkedList<Integer>> weaved = new ArrayList<LinkedList<Integer>>();
                weaveLists(left, right, weaved, prefix);

                result.addAll(weaved);
            }
        }
        return result;
    }

    void weaveLists(LinkedList<Integer> first, LinkedList<Integer> second, ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix) {
        if (first.size() == 0 || second.size() == 0) {
            LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
            result.addAll(first);
            result.addAll(second);
            results.add(result);
            return;
        }

        int headFirst = first.removeFirst();
        prefix.addLast(headFirst);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        first.addFirst(headFirst);


        int headSecond = second.removeFirst();
        prefix.addLast(headSecond);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        second.addFirst(headSecond);

    }
}
