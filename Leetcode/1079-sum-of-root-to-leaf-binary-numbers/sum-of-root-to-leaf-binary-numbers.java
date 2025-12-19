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
    int sum=0;
    public int sumRootToLeaf(TreeNode root) {
        traverse(root, "");
        return sum;
        
    }
    public void traverse(TreeNode curr, String currString){
        if(curr==null)return;
        if(curr.left==null && curr.right==null){
            currString+=curr.val;
            sum+=Integer.parseInt(currString, 2);
            return;
        }
        currString+=curr.val;
        traverse(curr.left, currString);
        traverse(curr.right, currString);
    }
}