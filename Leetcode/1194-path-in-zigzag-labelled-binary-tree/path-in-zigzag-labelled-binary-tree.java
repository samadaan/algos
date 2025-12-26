class Solution {
    int[][] dp;
    public List<Integer> pathInZigZagTree(int label) {
        dp=new int[label][2];
        List<Integer> ans = new ArrayList<>();
        while (label != 0) {
            ans.add(0, label);
            label = label / 2;
        }

        correct(ans);
        return ans;

    }

    private void correct(List<Integer> ans) {
        if (ans.size() % 2 == 0) {
            for (int i = 1; i < ans.size() - 1; i++) {
                if (i % 2 == 0) {
                    int h = i + 1;
                    int[] bounds = getBounds(h);
                    int diff = ans.get(i) - bounds[0];
                    int val = bounds[1] - diff;
                    ans.set(i, val);
                }
            }
        } else {
            for (int i = 1; i < ans.size() - 1; i++) {
                if (i % 2 == 1) {
                    int h = i + 1;
                    int[] bounds = getBounds(h);
                    int diff = ans.get(i) - bounds[0];
                    int val = bounds[1] - diff;
                    ans.set(i, val);
                }
            }

        }
    }

    private int[] getBounds(int x) {
        if (x == 2) {
            return new int[] { 2, 3 };
        }
        if(dp[x][0]!=0 && dp[x][1]!=0){
            return dp[x];
        }
        return dp[x] = new int[] { 2 * getBounds(x - 1)[0], 2 * getBounds(x - 1)[1] + 1 };
    }
}