class Solution {
    class Pair {
        int weight;
        int node;

        public Pair(int w, int n) {
            this.weight = w;
            this.node = n;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {

        List<Pair>[] adj = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] time : times) {
            adj[time[0]].add(new Pair(time[2], time[1]));
        }

        int[] dist = new int[n + 1];
        int[] visited = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        for (int i = 0; i <= n; i++) {
            int x = minDist(dist, visited);
            if (x == -1) {
                break;
            }
            visited[x] = 1;
            for (Pair p : adj[x]) {
                dist[p.node] = Math.min(dist[p.node], dist[x] + p.weight);
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, dist[i]);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;

    }

    private int minDist(int[] dist, int[] visited) {
        int minValue = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 1; i < dist.length; i++) {
            if (visited[i] == 0 && dist[i] < minValue) {
                minValue = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}