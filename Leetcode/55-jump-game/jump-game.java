class Solution {
    Boolean memo[];
    public boolean canJump(int[] nums) {
        memo=new Boolean[nums.length];
        return recur(0, nums);
    }
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