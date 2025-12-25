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
    int index;
    List<Integer> ans;
    int[] voyage;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        index = 0;
        ans = new ArrayList<>();
        this.voyage = voyage;
        if (traverse(root)) {
            return ans;
        }
        return Arrays.asList(-1);

    }

    private boolean traverse(TreeNode node) {
        if (node == null)
            return true;

        // 1. Current node value must match the current voyage index
        if (node.val != voyage[index++])
            return false;

        // 2. Check if we need to flip: 
        // If there's a left child and it doesn't match the next voyage element...
        if (node.left != null && node.left.val != voyage[index]) {
            // ...and there's a right child, we try flipping
            if (node.right != null) {
                ans.add(node.val);
                // After "flipping", we visit RIGHT child before LEFT child
                return traverse(node.right) && traverse(node.left);
            } else {
                // No right child to flip with, so impossible
                return false;
            }
        }

        // 3. Standard Pre-order (Left then Right)
        return traverse(node.left) && traverse(node.right);
    }
}