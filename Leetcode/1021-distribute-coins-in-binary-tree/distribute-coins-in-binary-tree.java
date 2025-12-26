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
    int totalMoves;
    public int distributeCoins(TreeNode root) {
        totalMoves=0;
        dfs(root);
        return totalMoves;
        
    }

    private int dfs(TreeNode curr){
        if(curr==null)return 0;

        int leftBalance=dfs(curr.left);
        int rightBalance=dfs(curr.right);

        totalMoves+=Math.abs(leftBalance)+Math.abs(rightBalance);

        return curr.val-1 + leftBalance + rightBalance;
    }
}