class Solution {
    public int rob(int[] nums) {
        int[][] dp=new int[nums.length][2];
        for(int i=0;i<nums.length;i++){
            dp[i][0]=-1;
            dp[i][1]=-1;

        }
        return memoization(dp, 0, nums, 1);
    }
    // recursve
    // public int recurse(int currIndex, int[] nums, boolean allowed){
    //     if(nums.length==currIndex)return 0;
    //     if(allowed){
    //         return Math.max(recurse(currIndex+1, nums, true), nums[currIndex]+recurse(currIndex+1, nums, false));
    //     }
    //     return recurse(currIndex+1, nums, true);
    // }

    public int memoization(int[][] dp, int currIndex, int[] nums, int allowed){
        if(nums.length==currIndex)return 0;
        if(dp[currIndex][allowed]!=-1)return dp[currIndex][allowed];
        if(allowed==1){
            return dp[currIndex][1]=Math.max(memoization(dp, currIndex+1, nums, 1), nums[currIndex]+memoization(dp, currIndex+1, nums, 0));
        }
        return dp[currIndex][0]=memoization(dp, currIndex+1, nums, 1);

    }
}