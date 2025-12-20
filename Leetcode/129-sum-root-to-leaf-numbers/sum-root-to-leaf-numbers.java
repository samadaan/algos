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
    int sum;
    public int sumNumbers(TreeNode root) {
        sum=0;
        traverse(root, "");
        return sum;
    }
    void traverse(TreeNode curr, String currString){
        if(curr==null)return;
        currString+=curr.val;
        if(curr.left==null && curr.right==null){   
            sum+=Integer.parseInt(currString);
            return;
        }
        traverse(curr.left, currString);
        traverse(curr.right, currString);

    }
}