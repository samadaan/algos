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
    int prevVal=-1;
    int diff=Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if(root==null)return 0;
        inorder(root);
        return diff;
    }
    void inorder(TreeNode curr){
        if(curr==null)return;
        inorder(curr.left);
        if(prevVal!=-1 && curr.val-prevVal<diff){
            diff=curr.val-prevVal;
        }
        prevVal=curr.val;
        inorder(curr.right);

    }
}