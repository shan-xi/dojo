package org.spin.hackerrank.linkedlist;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input_count = sc.nextInt();
        int count = 0;
        SinglyLinkedListNode sn = new SinglyLinkedListNode();

        while (sc.hasNext()) {
            count++;
            Node node = new Node(sc.nextInt());
            sn.add(node);

            if (count == input_count)
                break;
        }
        sn.printAllNodes();

    }
}

class SinglyLinkedListNode {
    private Node head;

    void add(Node node) {
        Node current = head;
        if (head == null) {
            head = node;
        } else {
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(node);
        }
    }

    void printAllNodes() {
        Node n = head;
        while (n != null) {
            System.out.println(n.getValue());
            n = n.getNext();
        }
    }
}

class Node {
    private Integer value;
    private Node next;

    Node(Integer value) {
        this.value = value;
    }

    Integer getValue() {
        return this.value;
    }

    Node getNext() {
        return this.next;
    }

    void setNext(Node node) {
        next = node;
    }
}