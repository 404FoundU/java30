package DSA.Graph.dfs;

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
        return false;
    }
}

