package DSA.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class GraphAdjacencyMatrix {
    int[][] adjacencyMatrix = null;
    Map<String, Integer> vertices = new HashMap<>();

    public GraphAdjacencyMatrix(int size) {
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

    void bfsTraversal(String start) {
        boolean[] visited = new boolean[adjacencyMatrix.length]; // To track visited vertices
        Queue<Integer> queue = new LinkedList<>();  // Queue for BFS

        // Get the start index from the vertex map
        int startIndex = vertices.get(start);
        visited[startIndex] = true;  // Mark the starting vertex as visited
        queue.add(startIndex);  // Add the starting vertex to the queue

        System.out.println("BFS starting from node: " + start);

        while (!queue.isEmpty()) {
            int currentIndex = queue.poll();  // Dequeue a vertex
            System.out.print(getKeyByValue(vertices, currentIndex) + " ");  // Print the current vertex

            // Get all adjacent vertices of the dequeued vertex
            for (int i = 0; i < adjacencyMatrix.length; i++) {
                if (adjacencyMatrix[currentIndex][i] == 1 && !visited[i]) {  // If adjacent and not visited
                    visited[i] = true;  // Mark it as visited
                    queue.add(i);  // Enqueue the adjacent vertex
                }
            }
        }
        System.out.println();  // For newline after traversal
    }

    private String getKeyByValue(Map<String, Integer> map, int value) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == value) {
                return entry.getKey();
            }
        }
        return null;
    }


    public static void main(String[] args) {
        GraphAdjacencyMatrix graph = new GraphAdjacencyMatrix(5);
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
        graph.bfsTraversal("A");
    }
}

