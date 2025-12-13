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
    TreeNode head=new TreeNode(-1);
    TreeNode ans=head;
    public TreeNode increasingBST(TreeNode root) {
        traverse(root);
        return head.right;
        
    }
    public void traverse(TreeNode root){
        if(root==null)return;
        traverse(root.left);
        root.left=null;
        ans.right=root;
        ans=ans.right;
        traverse(root.right);
    }
    // public void traverse(TreeNode curr){
    //     if(curr==null)return;
    //     traverse(curr.left);
    //     traverse(curr.right);
    //     TreeNode leftMax=max(curr.left);
    //     TreeNode rightMin=min(curr.right);
    //     if(leftMax!=null)leftMax.right=curr;
    //     curr.right=rightMin;
        
      
    // }
    // public TreeNode max(TreeNode curr){
    //     if(curr==null)return null;
    //     if(curr.right!=null){
    //         max(curr.right);
    //     }
    //     return curr;
    // }
    // public TreeNode min(TreeNode curr){
    //     if(curr==null)return null;
    //     if(curr.left!=null){
    //         min(curr.left);
    //     }
    //     return curr;
    // }
}