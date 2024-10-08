class Solution {
    Set<String> words;
    public boolean wordBreak(String s, List<String> wordDict) {
        words=new HashSet<>(wordDict);
        //return recurse(0, words, s);
        // int[] dp=new int[s.length()];
        // Arrays.fill(dp,-1);
        // return memoization(dp, 0, words, s);
        return tabulate(words, s);
        
    }
    public boolean recurse(int currIndex, Set<String> words, String s){
        if(currIndex==s.length())return true;
        for(int j=currIndex+1; j<=s.length(); j++){
            if(words.contains(s.substring(currIndex, j)) && recurse(j, words, s)){
                return true;
            }
        }
        return false;
    }
    public boolean memoization(int[] dp, int currIndex, Set<String> words, String s){
        if(currIndex==s.length())return true;
        if(dp[currIndex]!=-1){
            if(dp[currIndex]==1)return true;
            return false;
        }
        for(int j=currIndex+1; j<=s.length(); j++){
            if(words.contains(s.substring(currIndex, j)) && memoization(dp, j, words, s)){
                dp[currIndex]=1;
                return true;
            }
        }
        dp[currIndex]=0;
        return false;
    }

    public boolean tabulate(Set<String> words, String s){
        int n=s.length();
        boolean[] dp=new boolean[s.length()+1];
        dp[n]=true;
        for(int i=n-1;i>=0;i--){
            for(int j=i+1;j<=n;j++){
                if(words.contains(s.substring(i,j)) && dp[j]){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[0];
    }
}