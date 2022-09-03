package org.spin.crackinterview;

import java.util.HashSet;

public class RemoveDups {
    public static void main(String[] args) {
        LinkedListNode<Integer> n1 = new LinkedListNode<>(1);
        LinkedListNode<Integer> n2 = new LinkedListNode<>(3);
        n1.next = n2;
        LinkedListNode<Integer> n3 = new LinkedListNode<>(3);
        n2.next = n3;
        n3.next = null;
        LinkedListNode.printAllNodeData(n1);
        deleteDups(n1);
        LinkedListNode.printAllNodeData(n1);
    }

    static void deleteDups(LinkedListNode<Integer> n) {
        HashSet<Integer> set = new HashSet<Integer>();
        LinkedListNode<Integer> previous = null;
        while (n != null) {
            if (set.contains(n.data)) {
                previous.next = n.next;
            } else {
                set.add(n.data);
                previous = n;
            }
            n = n.next;
        }
    }
}
