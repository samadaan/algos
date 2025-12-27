class Solution {
    List<Integer>[] adjList;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        adjList=new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++){
            adjList[i]=new ArrayList<>();
        }
        for(int[] pre:prerequisites){
            adjList[pre[0]].add(pre[1]);
        }

        int[] state=new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (checkCycle(i, state)) {
                return false;
            }
        }
        return true;

    }

    public boolean checkCycle(int source, int[] state) {
        if(state[source]==1)return true;
        if(state[source]==2)return false;
        state[source]=1;
        for (Integer x : adjList[source]) {
            if (checkCycle(x, state)) {
                return true;
            }
        }
        state[source]=2;
        return false;
    }
}