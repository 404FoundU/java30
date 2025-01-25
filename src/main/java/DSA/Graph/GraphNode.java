package DSA.Graph;

public class GraphNode implements Comparable<GraphNode> {

    public int dest;
    public int weight;

    public GraphNode(int dest, int weight) {
        this.dest = dest;
        this.weight = weight;
    }

    public int compareTo(GraphNode other) {
        return this.weight - other.weight;
    }

}
