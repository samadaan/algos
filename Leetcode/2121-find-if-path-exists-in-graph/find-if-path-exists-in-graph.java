class Solution {
    private Map<Integer, List<Integer>> adjMap;
    private Set<Integer> visited;

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        adjMap = new HashMap<>();
        visited = new HashSet<>();
        for (int[] edge : edges) {
            adjMap.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            adjMap.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        return dfs(source, destination);
    }

    private boolean dfs(int source, int destination) {
        if (source == destination)
            return true;
        if (visited.contains(source))
            return false;
        visited.add(source);
        for (Integer adj : adjMap.get(source)) {
            if (dfs(adj, destination)) {
                return true;
            }
        }
        return false;
    }

}