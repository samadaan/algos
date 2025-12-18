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
    int rv;
    public int findSecondMinimumValue(TreeNode root) {
        rv=root.val;
       long val=minValue(root);
       if(val==Long.MAX_VALUE)return -1;
       return (int)val;
    }
    public long minValue(TreeNode curr){
        if(curr==null){
            return Long.MAX_VALUE;
        }
        if(curr.val!=rv){
            return curr.val;
        }
        return Math.min(minValue(curr.left), minValue(curr.right));
    }
}