package org.spin.crackinterview;

import org.spin.crackinterview.util.Project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class BuildOrder {
    public static void main(String[] args) {
//        String[] projects = new String[]{"a", "b", "c", "d", "e", "f"};
        String[] projects = new String[]{"a", "b", "c", "d", "e", "f", "g"};
//        String[] projects = new String[]{"a", "b", "c"};
//        String[][] dependencies = new String[][]{
//                {"a", "d"},
//                {"f", "b"},
//                {"b", "d"},
//                {"f", "a"},
//                {"d", "c"},
//        };
        String[][] dependencies = new String[][]{
                {"f", "c"},
                {"f", "b"},
                {"c", "a"},
                {"b", "a"},
                {"b", "e"},
                {"a", "e"},
                {"d", "g"},
        };
//        String[][] dependencies = new String[][]{
//                {"c", "a"},
//                {"a", "b"},
//                {"b", "a"}
//        };
        BuildOrder bo = new BuildOrder();
        Project[] p = bo.findBuildOrder(projects, dependencies);
        if (p != null)
            for (Project project : p) {
                System.out.println(project.getName());
            }
        System.out.println();
        Stack<Project> sp = bo.findBuildOrderDFS(projects, dependencies);
        if (sp != null)
            while (!sp.isEmpty()) {
                System.out.println(sp.pop().getName());
            }

    }

    /* find a correct build order*/
    Project[] findBuildOrder(String[] projects, String[][] dependencies) {
        Graph graph = buildGraph(projects, dependencies);
        return orderProjects(graph.getNodes());
    }

    Graph buildGraph(String[] projects, String[][] dependencies) {
        Graph graph = new Graph();
        for (String project : projects) {
            graph.getOrCreateNode(project);
        }
        for (String[] dependency : dependencies) {
            String first = dependency[0];
            String second = dependency[1];
            graph.addEdge(first, second);
        }
        return graph;
    }

    Project[] orderProjects(ArrayList<Project> projects) {
        Project[] order = new Project[projects.size()];

        int endOfList = addNonDependent(order, projects, 0);

        int toBeProcessed = 0;
        while (toBeProcessed < order.length) {
            Project current = order[toBeProcessed];

            if (current == null) {
                return null;
            }
            ArrayList<Project> children = current.getChildren();
            for (Project child : children) {
                child.decrementDependencies();
            }
            endOfList = addNonDependent(order, children, endOfList);
            toBeProcessed++;
        }
        return order;
    }

    int addNonDependent(Project[] order, ArrayList<Project> projects, int offset) {
        for (Project project : projects) {
            if (project.getNumberDependencies() == 0) {
                order[offset] = project;
                offset++;
            }
        }
        return offset;
    }

    Stack<Project> findBuildOrderDFS(String[] projects, String[][] dependencies) {
        Graph graph = buildGraph(projects, dependencies);
        return orderProjectsDFS(graph.getNodes());
    }

    Stack<Project> orderProjectsDFS(ArrayList<Project> projects) {
        Stack<Project> stack = new Stack<>();
        for (Project project : projects) {
            if (project.getState() == Project.State.BLANK) {
                if (!doDFS(project, stack)) {
                    return null;
                }
            }
        }
        return stack;
    }

    boolean doDFS(Project project, Stack<Project> stack) {
        if (project.getState() == Project.State.PARTIAL) {
            return false;
        }
        if (project.getState() == Project.State.BLANK) {
            project.setState(Project.State.PARTIAL);
            ArrayList<Project> children = project.getChildren();
            for (Project child : children) {
                if (!doDFS(child, stack)) {
                    return false;
                }
            }
            project.setState(Project.State.COMPLETE);
            stack.push(project);
        }
        return true;
    }
}

class Graph {
    private ArrayList<Project> nodes = new ArrayList<Project>();
    private HashMap<String, Project> map = new HashMap<String, Project>();

    public Project getOrCreateNode(String name) {
        if (!map.containsKey(name)) {
            Project node = new Project(name);
            nodes.add(node);
            map.put(name, node);
        }
        return map.get(name);
    }

    public void addEdge(String startName, String endName) {
        Project start = getOrCreateNode(startName);
        Project end = getOrCreateNode(endName);
        start.addNeighbor(end);
    }

    public ArrayList<Project> getNodes() {
        return nodes;
    }

}
