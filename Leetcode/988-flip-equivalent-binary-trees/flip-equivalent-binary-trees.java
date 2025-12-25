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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null && root2 != null) {
            return false;
        }
        if (root1 != null && root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        boolean swapped = flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
        boolean notSwapped = flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);

        // System.out.println(
        //         "root1 " + root1.val + " root2 " + root2.val + " swapped " + swapped + " notSwapped " + notSwapped);
        return swapped || notSwapped;

    }
}