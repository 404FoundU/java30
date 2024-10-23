package DSA.Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class TopologicalSortAdjacencyList {

    private Map<String, Set<String>> adjacencyList = new HashMap<>();

    // Add a vertex to the graph
    void addVertex(String vertex) {
        adjacencyList.putIfAbsent(vertex, new HashSet<>());
    }

    // Add a directional edge (x -> y)
    void addDirectionalEdge(String x, String y) {
        Set<String> vertices1 = adjacencyList.get(x);
        vertices1.add(y);
        adjacencyList.put(x, vertices1);
    }

    // Print the graph
    void printGraph() {
        for (Map.Entry<String, Set<String>> vertex : adjacencyList.entrySet()) {
            vertex.getValue()
                    .forEach(e -> System.out.print(vertex.getKey() + "->" + e + " "));
            System.out.println();
        }
    }

    // Topological Sort utility function using DFS
    private void topologicalSortUtil(String vertex, Set<String> visited, Stack<String> stack) {
        // Mark the current vertex as visited
        visited.add(vertex);

        // Recur for all the vertices adjacent to this vertex
        for (String adj : adjacencyList.get(vertex)) {
            if (!visited.contains(adj)) {
                topologicalSortUtil(adj, visited, stack);
            }
        }

        // Push current vertex to the stack which stores the result
        stack.push(vertex);
    }

    // The function to do Topological Sort
    void topologicalSort() {
        Stack<String> stack = new Stack<>();
        Set<String> visited = new HashSet<>();

        // Call the recursive helper function for all vertices
        for (String vertex : adjacencyList.keySet()) {
            if (!visited.contains(vertex)) {
                topologicalSortUtil(vertex, visited, stack);
            }
        }

        // Print the contents of the stack
        System.out.println("Topological Sort Order:");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TopologicalSortAdjacencyList graph = new TopologicalSortAdjacencyList();

        // Add vertices
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
        graph.addVertex("H");

        // Add directional edges (A -> B means A comes before B)
        graph.addDirectionalEdge("A", "C");
        graph.addDirectionalEdge("C", "E");
        graph.addDirectionalEdge("E", "H");
        graph.addDirectionalEdge("E", "F");
        graph.addDirectionalEdge("F", "G");
        graph.addDirectionalEdge("B", "C");
        graph.addDirectionalEdge("B", "D");
        graph.addDirectionalEdge("D", "F");

        // Print the graph
        graph.printGraph();

        // Perform Topological Sort
        graph.topologicalSort();
    }
}

