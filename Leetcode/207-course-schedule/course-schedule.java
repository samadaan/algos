class Solution {
    Map<Integer, List<Integer>> adjMap;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        adjMap = new HashMap<>();
        for (int[] pre : prerequisites) {
            adjMap.computeIfAbsent(pre[0], k -> new ArrayList<>()).add(pre[1]);
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
        for (Integer x : adjMap.getOrDefault(source, new ArrayList<>())) {
            if (checkCycle(x, state)) {
                return true;
            }
        }
        state[source]=2;
        return false;
    }
}