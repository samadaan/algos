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
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        List<Pair>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++)
            adjList[i] = new ArrayList<>();
        for (int[] f : flights) {
            adjList[f[0]].add(new Pair(f[1], f[2]));
        }

        for (int i = 0; i <= k; i++) {
            int[] arr=Arrays.copyOf(dist, dist.length);
            for (int j = 0; j < n; j++) {
                if (dist[j] != Integer.MAX_VALUE) {
                    // System.out.println("Processing "+j);
                    int currDist = dist[j];
                    for (Pair p : adjList[j]) {
                        int diff = p.weight;
                        int newNode = p.node;
                        if (dist[newNode] > currDist + diff) {
                            arr[newNode] = Math.min(arr[newNode], currDist + diff);
                            // System.out.println(newNode+" "+dist[newNode]);
                        }
                    }
                }
            }
            dist=arr;
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];

    }
}