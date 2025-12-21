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
    int maxDepth;
    int val;
    public int findBottomLeftValue(TreeNode root) {
        maxDepth=-1;
        val=0;
        traverse(root, 0);
        return val;
    }
    void traverse(TreeNode curr, int depth){
        if(curr==null)return;

        if(depth>maxDepth){
            maxDepth=depth;
            val=curr.val;
        }

        traverse(curr.left, depth+1);
        traverse(curr.right, depth+1);
    }
}