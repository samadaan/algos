class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        int[] indegree = new int[n];

        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();

        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
            indegree[edge[0]]++;
            indegree[edge[1]]++;

        }

        Queue<Integer> queue=new LinkedList<>();

        for(int i=0;i<n;i++){
            if(indegree[i]<=1){
                queue.add(i);
            }
        }

        List<Integer> ans=new ArrayList<>();

        while(!queue.isEmpty()){
            int size=queue.size();
            ans.clear();
            while(size-- >0){
                int c=queue.poll();
                ans.add(c);
                for(Integer sib:adj[c]){
                    indegree[sib]--;
                    if(indegree[sib]==1){
                        queue.add(sib);
                    }
                }
            }
        }

        return ans;

    }
}