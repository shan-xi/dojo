package org.spin.crackinterview;

public class SumList {
    public static void main(String[] args) {
        LinkedListNode<Integer> n1 = new LinkedListNode<>(6);
        LinkedListNode<Integer> n2 = new LinkedListNode<>(1);
        LinkedListNode<Integer> n3 = new LinkedListNode<>(7);
        n2.setNext(n3);
        n1.setNext(n2);

        LinkedListNode<Integer> n4 = new LinkedListNode<>(2);
        LinkedListNode<Integer> n5 = new LinkedListNode<>(9);
        LinkedListNode<Integer> n6 = new LinkedListNode<>(5);
        n5.setNext(n6);
        n4.setNext(n5);

//        LinkedListNode<Integer> r = addLists(n1, n4, 0);
        LinkedListNode<Integer> r = addLists2(n1, n4);
        LinkedListNode.printAllNodeData(r);
    }

    static LinkedListNode<Integer> addLists(LinkedListNode<Integer> l1, LinkedListNode<Integer> l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }
        LinkedListNode<Integer> result = new LinkedListNode<>();
        int value = carry;
        if (l1 != null) {
            value += l1.data;
        }
        if (l2 != null) {
            value += l2.data;
        }
        result.data = value % 10;
        if (l1 != null || l2 != null) {
            LinkedListNode<Integer> more = addLists(l1 == null ? null : l1.next, l2 == null ? null : l2.next, value >= 10 ? 1 : 0);
            result.setNext(more);
        }
        return result;
    }

    static class PartialSum {
        public LinkedListNode<Integer> sum = null;
        public int carry = 0;
    }

    static LinkedListNode<Integer> addLists2(LinkedListNode<Integer> l1, LinkedListNode<Integer> l2) {
        int len1 = LinkedListNode.length(l1);
        int len2 = LinkedListNode.length(l2);

        if (len1 < len2) {
            l1 = padList(l1, len2 - len1);
        } else {
            l2 = padList(l2, len1 - len2);
        }

        PartialSum sum = addListsHelper(l1, l2);

        if (sum.carry == 0) {
            return sum.sum;
        } else {
            return insertBefore(sum.sum, sum.carry);
        }
    }

    static PartialSum addListsHelper(LinkedListNode<Integer> l1, LinkedListNode<Integer> l2) {
        if (l1 == null && l2 == null) {
            return new PartialSum();
        }

        PartialSum sum = addListsHelper(l1.next, l2.next);

        int val = sum.carry + l1.data + l2.data;

        sum.sum = insertBefore(sum.sum, val % 10);
        sum.carry = val / 10;
        return sum;
    }

    static LinkedListNode<Integer> padList(LinkedListNode<Integer> l, int padding) {
        LinkedListNode<Integer> head = l;
        for (int i = 0; i < padding; i++) {
            head = insertBefore(head, 0);
        }
        return head;
    }

    static LinkedListNode<Integer> insertBefore(LinkedListNode<Integer> list, int data) {
        LinkedListNode<Integer> node = new LinkedListNode<>(data);
        if (list != null) {
            node.next = list;
        }
        return node;
    }
}
