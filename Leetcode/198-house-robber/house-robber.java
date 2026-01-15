class Solution {
    int[][] dp;

    public int rob(int[] nums) {
        dp = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        return rec(nums, 0, 1);

    }

    int rec(int[] nums, int currIndex, int canChoose) {
        if (currIndex >= nums.length)
            return 0;
        if (dp[currIndex][canChoose] != -1)
            return dp[currIndex][canChoose];
        if (canChoose == 1) {
            int val1 = nums[currIndex] + rec(nums, currIndex + 1, 0);
            int val2 = rec(nums, currIndex + 1, 1);
            return dp[currIndex][canChoose] = Math.max(val1, val2);
        }
        return dp[currIndex][canChoose] = rec(nums, currIndex + 1, 1);

    }
}