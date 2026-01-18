class Solution {
    public String longestPalindrome(String s) {
        if(s.isEmpty())return "";
        int maxLen = 0;
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            int j = i - 1;
            int k = i + 1;
            while (k < s.length() && s.charAt(i) == s.charAt(k)) {
                k++;
            }

            while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
                j--;
                k++;
            }

            int len = k - j - 1;
            if (len > maxLen) {
                maxLen = len;
                ans = s.substring(j + 1, k);
            }

        }
        return ans;
    }
}