class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] redblack = new int[n];// 1 red -1 black
        for (int i = 0; i < n; i++) {
            if (redblack[i] == 0 && notRedBlack(i, graph, 1, redblack)) {
                return false;
            }
        }
        return true;

    }

    private boolean notRedBlack(int source, int[][] graph, int color, int[] redblack) {
        redblack[source] = color;

        for (int i = 0; i < graph[source].length; i++) {
            int x = graph[source][i];
            if (redblack[x] == color) {
                return true;
            }
            if (redblack[x] == 0) {
                if (notRedBlack(x, graph, -color, redblack)) {
                    return true;
                }
            }

        }
        return false;
    }

}