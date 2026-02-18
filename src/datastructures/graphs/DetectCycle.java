package datastructures.graphs;

import java.util.*;

public class DetectCycle {
    static boolean dfs(int node, int parent, boolean[] visited, List<List<Integer>> adj) {
        visited[node] = true;

        for (int neighbor : adj.get(node)) {

            if (!visited[neighbor]) {
                if (dfs(neighbor, node, visited, adj))
                    return true;
            }
            else if (neighbor != parent) {
                return true;
            }
        }

        return false;
    }

    static boolean hasCycle(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, -1, visited, adj))
                    return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int V = 4;
        int[][] edges = {
                {0,1},{1,2},{2,0}
        };

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        System.out.println("Cycle exists? " + hasCycle(V, adj));
    }
}
