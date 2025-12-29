class Solution {
    class Pair {
        int node;
        int weight;

        public Pair(int n, int w) {
            this.node = n;
            this.weight = w;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<Pair>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int[] f : flights) {
            adj[f[0]].add(new Pair(f[1], f[2]));
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(src, 0));
        int count = 0;
        while (!queue.isEmpty() && count<=k) {
            int size = queue.size();
            while (size-- > 0) {
                Pair p = queue.remove();
                int u=p.node;
                int w=p.weight;
                for (Pair a : adj[p.node]) {
                    int v=a.node;
                    int z=a.weight;
                    if (w + z < dist[v]) {
                        dist[v] = w + z;
                        queue.add(new Pair(v, dist[v]));
                    }
                }
            }
            count++;
        }
        if (dist[dst] == Integer.MAX_VALUE) {
            return -1;
        }
        return dist[dst];

    }
}