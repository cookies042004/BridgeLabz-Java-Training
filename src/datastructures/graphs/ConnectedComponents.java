package datastructures.graphs;

import java.util.*;

public class ConnectedComponents {
    static void dfs(int node, boolean[] visited, List<List<Integer>> adj) {
        visited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, adj);
            }
        }
    }

    static int countComponents(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        int count = 0;

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, visited, adj);
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int V = 5;
        int[][] edges = {
                {0,1},{1,2},{3,4}
        };

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        System.out.println("Connected Components: " + countComponents(V, adj));
    }
}
