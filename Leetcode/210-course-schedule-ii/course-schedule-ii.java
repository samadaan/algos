class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Stack<Integer> stack=new Stack<>();

        List<Integer>[] adj=new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++)adj[i]=new ArrayList<>();

        for(int[] pre: prerequisites){
            adj[pre[0]].add(pre[1]);
        }

        int[] state=new int[numCourses];

        for(int i=0;i<numCourses;i++){
            if(!topologicalDfs(i, adj, state, stack)){
                return new int[0];
            }
        }

        int[] ans=new int[numCourses];
        int i=numCourses-1;
        while(!stack.isEmpty()){
            ans[i--]=stack.pop();
        }
        return ans;
        
    }
    private boolean topologicalDfs(int source, List<Integer>[] adj, int[] state, Stack<Integer> stack){
        if(state[source]==1){
            return false;
        }
        if(state[source]==2){
            return true;
        }
        state[source]=1;
        for(Integer node:adj[source]){
            if(!topologicalDfs(node, adj, state, stack)){
                return false;
            }
        }
        state[source]=2;
        stack.push(source);
        return true;
    }
}