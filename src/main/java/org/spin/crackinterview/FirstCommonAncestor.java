package org.spin.crackinterview;

import org.spin.crackinterview.util.TreeNode;

public class FirstCommonAncestor {
    public static void main(String[] args) {
        TreeNode a = new TreeNode<>(20);
        TreeNode b = new TreeNode(10);
        TreeNode c = new TreeNode(30);
        TreeNode d = new TreeNode(5);
        TreeNode e = new TreeNode(15);
        TreeNode f = new TreeNode(3);
        TreeNode g = new TreeNode(7);
        TreeNode h = new TreeNode(17);
        a.left = b;
        b.parent = a;
        a.right = c;
        c.parent = a;
        b.left = d;
        d.parent = b;
        d.left = f;
        f.parent = d;
        d.right = g;
        g.parent = d;
        b.right = e;
        e.parent = b;
        e.right = h;
        h.parent = e;

        FirstCommonAncestor fc = new FirstCommonAncestor();
        TreeNode r1 = fc.commonAncestor(g, h);
        System.out.println(r1.data);
        TreeNode r2 = fc.commonAncestor(a, g, h);
        System.out.println(r2.data);
        TreeNode r3 = fc.commonAncestor2(a, g, h);
        System.out.println(r3.data);

    }

    TreeNode commonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (!covers(root, p) || !covers(root, q)) {
            return null;
        }
        return ancestorHelper(root, p, q);
    }

    TreeNode ancestorHelper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        boolean pIsOnLeft = covers(root.left, p);
        boolean qIsOnLeft = covers(root.left, q);
        if (pIsOnLeft != qIsOnLeft) {
            return root;
        }
        TreeNode childSide = pIsOnLeft ? root.left : root.right;
        return ancestorHelper(childSide, p, q);
    }

    TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (!covers(root, p) || !covers(root, q)) {
            return null;
        } else if (covers(p, q)) {
            return p;
        } else if (covers(q, p)) {
            return q;
        }

        TreeNode sibling = getSibling(p);
        TreeNode parent = p.parent;
        while (!covers(sibling, q)) {
            sibling = getSibling(parent);
            parent = parent.parent;
        }
        return parent;
    }

    boolean covers(TreeNode root, TreeNode p) {
        if (root == null) return false;
        if (root == p) return true;
        return covers(root.left, p) || covers(root.right, p);
    }

    TreeNode getSibling(TreeNode node) {
        if (node == null || node.parent == null) {
            return null;
        }
        TreeNode parent = node.parent;
        return parent.left == node ? parent.right : parent.left;
    }

    TreeNode commonAncestor(TreeNode p, TreeNode q) {
        int delta = depth(p) - depth(q);
        TreeNode first = delta > 0 ? q : p;
        TreeNode second = delta > 0 ? p : q;
        second = goUpBy(second, Math.abs(delta));

        while (first != second && first != null && second != null) {
            first = first.parent;
            second = second.parent;
        }
        return first == null || second == null ? null : first;
    }

    TreeNode goUpBy(TreeNode node, int delta) {
        while (delta > 0 && node != null) {
            node = node.parent;
            delta--;
        }
        return node;
    }

    int depth(TreeNode node) {
        int depth = 0;
        while (node != null) {
            node = node.parent;
            depth++;
        }
        return depth;
    }
}
