
class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            // ans[i >> 1] is i/2. (i & 1) is 1 if odd, 0 if even.
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }
}
