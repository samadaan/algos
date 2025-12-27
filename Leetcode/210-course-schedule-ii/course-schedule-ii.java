class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] indegree=new int[numCourses];
        List<Integer>[] adj=new ArrayList[numCourses];

        for(int i=0;i<numCourses;i++){
            adj[i]=new ArrayList<>();
        }

        for(int[] pre:prerequisites){
            indegree[pre[0]]++;
            adj[pre[1]].add(pre[0]);
        }
        int[] ans=new int[numCourses];
        int index=0;
        Queue<Integer> queue=new LinkedList<>();

        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0)queue.offer(i);
        }

        while(!queue.isEmpty()){
            Integer node=queue.remove();
            ans[index++]=node;
            for(Integer x:adj[node]){
                indegree[x]--;
                if(indegree[x]==0){
                    queue.add(x);
                }
            }
        }
        if(index!=numCourses){
            return new int[0];
        }
        return ans;

        
    }
}