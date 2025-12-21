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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length - 1);
    }

    TreeNode construct(int[] arr, int leftIndex, int rightIndex) {
        if (leftIndex > rightIndex)
            return null;

        int maxIdx = findMax(arr, leftIndex, rightIndex);
        TreeNode node = new TreeNode(arr[maxIdx]);
        node.left = construct(arr, leftIndex, maxIdx - 1);
        node.right = construct(arr, maxIdx + 1, rightIndex);
        return node;

    }

    int findMax(int[] arr, int leftIndex, int rightIndex) {
        int maxValue = Integer.MIN_VALUE;
        int index = -1;
        for (int i = leftIndex; i <= rightIndex; i++) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
                index = i;
            }
        }
        return index;
    }
}