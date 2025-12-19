class Solution {
    int[][] dp;
    public int numTrees(int n) {
        dp=new int[n+1][n+1];
        return genTrees(1, n);
    }
    public int genTrees(int leftVal, int rightVal){
        if(leftVal>=rightVal)return 1;
        if(dp[leftVal][rightVal]!=0)return dp[leftVal][rightVal];
        int sum=0;
        for(int i=leftVal;i<=rightVal;i++){
            sum+=genTrees(leftVal, i-1)*genTrees(i+1, rightVal);
        }
        dp[leftVal][rightVal]=sum;
        return dp[leftVal][rightVal];
    }
}