class Solution {
    String ans;
    int maxLen;
    int[][] memo;

    public String longestPalindrome(String s) {
        // maxLen = 0;
        // ans = "";
        // memo = new int[s.length()][s.length()];
        // for (int i = 0; i < s.length(); i++) {
        //     for (int j = 0; j < s.length(); j++) {
        //         memo[i][j] = -1;
        //     }
        // }
        // recur(0, s.length() - 1, s);
        // return ans;
        if(s.isEmpty())return "";
        int maxLen=0;
        String ans=s.substring(0,1);
        int[][] dp=new int[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            dp[i][i]=1;
        }
        for(int len=2;len<=s.length();len++){
            for(int i=0;i<=s.length()-len;i++){
                int j=i+len-1;
                if(s.charAt(i)==s.charAt(j) && isPalindrome(s, i, j)){
                    if(j-i+1>maxLen){
                        maxLen=j-i+1;
                        ans=s.substring(i, j+1);
                    }
                    dp[i][j]=j-i+1;
                }else{
                    dp[i][j]=Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return ans;
    }
    public int recur(int startIndex, int endIndex, String s) {
        if (startIndex >= s.length() || endIndex >= s.length() || startIndex < 0 || endIndex < 0)
            return 0;
        if (startIndex == endIndex){
            if(maxLen==0){
                maxLen=1;
                ans=s.substring(startIndex, endIndex+1);
            }
            return memo[startIndex][endIndex]=1;
        }
        if (memo[startIndex][endIndex] != -1)
            return memo[startIndex][endIndex];
        if (s.charAt(startIndex) == s.charAt(endIndex) && isPalindrome(s, startIndex + 1, endIndex - 1)) {
            if (endIndex - startIndex + 1 > maxLen) {
                maxLen = endIndex - startIndex + 1;
                ans = s.substring(startIndex, endIndex + 1);
            }
            return memo[startIndex][endIndex] = endIndex - startIndex + 1;
        }
        return memo[startIndex][endIndex] = Math.max(recur(startIndex + 1, endIndex, s),
                recur(startIndex, endIndex - 1, s));

    }

    public boolean isPalindrome(String s, int startIndex, int endIndex) {
        // System.out.println("startIndex "+startIndex+" endIndex "+endIndex);
        while (endIndex > startIndex) {
            if (s.charAt(startIndex) != s.charAt(endIndex)) {
                return false;
            }
            startIndex++;
            endIndex--;
        }
        // System.out.println("startIndex "+startIndex+" endIndex "+endIndex + " palindrome ");
        return true;
    }
}