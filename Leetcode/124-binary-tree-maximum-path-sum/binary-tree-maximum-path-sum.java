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
    int ans = Integer.MIN_VALUE;;

    public int maxPathSum(TreeNode root) {
        traverse(root);
        return ans;

    }

    private int traverse(TreeNode root) {
        if (root == null)
            return 0;
        int left = traverse(root.left);
        int right = traverse(root.right);

        ans = Math.max(ans, root.val);
        ans = Math.max(ans, left + root.val);
        ans = Math.max(ans, right + root.val);
        ans = Math.max(ans, left + right + root.val);

        return Math.max(root.val, Math.max(left + root.val, right + root.val));

    }
}