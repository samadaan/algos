class Solution {
    int[][] dp;

    public int rob(int[] nums) {
        // dp = new int[nums.length][2];
        // for (int i = 0; i < nums.length; i++) {
        //     dp[i][0] = -1;
        //     dp[i][1] = -1;
        // }
        // return rec(nums, 0, 1);
        int n=nums.length-1;
        // dp[n][0]=0;
        // dp[n][1]=nums[n];
        // for(int i=n-2;i>=0;i--){
        //     dp[i][0]=dp[i+1][1];
        //     dp[i][1]=Math.max(nums[i]+dp[i+1][0], dp[i+1][1]);
        // }
        // return dp[0][1];

        // int[][] ndp=new int[2][2];
        // ndp[1][0]=0;
        // ndp[1][1]=nums[n];
        int canChoose=nums[n];
        int canNotChoose=0;

        for(int i=n-1;i>=0;i--){
            int canNotChoose1=canChoose;
            int canChoose1=Math.max(nums[i]+canNotChoose, canChoose);
            // System.out.println("i "+i+" canNotChoose1 "+ canNotChoose1+" canChoose1 "+canChoose1);
            canChoose=canChoose1;
            canNotChoose=canNotChoose1;
        }
        return canChoose;

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