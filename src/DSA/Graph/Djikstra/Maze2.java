package DSA.Graph.Djikstra;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//https://leetcode.com/problems/the-maze-ii
public class Maze2 {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;

        // Distance array to store the shortest distance to each cell
        int[][] dist = new int[m][n];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // Priority Queue: {distance, row, col}
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, start[0], start[1]});
        dist[start[0]][start[1]] = 0;

        // Directions: right, down, left, up
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currDist = curr[0], x = curr[1], y = curr[2];

            // If we reach the destination, return the distance
            if (x == destination[0] && y == destination[1]) {
                return currDist;
            }

            // Explore all directions
            for (int[] dir : directions) {
                int nx = x, ny = y, steps = 0;

                // Roll the ball until it hits a wall or boundary
                while (nx + dir[0] >= 0 && nx + dir[0] < m && ny + dir[1] >= 0 && ny + dir[1] < n && maze[nx + dir[0]][ny + dir[1]] == 0) {
                    nx += dir[0];
                    ny += dir[1];
                    steps++;
                }

                // Check if we found a shorter distance to (nx, ny)
                if (currDist + steps < dist[nx][ny]) {
                    dist[nx][ny] = currDist + steps;
                    pq.offer(new int[]{dist[nx][ny], nx, ny});
                }
            }
        }

        // If destination is unreachable, return -1
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
