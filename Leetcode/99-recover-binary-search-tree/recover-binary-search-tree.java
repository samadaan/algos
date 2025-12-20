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
    TreeNode first=null;
    TreeNode second=null;
    TreeNode prev=new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        traverse(root);

        int temp=first.val;
        first.val=second.val;
        second.val=temp;
        return;
    }
    public void traverse(TreeNode curr){
        if(curr==null)return;

        traverse(curr.left);

        if(first==null && prev.val>curr.val){
            first=prev;
        }
        if(first!=null && prev.val>curr.val){
            second=curr;
        }

        prev=curr;

        traverse(curr.right);
    }


}