class Solution {
    Integer[][] memo;
    public int uniquePaths(int m, int n) {
        memo=new Integer[m][n];
        return recur(0, 0, m, n);
    }
    int recur(int i, int j, int m, int n){
        if(i>=m || j>=n)return 0;
        if(i==m-1 && j==n-1)return 1;
        if(memo[i][j]!=null)return memo[i][j];
        return memo[i][j]=recur(i+1, j, m, n) + recur(i, j+1, m, n);
    }
}