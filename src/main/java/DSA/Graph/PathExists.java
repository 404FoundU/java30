package DSA.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

//https://www.youtube.com/watch?v=knLFe7hEp3Y&list=PLKYEe2WisBTHCmJ6IfEMjg8o--Bvfc5gt&index=1
public class PathExists {

    static Map<Integer, List<Integer>> adjList = new HashMap<>();

    static void addVertex(int x) {
        adjList.put(x, new ArrayList<>());
    }

    static void addBidirectionalEdge(int x, int y) {
        List<Integer> neighbours1 = adjList.get(x);
        neighbours1.add(y);
        adjList.put(x, neighbours1);
        List<Integer> neighbours2 = adjList.get(y);
        neighbours2.add(x);
        adjList.put(y, neighbours2);
    }

    static boolean bfs(int start, int destination) {
        if (start == destination) {
            return true;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        Set<Integer> visited = new HashSet<>();
        visited.add(start);
        while (!queue.isEmpty()) {
            Integer currentVertex = queue.poll();
            if (currentVertex == destination) {
                return true;
            }
            for (Integer neighbour : adjList.get(currentVertex)) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    queue.add(neighbour);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] edges2 = {
                {0, 1},
                {1, 2},
                {2, 0}
        };
        int[][] edges = {
                {0, 1},
                {0, 2},
                {3, 5},
                {5, 4},
                {4, 3}
        };
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges[0].length; j++) {
                addVertex(edges[i][j]);
            }
        }
        for (int i = 0; i < edges.length; i++) {
            addBidirectionalEdge(edges[i][0], edges[i][1]);
        }
        System.out.println(adjList);
//        System.out.println(bfs(0, 2));
        System.out.println(bfs(0, 5));
    }
}
