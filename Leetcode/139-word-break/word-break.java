class Solution {
    Boolean[] memo;
    Set<String> set;
    public boolean wordBreak(String s, List<String> wordDict) {
        set=new HashSet<>(wordDict);
        memo=new Boolean[s.length()];
        return rec(s, 0);

        
    }
    public boolean rec(String s, int start){
        // System.out.println(s+" "+start);
        if(start==s.length())return true;

        if(memo[start]!=null)return memo[start];

        for(int i=start+1; i<=s.length();i++){
            // System.out.println(i);
            if(set.contains(s.substring(start, i)) && rec(s, i)){
                return memo[start]=true;
            }
        }
        return memo[start]=false;
    }
}