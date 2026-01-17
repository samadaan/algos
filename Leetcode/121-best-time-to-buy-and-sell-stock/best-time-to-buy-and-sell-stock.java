class Solution {
    int[] arr;
    Integer[][] dp;

    public int maxProfit(int[] prices) {
        arr = prices;
        dp = new Integer[prices.length][2];
        return recur(0, 1);

    }

    public int recur(int index, int canBuy) {
        if (index >= arr.length)
            return 0;
        if (dp[index][canBuy] != null) {
            return dp[index][canBuy];
        }
        if (canBuy == 1) {
            int buy = -arr[index] + recur(index + 1, 0);
            int notbuy = recur(index + 1, 1);
            return dp[index][1] = Math.max(buy, notbuy);
        } else {
            int sell = arr[index];
            int notsell = recur(index + 1, 0);
            return dp[index][0] = Math.max(sell, notsell);
        }

    }
}