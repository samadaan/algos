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

    public List<Integer> largestValues(TreeNode root) {
        ans = new ArrayList<>();
        traverse(root, 0);
        return ans;
    }

    void traverse(TreeNode curr, int depth) {
        if (curr == null)
            return;
        if (depth == ans.size()) {
            ans.add(Integer.MIN_VALUE);
        }
        ans.set(depth, Math.max(curr.val, ans.get(depth)));
        traverse(curr.left, depth + 1);
        traverse(curr.right, depth + 1);

    }
}