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
        if (root == null)
            return null;

        // 1. Prune the left and right subtrees first (Post-order)
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        // 2. Decide if the current node should be pruned:
        // A node is pruned if its left and right subtrees are now null 
        // AND its own value is 0.
        if (root.val == 0 && root.left == null && root.right == null) {
            return null;
        }

        // Otherwise, keep this node
        return root;

    }

}