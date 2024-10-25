package DSA.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

//https://www.udemy.com/course/js-algorithms-and-data-structures-masterclass/learn/lecture/11241590#overview
public class Djikstras {

    private Map<String, List<GraphNode>> adjacencyList = new HashMap<>();

    void addVertex(String vertex) {
        adjacencyList.putIfAbsent(vertex, new ArrayList<>());
    }

    void addWeightedEdge(String x, String y, int weight) {
        List<GraphNode> graphNodes = adjacencyList.get(x);
        graphNodes.add(new GraphNode(y, weight));
    }

    Map<String, Integer> djikstrasPath(String source) {
        Map<String, Integer> distances = new HashMap<>();

        for (String vertex : adjacencyList.keySet()) {
            distances.put(vertex, Integer.MAX_VALUE);
        }

        distances.put(source, 0);
        PriorityQueue<GraphNode> pq = new PriorityQueue<>();
        pq.add(new GraphNode(source, 0));


        while (!pq.isEmpty()) {
            GraphNode currentNode = pq.poll();
            String parentVertex = currentNode.target;
            // Iterate over neighbors of the current vertex
            for (GraphNode node : adjacencyList.get(parentVertex)) {
                String neighbour = node.target;
                int distanceOfNeighbour = node.distance;
                Integer distanceFromParentVertex = distances.get(parentVertex);

                int newDistance = distanceFromParentVertex + distanceOfNeighbour;
                // Update the distanceOfNeighbour if a shorter path is found
                Integer oldDistance = distances.get(neighbour);
                if (newDistance < oldDistance) {
                    distances.put(neighbour, newDistance);
                    pq.add(new GraphNode(neighbour, newDistance));
                }
            }
        }

        return distances;

    }


    public static void main(String[] args) {
        Djikstras graph = new Djikstras();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");

        graph.addWeightedEdge("A", "B", 2);
        graph.addWeightedEdge("A", "C", 4);
        graph.addWeightedEdge("B", "C", 1);
        graph.addWeightedEdge("B", "D", 7);
        graph.addWeightedEdge("C", "E", 3);
        graph.addWeightedEdge("D", "E", 1);

        Map<String, Integer> distances = graph.djikstrasPath("A");

        distances.entrySet().forEach(
                e -> System.out.println(e.getKey() + "=" + e.getValue())
        );

    }

}

class GraphNode implements Comparable<GraphNode> {
    String target;
    int distance;

    public GraphNode(String target, int distance) {
        this.target = target;
        this.distance = distance;
    }

    @Override
    public int compareTo(GraphNode other) {
        return this.distance - other.distance;
    }
}
