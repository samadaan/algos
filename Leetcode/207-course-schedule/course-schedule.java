class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<Integer>[] adj = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++)
            adj[i] = new ArrayList<>();

        for (int[] pre : prerequisites) {
            indegree[pre[1]]++;
            adj[pre[0]].add(pre[1]);
        }

        Queue<Integer> queue = new LinkedList<>();
        int num = 0;

        for (int i=0;i<numCourses;i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        

        while (!queue.isEmpty()) {
            int node = queue.poll();
            num++;
            for (int x : adj[node]) {
                indegree[x]--;
                if (indegree[x] == 0) {
                    // System.out.println("x "+x);
                    queue.offer(x);
                }
            }
        }

        // System.out.println("num "+num);

        return num == numCourses;

    }
}