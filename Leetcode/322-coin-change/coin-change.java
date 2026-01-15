class Solution {
    int[] c;
    long[] memo;

    public int coinChange(int[] coins, int amount) {
        c = coins;
        memo=new long[amount+1];
        int val = (int) rec(amount);
        if (val == Integer.MAX_VALUE)
            return -1;
        return val;

    }

    public long rec(int remAmount) {
        if (remAmount < 0)
            return Integer.MAX_VALUE;
        if (remAmount == 0)
            return 0;
        if(memo[remAmount]!=0)return memo[remAmount];
        long min = Integer.MAX_VALUE;
        for (int i = 0; i < c.length; i++) {
            min = Math.min(min, rec(remAmount - c[i]));
        }
        memo[remAmount] = min == Integer.MAX_VALUE ? min : 1 + min;
        return memo[remAmount];
    }
}