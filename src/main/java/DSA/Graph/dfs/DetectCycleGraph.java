package DSA.Graph.dfs;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//https://www.geeksforgeeks.org/detect-cycle-in-a-graph/
class DetectCycleGraph {

    // Function to perform DFS and detect cycle in a
    // directed graph


    public static void main(String[] args) {
        int V = 4; // Number of vertices

        // Directed edges of the graph
        int[][] edges = {
                {0, 1},
                {0, 2},
                {1, 2},
                {2, 0}, // This edge creates a cycle (0 → 2 → 0)
                {2, 3}
        };

        // Print result
        System.out.println(isCyclic(V, edges) ? "true"
                : "false");
    }

    private static boolean isCyclic(int v, int[][] edges) {
        int m = edges.length;
        int n = edges[0].length;

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < v; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            graph.get(start).add(end);
        }
//        System.out.println(graph);
        boolean[] visited = new boolean[v];
        boolean[] dfsVisited = new boolean[v]; // recursionStack

        for (int i = 0; i < v; i++) {
            if (visited[i] == false) {
                if (dfsCycle(graph, visited, dfsVisited, i)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean dfsCycle(
            Map<Integer, List<Integer>> graph, boolean[] visited, boolean[] dfsVisited, int currentNode) {
        // If the current node is already in the recursion
        // stack, a cycle is detected
        if (dfsVisited[currentNode])
            return true;

        // If already visited and not in dfsVisited, it's not
        // part of a cycle
        if (visited[currentNode])
            return false;

        // Mark the current node as visited and add it to
        // the recursion stack
        visited[currentNode] = true;
        dfsVisited[currentNode] = true;

        // Recur for all adjacent vertices
        for (int neighbor : graph.get(currentNode)) {
            if (dfsCycle(graph, visited, dfsVisited, neighbor))
                return true;
        }

        // Backtrack: remove the vertex from recursion stack
        dfsVisited[currentNode] = false;
        return false;

    }
}

