class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> words=new HashSet<>(wordDict);

        boolean[] dp=new boolean[s.length()+1];
        dp[0]=true;
        for(int len=1;len<=s.length();len++){
            for(int i=0;i<len;i++){
                if(dp[i] && words.contains(s.substring(i, len))){
                    dp[len]=true;
                    break;
                }
            }
        }
        return dp[s.length()];
        
    }
}