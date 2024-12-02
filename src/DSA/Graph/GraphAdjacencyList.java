package DSA.Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class GraphAdjacencyList {

    private Map<String, Set<String>> adjacencyList = new HashMap<>();

    void addVertex(String vertex) {
        adjacencyList.put(vertex, new HashSet<>());
    }

    void addEdge(String x, String y) {
        Set<String> vertices1 = adjacencyList.get(x);
        vertices1.add(y);
        adjacencyList.put(x, vertices1);
        Set<String> vertices2 = adjacencyList.get(y);
        vertices2.add(x);
        adjacencyList.put(y, vertices2);
    }

    void printGraph() {
        for (Map.Entry<String, Set<String>> vertex : adjacencyList.entrySet()) {
            System.out.print(vertex.getKey() + ": ");
            vertex.getValue()
                    .forEach(e -> System.out.print(e + "->"));
            System.out.println(" ");
        }
    }

    void bfsTraversal(String start) {
        Queue<String> q = new LinkedList<>();
        q.add(start);
        Set<String> visited = new HashSet<>();
        visited.add(start);
        while (!q.isEmpty()) {
            String vertex = q.poll();
            System.out.println(vertex + " ");
            Set<String> vertices = adjacencyList.get(vertex);
            for (String e : vertices) {
                if (!visited.contains(e)) {
                    visited.add(e);
                    q.add(e);
                }
            }

        }

    }

    void dfsTraversal(String start) {
        Stack<String> stack = new Stack<>();
        stack.add(start);
        Set<String> visited = new HashSet<>();
        visited.add(start);
        while (!stack.isEmpty()) {
            String vertex = stack.pop();
            System.out.println(vertex + " ");
            Set<String> vertices = adjacencyList.get(vertex);
            for (String e : vertices) {
                if (!visited.contains(e)) {
                    visited.add(e);
                    stack.add(e);
                }
            }

        }

    }

    public static void main(String[] args) {
        GraphAdjacencyList graph = new GraphAdjacencyList();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("A", "D");
        graph.addEdge("B", "A");
        graph.addEdge("B", "E");
        graph.addEdge("C", "A");
        graph.addEdge("C", "D");
        graph.addEdge("D", "C");
        graph.addEdge("D", "A");
        graph.addEdge("D", "E");
        graph.printGraph();
//        graph.bfsTraversal("A");
        graph.dfsTraversal("A");
    }
}
