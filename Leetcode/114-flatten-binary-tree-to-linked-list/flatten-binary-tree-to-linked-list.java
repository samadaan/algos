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
    TreeNode prev;
    public void flatten(TreeNode root) {
        if(root==null)return;

        flatten(root.right);
        flatten(root.left);

        
        root.right=prev;
        root.left=null;
        prev=root;



        // if (root == null)
        //     return;
        // TreeNode left = root.left;
        // TreeNode right = root.right;
        // if (left != null) {
        //     root.left=null;
        //     root.right = left;
        //     flatten(left);
        //     while (left.right != null) {
        //         left = left.right;
        //     }
        // }
        // if (right != null) {
        //     flatten(right);
        //     if (left != null) {
        //         left.right = right;
        //     }
        // }
    }
}