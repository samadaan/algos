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
    Map<String, Integer> freqMap;
    List<TreeNode> ans;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        freqMap = new HashMap<>();
        ans = new ArrayList<>();
        serialize(root);
        return ans;
    }

    private String serialize(TreeNode curr) {
        if (curr == null)
            return "#";

        String ser = curr.val + "," + serialize(curr.left) + "," + serialize(curr.right);

        int freq = freqMap.getOrDefault(ser, 0) + 1;

        if (freq == 2) {
            ans.add(curr);
        }

        freqMap.put(ser, freq);
        return ser;
    }

}