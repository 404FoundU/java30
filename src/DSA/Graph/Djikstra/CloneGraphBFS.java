package DSA.Graph.Djikstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

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

public class CloneGraphBFS {


    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>(); // maps the node to clone node
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        map.put(node, new Node(node.val));
        while (!q.isEmpty()) {
            Node current = q.poll();
            Node currentClone = map.get(current);
            for (Node neighbour : current.neighbors) {
                Node neighbourClone;
                if (map.containsKey(neighbour)) {
                    neighbourClone = map.get(neighbour);
                } else {
                    neighbourClone = new Node(neighbour.val);
                    q.add(neighbour);
                    map.put(neighbour, neighbourClone);
                }
                currentClone.neighbors.add(neighbourClone);
            }
        }
        return map.get(node);
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

        CloneGraphBFS solution = new CloneGraphBFS();
        Node clonedGraph = solution.cloneGraph(graph);

        System.out.println("Graph cloned successfully");
    }
}
