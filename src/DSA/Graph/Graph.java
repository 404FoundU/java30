package DSA.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    int[][] adjacencyMatrix = null;
    Map<String, Integer> vertices = new HashMap<>();

    public Graph(int size) {
        this.adjacencyMatrix = new int[size][size];
    }

    void addNode(String name, int index) {
        vertices.put(name, index);
    }

    void addEdge(String x, String y) {
        int vertex1 = vertices.get(x);
        int vertex2 = vertices.get(y);
        adjacencyMatrix[vertex1][vertex2] = 1;
        adjacencyMatrix[vertex2][vertex1] = 1;
    }

    void printGraph() {
        int length = adjacencyMatrix.length;
        System.out.print("  ");
        List<String> nodes = new ArrayList<>();
        for (Map.Entry<String, Integer> vertex : vertices.entrySet()) {
            System.out.print(vertex.getKey() + " ");
            nodes.add(vertex.getKey());
        }
        System.out.println(" ");

        for (int i = 0; i < length; i++) {
            System.out.print(nodes.get(i) + " ");
            for (int j = 0; j < length; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addNode("A", 0);
        graph.addNode("B", 1);
        graph.addNode("C", 2);
        graph.addNode("D", 3);
        graph.addNode("E", 4);

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

