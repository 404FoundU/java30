package DSA.Graph.dfs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
You are given a file system represented as a directed graph.
 Each node (called an Entity) can be either a file or a directory.
  A directory contains a list of children (by ID), which can be files or other directories.
Implement a function hasCycle(Map<Integer, Entity> graph) that returns true if the file system contains a cycle,
otherwise false.
 */
public class FileSystemCycleDetector {

    public static void main(String[] args) {
        Map<Integer, Entity> graph = new HashMap<>();

        // Without a cycle
        graph.put(1, new Entity(1, "directory", 0, "root", Arrays.asList(2, 3)));
        graph.put(2, new Entity(2, "directory", 0, "subdir", Arrays.asList(4)));
        graph.put(3, new Entity(3, "file", 300, "fileA", null));
        graph.put(4, new Entity(4, "file", 100, "fileB", null));

        System.out.println("Has cycle (expect false)? " + hasCycle(graph)); // Output: false

        // Introduce a cycle: node 2 → 5 → 1 → 2
        graph.put(5, new Entity(5, "directory", 0, "cycleDir", Arrays.asList(1)));
        graph.get(2).children.add(5);

        System.out.println("Has cycle (expect true)? " + hasCycle(graph)); // Output: true
    }

    public static boolean hasCycle(Map<Integer, Entity> graph) {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> recStack = new HashSet<>();

        for (int node : graph.keySet()) {
            if (dfs(node, graph, visited, recStack)) {
                return true;
            }
        }
        return false;
    }

    private static boolean dfs(int node, Map<Integer, Entity> graph, Set<Integer> visited, Set<Integer> recStack) {
        if (recStack.contains(node)) return true;
        if (visited.contains(node)) return false;

        visited.add(node);
        recStack.add(node);

        Entity entity = graph.get(node);
        if ("directory".equals(entity.type) && entity.children != null) {
            for (int child : entity.children) {
                if (dfs(child, graph, visited, recStack)) return true;
            }
        }

        recStack.remove(node);
        return false;
    }

    static class Entity {
        int id;
        String type; // "file" or "directory"
        int size;    // only used if file
        String name;
        List<Integer> children;

        public Entity(int id, String type, int size, String name, List<Integer> children) {
            this.id = id;
            this.type = type;
            this.size = size;
            this.name = name;
            this.children = children;
        }
    }
}

