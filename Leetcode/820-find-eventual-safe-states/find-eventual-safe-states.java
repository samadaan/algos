class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {

        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < graph.length; i++) {
            if (graph[i].length == 0) {
                s.add(i);
            }
        }
        int[] state = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (state[i] == 0) {
                dfs(i, graph, s, state);
            }
        }
        List<Integer> list = new ArrayList<>(s);
        Collections.sort(list);
        return list;

    }

    public boolean dfs(int source, int[][] adj, Set<Integer> tnSet, int[] state) {
        if (state[source] == 1) {
            return false;
        }
        if (state[source] == 2) {
            return true;
        }
        if (tnSet.contains(source)) {
            return true;
        }
        state[source] = 1;
        for (int a : adj[source]) {
            if (!dfs(a, adj, tnSet, state)) {
                return false;
            }
        }
        state[source] = 2;
        tnSet.add(source);
        return true;
    }
}