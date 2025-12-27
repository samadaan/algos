class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] degreeArr = new int[n + 1];
        Arrays.fill(degreeArr, 0);
        int ans = -1;
        for (int[] x : trust) {
            degreeArr[x[0]]--;
            degreeArr[x[1]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (ans == -1 && degreeArr[i] == n - 1) {
                ans=i;
            } else if (degreeArr[i] == n - 1) {
                return -1;
            }
        }
        return ans;

    }
}