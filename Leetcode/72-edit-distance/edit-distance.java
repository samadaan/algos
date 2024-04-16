class Solution {
    String s1;
    String s2;
    public int minDistance(String word1, String word2) {
        s1=word1;
        s2=word2;
        // return recurse(word1.length()-1, word2.length()-1);
        return tabulation();
    }
    public int recurse(int i, int j){
        if(i<0 || j<0){
            if(i<0)return j+1;
            return i+1;
        }
        if(s1.charAt(i)==s2.charAt(j)){
            return recurse(i-1, j-1);
        }
        return   1+ Math.min(recurse(i-1, j-1), Math.min(recurse(i, j-1), recurse(i-1, j)));
    }

    public int tabulation(){
        int[] prev=new int[s2.length()+1];
        for(int i=0;i<=s2.length();i++){
            prev[i]=i;
        }
        for(int i=1;i<=s1.length();i++){
            int[] curr=new int[s2.length()+1];
            curr[0]=i;
            for(int j=1;j<=s2.length();j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    curr[j]=prev[j-1];
                }else{
                    curr[j]=1+Math.min(prev[j-1], Math.min(prev[j], curr[j-1]));
                }
            }
            prev=curr;
        }
        return prev[s2.length()];
    }
}