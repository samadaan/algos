class Solution {
    static int[] dp;
    public int rob(int[] nums) {
        dp=new int[nums.length];
        Arrays.fill(dp,-1);
        return recurse(nums, 0);
    }
    public int recurse(int[] nums, int currIndex){
        if(currIndex>=nums.length)return 0;
        if(dp[currIndex]!=-1)return dp[currIndex];
        int taken=nums[currIndex]+recurse(nums,currIndex+2);
        int notTaken=recurse(nums,currIndex+1);
        dp[currIndex] = Math.max(taken, notTaken);
        return dp[currIndex];
    }
}
