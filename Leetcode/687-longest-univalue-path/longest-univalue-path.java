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

    public int longestUnivaluePath(TreeNode root) {
        ans = 1;
        int a = traverse(root);
        ans = Math.max(a, ans);
        return ans - 1;
    }

    int traverse(TreeNode curr) {
        if (curr == null)
            return 0;
        if (curr.left == null && curr.right == null) {
            return 1;
        }

        int l = traverse(curr.left);
        int r = traverse(curr.right);
        int c = 1;
        if (curr.left != null && curr.right != null && curr.val == curr.left.val && curr.val == curr.right.val) {
            ans = Math.max(c + l + r, ans);
            c += Math.max(l, r);
            return c;

        } else if (curr.left != null && curr.val == curr.left.val) {
            c += l;
        } else if (curr.right != null && curr.val == curr.right.val) {
            c += r;
        }
        ans = Math.max(c, ans);
        return c;

    }
}