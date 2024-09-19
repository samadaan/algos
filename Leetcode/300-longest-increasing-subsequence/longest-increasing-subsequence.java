class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp, 1);
        int ans=1;
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    if(1+dp[j]>dp[i]){
                        dp[i]=1+dp[j];
                        ans=Math.max(ans, dp[i]);
                    }
                }
            }
        }
        return ans;
    }
}