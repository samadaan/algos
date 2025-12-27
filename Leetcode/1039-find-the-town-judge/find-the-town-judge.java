class Solution {
    
    public int findJudge(int n, int[][] trust) {
        Map<Integer, List<Integer>> adjMap = new HashMap<>();

        for(int[] x: trust){
            List<Integer> adj = adjMap.getOrDefault(x[0], new ArrayList<>());
            adj.add(x[1]);
            adjMap.put(x[0], adj);
        }
        int ans=1;
        Set<Integer> noOutEdgeSet = new HashSet<>();
        for(int i=1;i<=n;i++){
            if(adjMap.get(i)==null){
                noOutEdgeSet.add(i);
            }
        }
        // System.out.println(noOutEdgeSet);
        if(noOutEdgeSet.size()!=1){
            return -1;
        }
        for(Map.Entry<Integer, List<Integer>> entry:adjMap.entrySet()){
            boolean found=false;
            for(Integer adj:entry.getValue()){
                if(noOutEdgeSet.contains(adj)){
                    ans=adj;
                    found=true;
                }
            }
            if(!found){
                return -1;
            }
        }
        return ans;
    }
}