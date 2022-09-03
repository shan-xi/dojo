package org.spin.crackinterview;

import java.util.Objects;
import java.util.Stack;

public class Palindrome {
    public static void main(String[] args) {
        LinkedListNode<Integer> n0 = new LinkedListNode<>(0);
        LinkedListNode<Integer> n1 = new LinkedListNode<>(1);
        LinkedListNode<Integer> n2 = new LinkedListNode<>(2);
        LinkedListNode<Integer> n3 = new LinkedListNode<>(1);
        LinkedListNode<Integer> n4 = new LinkedListNode<>(0);
        n0.setNext(n1);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
//        System.out.println(isPalindrome(n0));
        System.out.println(isPalindrome2(n0));
    }

    static boolean isPalindrome2(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> fast = head;
        LinkedListNode<Integer> slow = head;
        Stack<Integer> stack = new Stack<>();
        while (fast != null && fast.next != null) {
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            int top = stack.pop();
            if (top != slow.data) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

    static boolean isPalindrome(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> reversed = reverseAndClone(head);
        return isEqual(head, reversed);
    }

    static LinkedListNode<Integer> reverseAndClone(LinkedListNode<Integer> node) {
        LinkedListNode<Integer> head = null;
        while (node != null) {
            LinkedListNode<Integer> n = new LinkedListNode<>(node.data);
            n.next = head;
            head = n;
            node = node.next;
        }
        return head;
    }

    static boolean isEqual(LinkedListNode<Integer> one, LinkedListNode<Integer> two) {
        while (one != null && two != null) {
            if (!Objects.equals(one.data, two.data)) {
                return false;
            }
            one = one.next;
            two = two.next;
        }
        return one == null && two == null;
    }
}
