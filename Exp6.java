import java.util.*;

public class PrimMST {

    static class Edge {
        int vertex;
        int weight;

        Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    public static void primMST(List<List<Edge>> graph, int n) {

        boolean[] visited = new boolean[n];
        PriorityQueue<Edge> pq =
                new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));

        // Start from vertex 0
        pq.add(new Edge(0, 0));

        int totalWeight = 0;

        while (!pq.isEmpty()) {
            Edge current = pq.poll();

            int u = current.vertex;

            if (visited[u]) {
                continue;
            }

            visited[u] = true;
            totalWeight += current.weight;

            System.out.println("Vertex: " + u +
                    "  Weight: " + current.weight);

            // Add all adjacent edges
            for (Edge edge : graph.get(u)) {
                if (!visited[edge.vertex]) {
                    pq.add(edge);
                }
            }
        }

        System.out.println("Total MST Weight: " + totalWeight);
    }

    public static void main(String[] args) {

        int n = 5;

        List<List<Edge>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges
        addEdge(graph, 0, 1, 2);
        addEdge(graph, 0, 3, 6);
        addEdge(graph, 1, 2, 3);
        addEdge(graph, 1, 3, 8);
        addEdge(graph, 1, 4, 5);
        addEdge(graph, 2, 4, 7);
        addEdge(graph, 3, 4, 9);

        primMST(graph, n);
    }

    static void addEdge(List<List<Edge>> graph,
                        int u, int v, int weight) {

        graph.get(u).add(new Edge(v, weight));
        graph.get(v).add(new Edge(u, weight));
    }
}