class Solution {
    int[] arr;
    public int minCost(int n, int[] cuts) {
        arr=new int[cuts.length+2];
        arr[0]=0;
        arr[arr.length-1]=n;
        for(int i=1;i<arr.length-1;i++){
            arr[i]=cuts[i-1];
        }
        Arrays.sort(arr);
        int[][] dp=new int[arr.length][arr.length];
        for(int[] d:dp){
            Arrays.fill(d, -1);
        }
        return memoization(1, arr.length-2, dp);



        
    }
    public int recurse(int i, int j){
        if(i>j)return 0;
        int min=(int)1e9;
        for(int k=i;k<=j;k++){
            min=Math.min(min, arr[j+1]-arr[i-1]+recurse(i, k-1)+recurse(k+1, j));
        }
        return min;
    }

    public int memoization(int i, int j, int[][] dp){
        if(i>j)return 0;
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int min=(int)1e9;
        for(int k=i;k<=j;k++){
            min=Math.min(min, arr[j+1]-arr[i-1]+memoization(i, k-1, dp)+memoization(k+1, j, dp));
        }
        return dp[i][j] = min;
    }
}