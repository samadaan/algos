class Solution {
    int[][] memo;

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        // Base cases: distance between string and empty string
        for (int i = 0; i <= m; i++)
            dp[i][0] = i;
        for (int j = 0; j <= n; j++)
            dp[0][j] = j;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // Min of (Insert, Delete, Replace) + 1
                    dp[i][j] = 1 + Math.min(dp[i][j - 1],
                            Math.min(dp[i - 1][j], dp[i - 1][j - 1]));
                }
            }
        }
        return dp[m][n];
    }

    int recur(int sIndex, int dIndex, String word1, String word2) {
        if (sIndex == word1.length() && dIndex == word2.length())
            return 0;
        if (sIndex == word1.length())
            return word2.length() - dIndex;
        if (dIndex == word2.length())
            return word1.length() - sIndex;
        if (memo[sIndex][dIndex] != -1)
            return memo[sIndex][dIndex];
        if (word1.charAt(sIndex) == word2.charAt(dIndex))
            return memo[sIndex][dIndex] = recur(sIndex + 1, dIndex + 1, word1, word2);
        // Insert
        int val1 = recur(sIndex, dIndex + 1, word1, word2);
        // Delete
        int val2 = recur(sIndex + 1, dIndex, word1, word2);
        // Replace
        int val3 = recur(sIndex + 1, dIndex + 1, word1, word2);
        int min = Math.min(val1, Math.min(val2, val3));
        return memo[sIndex][dIndex] = 1 + min;
    }
}