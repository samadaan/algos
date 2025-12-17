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
    StringBuilder sb;
    public String tree2str(TreeNode root) {
        if(root==null)return "";
        sb=new StringBuilder();
        traverse(root);
        return sb.toString();
        



    }
    void traverse(TreeNode curr){
        sb.append(curr.val);
        if(curr.left!=null){
            sb.append("(");
            traverse(curr.left);
            sb.append(")");
        }
        if(curr.right!=null){
            if(curr.left==null){
                sb.append("()");
            }
            sb.append("(");
            traverse(curr.right);
            sb.append(")");
        }
    }
}