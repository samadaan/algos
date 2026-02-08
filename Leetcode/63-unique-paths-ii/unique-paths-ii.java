class Solution {
    int m, n;
    int[][] nums;
    int[][] memo;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        m = obstacleGrid.length;
        n = obstacleGrid[0].length;
        nums = obstacleGrid;
        memo = new int[m][n];
        // return recur(0, 0);
        boolean a = true;
        for (int i = m - 1; i >= 0; i--) {
            if (nums[i][n - 1] == 1) {
                break;
            }
            memo[i][n-1]=1;
        }
        for (int i = n - 1; i >= 0; i--) {
            if (nums[m - 1][i] == 1) {
                break;
            }
            memo[m-1][i]=1;
            
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (nums[i][j] == 1) {
                    memo[i][j] = 0;
                } else {
                    memo[i][j] = memo[i + 1][j] + memo[i][j + 1];
                }
            }
        }
        return memo[0][0];
    }

    // int recur(int i, int j) {
    //     if (i >= m || j >= n)
    //         return 0;
    //     if (memo[i][j] != null)
    //         return memo[i][j];
    //     if (nums[i][j] == 1)
    //         return memo[i][j] = 0;
    //     if (i == m - 1 && j == n - 1)
    //         return 1;
    //     return memo[i][j] = recur(i + 1, j) + recur(i, j + 1);
    // }
}