package org.spin.crackinterview;

public class LinkedListNode<T> {
    T data;
    LinkedListNode<T> next;

    public LinkedListNode() {

    }

    public LinkedListNode(T data) {
        this.data = data;
    }

    public void setNext(LinkedListNode<T> node) {
        this.next = node;
    }

    public static <T> int length(LinkedListNode<T> node) {
        int count = 1;
        LinkedListNode<T> current = node;
        while (current != null) {
            current = current.next;
            count++;
        }
        return count;
    }

    public static <T> void printAllNodeData(LinkedListNode<T> root) {
        LinkedListNode<T> cur = root;
        while (cur != null) {
            System.out.println(cur.data);
            cur = cur.next;
        }
    }
}
