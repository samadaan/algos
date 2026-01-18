class Solution {
    String ans;
    int maxLen;
    int[][] memo;

    public String longestPalindrome(String s) {
        maxLen = 0;
        ans = "";
        memo = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                memo[i][j] = -1;
            }
        }
        recur(0, s.length() - 1, s);
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