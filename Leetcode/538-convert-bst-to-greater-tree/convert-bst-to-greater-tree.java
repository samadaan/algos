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
    int prevSum;

    public TreeNode convertBST(TreeNode root) {
        prevSum = 0;
        traverse(root);
        return root;
    }

    void traverse(TreeNode curr) {
        if (curr == null)
            return;
        traverse(curr.right);
        prevSum += curr.val;
        curr.val = prevSum;
        traverse(curr.left);

    }
}