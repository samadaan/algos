class Solution {
    class DSU {
        int[] parent;
        int[] rank;

        public DSU(int n) {
            this.parent = new int[n];
            this.rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int curr) {
            if (parent[curr] == curr) {
                return curr;
            }
            return parent[curr] = find(parent[curr]);
        }

        public boolean union(int x, int y) {
            int parx = find(x);
            int pary = find(y);
            if (parx == pary)
                return false;
            if (rank[parx] >= rank[pary]) {
                parent[pary] = parx;
                rank[parx]++;
            } else {
                parent[parx] = pary;
                rank[pary]++;
            }
            return true;
        }

        public int findUniqueParent() {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < parent.length; i++) {
                set.add(find(parent[i]));
            }
            return set.size();
        }
    }

    public int makeConnected(int n, int[][] connections) {
        DSU dsu = new DSU(n);
        int count = 0;
        for (int[] conn : connections) {
            if (!dsu.union(conn[0], conn[1])) {
                count++;
            }
        }
        System.out.println(count);
        int edgeRequired = dsu.findUniqueParent() - 1;
        System.out.println(edgeRequired);
        if (count >= edgeRequired) {
            return edgeRequired;
        }
        return -1;

    }
}