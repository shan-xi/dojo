package org.spin.crackinterview.util;

public class Node<T> {

    private final Node<T>[] adj;
    public int adjCount;
    private T vertex;
    public State state;

    public Node(T vertex, int adjLen) {
        this.vertex = vertex;
        adj = new Node[adjLen];
        state = State.Unvisited;
        adjCount = 0;
    }

    public void addAdj(Node<T> x) throws NodeCapacityFullException {
        if (adjCount < adj.length) {
            this.adj[adjCount] = x;
            adjCount++;
        } else {
            throw new NodeCapacityFullException();
        }
    }

    public Node<T>[] getAdjacent() {
        return adj;
    }

    public T getVertex() {
        return vertex;
    }
}
