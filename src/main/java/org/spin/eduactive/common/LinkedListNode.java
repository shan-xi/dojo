package org.spin.eduactive.common;

public class LinkedListNode {
    public Integer data;
    public LinkedListNode next;

    public LinkedListNode arbitrary_pointer;

    public LinkedListNode(Integer data) {
        this.data = data;
    }

    public LinkedListNode(Integer data, LinkedListNode next, LinkedListNode arbitrary_pointer) {
        this.data = data;
        this.next = next;
        this.arbitrary_pointer = arbitrary_pointer;
    }
}