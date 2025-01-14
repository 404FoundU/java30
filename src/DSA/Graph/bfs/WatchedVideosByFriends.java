package DSA.Graph.bfs;


import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

//https://leetcode.com/problems/get-watched-videos-by-your-friends
public class WatchedVideosByFriends {

    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] graph, int source, int level) {
        int n = graph.length;

        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        visited[source] = true;

        int currentLevel = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            // navigate to current level friends
            if (level == currentLevel) {
                break;
            }
            for (int i = 0; i < size; i++) {
                int current = q.poll();

                for (int neighbour : graph[current]) {
                    if (!visited[neighbour]) {
                        visited[neighbour] = true;
                        q.add(neighbour);
                    }
                }
            }
            currentLevel++;

        }

        Map<String, Integer> freqCounter = new HashMap<>();
        // queue has only friends
        while (!q.isEmpty()) {
            int current = q.poll();
            List<String> videos = watchedVideos.get(current);
            videos.forEach(video -> {
                Integer count = freqCounter.getOrDefault(video, 0);
                freqCounter.put(video, count + 1);
            });
        }

        Comparator<Map.Entry<String, Integer>> entryComparator = (a, b) -> a.getValue().compareTo(b.getValue());
        return freqCounter.entrySet()
                .stream()
                .sorted(entryComparator)
                .map(f -> f.getKey())
                .collect(Collectors.toList());


    }


    public static void main(String[] args) {
        WatchedVideosByFriends solver = new WatchedVideosByFriends();
        List<List<String>> watchedVideos = Arrays.asList(
                Arrays.asList("A", "B"),
                Arrays.asList("C"),
                Arrays.asList("B", "C"),
                Arrays.asList("D")
        );
        int[][] friends = {
                {1, 2},
                {0, 3},
                {0, 3},
                {1, 2}
        };
        int id = 0;
        int level = 1;

        System.out.println("Watched Videos: " + solver.watchedVideosByFriends(watchedVideos, friends, id, level));
        // Output: [B, C]
    }
}
