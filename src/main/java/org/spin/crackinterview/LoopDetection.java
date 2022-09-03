package org.spin.crackinterview;

import java.util.Objects;

public class LoopDetection {
    public static void main(String[] args) {
        LinkedListNode<String> n1 = new LinkedListNode<>("A");
        LinkedListNode<String> n2 = new LinkedListNode<>("B");
        LinkedListNode<String> n3 = new LinkedListNode<>("C");
        LinkedListNode<String> n4 = new LinkedListNode<>("D");
        LinkedListNode<String> n5 = new LinkedListNode<>("E");
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        n5.setNext(n1);
        LinkedListNode<String> r = findBeginning(n1);
        System.out.println(r.data);
    }

    static LinkedListNode<String> findBeginning(LinkedListNode<String> head) {
        LinkedListNode<String> slow = head;
        LinkedListNode<String> fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (Objects.equals(slow, fast)) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        slow = head;
        while (!Objects.equals(slow, fast)) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
