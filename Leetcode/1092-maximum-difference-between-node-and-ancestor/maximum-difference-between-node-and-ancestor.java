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
    int ans;

    public int maxAncestorDiff(TreeNode root) {
        ans = Integer.MIN_VALUE;
        traverse(root);
        return ans;

    }

    private int[] traverse(TreeNode curr) {
        if (curr == null) {
            return new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE };
        }
        if (curr.left == null && curr.right == null) {
            return new int[] { curr.val, curr.val };
        }
        int[] left = traverse(curr.left);
        int[] right = traverse(curr.right);
        int min = Math.min(left[0], right[0]);
        int max = Math.max(left[1], right[1]);
        int f[] = { min, max };

        ans = Math.max(ans, Math.abs(curr.val - f[0]));
        ans = Math.max(ans, Math.abs(curr.val - f[1]));

        return new int[] { Math.min(curr.val, f[0]), Math.max(curr.val, f[1]) };

    }
}