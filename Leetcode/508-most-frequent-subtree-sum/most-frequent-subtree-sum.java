/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> ans;
    int maxFreq;
    Map<Integer, Integer> sumFreqMap;

    public int[] findFrequentTreeSum(TreeNode root) {
        sumFreqMap = new HashMap<>();
        maxFreq = 0;
        ans = new ArrayList<>();
        sum(root);
        int[] a = new int[ans.size()];
        for (int i = 0; i < a.length; i++) {
            a[i] = ans.get(i);
        }
        return a;
    }

    int sum(TreeNode curr) {
        if (curr == null)
            return 0;
        int left = sum(curr.left);
        int right = sum(curr.right);
        int sum = curr.val + left + right;
        int freq = sumFreqMap.getOrDefault(sum, 0) + 1;
        if (freq > maxFreq) {
            maxFreq = freq;
            ans = new ArrayList<>();
            ans.add(sum);
        } else if (freq == maxFreq) {
            ans.add(sum);
        }
        sumFreqMap.put(sum, freq);
        return sum;
    }
}