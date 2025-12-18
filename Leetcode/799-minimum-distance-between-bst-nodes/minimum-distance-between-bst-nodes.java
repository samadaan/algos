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
    int minDiff;
    int prevVal;
    public int minDiffInBST(TreeNode root) {
        minDiff=Integer.MAX_VALUE;
        prevVal=-1;
        traverse(root);
        return minDiff;
    }
    public void traverse(TreeNode curr){
        if(curr==null) return;
        traverse(curr.left);
        if(prevVal==-1){
            prevVal=curr.val;
        }else{
            minDiff=Math.min(minDiff, curr.val-prevVal);
            prevVal=curr.val;
        }
        traverse(curr.right);
    }

}