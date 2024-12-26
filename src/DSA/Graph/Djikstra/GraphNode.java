package DSA.Graph.Djikstra;

public class GraphNode implements Comparable<GraphNode> {

    int vertex;
    int distance;

    public GraphNode(int vertex, int distance) {
        this.vertex = vertex;
        this.distance = distance;
    }

    public int compareTo(GraphNode other) {
        return this.distance - other.distance;
    }

}
