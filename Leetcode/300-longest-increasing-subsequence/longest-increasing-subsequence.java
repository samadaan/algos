class Solution {
    int[] n;
    int len;
    Integer[][] memo;

    public int lengthOfLIS(int[] nums) {
        n = nums;
        len = nums.length;
        memo = new Integer[nums.length][nums.length + 1];
        return recur(0, -1);

    }

    public int recur(int index, int prevIndex) {
        if (index >= len) {
            return 0;
        }
        if (memo[index][prevIndex + 1] != null) {
            return memo[index][prevIndex + 1];
        }
        int len = recur(index + 1, prevIndex);
        if (prevIndex == -1 || n[index] > n[prevIndex]) {
            len = Math.max(len, 1 + recur(index + 1, index));
        }
        return memo[index][prevIndex + 1] = len;
    }
}