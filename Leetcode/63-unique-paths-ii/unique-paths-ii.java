class Solution {
    int m, n;
    int[][] nums;
    Integer[][] memo;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        m = obstacleGrid.length;
        n = obstacleGrid[0].length;
        nums = obstacleGrid;
        memo = new Integer[m][n];
        return recur(0, 0);
    }

    int recur(int i, int j) {
        if (i >= m || j >= n)
            return 0;
        if (memo[i][j] != null)
            return memo[i][j];
        if (nums[i][j] == 1)
            return memo[i][j] = 0;
        if (i == m - 1 && j == n - 1)
            return 1;
        return memo[i][j] = recur(i + 1, j) + recur(i, j + 1);
    }
}