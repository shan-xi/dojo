package org.spin.crackinterview;

public class DeleteMiddleNode {

    public static void main(String[] args) {
        LinkedListNode<Integer> n1 = new LinkedListNode<>(1);
        LinkedListNode<Integer> n2 = new LinkedListNode<>(2);
        LinkedListNode<Integer> n3 = new LinkedListNode<>(3);
        n1.next = n2;
        n2.next = n3;
        LinkedListNode.printAllNodeData(n1);
        System.out.println(deleteNode(n2));
        System.out.println();
        LinkedListNode.printAllNodeData(n1);
        System.out.println(deleteNode(n3));
        System.out.println();
        LinkedListNode.printAllNodeData(n1);
    }

    static boolean deleteNode(LinkedListNode n){
        if(n == null || n.next == null){
            return false;
        }
        LinkedListNode next = n.next;
        n.data = next.data;
        n.next = n.next.next;
        return true;
    }
}
