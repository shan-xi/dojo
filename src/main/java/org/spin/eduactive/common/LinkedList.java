package org.spin.eduactive.common;

public class LinkedList {

    public static LinkedListNode create_linked_list(int[] arr) {
        LinkedListNode current = null;
        LinkedListNode head = null;
        for (int i : arr) {
            LinkedListNode node = new LinkedListNode(i);
            if (current == null) {
                current = node;
                head = current;
            } else {
                current.next = node;
                current = node;
            }
        }
        return head;
    }

    public static void display(LinkedListNode node) {
        while (node != null) {
            System.out.print(node.data + "\s");
            node = node.next;
        }
        System.out.println();
    }

    public static void display2(LinkedListNode node) {
        while (node != null) {
            if (node.arbitrary_pointer != null)
                System.out.print(node.data + ":" + node.arbitrary_pointer.data + "\s");
            else
                System.out.print(node.data + ":null" + "\s");
            node = node.next;
        }
        System.out.println();
    }
}
