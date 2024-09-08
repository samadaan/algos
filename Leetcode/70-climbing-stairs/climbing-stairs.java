class Solution {
    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        for(int i=0;i<dp.length;i++){
            dp[i]=-1;
        }
        return climbStairs(dp, n);
    }
    // recurisve solution
    //     if(n==0)return 1;
    //     if(n<0)return 0;
    //     return climbStairs(n-1)+climbStairs(n-2);

    // memoization
    public int climbStairs(int[] dp, int n){
        if(n==0)return 1;
        if(n<0)return 0;
        if(dp[n]!=-1)return dp[n];
        return dp[n]=climbStairs(dp, n-1)+climbStairs(dp, n-2);
    }

}