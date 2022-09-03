package org.spin.crackinterview;

import java.util.Objects;

public class Intersection {
    public static void main(String[] args) {
        LinkedListNode<Integer> list1_n1 = new LinkedListNode<>(3);
        LinkedListNode<Integer> list1_n2 = new LinkedListNode<>(1);
        LinkedListNode<Integer> list1_n3 = new LinkedListNode<>(5);
        LinkedListNode<Integer> list1_n4 = new LinkedListNode<>(9);
        LinkedListNode<Integer> list1_n5 = new LinkedListNode<>(7);
        LinkedListNode<Integer> list1_n6 = new LinkedListNode<>(2);
        LinkedListNode<Integer> list1_n7 = new LinkedListNode<>(1);
        list1_n1.setNext(list1_n2);
        list1_n2.setNext(list1_n3);
        list1_n3.setNext(list1_n4);
        list1_n4.setNext(list1_n5);
        list1_n5.setNext(list1_n6);
        list1_n6.setNext(list1_n7);

        LinkedListNode<Integer> list2_n1 = new LinkedListNode<>(4);
        LinkedListNode<Integer> list2_n2 = new LinkedListNode<>(6);
        LinkedListNode<Integer> list2_n3 = new LinkedListNode<>(7);
        LinkedListNode<Integer> list2_n4 = new LinkedListNode<>(2);
        LinkedListNode<Integer> list2_n5 = new LinkedListNode<>(1);
        list2_n1.setNext(list2_n2);
        list2_n2.setNext(list2_n3);
        list2_n3.setNext(list2_n4);
        list2_n4.setNext(list2_n5);

        LinkedListNode<Integer> r = findIntersection(list1_n1, list2_n1);
        System.out.println(r.data);

    }

    static class Result {
        public LinkedListNode<Integer> tail;
        public int size;

        public Result(LinkedListNode<Integer> tail, int size) {
            this.tail = tail;
            this.size = size;
        }
    }

    static LinkedListNode<Integer> findIntersection(LinkedListNode<Integer> list1, LinkedListNode<Integer> list2) {
        if (list1 == null || list2 == null) return null;

        Result result1 = getTailAndSize(list1);
        Result result2 = getTailAndSize(list2);

        if (!Objects.equals(result1.tail.data, result2.tail.data)) {
            return null;
        }

        LinkedListNode<Integer> shorter = result1.size < result2.size ? list1 : list2;
        LinkedListNode<Integer> longer = result1.size < result2.size ? list2 : list1;

        longer = getKthNode(longer, Math.abs(result1.size - result2.size));

        while (!Objects.equals(shorter.data, longer.data)) {
            shorter = shorter.next;
            longer = longer.next;
        }

        return longer;
    }

    static Result getTailAndSize(LinkedListNode<Integer> list) {
        if (list == null) return null;
        int size = 1;
        LinkedListNode<Integer> current = list;
        while (current.next != null) {
            size++;
            current = current.next;
        }
        return new Result(current, size);
    }

    static LinkedListNode<Integer> getKthNode(LinkedListNode<Integer> head, int k) {
        LinkedListNode<Integer> current = head;
        while (k > 0 && current != null) {
            current = current.next;
            k--;
        }
        return current;
    }
}
