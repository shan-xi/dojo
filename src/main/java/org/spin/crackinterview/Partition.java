package org.spin.crackinterview;

public class Partition {
    public static void main(String[] args) {
        LinkedListNode<Integer> n1 = new LinkedListNode<>(3);
        LinkedListNode<Integer> n2 = new LinkedListNode<>(5);
        LinkedListNode<Integer> n3 = new LinkedListNode<>(8);
        LinkedListNode<Integer> n4 = new LinkedListNode<>(6);
        LinkedListNode<Integer> n5 = new LinkedListNode<>(10);
        LinkedListNode<Integer> n6 = new LinkedListNode<>(2);
        LinkedListNode<Integer> n7 = new LinkedListNode<>(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        LinkedListNode head = partition2(n1, 5);
        LinkedListNode.printAllNodeData(head);
    }

    static LinkedListNode<Integer> partition2(LinkedListNode<Integer> node, int x) {
        LinkedListNode<Integer> head = node;
        LinkedListNode<Integer> tail = node;

        while (node != null) {
            LinkedListNode<Integer> next = node.next;
            if (node.data < x) {
                node.next = head;
                head = node;
            } else {
                tail.next = node;
                tail = node;
            }

            node = next;
        }
        tail.next = null;
        return head;
    }

    static LinkedListNode<Integer> partition(LinkedListNode<Integer> node, int x) {
        LinkedListNode<Integer> beforeStart = null;
        LinkedListNode<Integer> beforeEnd = null;
        LinkedListNode<Integer> afterStart = null;
        LinkedListNode<Integer> afterEnd = null;

        while (node != null) {
            LinkedListNode<Integer> next = node.next;
            node.next = null;
            if (node.data < x) {
                if (beforeStart == null) {
                    beforeStart = node;
                    beforeEnd = beforeStart;
                } else {
                    beforeEnd.next = node;
                    beforeEnd = node;
                }
            } else {
                if (afterStart == null) {
                    afterStart = node;
                    afterEnd = afterStart;
                } else {
                    afterEnd.next = node;
                    afterEnd = node;
                }
            }
            node = next;
        }
        if (beforeStart == null) {
            return afterStart;
        }
        beforeEnd.next = afterStart;
        return beforeStart;
    }
}
