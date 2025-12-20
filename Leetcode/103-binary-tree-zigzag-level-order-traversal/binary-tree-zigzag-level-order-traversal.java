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
    List<List<Integer>> ans;

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ans = new ArrayList<>();
        traverse(root, 0);
        return ans;
    }

    void traverse(TreeNode curr, int depth) {
        if (curr == null)
            return;
        if (depth == ans.size()) {
            ans.add(new ArrayList<>());
        }
        traverse(curr.left, depth + 1);
        if (depth % 2 == 0) {
            ans.get(depth).add(curr.val);
        } else {
            ans.get(depth).add(0, curr.val);
        }
        traverse(curr.right, depth + 1);

    }
}