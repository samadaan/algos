class Solution {
    Set<String> words;
    Map<String, Boolean> dp;
    String str;
    public boolean wordBreak(String s, List<String> wordDict) {
        words=new HashSet<>(wordDict);
        str=s;
        dp=new HashMap<>();
        return recur(0, str.length());
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