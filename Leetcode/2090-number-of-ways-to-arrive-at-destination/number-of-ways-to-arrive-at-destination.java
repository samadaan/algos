class Solution {
    class Pair {
        int node;
        long weight;

        public Pair(int n, long w) {
            this.node = n;
            this.weight = w;
        }
    }

    public int countPaths(int n, int[][] roads) {
        long mod = 1_000_000_007L; // Proper long literal
        long[] ways = new long[n];
        ways[0] = 1;

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        List<Pair>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++)
            adjList[i] = new ArrayList<>();
        for (int[] r : roads) {
            adjList[r[0]].add(new Pair(r[1], r[2]));
            adjList[r[1]].add(new Pair(r[0], r[2]));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((p, q) -> Long.compare(p.weight, q.weight));
        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int currNode = p.node;
            long currWeight = p.weight;
            if (currNode == n - 1) {
                continue;
            }
            for (Pair q : adjList[currNode]) {
                if (dist[q.node] > currWeight + q.weight) {
                    dist[q.node] = currWeight + q.weight;
                    ways[q.node] = ways[currNode];
                    pq.add(new Pair(q.node, dist[q.node]));
                } else if (dist[q.node] == currWeight + q.weight) {
                    ways[q.node] = (ways[q.node] + ways[currNode]) % mod;
                }
            }
        }
        return (int) (ways[n - 1] % mod);

    }
}