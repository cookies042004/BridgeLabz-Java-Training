package datastructures.graphs;

import java.util.*;

class Pair {
    int node, weight;

    Pair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}

public class DijkstraAlgorithm {
    static void dijkstra(int V, List<List<Pair>> adj, int source) {

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq =
                new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));

        dist[source] = 0;
        pq.add(new Pair(source, 0));

        while (!pq.isEmpty()) {

            Pair current = pq.poll();
            int node = current.node;

            for (Pair neighbor : adj.get(node)) {

                int newDist = dist[node] + neighbor.weight;

                if (newDist < dist[neighbor.node]) {
                    dist[neighbor.node] = newDist;
                    pq.add(new Pair(neighbor.node, newDist));
                }
            }
        }

        for (int i = 0; i < V; i++) {
            System.out.println("Distance from source to " + i + " = " + dist[i]);
        }
    }

    public static void main(String[] args) {
        int V = 5;

        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        adj.get(0).add(new Pair(1, 2));
        adj.get(1).add(new Pair(0, 2));

        adj.get(0).add(new Pair(2, 4));
        adj.get(2).add(new Pair(0, 4));

        adj.get(1).add(new Pair(2, 1));
        adj.get(2).add(new Pair(1, 1));

        adj.get(1).add(new Pair(3, 7));
        adj.get(3).add(new Pair(1, 7));

        adj.get(2).add(new Pair(4, 3));
        adj.get(4).add(new Pair(2, 3));

        dijkstra(V, adj, 0);
    }
}
