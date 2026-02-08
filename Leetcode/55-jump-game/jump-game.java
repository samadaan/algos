class Solution {
    Boolean memo[];
    public boolean canJump(int[] nums) {
        boolean[] dp=new boolean[nums.length];
        dp[nums.length-1]=true;
        int reach=nums.length-1;
        for(int i=nums.length-2;i>=0;i--){
            if(i+nums[i]>=reach){
                reach=i;
                dp[i]=true;
            }
        }
        return dp[0];
    }
    // O(n^2)
    boolean recur(int index, int[] nums){
        if(index>=nums.length)return false;
        if(index==nums.length-1)return true;
        if(memo[index]!=null)return memo[index];

        for(int i=index+1;i<=index+nums[index];i++){
            if(recur(i, nums)){
                memo[index]=true;
                return true;
            }
        }
        memo[index]=false;
        return false;
    }
}