package DSA.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TopologicalSortKahns {

    private Map<String, List<String>> adjacencyList = new HashMap<>();

    // Add a vertex to the graph
    void addVertex(String vertex) {
        adjacencyList.putIfAbsent(vertex, new HashSet<>());
    }

    // Add a directional edge (x -> y)
    void addDirectionalEdge(String x, String y) {
        List<String> vertices1 = adjacencyList.get(x);
        vertices1.add(y);
        adjacencyList.put(x, vertices1);
    }

    // Print the graph
    void printGraph() {
        for (Map.Entry<String, List<String>> vertex : adjacencyList.entrySet()) {
            vertex.getValue()
                    .forEach(e -> System.out.print(vertex.getKey() + "->" + e + " "));
            System.out.println();
        }
    }


    // The function to do Topological Sort
    List<String> topologicalSort() {
        Map<String, Integer> inDegree = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        List<String> topologicalOrder = new ArrayList<>();

        for (String vertex : adjacencyList.keySet()) {
            inDegree.put(vertex, 0);
        }
        for (String vertex : adjacencyList.keySet()) {
            for (String neighbour : adjacencyList.get(vertex)) {
                Integer currentDegree = inDegree.get(neighbour);
                inDegree.put(neighbour, currentDegree + 1);
            }
        }
        // Step 2: Add all vertices with in-degree 0 to the queue
        for (Map.Entry<String, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.add(entry.getKey());
            }
        }
        // Step 3: Process vertices in the queue
        while (!queue.isEmpty()) {
            String vertex = queue.poll();
            topologicalOrder.add(vertex);

            // Reduce the in-degree of each neighbor
            for (String neighbour : adjacencyList.get(vertex)) {
                Integer currentDegree = inDegree.get(neighbour);
                inDegree.put(neighbour, currentDegree - 1);
                // If in-degree becomes 0, add to the queue
                if (inDegree.get(neighbour) == 0) {
                    queue.add(neighbour);
                }
            }
        }
        // Step 4: Check for a cycle
        if (topologicalOrder.size() != adjacencyList.size()) {
            System.out.println("Graph has one cycle");
        }

        return topologicalOrder;
    }

    public static void main(String[] args) {
        TopologicalSortKahns graph = new TopologicalSortKahns();

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

