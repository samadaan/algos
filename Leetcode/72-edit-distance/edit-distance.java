class Solution {
    int[][] memo;

    public int minDistance(String word1, String word2) {
        if(word1.length()==0 || word2.length()==0){
            return Math.max(word1.length(), word2.length());
        }
        memo = new int[word1.length()+1][word2.length()+1];
        // for (int[] arr : memo) {
        //     Arrays.fill(arr, -1);
        // }
        int prevValue = 0;
        for (int i = word1.length(); i >= 0; i--) {
            memo[i][word2.length()] = prevValue++;
        }
        prevValue = 0;
        for (int i = word2.length(); i >= 0; i--) {
            memo[word1.length()][i] = prevValue++;
        }
        for (int sIndex = word1.length() - 1; sIndex >= 0; sIndex--) {
            for (int dIndex = word2.length() - 1; dIndex >= 0; dIndex--) {
                if (word1.charAt(sIndex) == word2.charAt(dIndex)) {
                    memo[sIndex][dIndex] = memo[sIndex + 1][dIndex + 1];
                } else {
                    int minVal = Math.min(memo[sIndex][dIndex + 1],
                            Math.min(memo[sIndex + 1][dIndex], memo[sIndex + 1][dIndex + 1]));
                    memo[sIndex][dIndex] = 1 + minVal;
                }
            }
        }
        // for(int i=0;i<word1.length();i++){
        //     for(int j=0;j<word2.length();j++){
        //         System.out.print(memo[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        return memo[0][0];
        // return recur(0, 0, word1, word2);
    }

    int recur(int sIndex, int dIndex, String word1, String word2) {
        if (sIndex == word1.length() && dIndex == word2.length())
            return 0;
        if (sIndex == word1.length())
            return word2.length() - dIndex;
        if (dIndex == word2.length())
            return word1.length() - sIndex;
        if (memo[sIndex][dIndex] != -1)
            return memo[sIndex][dIndex];
        if (word1.charAt(sIndex) == word2.charAt(dIndex))
            return memo[sIndex][dIndex] = recur(sIndex + 1, dIndex + 1, word1, word2);
        // Insert
        int val1 = recur(sIndex, dIndex + 1, word1, word2);
        // Delete
        int val2 = recur(sIndex + 1, dIndex, word1, word2);
        // Replace
        int val3 = recur(sIndex + 1, dIndex + 1, word1, word2);
        int min = Math.min(val1, Math.min(val2, val3));
        return memo[sIndex][dIndex] = 1 + min;
    }
}