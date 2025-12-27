class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] degreeArr = new int[n + 1];
        for (int[] x : trust) {
            degreeArr[x[0]]--;
            degreeArr[x[1]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (degreeArr[i] == n - 1) {
                return i;
            }
        }
        return -1;

    }
}