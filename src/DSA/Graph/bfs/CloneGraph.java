package DSA.Graph.bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://www.youtube.com/watch?v=6xRGcSl_MP4
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class CloneGraph {
    Map<Node, Node> map = new HashMap<>(); // maps the node to node

    public Node cloneGraph(Node node) {
        if (node == null) return null;


        Node curr = new Node(node.val);
        map.put(node, curr);

        for (Node nei : node.neighbors) {
            // if nei is not in map then call dfs on this node again
            if (!map.containsKey(nei)) cloneGraph(nei);
            // if map has been visited we do not recurse add it to neighbours
            Node neighbourNode = map.get(nei);
            curr.neighbors.add(neighbourNode);
        }

        return curr;
    }

    public static Node buildGraph(int[][] adjList) {
        if (adjList.length == 0) return null;

        Map<Integer, Node> map = new HashMap<>();

        for (int i = 1; i <= adjList.length; i++) {
            map.put(i, new Node(i));
        }

        for (int i = 1; i <= adjList.length; i++) {
            Node node = map.get(i);
            for (int neighbor : adjList[i - 1]) {
                node.neighbors.add(map.get(neighbor));
            }
        }

        return map.get(1);
    }

    public static void main(String[] args) {
        int[][] adjList = {{2, 4}, {1, 3}, {2, 4}, {1, 3}};
        Node graph = buildGraph(adjList);

        CloneGraph solution = new CloneGraph();
        Node clonedGraph = solution.cloneGraph(graph);

        System.out.println("Graph cloned successfully");
    }
}
