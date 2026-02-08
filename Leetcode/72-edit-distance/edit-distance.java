class Solution {
    int[][] memo;
    public int minDistance(String word1, String word2) {
        memo=new int[word1.length()][word2.length()];
        for(int[] arr : memo){
            Arrays.fill(arr, -1);
        }
        return recur(0, 0, word1, word2);
    }

    int recur(int sIndex, int dIndex, String word1, String word2) {
        if (sIndex == word1.length() && dIndex == word2.length())
            return 0;
        if (sIndex == word1.length())
            return word2.length() - dIndex;
        if (dIndex == word2.length())
            return word1.length() - sIndex;
        if(memo[sIndex][dIndex]!=-1)
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