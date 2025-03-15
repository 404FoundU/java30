package DSA.Graph.bfs;

/*
A network consisting of N cities and N-1 roads connecting them is given. Cities are labeled with distinct integers within the range [0..N−1].

Roads connect cities in such a way that each pair of distinct cities is connected either by a direct road or along a path consisting of direct roads. There is exactly one way to reach any city from any other city. In other words, cities and direct roads form a tree.

Jack lives in city number 0. He wants to plan a trip and visit as many cities as possible. Nonetheless, he does not want to visit any city more than once, and he can only move along direct roads. The trip may finish in any city.

There is one issue. Each city labeled with an odd number (1, 3, 5, …) requires a special ticket to visit it. The tickets are already sold out, but luckily Jack has already bought one such ticket, so he can visit at most one odd-numbered city.

Jack wonders how many cities (including the starting one) he can visit.

That, given a non-empty array T consisting of N integers describing a network of N cities and N-1 roads, returns the maximum number of cities that Jack can visit.

Array T describes a network of cities as follows:

T[0] = 0;
if T[P] = Q and P ≠ 0, then there is a direct road between cities P and Q.

Example 1:

Given T = [0, 9, 0, 2, 6, 8, 0, 8, 3, 0]

      0
     /|\
    9 2 6
    | | |
    1 3 4
      |
      8
     / \
    7   5
The function should return 4. One possible path is 0 → 2 → 3 → 8. City number 3 is the only city visited with an odd number.

Example 2:

Given T = [0, 0, 0, 1, 6, 1, 0, 0]

      0
    / | | \
   1  2 6  7
  / \    |
 3   5   4


The function should return 3. One possible path is 0 → 6 → 4. No city with an odd number was visited on the path.

Constraints:
N is an integer within the range [1..100,000];
Each element of array T is an integer within the range [0..N−1];
There is exactly one (possibly indirect) connection between any two distinct cities.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaxCitiesTrip {

    private static int bfs(int[] T) {
        int n = T.length;
        List<List<Integer>> graph = new ArrayList<>();
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for (int i = 1; i < n; i++) {
            graph.get(i).add(T[i]);
            graph.get(T[i]).add(i);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 1, 0}); // city, count, oddVisited
        visited[0] = true;
        int maxCities = 1;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int city = curr[0], count = curr[1], oddVisited = curr[2];
            maxCities = Math.max(maxCities, count);

            for (int neighbor : graph.get(city)) {
                if (!visited[neighbor]) {
                    int isOdd = neighbor % 2;
                    if (isOddAllowed(oddVisited, isOdd)) {
                        visited[neighbor] = true;
                        queue.offer(new int[]{neighbor, count + 1, oddVisited | isOdd});
                    }
                }
            }
        }
        return maxCities;
    }

    private static boolean isOddAllowed(int oddVisited, int isOdd) {
        return isOdd == 0 || (isOdd == 1 && oddVisited == 0);
    }

    public int solution(int[] T) {
        return bfs(T);
    }

    public static void main(String[] args) {
        MaxCitiesTrip sol = new MaxCitiesTrip();
        int[] T1 = {0, 9, 0, 2, 6, 8, 0, 8, 3, 0};
        System.out.println("Example 1: " + sol.solution(T1)); // Expected Output: 4

        int[] T2 = {0, 0, 0, 1, 6, 1, 0, 0};
        System.out.println("Example 2: " + sol.solution(T2)); // Expected Output: 3
    }


}

/*
Time complexity: O(N) as each city is visited at most once.
Space complexity: O(N) for adjacency list and BFS queue.
*/
