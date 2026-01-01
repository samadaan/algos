class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {

        List<Integer>[] adjList = new ArrayList[quiet.length];
        for (int i = 0; i < quiet.length; i++)
            adjList[i] = new ArrayList<>();

        for (int[] rich : richer) {
            adjList[rich[1]].add(rich[0]);
        }

        int[] state = new int[quiet.length];
        Arrays.fill(state, -1);

        int[] ans = new int[quiet.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = dfs(i, state, adjList, quiet);
        }
        return ans;

    }

    private int dfs(int source, int[] state, List<Integer>[] adjList, int[] quiet) {
        if (state[source] >= 0) {
            return state[source];
        }
        int minIndex = source;
        for (Integer adj : adjList[source]) {
            int ind = dfs(adj, state, adjList, quiet);
            if (quiet[ind] < quiet[minIndex]) {
                minIndex = ind;
            }
        }
        state[source] = minIndex;
        return minIndex;
    }
}