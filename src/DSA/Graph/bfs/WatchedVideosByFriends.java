package DSA.Graph.bfs;


import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

public class WatchedVideosByFriends {

    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {

        int n = friends.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        visited[id] = true;
        int currentLevel = 0;

        while (!q.isEmpty()) {
            if (currentLevel >= level) {
                break;
            }

            int size = q.size();
            for (int i = 0; i < size; i++) {
                int currentPerson = q.poll();
                for (int friend : friends[currentPerson]) {
                    if (!visited[friend]) {
                        q.add(friend);
                        visited[friend] = true;
                    }
                }
            }
            currentLevel++;
        }

        Map<String, Integer> videoAndCount = new HashMap<>();
        while (!q.isEmpty()) {
            int person = q.poll();
            for (String video : watchedVideos.get(person)) {
                videoAndCount.put(video, videoAndCount.getOrDefault(video, 0) + 1);
            }
        }


        return videoAndCount.entrySet()
                .stream()
                .sorted((a, b) -> a.getValue().compareTo(b.getValue())) // Sort by values
                .map(Map.Entry::getKey)              // Extract the keys
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
