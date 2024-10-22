package DSA.Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
    }
}
