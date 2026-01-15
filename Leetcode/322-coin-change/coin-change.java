class Solution {
    int[] c;
    long[] memo;

    public int coinChange(int[] coins, int amount) {
        // c = coins;
        // memo=new long[amount+1];
        // int val = (int) rec(amount);
        // if (val == Integer.MAX_VALUE)
        //     return -1;
        // return val;

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int am = 1; am <= amount; am++) {
            for (int i = 0; i < coins.length; i++) {
                if (am - coins[i] >= 0 && dp[am - coins[i]] != Integer.MAX_VALUE) {
                    dp[am] = Math.min(dp[am], 1 + dp[am - coins[i]]);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];

    }

    public long rec(int remAmount) {
        if (remAmount < 0)
            return Integer.MAX_VALUE;
        if (remAmount == 0)
            return 0;
        if (memo[remAmount] != 0)
            return memo[remAmount];
        long min = Integer.MAX_VALUE;
        for (int i = 0; i < c.length; i++) {
            min = Math.min(min, rec(remAmount - c[i]));
        }
        memo[remAmount] = min == Integer.MAX_VALUE ? min : 1 + min;
        return memo[remAmount];
    }
}