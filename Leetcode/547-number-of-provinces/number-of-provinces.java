class Solution {
    public int findCircleNum(int[][] isConnected) {
        int[] state=new int[isConnected.length];
        int count=0;
        for(int i=0;i<isConnected.length;i++){
            if(state[i]==0){
                dfs(i, isConnected, state);
                count++;
            }
        }
        return count;
        
    }

    private void dfs(int source, int[][] adj, int[] state){
        if(state[source]==1)return;
        state[source]=1;
        for(int i=0;i<adj[source].length;i++){
            if(adj[source][i]==1){
                dfs(i, adj, state);
            }
        }
        return;
    }
}