package org.spin.codetesting.amazon.vidoeinterview;

public class BinaryTree {
    Node root;

    BinaryTree() {
        root = null;
    }

    void printInorder(Node node) {
        if (node == null) {
            return;
        }

        printInorder(node.left);
        System.out.println(node.key + " ");
        printInorder(node.right);
    }

    void printInorder() {
        printInorder(root);
    }

    void printPreorder(Node node){
        if(node == null){
            return;
        }
        System.out.println(node.key+" ");
        printPreorder(node.left);
        printPreorder(node.right);
    }

    void printPreorder(){
        printPreorder(root);
    }

    void printPostorder(Node node){
        if(node == null){
            return;
        }

        printPostorder(node.left);
        printPostorder(node.right);
        System.out.println(node.key+" ");
    }

    void printPostorder(){
        printPostorder(root);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        tree.printInorder();
        System.out.println();
        tree.printPreorder();
        System.out.println();
        tree.printPostorder();

    }
}

