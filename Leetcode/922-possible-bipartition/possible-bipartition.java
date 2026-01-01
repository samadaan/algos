class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<Integer>[] adjList = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int[] d : dislikes) {
            adjList[d[0]].add(d[1]);
            adjList[d[1]].add(d[0]);
        }
        int[] state = new int[n+1];
        for (int i = 1; i <= n; i++) {
            if(state[i]==0 && canNotdivide(i, adjList, state, 1)){
                return false;
            }  
        }
        return true;
    }

    private boolean canNotdivide(int source, List<Integer>[] adjList, int[] state, int prevValue) {
        if (state[source] != 0) {
            return state[source] == prevValue;
        }
        state[source] = -1 * prevValue;
        //System.out.println("source "+source+" state[source] "+state[source]);
        for (Integer adj : adjList[source]) {
            if (canNotdivide(adj, adjList, state, state[source])) {
                return true;
            }
        }
        return false;

    }
}