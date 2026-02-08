class Solution {
    int ans;

    public int maxSubArray(int[] nums) {
        ans = Integer.MIN_VALUE;
        recur(0, 0, nums);
        return ans;
    }

    void recur(int index, int prevSum, int[] nums) {
        if (index == nums.length)
            return;
        int currSum = prevSum + nums[index];
        ans = Math.max(ans, currSum);
        if (currSum >= 0) {
            recur(index + 1, currSum, nums);
        } else {
            recur(index + 1, 0, nums);
        }

    }
}