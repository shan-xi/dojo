package org.spin.crackinterview;

public class ReturnKthToLast {
    public static void main(String[] args) {
        LinkedListNode n1 = new LinkedListNode(1);
        LinkedListNode n2 = new LinkedListNode(2);
        LinkedListNode n3 = new LinkedListNode(3);
        LinkedListNode n4 = new LinkedListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
//        LinkedListNode r = nthTolast(n1, 3);
//        System.out.println(r.data);

        printKthToLast(n1, 3);
        LinkedListNode r = kthToLast(n1, 3);
        System.out.println(r.data);

    }

    static LinkedListNode<Integer> nthTolast(LinkedListNode<Integer> head, int k) {
        LinkedListNode<Integer> p1 = head;
        LinkedListNode<Integer> p2 = head;

        for (int i = 0; i < k; i++) {
            if (p1 == null) return null;
            p1 = p1.next;
        }
        System.out.println(p1.data);

        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    static int printKthToLast(LinkedListNode<Integer> head, int k) {
        if (head == null) {
            return 0;
        }
        int index = printKthToLast(head.next, k) + 1;
        if (index == k) {
            System.out.println(k + "th to last node is " + head.data);
        }
        return index;
    }

    static class Index {
        public int value = 0;
    }

    static LinkedListNode<Integer> kthToLast(LinkedListNode<Integer> head, int k) {
        Index idx = new Index();
        return kthToLast(head, k, idx);
    }

    static LinkedListNode<Integer> kthToLast(LinkedListNode<Integer> head, int k, Index idx) {
        if (head == null) {
            return null;
        }
        LinkedListNode<Integer> node = kthToLast(head.next, k, idx);
        idx.value = idx.value + 1;
        if (idx.value == k) {
            return head;
        }
        return node;
    }
}
