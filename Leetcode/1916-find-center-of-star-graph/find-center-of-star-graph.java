class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length + 1;
        int[] arr = new int[n + 1];
        for (int[] edge : edges) {
            arr[edge[0]]++;
            if (arr[edge[0]] == n - 1) {
                return edge[0];
            }
            arr[edge[1]]++;
            if (arr[edge[1]] == n - 1) {
                return edge[1];
            }
        }
        return -1;

    }
}