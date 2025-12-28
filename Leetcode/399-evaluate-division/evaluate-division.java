class Solution {

    class Pair {
        double w;
        String node;

        public Pair(double w, String node) {
            this.w = w;
            this.node = node;
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Pair>> adjMap = new HashMap<>();
        int index = 0;
        for (List<String> equation : equations) {
            double val = values[index++];
            adjMap.computeIfAbsent(equation.get(0), k -> new ArrayList<>()).add(new Pair(val, equation.get(1)));
            adjMap.computeIfAbsent(equation.get(1), k -> new ArrayList<>()).add(new Pair(1 / val, equation.get(0)));
        }

        double[] ans = new double[queries.size()];
        int in = 0;
        Set<String> visited = new HashSet<>();
        for (List<String> query : queries) {
            if (adjMap.get(query.get(0)) == null || adjMap.get(query.get(1)) == null) {
                ans[in++] = -1;
                continue;
            }
            double x = bfs(query.get(0), query.get(1), adjMap, visited);
            if (x < 0) {
                ans[in++] = -1;
            } else
                ans[in++] = x;
        }
        return ans;

    }

    private double bfs(String source, String destination, Map<String, List<Pair>> adjMap, Set<String> visited) {
        if (source.equals(destination)) {
            return 1.0;
        }
        if (visited.contains(source)) {
            return -1.0;
        }
        visited.add(source);

        for (Pair p : adjMap.get(source)) {
            double x = p.w * bfs(p.node, destination, adjMap, visited);
            if (x >= 0) {
                visited.remove(source);
                return x;
            }
        }
        visited.remove(source);
        return -1;
    }
}