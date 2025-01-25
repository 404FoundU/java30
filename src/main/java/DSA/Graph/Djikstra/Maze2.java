package DSA.Graph.Djikstra;


import java.util.Comparator;
import java.util.PriorityQueue;

//https://leetcode.com/problems/the-maze-ii
public class Maze2 {

    public static final int[][] DIRECTIONS = {
            {-1, 0}, {1, 0}, {0, 1}, {0, -1}
    };
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;

        int[][] cost = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = Integer.MAX_VALUE;
            }
        }
        cost[start[0]][start[1]] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> cost[a[0]][a[1]]));
//        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(cost[a[0]][a[1]], cost[b[0]][b[1]]));

        pq.add(new int[]{start[0], start[1]});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int row = current[0];
            int col = current[1];
            // If we reach the destination, return the cost
            if (row == destination[0] && col == destination[1]) {
                return cost[row][col];
            }
            for (int[] direction : DIRECTIONS) {
                int r = row;
                int c = col;
                int steps = 0;
                // Roll the ball until it hits a wall or boundary
                while (r + direction[0] >= 0 && r + direction[0] < m &&
                        c + direction[1] >= 0 && c + direction[1] < n &&
                        maze[r + direction[0]][c + direction[1]] == 0) {
                    r += direction[0];
                    c += direction[1];
                    steps++;
                }
                // update cost if we find shorter path
                int candidateCost = cost[row][col] + steps;
                if (candidateCost < cost[r][c]) {
                    cost[r][c] = candidateCost;
                    pq.add(new int[]{r, c});
                }
            }
        }
        // If the destination is unreachable, return -1
        return -1;
    }

    public static void main(String[] args) {
        Maze2 solution = new Maze2();

        int[][] maze1 = {
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}
        };
        int[] start1 = {0, 4};
        int[] destination1 = {4, 4};
        System.out.println("Shortest Distance: " + solution.shortestDistance(maze1, start1, destination1)); // Output: 12

        int[][] maze2 = {
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}
        };
        int[] start2 = {0, 4};
        int[] destination2 = {3, 2};
        System.out.println("Shortest Distance: " + solution.shortestDistance(maze2, start2, destination2)); // Output: -1
    }
}
