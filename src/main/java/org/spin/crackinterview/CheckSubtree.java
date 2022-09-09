package org.spin.crackinterview;

import org.spin.crackinterview.util.TreeNode;

public class CheckSubtree {
    public static void main(String[] args) {
        CheckSubtree cs = new CheckSubtree();
        TreeNode t1 = new TreeNode("A");
        TreeNode t2 = new TreeNode("B");
        TreeNode t3 = new TreeNode("C");
        TreeNode t4 = new TreeNode("D");
        TreeNode t5 = new TreeNode("E");
        t1.addLeft(t2);
        t1.addRight(t3);
        t2.addLeft(t4);
        t2.addLeft(t5);

        System.out.println(cs.containsTree(t1, t2));
        System.out.println(cs.containsTree2(t1, t2));

    }

    boolean containsTree(TreeNode t1, TreeNode t2) {
        StringBuilder string1 = new StringBuilder();
        StringBuilder string2 = new StringBuilder();

        getOrderString(t1, string1);
        getOrderString(t2, string2);

        System.out.println(string1);
        System.out.println(string2);
        return string1.indexOf(string2.toString()) != -1;
    }

    void getOrderString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("X");
            return;
        }
        sb.append(node.data + " ");
        getOrderString(node.left, sb);
        getOrderString(node.right, sb);
    }

    boolean containsTree2(TreeNode t1, TreeNode t2) {
        if (t2 == null) return true;
        return subTree(t1, t2);
    }

    boolean subTree(TreeNode r1, TreeNode r2) {
        if (r1 == null) {
            return false;
        } else if (r1.data == r2.data && matchTree(r1, r2)) {
            return true;
        }
        return subTree(r1.left, r2) || subTree(r1.right, r2);
    }

    boolean matchTree(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) {
            return true;
        } else if (r1 == null || r2 == null) {
            return false;
        } else if (r1.data != r2.data) {
            return false;
        } else {
            return matchTree(r1.left, r2.left) && matchTree(r1.right, r2.right);
        }
    }
}
