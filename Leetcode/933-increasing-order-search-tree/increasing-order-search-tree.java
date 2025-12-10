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
    TreeNode head=null;
    TreeNode ans=head;
    public TreeNode increasingBST(TreeNode root) {
        traverse(root);
        return head;
        
    }
    public void traverse(TreeNode root){
        if(root==null)return;
        traverse(root.left);
        if(ans==null){
            ans=new TreeNode(root.val);
            head=ans;
        }else{
            ans.right=new TreeNode(root.val);
            ans=ans.right;
        }
        traverse(root.right);
    }
}