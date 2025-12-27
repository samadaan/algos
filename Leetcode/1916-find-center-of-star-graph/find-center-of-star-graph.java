class Solution {
    public int findCenter(int[][] edges) {
        // Just compare the two nodes of the first edge 
        // with the two nodes of the second edge.
        int u1 = edges[0][0], v1 = edges[0][1];
        int u2 = edges[1][0], v2 = edges[1][1];

        // The center node must be present in both edges
        if (u1 == u2 || u1 == v2) {
            return u1;
        } else {
            return v1;
        }

    }
}