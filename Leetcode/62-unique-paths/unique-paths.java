class Solution {
    Integer[][] memo;
    public int uniquePaths(int m, int n) {
        memo=new Integer[m][n];
        // return recur(0, 0, m, n);
        for(int i=0;i<n;i++){
            memo[m-1][i]=1;
        }
        for(int i=0;i<m;i++){
            memo[i][n-1]=1;
        }
        for(int i=m-2;i>=0;i--){
            for(int j=n-2;j>=0;j--){
                memo[i][j]=memo[i+1][j]+memo[i][j+1];
            }
        }
        return memo[0][0];
    }
    // O(n^2) memoization
    int recur(int i, int j, int m, int n){
        if(i>=m || j>=n)return 0;
        if(i==m-1 && j==n-1)return 1;
        if(memo[i][j]!=null)return memo[i][j];
        return memo[i][j]=recur(i+1, j, m, n) + recur(i, j+1, m, n);
    }
}