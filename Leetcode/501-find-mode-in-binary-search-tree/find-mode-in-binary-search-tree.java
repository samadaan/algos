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
    int maxCount = 0;
    int prevVal = Integer.MIN_VALUE;
    int count = 0;
    List<Integer> ans = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        if (root == null)
            return new int[0];
        traverse(root);
        int[] ans1 = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            ans1[i] = ans.get(i);
        }
        return ans1;

    }

    void traverse(TreeNode curr) {
        if (curr == null)
            return;
        traverse(curr.left);
        if (count == 0 || prevVal != curr.val) {
            count = 1;
            prevVal = curr.val;
        } else {
            count++;
        }
        if (count == maxCount) {
            ans.add(curr.val);
        } else if (count > maxCount) {
            ans.clear();
            ans.add(curr.val);
            maxCount = count;
        }
        traverse(curr.right);
    }
}