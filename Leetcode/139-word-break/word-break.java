class Solution {
    Set<String> words;
    Map<String, Boolean> dp;
    String str;
    public boolean wordBreak(String s, List<String> wordDict) {
        words=new HashSet<>(wordDict);
        int n=s.length();
        boolean[][] dp=new boolean[n][n];
        for(int i=0;i<n;i++){
            if(words.contains(s.substring(i, i+1)))dp[i][i]=true;
        }
        // if(n==1)return dp[0][0];
        for(int len=2;len<=n;len++){
            for(int i=0;i<=n-len;i++){
                int j=i+len-1;
                if(words.contains(s.substring(i, j+1))){
                    dp[i][j]=true;
                    continue;
                }
                for(int x=i;x<j;x++){
                    if(dp[i][x] && dp[x+1][j]){
                        dp[i][j]=true;
                        break;
                    }
                }
            }
        }
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         System.out.print(dp[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        return dp[0][n-1];
    }
    
    
    
    
    
    
    
    
    
    public boolean recur(int startIndex, int endIndex){
        if(startIndex>endIndex)return false;
        String x=str.substring(startIndex, endIndex);
        if(dp.containsKey(x))return dp.get(x);
        // System.out.println(x);
        if(words.contains(x))return true;
        for(int i=startIndex;i<endIndex;i++){
            if(recur(startIndex, i) && recur(i, endIndex)){
                dp.put(x, true);
                return true;
            }
        }
        dp.put(x, false);
        return false;
    }
}