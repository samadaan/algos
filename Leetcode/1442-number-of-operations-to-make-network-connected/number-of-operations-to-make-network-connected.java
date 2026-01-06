class Solution {
    class DSU {
        int[] parent;
        int[] rank;
        int components;

        public DSU(int n) {
            this.parent = new int[n];
            this.rank = new int[n];
            this.components = n;
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        public int find(int i) {
            if (parent[i] == i) return i;
            return parent[i] = find(parent[i]);
        }

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) return false;
            
            // Union by Rank
            if (rank[rootX] < rank[rootY]) parent[rootX] = rootY;
            else if (rank[rootX] > rank[rootY]) parent[rootY] = rootX;
            else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
            components--; // Two components merged into one
            return true;
        }
    }

    public int makeConnected(int n, int[][] connections) {
        // Condition: Total edges must be at least n-1
        if (connections.length < n - 1) return -1;

        DSU dsu = new DSU(n);
        for (int[] conn : connections) {
            dsu.union(conn[0], conn[1]);
        }

        // We need (number of components - 1) cables to connect them all
        return dsu.components - 1;
    }
}