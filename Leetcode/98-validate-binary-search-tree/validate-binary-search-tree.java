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
    long prevVal=Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if(root==null)return true;
        boolean v = isValidBST(root.left);
        if(prevVal==Long.MIN_VALUE){
            prevVal=root.val;
        }else if(prevVal>=root.val){
            return false;
        }
        prevVal=root.val;
        return v && isValidBST(root.right); 
        
    }
}