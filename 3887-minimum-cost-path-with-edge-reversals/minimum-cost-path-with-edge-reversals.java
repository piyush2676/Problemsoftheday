import java.util.*;

class Solution {

    static class Pair {
        int node;
        int dist;

        Pair(int d, int n) {
            dist = d;
            node = n;
        }
    }

    public int minCost(int n, int[][] edges) {
        Map<Integer, List<Pair>> adj = new HashMap<>();

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(new Pair(wt, v));
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(new Pair(2 * wt, u)); 
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);

        int[] result = new int[n];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[0] = 0;

        pq.offer(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int d = cur.dist;
            int node = cur.node;

            if (node == n - 1) return result[n - 1];

            if (!adj.containsKey(node)) continue;

            for (Pair p : adj.get(node)) {
                int adjNode = p.node;
                int dist = p.dist;

                if (d + dist < result[adjNode]) {
                    result[adjNode] = d + dist;
                    pq.offer(new Pair(d + dist, adjNode));
                }
            }
        }

        return -1;
    }
}
