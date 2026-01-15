class Solution {
    // int[] c;
    // long[] memo;

    public int coinChange(int[] coins, int amount) {
        int max = amount + 1; // Faster than Integer.MAX_VALUE to avoid overflow logic
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}