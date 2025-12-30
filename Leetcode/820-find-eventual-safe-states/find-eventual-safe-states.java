class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> list=new ArrayList<>();

        int[] state = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if(state[i]==2){
                list.add(i);
            }
            if (state[i] == 0 && dfs(i, graph, state)) {
                list.add(i);
            }
        }
        Collections.sort(list);
        return list;

    }

    public boolean dfs(int source, int[][] adj, int[] state) {
        if (state[source] == 1) {
            return false;
        }
        if (state[source] == 2) {
            return true;
        }
        state[source] = 1;
        for (int a : adj[source]) {
            if (!dfs(a, adj, state)) {
                return false;
            }
        }
        state[source] = 2;
        return true;
    }
}