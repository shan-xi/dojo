package org.spin.crackinterview;

import com.sun.source.tree.Tree;
import org.spin.crackinterview.util.TreeNode;

public class ValidBST {
    public static void main(String[] args) {
        ValidBST vb = new ValidBST();

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        System.out.println(vb.checkBST2(root));
    }

    Integer last_printed = null;

    boolean checkBST(TreeNode<Integer> n) {
        if (n == null) return true;

        if (!checkBST(n.left)) {
            return false;
        }
        if (last_printed != null && n.data <= last_printed) {
            return false;
        }
        last_printed = n.data;

        if (!checkBST(n.right)) {
            return false;
        }

        return true;
    }

    boolean checkBST2(TreeNode<Integer> n) {
        return checkBST2(n, null, null);
    }

    boolean checkBST2(TreeNode<Integer> n, Integer min, Integer max) {
        if (n == null) {
            return true;
        }
        if ((min != null && n.data <= min) || (max != null && n.data > max)) {
            return false;
        }
        if (!checkBST2(n.left, min, n.data) || !checkBST2(n.right, n.data, max)) {
            return false;
        }
        return true;
    }
}
