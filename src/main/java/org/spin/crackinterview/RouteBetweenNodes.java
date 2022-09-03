package org.spin.crackinterview;

import org.spin.crackinterview.util.Graph;
import org.spin.crackinterview.util.Node;
import org.spin.crackinterview.util.NodeCapacityFullException;
import org.spin.crackinterview.util.State;

import java.util.LinkedList;
import java.util.Objects;

public class RouteBetweenNodes {
    public static void main(String[] args) throws Exception {
        Node<String> n1 = new Node<>("A", 1);
        Node<String> n2 = new Node<>("B", 1);
        Node<String> n3 = new Node<>("C", 1);
        Node<String> n4 = new Node<>("D", 1);
        n1.addAdj(n2);
        n2.addAdj(n3);
        Graph<String> g = new Graph<>();
        g.addNodes(n1);
        g.addNodes(n2);
        g.addNodes(n3);
        g.addNodes(n4);
        RouteBetweenNodes rb = new RouteBetweenNodes();
        System.out.println(rb.search(g, n1, n3));
    }

    boolean search(Graph<String> g, Node<String> start, Node<String> end) {
        if (start == end) {
            return true;
        }
        LinkedList<Node<String>> q = new LinkedList<Node<String>>();
        start.state = State.visiting;
        q.add(start);
        Node<String> u;
        while (!q.isEmpty()) {
            u = q.removeFirst();
            if (u != null) {
                for (Node<String> v : u.getAdjacent()) {
                    if (v != null && v.state == State.Unvisited) {
                        if (Objects.equals(v.getVertex(), end.getVertex())) {
                            return true;
                        } else {
                            v.state = State.visiting;
                            q.add(v);
                        }
                    }
                }
                u.state = State.visited;
            }
        }
        return false;
    }
}
