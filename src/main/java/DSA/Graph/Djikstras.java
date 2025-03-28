package DSA.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

//https://www.udemy.com/course/js-algorithms-and-data-structures-masterclass/learn/lecture/11241590#overview
public class Djikstras {

    private Map<String, List<GraphNodeOld>> adjacencyList = new HashMap<>();

    void addVertex(String vertex) {
        adjacencyList.putIfAbsent(vertex, new ArrayList<>());
    }

    void addWeightedEdge(String x, String y, int weight) {
        List<GraphNodeOld> graphNodeOlds = adjacencyList.get(x);
        graphNodeOlds.add(new GraphNodeOld(y, weight));
    }

    Map<String, Integer> djikstrasPath(String source) {
        Map<String, Integer> distances = new HashMap<>();

        for (String vertex : adjacencyList.keySet()) {
            distances.put(vertex, Integer.MAX_VALUE);
        }

        distances.put(source, 0);
        PriorityQueue<GraphNodeOld> pq = new PriorityQueue<>();
        pq.add(new GraphNodeOld(source, 0));


        while (!pq.isEmpty()) {
            GraphNodeOld currentNode = pq.poll();
            String parentVertex = currentNode.target;
            // Iterate over neighbors of the current vertex
            for (GraphNodeOld node : adjacencyList.get(parentVertex)) {
                String neighbour = node.target;
                int distanceOfNeighbour = node.distance;
                Integer distanceFromParentVertex = distances.get(parentVertex);

                int candidateDistance = distanceFromParentVertex + distanceOfNeighbour;
                // Update the distanceOfNeighbour if a shorter path is found
                Integer oldDistance = distances.get(neighbour);
                if (candidateDistance < oldDistance) {
                    distances.put(neighbour, candidateDistance);
                    pq.add(new GraphNodeOld(neighbour, candidateDistance));
                }
            }
        }

        return distances;

    }

    Map<String, Integer> djikstrasPath2(String source, String dest) {
        Map<String, Integer> distances = new HashMap<>();
        Map<String, String> previous = new HashMap<>();
        List<String> path = new LinkedList<>();

        for (String vertex : adjacencyList.keySet()) {
            distances.put(vertex, Integer.MAX_VALUE);
            previous.put(vertex, null);
        }
        distances.put(source, 0);

        PriorityQueue<GraphNodeOld> pq = new PriorityQueue<>();
        pq.add(new GraphNodeOld(source, 0));
        String smallestVertex = null;


        while (!pq.isEmpty()) {
            smallestVertex = pq.poll().target;
            if (smallestVertex.equals(dest)) {

//we are done
// build path to smallest
                while (previous.get(smallestVertex) != null) {
                    path.add(smallestVertex);
                    smallestVertex = previous.get(smallestVertex);
                }
                path.add(smallestVertex);
                path.forEach(System.out::println);
            }

            // for each neighbouring node- calculate candidateDistance from starting node
            for (GraphNodeOld nextNeighbourNode : adjacencyList.get(smallestVertex)) {

                String nextNeighbourVertex = nextNeighbourNode.target;
                int distance = nextNeighbourNode.distance;
                Integer nextNeighbourDistance = distances.get(nextNeighbourVertex);
                // calculate new distance to neighbouring node
                Integer oldDistance = distances.get(smallestVertex);
                int candidateDistance = oldDistance + distance;
                //if candiateDistance < what is stored in distances table

                if (candidateDistance < nextNeighbourDistance) {
                    distances.put(nextNeighbourVertex, candidateDistance);
                    previous.put(nextNeighbourVertex, smallestVertex);
                    pq.add(new GraphNodeOld(nextNeighbourVertex, candidateDistance));

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

//        Map<String, Integer> distances = graph.djikstrasPath("A");
        Map<String, Integer> distances = graph.djikstrasPath2("A", "E");

        distances.entrySet().forEach(
                e -> System.out.println(e.getKey() + "=" + e.getValue())
        );

    }

}

class GraphNodeOld implements Comparable<GraphNodeOld> {
    String target;
    int distance;

    public GraphNodeOld(String target, int distance) {
        this.target = target;
        this.distance = distance;
    }

    @Override
    public int compareTo(GraphNodeOld other) {
        return this.distance - other.distance;
    }
}
