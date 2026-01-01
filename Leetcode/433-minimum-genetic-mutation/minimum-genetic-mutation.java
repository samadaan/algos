class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int ans = 0;
        queue.add(startGene);
        visited.add(startGene);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String s = queue.poll();
                if (s.equals(endGene)) {
                    return ans;
                }
                for (String x : bank) {
                    if (!visited.contains(x) && charDiff(s, x) == 1) {
                        queue.add(x);
                        visited.add(x);
                    }
                }
            }
            ans++;
        }
        return -1;

    }

    private int charDiff(String a, String b) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
            }
        }
        return count;
    }
}