class Solution {
    static int[] dp;
    public int rob(int[] nums) {
        if(nums.length==1)return nums[0];
        dp=new int[nums.length];
        dp[nums.length-1]=nums[nums.length-1];
        dp[nums.length-2]=Math.max(nums[nums.length-1], nums[nums.length-2]);
        for(int i=nums.length-3; i>=0;i--){
            dp[i]=Math.max(dp[i+1], nums[i]+dp[i+2]);
        }
        return dp[0];
    }
    // public int recurse(int[] nums, int currIndex){
    //     if(currIndex>=nums.length)return 0;
    //     if(dp[currIndex]!=-1)return dp[currIndex];
    //     int taken=nums[currIndex]+recurse(nums,currIndex+2);
    //     int notTaken=recurse(nums,currIndex+1);
    //     dp[currIndex] = Math.max(taken, notTaken);
    //     return dp[currIndex];
        
    // }
}
