package org.spin.crackinterview.util;

public class Graph<T> {
    public static int MAX_VERTICES = 6;
    private Node<T> vertices[];
    public int count;

    public Graph() {
        vertices = new Node[MAX_VERTICES];
        count = 0;
    }

    public void addNodes(Node<T> x) throws GraphVertexFullException {
        if (count < vertices.length) {
            vertices[count] = x;
            count++;
        } else {
            throw new GraphVertexFullException();
        }
    }

    public Node<T>[] getNodes() {
        return vertices;
    }
}
