package DSA.Graph.topologicalSort;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

//https://www.youtube.com/watch?v=73sneFXuTEg
public class CourseSchedule2 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int coursePrerequisite = prerequisite[1];
            graph.get(coursePrerequisite).add(course);
            inDegree[course]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }
        int completedCourse = 0;
        while (!q.isEmpty()) {
            int course = q.poll();
            completedCourse++;

            // reduce inDegree of each neighbour
            for (int neighbour : graph.get(course)) {
                inDegree[neighbour]--;
                if (inDegree[neighbour] == 0) {
                    q.add(neighbour);
                }
            }
        }
        return completedCourse == numCourses;
    }

    public static void main(String[] args) {
        CourseSchedule2 solution = new CourseSchedule2();

        // Example 1
        // Graph representation:
        // 0 <- 1
        // |    \
        // v     v
        // 2     3
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};

        System.out.println(solution.canFinish(numCourses, prerequisites)); // Output: true

        // Example 2
        // Graph representation:
        // 0 <- 1 <- 2 <- 0 (cycle)
        numCourses = 2;
        prerequisites = new int[][]{{1, 0}, {0, 1}};

        System.out.println(solution.canFinish(numCourses, prerequisites)); // Output: false

        // Example 3
        // Graph representation:
        // No prerequisites
        numCourses = 3;
        prerequisites = new int[][]{};

        System.out.println(solution.canFinish(numCourses, prerequisites)); // Output: true
    }
}
