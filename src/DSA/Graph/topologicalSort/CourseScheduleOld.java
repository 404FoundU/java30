package DSA.Graph.topologicalSort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

//https://www.youtube.com/watch?v=nz5V5pOiT8w&list=PLKYEe2WisBTHCmJ6IfEMjg8o--Bvfc5gt&index=4
public class CourseScheduleOld {

    static Map<Integer, List<Integer>> adjList = new HashMap<>();

    static boolean topologicalSort() {

        Map<Integer, Integer> inDegrees = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        //initialize indegrees as 0
        for (Map.Entry<Integer, List<Integer>> vertex : adjList.entrySet()) {
            inDegrees.put(vertex.getKey(), 0);
        }
        for (Map.Entry<Integer, List<Integer>> entry : adjList.entrySet()) {
            Integer vertex = entry.getKey();
            for (int neighbour : adjList.get(vertex)) {
                int currentDegree = inDegrees.get(neighbour);
                inDegrees.put(neighbour, currentDegree + 1);
            }
        }
        // Step 2: Add all vertices with in-degree 0 to the queue
        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegrees.entrySet()) {
            if (entry.getValue() == 0) {
                queue.add(entry.getKey());
            }
        }
        while (!queue.isEmpty()) {
            Integer currentVertex = queue.poll();
            result.add(currentVertex);
            for (Integer neighbour : adjList.get(currentVertex)) {
                int currentDegree = inDegrees.get(neighbour);
                inDegrees.put(neighbour, currentDegree - 1);

                if (inDegrees.get(neighbour) == 0) {
                    queue.add(neighbour);
                }

            }
        }
        if (result.size() == adjList.size()) {
            return true;
        }

        return false;
    }


    static void addVertex(int x) {
        if (adjList.containsKey(x)) {
            return;
        }
        adjList.put(x, new ArrayList<>());
    }

    static void addDirectionalEdge(int x, int y) {
        List<Integer> vertices = adjList.get(x);
        vertices.add(y);
        adjList.put(x, vertices);

    }

    public static void main(String[] args) {
        int numOfCourses = 3;
       /* int[][] prerequisites = {
                {1, 0},
                {2, 1}
        };*/
        int[][] prerequisites = {
                {1, 0}, {0, 1}, {1, 2}
        };
        for (int i = 0; i < prerequisites.length; i++) {
            for (int j = 0; j < prerequisites[0].length; j++) {
                addVertex(prerequisites[i][j]);
            }
        }
        for (int i = 0; i < prerequisites.length; i++) {
            addDirectionalEdge(prerequisites[i][0], prerequisites[i][1]);
        }

        System.out.println(adjList);
        System.out.println(topologicalSort());
    }

}
