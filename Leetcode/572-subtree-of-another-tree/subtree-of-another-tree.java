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
    TreeNode subRoot;
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        this.subRoot=subRoot;
        return equals(root, subRoot);

    }

    public boolean equals(TreeNode r, TreeNode sb) {
        
        if(r==null) return false;

        if(sameTree(r, sb))return true;

        return equals(r.left, sb) || equals(r.right, sb);
    }

    public boolean sameTree(TreeNode r, TreeNode sb){
        if (r == null && sb == null) {
            return true;
        }
        if (r == null || sb == null || r.val!=sb.val) {
            return false;
        }
        return sameTree(r.left, sb.left) && sameTree(r.right, sb.right);
    }
}