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
    String smallest = "";

    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return smallest;
    }

    private void dfs(TreeNode node, StringBuilder sb) {
        if (node == null) return;

        // Convert 0-25 to 'a'-'z' and append
        sb.append((char)('a' + node.val));

        // If it's a leaf, build the string (Leaf to Root) and compare
        if (node.left == null && node.right == null) {
            // We need to reverse because the path is built Root -> Leaf
            String current = sb.reverse().toString();
            
            // Compare with the smallest found so far
            if (smallest.equals("") || current.compareTo(smallest) < 0) {
                smallest = current;
            }
            
            // Reverse back so we don't mess up the backtracking for other branches
            sb.reverse();
        }

        dfs(node.left, sb);
        dfs(node.right, sb);

        // Backtrack: remove the current node's character
        sb.setLength(sb.length() - 1);
    }
}