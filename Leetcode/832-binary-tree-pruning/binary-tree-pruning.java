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
    public TreeNode pruneTree(TreeNode root) {
        int val = traverse(root);
        if (val == 0)
            return null;
        return root;

    }

    public int traverse(TreeNode root) {
        if (root == null)
            return 0;
        int left = traverse(root.left);
        int right = traverse(root.right);

        if (left == 0) {
            root.left = null;
        }
        if (right == 0) {
            root.right = null;
        }
        if (left == 0 && right == 0) {
            return root.val;
        }
        return 1;
    }

}