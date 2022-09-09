package org.spin.crackinterview;

import org.spin.crackinterview.util.TreeNode;
import org.spin.crackinterview.util.TreeNodeInt;

public class RandomNode {
    public static void main(String[] args) {
        TreeNodeInt n1 = new TreeNodeInt(10);
        n1.insertInOrder(8);
        n1.insertInOrder(11);
        n1.insertInOrder(7);
        System.out.println(n1.getRandomNode().data);
        System.out.println(n1.find(8).data);
    }
}
